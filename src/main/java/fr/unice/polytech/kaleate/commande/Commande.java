package fr.unice.polytech.kaleate.commande;

import fr.unice.polytech.kaleate.commande.gestion.CommandeGestion;
import fr.unice.polytech.kaleate.commande.utilisation.CommandeUtilisation;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Monnayable;

import java.util.List;

public interface Commande extends CommandeGestion, CommandeUtilisation {
    void valideeCommande();
}
