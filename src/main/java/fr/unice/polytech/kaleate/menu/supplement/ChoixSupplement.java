package fr.unice.polytech.kaleate.menu.supplement;

import fr.unice.polytech.kaleate.menu.Choix;
import fr.unice.polytech.kaleate.menu.composant.SupplementComposant;
import fr.unice.polytech.kaleate.outils.Monnayable;

import java.util.ArrayList;
import java.util.List;

public interface ChoixSupplement<T> extends Monnayable {


    public void setSupplementsListe(List<T> supplementsListe);

    public void ajoutSupplement(T supplement);

    public void selectionnerSupplement(T supplement);

    public List<T> getSupplementsListe();

    public List<T> getSupplementsSelectionnes();

    public void ajoutSupplementSelectionne(T supplement);

    public void supprimeSupplementSelectionne(T supplement);

    public void supprimeSupplement(T supplement);

    public void reset();

}
