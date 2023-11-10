package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class Element {
    private String nomElement;
    private int nbComposants;
    private ArrayList<ChoixComposant> choixComposantListe;
    private ArrayList<SupplementElement> choixSupplementElement;

    public Element(String nomElement, int nbComposants) {
        this.nomElement = nomElement;
        this.nbComposants = nbComposants;
        this.choixComposantListe = new ArrayList<>(nbComposants);
        this.choixSupplementElement = new ArrayList<>();
    }

    public String getNomElement() {
        return nomElement;
    }

    public int getNbComposants() {
        return nbComposants;
    }

    public ArrayList<ChoixComposant> getChoixComposantListe() {
        return choixComposantListe;
    }

    public ArrayList<SupplementElement> getChoixSupplementElement() {
        return choixSupplementElement;
    }

    public void ajoutComposant(ChoixComposant choixComposant){
        choixComposantListe.add(choixComposant);
    }
}
