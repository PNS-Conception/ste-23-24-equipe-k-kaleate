package fr.unice.polytech.kaleate.outils;

import fr.unice.polytech.kaleate.campus.Utilisateur;

public interface InterfacePayement {
    boolean payer(Utilisateur user, double prix);
    boolean rembourser(Utilisateur user,double solde);
}
