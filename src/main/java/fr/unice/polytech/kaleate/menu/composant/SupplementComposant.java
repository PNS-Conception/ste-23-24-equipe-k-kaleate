package fr.unice.polytech.kaleate.menu.composant;

import fr.unice.polytech.kaleate.menu.composant.Composant;
import fr.unice.polytech.kaleate.menu.supplement.Supplement;

public class SupplementComposant extends Composant implements Supplement {

    private float prix;

    public SupplementComposant(String nomSupplementComposant, float prix) {
        super(nomSupplementComposant);
        this.prix = prix;
    }

    @Override
    public float getPrix() {
        return this.prix;
    }

    @Override
    public float getPrixSansReduction() {
        return this.prix;
    }

    @Override
    public float getPrixBase() {
        return this.prix;
    }

    @Override
    public String getNom() {
        return super.getNomComposant();
    }

    @Override
    public boolean estSupplementParNom(String nom) {
        return super.estComposantParNom(nom);
    }
}
