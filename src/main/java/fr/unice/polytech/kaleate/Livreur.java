package fr.unice.polytech.kaleate;

public class Livreur {
    private Commande commande;
    private String nom;
    private String prenom;

    public Livreur(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.commande = null;
    }

    public Commande getCommande() {
        return commande;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    /**
     * Recuperer la commande prete i du restaurant r
     * @param r
     * @param i
     * @return
     */
    public boolean recupere_commande(Restaurant r, int i){
        Commande c = r.getCommandePrete().getCommandeById(i);
        if (c!=null & (this.commande==null||this.commande.getStatut()==StatutCommande.LIVREE)){
            this.commande=c;
            this.commande.setStatut(StatutCommande.EN_LIVRAISON);
            return true;
        }
        return false;
    }
}
