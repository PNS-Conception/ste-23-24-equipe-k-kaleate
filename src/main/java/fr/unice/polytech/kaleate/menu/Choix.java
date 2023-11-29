package fr.unice.polytech.kaleate.menu;

import java.util.List;

public interface Choix<T> {
    public void setNom(String nom);

    public void setNbChoixPossiblePourUtilisateur(int n);

    public void setListe(List<T> liste);

    public void ajout(T t);

    public void supprimer(T t);

    public String getNom();

    public int getNbChoixPossiblePourUtilisateur();

    public List<T> getListe();

    public List<T> getListeSelectionne();

    public boolean estChoixParNom(String nom);

    public T getParNom(String nom);

    public T getSelectionneParNom(String s);

    public void choisir(T t);

    public void reset();
}
