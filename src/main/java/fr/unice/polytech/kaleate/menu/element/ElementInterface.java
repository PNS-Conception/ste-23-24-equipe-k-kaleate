package fr.unice.polytech.kaleate.menu.element;

import fr.unice.polytech.kaleate.menu.gestion.ElementGestion;
import fr.unice.polytech.kaleate.menu.utilisation.ElementUtilisation;
import fr.unice.polytech.kaleate.outils.Monnayable;

/**
 *
 * @param <CT> Classe choix de l'élément
 * @param <ST> Classe en supplément de l'élément
 */
public interface ElementInterface<CT, ST> extends ElementGestion<CT, ST>, ElementUtilisation<CT, ST>, Monnayable {
    public void reset();
}
