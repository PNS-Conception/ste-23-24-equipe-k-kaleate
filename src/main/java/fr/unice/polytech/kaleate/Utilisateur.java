package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class Utilisateur {

        private String nom;
        private String prenom;

        private Commande commandeActuelle;

        private ArrayList<Commande> historique;

        private float solde = 1000;

        public Utilisateur(String nom, String prenom){
            this.nom = nom;
            this.prenom = prenom;
        }

        public String getNom(){
            return this.nom;
        }

        public String getPrenom(){
            return this.prenom;
        }

        public Commande getCommandeActuelle() {
            return commandeActuelle;
        }

        public void setCommandeActuelle(Commande commandeActuelle) {
            this.commandeActuelle = commandeActuelle;
        }
        public boolean rejoindreCommandegroupee(CommandeGroupee commandeGroupee,int code){
                if(commandeActuelle == null){
                    commandeActuelle = new Commande();
                }
                return commandeGroupee.ajouterCommande(code, commandeActuelle);
        }
        public boolean addMenu(Menu m){
            if(commandeActuelle == null){
                commandeActuelle = new Commande();
            }
            return commandeActuelle.addMenu(m);
        }
        public boolean removeMenu(Menu m){
            return commandeActuelle.removeMenu(m);
        }

        public void setCreneauLivraison(Creneau creneauLivraison) {
            this.commandeActuelle.setCreneauLivraison(creneauLivraison);
        }

        public float getSolde() {
            return solde;
        }

        public void setSolde(float solde) {
            this.solde = solde;
        }
        public void addSolde(float solde) {
            this.solde += solde;
        }
        public boolean payer(){
            if(commandeActuelle == null) return false;
            if(new PayementExterne().payer(commandeActuelle.getPrice())) {
                commandeActuelle.setStatut(StatutCommande.PAYEE);
                return true;
            }
            return false;
        }
}
