package fr.unice.polytech.kaleate.commande.utilisation;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.StatutCommande;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.outils.Monnayable;

import java.util.List;

/**
 * Interface côté utilisateur
 *
 */
public interface CommandeUtilisation extends Monnayable {
    List<Menu> getMenus();

    boolean addMenu(Menu menu);

    boolean removeMenu(Menu menu);

    boolean modifiable();
    float getTempsPreparation();
    int getId();
    void setId(int i);
    Utilisateur getUtilisateurEmetteur();
    void setUtilisateurEmetteur(Utilisateur utilisateur);
    Utilisateur getUtilisateurRecepteur();
    void setUtilisateurRecepteur(Utilisateur utilisateur);
    StatutCommande getStatut();
    Creneau getCreneauLivraison();
}
