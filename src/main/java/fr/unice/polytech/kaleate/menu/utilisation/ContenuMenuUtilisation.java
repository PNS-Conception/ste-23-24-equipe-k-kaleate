package fr.unice.polytech.kaleate.menu.utilisation;

import fr.unice.polytech.kaleate.outils.Monnayable;

import java.util.List;

public interface ContenuMenuUtilisation extends Monnayable {
    ContenuMenuUtilisation getContenuMenu();

    List<ChoixElementUtilisation> getChoixElementListeUtilisation();


}
