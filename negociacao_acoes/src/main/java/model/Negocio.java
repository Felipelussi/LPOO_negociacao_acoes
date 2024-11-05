/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Corretor;
import model.Acao;
import model.Cliente;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author felipe
 */
@Entity()
@Table(name="negocios")
public class Negocio {
    @Id
    int id;
    
    @ManyToOne()
    @JoinColumn(name = "comprador_id")
    Cliente comprador;
    
    @ManyToOne()
    @JoinColumn(name = "vendedor_id")
    Cliente vendedor;
    
    int quantidade;
    
    @ManyToOne()
    @JoinColumn(name = "acao_id")
    Acao acao;
    
    @ManyToOne()
    @JoinColumn(name = "corretor_id")
    Corretor corretor;
    
    Date data;
    
}
