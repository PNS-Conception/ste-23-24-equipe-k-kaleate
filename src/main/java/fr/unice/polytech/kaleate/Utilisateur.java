package fr.unice.polytech.kaleate;

public class Utilisateur {

        private String nom;
        private String prenom;

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
}
