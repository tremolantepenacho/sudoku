/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;

/**
 *
 * @author hector
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SudokuInstance ejemplo=new SudokuInstance("facil.sdk");
       
        ejemplo.imprimeSudoku();
        int total;
        do {
            total=ejemplo.realizaPasada();
            System.out.println(total);
            ejemplo.imprimeSudoku();
            
        }while (total!=0);
        
    /* ArrayList<Integer> nums=ejemplo.obtenNumerosRestantesFila(0);
    
     for(int num:nums){
         System.out.print(num+":");
      */   ArrayList<Integer>posis=ejemplo.obtenPosicionesPosiblesNumeroEnFila(1, 0);
         for (int pos:posis){
             System.out.print(pos+";");
         }
        /* System.out.println();
     }*/
        
     for (int i=0;i<9;i++){
         ejemplo.completaFila(i);
     }
     
        System.out.println("******************************");
      ejemplo.imprimeSudoku();
    }
    
}
