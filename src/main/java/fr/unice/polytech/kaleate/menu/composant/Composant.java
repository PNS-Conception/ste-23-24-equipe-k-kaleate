package fr.unice.polytech.kaleate.menu.composant;

public class Composant {
    private String nomComposant;

    public Composant(String nomComposant){
        this.nomComposant = nomComposant;
    }

    public String getNom() {
        return nomComposant;
    }

    public boolean estParNom(String nomElement){
        return this.nomComposant.equals(nomElement);
    }
}
