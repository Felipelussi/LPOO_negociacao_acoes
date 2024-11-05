/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author felipe
 */
public class Corretor extends Pessoa{
    int registroProfissional;
    public Corretor(int registroProfissional, int id, String nome, String cpf) {
        super(id, nome, cpf);
        this.registroProfissional = registroProfissional;
    }

}
