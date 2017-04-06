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
        int ligne = (b % 10) - 1;
        int colonne = (b / 10) - 1 ;
        if(ligne < 1 || ligne >= 8 || colonne < 1 || colonne > 8 || this.plateau[colonne][ligne] != CaseStatut.vide)
        {
            return false;
        }
        boolean isPossible = false;
        for(int i = -1; i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if(colonne + i >= 0 && colonne + i < 8 && ligne + j >= 0 && ligne + j < 8)
                {
                    {
                        if(a == 1 && this.plateau[colonne + i][ligne + j] == CaseStatut.noire)
                        {
                            int ligne2 = ligne + j;
                            int colonne2 = colonne + i;
                            while(ligne2 >= 0 && ligne2 < 8 && colonne2 >= 0 && colonne2 < 8 && this.plateau[colonne2][ligne2] == CaseStatut.noire)
                            {
                                ligne2+=j;
                                colonne2+=i;
                            }
                            if(ligne2 < 0 && ligne2 > 7 && colonne2 < 0 && colonne2 > 7) continue;
                            if(this.plateau[colonne2][ligne2] == CaseStatut.blanche)
                            {
                                while(ligne2 != ligne && colonne2 != colonne)
                                {
                                    ligne2 -= j;
                                    colonne2 -=i;
                                    this.plateau[colonne2][ligne2] = CaseStatut.blanche;
                                }
                                isPossible = true;
                            }
                            
                        }
                        else if(a == 2 && this.plateau[colonne + i][ligne + j] == CaseStatut.blanche)
                        {
                            int ligne2 = ligne + j;
                            int colonne2 = colonne + i;
                            while(ligne2 >= 0 && ligne2 < 8 && colonne2 >= 0 && colonne2 < 8 && this.plateau[colonne2][ligne2] == CaseStatut.blanche)
                            {
                                ligne2+=j;
                                colonne2+=i;
                            }
                            if(ligne2 < 0 && ligne2 > 7 && colonne2 < 0 && colonne2 > 7) continue;
                            if(this.plateau[colonne2][ligne2] == CaseStatut.noire)
                            {
                                while(ligne2 != ligne && colonne2 != colonne)
                                {
                                    ligne2 -= j;
                                    colonne2 -=i;
                                    this.plateau[colonne2][ligne2] = CaseStatut.noire;
                                }
                                isPossible = true;
                            }
                        }
                    }
                    }
            }
        }

        return isPossible;
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
