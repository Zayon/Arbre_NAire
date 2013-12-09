/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minesales.infres5.a2.p2.arbre_NAire;

/**
 *
 * @author zayon
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArbreNAire<Integer> arbre = BuildArbre(2, 3);
       String str = "";
    }

    public static ArbreNAire<Integer> BuildArbre(int profondeur, int largeur) {
        ArbreNAire<Integer> arbre = new ArbreNAire<>(1);
        BuildArbre(arbre, profondeur, largeur);
        return arbre;
    }
    
    private static void BuildArbre(ArbreNAire<Integer> arbre, int profondeur, int largeur){
        if (profondeur > 0){
            for (int j = 0; j < largeur; j++) {
                arbre.addFils(arbre.getItem() * 10 + j);
                arbre.goToFils(j);
                BuildArbre(arbre, profondeur-1, largeur);
                arbre.goToPere();
            }
        } else {
            //On s'arrête ici!
        }
        
    }

}
