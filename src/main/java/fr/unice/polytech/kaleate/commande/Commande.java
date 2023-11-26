package fr.unice.polytech.kaleate.commande;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Monnayable;

import java.util.List;
import java.util.Observer;

public interface Commande extends Monnayable, Observer {
    public List<Menu> getMenus();

    public void setMenus(List<Menu> menus);
    public boolean addMenu(Menu menu);

    public boolean removeMenu(Menu menu);
    public boolean modifiable();
    public float getTempsPreparation();
    public int getId();
    public void setId(int id);
    public Utilisateur getUtilisateurRecepteur();
    public Utilisateur getUtilisateurEmetteur();
    public void setUtilisateurRecepteur(Utilisateur utilisateur);
    public void setUtilisateurEmetteur(Utilisateur utilisateur);
    public StatutCommande getStatut();
    //TODO n'est pas viable dans l'utilisation
    public void setStatut(StatutCommande statut);
    public void valideeCommande();


}
