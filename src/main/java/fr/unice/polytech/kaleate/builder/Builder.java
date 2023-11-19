package fr.unice.polytech.kaleate.builder;

import fr.unice.polytech.kaleate.menu.gestion.ChoixSupplementGestion;

public interface Builder<R> {
    public void reset();

    public R getResult();
}
