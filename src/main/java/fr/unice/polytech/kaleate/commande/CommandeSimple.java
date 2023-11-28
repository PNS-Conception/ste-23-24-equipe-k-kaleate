package fr.unice.polytech.kaleate.commande;

import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import fr.unice.polytech.kaleate.menu.StatutMenu;
import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;

import java.util.*;
import java.util.stream.Collectors;

//TODO Il faut interfacer ou abstraire les Commandes pour pouvoir faire proprement le traitement des commandes avec

public class CommandeSimple implements Observer, Commande {
    private ListeMenus menus;
    private Utilisateur utilisateur; // TODO pour pouvoir faire des commandes selon les extensions, avoir l'utilisateur initial de la commande et le recepteur de la commande
    private StatutCommande statut = StatutCommande.EN_CREATION;

    private int id;

    private static int nextID = 1;

    private Creneau creneauLivraison;

    public CommandeSimple(Utilisateur utilisateur){
        this.menus = new ListeMenus();
        this.utilisateur = utilisateur;
    }

    public CommandeSimple(Utilisateur utilisateur, Creneau creneauLivraison){
        this.menus = new ListeMenus();
        this.utilisateur = utilisateur;
        this.creneauLivraison = creneauLivraison;
    }
    public CommandeSimple(){
        this.menus = new ListeMenus();
    }

    @Override
    public ListeMenus getMenus(){
        return this.menus;
    }

    @Override
    public void setMenus(ListeMenus menus){
        this.menus = menus;
    }

    public boolean addMenu(Menu menu){
        if(modifiable()) {
            menu.setCommande(this);
            return this.menus.add(menu);
        }
        return false;
    }

    @Override
    public boolean removeMenu(Menu menu){
        if(modifiable()) {
            menu.setCommande(null);
            return this.menus.remove(menu);
        }
        return false;
    }
    @Override
    public boolean modifiable(){
        if(statut == StatutCommande.EN_CREATION ||statut == StatutCommande.VALIDEE ){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public double getPrix(){
        double price = 0;
        for(Menu menu : this.menus){
            price += menu.getPrix();
        }
        return price;
    }

    public double getPrixAvecSupplement(){
        double prix = getPrix();
        for(Menu menu : this.menus){
            prix += menu.getPrixAvecSupplements();
        }
        return prix;
    }

    //TODO remplir methode
    @Override
    public double getPrixSansReduction() {
        return 0;
    }
    @Override
    public double getPrixBase() {
        return 0;
    }
    @Override
    public float getTempsPreparation(){
        float tps = 0;
        for(Menu menu : this.menus){
            tps += menu.getTempsPreparation();
        }
        return tps;
    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Utilisateur getUtilisateurRecepteur() {
        return utilisateur;
    }
    @Override
    public Utilisateur getUtilisateurEmetteur() { return utilisateur;}
    @Override
    public void setUtilisateurRecepteur(Utilisateur utilisateur) { this.utilisateur = utilisateur;}
    @Override
    public void setUtilisateurEmetteur(Utilisateur utilisateur) { this.utilisateur = utilisateur;}

    @Override
    public StatutCommande getStatut() {
        return statut;
    }

    //TODO n'est pas viable dans l'utilisation
    public void setStatut(StatutCommande statut) {
        this.statut = statut;
        if (statut.equals(StatutCommande.VALIDEE)){
            for (Menu m : this.menus){
                m.setStatutValide();
            }
        }
        else if(statut.equals(StatutCommande.PRETE)){
            for (Menu m : this.menus){
                m.setStatutPret();
            }
        }else if(statut.equals(StatutCommande.PAYEE)){
            for (Menu m : this.menus){
                m.setStatut(StatutMenu.PAYEE);
            }
        }
        else
        {
            for (Menu m : this.menus){
                m.setStatutEnPreparation();
            }
        }
    }
    @Override
    public void valideeCommande()
    {
        for(Menu m : menus) m.setCommande(this);
        setStatut(StatutCommande.VALIDEE);
    }


    public Creneau getCreneauLivraison() {
        return creneauLivraison;
    }

    public void setCreneauLivraison(Creneau creneauLivraison) {
        this.creneauLivraison = creneauLivraison;
    }

    public List<Menu> getListeMenus() {
        return this.menus.stream().toList();
    }

    public boolean contains(Menu menu) {
        return this.menus.contains(menu);
    }

    /**
     * Pour récuperer tous les restaurants associés à la commande
     *
     * -> (sans doublon)
     *
     * @return une liste de Restaurants
     */
    public List<Restaurant> getRestaurants() {
        Set<Restaurant> res = new HashSet<>();
        for (Menu m : menus)
        {
            res.add(m.getRestaurant());
        }
        return res.stream().toList();
    }

    public boolean finirPreparationMenu(Menu mp){
        if (contains(mp)) {
            for (int i=0; i<menus.size(); i++){
                if (mp.equals(menus.get(i)))
                    if(menus.get(i).getStatut()==StatutMenu.VALIDE || menus.get(i).getStatut()==StatutMenu.EN_PREPARATION){
                        mp.setStatutPret();
                        return true;
                    }
            }
        }
        return false;
    }

    public boolean preparerMenu(Menu mp){
        if (contains(mp)) {
            for (int i=0; i<menus.size(); i++){
                if (mp.equals(menus.get(i)))
                    if(menus.get(i).getStatut()==StatutMenu.VALIDE || menus.get(i).getStatut()==StatutMenu.EN_PREPARATION){
                        mp.setStatut(StatutMenu.EN_PREPARATION);
                        return true;
                    }
            }
        }
        return false;
    }

    public List<StatutMenu> getStatutsMenus(){
        return menus.stream().map(Menu::getStatut).collect(Collectors.toList());
    }

    public Menu getMenuParNom(String nomMenu){
        return this.menus.stream().filter(menu -> menu.estMenuParNom(nomMenu)).findFirst().orElse(null);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(!(o instanceof Menu)) throw new RuntimeException("Observable not a Menu");
        boolean isReady = true;
        for (Menu m : menus) {
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
    public int hashCode() {
        return id;
    }
}
