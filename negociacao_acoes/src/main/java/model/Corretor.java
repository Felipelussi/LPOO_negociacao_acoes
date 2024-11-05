/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Entity;

/**
 *
 * @author felipe
 */
@Entity
public class Corretor extends Pessoa{
    private int registroProfissional;
    public Corretor(String nome, String cpf, int registroProfissional) {
        super(nome, cpf);
        this.registroProfissional = registroProfissional;
    }

    public int getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(int registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

}
