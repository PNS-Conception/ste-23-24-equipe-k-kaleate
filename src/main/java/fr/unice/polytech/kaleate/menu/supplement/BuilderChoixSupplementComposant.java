package fr.unice.polytech.kaleate.menu.supplement;

import fr.unice.polytech.kaleate.menu.composant.ChoixSupplementComposant;
import fr.unice.polytech.kaleate.menu.composant.SupplementComposant;

public class BuilderChoixSupplementComposant extends BuilderChoixSupplement<SupplementComposant> {

        @Override
        public void reset() {
            this.choixSupplementGestion = new ChoixSupplementComposant();
        }

        @Override
        public ChoixSupplementComposant getResult() {
            return (ChoixSupplementComposant) this.choixSupplementGestion;
        }
}
