package fr.unice.polytech.kaleate.menu.supplement;


import fr.unice.polytech.kaleate.menu.element.SupplementElement;

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
    public void supprimeSupplement(SupplementElement supplement) {
        supplementsListe.remove(supplement);
    }

    @Override
    public void reset() {

        supplementsSelectionnes = new ArrayList<>();
    }


    @Override
    public double getPrix() {
        return supplementsSelectionnes.stream().mapToDouble(SupplementElement::getPrix).sum();
    }

    @Override
    public double getPrixSansReduction() {
        return 0;
    }

    @Override
    public double getPrixBase() {
        return 0;
    }

    public void supprimerSupplementParNom(String nom) {
        for (SupplementElement supplement : supplementsListe) {
            if (supplement.getNom().equals(nom)) {
                supplementsListe.remove(supplement);
                break;
            }
        }
    }

    public SupplementElement getSupplementParNom(String nom) {
        for (SupplementElement supplement : supplementsListe) {
            if (supplement.getNom().equals(nom)) {
                return supplement;
            }
        }
        return null;
    }

    public void supprimerSupplementSelectionneParNom(String nom) {
        for (SupplementElement supplement : supplementsSelectionnes) {
            if (supplement.getNom().equals(nom)) {
                supplementsSelectionnes.remove(supplement);
                break;
            }
        }
    }

    public SupplementElement getSupplementSelectionneParNom(String nom) {
        for (SupplementElement supplement : supplementsSelectionnes) {
            if (supplement.getNom().equals(nom)) {
                return supplement;
            }
        }
        return null;
    }
}
