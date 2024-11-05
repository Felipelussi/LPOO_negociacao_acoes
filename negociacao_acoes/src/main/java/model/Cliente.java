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
    private int nConta;
    
    @OneToMany(mappedBy = "id")
    private List<AcaoCliente> acoes;
    
    @OneToMany(mappedBy = "id")
    private List<Negocio> negocios;

    public Cliente(String nome, String cpf, int nConta) {
        super(nome, cpf);
        this.nConta = nConta;
        this.acoes = new ArrayList<AcaoCliente>();
        this.negocios = new ArrayList<Negocio>();
    }

    public int getnConta() {
        return nConta;
    }

    public void setnConta(int nConta) {
        this.nConta = nConta;
    }

    public List<AcaoCliente> getAcoes() {
        return acoes;
    }

    public void setAcoes(List<AcaoCliente> acoes) {
        this.acoes = acoes;
    }

    public List<Negocio> getNegocios() {
        return negocios;
    }

    public void setNegocios(List<Negocio> negocios) {
        this.negocios = negocios;
    }
    
    public void addNegocio(Negocio negocio) {
 
    this.negocios.add(negocio);
    }
    
    public boolean verificaAcoes(Acao acao, int qtd){
        
        System.out.println(acao.getNome());
        System.out.println("qtd: " + qtd);
        return true;
//        if(!this.acoes.contains(acao))
//          return false;
//        return this.acoes.get(this.acoes.indexOf(acao)).getQuantidade() >= qtd;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nConta=" + nConta + ", acoes=" + acoes + ", negocios=" + negocios + '}';
    }
    
        public AcaoCliente getAcaoCliente(Acao acao) {
        return this.acoes.stream()
                .filter(acaoCliente -> acaoCliente.getAcao().equals(acao))
                .findFirst()
                .orElse(null);
    }

    public void addAcaoCliente(AcaoCliente acaoCliente) {
        this.acoes.add(acaoCliente);
    }
       
}
