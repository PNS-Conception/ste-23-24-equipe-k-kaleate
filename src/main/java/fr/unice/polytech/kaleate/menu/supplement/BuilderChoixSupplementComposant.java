package fr.unice.polytech.kaleate.menu.supplement;

import fr.unice.polytech.kaleate.menu.composant.ChoixSupplementComposant;
import fr.unice.polytech.kaleate.menu.composant.Composant;
import fr.unice.polytech.kaleate.menu.composant.SupplementComposant;

public class BuilderChoixSupplementComposant extends BuilderChoixSupplement<SupplementComposant> {

        @Override
        public void reset() {
            this.choixSupplement = new ChoixSupplementComposant();
        }

        @Override
        public ChoixSupplement<SupplementComposant> getResult() {
            return (ChoixSupplement<SupplementComposant>) this.choixSupplement;
        }
}
