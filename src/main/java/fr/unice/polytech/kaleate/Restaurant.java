package fr.unice.polytech.kaleate;

public class Restaurant {
    ListMenus menus;
    String name;

    public Restaurant(){
        this.menus = new ListMenus();
    }

    public Restaurant(String name){
        this.menus = new ListMenus();
        this.name = name;
    }

    public Restaurant(String name, ListMenus menus){
        this.name = name;
        this.menus = menus;
    }

    public ListMenus getMenus(){
        return this.menus;
    }

    public void setMenus(ListMenus menus){
        this.menus = menus;
    }

    public ListMenus getMenusDansCreneau(Creneau creneau){
        ListMenus listMenu = new ListMenus(this.menus);
        listMenu = new ListMenus(listMenu.stream().filter(menu -> !menu.estComprisDansCreneau(creneau)).toList());
        return listMenu;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n" + name +
                "\n" + menus;
    }
}
