/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.negociacao_acoes;


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
        
    

