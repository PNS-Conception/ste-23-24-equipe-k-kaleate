package fr.unice.polytech.kaleate.menu.element;

import fr.unice.polytech.kaleate.menu.supplement.ChoixSupplement;

import java.util.ArrayList;
import java.util.List;

public class ChoixSupplementElement implements ChoixSupplement<SupplementElement> {

    private List<SupplementElement> supplementsSelectionnes;
    private List<SupplementElement> supplementsListe;

    public ChoixSupplementElement() {
        super();
        supplementsListe = new ArrayList<>();
        supplementsSelectionnes = new ArrayList<>();
    }

    @Override
    public void setSupplementsListe(List<SupplementElement> supplementsListe) {
        this.supplementsListe = supplementsListe;
    }

    @Override
    public void ajoutSupplement(SupplementElement supplement) {
        supplementsListe.add(supplement);
    }

    @Override
    public void supprimeSupplement(SupplementElement supplement) {
        supplementsListe.remove(supplement);
    }

    @Override
    public void selectionnerSupplement(SupplementElement supplement) {
        supplementsSelectionnes.add(supplement);
    }

    @Override
    public List<SupplementElement> getSupplementsListe() {
        return supplementsListe;
    }

    @Override
    public List<SupplementElement> getSupplementsSelectionnes() {
        return supplementsSelectionnes;
    }

    @Override
    public void ajoutSupplementSelectionne(SupplementElement supplement) {
        supplementsSelectionnes.add(supplement);
    }

    @Override
    public void supprimeSupplementSelectionne(SupplementElement supplement) {
        supplementsSelectionnes.remove(supplement);
    }

    @Override
    public void reset() {

        supplementsSelectionnes = new ArrayList<>();
    }

    //TODO definir les prix
    @Override
    public double getPrix() {
        double prix = 0;
        for (SupplementElement supplement : supplementsSelectionnes) {
            prix += supplement.getPrix();
        }
        return prix;
    }

    @Override
    public double getPrixSansReduction() {
        return 0;
    }

    @Override
    public double getPrixBase() {
        return 0;
    }
}
