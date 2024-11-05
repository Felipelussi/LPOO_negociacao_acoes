/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.mycompany.negociacao_acoes.dao.PersistenciaJPA;
import model.Acao;
import model.Cliente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author felipe
 */
public class TestePersistencia {
    
     PersistenciaJPA jpa = new PersistenciaJPA();
    public TestePersistencia() {
    }
    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testePersistencia() {
        Acao a = new Acao(1, "Petrobras", 5.234, "PETR4");
        Cliente c = new Cliente("felipe", "939731987", 2);
        try {
            jpa.persist(a);
            jpa.persist(c);

        } catch (Exception e) {
            System.out.println("Erro ao persistir model: " + a);
            System.out.println(e);
        }

    }
}
