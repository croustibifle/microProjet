package Jeu;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by moi on 06/04/2017.
 */
class JeuTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    //verifie que le joueur ne joue pas sur une case déjà prise
    @org.junit.jupiter.api.Test
    void testActionCasePrise() {
        Jeu jeu = new Jeu();
        jeu.init();
        int j1 = 1;
        int j2 = 2;
        int b = 44;
        assertFalse(jeu.action(j1,b));
        assertFalse(jeu.action(j2,b));
    }

    @org.junit.jupiter.api.Test
    void testInit() {
        Jeu jeu = new Jeu();
        jeu.init();

    }

}