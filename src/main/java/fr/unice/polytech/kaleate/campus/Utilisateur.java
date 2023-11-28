package fr.unice.polytech.kaleate.campus;

import fr.unice.polytech.kaleate.CommandeException;
import fr.unice.polytech.kaleate.commande.Commande;
import fr.unice.polytech.kaleate.menu.element.ChoixElement;
import fr.unice.polytech.kaleate.outils.PayementExterne;
import fr.unice.polytech.kaleate.commande.CommandeSimple;
import fr.unice.polytech.kaleate.commande.CommandeGroupee;
import fr.unice.polytech.kaleate.commande.StatutCommande;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;

import java.util.ArrayList;

public class Utilisateur {

        private String nom;
        private String prenom;

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
                    commandeActuelle = new CommandeSimple();
                }
                return commandeGroupee.ajouterCommande(code, commandeActuelle);
        }
        public boolean addMenu(Menu m){
            if(commandeActuelle == null){
                commandeActuelle = new CommandeSimple();
            }
            m.verifContenuMenu();
            return commandeActuelle.addMenu(m);
        }
        public boolean removeMenu(Menu m){
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
        public boolean payer(){
            if(commandeActuelle == null) return false;
            if(new PayementExterne().payer(commandeActuelle.getPrix())) {
                commandeActuelle.setStatut(StatutCommande.PAYEE);
                commandeActuelle.enregistrerCommande();
                return true;
            }
            return false;
        }
        public void recupererCommande(){
            if(commandeActuelle.getStatut()==StatutCommande.A_RECUPERER){
                commandeActuelle.setStatut(StatutCommande.LIVREE);
                resetCommandeActuelle();
            }
        }
        public void resetCommandeActuelle(){
            commandeActuelle = new CommandeSimple();
        }

    public ArrayList<Commande> getHistorique() {
        return historique;
    }

    public int getIdCommande() throws CommandeException {;
            if(commandeActuelle.getStatut().compareTo(StatutCommande.PAYEE)>=0)
                return commandeActuelle.getId();
            throw new CommandeException("La commande n'est pas encore payée.");
    }
    public Creneau getDateCommande() throws CommandeException {
        if(commandeActuelle.getStatut().compareTo(StatutCommande.PAYEE)>=0)
            return commandeActuelle.getCreneauLivraison();
        throw new CommandeException("La commande n'est pas encore payée.");
    }
   /*public Creneau getPointLivraison() throws CommandeException {
        if(commandeActuelle.getStatut().compareTo(StatutCommande.PAYEE)>=0)
            return commandeActuelle.get();
        throw new CommandeException("La commande n'est pas encore payée.");
    }*/
}
