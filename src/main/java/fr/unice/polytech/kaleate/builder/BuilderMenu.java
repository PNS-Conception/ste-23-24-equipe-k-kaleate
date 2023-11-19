package fr.unice.polytech.kaleate.builder;

import fr.unice.polytech.kaleate.menu.BuilderContenuMenu;
import fr.unice.polytech.kaleate.menu.ContenuMenu;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.Restaurant;

public class BuilderMenu implements Builder<Menu> {

    Menu menu;

    BuilderContenuMenu builderContenuMenu;

    @Override
    public void reset() {
        menu = new Menu();
        builderContenuMenu.reset();
    }
    public Menu getNew(String name, double prix, Creneau creneau, ContenuMenu contenuMenu, Restaurant restaurant, int tempsPreparation)
    {
        this.reset();

        setName(name);
        setPrix(prix);
        setCreneau(creneau);
        setContenuMenu(contenuMenu);
        setRestaurant(restaurant);
        setTempsPreparation(tempsPreparation);

        return getResult();
    }

    public void setName(String name)
    {
        menu.setName(name);
    }

    public void setPrix(double prix)
    {
        menu.setPrix(prix);
    }

    public void setCreneau(Creneau creneau)
    {
        menu.setCreneau(creneau);
    }

    public void setRestaurant(Restaurant restaurant)
    {
        menu.setRestaurant(restaurant);
    }

    public void setContenuMenu()
    {
        menu.setContenuMenu(builderContenuMenu.getResult());
        builderContenuMenu.reset();
    }

    public void setContenuMenu(ContenuMenu contenuMenu)
    {
        menu.setContenuMenu(contenuMenu);
    }

    public void setTempsPreparation(int tempsPreparation)
    {
        menu.setTempsPreparation(tempsPreparation);
    }

    public BuilderContenuMenu getBuilderContenuMenu() {
        return builderContenuMenu;
    }

    @Override
    public Menu getResult() {
        return menu;
    }
}
