package fr.unice.polytech.kaleate.menu.gestion;

import java.util.List;

public interface ChoixGestion<T> {
    public void setNom(String nom);
    public String getNom();

    public void setNbChoix(int n);
    public int getNbChoix();

    public void setListe(List<T> liste);
    public List<T> getListeGestion();

    public List<T> getListeSelectionneGestion();

    public void ajout(T t);

    public void supprimer(T t);

    public boolean estChoixParNom(String nom);

    public T getParNom(String nom);

    public T getSelectionneParNom(String s);
}
