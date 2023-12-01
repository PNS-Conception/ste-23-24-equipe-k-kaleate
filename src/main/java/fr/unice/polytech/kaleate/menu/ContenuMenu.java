package fr.unice.polytech.kaleate.menu;

import fr.unice.polytech.kaleate.menu.element.ChoixElement;
import fr.unice.polytech.kaleate.menu.supplement.ChoixSupplementElement;
import fr.unice.polytech.kaleate.menu.supplement.Supplement;
import fr.unice.polytech.kaleate.menu.element.SupplementElement;
import fr.unice.polytech.kaleate.outils.Monnayable;

import java.util.ArrayList;
import java.util.List;

public class ContenuMenu implements Monnayable {

    private List<ChoixElement> choixElementListe;
    private ChoixSupplementElement choixSupplementElement;

    public ContenuMenu()
    {
        choixElementListe = new ArrayList<>();
        choixSupplementElement = new ChoixSupplementElement();
    }

    public ContenuMenu(ArrayList<ChoixElement> choixElementListe, ChoixSupplementElement choixSupplements) {
        this.choixElementListe = choixElementListe;
        this.choixSupplementElement = choixSupplements;
    }

    public List<ChoixElement> getChoixElementListe() {
        return choixElementListe;
    }

    public ContenuMenu getContenuMenu() {
        return null;
    }

    public List<ChoixElement> getChoixElementListeUtilisation() {
        return choixElementListe;
    }

    public void setChoixElementListe(ArrayList<ChoixElement> choixElementListe) {
        this.choixElementListe = choixElementListe;
    }

    public void setChoixSupplementElement(ChoixSupplementElement choixSupplementElement) {
        this.choixSupplementElement = choixSupplementElement;
    }

    public List<SupplementElement> getSupplementElementListe() {
        return choixSupplementElement.getSupplementsListe();
    }

    public ArrayList<SupplementElement> getSupplementElementListeSelectionne() {
        return (ArrayList<SupplementElement>) choixSupplementElement.getSupplementsSelectionnes();
    }

    public ChoixSupplementElement getChoixSupplementElement() {
        return choixSupplementElement;
    }

    public void setSupplementElementListe(ChoixSupplementElement supplementElement) {
        choixSupplementElement = supplementElement;
    }

    /**
     * Prends en paramètre un ChoixElement
     * l'ajoute à la liste choixElementliste qui contient les choix possibles pour l'utilisateur ajoutés par le manager de restaurant
     * @param choixElement le ChoixElement à rajouter
     */
    public void ajouterChoixElement(ChoixElement choixElement){
        choixElementListe.add(choixElement);
    }

    /**
     * Ajoute un élément supplément à la liste des éléments suppléments disponible pour l'utilisateur
     * @param supplementElement l'élément supplément que le manager de restaurant veut ajouter
     */
    public void ajouterElementSupplement(SupplementElement supplementElement){
        choixSupplementElement.getSupplementsListe().add(supplementElement);
    }

    /**
     * Ajoute un élément suppplémentaire à la liste des éléments supplémentaires sélectionnés par l'utilisateur
     * @param supplementElement l'élément supplément choisi par l'utilisateur
     */
    public void ajouterElementSupplementSelectionne(SupplementElement supplementElement) {
        choixSupplementElement.selectionnerSupplement(supplementElement);
    }



    /**
     * Cherche dans la liste des Supplements éléments disponibles un supplément grâce à son nom
     * @param nomSupplement le nom du supplément élément que l'on veut
     * @return le supplément élément trouvé à  partir du string entré en paramètre
     */
    public SupplementElement getChoixSupplementElementParNom(String nomSupplement){
        return this.choixSupplementElement.getSupplementsListe().stream().filter(supplementElement -> (supplementElement.estSupplementParNom(nomSupplement))).findFirst().orElse(null);
    }

    /**
     * Cherche dans la liste des Supplements éléments sélectionés un supplément grâce à son nom
     * @param nomSup le nom du supplément élément que  l'on veut
     * @return le supplément élément trouvé à partir du string entré en paramètre
     */
    public SupplementElement getSupplementElementListeSelectioneParNom(String nomSup){
        return choixSupplementElement.getSupplementsSelectionnes().stream().filter(supplementElement -> supplementElement.estSupplementParNom(nomSup)).findFirst().orElse(null);
    }

    public ChoixElement getChoixElementParNom(String nomChoixElement){
        return choixElementListe.stream().filter(choixElement -> choixElement.estChoixParNom(nomChoixElement)).findFirst().orElse(null);
    }

    public void reset()
    {
        for(ChoixElement ce : choixElementListe) ce.reset();
        choixSupplementElement.reset();
    }

    /**
     * Calcule le prix des suppléments ajoutés par l'utilisateur dans le menu
     * @return le prix ddes suppléments
     */
    @Override
    public double getPrix() {
        double total = 0;
        for (ChoixElement e : choixElementListe) {
            total += e.getPrixSupplement();
        }
        for(Supplement supplementElement : choixSupplementElement.getSupplementsSelectionnes()){
            total += supplementElement.getPrix();

        }
        return total;
    }

    @Override
    public double getPrixSansReduction() {
        return getPrix();
    }

    @Override
    public double getPrixBase() {
        return getPrix();
    }


    public void verifSiElementChoisi(){
        for(ChoixElement choixElement : choixElementListe){
            choixElement.verifElement();
        }

    }

    public void supprimerChoixElementParNom(String nomChoixElement){
        choixElementListe.remove(getChoixElementParNom(nomChoixElement));
    }
}
