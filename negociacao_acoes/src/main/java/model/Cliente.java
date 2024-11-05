/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author felipe
 */
@Entity
public class Cliente extends Pessoa{
    int nConta;
    
    @OneToMany(mappedBy = "id")
    List<AcaoCliente> acoes;
    @OneToMany(mappedBy = "id")
    List<Negocio> negocios;

    public Cliente(String nome, String cpf, int nConta) {
        super(nome, cpf);
        this.nConta = nConta;
        this.acoes = new ArrayList<AcaoCliente>();
        this.negocios = new ArrayList<Negocio>();
    }
    
    
}
