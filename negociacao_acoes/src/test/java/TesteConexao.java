/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.mycompany.negociacao_acoes.dao.PersistenciaJPA;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author felipe
 */
public class TesteConexao {
    PersistenciaJPA  jpa = new PersistenciaJPA();
    
    public TesteConexao() {
            

    }
    
    @BeforeClass
    public static void setUpClass() {
   

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        if(jpa.conexaoAberta())
        {
            System.out.println("conectado");
        }
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
        System.out.println("Conexão encerrada");
    }
    
    @Test
    public void testeConexao(){
        System.out.println("Conexão realizada");
    }

}
