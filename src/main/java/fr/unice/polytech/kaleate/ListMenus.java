package fr.unice.polytech.kaleate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListMenus extends ArrayList<Menu> implements Listeur {

    public ListMenus(){
        super();
    }

    public ListMenus(ListMenus listMenus){
        super(listMenus);
    }
    public ListMenus(List<Menu> listMenus){
        super(listMenus);
    }

    @Override
    public Listable getParNom(String s) {
        return this.stream().filter(menu -> menu.estMenuParNom(s)).findFirst().orElse(null);
    }

    @Override
    public List<Menu> getMenusDansCreneau(Creneau creneau){

        return this.stream()
                .filter(menu -> menu.estComprisDansCreneau(creneau))
                .collect(Collectors.toList());
    }

    @Override
    public List<Menu> getAllMenus() {
        return null;
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
