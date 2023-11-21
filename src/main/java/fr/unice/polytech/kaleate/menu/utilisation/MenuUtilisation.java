package fr.unice.polytech.kaleate.menu.utilisation;

import fr.unice.polytech.kaleate.menu.ContenuMenu;
import fr.unice.polytech.kaleate.menu.element.SupplementElement;
import fr.unice.polytech.kaleate.menu.utilisation.ChoixUtilisation;
import fr.unice.polytech.kaleate.menu.utilisation.ElementUtilisation;
import fr.unice.polytech.kaleate.outils.Monnayable;

import java.util.List;

public interface MenuUtilisation extends Monnayable {
    String getNom();
    String getDescription();
    int getId();

    ContenuMenu getContenuMenu();
}
