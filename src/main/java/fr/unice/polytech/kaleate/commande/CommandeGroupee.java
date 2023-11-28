package fr.unice.polytech.kaleate.commande;

import fr.unice.polytech.kaleate.menu.Menu;

import java.util.ArrayList;
import java.util.Random;

public class CommandeGroupee extends CommandeSimple {
    private ArrayList<Commande> commandes = new ArrayList<>();
    private int code;

    public CommandeGroupee(){
        super();
        Random r = new Random();
        code = r.nextInt(10000,99999);
    }
    public CommandeGroupee(Commande commande){
        super(commande.getUtilisateurEmetteur());
        for (Menu m : commande.getMenus()) {
            this.addMenu(m);
        }
        setCreneauLivraison(commande.getCreneauLivraison());
        commandes.add(commande);
        Random r = new Random();
        code = r.nextInt(10000,99999);
    }
    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(ArrayList<Commande> commandes) {
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
