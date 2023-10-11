package fr.unice.polytech.kaleate;

import java.util.ArrayList;
import java.util.List;

public class ListMenus extends ArrayList<Menu> {

    public ListMenus(){
        super();
    }

    public ListMenus(ListMenus listMenus){
        super(listMenus);
    }
    public ListMenus(List<Menu> listMenus){
        super(listMenus);
    }

    public ListMenus getMenusDansCreneau(Creneau creneau){
        ListMenus listMenu = new ListMenus(this);
        listMenu = new ListMenus(listMenu.stream().filter(menu -> !menu.estComprisDansCreneau(creneau)).toList());
        return listMenu;
    }

    public Menu getMenuParNom(String string) {
        return this.stream().filter(menu -> menu.estMenuParNom(string)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Menu menu : this){
            stringBuffer.append(menu.toString());
            stringBuffer.append("\n");
        }
        return "ListMenus \n" + stringBuffer.toString();
    }
}
