package fr.unice.polytech.kaleate;

public class Livreur {

    private String nom;
    private String prenom;

    private GestionnaireLivraison gestionnaireLivraison;

    public Livreur(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;

    }



    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }



    public void attribuerCommande(Commande commande){
        gestionnaireLivraison = new GestionnaireLivraison(commande);
    }

    public void debuterLaCourse(){
        gestionnaireLivraison.debuterLaCourse();
      }

    public void arriverADestination(){
        gestionnaireLivraison.arriverADestination();
        }

    public void terminerLivraison(){
        gestionnaireLivraison.ajouterAHistorique();
        gestionnaireLivraison = null;

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
