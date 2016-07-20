/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author hector
 */
public class SudokuInstance {
    int matriz[][];

    public static boolean existeFichero(String fichero){
       
        try {
            FileReader fr=new FileReader(fichero);
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }
    }
    /*
    public static boolean ficheroValido(String fichero){
        
        if (SudokuInstance.existeFichero(fichero)){
            
            
        }
        else {
            return false;
        }
       }
*/
    public SudokuInstance(String fichero){
        
        if (SudokuInstance.existeFichero(fichero)){
            matriz=new int[9][9];
            try {
                BufferedReader br=new BufferedReader(new FileReader(fichero));
                for (int i=0;i<9;i++){
                    String fila=br.readLine();
                    String[] casillas =fila.split(" ");
                    for (int j=0;j<9;j++){
                        matriz[i][j]=Integer.parseInt(casillas[j]);
                    }
                }
            }
        catch  (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            }
            //puntero nulo si no hay bastantes filas
        catch (NullPointerException npe){
            npe.printStackTrace();
        }
        catch (Exception e){
                e.printStackTrace();
            }
        }    
    }
    public void setNumero(int num, int fila, int col){
        matriz[fila][col]=num;
    }
    public int getNumero(int fila, int col){
        return matriz[fila][col];
    }
    public void imprimeSudoku(){
        System.out.println("---------------------");
        for(int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if(j==0){
                    System.out.print("|");
                }
                System.out.print(matriz[i][j]+" ");
                if(j==2 || j==5 ||j==8){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i==2 || i==5 ||i==8){
                    System.out.println("---------------------");
                }
        }
    }
    public boolean casillaVacia(int fila,int col){
        return (matriz[fila][col]==0);
    }
    public boolean esNumeroValido(int num, int fila, int col){
        
        if (!estaNumeroEnFila(num,fila)){
            if (!estaNumeroEnColumna(num,col)){
                if (!estaNumeroEnSector(num,fila,col)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean estaNumeroEnFila(int num, int fila){
        int col=0;
        while (col<9){
            if (matriz[fila][col]==num){
                return true;
            }
            col++;
        }
        return false;
    }
    
     public boolean estaNumeroEnColumna(int num, int col){
        int fila=0;
        while (fila<9){
            if (matriz[fila][col]==num){
                return true;
            }
            fila++;
        }
        return false;
    }
     
    public boolean estaNumeroEnSector(int num, int fila, int col){
     
        int filIni=0;
        int colIni=0;
        int numSector=numeroSector(fila,col);
        switch (numSector) {
            case 1:  {
                       filIni=0;
                       colIni=0;
                       break;
                }
            case 2:  {
                       filIni=0;
                       colIni=3;
                       break;
                }
            case 3:  {
                       filIni=0;
                       colIni=6;
                       break;
                }
            case 4:  {
                       filIni=3;
                       colIni=0;
                       break;
                }
            case 5:  {
                       filIni=3;
                       colIni=3;
                       break;
                }
            case 6:  {
                       filIni=3;
                       colIni=6;
                       break;
                }
            case 7:  {
                       filIni=6;
                       colIni=0;
                       break;
                }
            case 8:  {
                       filIni=6;
                       colIni=3;
                       break;
                }
            case 9:  {
                       filIni=6;
                       colIni=6;
                       break;
                }
        }
        int i=filIni;
        
        while (i<filIni+3){
            int j=colIni;
            while (j<colIni+3){   
               if (matriz[i][j]==num) return true;
               j++;
            }
            i++;
        }
        
        return false;             
    }
     protected int numeroSector(int fila, int col){
         if (fila<3){
             if (col<3) {
                 return 1;
             }
             else if (col<6) {
                return 2;
             }
                else return 3;
             }
         else if (fila<6){
              if (col<3) {
                 return 4;
             }
             else if (col<6) {
                return 5;
             }
                else return 6;
             }
         else {
              if (col<3) {
                 return 7;
             }
             else if (col<6) {
                return 8;
             }
                else return 9;
             }
         
     }
     
     public ArrayList<Integer> obtieneNumerosValidos(int fila, int col){
         ArrayList<Integer> nums=new ArrayList();
         if (matriz[fila][col]!=0){
             return nums;
         }
         for (int i=1;i<10;i++){
             if (esNumeroValido(i,fila,col)){
                nums.add(i);
            }
         }
     return nums;
     }
     
    /* Obtiene los numeros que faltan por poner en una fila*/
    public ArrayList<Integer> obtenNumerosRestantesFila(int fila){
       ArrayList<Integer> aux=creaListaLlena();
       for (int i=0;i<9;i++){
           if (getNumero(fila,i)!=0){
               aux.remove((Integer)getNumero(fila,i));
           }
       }
       return aux;
    }
    
    
    public ArrayList<Integer> obtenPosicionesPosiblesNumeroEnFila(int num,int fila){
        ArrayList<Integer> aux=new ArrayList();
        for (int i=0;i<9;i++){
            if (casillaVacia(fila,i)){
                if (esNumeroValido(num,fila,i)){
                    aux.add(i);
                }
            }
        }
        return aux;
    }
    
    public void completaFila(int fila){
        
        ArrayList<Integer> numerosRestantes=obtenNumerosRestantesFila(fila);
        for (int num:numerosRestantes){
             ArrayList<Integer> posicionesPosibles=obtenPosicionesPosiblesNumeroEnFila(num,fila);
             if (posicionesPosibles.size()==1){
                 setNumero(num,fila,posicionesPosibles.get(0));
             }
         }
        
    }
    
    private ArrayList<Integer> creaListaLlena(){
        ArrayList<Integer> aux=new ArrayList();
        for (int i=1;i<10;i++){
            aux.add(i);
        }
        return aux;
    }
    public int realizaPasada(){
         ArrayList<Integer> aux;
         int res=0;
         for (int i=0;i<9;i++){
             for (int j=0;j<9;j++){
                 if (casillaVacia(i,j)){
                     aux=obtieneNumerosValidos(i,j);
                     if (aux.size()==1){
                         matriz[i][j]=aux.get(0);
                         res++;
                     }
                 }
             }
         }
         return res;
     }
}