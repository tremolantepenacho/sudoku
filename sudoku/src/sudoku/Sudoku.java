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
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
            if (ejemplo.casillaVacia(i, j)){
                System.out.print("fila="+i+" col="+j+" nums=");
                for(int num:ejemplo.obtieneNumerosValidos(i, j)){
                    System.out.print(num+",");
                }
             }
                System.out.println();
         }
     }
     
     ArrayList<Integer> nums=ejemplo.obtieneNumerosValidos(6, 8);
     for(int num:nums){
         System.out.println(num);
     }
    }
    
}
