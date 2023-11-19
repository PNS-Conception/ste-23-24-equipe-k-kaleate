package fr.unice.polytech.kaleate.commande;

import java.util.ArrayList;
import java.util.Random;

public class CommandeGroupee extends CommandeSimple {
    private ArrayList<CommandeSimple> commandes = new ArrayList<>();
    private int code;

    public CommandeGroupee(){
        super();
        Random r = new Random();
        code = r.nextInt(10000,99999);
    }
    public CommandeGroupee(CommandeSimple commande){
        super(commande.getUtilisateur(),commande.getMenus());
        setCreneauLivraison(commande.getCreneauLivraison());
        commandes.add(commande);
        Random r = new Random();
        code = r.nextInt(10000,99999);
    }
    public ArrayList<CommandeSimple> getCommandes() {
        return commandes;
    }

    public void setCommandes(ArrayList<CommandeSimple> commandes) {
        this.commandes = commandes;
    }

    public boolean ajouterCommande(int code, CommandeSimple commande){
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
