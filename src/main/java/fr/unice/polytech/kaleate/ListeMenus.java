package fr.unice.polytech.kaleate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListeMenus extends ArrayList<Menu> implements Listeur {

    public ListeMenus(){
        super();
    }

    public ListeMenus(ListeMenus listeMenus){
        super(listeMenus);
    }
    public ListeMenus(List<Menu> listeMenus){
        super(listeMenus);
    }

    public Menu getParNom(String s) {
        return this.stream().filter(menu -> menu.estMenuParNom(s)).findFirst().orElse(null);
    }

    @Override
    public List<Menu> getMenusDansCreneau(Creneau creneau){

        return this.stream()
                .filter(menu -> menu.chevaucheCreneau(creneau))
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
        return "ListeMenus \n" + stringBuffer.toString();
    }
}
