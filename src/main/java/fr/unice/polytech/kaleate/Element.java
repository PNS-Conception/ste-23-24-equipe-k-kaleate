package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class Element {
    private String nomElement;
    private ArrayList<ChoixComposant> choixComposantListe;
    private ArrayList<SupplementComposant> choixSupplementComposant;
    private ArrayList<SupplementComposant> choixSupplementComposantSelectionne;

    public Element(String nomElement) {
        this.nomElement = nomElement;
        this.choixComposantListe = new ArrayList<>();
        this.choixSupplementComposant = new ArrayList<>();
        this.choixSupplementComposantSelectionne = new ArrayList<>();
    }

    public String getNomElement() {
        return nomElement;
    }


    public ArrayList<ChoixComposant> getChoixComposantListe() {
        return choixComposantListe;
    }

    public ArrayList<SupplementComposant> getChoixSupplementComposant() {
        return choixSupplementComposant;
    }

    public ArrayList<SupplementComposant> getChoixSupplementComposantSelectionne() {
        return choixSupplementComposantSelectionne;
    }

    public boolean estElementParNom(String nomElement){
        return this.nomElement.equals(nomElement);
    }

    /**
     * Ajoute un Choix Composant à la liste des Choix Composants disponibles pour l'utilisateur proposé par le manager de restaurant
     * @param choixComposant le choix composant à ajouter
     */
    public void ajoutComposant(ChoixComposant choixComposant){
        choixComposantListe.add(choixComposant);
    }

    /**
     * Ajoute un Supplément Composant à la liste des supplements Composants disponibles pour l'utilisateur proposé par le manager de restaurant
     * @param supplementComposant le supplement Composant à ajouter
     */
    public void ajoutSupplementComposant(SupplementComposant supplementComposant){
        choixSupplementComposant.add(supplementComposant);
    }

    /**
     * Ajoute un Supplément Composant à la liste des Suppléments Composants disponibles pour l'utilisateur proposé par le manager
     * @param supplementComposant le supplément composant selectionné par l'utilisateur
     */
    public void ajoutChoixSupplementSelectionne(SupplementComposant supplementComposant){
        choixSupplementComposantSelectionne.add(supplementComposant);
    }

    /**
     * Calcule le prix des suppléments compris dans l'élément
     * @return le prix des suppléments
     */
    public float getPrixSupplements(){
        float totSup = 0;
        for (SupplementComposant supplementComposant : choixSupplementComposantSelectionne){
            totSup += supplementComposant.getPrix();
        }

        return totSup;
    }

    /**
     * Cherche le choix composant dans la liste des composants disponibles pour l'utilisateur proposés par le manager de restaurant
     * @param nomChoixComposant qu'on l'on veut
     * @return le choix composant trouvé à partir du string entré en paramètres
     */
    public ChoixComposant getChoixComposantParNom(String nomChoixComposant){
        return choixComposantListe.stream().filter(choixComposant1 -> choixComposant1.estChoixComposantParNom(nomChoixComposant)).findFirst().orElse(null);
    }

    /**
     * Cherche le supplément composant dans la liste des supléments composants disponibles pour l'utilisateur proposés par le manager de restaurant
     * @param nomSupplement que l'on veut
     * @return le supplément composant trouvé avec le string entré en paramètres
     */
    public SupplementComposant getSupplementComposantParNom(String nomSupplement){
        return this.choixSupplementComposant.stream().filter(choixSupplement -> choixSupplement.estComposantParNom(nomSupplement)).findFirst().orElse(null);
    }

    /**
     * Cherche le supplément composant sélectionné dans la liste des suppléments composants sélectionné disponibles par l'utilisateur
     * @param nomSupplement que l'on veut
     * @return le supplément composant trouvé avec le string entré en paramètres
     */
    public SupplementComposant getSupplementComposantSelectionneParNom(String nomSupplement){
        return this.choixSupplementComposantSelectionne.stream().filter(choixSupplement -> choixSupplement.estComposantParNom(nomSupplement)).findFirst().orElse(null);
    }
}
