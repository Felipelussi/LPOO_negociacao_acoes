/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
@DiscriminatorValue("Cliente")
public class Cliente extends Pessoa {

    private String nConta;

    @OneToMany(mappedBy = "id")
    private List<AcaoCliente> acoes;

    @OneToMany(mappedBy = "id")
    private List<Negocio> negocios;

    public Cliente(String nome, String cpf, String nConta) {
        super(nome, cpf);
        this.nConta = nConta;
        this.acoes = new ArrayList<>();
        this.negocios = new ArrayList<>();
    }
    
    public Cliente(){
        super();
    }

    public String getnConta() {
        return nConta;
    }

    public void setnConta(String nConta) {
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

    public void comprar(Acao acao, int quantidade) {
        AcaoCliente acaoCliente = this.getAcaoCliente(acao);
        if (acaoCliente != null) {
            acaoCliente.setQuantidade(acaoCliente.getQuantidade() + quantidade);
        } else {
            acaoCliente = new AcaoCliente(acao, this, quantidade);
            this.addAcaoCliente(acaoCliente);
        }
    }

    public void vender(Acao acao, int quantidade) {
        AcaoCliente acaoCliente = this.getAcaoCliente(acao);
        if (acaoCliente == null || acaoCliente.getQuantidade() < quantidade) {
            throw new IllegalArgumentException("Não há ações suficientes para a venda.");
        }
        acaoCliente.setQuantidade(acaoCliente.getQuantidade() - quantidade);
        if (acaoCliente.getQuantidade() == 0) {
            this.acoes.remove(acaoCliente);
        }
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
