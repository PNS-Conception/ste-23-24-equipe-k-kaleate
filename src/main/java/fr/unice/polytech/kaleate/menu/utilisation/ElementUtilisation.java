package fr.unice.polytech.kaleate.menu.utilisation;

import fr.unice.polytech.kaleate.menu.composant.SupplementComposant;
import fr.unice.polytech.kaleate.menu.element.ElementInterface;

import java.util.List;

/**
 */
public interface ElementUtilisation extends ElementInterface {
    public String getNom();

    public boolean estParNom(String nom);

    public List<ChoixComposantUtilisation> getChoixComposantListeUtilisation();

    public List<SupplementComposant> getChoixSupplement();

    public List<SupplementComposant> getChoixSupplementSelectionne();
    public void ajoutChoixSupplementSelectionne(SupplementComposant supplementComposant);

    public void supprimeSupplementSelectionne(SupplementComposant choix);
    public SupplementComposant getSupplementSelectionneParNom(String nomSupplement);
    public SupplementComposant getSupplementParNom(String nomSupplement);
    public ChoixComposantUtilisation getChoixParNom(String nomChoixComposant);
}
