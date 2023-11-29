package fr.unice.polytech.kaleate.outils;

import fr.unice.polytech.kaleate.campus.Utilisateur;

public class PayementExterne implements InterfacePayement {
    @Override
    public boolean payer(Utilisateur user, double prix){
        if(user.getSolde()>= prix){
            user.removeSolde((float) prix);
            return true;
        }
        return false;
    }

    @Override
    public boolean rembourser(Utilisateur user,double prix){
        user.addSolde((float) prix);
        return true;

    }



}
