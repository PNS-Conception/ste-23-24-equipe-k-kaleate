package fr.unice.polytech.kaleate.menu.supplement;

import fr.unice.polytech.kaleate.outils.Monnayable;

public interface Supplement extends Monnayable {
    String getNom();

    boolean estSupplementParNom(String nom);

}
