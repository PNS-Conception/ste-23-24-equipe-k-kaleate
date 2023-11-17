package fr.unice.polytech.kaleate.outils;

import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;

import java.util.List;

public interface Listeur {

    List<Menu> getMenusDansCreneau(Creneau c);

    List<Menu> getAllMenus();


}
