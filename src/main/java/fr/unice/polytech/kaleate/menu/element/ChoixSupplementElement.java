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
    public void addSupplement(SupplementElement supplement) {
        supplementsListe.add(supplement);
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
    public void reset() {
        //TODO verifier si c'est bien ca
        supplementsSelectionnes = new ArrayList<>();
    }

    @Override
    public float getPrix() {
        return 0;
    }

    @Override
    public float getPrixSansReduction() {
        return 0;
    }

    @Override
    public float getPrixBase() {
        return 0;
    }
}
