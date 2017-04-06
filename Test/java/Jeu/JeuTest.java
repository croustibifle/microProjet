package java.Jeu;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by moi on 06/04/2017.
 */
@RunWith(Arquillian.class)
public class JeuTest {
    @Before
    public void setUp() throws Exception {
        Jeu jeu = new Jeu();
        CaseStatut[][] plateau = new CaseStatut[8][8];
        jeu.init();
        jeu.init().plateau[4][4] = CaseStatut.noire;


    }


    @Test
    //test si le joueur peut joue sur la meme case.
    public void testActionCasePrise() throws Exception {
        Jeu jeu = new Jeu();
        jeu.init();
        int j1 = 1;
        int j2 = 2;
        int b = 44;
        assertFalse(jeu.action(j1,b));
        assertFalse(jeu.action(j2,b));
    }

    @Test
    public void testInitCasePrise() throws Exception {
        Jeu jeu = new Jeu();
        jeu.init();

    }




    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Jeu.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
