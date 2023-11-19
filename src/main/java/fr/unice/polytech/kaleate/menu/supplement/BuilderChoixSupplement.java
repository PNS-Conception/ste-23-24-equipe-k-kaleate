package fr.unice.polytech.kaleate.menu.supplement;

import fr.unice.polytech.kaleate.builder.Builder;
import fr.unice.polytech.kaleate.menu.gestion.ChoixSupplementGestion;

import java.util.List;

public abstract class BuilderChoixSupplement<T> implements Builder<ChoixSupplementGestion<T>> {

    ChoixSupplementGestion<T> choixSupplementGestion;
    Class<Supplement> classChose;

    public void setChoixSupplement(List<T> choixSupplement) {
        this.choixSupplementGestion.setSupplementsListe(choixSupplement);

    }
    @Override
    public abstract void reset();
    @Override
    public ChoixSupplementGestion<T> getResult() {
        return choixSupplementGestion;
    }
}
