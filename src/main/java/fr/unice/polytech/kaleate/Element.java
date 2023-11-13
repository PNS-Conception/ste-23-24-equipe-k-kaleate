package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class Element {
    private String nomElement;
    private ArrayList<ChoixComposant> choixComposantListe;
    private ArrayList<SupplementComposant> choixSupplementComposant;
    private ArrayList<SupplementComposant> choixSupplementSelectione;

    public Element(String nomElement) {
        this.nomElement = nomElement;
        this.choixComposantListe = new ArrayList<>();
        this.choixSupplementComposant = new ArrayList<>();
        this.choixSupplementSelectione = new ArrayList<>();
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

    public ArrayList<SupplementComposant> getChoixSupplementSelectione() {
        return choixSupplementSelectione;
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

    public void ajoutChoixSupplementSelectionne(SupplementComposant supplementComposant){
        choixSupplementSelectione.add(supplementComposant);
    }

    public float getPrixSupplements(){
        float totSup = 0;
        for (SupplementComposant supplementComposant : choixSupplementSelectione){
            totSup += supplementComposant.getPrix();
        }

        return totSup;
    }

    public ChoixComposant getChoixComposantParNom(String nomChoixComposant){
        return choixComposantListe.stream().filter(choixComposant1 -> choixComposant1.estChoixComposantParNom(nomChoixComposant)).findFirst().orElse(null);
    }

    public SupplementComposant getSupplementComposantParNom(String nomSupplement){
        return this.choixSupplementComposant.stream().filter(choixSupplement -> choixSupplement.estComposantParNom(nomSupplement)).findFirst().orElse(null);
    }

    public SupplementComposant getSupplementComposantSelectionneParNom(String nomSupplement){
        return this.choixSupplementSelectione.stream().filter(choixSupplement -> choixSupplement.estComposantParNom(nomSupplement)).findFirst().orElse(null);
    }
}
