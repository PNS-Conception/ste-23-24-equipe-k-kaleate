package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class ChoixComposant {
    private String nomComposant;
    private int nbChoixComposantMax;
    private ArrayList<Composant> composantListe;
    private ArrayList<Composant> listeComposantSelectionne;

    public ChoixComposant(String nomComposant, int nbChoixComposantMax) {
        this.nomComposant = nomComposant;
        this.nbChoixComposantMax = nbChoixComposantMax;
        this.composantListe = new ArrayList<>();
        this.listeComposantSelectionne = new ArrayList<>(nbChoixComposantMax);
    }

    public String getNomComposant() {
        return nomComposant;
    }

    public int getNbChoixComposantMax() {
        return nbChoixComposantMax;
    }

    public ArrayList<Composant> getComposantListe() {
        return composantListe;
    }

    public ArrayList<Composant> getListeComposantSelectionne() {
        return listeComposantSelectionne;
    }


    /**
     * Ajoute un composant à la liste des composants disponibles pour un utilisateur proposé par le manager de restaurant
     * @param composant que l'on veut ajouter
     */
    public void ajoutComposant(Composant composant){
        composantListe.add(composant);
    }

    /**
     * Cherche un composant dans la liste des composants disponibles
     * @param s le composant que l'on veut
     * @return le composant trouvé grâce au string d'entré en paramètres
     */
    public Composant getComposantParNom(String s){
        return composantListe.stream().filter(composant -> composant.estComposantParNom(s)).findFirst().orElse(null);
    }

    /**
     * Cherche un composant sélectionné dans la liste des composants sélectionnés
     * @param s le composant que l'on veut
     * @return le composant trouvé grâce au string entré en paramètres
     */
    public Composant getComposantSelectionneParNom(String s){
        return listeComposantSelectionne.stream().filter(composant -> composant.estComposantParNom(s)).findFirst().orElse(null);
    }

    /**
     * Ajoute le composant choisi par l'utilisateur à la liste des composants sélectionnnés
     * @param composant le composant à ajouter
     */
    public void choisirComposant(Composant composant){
        if(listeComposantSelectionne.size() < nbChoixComposantMax){
            listeComposantSelectionne.add(composant);
        }
    }
    public boolean estChoixComposantParNom(String nomComposant){
        return this.nomComposant.equals(nomComposant);
    }
}
