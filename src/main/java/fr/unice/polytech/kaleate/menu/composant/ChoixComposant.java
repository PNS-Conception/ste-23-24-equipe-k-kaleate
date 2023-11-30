package fr.unice.polytech.kaleate.menu.composant;

import fr.unice.polytech.kaleate.menu.Choix;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un choix de composants sélectionnés dans le menu
 *
 * composantListe : liste des composants disponibles
 * nbChoixComposantMax : nombre de composants maximum choisissable
 */


public class ChoixComposant implements Choix<Composant> {
    private String nomComposant;
    private int nbChoixComposantMax;
    private List<Composant> composantListeDisponible;
    private List<Composant> composantListeSelectionne;

    public ChoixComposant(){
        this.composantListeDisponible = new ArrayList<>();
        this.composantListeSelectionne = new ArrayList<>();
        this.nbChoixComposantMax = 0;
        this.nomComposant = "";
    }

    public ChoixComposant(String nomComposant, int nbChoixComposantMax) {
        this.nomComposant = nomComposant;
        this.nbChoixComposantMax = nbChoixComposantMax;
        this.composantListeDisponible = new ArrayList<>();
        this.composantListeSelectionne = new ArrayList<>();
    }


    public ChoixComposant(String nomComposant, int nbChoixComposantMax, List<Composant> composantListeDisponible) {
        this.nomComposant = nomComposant;
        this.nbChoixComposantMax = nbChoixComposantMax;
        this.composantListeDisponible = composantListeDisponible;
        this.composantListeSelectionne = new ArrayList<>();
    }

    public String getNomComposant() {
        return nomComposant;
    }


    public void setNom(String nomComposant) {
        this.nomComposant = nomComposant;
    }

    public String getNom() {
        return nomComposant;
    }

    @Override
    public void setNbChoixPossiblePourUtilisateur(int nbChoixComposantMax) {
        this.nbChoixComposantMax = nbChoixComposantMax;
    }

    @Override
    public void setListe(List<Composant> composantListe) {
        this.composantListeDisponible = composantListe;
    }

    @Override
    public int getNbChoixPossiblePourUtilisateur() {
        return nbChoixComposantMax;
    }

    @Override

    public List<Composant> getListe() {
        return composantListeDisponible;
    }

    @Override

    public List<Composant> getListeSelectionne() {
        return composantListeSelectionne;
    }

    /**
     * Ajoute un composant à la liste des composants disponibles pour un utilisateur proposé par le manager de restaurant
     * @param composant que l'on veut ajouter
     */
    @Override
    public void ajout(Composant composant){
        composantListeDisponible.add(composant);
    }

    @Override
    public void supprimer(Composant composant) {
        composantListeDisponible.remove(composant);
    }

    public void ajout(String name){
        ajout(new Composant(name));
    }

    /**
     * Cherche un composant dans la liste des composants disponibles
     * @param s le composant que l'on veut
     * @return le composant trouvé grâce au string d'entré en paramètres
     */
    @Override
    public Composant getParNom(String s){
        return composantListeDisponible.stream().filter(composant -> composant.estParNom(s)).findFirst().orElse(null);
    }

    /**
     * Cherche un composant sélectionné dans la liste des composants sélectionnés
     * @param s le composant que l'on veut
     * @return le composant trouvé grâce au string entré en paramètres
     */
    @Override
    public Composant getSelectionneParNom(String s){
        return composantListeSelectionne.stream().filter(composant -> composant.estParNom(s)).findFirst().orElse(null);
    }

    /**
     * Ajoute le composant choisi par l'utilisateur à la liste des composants sélectionnnés
     * @param composant le composant à ajouter
     */
    @Override
    public void choisir(Composant composant){
        if(composantListeSelectionne.size() < nbChoixComposantMax){
            composantListeSelectionne.add(composant);
        }
        //TODO throw exception
    }

    @Override
    public boolean estChoixParNom(String nomComposant){
        return this.nomComposant.equals(nomComposant);
    }

    @Override
    public void reset(){
        composantListeSelectionne.clear();
        composantListeSelectionne = new ArrayList<>();
    }
    //TODO vérifier si le composant permet de choisir (+ de 1 composant, sinon pas choisissable)
    //TODO

    public void verifComposant(){
        if(composantListeSelectionne.size() == 0){
            composantListeSelectionne.add(composantListeDisponible.get(0));
        }

    }

    public void supprimerComposantParNom(String nomComposant){
        composantListeDisponible.remove(getParNom(nomComposant));
    }
}
