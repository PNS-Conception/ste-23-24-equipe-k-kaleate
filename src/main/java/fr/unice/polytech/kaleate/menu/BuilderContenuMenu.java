package fr.unice.polytech.kaleate.menu;

import fr.unice.polytech.kaleate.builder.Builder;
import fr.unice.polytech.kaleate.menu.composant.BuilderChoixComposant;
import fr.unice.polytech.kaleate.menu.element.BuilderChoixElement;
import fr.unice.polytech.kaleate.menu.element.BuilderElement;
import fr.unice.polytech.kaleate.menu.element.ChoixElement;
import fr.unice.polytech.kaleate.menu.supplement.ChoixSupplementElement;
import fr.unice.polytech.kaleate.menu.supplement.BuilderChoixSupplementComposant;
import fr.unice.polytech.kaleate.menu.supplement.BuilderChoixSupplementElement;

import java.util.ArrayList;

public class BuilderContenuMenu implements Builder<ContenuMenu> {

        private ContenuMenu contenuMenu;

        private BuilderElement builderElement;
        private BuilderChoixComposant builderChoixComposant;

        private BuilderChoixSupplementComposant builderChoixSupplementComposant;
        private BuilderChoixSupplementElement builderChoixSupplementElement;
        private BuilderChoixElement builderChoixElement;

        public BuilderContenuMenu()
        {
            reset();
            builderChoixElement = new BuilderChoixElement();
        }

        @Override
        public void reset() {
            this.contenuMenu = new ContenuMenu();
        }

        public void setNomMenu(ArrayList<ChoixElement> choixElement) {
            this.contenuMenu.setChoixElementListe(choixElement);
        }

        public BuilderChoixElement getBuilderChoixElement() {
            return this.builderChoixElement;
        }

        public void setBuilderChoixElement(BuilderChoixElement builderChoixElement) {
            this.builderChoixElement = builderChoixElement;
        }

        public void addChoixElement(ChoixElement choixElement) {
            contenuMenu.ajouterChoixElement(choixElement);

            //this.contenuMenu.ajouterChoixElement(builderChoixElement.getResult());
            //builderChoixElement.reset();
        }

        public void setChoixSupplementElement(ChoixSupplementElement choixSupplementElement) {
            contenuMenu.setChoixSupplementElement(choixSupplementElement);

        }

        @Override
        public ContenuMenu getResult() {
            return contenuMenu;
        }
}
