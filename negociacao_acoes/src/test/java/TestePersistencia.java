/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.mycompany.negociacao_acoes.dao.PersistenciaJPA;
import java.util.Date;
import java.util.Optional;
import model.Acao;
import model.AcaoCliente;
import model.Cliente;
import model.Corretor;
import model.Negocio;
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
        Cliente fer = new Cliente("fernanda", "939731987", 3);
        Corretor co = new Corretor("diego", "32049420249", 12);
        AcaoCliente ac = new AcaoCliente(a, fer, 200);
        AcaoCliente ac1 = new AcaoCliente(a, c, 200);
        Negocio ne = new Negocio(c, fer, 100, a, co, new Date());

        try {
            jpa.persist(a);
            jpa.persist(c);
            jpa.persist(fer);
            jpa.persist(ac);
            jpa.persist(ac1);
            jpa.persist(co);
            jpa.persist(ne);
            jpa.persist(c);
        } catch (Exception e) {
            System.out.println("Erro ao persistir entidades");
            System.out.println(e);
        }


    }
}
