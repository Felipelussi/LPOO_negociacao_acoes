package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PessoaTableModel extends AbstractTableModel {

    private List<Pessoa> pessoas;
    private final String[] colunas = {"ID", "Nome", "CPF", "Tipo"};

    public PessoaTableModel(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public int getRowCount() {
        return pessoas.size(); // Retorna o número de linhas (objetos na lista)
    }

    @Override
    public int getColumnCount() {
        return colunas.length; // Retorna o número de colunas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pessoa pessoa = pessoas.get(rowIndex);
        switch (columnIndex) {
            case 0: return pessoa.id; // ID
            case 1: return pessoa.getNome(); // Nome
            case 2: return pessoa.getCpf(); // CPF
            case 3: return (pessoa instanceof Cliente) ? "Cliente" : "Corretor"; // Tipo
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column]; // Retorna o nome da coluna
    }

    public void addPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        fireTableRowsInserted(pessoas.size() - 1, pessoas.size() - 1);
    }

    public void removePessoa(int rowIndex) {
        pessoas.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public Pessoa getPessoaAt(int rowIndex) {
        return pessoas.get(rowIndex);
    }
}
