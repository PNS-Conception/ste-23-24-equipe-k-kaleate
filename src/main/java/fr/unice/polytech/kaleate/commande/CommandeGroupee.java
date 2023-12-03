package fr.unice.polytech.kaleate.commande;


import fr.unice.polytech.kaleate.menu.StatutMenu;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommandeGroupee extends CommandeSimple {
    private List<Commande> commandes = new ArrayList<>();
    private int code;

    public CommandeGroupee(){
        super();
        SecureRandom r = new SecureRandom ();
        code = r.nextInt(10000,99999);
    }
    public CommandeGroupee(Commande commande){
        super(commande.getUtilisateurEmetteur());
        for (Commandable m : commande.getMenus()) {
            this.addMenu(m);
        }
        setCreneauLivraison(commande.getCreneauLivraison());
        commandes.add(commande);
        Random r = new Random();
        code = r.nextInt(10000,99999);
    }
    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public boolean ajouterCommande(int code, Commande commande){
        if(code != this.code) return false;
        if(commande.getCreneauLivraison() == null ) //la commande est pas initialisé donc pas besoin de verif)
        {
            commande.setCreneauLivraison(this.getCreneauLivraison());
        }
        if(!(commande.getCreneauLivraison().equals(commandes.get(0).getCreneauLivraison()))){// la commande ajoutée doit avoir le meme creneau que la commande mère
            return false;
        }

        return commandes.add(commande);

    }

    @Override
    protected int nombreMenuPourReduc() {
        int i =0;
        for(Commande c : commandes){
            for(Commandable m : c.getMenus()){
                if(m.getStatut()!= StatutMenu.ANNULE){
                    i++;
                }
            }
        }


        return i;
    }

    @Override
    public boolean elligibleReduction() {
        if(getReduction()) return true;
        if(nombreMenuPourReduc()>=10){
            getUtilisateurEmetteur().addSolde((float) (getPrix()*0.1));
            for(Commande c : commandes)
                c.setReduction(true);
            return true;
        }
        return false;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandeGroupee)) return false;
        Boolean res = true;
        CommandeGroupee cs = (CommandeGroupee) o;
        if(cs.commandes.size() != commandes.size()) return false;
        for(int i =0;i<commandes.size();i++){
            res = res && commandes.get(i).equals(cs.commandes.get(i));
        }
        return res;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
