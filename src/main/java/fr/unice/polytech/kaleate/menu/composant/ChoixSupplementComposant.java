package fr.unice.polytech.kaleate.menu.composant;

import fr.unice.polytech.kaleate.menu.supplement.ChoixSupplement;

import java.util.ArrayList;
import java.util.List;

public class ChoixSupplementComposant implements ChoixSupplement<SupplementComposant> {

    private List<SupplementComposant> supplementsSelectionnes;
    private List<SupplementComposant> supplementsListe;

    public ChoixSupplementComposant() {
        super();
        supplementsListe = new ArrayList<>();
    }

    @Override
    public void setSupplementsListe(List<SupplementComposant> supplementsListe) {
        this.supplementsListe = supplementsListe;
    }

    @Override
    public void addSupplement(SupplementComposant supplement) {
        supplementsListe.add(supplement);
    }

    @Override
    public void selectionnerSupplement(SupplementComposant supplement) {
            supplementsSelectionnes.add(supplement);
    }

    @Override
    public List<SupplementComposant> getSupplementsListe() {
        return supplementsListe;
    }

    @Override
    public List<SupplementComposant> getSupplementsSelectionnes() {
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
