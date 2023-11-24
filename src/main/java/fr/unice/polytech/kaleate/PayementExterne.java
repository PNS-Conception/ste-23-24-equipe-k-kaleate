package fr.unice.polytech.kaleate;

public class PayementExterne implements InterfacePayement {
    @Override
    public boolean payer(Utilisateur user,float prix){
        if(user.getSolde()>= prix){
            user.removeSolde(prix);
            return true;
        }
        return false;
    }

    @Override
    public boolean rembourser(Utilisateur user,float prix){
        user.addSolde(prix);
        return true;

    }

}
