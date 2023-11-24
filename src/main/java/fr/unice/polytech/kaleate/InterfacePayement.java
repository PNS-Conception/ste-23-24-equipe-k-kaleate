package fr.unice.polytech.kaleate;

public interface InterfacePayement {
    boolean payer(Utilisateur user, float prix);
    boolean rembourser(Utilisateur user,float solde);
}
