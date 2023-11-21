package fr.unice.polytech.kaleate.menu.element;

import fr.unice.polytech.kaleate.menu.composant.ChoixComposant;
import fr.unice.polytech.kaleate.menu.composant.ChoixSupplementComposant;
import fr.unice.polytech.kaleate.menu.composant.SupplementComposant;
import fr.unice.polytech.kaleate.menu.gestion.ChoixComposantGestion;
import fr.unice.polytech.kaleate.menu.gestion.ElementGestion;
import fr.unice.polytech.kaleate.menu.supplement.ChoixSupplement;
import fr.unice.polytech.kaleate.menu.utilisation.ChoixComposantUtilisation;
import fr.unice.polytech.kaleate.menu.utilisation.ElementUtilisation;

import java.util.ArrayList;
import java.util.List;

public class Element implements ElementGestion, ElementUtilisation {
    private String nomElement;
    private List<ChoixComposant> choixComposantListe;
    private ChoixSupplement<SupplementComposant> choixSupplement;

    public Element() {
        this.nomElement = "";
        this.choixComposantListe = new ArrayList<>();
    }

    public Element(String nomElement) {
        this.nomElement = nomElement;
        this.choixComposantListe = new ArrayList<>();
        this.choixSupplement = new ChoixSupplementComposant();
    }

    protected Element(ElementGestion elementGestion) {
        this.nomElement = elementGestion.getNom();
        this.choixComposantListe = elementGestion.getChoixComposantListeGestion().stream().map(ChoixComposant::new).toList();
        this.choixSupplement = new ChoixSupplementComposant();
    }

    @Override
    public String getNom() {
        return nomElement;
    }

    @Override
    public void setNom(String nomElement) {
        this.nomElement = nomElement;
    }

    /**
     * @return la liste des choix composants disponibles pour l'utilisateur proposé par le manager de restaurant
     */
    @Override
    public List<SupplementComposant> getChoixSupplement() {
        return choixSupplement.getSupplementsListe();
    }

    /**
     * @return la liste des choix composants sélectionnés par l'utilisateur
     */
    @Override
    public List<SupplementComposant> getChoixSupplementSelectionne() {
        return choixSupplement.getSupplementsSelectionnes();
    }

    @Override
    public void ajout(ChoixComposantGestion choix) {
        choixComposantListe.add((ChoixComposant) choix);
    }

    @Override
    public boolean estParNom(String nomElement){
        return this.nomElement.equals(nomElement);
    }

    @Override
    public List<ChoixComposantUtilisation> getChoixComposantListeUtilisation() {
        List<ChoixComposantUtilisation> ccg = new ArrayList<>();
        ccg.addAll(choixComposantListe);
        return ccg;
    }

    @Override
    public List<ChoixComposantGestion> getChoixComposantListeGestion() {
        List<ChoixComposantGestion> ccg = new ArrayList<>();
        ccg.addAll(choixComposantListe);
        return ccg;
    }

    @Override
    public void supprimeSupplement(SupplementComposant supplementComposant) {
        choixComposantListe.remove(supplementComposant);
    }

    /**
     * Ajoute un Supplément Composant à la liste des supplements Composants disponibles pour l'utilisateur proposé par le manager de restaurant
     * @param supplementComposant le supplement Composant à ajouter
     */
    @Override
    public void ajoutSupplement(SupplementComposant supplementComposant){
        choixSupplement.ajoutSupplement(supplementComposant);
    }

    @Override
    public void ajoutChoixSupplement(ChoixSupplement<SupplementComposant> choix) {
        choixSupplement = choix;
    }

    /**
     * Ajoute un Supplément Composant à la liste des Suppléments Composants disponibles pour l'utilisateur proposé par le manager
     * @param supplementComposant le supplément composant selectionné par l'utilisateur
     */
    @Override
    public void ajoutChoixSupplementSelectionne(SupplementComposant supplementComposant){
        choixSupplement.selectionnerSupplement(supplementComposant);
    }

    @Override
    public void supprimeSupplementSelectionne(SupplementComposant supplementComposant) {
        choixSupplement.supprimeSupplementSelectionne(supplementComposant);
    }


    /**
     * Cherche le choix composant dans la liste des composants disponibles pour l'utilisateur proposés par le manager de restaurant
     * @param nomChoixComposant qu'on l'on veut
     * @return le choix composant trouvé à partir du string entré en paramètres
     */
    @Override
    public ChoixComposant getChoixParNom(String nomChoixComposant){
        return choixComposantListe.stream().filter(choixComposant1 -> choixComposant1.estChoixParNom(nomChoixComposant)).findFirst().orElse(null);
    }

    /**
     * Cherche le supplément composant dans la liste des supléments composants disponibles pour l'utilisateur proposés par le manager de restaurant
     * @param nomSupplement que l'on veut
     * @return le supplément composant trouvé avec le string entré en paramètres
     */
    @Override
    public SupplementComposant getSupplementParNom(String nomSupplement){
        return this.choixSupplement.getSupplementsListe().stream().filter(choixSupplement -> choixSupplement.estParNom(nomSupplement)).findFirst().orElse(null);
    }


    /**
     * Cherche le supplément composant sélectionné dans la liste des suppléments composants sélectionné disponibles par l'utilisateur
     * @param nomSupplement que l'on veut
     * @return le supplément composant trouvé avec le string entré en paramètres
     */
    @Override
    public SupplementComposant getSupplementSelectionneParNom(String nomSupplement){
        return this.choixSupplement.getSupplementsListe().stream().filter(choixSupplement -> choixSupplement.estParNom(nomSupplement)).findFirst().orElse(null);
    }

    @Override
    public void reset(){
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
    public double getPrix(){
        double totSup = 0;
        for (SupplementComposant supplementComposant : choixSupplement.getSupplementsSelectionnes()){
            totSup += supplementComposant.getPrix();
        }

        return totSup;
    }

    @Override
    public double getPrixSansReduction() {
        return getPrix();
    }

    @Override
    public double getPrixBase() {
        return getPrix();
    }
}
