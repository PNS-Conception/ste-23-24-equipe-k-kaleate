package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class ChoixElement {
    private String nomElement;
    private int nbChoixElement;
    private ArrayList<Element> elementListe;
    private ArrayList<Integer> listeChoixElement;

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

    void ajoutChoixElement(int i){
        if (listeChoixElement.size() < nbChoixElement){
            listeChoixElement.add(i);
        }
        //Ajouter un else?
    }
}
