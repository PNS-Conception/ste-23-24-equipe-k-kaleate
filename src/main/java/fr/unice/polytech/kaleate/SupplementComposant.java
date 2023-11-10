package fr.unice.polytech.kaleate;

public class SupplementComposant extends Composant implements Supplement{

    private int prix;

    public SupplementComposant(String nomSupplementComposant, int prix) {
        super(nomSupplementComposant);
        this.prix = prix;
    }

    @Override
    public int getPrix() {
        return this.prix;
    }
}
