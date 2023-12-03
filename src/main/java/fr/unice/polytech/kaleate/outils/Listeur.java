package fr.unice.polytech.kaleate.outils;

import fr.unice.polytech.kaleate.commande.Commandable;

import java.util.List;

public interface Listeur {

    List<Commandable> getMenusDansCreneau(Creneau c, Class typeMenu);

    List<Commandable> getAllMenus(Class typeMenu);


}
