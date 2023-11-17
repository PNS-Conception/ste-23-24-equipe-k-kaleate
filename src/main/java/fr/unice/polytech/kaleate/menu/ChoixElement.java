package fr.unice.polytech.kaleate.menu;

import java.util.ArrayList;

public class ChoixElement {
    private String nomElement;
    private int nbChoixElement;
    private ArrayList<Element> elementListe;
    private ArrayList<Element> elementListeSelectionne;

    public ChoixElement(String nomElement, int nbChoixElement){
        this.nomElement = nomElement;
        this.nbChoixElement = nbChoixElement;
        this.elementListe = new ArrayList<>();
        this.elementListeSelectionne = new ArrayList<>(nbChoixElement);
    }

    public String getNomElement() {
        return nomElement;
    }

    public int getNbChoixElement() {
        return nbChoixElement;
    }

    public ArrayList<Element> getElementListe() {
        return elementListe;
    }

    public ArrayList<Element> getElementListeSelectionne() {
        return elementListeSelectionne;
    }

    public boolean estChoixElementParNom(String nomChoixelement){
        return this.nomElement.equals(nomChoixelement);
    }

    /**
     * Ajout un élément à la liste des éléments disponible pour l'utilisateur
     * @param e l'élément à ajouter
     */
    public void ajoutElement(Element e){
        elementListe.add(e);
    }

    /**
     * Cherche un élément grâce à son nom dans la liste des éléments proposés par le manger de restaurant
     * @param s le nom de l'élément recherché
     * @return l'élément trouvé grâce à l'entrée
     */
    public Element getElementParNom(String s){
        return elementListe.stream().filter(element -> element.estElementParNom(s)).findFirst().orElse(null);
    }

    /**
     * Cherche un élément grâce à son nom dans la liste des éléments séléctionnés par l'utilisateur
     * @param s le nom de l'élément recherché
     * @return l'élément trouvé grâce à l'entrée
     */
    public Element getElementSelectioneParNom(String s){
        return elementListeSelectionne.stream().filter(element -> element.estElementParNom(s)).findFirst().orElse(null);
    }

    /**
     * Ajoute un élément sélectionné par l'utilisateur à la liste des éléments selectionnés
     * @param element l'élément à ajouter
     */
    public void choisirElement(Element element){
        if (elementListeSelectionne.size() < nbChoixElement){
            elementListeSelectionne.add(element);
        }
    }

    /**
     * Calcule le prix des supppléments de cet élément
     * @return le prix des suppléments
     */
    public float getPrixSupplement(){
        float prixSupp = 0;
        for (Element e : elementListeSelectionne){
            prixSupp += e.getPrixSupplements();
        }
        return prixSupp;
    }

    public void resetChoixElement(){
        this.elementListeSelectionne = new ArrayList<>();
        for(Element e : elementListe){
            e.resetElement();
        }
    }
}
