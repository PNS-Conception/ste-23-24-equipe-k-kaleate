package fr.unice.polytech.kaleate.builder;

import fr.unice.polytech.kaleate.menu.ContenuMenu;
import fr.unice.polytech.kaleate.menu.element.BuilderChoixElement;
import fr.unice.polytech.kaleate.menu.supplement.BuilderChoixSupplementElement;

public class BuilderContenuMenu {
    ContenuMenu contenuMenu;

    BuilderChoixElement builderChoixElement = new BuilderChoixElement();

    BuilderChoixSupplementElement builderChoixSupplementElement = new BuilderChoixSupplementElement();

    public BuilderContenuMenu() {
        this.reset();
    }

    public ContenuMenu getResult() {
        return this.contenuMenu;
    }

    public void setBuilderChoixElement(BuilderChoixElement builderChoixElement) {
        this.builderChoixElement = builderChoixElement;
    }

    public void setBuilderChoixSupplementElement(BuilderChoixSupplementElement builderChoixSupplementElement) {
        this.builderChoixSupplementElement = builderChoixSupplementElement;
    }

    public void addChoixElement() {
        this.contenuMenu.ajouterChoixElement(this.builderChoixElement.getResult());
    }

    public void addChoixSupplementElement() {
        this.contenuMenu.setSupplementElementListe(this.builderChoixSupplementElement.getResult());
    }

    public BuilderChoixElement getBuilderChoixElement() {
        return this.builderChoixElement;
    }

    public BuilderChoixSupplementElement getBuilderChoixSupplementElement() {
        return this.builderChoixSupplementElement;
    }

    public void reset() {
        this.builderChoixElement.reset();
        this.builderChoixSupplementElement.reset();
        this.contenuMenu = new ContenuMenu();
    }
}
