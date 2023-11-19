package fr.unice.polytech.kaleate.menu.element;

import fr.unice.polytech.kaleate.menu.composant.ChoixComposant;
import fr.unice.polytech.kaleate.menu.composant.ChoixSupplementComposant;
import fr.unice.polytech.kaleate.menu.composant.SupplementComposant;
import fr.unice.polytech.kaleate.outils.Monnayable;

import java.util.ArrayList;
import java.util.List;

public class Element implements Monnayable {
    private String nomElement;
    private ArrayList<ChoixComposant> choixComposantListe;
    private ChoixSupplementComposant choixSupplement;

    public Element() {
        this.nomElement = "";
        this.choixComposantListe = new ArrayList<>();
    }

    public Element(String nomElement) {
        this.nomElement = nomElement;
        this.choixComposantListe = new ArrayList<>();
        this.choixSupplement = new ChoixSupplementComposant();
    }

    public String getNomElement() {
        return nomElement;
    }

    public void setNomElement(String nomElement) {
        this.nomElement = nomElement;
    }


    public ArrayList<ChoixComposant> getChoixComposantListe() {
        return choixComposantListe;
    }

    public List<SupplementComposant> getChoixSupplement() {
        return choixSupplement.getSupplementsListe();
    }

    public List<SupplementComposant> getChoixSupplementComposantSelectionne() {
        return choixSupplement.getSupplementsSelectionnes();
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
        choixSupplement.addSupplement(supplementComposant);
    }

    public void ajoutChoixSupplementComposant(ChoixSupplementComposant choixComposant){
        choixSupplement = choixComposant;
    }

    /**
     * Ajoute un Supplément Composant à la liste des Suppléments Composants disponibles pour l'utilisateur proposé par le manager
     * @param supplementComposant le supplément composant selectionné par l'utilisateur
     */
    public void ajoutChoixSupplementSelectionne(SupplementComposant supplementComposant){
        choixSupplement.selectionnerSupplement(supplementComposant);
    }


    /**
     * Cherche le choix composant dans la liste des composants disponibles pour l'utilisateur proposés par le manager de restaurant
     * @param nomChoixComposant qu'on l'on veut
     * @return le choix composant trouvé à partir du string entré en paramètres
     */
    public ChoixComposant getChoixComposantParNom(String nomChoixComposant){
        return choixComposantListe.stream().filter(choixComposant1 -> choixComposant1.estChoixParNom(nomChoixComposant)).findFirst().orElse(null);
    }

    /**
     * Cherche le supplément composant dans la liste des supléments composants disponibles pour l'utilisateur proposés par le manager de restaurant
     * @param nomSupplement que l'on veut
     * @return le supplément composant trouvé avec le string entré en paramètres
     */
    public SupplementComposant getSupplementComposantParNom(String nomSupplement){
        return this.choixSupplement.getSupplementsListe().stream().filter(choixSupplement -> choixSupplement.estComposantParNom(nomSupplement)).findFirst().orElse(null);
    }

    /**
     * Cherche le supplément composant sélectionné dans la liste des suppléments composants sélectionné disponibles par l'utilisateur
     * @param nomSupplement que l'on veut
     * @return le supplément composant trouvé avec le string entré en paramètres
     */
    public SupplementComposant getSupplementComposantSelectionneParNom(String nomSupplement){
        return this.choixSupplement.getSupplementsListe().stream().filter(choixSupplement -> choixSupplement.estComposantParNom(nomSupplement)).findFirst().orElse(null);
    }

    public void resetElement(){
        this.choixSupplement.reset();
        for(ChoixComposant chCo : choixComposantListe){
            chCo.reset();
        }
    }


    /**
     * Calcule le prix des suppléments compris dans l'élément
     * @return le prix des suppléments
     */
    @Override
    public float getPrix(){
        float totSup = 0;
        for (SupplementComposant supplementComposant : choixSupplement.getSupplementsSelectionnes()){
            totSup += supplementComposant.getPrix();
        }

        return totSup;
    }

    @Override
    public float getPrixSansReduction() {
        return getPrix();
    }

    @Override
    public float getPrixBase() {
        return getPrix();
    }
}
