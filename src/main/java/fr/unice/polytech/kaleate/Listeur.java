package fr.unice.polytech.kaleate;

import java.util.List;

public interface Listeur {

    List<Menu> getMenusDansCreneau(Creneau c);

    List<Menu> getAllMenus();


}
