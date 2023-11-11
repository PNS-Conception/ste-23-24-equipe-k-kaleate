package fr.unice.polytech.kaleate;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChoixElement {
    private String nomElement;
    private int nbChoixElement;
    private ArrayList<Element> elementListe;
    private ArrayList<Integer> listeChoixElement;

    public ChoixElement(String nomElement, int nbChoixElement){
        this.nomElement = nomElement;
        this.nbChoixElement = nbChoixElement;
        this.elementListe = new ArrayList<>();
        this.listeChoixElement = new ArrayList<>(nbChoixElement);
    }

    public String getNomElement() {
        return nomElement;
    }

    public int getNbChoixElement() {
        return nbChoixElement;
    }

    public ArrayList<Element> getElementListe() {
        return elementListe;
    }

    public ArrayList<Integer> getListeChoixElement() {
        return listeChoixElement;
    }

    void ajoutChoixElement(int i){
        if (listeChoixElement.size() < nbChoixElement){
            listeChoixElement.add(i);
        }
        //Ajouter un else?
    }

    void ajoutElement(Element e){
        elementListe.add(e);
    }

    public Element getParNom(String s){
        return elementListe.stream().filter(element -> element.estElementParNom(s)).findFirst().orElse(null);
    }

    void choisirElement(Element element){
        int rang = 0;
        for (int i = 0; i < elementListe.size(); i++){
            if (Objects.equals(elementListe.get(i).getNomElement(), element.getNomElement())){
                rang = i;
                break;
            }
        }
        listeChoixElement.add(rang);
    }
}
