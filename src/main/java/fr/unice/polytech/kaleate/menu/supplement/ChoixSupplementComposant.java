package fr.unice.polytech.kaleate.menu.supplement;

import fr.unice.polytech.kaleate.menu.Choix;
import fr.unice.polytech.kaleate.menu.composant.SupplementComposant;
import fr.unice.polytech.kaleate.menu.supplement.ChoixSupplement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChoixSupplementComposant implements ChoixSupplement<SupplementComposant> {

    private List<SupplementComposant> supplementsSelectionnes;
    private List<SupplementComposant> supplementsListe;

    public ChoixSupplementComposant() {
        super();
        supplementsListe = new ArrayList<>();
        supplementsSelectionnes = new ArrayList<>();
    }

    @Override
    public void setSupplementsListe(List<SupplementComposant> supplementsListe) {
        this.supplementsListe = supplementsListe;
    }

    @Override
    public void ajoutSupplement(SupplementComposant supplement) {
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
    public void ajoutSupplementSelectionne(SupplementComposant supplement) {
        supplementsSelectionnes.add(supplement);
    }

    @Override
    public void supprimeSupplementSelectionne(SupplementComposant supplement) {
        supplementsSelectionnes.remove(supplement);
    }

    @Override
    public void supprimeSupplement(SupplementComposant supplement) {
        supplementsListe.remove(supplement);
    }

    @Override
    public void reset() {

        supplementsSelectionnes = new ArrayList<>();
    }

    //TODO definir la monayable
    @Override
    public double getPrix() {
        return supplementsSelectionnes.stream().mapToDouble(SupplementComposant::getPrix).sum();
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
