package fr.unice.polytech.kaleate.menu.element;

import fr.unice.polytech.kaleate.menu.gestion.ChoixElementGestion;
import fr.unice.polytech.kaleate.menu.gestion.ElementGestion;
import fr.unice.polytech.kaleate.menu.utilisation.ChoixElementUtilisation;
import fr.unice.polytech.kaleate.menu.utilisation.ElementUtilisation;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un choix d'éléments sélectionnés dans le menu
 *
 * elementsListe : liste des éléments disponibles pour l'utilisateur
 * nbChoixElement : nombre d'éléments que l'utilisateur peut choisir
 *
 */
public class ChoixElement implements ChoixElementUtilisation, ChoixElementGestion {
    private String nomElement;
    private int nbChoixElement;

    private List<Element> elementListeSelectionne;
    private List<Element> elementListe;

    public ChoixElement(){
        super();
        this.elementListe = new ArrayList<>();
        this.elementListeSelectionne = new ArrayList<>();
        this.nbChoixElement = 0;
        this.nomElement = "";
    }

    public ChoixElement(String nomElement, int nbChoixElement){
        this.nomElement = nomElement;
        this.nbChoixElement = nbChoixElement;
        this.elementListe = new ArrayList<>();
        this.elementListeSelectionne = new ArrayList<>();
    }

    protected ChoixElement(String nomElement, int nbChoixElement, ArrayList<Element> elementListe){
        this.nomElement = nomElement;
        this.nbChoixElement = nbChoixElement;
        this.elementListe = elementListe;
        this.elementListeSelectionne = new ArrayList<>();
    }

    @Override
    public String getNom() {
        return nomElement;
    }

    @Override
    public int getNbChoix() {
        return nbChoixElement;
    }

    @Override
    public List<ElementUtilisation> getListeUtilisation() {
        return elementListe.stream().map(a -> (ElementUtilisation) a).toList();
    }

    @Override
    public List<ElementUtilisation> getListeSelectionneUtilisation() {
        return elementListeSelectionne.stream().map(a -> (ElementUtilisation) a).toList();
    }

    @Override
    public List<ElementGestion> getListeGestion() {
        return elementListe.stream().map(a -> (ElementGestion) a).toList();
    }

    @Override
    public List<ElementGestion> getListeSelectionneGestion() {
        return elementListeSelectionne.stream().map(a -> (ElementGestion) a).toList();
    }

    @Override
    public void setListe(List<ElementGestion> liste) {
        this.elementListe = liste.stream().map(Element::new).toList();
    }

    @Override
    public void setNom(String nomElement) {
        this.nomElement = nomElement;
    }

    @Override
    public void setNbChoix(int nbChoixElement) {
        this.nbChoixElement = nbChoixElement;
    }

    @Override
    public void ajout(ElementGestion elementGestion) {

    }

    @Override
    public void supprimer(ElementGestion elementGestion) {

    }

    @Override
    public boolean estChoixParNom(String nomChoixelement){
        return this.nomElement.equals(nomChoixelement);
    }

    /**
     * Ajout un élément à la liste des éléments disponible pour l'utilisateur
     * @param e l'élément à ajouter
     */
    public void ajout(Element e){
        elementListe.add(e);
    }

    public void supprimer(Element element) {
        elementListe.remove(element);
    }

    /**
     * Cherche un élément grâce à son nom dans la liste des éléments proposés par le manger de restaurant
     * @param s le nom de l'élément recherché
     * @return l'élément trouvé grâce à l'entrée
     */
    @Override
    public Element getParNom(String s){
        return elementListe.stream().filter(element -> element.estParNom(s)).findFirst().orElse(null);
    }

    /**
     * Cherche un élément grâce à son nom dans la liste des éléments séléctionnés par l'utilisateur
     * @param s le nom de l'élément recherché
     * @return l'élément trouvé grâce à l'entrée
     */
    @Override
    public Element getSelectionneParNom(String s){
        return elementListeSelectionne.stream().filter(element -> element.estParNom(s)).findFirst().orElse(null);
    }

    @Override
    public void choisir(ElementUtilisation elementUtilisation) {
        choisir((Element) elementUtilisation);
    }

    /**
     * Ajoute un élément sélectionné par l'utilisateur à la liste des éléments selectionnés
     * @param element l'élément à ajouter
     */
    public void choisir(Element element){
        if (elementListeSelectionne.size() < nbChoixElement){
            elementListeSelectionne.add(element);
        }
    }

    /**
     * Calcule le prix des supppléments de cet élément
     * @return le prix des suppléments
     */
    public double getPrixSupplement(){
        double prixSupp = 0;
        for (Element e : elementListeSelectionne){
            prixSupp += e.getPrix();
        }
        return prixSupp;
    }

    public void reset(){
        elementListeSelectionne.clear();
        for(Element e : elementListe){
            e.reset();
        }
    }
}
