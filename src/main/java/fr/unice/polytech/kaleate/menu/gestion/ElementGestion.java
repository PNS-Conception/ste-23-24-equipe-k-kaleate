package fr.unice.polytech.kaleate.menu.gestion;

import fr.unice.polytech.kaleate.menu.composant.SupplementComposant;
import fr.unice.polytech.kaleate.menu.element.ElementInterface;
import fr.unice.polytech.kaleate.menu.supplement.ChoixSupplement;

import java.util.List;


/**
 *
 */
public interface ElementGestion extends ElementInterface {
    public String getNom();

    public void setNom(String nom);

    public boolean estParNom(String nom);

    public List<ChoixComposantGestion> getChoixComposantListeGestion();

    public List<SupplementComposant> getChoixSupplement();

    public List<SupplementComposant> getChoixSupplementSelectionne();

    public void ajout(ChoixComposantGestion choix);
    public void supprimeSupplement(SupplementComposant supplement);

    public void ajoutSupplement(SupplementComposant supplement);

    public void ajoutChoixSupplement(ChoixSupplement<SupplementComposant> choix);
    public ChoixComposantGestion getChoixParNom(String nomChoix);
}
