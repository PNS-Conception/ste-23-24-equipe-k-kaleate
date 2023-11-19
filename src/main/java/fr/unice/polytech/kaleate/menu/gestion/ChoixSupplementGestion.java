package fr.unice.polytech.kaleate.menu.gestion;

import fr.unice.polytech.kaleate.outils.Monnayable;

import java.util.List;

public interface ChoixSupplementGestion<T> extends Monnayable {

    public void setSupplementsListe(List<T> supplementsListe);
    public void ajoutSupplement(T supplement);
    public void supprimeSupplement(T supplement);

    public List<T> getSupplementsListe();


}
