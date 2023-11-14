package fr.unice.polytech.kaleate;

public interface RestaurantFactory {
    Restaurant nouveauRestau(String name, Campus campus);
}
