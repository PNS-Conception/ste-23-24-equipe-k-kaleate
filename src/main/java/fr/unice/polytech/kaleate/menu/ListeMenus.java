package fr.unice.polytech.kaleate.menu;

import fr.unice.polytech.kaleate.commande.Commandable;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.outils.Listeur;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListeMenus extends ArrayList<Commandable> implements Listeur {

    public ListeMenus(){
        super();
    }

    public ListeMenus(ListeMenus listeMenus){
        super(listeMenus);
    }
    public ListeMenus(List<Commandable> listeMenus){
        super(listeMenus);
    }

    public Commandable getParNom(String s) {
        return this.stream().filter(menu -> menu.estMenuParNom(s)).findFirst().orElse(null);
    }

    @Override
    public List<Commandable> getMenusDansCreneau(Creneau creneau, Class typeMenu){

        return this.stream()
                .filter(menu -> menu.chevaucheCreneau(creneau) && typeMenu.isInstance(menu))
                .collect(Collectors.toList());
    }
    @Override
    public List<Commandable> getAllMenus(Class typeMenu) {
        return this.stream().filter(menu -> typeMenu.isInstance(menu)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Commandable menu : this){
            stringBuffer.append(menu.toString());
            stringBuffer.append("\n");
        }
        return "ListeMenus \n" + stringBuffer.toString();
    }

    public void resetListeMenu(){
        this.stream().filter(m -> m instanceof Menu).forEach(m -> ((Menu) m).resetMenu());
    }

    public Commandable getMenuParNom(String nom, Class typeMenu){
        return stream().filter(menu -> menu.estMenuParNom(nom) && typeMenu.isInstance(menu)).findFirst().orElse(null);
    }
}
