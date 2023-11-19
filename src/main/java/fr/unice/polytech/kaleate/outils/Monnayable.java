package fr.unice.polytech.kaleate.outils;

public interface Monnayable {
    /**
     * prix tout compris dedans
     * @return float
     */
    public double getPrix();

    /**
     * prix sans reduction, avec tous les éléments supplémentaires
     * @return float
     */
    public double getPrixSansReduction();

    /**
     * prix de base, sans réduction ni élément supplémentaire
     * @return float
     */
    public double getPrixBase();


}
