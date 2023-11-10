package fr.unice.polytech.kaleate;

public class SupplementElement extends Element implements Supplement{
    private int prix;

    public SupplementElement(String nomElement, int nbComposants, int prix) {
        super(nomElement,nbComposants);
        this.prix = prix;
    }


    @Override
    public int getPrix() {
        return this.prix;
    }
}
