package fr.unice.polytech.kaleate.menu.supplement;


import fr.unice.polytech.kaleate.menu.element.SupplementElement;

public class BuilderChoixSupplementElement extends BuilderChoixSupplement<SupplementElement> {

        public BuilderChoixSupplementElement() {
            this.choixSupplement = new ChoixSupplementElement();
        }

        @Override
        public void reset() {
            this.choixSupplement = new ChoixSupplementElement();

        }

        @Override
        public ChoixSupplementElement getResult() {
            return (ChoixSupplementElement) this.choixSupplement;
        }
}
