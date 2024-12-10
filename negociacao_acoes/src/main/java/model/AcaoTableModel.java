package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Acao;

public class AcaoTableModel extends AbstractTableModel {

    private List<Acao> acoes;
    private final String[] colunas = {"Nome", "Sigla", "Preço"};

    public AcaoTableModel(List<Acao> acoes) {
       this.acoes  = acoes;
    }

    @Override
    public int getRowCount() {
        return acoes.size(); // Retorna o número de linhas (objetos na lista)
    }

    @Override
    public int getColumnCount() {
        return colunas.length; // Retorna o número de colunas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Acao acao = acoes.get(rowIndex);
        switch (columnIndex) {
            case 0: return acao.getNome(); // Nome
            case 1: return acao.getSigla(); // Sigla
            case 2: return acao.getPreco(); // Preço
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column]; // Retorna o nome da coluna
    }

    public void addAcao(Acao acao) {
        acoes.add(acao);
        fireTableRowsInserted(acoes.size() - 1, acoes.size() - 1);
    }

    public void removeAcao(int rowIndex) {
        acoes.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public Acao getAcaoAt(int rowIndex) {
        return acoes.get(rowIndex);
    }
}
