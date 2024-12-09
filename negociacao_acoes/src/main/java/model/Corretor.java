/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 *
 * @author felipe
 */
@Entity
@DiscriminatorValue("Corretor")
public class Corretor extends Pessoa {

    @Column
     String registroProfissional;

    public Corretor(String nome, String cpf, String registroProfissional) {
        super(nome, cpf);
        this.registroProfissional = registroProfissional;
    }

    public Corretor(){
        super();
    }
    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }
    
  

}
