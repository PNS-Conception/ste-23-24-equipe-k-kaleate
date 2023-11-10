package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class ChoixComposant {
    private String nomComposant;
    private int nbChoixComposantMax;
    private ArrayList<Composant> composantListe;
    private ArrayList<Integer> listeChoixComposant;

    public ChoixComposant(String nomComposant, int nbChoixComposantMax) {
        this.nomComposant = nomComposant;
        this.nbChoixComposantMax = nbChoixComposantMax;
        this.composantListe = new ArrayList<>();
        this.listeChoixComposant = new ArrayList<>(nbChoixComposantMax);
    }

    public String getNomComposant() {
        return nomComposant;
    }

    public int getNbChoixComposantMax() {
        return nbChoixComposantMax;
    }

    public ArrayList<Composant> getComposantListe() {
        return composantListe;
    }

    public ArrayList<Integer> getListeChoixComposant() {
        return listeChoixComposant;
    }

    public void ajoutChoixComposant(int i){
        if(listeChoixComposant.size() < nbChoixComposantMax){
            listeChoixComposant.add(i);
        }
        //Ajouter un else?
    }

    public void ajoutComposant(Composant composant){
        composantListe.add(composant);
    }
}
