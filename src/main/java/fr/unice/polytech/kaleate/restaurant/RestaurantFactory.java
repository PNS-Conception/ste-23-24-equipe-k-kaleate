package fr.unice.polytech.kaleate.restaurant;

import fr.unice.polytech.kaleate.campus.Campus;

public interface RestaurantFactory {
    Restaurant nouveauRestau(String name, Campus campus);
}
