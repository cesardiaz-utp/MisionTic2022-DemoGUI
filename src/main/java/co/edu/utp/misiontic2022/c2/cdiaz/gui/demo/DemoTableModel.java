package co.edu.utp.misiontic2022.c2.cdiaz.gui.demo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DemoTableModel extends AbstractTableModel {

    private List<DemoObject> data;

    public DemoTableModel() {
        data = new ArrayList<>();
    }

    public void setData(List<DemoObject> data) {
        this.data = data;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nombre";
        }
        return super.getColumnName(column);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var objeto = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return objeto.getId();
            case 1:
                return objeto.getNombre();
        }

        return null;
    }

}
