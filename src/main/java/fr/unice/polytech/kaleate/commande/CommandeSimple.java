package fr.unice.polytech.kaleate.commande;

import fr.unice.polytech.kaleate.restaurant.Restaurant;
import fr.unice.polytech.kaleate.menu.StatutMenu;
import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;

import java.util.*;
import java.util.stream.Collectors;

//TODO Il faut interfacer ou abstraire les Commandes pour pouvoir faire proprement le traitement des commandes avec

public class CommandeSimple implements Observer {
    private List<Menu> menus;
    private Utilisateur utilisateur; // TODO pour pouvoir faire des commandes selon les extensions, avoir l'utilisateur initial de la commande et le recepteur de la commande
    private StatutCommande statut = StatutCommande.EN_CREATION;

    private int id;

    private static int nextID = 1;

    private Creneau creneauLivraison;
    public CommandeSimple(Utilisateur utilisateur, List<Menu> menus){
        this.menus = menus;
        this.utilisateur = utilisateur;
        id = nextID;
        nextID++;
    }

    public CommandeSimple(Utilisateur utilisateur, Menu menu){
        this.menus = new ArrayList<>();
        this.menus.add(menu);
        this.utilisateur = utilisateur;
    }
    public CommandeSimple(Utilisateur utilisateur, Menu menu, Creneau creneauLivraison, Restaurant restaurant){
        this.menus = new ArrayList<>();
        this.menus.add(menu);
        this.utilisateur = utilisateur;
        this.creneauLivraison = creneauLivraison;
    }
    public CommandeSimple(){
        this.menus = new ArrayList<>();
    }

    public List<Menu> getMenus(){
        return this.menus;
    }

    public void setMenus(List<Menu> menus){
        this.menus = menus;
    }

    public boolean addMenu(Menu menu){
        if(modifiable())
            return this.menus.add(menu);
        return false;
    }

    public boolean removeMenu(Menu menu){
        if(modifiable())
           return this.menus.remove(menu);
        return false;
    }
    public boolean modifiable(){
        if(statut == StatutCommande.EN_CREATION ||statut == StatutCommande.VALIDEE ){
            return true;
        }else{
            return false;
        }
    }
    public float getPrice(){
        float price = 0;
        for(Menu menu : this.menus){
            price += menu.getPrix();
        }
        return price;
    }

    public float getPrixAvecSupplement(){
        float prix = getPrice();
        for(Menu menu : this.menus){
            prix += menu.getPrixAvecSupplements();
        }
        return prix;
    }

    public float getTempsPreparation(){
        float tps = 0;
        for(Menu menu : this.menus){
            tps += menu.getTempsPreparation();
        }
        return tps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public StatutCommande getStatut() {
        return statut;
    }

    //todo n'est pas viable dans l'utilisation
    public void setStatut(StatutCommande statut) {
        this.statut = statut;
        if (statut.equals(StatutCommande.VALIDEE)){
            for (Menu m : this.menus){
                m.setStatutValide();
            }
        }
    }

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

        return menus.stream().map(Menu::getRestaurant).collect(Collectors.toSet()).stream().toList();
    }

    public boolean preparerMenu(Menu mp){
        if (contains(mp)) {
            for (int i=0; i<menus.size(); i++){
                if (mp.equals(menus.get(i))&& menus.get(i).getStatut()==StatutMenu.VALIDE){
                    mp.setStatutPret();
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
            if(m.getStatut() == StatutMenu.EN_PREPARATION)
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
}
