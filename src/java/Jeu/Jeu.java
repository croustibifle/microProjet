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
                            testDirection(colonne,ligne,i,j,CaseStatut.noire);
                            
                        }
                        else if(a == 2 && this.plateau[colonne + i][ligne + j] == CaseStatut.blanche)
                        {
                            testDirection(colonne,ligne,i,j,CaseStatut.blanche);
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
        int compt1 = 0;
        int compt2 = 0;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j<8;j++)
            {
                if(this.plateau[j][i] == CaseStatut.blanche) compt1++;
                else if(this.plateau[j][i] == CaseStatut.noire) compt2++;
            }
        }
        
        if(compt1 > compt2) return 1;
        else if(compt2 > compt1) return 2;
        else return 0;     
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
        String information = "";
        for(int i = 0; i<8; i++)
        {
            for(int j=0; j<8;j++)
            {
                information = information + "[";
                if(this.plateau[i][j] == CaseStatut.blanche)
                {
                    information = information + "O";
                }
                else if(this.plateau[i][j] == CaseStatut.noire)
                {
                    information = information + "X";
                }
                else
                {
                    information = information + " ";
                }
                information = information + "]";
            }
            information += "\n";
        }
        return "information";
    }
    
    public boolean testDirection(int colonne,int ligne,int i,int j,CaseStatut couleur)
    {
        int ligne2 = ligne + j;
        int colonne2 = colonne + i;
        while(ligne2 >= 0 && ligne2 < 8 && colonne2 >= 0 && colonne2 < 8 && this.plateau[colonne2][ligne2] == couleur)
        {
            ligne2+=j;
            colonne2+=i;
        }
        if(ligne2 < 0 && ligne2 > 7 && colonne2 < 0 && colonne2 > 7) return false;
        if(this.plateau[colonne2][ligne2] == inverse(couleur))
        {
            while(ligne2 != ligne && colonne2 != colonne)
            {
                ligne2 -= j;
                colonne2 -=i;
                this.plateau[colonne2][ligne2] = inverse(couleur);
            }
        }
        return true;
        
    }
    
    public CaseStatut inverse(CaseStatut couleur)
    {
        if(couleur == CaseStatut.blanche) return CaseStatut.noire;
        else if(couleur == CaseStatut.noire) return CaseStatut.blanche;
        return CaseStatut.vide;
    }
    
    public boolean finDePartie() 
    {
        boolean check = true;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j<8;j++)
            {
                String indexCase = "" + j + i; 
                if (action(1,Integer.parseInt(indexCase))) check = true;
                if (action(2,Integer.parseInt(indexCase))) check = true;
            }
        }
        return check;
    }
    
}
