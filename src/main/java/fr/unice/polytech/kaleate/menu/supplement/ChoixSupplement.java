package fr.unice.polytech.kaleate.menu.supplement;

import fr.unice.polytech.kaleate.menu.utilisation.ChoixSupplementUtilisation;
import fr.unice.polytech.kaleate.menu.gestion.ChoixSupplementGestion;

public interface ChoixSupplement<T> extends ChoixSupplementGestion<T>, ChoixSupplementUtilisation<T> {

}
