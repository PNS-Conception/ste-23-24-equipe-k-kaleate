package fr.unice.polytech.kaleate.menu.gestion;

import fr.unice.polytech.kaleate.menu.supplement.ChoixSupplement;

import java.util.List;


/**
 *
 * @param <CT> Classe choix de l'élément
 * @param <ST> Classe en supplément de l'élément
 */
public interface ElementGestion<CT, ST> {
    public String getNom();

    public void setNom(String nom);

    public boolean estParNom(String nom);

    public List<CT> getChoixComposantListe();

    public List<ST> getChoixSupplement();

    public List<ST> getChoixSupplementSelectionne();

    public void ajout(CT choix);
    public void supprimeSupplement(ST supplement);

    public void ajoutSupplement(ST supplement);

    public void ajoutChoixSupplement(ChoixSupplement<ST> choix);
    public CT getChoixParNom(String nomChoix);
}
