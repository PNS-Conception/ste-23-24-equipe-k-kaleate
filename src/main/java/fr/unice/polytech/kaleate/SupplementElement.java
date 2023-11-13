package fr.unice.polytech.kaleate;

public class SupplementElement extends Element implements Supplement{
    private float prix;

    public SupplementElement(String nomElement, float prix) {
        super(nomElement);
        this.prix = prix;
    }


    @Override
    public float getPrix() {
        return this.prix;
    }
}
