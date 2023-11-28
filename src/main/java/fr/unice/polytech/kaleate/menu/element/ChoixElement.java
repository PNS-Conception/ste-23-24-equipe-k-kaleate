package fr.unice.polytech.kaleate.menu.element;

import fr.unice.polytech.kaleate.menu.Choix;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un choix d'éléments sélectionnés dans le menu
 *
 * elementsListe : liste des éléments disponibles pour l'utilisateur
 * nbChoixElement : nombre d'éléments que l'utilisateur peut choisir
 *
 */
public class ChoixElement implements Choix<Element> {
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
    public List<Element> getListe() {
        return elementListe;
    }

    @Override
    public List<Element> getListeSelectionne() {
        return elementListeSelectionne;
    }

    @Override
    public void setListe(List<Element> liste) {
        this.elementListe = liste;

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

    @Override
    public void reset(){
        elementListeSelectionne.clear();
        for(Element e : elementListe){
            e.reset();
        }
    }

    public void verifElement(){
        if(elementListeSelectionne.size() == 0){
            elementListeSelectionne.add(elementListe.get(0));
        }
        for(Element e : elementListeSelectionne){
            e.verifChoixComposant();
        }
    }
}
