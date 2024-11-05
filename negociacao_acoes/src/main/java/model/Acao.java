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
    int id;

    public Acao(int id, String nome, Double preco, String sigla) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.sigla = sigla;
    }
    String nome;
    Double preco;
    String sigla;
    
}
