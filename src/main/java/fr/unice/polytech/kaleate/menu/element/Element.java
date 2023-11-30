package fr.unice.polytech.kaleate.menu.element;

import fr.unice.polytech.kaleate.menu.composant.ChoixComposant;
import fr.unice.polytech.kaleate.menu.supplement.ChoixSupplementComposant;
import fr.unice.polytech.kaleate.menu.composant.SupplementComposant;
import fr.unice.polytech.kaleate.menu.supplement.ChoixSupplement;
import fr.unice.polytech.kaleate.outils.Monnayable;

import java.util.ArrayList;
import java.util.List;

public class Element implements Monnayable {
    private String nomElement;
    private List<ChoixComposant> choixComposantListe;
    private ChoixSupplementComposant choixSupplementComposant;

    public Element() {
        this.nomElement = "";
        this.choixComposantListe = new ArrayList<>();
        this.choixSupplementComposant = new ChoixSupplementComposant();
    }

    public Element(String nomElement) {
        this.nomElement = nomElement;
        this.choixComposantListe = new ArrayList<>();
        this.choixSupplementComposant = new ChoixSupplementComposant();
    }

    public String getNom() {
        return nomElement;
    }

    public void setNom(String nomElement) {
        this.nomElement = nomElement;
    }

    /**
     * @return la liste des choix composants disponibles pour l'utilisateur proposé par le manager de restaurant
     */
    public List<SupplementComposant> getChoixSupplementComposant() {
        return choixSupplementComposant.getSupplementsListe();
    }

    /**
     * @return la liste des choix composants sélectionnés par l'utilisateur
     */
    public List<SupplementComposant> getChoixSupplementSelectionne() {
        return choixSupplementComposant.getSupplementsSelectionnes();
    }

    public ChoixSupplementComposant getChoixSupplementComposantDispo() {
        return choixSupplementComposant;
    }

    public boolean estParNom(String nomElement){
        return this.nomElement.equals(nomElement);
    }

    public List<ChoixComposant> getChoixComposantListeUtilisation() {
        return choixComposantListe;
    }

    public void supprimeSupplement(SupplementComposant supplementComposant) {
        choixSupplementComposant.supprimeSupplement(supplementComposant);
    }

    /**
     * Ajoute un Supplément Composant à la liste des supplements Composants disponibles pour l'utilisateur proposé par le manager de restaurant
     * @param supplementComposant le supplement Composant à ajouter
     */
    public void ajoutSupplement(SupplementComposant supplementComposant){
        choixSupplementComposant.ajoutSupplement(supplementComposant);
    }
    public void ajoutChoixSupplement(ChoixSupplementComposant choix) {
        choixSupplementComposant = choix;
    }

    /**
     * Ajoute un Supplément Composant à la liste des Suppléments Composants disponibles pour l'utilisateur proposé par le manager
     * @param supplementComposant le supplément composant selectionné par l'utilisateur
     */
    public void ajoutChoixSupplementSelectionne(SupplementComposant supplementComposant){
        choixSupplementComposant.selectionnerSupplement(supplementComposant);
    }

    public void supprimeSupplementSelectionne(SupplementComposant supplementComposant) {
        choixSupplementComposant.supprimeSupplementSelectionne(supplementComposant);
    }

    /**
     * Cherche le choix composant dans la liste des composants disponibles pour l'utilisateur proposés par le manager de restaurant
     * @param nomChoixComposant qu'on l'on veut
     * @return le choix composant trouvé à partir du string entré en paramètres
     */
    public ChoixComposant getChoixParNom(String nomChoixComposant){
        return choixComposantListe.stream().filter(cs -> cs.estChoixParNom(nomChoixComposant)).findFirst().orElse(null);
    }

    /**
     * Cherche le supplément composant dans la liste des supléments composants disponibles pour l'utilisateur proposés par le manager de restaurant
     * @param nomSupplement que l'on veut
     * @return le supplément composant trouvé avec le string entré en paramètres
     */
    public SupplementComposant getSupplementParNom(String nomSupplement){
        return this.choixSupplementComposant.getSupplementsListe().stream().filter(cs -> cs.estParNom(nomSupplement)).findFirst().orElse(null);
    }


    /**
     * Cherche le supplément composant sélectionné dans la liste des suppléments composants sélectionné disponibles par l'utilisateur
     * @param nomSupplement que l'on veut
     * @return le supplément composant trouvé avec le string entré en paramètres
     */
    public SupplementComposant getSupplementSelectionneParNom(String nomSupplement){
        return this.choixSupplementComposant.getSupplementsListe().stream().filter(cs -> cs.estParNom(nomSupplement)).findFirst().orElse(null);
    }

    public void reset(){
        this.choixSupplementComposant.reset();
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
        for (SupplementComposant supplementComposant : choixSupplementComposant.getSupplementsSelectionnes()){
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

    public void ajoutChoixComposant(ChoixComposant cc) {
        choixComposantListe.add(cc);
    }

    public void verifChoixComposant() {
        for (ChoixComposant cc : choixComposantListe) {
            cc.verifComposant();
        }
    }

    public void supprimerChoixComposantParNom(String nomChoixComposant) {
        choixComposantListe.removeIf(cc -> cc.estChoixParNom(nomChoixComposant));
    }
}
