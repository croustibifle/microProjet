/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import java.util.ArrayList;

/**
 *
 * @author theking
 */
public class Jeu implements API{
    private CaseStatut[][] plateau;
    private int derniereAct;
 
    public Jeu()
    {
        plateau = new CaseStatut[8][8];
        derniereAct = 0;
    }
    
    @Override
    public void init()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j<8;j++)
            {
                this.plateau[j][i] = CaseStatut.vide;
            }
        }
        this.plateau[4][4] = CaseStatut.noire;
        this.plateau[5][5] = CaseStatut.noire;
        this.plateau[4][5] = CaseStatut.blanche;
        this.plateau[5][4] = CaseStatut.blanche;
        derniereAct = 0;
    }
    
    @Override
    public boolean action(int a, int b)
    {
        return true;
    }
    
    @Override
    public int vainqueur()
    {
        return 0;
    }
    
    @Override
    public String statut()
    {
        return "Joueur 1";
    }
    
    @Override
    public int derniereAction()
    {
        return derniereAct;
    }
    
    @Override
    public String affichage()
    {
        return "information";
    }
    
}
