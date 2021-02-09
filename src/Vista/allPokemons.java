/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author facue
 */
public class allPokemons extends javax.swing.JInternalFrame {
    Controlador controlador;
    
    
    @Override
    public void dispose() {
        controlador.getModelo().setAuxPokemon(null);
        super.dispose();
    }
    

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void setTablaAllPkm(JTable tablaAllPkm) {
        this.tablaAllPkm = tablaAllPkm;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public JTable getTablaAllPkm() {
        return tablaAllPkm;
    }
    
    /**
     * Creates new form allPokemons
     */
    public allPokemons() {
        this.setTitle("All pokemons");
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
        tablaAllPkm = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        tablaAllPkm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAllPkm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAllPkmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAllPkm);
        if (tablaAllPkm.getColumnModel().getColumnCount() > 0) {
            tablaAllPkm.getColumnModel().getColumn(0).setResizable(false);
            tablaAllPkm.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton1.setText("Add new Pokemon");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("View and modify selected pokemon");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if (!controlador.getNewPokemon().isVisible())
        {
        controlador.getNewPokemon().setVisible(true);
        controlador.getPrincipal().getDesktop().add(controlador.getNewPokemon(),0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!controlador.getAllPokemonsInfo().isVisible()) {
            try {
                controlador.getAllPokemonsInfo().getLblNameModify().setText(controlador.getModelo().getAuxPokemon().getName());
                controlador.getModelo().cargarTablaType(controlador.getAllPokemonsInfo().getTableModifyType());
                controlador.getModelo().cargarTablaEvolutions(controlador.getAllPokemonsInfo().getTableModifyEvolution());
                controlador.getModelo().cargarTablaAbilities(controlador.getAllPokemonsInfo().getTableModifyAbilities());
                controlador.getAllPokemonsInfo().setVisible(true);
                controlador.getPrincipal().getDesktop().add(controlador.getAllPokemonsInfo(), 0);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: Pokemon not selected");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablaAllPkmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAllPkmMouseClicked
       int fila= tablaAllPkm.getSelectedRow();
       if (fila==-1){
           JOptionPane.showMessageDialog(null,"Error");
       }
       else
       {
           int id= Integer.parseInt(tablaAllPkm.getValueAt(fila,0).toString());
           controlador.getAllPokemonsInfo().dispose();
           controlador.getAllPokemonsAddType().dispose();
           controlador.getAllPokemonsAddTypeEvo().dispose();
           controlador.getAllPokemonsInfo().dispose();
           controlador.getAllPokemonsModifyEvolution().dispose();
           controlador.getNewAbilitie().dispose();
           controlador.getNewAbilitieEvo().dispose();
           controlador.getNewEvolution().dispose();
           controlador.getModelo().setAuxPokemon(controlador.getModelo().createPokemonObjectAll(id));
       } 
    }//GEN-LAST:event_tablaAllPkmMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAllPkm;
    // End of variables declaration//GEN-END:variables
}
