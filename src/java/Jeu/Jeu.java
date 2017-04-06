/*
 * To change this license header, choose License Headers in Project Properties.bite
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;


/**
 *
 * @author theking
 */
public class Jeu implements API {
    private CaseStatut[][] plateau;
    private int dernierJoueur = 0;
    private int derniereAct;
 
//=================== Constructeur ========================
    public Jeu()
    {
        plateau = new CaseStatut[8][8];
        derniereAct = 0;
    }
    
//=================== Action ========================
    
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
    
//=================== Action ========================
    
    @Override
    public boolean action(int a, int b)
    {
        int ligne = (b % 10) - 1;
        int colonne = (b / 10) - 1;
        for(int i = -1; i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if (a == 1 && checkAvailability(colonne,ligne,CaseStatut.noire))
                {
                    if(colonne + i >= 0 && colonne + i < 8 && ligne + j >= 0 && ligne + j < 8 && this.plateau[colonne + i][ligne + j] == CaseStatut.blanche)
                    {
                        testDirection(colonne,ligne,i,j,CaseStatut.blanche);
                    }
                    dernierJoueur = 1;
                }else if (a == 2 && checkAvailability(colonne,ligne,CaseStatut.blanche))
                {
                    if(colonne + i >= 0 && colonne + i < 8 && ligne + j >= 0 && ligne + j < 8 && this.plateau[colonne + i][ligne + j] == CaseStatut.noire)
                    {
                        testDirection(colonne,ligne,i,j,CaseStatut.noire);
                    }
                    dernierJoueur = 2;
                }
            }

        }
        joueurCourant();
        return checkAvailability(colonne,ligne,CaseStatut.noire);
        
    }
    
    //=================== Vainqueur ========================
    
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
    
    //=================== statut ========================
    
    @Override
    public String statut()
    {
        if (dernierJoueur == 1)
            return "Joueur 2";
        else
            return "Joueur 1";
    }
    
    //=================== derniere action ========================
    
    @Override
    public int derniereAction()
    {
        return derniereAct;
    }
    
    ////=================== Affichage ========================
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
    
    //=================== test de la direction ========================
    
    
    public void testDirection(int colonne,int ligne,int i,int j,CaseStatut couleur)
    {
        int ligne2 = ligne + j;
        int colonne2 = colonne + i;
        while(ligne2 >= 0 && ligne2 < 8 && colonne2 >= 0 && colonne2 < 8 && this.plateau[colonne2][ligne2] == couleur)
        {
            ligne2+=j;
            colonne2+=i;
        }
        if(ligne2 >= 0 && ligne2 < 8 && colonne2 >= 0 && colonne2 < 8 && this.plateau[colonne2][ligne2] == inverse(couleur))
        {
            while(ligne2 != ligne && colonne2 != colonne)
            {
                ligne2 -= j;
                colonne2 -=i;
                this.plateau[colonne2][ligne2] = inverse(couleur);
                derniereAct = Integer.parseInt("" + j + i);
            }
        }
        
    }
    
    //=================== verifie si un joueur peut jouer ========================
    
    public boolean checkAvailability(int colonne,int ligne,CaseStatut couleur)
    {
        boolean isPossible = false;
        if(ligne < 1 || ligne >= 8 || colonne < 1 || colonne > 8 || this.plateau[colonne][ligne] != CaseStatut.vide)
        {
            return false;
        }

        for(int i = -1; i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if(colonne + i >= 0 && colonne + i < 8 && ligne + j >= 0 && ligne + j < 8)
                {
                    {
                        if(this.plateau[colonne + i][ligne + j] == inverse(couleur))
                        {
                            int ligne2 = ligne + j;
                            int colonne2 = colonne + i;
                            while(ligne2 >= 0 && ligne2 < 8 && colonne2 >= 0 && colonne2 < 8 && this.plateau[colonne2][ligne2] == inverse(couleur))
                            {
                                ligne2+=j;
                                colonne2+=i;
                            }
                            if(ligne2 < 0 && ligne2 > 7 && colonne2 < 0 && colonne2 > 7) return false;
                            isPossible = true;
                        }

                    }
                }
            }
        }

        return isPossible;
    }
    
    //=================== inverse la couleur ========================
    
    public CaseStatut inverse(CaseStatut couleur)
    {
        if(couleur == CaseStatut.blanche) return CaseStatut.noire;
        else if(couleur == CaseStatut.noire) return CaseStatut.blanche;
        return CaseStatut.vide;
    }

    //=================== verifie si c'est la fin de la partie ========================
    
    public boolean finDePartie() 
    {
        boolean check = true;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j<8;j++)
            {
                String indexCase = "" + j + i; 
                if (checkAvailability(j,i,CaseStatut.blanche)) check = false;
                if (checkAvailability(j,i,CaseStatut.noire)) check = false;
            }
        }
        return check;
    }
    
    // ================= attribue le joueur courant ====================
    
    public void joueurCourant()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j<8;j++)
            {
                if (!checkAvailability(j,i,CaseStatut.blanche)) dernierJoueur = 1;
                if (!checkAvailability(j,i,CaseStatut.noire)) dernierJoueur = 2;
            }
        }
    }
    
}
