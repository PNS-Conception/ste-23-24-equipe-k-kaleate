package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class Utilisateur {

        private String nom;
        private String prenom;

        private Commande commandeActuel;

        private ArrayList<Commande> historique;

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

        public Commande getCommandeActuel() {
            return commandeActuel;
        }

        public void setCommandeActuel(Commande commandeActuel) {
            this.commandeActuel = commandeActuel;
        }
        public boolean rejoindreCommandegroupee(CommandeGroupee commandeGroupee,int code){
                if(commandeActuel == null){
                    commandeActuel = new Commande();
                }
                return commandeGroupee.ajouterCommande(code,commandeActuel);
        }
        public boolean addMenu(Menu m){
                return commandeActuel.addMenu(m);
        }
        public boolean removeMenu(Menu m){
            return commandeActuel.removeMenu(m);
        }

        public void setCreneauLivraison(Creneau creneauLivraison) {
            this.commandeActuel.setCreneauLivraison(creneauLivraison);
        }
}
