package fr.unice.polytech.kaleate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Menu {
    private float price;
    private String name;
    public Creneau creneau;

    public Menu(float price, String name, Creneau creneau){
        this.price = price;
        this.name = name;
        this.creneau = creneau;
    }

    public float getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public Creneau getCreneau(){
        return this.creneau;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCreneau(Creneau creneau){
        this.creneau = creneau;
    }

    public boolean estMenuParNom(String name){
        return this.name.equals(name);
    }

    public boolean estComprisDansCreneau(Creneau creneau){
        return this.creneau.estComprisDansCreneau(creneau);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Menu))
            return false;
        if (obj == this)
            return true;
        return this.getName().equals(((Menu) obj).getName()) && this.getPrice() == ((Menu) obj).getPrice() && this.getCreneau().equals(((Menu) obj).getCreneau());
    }

    public boolean isStackable(Menu menu){
        return this.getName().equals(menu.getName()) && this.getPrice() == menu.getPrice();
    }

    @Override
    public String toString() {
        return "Menu : " + this.getName() + " / " + this.getPrice() + "€" + " / " + this.getCreneau().getDebut() + " - " + this.getCreneau().getFin();
    }

    //TODO DELETE AFTER TESTS
    public static List<Menu> getMenus(){
        List<Menu> menus = new ArrayList<Menu>();

        // date qui fonctionnent
        Date db = new Date();
        Date df = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(df);
        c.add(Calendar.DATE, 1);
        df = c.getTime();

        menus.add(new Menu(10, "Burger cheese", new Creneau(db, df)));
        menus.add(new Menu(12, "Burger double cheese", new Creneau(db, df)));
        menus.add(new Menu(8, "Hamburger classic", new Creneau(db, df)));


        // date qui ne fonctionnent pas
        Date dnb = new Date();
        Date dnf = new Date();

        Calendar c2 = Calendar.getInstance();
        c2.setTime(dnf);
        c2.add(Calendar.DATE, 2);
        dnb = c2.getTime();
        c2.add(Calendar.DATE, 1);
        dnf = c2.getTime();

        menus.add(new Menu(10, "NOT Burger cheese", new Creneau(dnb, dnf)));
        menus.add(new Menu(12, "NOT Burger double cheese", new Creneau(dnb, dnf)));
        menus.add(new Menu(8, "NOT Hamburger classic", new Creneau(dnb, dnf)));
        return menus;
    }
}
