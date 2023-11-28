package fr.unice.polytech.kaleate.campus;

import java.util.ArrayList;

public class ListeUtilisateur extends ArrayList<Utilisateur>{

    public ListeUtilisateur(){
        super();
    }

    public ListeUtilisateur(ListeUtilisateur listeUtilisateur){
        super(listeUtilisateur);
    }

    public Utilisateur getParNom(String nom){
        return this.stream().filter(utilisateur -> utilisateur.getNom().equals(nom)).findFirst().orElse(null);
    }
}
