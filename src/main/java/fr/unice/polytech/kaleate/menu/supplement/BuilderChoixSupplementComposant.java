package fr.unice.polytech.kaleate.menu.supplement;

import fr.unice.polytech.kaleate.menu.composant.SupplementComposant;

public class BuilderChoixSupplementComposant extends BuilderChoixSupplement<SupplementComposant> {


        public BuilderChoixSupplementComposant() {
            this.choixSupplement = new ChoixSupplementComposant();
        }
        @Override
        public void reset() {
            this.choixSupplement = new ChoixSupplementComposant();
        }

        @Override
        public ChoixSupplement<SupplementComposant> getResult() {
            return (ChoixSupplement<SupplementComposant>) this.choixSupplement;
        }
}
