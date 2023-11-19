package fr.unice.polytech.kaleate.menu.utilisation;

import java.util.List;

public interface ChoixSupplementUtilisation<T> {

    public void selectionnerSupplement(T supplement);

    public List<T> getSupplementsListe();

    public List<T> getSupplementsSelectionnes();

    public void reset();

}
