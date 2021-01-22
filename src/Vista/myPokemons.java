/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author facue
 */
public class myPokemons extends javax.swing.JInternalFrame {
private Controlador controlador; 

    public JTable getTablaMyPkn() {
        return tablaMyPkn;
    }

    public void setTablaMyPkn(JTable tablaMyPkn) {
        this.tablaMyPkn = tablaMyPkn;
    }

    public JButton getBtnInfo() {
        return btnInfo;
    }

    public void setBtnInfo(JButton btnInfo) {
        this.btnInfo = btnInfo;
    }


    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    /**
     * Creates new form myPokemons
     */
    public myPokemons() {
        this.setTitle("My pokemons");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMyPkn = new javax.swing.JTable();
        btnInfo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        tablaMyPkn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "LvlFound"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMyPkn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMyPknMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMyPkn);
        if (tablaMyPkn.getColumnModel().getColumnCount() > 0) {
            tablaMyPkn.getColumnModel().getColumn(0).setResizable(false);
            tablaMyPkn.getColumnModel().getColumn(1).setResizable(false);
            tablaMyPkn.getColumnModel().getColumn(2).setResizable(false);
        }

        btnInfo.setText("See all info of selected Pokemon");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInfo)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed

        if (!controlador.getUserPokemonInfo().isVisible())
        {
        controlador.getModelo().cargarTablaType(controlador.getUserPokemonInfo().getTableType());
        controlador.getModelo().cargarTablaEvolutions(controlador.getUserPokemonInfo().getTablaEvolution());
        controlador.getUserPokemonInfo().setVisible(true);
        controlador.getPrincipal().getDesktop().add(controlador.getUserPokemonInfo(),0);
        }
    }//GEN-LAST:event_btnInfoActionPerformed

    private void tablaMyPknMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMyPknMouseClicked
       int fila= tablaMyPkn.getSelectedRow();
       if (fila==-1){
           JOptionPane.showMessageDialog(null,"Usuario no seleccionado");
       }else{
           int id= Integer.parseInt(tablaMyPkn.getValueAt(fila,0).toString());
           controlador.getModelo().setAuxPokemon(controlador.getModelo().createPokemonObject(id));
           System.out.println(controlador.getModelo().getAuxPokemon().getId());
           System.out.println(controlador.getModelo().getAuxPokemon().getName());
        }  
    }//GEN-LAST:event_tablaMyPknMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMyPkn;
    // End of variables declaration//GEN-END:variables
}
