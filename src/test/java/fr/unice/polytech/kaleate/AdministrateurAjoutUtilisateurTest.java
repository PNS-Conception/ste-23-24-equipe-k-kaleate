package fr.unice.polytech.kaleate;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "fr.unice.polytech.kaleate")

public class AdministrateurAjoutUtilisateurTest {

    static AdministrateurCampus admin;
    static ListeUtilisateur listeUtilisateur;

    @Soit("je suis un administrateur campus {string}")
    public void je_suis_un_administrateur_campus(String string) {
        admin = new AdministrateurCampus(string);
        assertNotNull(admin);
    }

    @Etantdonnéque("le nombre d'utlisateur du campus est de {int}")
    public void le_nombre_d_utlisateur_du_campus_est_de(int int1) {
        assertEquals(admin.listeUtilisateur().size(), int1);
    }

    @Quand("j'ajoute l'utilisateur {string} {string}")
    public void j_ajoute_l_utilisateur(String arg0, String arg1) {
        admin.ajouterUtilisateur(arg0, arg1);
    }

    @Alors("le nombre d'utilisateurs augmente de {int}")
    public void le_nombre_d_utilisateurs_augmente_de(int int1) {
        assertEquals(admin.listeUtilisateur().size(), int1);
    }

    @Etantdonnéque("le nombre d'utisateur du campus est de {int}")
    public void le_nombre_d_utisateur_du_campus_est_de(int int1) {
        admin.ajouterUtilisateur("Bob", "Falbert");
        assertEquals(admin.listeUtilisateur().size(), int1);
    }

    @Quand("je supprime l'utilisateur {string} {string}")
    public void je_supprime_l_utilisateur(String string, String string2) {
        admin.supprimerUtilisateur(string);
    }

    @Alors("le nombre d'utilisateurs diminue et est égal à {int}")
    public void le_nombre_d_utilisateurs_diminue_et_est_egal_a(int int1) {
        assertEquals(admin.listeUtilisateur().size(), int1);
    }

}
