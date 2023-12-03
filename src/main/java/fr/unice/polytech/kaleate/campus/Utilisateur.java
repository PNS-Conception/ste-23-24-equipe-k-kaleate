package fr.unice.polytech.kaleate.campus;

import fr.unice.polytech.kaleate.Avis;
import fr.unice.polytech.kaleate.CommandeException;
import fr.unice.polytech.kaleate.Evaluable;
import fr.unice.polytech.kaleate.Evalueur;
import fr.unice.polytech.kaleate.commande.*;
import fr.unice.polytech.kaleate.livrable.Livreur;
import fr.unice.polytech.kaleate.outils.PayementExterne;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.Restaurant;

import java.util.ArrayList;

public class Utilisateur extends Evaluable implements Evalueur {

    private String nom;
    private String prenom;

    private final Class<Menu> typeMenu = Menu.class;
    private Commande commandeActuelle;

    private ArrayList<Commande> historique;

    private float solde = 1000;

    public Utilisateur(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.historique = new ArrayList<>();
    }

    public String getNom(){
        return this.nom;
    }

    public Class getTypeMenu() {
        return typeMenu;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public Commande getCommandeActuelle() {
        return commandeActuelle;
    }

    public void setCommandeActuelle(Commande commandeActuelle) {
        this.commandeActuelle = commandeActuelle;
    }
    public boolean rejoindreCommandegroupee(CommandeGroupee commandeGroupee, int code){
            if(commandeActuelle == null){
                commandeActuelle = new CommandeSimple(this);
                ListeCommande.getInstance().add(commandeActuelle);
            }
            return commandeGroupee.ajouterCommande(code, commandeActuelle);
    }
    public boolean addMenu(Commandable m){
        if(m instanceof Buffet){
            if(commandeActuelle != null)
                commandeActuelle.reset();
            commandeActuelle = (Buffet) m;
            m.getRestaurant().supprimerMenu(m);
            commandeActuelle.setUtilisateurEmetteur(this);
            return true;
        }
        if(commandeActuelle == null){
            commandeActuelle = new CommandeSimple();
        }
        m.verifContenuMenu();
        return commandeActuelle.addMenu(m);
    }

    public boolean removeMenu(Commandable m){
        return commandeActuelle.removeMenu(m);
    }

    public void setCreneauLivraison(Creneau creneauLivraison) {
        this.commandeActuelle.setCreneauLivraison(creneauLivraison);
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }
    public void addSolde(float solde) {
        this.solde += solde;
    }
    public void removeSolde(float solde){this.solde -=solde;}
    public boolean payer(){
        if(commandeActuelle == null) return false;
        if(new PayementExterne().payer(this,commandeActuelle.getPrix())) {
            for (Commandable m : commandeActuelle.getMenus()) {
                m.verifContenuMenu();
            }
            commandeActuelle.setUtilisateurEmetteur(this);
            commandeActuelle.setStatut(StatutCommande.PAYEE);
            commandeActuelle.elligibleReduction();
            commandeActuelle.enregistrerCommande();
            ListeCommande.getInstance().add(commandeActuelle);
            return true;
        }
        return false;
    }
    public void rembourser(Commandable m){
        new PayementExterne().rembourser(this,m.getPrix());
    }

    public boolean removeMenu(Menu m){
        return commandeActuelle.removeMenu(m);
    }

    public void recupererCommande(){
        if(commandeActuelle.getStatutCommande()==StatutCommande.A_RECUPERER){
            commandeActuelle.setStatut(StatutCommande.LIVREE);
        }
    }
    public void resetCommandeActuelle(){
        commandeActuelle.reset();
        commandeActuelle = null;
    }

        public ArrayList<Commande> getHistorique() {
            return historique;
        }


        public int getIdCommande() throws CommandeException {
                if(commandeActuelle.getStatutCommande().compareTo(StatutCommande.VALIDEE)>=0)
                    return commandeActuelle.getId();
                throw new CommandeException("La commande n'est pas encore payée.");
        }
        public Creneau getDateCommande() throws CommandeException {
            if(commandeActuelle.getStatutCommande().compareTo(StatutCommande.PAYEE)>=0)
                return commandeActuelle.getCreneauLivraison();
            throw new CommandeException("La commande n'est pas encore payée.");
        }

        @Override
        public void evaluer(Avis note, Evaluable evaluable) {
                if (evaluable instanceof Livreur || evaluable instanceof Restaurant){
                    evaluable.nouvelAvis(this,note);
                }
        }

        public void abandonCommande(){
            commandeActuelle.abandonCommande();
            commandeActuelle = null;
        }


        public void resetCommande(){
            commandeActuelle = null;
        }
       /*public Creneau getPointLivraison() throws CommandeException {
            if(commandeActuelle.getStatut().compareTo(StatutCommande.PAYEE)>=0)
                return commandeActuelle.get();
            throw new CommandeException("La commande n'est pas encore payée.");
        }*/
}
