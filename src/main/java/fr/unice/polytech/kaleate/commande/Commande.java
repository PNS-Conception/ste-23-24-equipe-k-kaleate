package fr.unice.polytech.kaleate.commande;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.menu.StatutMenu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.outils.Monnayable;
import fr.unice.polytech.kaleate.restaurant.Restaurant;

import java.util.List;
import java.util.Observer;

public interface Commande extends Monnayable, Observer {

    public ListeMenus getMenus();

    public void setMenus(ListeMenus menus);
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

    public boolean finirPreparationMenu(Menu menu);
    public boolean preparerMenu(Menu menu);

    public List<StatutMenu> getStatutsMenus();

    public Menu getMenuParNom(String nom);

    public List<Restaurant> getRestaurants();

    public boolean elligibleReduction();
    public Creneau getCreneauLivraison();
    public void setCreneauLivraison(Creneau creneauLivraison);
    public boolean annulerMenu(Menu mp);
    default public void enregistrerCommande(){
        for(Menu m : getMenus()) {
            m.setCommande(this);
        }
    }

}
