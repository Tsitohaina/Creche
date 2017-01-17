/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creche;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ITU
 */
public class ParentTest {
    
    public ParentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    /**
     * Test of getIdParent method, of class Parent.
     */
    @Test
    public void testGetIdParent(){
        System.out.println("getIdParent");
        Parent instance = new Parent();
        int expResult = 0;
        int result = instance.getIdParent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addParent method, of class Parent.
     */
    @Test
    public void testAddParent() throws Exception {
        System.out.println("addParent");
        String nom = "test1Nom";
        String prenom = "test1Prenom";
        Parent instance = new Parent();
        instance.addParent(nom, prenom);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getnbEnfant method, of class Parent.
     */
    @Test
    public void testGetnbEnfant() {
        System.out.println("getnbEnfant");
        int idParent = 0;
        Parent instance = new Parent();
        int expResult = 0;
        int result = instance.getnbEnfant(idParent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAllEnfant method, of class Parent.
     */
    @Test
    public void testGetAllEnfant() {
        System.out.println("getAllEnfant");
        int idParent = 0;
        Parent instance = new Parent();
        Enfant[] expResult = null;
        Enfant[] result = instance.getAllEnfant(idParent);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerParent method, of class Parent.
     */
    @Test
    public void testSupprimerParent() {
        System.out.println("supprimerParent");
        int idParent = 0;
        Parent instance = new Parent();
        int expResult = 0;
        int result = instance.supprimerParent(idParent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerTout method, of class Parent.
     */
    @Test
    public void testSupprimerTout() {
        System.out.println("supprimerTout");
        int idParent = 0;
        Parent instance = new Parent();
        instance.supprimerTout(idParent);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNbParent method, of class Parent.
     */
    @Test
    public void testGetNbParent() {
        System.out.println("getNbParent");
        Parent instance = new Parent();
        int expResult = 0;
        int result = instance.getNbParent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getParent method, of class Parent.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        int idParent = 0;
        Parent instance = new Parent();
        Parent expResult = null;
        Parent result = instance.getParent(idParent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAllParent method, of class Parent.
     */
    @Test
    public void testGetAllParent() {
        System.out.println("getAllParent");
        Parent instance = new Parent();
        Parent[] expResult = null;
        Parent[] result = instance.getAllParent();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Parent.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] arg = null;
        Parent.main(arg);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
