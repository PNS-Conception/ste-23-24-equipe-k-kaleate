package fr.unice.polytech.kaleate.menu;

import fr.unice.polytech.kaleate.builder.Builder;

public class BuilderContenuMenu implements Builder<ContenuMenu> {

        ContenuMenu contenuMenu;

        public BuilderContenuMenu()
        {
            reset();
        }

        @Override
        public void reset() {
            this.contenuMenu = new ContenuMenu();
        }

        public void setContenuMenu(ContenuMenu contenuMenu) {
            this.contenuMenu = contenuMenu;
        }



        @Override
        public ContenuMenu getResult() {
            return contenuMenu;
        }
}
