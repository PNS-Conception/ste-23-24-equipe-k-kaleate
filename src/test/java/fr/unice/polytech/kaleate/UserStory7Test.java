package fr.unice.polytech.kaleate;

import io.cucumber.java.fr.*;

public class UserStory7Test {

    @Soit("le restaurant {string}")
    public void le_restaurant(String string) {
    }
    @Soit("la commande {int} validee avec une liste de {int} menus du Restaurant {string}")
    public void la_commande_validee_avec_une_liste_de_menus_du_restaurant(Integer int1, Integer int2, String string) {
    }
    @Soit("je suis manager du restaurant {string}")
    public void je_suis_manager_du_restaurant(String string) {
    }
    @Étantdonnéque("{int} menus de la commande {int} sont pret")
    public void menus_de_la_commande_sont_pret(Integer int1, Integer int2) {
    }
    @Quand("je veux dire que la commande est prete")
    public void je_veux_dire_que_la_commande_est_prete() {
    }
    @Alors("la commande n'est pas prete")
    public void la_commande_n_est_pas_prete() {

    }

    @Étantdonnéque("{int} menus de la commande {int} sont prets")
    public void menus_de_la_commande_sont_prets(Integer int1, Integer int2) {

    }
    @Alors("la commande est prete")
    public void la_commande_est_prete() {

    }

}
