/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

/**
 *
 * @author theking
 */
public interface API {

    
    public void init();
    
    public boolean action(int a, int b);
    
    public int vainqueur();
    
    public String statut();
    
    public int derniereAction();
    
    public String affichage();
    
}
