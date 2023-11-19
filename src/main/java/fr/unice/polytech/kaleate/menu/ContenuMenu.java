package fr.unice.polytech.kaleate.menu;

import fr.unice.polytech.kaleate.menu.element.ChoixElement;
import fr.unice.polytech.kaleate.menu.element.ChoixSupplementElement;
import fr.unice.polytech.kaleate.menu.supplement.Supplement;
import fr.unice.polytech.kaleate.menu.element.SupplementElement;
import fr.unice.polytech.kaleate.outils.Monnayable;

import java.util.ArrayList;
import java.util.List;

public class ContenuMenu implements Monnayable {

    private List<ChoixElement> choixElementListe;
    private ChoixSupplementElement choixSupplements;

    public ContenuMenu()
    {
        choixElementListe = new ArrayList<>();
        choixSupplements = new ChoixSupplementElement();
    }

    public ContenuMenu(ArrayList<ChoixElement> choixElementListe, ChoixSupplementElement choixSupplements) {
        this.choixElementListe = choixElementListe;
        this.choixSupplements = choixSupplements;
    }

    public List<ChoixElement> getChoixElementListe() {
        return choixElementListe;
    }

    public void setChoixElementListe(ArrayList<ChoixElement> choixElementListe) {
        this.choixElementListe = choixElementListe;
    }

    public ArrayList<SupplementElement> getSupplementElementListe() {
        return (ArrayList<SupplementElement>) choixSupplements.getSupplementsListe();
    }

    public ArrayList<SupplementElement> getSupplementElementListeSelectionne() {
        return (ArrayList<SupplementElement>) choixSupplements.getSupplementsSelectionnes();
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
        choixSupplements.getSupplementsListe().add(supplementElement);
    }

    /**
     * Ajoute un élément suppplémentaire à la liste des éléments supplémentaires sélectionnés par l'utilisateur
     * @param supplementElement l'élément supplément choisi par l'utilisateur
     */
    public void ajouterElementSupplementSelectionne(SupplementElement supplementElement) {
        choixSupplements.selectionnerSupplement(supplementElement);
    }



    /**
     * Cherche dans la liste des Supplements éléments disponibles un supplément grâce à son nom
     * @param nomSupplement le nom du supplément élément que l'on veut
     * @return le supplément élément trouvé à  partir du string entré en paramètre
     */
    public SupplementElement getChoixSupplementElementParNom(String nomSupplement){
        return this.choixSupplements.getSupplementsListe().stream().filter(supplementElement -> (supplementElement.estSupplementParNom(nomSupplement))).findFirst().orElse(null);
    }

    /**
     * Cherche dans la liste des Supplements éléments sélectionés un supplément grâce à son nom
     * @param nomSup le nom du supplément élément que  l'on veut
     * @return le supplément élément trouvé à partir du string entré en paramètre
     */
    public SupplementElement getSupplementElementListeSelectioneParNom(String nomSup){
        return choixSupplements.getSupplementsSelectionnes().stream().filter(supplementElement -> supplementElement.estSupplementParNom(nomSup)).findFirst().orElse(null);
    }

    public void reset()
    {
        //TODO
    }

    /**
     * Calcule le prix des suppléments ajoutés par l'utilisateur dans le menu
     * @return le prix ddes suppléments
     */
    @Override
    public float getPrix() {
        float total = 0;
        for (ChoixElement e : choixElementListe) {
            total += e.getPrixSupplement();
        }
        for(Supplement supplementElement : choixSupplements.getSupplementsSelectionnes()){
            total += supplementElement.getPrix();
            total += supplementElement.getPrix();
        }
        return total;
    }

    @Override
    public float getPrixSansReduction() {
        return getPrix();
    }

    @Override
    public float getPrixBase() {
        return getPrix();
    }
}
