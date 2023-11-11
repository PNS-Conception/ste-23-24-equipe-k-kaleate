package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class Element {
    private String nomElement;
    private ArrayList<ChoixComposant> choixComposantListe;
    private ArrayList<SupplementElement> choixSupplementElement;

    public Element(String nomElement) {
        this.nomElement = nomElement;
        this.choixComposantListe = new ArrayList<>();
        this.choixSupplementElement = new ArrayList<>();
    }

    public String getNomElement() {
        return nomElement;
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
