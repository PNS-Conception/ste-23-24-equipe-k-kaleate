package fr.unice.polytech.kaleate.menu.element;

import fr.unice.polytech.kaleate.builder.Builder;
import fr.unice.polytech.kaleate.menu.composant.BuilderChoixComposant;
import fr.unice.polytech.kaleate.menu.composant.Composant;
import fr.unice.polytech.kaleate.menu.supplement.BuilderChoixSupplement;
import fr.unice.polytech.kaleate.menu.composant.ChoixSupplementComposant;
import fr.unice.polytech.kaleate.menu.supplement.BuilderChoixSupplementComposant;

public class BuilderElement implements Builder<Element> {

    Element element;

    BuilderChoixComposant builderChoixComposant = new BuilderChoixComposant();
    BuilderChoixSupplementComposant builderChoixSupplement = new BuilderChoixSupplementComposant();
    @Override
    public void reset() {
        element = new Element();
    }

    public void setNomElement(String nomElement) {
        element.setNomElement(nomElement);
    }

    public BuilderChoixComposant getBuilderChoixComposant() {
        return this.builderChoixComposant;
    }

    public BuilderChoixSupplement getBuilderChoixSupplement() {
        return this.builderChoixSupplement;
    }

    public void addChoixComposant() {
        element.ajoutComposant(builderChoixComposant.getResult());
        builderChoixComposant.reset();
    }

    public void addChoixSupplement() {
        element.ajoutChoixSupplementComposant(builderChoixSupplement.getResult());
        builderChoixSupplement.reset();
    }

    @Override
    public Element getResult() {
        return element;
    }
}
