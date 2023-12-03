package fr.unice.polytech.kaleate.commande;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.menu.StatutMenu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.outils.Monnayable;
import fr.unice.polytech.kaleate.restaurant.Restaurant;

import java.util.*;

public abstract class Commande implements Monnayable, Observer {

    static int nextID = 1;
    int id;

    protected Creneau creneauLivraison;

    protected StatutCommande statut = StatutCommande.EN_CREATION;

    public int getNexID(){
        return nextID++;
    }

    public abstract ListeMenus getMenus();

    public abstract void setMenus(ListeMenus menus);
    public abstract boolean addMenu(Commandable menu);

    public abstract boolean removeMenu(Commandable menu);
    public abstract boolean modifiable();
    public float getTempsPreparation()
    {
        float temps = 0;
        for(Commandable menu : getMenus())
        {
            temps += menu.getTempsPreparation();
        }
        return temps;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public abstract Utilisateur getUtilisateurRecepteur();
    public abstract Utilisateur getUtilisateurEmetteur();
    public abstract void setUtilisateurRecepteur(Utilisateur utilisateur);
    public abstract void setUtilisateurEmetteur(Utilisateur utilisateur);
    public StatutCommande getStatutCommande() {
        return statut;
    }
    public void setStatut(StatutCommande statut) {
        this.statut = statut;
        if (statut.equals(StatutCommande.VALIDEE)){
            for (Commandable m : getMenus()){
                m.setStatutValide();
            }
        }
        else if(statut.equals(StatutCommande.PRETE)){
            for (Commandable m : getMenus()){
                m.setStatutPret();
            }
        }
        else if(statut.equals(StatutCommande.EN_PREPARATION)){
            for (Commandable m : getMenus()){
                m.setStatutEnPreparation();
            }
        }
    }
    public void valideeCommande()
    {
        for(Commandable m : getMenus()) m.setCommande(this);
        setStatut(StatutCommande.VALIDEE);
    }

    public boolean finirPreparationMenu(Commandable mp){
        if (contains(mp)) {
            for(int i=0; i<getMenus().size(); i++){
                if (mp.equals(getMenus().get(i)))
                    if(getMenus().get(i).getStatut()==StatutMenu.VALIDE || getMenus().get(i).getStatut()==StatutMenu.EN_PREPARATION){
                        mp.setStatutPret();
                        return true;
                    }
            }
        }
        return false;
    }

    public boolean contains(Commandable menu) {
        return getMenus().contains(menu);
    }
    public boolean preparerMenu(Commandable mp){
        if (contains(mp)) {
            for(int i=0; i<getMenus().size(); i++){
                if (mp.equals(getMenus().get(i)))
                    if(getMenus().get(i).getStatut()==StatutMenu.VALIDE || getMenus().get(i).getStatut()==StatutMenu.EN_PREPARATION){
                        mp.setStatut(StatutMenu.EN_PREPARATION);
                        return true;
                    }
            }
        }
        return false;
    }

    public List<StatutMenu> getStatutsMenus(){
        return getMenus().stream().map(Commandable::getStatut).toList();
    }

    public Commandable getMenuParNom(String nom, Class typeMenu)
    {
        return getMenus().getMenuParNom(nom, typeMenu);
    }

    public List<Restaurant> getRestaurants() {
        Set<Restaurant> res = new HashSet<>();
        for (Commandable m : getMenus())
        {
            res.add(m.getRestaurant());
        }
        return res.stream().toList();
    }

    public Creneau getCreneauLivraison() {
        return creneauLivraison;
    }

    public void setCreneauLivraison(Creneau creneauLivraison) {
        this.creneauLivraison = creneauLivraison;
    }

    public void enregistrerCommande(){
        for(Commandable m : getMenus()) {
            m.setCommande(this);
        }
    }


    @Override
    public double getPrixBase(){
        double price = 0;
        for(Commandable menu : this.getMenus()){
            price += menu.getPrix();
        }
        return price;
    }

    @Override
    public double getPrix(){
        double prix = getPrixBase();
        for(Commandable menu : this.getMenus()){
            if(menu instanceof Menu)
                prix += ((Menu) menu).getPrixAvecSupplements();
            else
                prix += menu.getPrix();
        }
        return prix;
    }

    @Override
    public double getPrixSansReduction() {
        return 0;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(!(o instanceof Menu)) throw new RuntimeException("Observable not a Menu");
        boolean isReady = true;
        for (Commandable m : getMenus()) {
            if(m.getStatut() == StatutMenu.EN_PREPARATION || m.getStatut() == StatutMenu.PRET)
            {
                statut = StatutCommande.EN_PREPARATION;
            }
            if(m.getStatut() != StatutMenu.PRET) {
                isReady = false;
            }
        }
        if(isReady)
            statut = StatutCommande.PRETE;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commande)) return false;
        Commande cs = (Commande) o;
        return id == cs.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public abstract void reset();
}
