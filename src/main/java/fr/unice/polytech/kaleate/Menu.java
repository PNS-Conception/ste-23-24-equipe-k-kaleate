package fr.unice.polytech.kaleate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Menu {
    private float price;
    private String name;
    private Creneau creneau;
    private ArrayList<ChoixElement> choixElementListe;
    private ArrayList<SupplementElement> supplementElementListe;
    private ArrayList<SupplementElement> supplementElementListeSelectionne;

    private int tempsPreparation; // en minutes
    public Menu(float price, String name, Creneau creneau){
        this.price = price;
        this.name = name;
        this.creneau = creneau;
        choixElementListe = new ArrayList<>();
        supplementElementListe = new ArrayList<>();
        supplementElementListeSelectionne = new ArrayList<>();
    }
    public Menu(float price, String name, Creneau creneau,int tempsPreparation){
        this.price = price;
        this.name = name;
        this.creneau = creneau;
        this.tempsPreparation = tempsPreparation;
        choixElementListe = new ArrayList<>();
        supplementElementListe = new ArrayList<>();
        supplementElementListeSelectionne = new ArrayList<>();
    }


    public float getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public Creneau getCreneau(){
        return this.creneau;
    }

    public ArrayList<ChoixElement> getChoixElementListe() {return this.choixElementListe;}

    public ArrayList<SupplementElement> getSupplementElementListe() {
        return this.supplementElementListe;
    }

    public ArrayList<SupplementElement> getSupplementElementListeSelectionne() {
        return supplementElementListeSelectionne;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCreneau(Creneau creneau){
        this.creneau = creneau;
    }

    public boolean estMenuParNom(String name){
        return this.name.equals(name);
    }

    public boolean estComprisDansCreneau(Creneau creneau){
        return this.creneau.estComprisDansCreneau(creneau);
    }
    public boolean chevaucheCreneau(Creneau creneau){
        return this.creneau.chevaucheCreneau(creneau);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Menu))
            return false;
        if (obj == this)
            return true;
        return this.getName().equals(((Menu) obj).getName()) && this.getPrice() == ((Menu) obj).getPrice() && this.getCreneau().equals(((Menu) obj).getCreneau());
    }

    public boolean isStackable(Menu menu){
        return this.getName().equals(menu.getName()) && this.getPrice() == menu.getPrice();
    }

    @Override
    public String toString() {
        return "Menu : " + this.getName() + " / " + this.getPrice() + "€" + " / " + this.getCreneau().getDebut() + " - " + this.getCreneau().getFin();
    }

    public int getTempsPreparation() {
        return tempsPreparation;
    }

    public void setTempsPreparation(int tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }

    public void ajouterElement(ChoixElement choixElement){
        choixElementListe.add(choixElement);
    }

    public void ajouterElementSupplement(SupplementElement supplementElement){
        supplementElementListe.add(supplementElement);
    }

    public void ajouterElementSupplementSelectionne(SupplementElement supplementElement) {
        supplementElementListeSelectionne.add(supplementElement);
    }

    public float getPrixAvecSupplements() {
        float total = 0;
        for (ChoixElement e : choixElementListe) {
            total += e.getPrixSupplement();
        }
        for(SupplementElement supplementElement : supplementElementListeSelectionne){
            total += supplementElement.getPrix();
            total += supplementElement.getPrixSupplements();
        }
        return total;
    }

    public ChoixElement getChoixElementParNom(String nomChoixElement){
        return this.getChoixElementListe().stream().filter(choixElement -> choixElement.estChoixElementParNom(nomChoixElement)).findFirst().orElse(null);
    }

    public SupplementElement getChoixSupplementElementParNom(String nomSupplement){
        return this.supplementElementListe.stream().filter(supplementElement -> supplementElement.estElementParNom(nomSupplement)).findFirst().orElse(null);
    }

    public SupplementElement getSupplementElementListeSelectioneParNom(String nomSup){
        return this.supplementElementListeSelectionne.stream().filter(supplementElement -> supplementElement.estElementParNom(nomSup)).findFirst().orElse(null);
    }
}
