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

    @Test
    public void testePersistencia() {
        Acao petr4 = new Acao(1, "Petrobras", 5.234, "PETR4");
        Cliente felipe = new Cliente("felipe", "939731987", 2);
        Cliente fernanda = new Cliente("fernanda", "939731987", 3);
        Corretor corretor = new Corretor("diego", "32049420249", 12);
        AcaoCliente ac = new AcaoCliente(petr4, fernanda, 200);
        AcaoCliente ac1 = new AcaoCliente(petr4, felipe, 200);
        Negocio negocio = new Negocio(felipe, fernanda, 100, petr4, corretor, new Date());

        try {
            jpa.persist(petr4);
            jpa.persist(felipe);
            jpa.persist(fernanda);
            jpa.persist(ac);
            jpa.persist(ac1);
            jpa.persist(corretor);
            jpa.persist(negocio);
            jpa.persist(felipe);
        } catch (Exception e) {
            System.out.println("Erro ao persistir entidades");
            System.out.println(e);
        }

    }
}
