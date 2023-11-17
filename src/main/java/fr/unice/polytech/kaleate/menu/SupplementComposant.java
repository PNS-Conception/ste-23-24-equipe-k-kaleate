package fr.unice.polytech.kaleate.menu;

public class SupplementComposant extends Composant implements Supplement{

    private float prix;

    public SupplementComposant(String nomSupplementComposant, float prix) {
        super(nomSupplementComposant);
        this.prix = prix;
    }

    @Override
    public float getPrix() {
        return this.prix;
    }
}
