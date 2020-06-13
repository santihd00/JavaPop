package com.practica.programacion.gui;

import com.practica.programacion.Cliente;
import com.practica.programacion.ClienteProfesional;
import java.util.ArrayList;

/**
 *
 * @author Santiago Hernández
 */
public class ListaClientes extends ListaElementos {

    //Definir un array de strings en linea
    public ListaClientes(ArrayList<Cliente> clientes) {
        super(new String[]{"Nombre", "DNI", "Tarjeta de crédito", "Ubicación","Es profesional"}, (ArrayList) clientes);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class clase = null;
        switch (columnIndex) {
            case 0:
                clase = String.class;
                break;
            case 1:
                clase = String.class;
                break;
            case 2:
                clase = String.class;
                break;
            case 3:
                clase = String.class;
                break;
            case 4:
                clase= Boolean.class;
                break;
            default:
                System.out.println("Error: getColumnClass(): número de columna fuera de rango " + columnIndex);
        }
        return clase;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Buscamos el Producto correspondiente a la línea solicitada
        Object o = null;
        Cliente c = (Cliente) elementos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                o = c.getNombre();
                break;
            case 1:
                o = c.getDNI();
                break;
            case 2:
                o = c.getTarjetaDeCredito();
                break;
            case 3:
                o = c.getUbicacion();
                break;
            case 4:
                if(c instanceof ClienteProfesional){
                    o=Boolean.TRUE;
                }else{
                    o=Boolean.FALSE;
                }
            default:
                System.out.println("Error: getColumnClass(): número de columna fuera de rango " + columnIndex);
        }
        return o;
    }
//TODO: devolver clases

}
