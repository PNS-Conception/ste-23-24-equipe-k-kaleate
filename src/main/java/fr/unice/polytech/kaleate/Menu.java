package fr.unice.polytech.kaleate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Menu implements Listable{
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

}
