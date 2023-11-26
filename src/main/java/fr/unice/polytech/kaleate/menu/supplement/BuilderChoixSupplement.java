package fr.unice.polytech.kaleate.menu.supplement;

import fr.unice.polytech.kaleate.builder.Builder;

import java.util.List;

public abstract class BuilderChoixSupplement<T> implements Builder<ChoixSupplement<T>> {

    ChoixSupplement<T> choixSupplement;
    Class<Supplement> classChose;

    public void setChoixSupplement(List<T> choixSupplement) {
        this.choixSupplement.setSupplementsListe(choixSupplement);

    }
    @Override
    public abstract void reset();
    @Override
    public ChoixSupplement<T> getResult() {
        return choixSupplement;
    }
}
