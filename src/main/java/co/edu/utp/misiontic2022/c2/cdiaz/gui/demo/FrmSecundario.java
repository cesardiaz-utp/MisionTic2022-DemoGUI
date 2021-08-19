/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.cdiaz.gui.demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ROG
 */
public class FrmSecundario extends JFrame {

    private JTextField txtValor;
    private DemoTableModel tableModel;

    public FrmSecundario() {

        initUi();
    }

    private void initUi() {
        setTitle("Formulario secundario");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        var tabPane = new JTabbedPane();
        getContentPane().add(tabPane, BorderLayout.CENTER);

        var panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        iniciarConsulta1(panel1);
        tabPane.addTab("Consulta 1", panel1);

        var panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        //iniciarConsulta2(panel2);
        tabPane.addTab("Consulta 2", panel2);

        
    }

    private void iniciarConsulta1(JPanel panel){
        var etiqueta = new JLabel("MI VENTANA DE EJEMPLO");
        etiqueta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel.add(etiqueta, BorderLayout.PAGE_START);

        var panelBotones = new JPanel();
        panelBotones.setOpaque(true);
        panelBotones.setBackground(Color.GREEN);
        panelBotones.add(new JButton("Boton 1"));
        panelBotones.add(new JButton("Boton 2"));
        panel.add(panelBotones, BorderLayout.PAGE_END);

        var panelIzquierda = new JPanel();
        txtValor = new JTextField(10);
        panelIzquierda.add(txtValor);
        var botonEjecutar = new JButton("Guardar");
        botonEjecutar.addActionListener(e -> ejecutarTarea(txtValor.getText().trim()));
        panelIzquierda.add(botonEjecutar);
        panel.add(panelIzquierda, BorderLayout.LINE_START);

        var panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(new JLabel("Datos de la tabla"), BorderLayout.PAGE_START);

        var tabla = new JTable();
        tableModel = new DemoTableModel();
        tabla.setModel(tableModel);
        panelCentral.add(new JScrollPane(tabla), BorderLayout.CENTER);
        panelCentral.add(new JComboBox<>(), BorderLayout.PAGE_END);

        panel.add(panelCentral, BorderLayout.CENTER);
    }

    private void ejecutarTarea(String valor) {
        var dato = Integer.valueOf(valor);
        List<DemoObject> lista = new ArrayList<>();
        for (int i = 1; i <= dato; i++) {
            lista.add(new DemoObject(i, "Elemento "+i));
        }

        //JOptionPane.showMessageDialog(this, valor);
        tableModel.setData(lista);

        txtValor.setText("");
        txtValor.requestFocus();
    }

}
