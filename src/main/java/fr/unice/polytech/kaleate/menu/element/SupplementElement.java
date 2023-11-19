package fr.unice.polytech.kaleate.menu.element;

import fr.unice.polytech.kaleate.menu.supplement.Supplement;

public class SupplementElement implements Supplement {
    private float prix;

    private Element element;

    public SupplementElement(String nomElement, float prix) {
        this.element = new Element(nomElement);
        this.prix = prix;
    }

    @Override
    public String getNom() {
        return element.getNom();
    }

    @Override
    public boolean estSupplementParNom(String nom) {
        return element.estParNom(nom);
    }

    @Override
    public double getPrix() {
        return prix + element.getPrix();
    }

    @Override
    public double getPrixSansReduction() {
        return prix + element.getPrixSansReduction();
    }

    @Override
    public double getPrixBase() {
        return prix + element.getPrixBase();
    }
}
