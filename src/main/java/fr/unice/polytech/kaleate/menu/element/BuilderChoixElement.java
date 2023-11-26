package fr.unice.polytech.kaleate.menu.element;

import java.util.List;

import fr.unice.polytech.kaleate.builder.BuilderChoix;

public class BuilderChoixElement implements BuilderChoix<Element, ChoixElement> {

    ChoixElement choixElement;

    public BuilderChoixElement() {
        reset();
    }

    @Override
    public ChoixElement newChoix(String nomChoix, int nbChoix, List<Element> listeChoix) {
        reset();
        choixElement.setNom(nomChoix);
        choixElement.setNbChoix(nbChoix);
        choixElement.setListe(listeChoix);
        return getResult();
    }

    @Override
    public void nomChoix(String nomChoix) {
        choixElement.setNom(nomChoix);
    }

    @Override
    public void nbChoix(int nbChoix) {
        choixElement.setNbChoix(nbChoix);
    }

    @Override
    public void listeChoix(List<Element> listeChoix) {
        choixElement.setListe(listeChoix);
    }

    @Override
    public void addChoix(Element choix) {
        addChoix(choix);
    }

    @Override
    public List<Element> getChoix() {
        return choixElement.getListe();
    }

    @Override
    public ChoixElement getResult() {
        return choixElement;
    }

    @Override
    public void reset() {
        choixElement = new ChoixElement();
    }
}
