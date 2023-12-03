package fr.unice.polytech.kaleate.campus;

import fr.unice.polytech.kaleate.commande.Commandable;
import fr.unice.polytech.kaleate.commande.Commande;
import fr.unice.polytech.kaleate.menu.Menu;

public class Staff extends Utilisateur {

    private final Class<Commandable> typeMenu = Commandable.class;

    public Staff(String nom, String prenom) {
        super(nom, prenom);
    }


    @Override
    public Class getTypeMenu() {
        return typeMenu;
    }
}
