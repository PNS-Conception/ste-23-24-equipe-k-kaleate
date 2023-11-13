package fr.unice.polytech.kaleate;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChoixElement {
    private String nomElement;
    private int nbChoixElement;
    private ArrayList<Element> elementListe;
    private ArrayList<Element> listeChoixElement;

    public ChoixElement(String nomElement, int nbChoixElement){
        this.nomElement = nomElement;
        this.nbChoixElement = nbChoixElement;
        this.elementListe = new ArrayList<>();
        this.listeChoixElement = new ArrayList<>(nbChoixElement);
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

    public ArrayList<Element> getListeChoixElement() {
        return listeChoixElement;
    }

    public boolean estChoixElementParNom(String nomChoixelement){
        return this.nomElement.equals(nomChoixelement);
    }

    void ajoutElement(Element e){
        elementListe.add(e);
    }

    public Element getElementParNom(String s){
        return elementListe.stream().filter(element -> element.estElementParNom(s)).findFirst().orElse(null);
    }

    public Element getElementChoisiParNom(String s){
        return listeChoixElement.stream().filter(element -> element.estElementParNom(s)).findFirst().orElse(null);
    }

    public void choisirElement(Element element){
        if (listeChoixElement.size() < nbChoixElement){
            listeChoixElement.add(element);
        }
    }

    public float getPrixSupplement(){
        float prixSupp = 0;
        for (Element e : listeChoixElement){
            prixSupp += e.getPrixSupplements();
        }
        return prixSupp;
    }
}
