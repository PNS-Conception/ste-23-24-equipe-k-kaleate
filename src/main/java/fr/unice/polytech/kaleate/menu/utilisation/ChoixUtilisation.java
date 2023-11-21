package fr.unice.polytech.kaleate.menu.utilisation;

import java.util.List;

public interface ChoixUtilisation<T> {
    public String getNom();
    public int getNbChoix();


    public List<T> getListeUtilisation();

    public List<T> getListeSelectionneUtilisation();
    public boolean estChoixParNom(String nom);

    public T getParNom(String nom);

    public T getSelectionneParNom(String s);

    public void choisir(T t);
}
