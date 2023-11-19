package fr.unice.polytech.kaleate.menu.gestion;

import fr.unice.polytech.kaleate.outils.Monnayable;

import java.util.List;

public interface ChoixSupplementGestion<T> extends Monnayable {

    public void setSupplementsListe(List<T> supplementsListe);
    public void addSupplement(T supplement);

    public List<T> getSupplementsListe();

    public List<T> getSupplementsSelectionnes();

}
