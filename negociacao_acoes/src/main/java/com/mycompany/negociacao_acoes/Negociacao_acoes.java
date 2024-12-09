/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.negociacao_acoes;

import java.util.Date;
import model.Acao;
import model.AcaoCliente;
import model.Cliente;
import model.Corretor;
import model.Negocio;

/**
 *
 * @author felipe
 */
public class Negociacao_acoes{
    
//     private PersistenciaJPA jpa;

    public Negociacao_acoes() {
//        this.jpa = new PersistenciaJPA();
    }

    public void iniciarConexao() {
//        jpa.conexaoAberta();
    }

    public void fecharConexao() {
//        jpa.fecharConexao();
    }

    public void persistirDados() {
        Acao a = new Acao(1, "Petrobras", 5.234, "PETR4");
        Cliente c = new Cliente("felipe", "939731987", "2");
        Cliente fer = new Cliente("fernanda", "939731987", "3");
        Corretor co = new Corretor("diego", "32049420249", "12");
        AcaoCliente ac = new AcaoCliente(a, fer, 100);

        try {
//            jpa.persist(a);
//            jpa.persist(c);
//            jpa.persist(fer);
//            jpa.persist(co);
//            jpa.persist(ac);
            System.out.println("Dados persistidos com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao persistir dados: " + e.getMessage());
        }

      
    }
    

    public static void main(String[] args) {
//        Negociacao_acoes negociacao = new Negociacao_acoes();
//
//        negociacao.iniciarConexao();
//
//        negociacao.persistirDados();
//
//        negociacao.fecharConexao();
System.out.println("hello");
    }
}
        
    

