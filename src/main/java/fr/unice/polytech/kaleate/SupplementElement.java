package fr.unice.polytech.kaleate;

public class SupplementElement extends Element implements Supplement{
    private int prix;

    public SupplementElement(String nomElement, int prix) {
        super(nomElement);
        this.prix = prix;
    }


    @Override
    public int getPrix() {
        return this.prix;
    }
}
