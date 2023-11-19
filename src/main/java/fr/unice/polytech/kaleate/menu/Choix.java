package fr.unice.polytech.kaleate.menu;

import fr.unice.polytech.kaleate.menu.gestion.ChoixGestion;
import fr.unice.polytech.kaleate.menu.utilisation.ChoixUtilisation;

public interface Choix<T> extends ChoixUtilisation<T>, ChoixGestion<T> {
    void reset();
}
