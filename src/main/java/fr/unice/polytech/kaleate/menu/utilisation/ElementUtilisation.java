package fr.unice.polytech.kaleate.menu.utilisation;

import fr.unice.polytech.kaleate.menu.composant.ChoixComposant;
import fr.unice.polytech.kaleate.menu.composant.SupplementComposant;

import java.util.List;

/**
 *
 * @param <CT> Classe choix de l'élément
 * @param <ST> Classe en supplément de l'élément
 */
public interface ElementUtilisation<CT, ST> {
    public String getNom();

    public boolean estParNom(String nom);

    public List<CT> getChoixComposantListe();

    public List<ST> getChoixSupplement();

    public List<ST> getChoixSupplementSelectionne();
    public void ajoutChoixSupplementSelectionne(ST supplementComposant);

    public void supprimeSupplementSelectionne(ST choix);
    public ST getSupplementSelectionneParNom(String nomSupplement);
    public ST getSupplementParNom(String nomSupplement);
    public CT getChoixComposantParNom(String nomChoixComposant);
}
