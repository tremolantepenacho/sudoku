/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

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
     /*   for (int i=1;i<10;i++){
            System.out.println(i+":"+ejemplo.compruebaNumero(i, 0, 0));
        }
       */
     /*for (int i=1;i<10;i++){
          System.out.println(i+":"+ejemplo.estaNumeroEnSector(i, 1, 1));
     }*/
     
     ejemplo.esNumeroValido(3, 1, 4);
    }
    
}
