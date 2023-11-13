package fr.unice.polytech.kaleate;

import java.util.ArrayList;
import java.util.Objects;

public class ChoixComposant {
    private String nomComposant;
    private int nbChoixComposantMax;
    private ArrayList<Composant> composantListe;
    private ArrayList<Composant> listeChoixComposant;

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

    public ArrayList<Composant> getListeChoixComposant() {
        return listeChoixComposant;
    }

    public void ajoutChoixComposant(Composant composant){
        if(listeChoixComposant.size() < nbChoixComposantMax){
            listeChoixComposant.add(composant);
        }
        //Ajouter un else?
    }

    public void ajoutComposant(Composant composant){
        composantListe.add(composant);
    }

    public Composant getComposantParNom(String s){
        return composantListe.stream().filter(composant -> composant.estComposantParNom(s)).findFirst().orElse(null);
    }

    public Composant getComposantChoisiParNom(String s){
        return listeChoixComposant.stream().filter(composant -> composant.estComposantParNom(s)).findFirst().orElse(null);
    }

    public void choisirComposant(Composant composant){
        if(listeChoixComposant.size() < nbChoixComposantMax){
            listeChoixComposant.add(composant);
        }
    }
    public boolean estChoixComposantParNom(String nomComposant){
        return this.nomComposant.equals(nomComposant);
    }
}
