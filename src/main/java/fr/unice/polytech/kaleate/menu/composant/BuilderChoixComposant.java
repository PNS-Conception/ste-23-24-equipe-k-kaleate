package fr.unice.polytech.kaleate.menu.composant;

import fr.unice.polytech.kaleate.builder.BuilderChoix;

import java.util.List;

public class BuilderChoixComposant implements BuilderChoix<Composant, ChoixComposant> {

    private ChoixComposant choixComposant;

    public BuilderChoixComposant() {
        reset();
    }
    @Override
    public void reset() {
        choixComposant = new ChoixComposant();
    }

    public ChoixComposant newChoix(String nomChoix, int nbChoix, List<Composant> listeChoix) {
        reset();
        nomChoix(nomChoix);
        nbChoix(nbChoix);
        listeChoix(listeChoix);
        return getResult();
    }

    @Override
    public void nomChoix(String nomChoix) {
        choixComposant.setNom(nomChoix);
    }

    @Override
    public void nbChoix(int nbChoix) {
        choixComposant.setNbChoix(nbChoix);
    }

    @Override
    public void listeChoix(List<Composant> listeChoix) {
        choixComposant.setListe(listeChoix);
    }

    @Override
    public void addChoix(Composant choix) {
            addChoix(choix);
    }

    @Override
    public List<Composant> getChoix() {
        return choixComposant.getListe();
    }

    @Override
    public ChoixComposant getResult() {
        return choixComposant;
    }
}
