/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class Cliente extends Pessoa{
    int nConta;
    ArrayList<AcaoCliente> acoes;
    ArrayList<Negocio> negocios;

    public Cliente(int nConta, int id, String nome, String cpf) {
        super(id, nome, cpf);
        this.nConta = nConta;
        this.acoes = new ArrayList<AcaoCliente>();
        this.negocios = new ArrayList<Negocio>();
    }
    
    
}
