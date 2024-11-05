/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author felipe
 */
@Entity
public class AcaoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "acao_id")
    private Acao acao;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private int quantidade;

    public AcaoCliente( Acao acao, Cliente cliente, int quantidade) {
        this.acao = acao;
        this.cliente = cliente;
        this.quantidade = quantidade;
        cliente.addAcaoCliente(this);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    } 

    @Override
    public String toString() {
        return "AcaoCliente{" + "id=" + id + ", acao=" + acao + ", cliente=" + cliente + ", quantidade=" + quantidade + '}';
    }
    
    
        
}
