package fr.unice.polytech.kaleate.menu.composant;

import fr.unice.polytech.kaleate.menu.supplement.Supplement;

public class SupplementComposant extends Composant implements Supplement {

    private float prix;

    public SupplementComposant(String nomSupplementComposant, float prix) {
        super(nomSupplementComposant);
        this.prix = prix;
    }

    @Override
    public double getPrix() {
        return this.prix;
    }

    @Override
    public double getPrixSansReduction() {
        return this.prix;
    }

    @Override
    public double getPrixBase() {
        return this.prix;
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public boolean estSupplementParNom(String nom) {
        return super.estParNom(nom);
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.prix + "€";
    }
}
