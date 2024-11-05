/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Corretor;
import model.Acao;
import model.Cliente;
import java.util.Date;
import java.util.Optional;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author felipe
 */
@Entity()
@Table(name = "negocios")
public class Negocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "comprador_id")
    private Cliente comprador;

    @ManyToOne()
    @JoinColumn(name = "vendedor_id")
    private Cliente vendedor;

    private int quantidade;

    @ManyToOne()
    @JoinColumn(name = "acao_id")
    private Acao acao;

    @ManyToOne()
    @JoinColumn(name = "corretor_id")
    private Corretor corretor;

    private Date data;

    public Negocio(Cliente comprador, Cliente vendedor, int quantidade, Acao acao, Corretor corretor, Date data) {
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.quantidade = quantidade;
        this.acao = acao;
        this.corretor = corretor;
        this.data = data;        
        comprador.addNegocio(this);
        this.atualizarEstoque();
    }
    
//    public static Optional<Negocio> createNegocio(Cliente comprador, Cliente vendedor, int quantidade, Acao acao, Corretor corretor, Date data) {
//        if (vendedor.verificaAcoes(acao, quantidade)) {
//            return Optional.of(new Negocio(comprador, vendedor, quantidade, acao, corretor, data));
//    } else {
//        System.out.println("O vendedor não possui ações suficientes");
//        return Optional.empty();
//    }
//    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Cliente getVendedor() {
        return vendedor;
    }

    public void setVendedor(Cliente vendedor) {
        this.vendedor = vendedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    @Override
    public String toString() {
        return "Negocio{" + "id=" + id + ", comprador=" + comprador + ", vendedor=" + vendedor + ", quantidade=" + quantidade + ", acao=" + acao + ", corretor=" + corretor + ", data=" + data + '}';
    }
    
     private void atualizarEstoque() {
        AcaoCliente acaoClienteVendedor = vendedor.getAcaoCliente(this.acao);
        if (acaoClienteVendedor == null || acaoClienteVendedor.getQuantidade() < quantidade) {
            throw new IllegalArgumentException("Vendedor não tem ações suficientes para a transação.");
        }
        acaoClienteVendedor.setQuantidade(acaoClienteVendedor.getQuantidade() - quantidade);

        AcaoCliente acaoClienteComprador = comprador.getAcaoCliente(this.acao);
        if (acaoClienteComprador != null) {
            acaoClienteComprador.setQuantidade(acaoClienteComprador.getQuantidade() + quantidade);
        } else {
            acaoClienteComprador = new AcaoCliente(this.acao, comprador, quantidade);
            comprador.addAcaoCliente(acaoClienteComprador);
            
        }
    }



}
