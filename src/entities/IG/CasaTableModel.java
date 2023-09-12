package entities.IG;

import entities.Casa;
import entities.Entidade;

import javax.swing.table.AbstractTableModel;

public class CasaTableModel extends AbstractTableModel {
    private Casa[][] matriz;

    public CasaTableModel(Casa[][] matriz) {
        this.matriz = matriz;
    }

    @Override
    public int getRowCount() {
        return matriz.length;
    }

    @Override
    public int getColumnCount() {
        return matriz[0].length;
    }

    @Override
    public Casa getValueAt(int rowIndex, int columnIndex) {
        return matriz[rowIndex][columnIndex];
    }
}
