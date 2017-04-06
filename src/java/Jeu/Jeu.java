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
    private CaseStatut[][] plateau = new CaseStatut[8][8];
 
    @Override
    public void init()
    {
        
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
        return 0;
    }
    
    @Override
    public String affichage()
    {
        return "information";
    }
    
}
