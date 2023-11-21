package fr.unice.polytech.kaleate.commande.gestion;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.StatutCommande;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.outils.Monnayable;

import java.util.List;

/**
 * Interface côté Restaurant
 */
public interface CommandeGestion extends Monnayable {
    List<Menu> getMenus();
    void setMenus(List<Menu> menus);
    boolean modifiable();
    float getTempsPreparation();
    int getId();
    Utilisateur getUtilisateurEmetteur();
    Utilisateur getUtilisateurRecepteur();
    StatutCommande getStatut();
    Creneau getCreneauLivraison();
}
