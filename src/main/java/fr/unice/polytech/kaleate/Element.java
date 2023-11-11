package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class Element {
    private String nomElement;
    private ArrayList<ChoixComposant> choixComposantListe;
    private ArrayList<SupplementComposant> choixSupplementComposant;

    public Element(String nomElement) {
        this.nomElement = nomElement;
        this.choixComposantListe = new ArrayList<>();
        this.choixSupplementComposant = new ArrayList<>();
    }

    public String getNomElement() {
        return nomElement;
    }


    public ArrayList<ChoixComposant> getChoixComposantListe() {
        return choixComposantListe;
    }

    public ArrayList<SupplementComposant> getChoixSupplementComposant() {
        return choixSupplementComposant;
    }

    public boolean estElementParNom(String nomElement){
        return this.nomElement.equals(nomElement);
    }

    public void ajoutComposant(ChoixComposant choixComposant){
        choixComposantListe.add(choixComposant);
    }
    public void ajoutSupplementComposant(SupplementComposant supplementComposant){
        choixSupplementComposant.add(supplementComposant);
    }
}
