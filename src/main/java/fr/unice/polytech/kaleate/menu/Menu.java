package fr.unice.polytech.kaleate.menu;

import fr.unice.polytech.kaleate.commande.Commande;
import fr.unice.polytech.kaleate.menu.element.ChoixElement;
import fr.unice.polytech.kaleate.menu.supplement.Supplement;
import fr.unice.polytech.kaleate.menu.element.SupplementElement;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.outils.Monnayable;
import fr.unice.polytech.kaleate.restaurant.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Menu extends Observable implements Monnayable {
    private double prix;
    private String name;
    private Creneau creneau;
    private ContenuMenu contenuMenu;
    private StatutMenu statut = StatutMenu.COMMANDABLE;
    private Commande commande;

    private Restaurant restaurant;
    private int tempsPreparation; // en minutes

    public Menu()
    {
    }


    public Menu(float prix, String name, Creneau creneau){
        this.prix = prix;
        this.name = name;
        this.creneau = creneau;
        this.contenuMenu = new ContenuMenu();
    }
    public Menu(float prix, String name, Creneau creneau,Restaurant restaurant){
        this.prix = prix;
        this.name = name;
        this.creneau = creneau;
        this.contenuMenu = new ContenuMenu();
        this.restaurant = restaurant;
    }
    public Menu(float prix, String name, Creneau creneau, int tempsPreparation){
        this.prix = prix;
        this.name = name;
        this.creneau = creneau;
        this.tempsPreparation = tempsPreparation;
        this.contenuMenu = new ContenuMenu();
    }


    public ContenuMenu getContenuMenu() {
        return contenuMenu;
    }

    public void setContenuMenu(ContenuMenu contenuMenu) {
        this.contenuMenu = contenuMenu;
    }

    public String getName(){
        return this.name;
    }

    public Creneau getCreneau(){
        return this.creneau;
    }

    public void setCommande(Commande c)
    {
        this.commande = c;
    }
    public Commande getCommande()
    {
        return commande;
    }

    public List<ChoixElement> getChoixElementListe() {return contenuMenu.getChoixElementListe();}

    /**
     * @return la liste des éléments suppléments proposés par le restaurant
     */
    public List<SupplementElement> getSupplementElementListe() {
        return contenuMenu.getSupplementElementListe();
    }

    /**
     * @return la liste des éléments suppléments sélectionnés par l'utilisateur
     */

    public List<SupplementElement> getSupplementElementListeSelectionne() {
        return contenuMenu.getSupplementElementListeSelectionne();
    }

    public void setPrix(double prix){
        this.prix = prix;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCreneau(Creneau creneau){
        this.creneau = creneau;
    }

    public boolean estMenuParNom(String name){
        return this.name.equals(name);
    }

    public boolean estComprisDansCreneau(Creneau creneau){
        return this.creneau.estComprisDansCreneau(creneau);
    }
    public boolean chevaucheCreneau(Creneau creneau){
        return this.creneau.chevaucheCreneau(creneau);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Menu))
            return false;
        if (obj == this)
            return true;
        return this.getName().equals(((Menu) obj).getName()) && this.getPrix() == ((Menu) obj).getPrix() && this.getCreneau().equals(((Menu) obj).getCreneau());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean isStackable(Menu menu){
        return this.getName().equals(menu.getName()) && this.getPrix() == menu.getPrix();
    }

    @Override
    public String toString() {
        return "Menu : " + this.getName() + " / " + this.getPrix() + "€" + " / " + this.getCreneau().getDebut() + " - " + this.getCreneau().getFin();
    }

    public int getTempsPreparation() {
        return tempsPreparation;
    }

    public void setTempsPreparation(int tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }


    //TODO A revoir avec l'interface monnayable
    /**
     * Calcule le prix des suppléments ajoutés par l'utilisateur dans le menu
     * @return le prix ddes suppléments
     */
    public double getPrixAvecSupplements() {
        double total = 0;
        for (ChoixElement e : contenuMenu.getChoixElementListe()) {
            total += e.getPrixSupplement();
        }
        for(Supplement supplementElement : contenuMenu.getSupplementElementListeSelectionne()){
            total += supplementElement.getPrix();
        }
        return this.getPrix() + total;
    }

    /**
     * Cherche dans la liste des choix d'éléments un Choix grâce à son nom
     * @param nomChoixElement le nom du ChoixElement que l'on veut
     * @return le ChoixElement trouvé  à partir du string entrée en paramètre
     */
    public ChoixElement getChoixElementParNom(String nomChoixElement){
        return this.getChoixElementListe().stream().filter(choixElement -> choixElement.estChoixParNom(nomChoixElement)).findFirst().orElse(null);
    }


    public void resetMenu(){
        contenuMenu.reset();
    }

    public void setStatut(StatutMenu statut) {
        this.statut = statut;
        commande.update(this, this);
    }

    public StatutMenu getStatut() {
        return statut;
    }

    public void setStatutValide() {
        setStatut(StatutMenu.VALIDE);
    }

    public void setStatutEnPreparation() {
        setStatut(StatutMenu.EN_PREPARATION);
    }

    public void setStatutPret() {
        setStatut(StatutMenu.PRET);
    }
    public void setStatutPaye() {
        setStatut(StatutMenu.PAYEE);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public double getPrix() {
        return prix;
    }

    @Override
    public double getPrixSansReduction() {
        return prix;
    }

    @Override
    public double getPrixBase() {
        return prix;
    }

    public void verifContenuMenu(){
        this.contenuMenu.verifSiElementChoisi();
    }
}
