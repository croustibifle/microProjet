package Jeu;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by moi on 06/04/2017.
 */
class JeuTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Jeu jeu = new Jeu();
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                jeu.setPlateau(i, j, CaseStatut.vide);
            }
        }
        jeu.setPlateau(1,3,CaseStatut.blanche);
        jeu.setPlateau(1,4,CaseStatut.noire);
        jeu.setPlateau(5,4,CaseStatut.blanche);
        jeu.setPlateau(5,5,CaseStatut.blanche);
        jeu.setPlateau(5,6,CaseStatut.noire);
        jeu.setPlateau(3,4,CaseStatut.noire);

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