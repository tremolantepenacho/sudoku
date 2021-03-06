/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hector
 */
public class SudokuInstanceTest {
    
    static SudokuInstance ejemplo;
    
   /* public SudokuInstanceTest() {
    }*/
    
    @BeforeClass
    public static void setUpClass() {
        
        ejemplo=new SudokuInstance("facil.sdk");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testFicheroNoExiste() {
        assertFalse(SudokuInstance.existeFichero("ficheroimaginario"));
                    
    }
    @Test
    public void testEstaNumeroEnFila(){
        assertFalse(ejemplo.estaNumeroEnFila(1, 0));
        assertTrue(ejemplo.estaNumeroEnFila(2, 0));
    }
    @Test
    public void testEstaNumeroEnColumna(){
        assertFalse(ejemplo.estaNumeroEnColumna(7, 0));
        assertTrue(ejemplo.estaNumeroEnColumna(1, 0));
    }
    
    /**
     * Test of estaNumeroEnSector method, of class SudokuInstance.
     */
    @Test
    public void testEstaNumeroEnSector() {
       assertFalse(ejemplo.estaNumeroEnSector(9, 1, 1));
       assertTrue(ejemplo.estaNumeroEnSector(8, 1, 1));
       
       assertFalse(ejemplo.estaNumeroEnSector(1, 1, 4));
       assertTrue(ejemplo.estaNumeroEnSector(5, 1, 4));
       
       assertFalse(ejemplo.estaNumeroEnSector(8, 1, 8));
       assertTrue(ejemplo.estaNumeroEnSector(7, 1, 8));
       
       
       assertFalse(ejemplo.estaNumeroEnSector(5, 4, 1));
       assertTrue(ejemplo.estaNumeroEnSector(8, 4, 1));
       
       assertFalse(ejemplo.estaNumeroEnSector(3, 4, 4));
       assertTrue(ejemplo.estaNumeroEnSector(7, 4, 4));
       
       assertFalse(ejemplo.estaNumeroEnSector(1, 4, 8));
       assertTrue(ejemplo.estaNumeroEnSector(5, 4, 8));
       
       
       assertFalse(ejemplo.estaNumeroEnSector(6, 7, 1));
       assertTrue(ejemplo.estaNumeroEnSector(9, 7, 1));
       
       assertFalse(ejemplo.estaNumeroEnSector(1, 7, 4));
       assertTrue(ejemplo.estaNumeroEnSector(6, 7, 4));
       
       assertFalse(ejemplo.estaNumeroEnSector(1, 7, 8));
       assertTrue(ejemplo.estaNumeroEnSector(8, 7, 8));
       
       
       
    }
    @Test
    public void testNumeroSector(){
        assertEquals(1,ejemplo.numeroSector(0, 0));
        assertEquals(4,ejemplo.numeroSector(4, 0));
        assertEquals(7,ejemplo.numeroSector(7, 0));
        assertEquals(2,ejemplo.numeroSector(0, 4));
        assertEquals(5,ejemplo.numeroSector(4, 4));
        assertEquals(8,ejemplo.numeroSector(7, 4));
        assertEquals(3,ejemplo.numeroSector(0, 7));
        assertEquals(6,ejemplo.numeroSector(4, 7));
        assertEquals(9,ejemplo.numeroSector(7, 7));
    }

   @Test
   public void testEsNumeroValido(){
       assertTrue(ejemplo.esNumeroValido(4, 0, 0));
       assertFalse(ejemplo.esNumeroValido(1, 0, 0));
       
       assertTrue(ejemplo.esNumeroValido(4, 0, 4));
       assertFalse(ejemplo.esNumeroValido(2, 0, 4));
       
       assertTrue(ejemplo.esNumeroValido(1, 0, 7));
       assertFalse(ejemplo.esNumeroValido(6, 0, 7));
       
       assertTrue(ejemplo.esNumeroValido(7, 3, 0));
       assertFalse(ejemplo.esNumeroValido(4, 3, 0));
       
       assertTrue(ejemplo.esNumeroValido(4, 3, 4));
       assertFalse(ejemplo.esNumeroValido(7, 3, 4));
       
       assertTrue(ejemplo.esNumeroValido(7, 3, 8));
       assertFalse(ejemplo.esNumeroValido(6, 3, 8));
       
       assertTrue(ejemplo.esNumeroValido(1, 6, 2));
       assertFalse(ejemplo.esNumeroValido(9, 6, 2));
       
       assertTrue(ejemplo.esNumeroValido(5, 6, 4));
       assertFalse(ejemplo.esNumeroValido(7, 6, 4));
       
       assertTrue(ejemplo.esNumeroValido(1, 7, 7));
       assertFalse(ejemplo.esNumeroValido(2, 7, 7));
   }

    @Test
   public void testObtieneNumerosValidos(){   
       assertTrue(ejemplo.obtieneNumerosValidos(1, 0).isEmpty());
       
       assertEquals(ejemplo.obtieneNumerosValidos(3,0).size(),1);
       assertEquals(ejemplo.obtieneNumerosValidos(3,0).get(0).intValue(),7);
       
       assertEquals(ejemplo.obtieneNumerosValidos(0,0).size(),2);
       assertEquals(ejemplo.obtieneNumerosValidos(0,0).get(0).intValue(),4);
       assertEquals(ejemplo.obtieneNumerosValidos(0,0).get(1).intValue(),7);
       
       assertEquals(ejemplo.obtieneNumerosValidos(1,8).size(),3);
       assertEquals(ejemplo.obtieneNumerosValidos(1,8).get(0).intValue(),4);
       assertEquals(ejemplo.obtieneNumerosValidos(1,8).get(1).intValue(),8);
       assertEquals(ejemplo.obtieneNumerosValidos(1,8).get(2).intValue(),9);
       
       assertEquals(ejemplo.obtieneNumerosValidos(2,3).size(),4);
       assertEquals(ejemplo.obtieneNumerosValidos(2,3).get(0).intValue(),3);
       assertEquals(ejemplo.obtieneNumerosValidos(2,3).get(1).intValue(),4);
       assertEquals(ejemplo.obtieneNumerosValidos(2,3).get(2).intValue(),7);
       assertEquals(ejemplo.obtieneNumerosValidos(2,3).get(3).intValue(),9);
       
       assertEquals(ejemplo.obtieneNumerosValidos(8,4).size(),5);
       assertEquals(ejemplo.obtieneNumerosValidos(8,4).get(0).intValue(),1);
       assertEquals(ejemplo.obtieneNumerosValidos(8,4).get(1).intValue(),2);
       assertEquals(ejemplo.obtieneNumerosValidos(8,4).get(2).intValue(),5);
       assertEquals(ejemplo.obtieneNumerosValidos(8,4).get(3).intValue(),8);
       assertEquals(ejemplo.obtieneNumerosValidos(8,4).get(4).intValue(),9);
   
   }
   @Test
   public void testObtenNumerosRestantesFilas(){   
       ArrayList<Integer> aux=ejemplo.obtenNumerosRestantesFila(1);
       assertEquals(aux.size(),5);
       assertTrue(aux.contains((Integer)2));
       assertTrue(aux.contains((Integer)4));
       assertTrue(aux.contains((Integer)6));
       assertTrue(aux.contains((Integer)8));
       assertTrue(aux.contains((Integer)9));
       assertFalse(aux.contains((Integer)1));
       assertFalse(aux.contains((Integer)3));
       assertFalse(aux.contains((Integer)5));
       assertFalse(aux.contains((Integer)7));
       
       aux=ejemplo.obtenNumerosRestantesFila(8);
       assertEquals(aux.size(),6);
       assertTrue(aux.contains((Integer)1));
       assertTrue(aux.contains((Integer)2));
       assertTrue(aux.contains((Integer)4));
       assertTrue(aux.contains((Integer)5));
       assertTrue(aux.contains((Integer)8));
       assertTrue(aux.contains((Integer)9));
       assertFalse(aux.contains((Integer)3));
       assertFalse(aux.contains((Integer)6));
       assertFalse(aux.contains((Integer)7));
   }
   @Test
   public void testObtenPosicionesPosiblesNumeroEnFila(){
       ArrayList<Integer> aux=ejemplo.obtenPosicionesPosiblesNumeroEnFila(1,0);
       assertEquals(aux.size(),3);
       assertTrue(aux.contains((Integer)4));
       assertTrue(aux.contains((Integer)5));
       assertTrue(aux.contains((Integer)7));
       
       aux=ejemplo.obtenPosicionesPosiblesNumeroEnFila(2,0);
       assertEquals(aux.size(),0);
       
       aux=ejemplo.obtenPosicionesPosiblesNumeroEnFila(6,1);
       assertEquals(aux.size(),1);
       assertEquals(aux.get(0),(Integer)1);
    
   }
}
