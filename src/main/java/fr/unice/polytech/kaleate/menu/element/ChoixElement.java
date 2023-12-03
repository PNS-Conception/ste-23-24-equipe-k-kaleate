package fr.unice.polytech.kaleate.menu.element;

import fr.unice.polytech.kaleate.menu.Choix;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un choix d'éléments sélectionnés dans le menu
 *
 * elementsListeDisponible : liste des éléments disponibles pour l'utilisateur
 * nbChoixElement : nombre d'éléments que l'utilisateur peut choisir
 *
 */
public class ChoixElement implements Choix<Element> {
    private String nomElement;
    private int nbChoixElement;

    private List<Element> elementListeSelectionne;
    private List<Element> elementListeDisponible;

    public ChoixElement(){
        super();
        this.elementListeDisponible = new ArrayList<>();
        this.elementListeSelectionne = new ArrayList<>();
        this.nbChoixElement = 0;
        this.nomElement = "";
    }

    public ChoixElement(String nomElement, int nbChoixElement){
        this.nomElement = nomElement;
        this.nbChoixElement = nbChoixElement;
        this.elementListeDisponible = new ArrayList<>();
        this.elementListeSelectionne = new ArrayList<>();
    }

    protected ChoixElement(String nomElement, int nbChoixElement, ArrayList<Element> elementListeDisponible){
        this.nomElement = nomElement;
        this.nbChoixElement = nbChoixElement;
        this.elementListeDisponible = elementListeDisponible;
        this.elementListeSelectionne = new ArrayList<>();
    }

    @Override
    public String getNom() {
        return nomElement;
    }

    @Override
    public int getNbChoixPossiblePourUtilisateur() {
        return nbChoixElement;
    }

    @Override
    public List<Element> getListe() {
        return elementListeDisponible;
    }

    @Override
    public List<Element> getListeSelectionne() {
        return elementListeSelectionne;
    }

    @Override
    public void setListe(List<Element> liste) {
        this.elementListeDisponible = liste;

    }

    @Override
    public void setNom(String nomElement) {
        this.nomElement = nomElement;
    }

    @Override
    public void setNbChoixPossiblePourUtilisateur(int nbChoixElement) {
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
        elementListeDisponible.add(e);
    }

    public void supprimer(Element element) {
        elementListeDisponible.remove(element);
    }

    /**
     * Cherche un élément grâce à son nom dans la liste des éléments proposés par le manger de restaurant
     * @param s le nom de l'élément recherché
     * @return l'élément trouvé grâce à l'entrée
     */
    @Override
    public Element getParNom(String s){
        return elementListeDisponible.stream().filter(element -> element.estParNom(s)).findFirst().orElse(null);
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
        elementListeSelectionne = new ArrayList<>();
        for(Element e : elementListeDisponible){
            e.reset();
        }
    }

    public void verifElement(){
        if(elementListeSelectionne.size() == 0){
            elementListeSelectionne.add(elementListeDisponible.get(0));
        }
        for(Element e : elementListeSelectionne){
            e.verifChoixComposant();
        }
    }

    public void supprimerElementDisponibleParNom(String nom){
        elementListeDisponible.removeIf(element -> element.estParNom(nom));
    }

    public void supprimerElementSelectionneParNom(String nom){
        elementListeSelectionne.removeIf(element -> element.estParNom(nom));
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(nomElement).append(" : ");
        for(Element e : elementListeSelectionne){
            sb.append(e.getNom()).append(" ");
        }
        sb.append("\n");
        for(Element e : elementListeDisponible){
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }
}
