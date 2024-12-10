package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AcaoClienteTableModel extends AbstractTableModel {

    private List<AcaoCliente> acaoClientes;
    private final String[] colunas = {"ID", "Cliente", "Ação", "Quantidade"};

    public AcaoClienteTableModel(List<AcaoCliente> acaoClientes) {
        this.acaoClientes = acaoClientes;
    }

    @Override
    public int getRowCount() {
        return acaoClientes.size(); // Retorna o número de linhas (objetos na lista)
    }

    @Override
    public int getColumnCount() {
        return colunas.length; // Retorna o número de colunas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AcaoCliente acaoCliente = acaoClientes.get(rowIndex);
        switch (columnIndex) {
            case 0: return acaoCliente.getId(); // ID
            case 1: return acaoCliente.getCliente().getNome(); // Nome do cliente
            case 2: return acaoCliente.getAcao().getNome(); // Nome da ação
            case 3: return acaoCliente.getQuantidade(); // Quantidade
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column]; // Retorna o nome da coluna
    }

    public void addAcaoCliente(AcaoCliente acaoCliente) {
        acaoClientes.add(acaoCliente);
        fireTableRowsInserted(acaoClientes.size() - 1, acaoClientes.size() - 1);
    }

    public void removeAcaoCliente(int rowIndex) {
        acaoClientes.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public AcaoCliente getAcaoClienteAt(int rowIndex) {
        return acaoClientes.get(rowIndex);
    }
}
