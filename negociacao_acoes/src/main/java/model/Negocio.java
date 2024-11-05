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
import javax.persistence.Table;

/**
 *
 * @author felipe
 */
//@Entity()
//@Table(name="negocios")
public class Negocio {
//    @Id
    int id;
    Cliente comprador;
    Cliente vendedor;
    int quantidade;
    Acao acao;
    Corretor corretor;
    Date data;
    
}
