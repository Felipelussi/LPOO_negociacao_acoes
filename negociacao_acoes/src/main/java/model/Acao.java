/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author felipe
 */
@Entity()
@Table(name="acoes")
public class Acao {
    @Id
    private int id;

    public Acao(int id, String nome, Double preco, String sigla) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.sigla = sigla;
    }
    private String nome;
    private Double preco;
    private String sigla;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "Acao{" + "id=" + id + ", nome=" + nome + ", preco=" + preco + ", sigla=" + sigla + '}';
    }
    
}
