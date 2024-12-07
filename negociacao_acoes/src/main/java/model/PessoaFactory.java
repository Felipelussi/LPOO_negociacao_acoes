/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author felipe
 */
public class PessoaFactory {
    public static Pessoa criarPessoa(String nome, String cpf, String nConta,  String registro) {
        if (registro == null || registro.trim().isEmpty()) {
            return new Cliente(nome, cpf, nConta);
        } else {
            return new Corretor(nome, cpf, registro);
        }
    }
}
