package fr.unice.polytech.kaleate;

import java.util.List;

public interface Listeur {

    Listable getParNom(String s);

    List<Menu> getMenusDansCreneau(Creneau c);

    List<Menu> getAllMenus();


}
