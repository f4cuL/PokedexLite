/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author facue
 */
public class allPokemonsInfo extends javax.swing.JInternalFrame {

    private Controlador controlador;

    public Controlador getControlador() {
        return controlador;
    }

    public JTable getTableModifyAbilities() {
        return tableModifyAbilities;
    }

    public void setTableModifyAbilities(JTable tableModifyAbilities) {
        this.tableModifyAbilities = tableModifyAbilities;
    }

    public JTable getTableModifyEvolution() {
        return tableModifyEvolution;
    }

    public void setTableModifyEvolution(JTable tableModifyEvolution) {
        this.tableModifyEvolution = tableModifyEvolution;
    }

    public JTable getTableModifyType() {
        return tableModifyType;
    }

    public void setTableModifyType(JTable tableModifyType) {
        this.tableModifyType = tableModifyType;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    /**
     * Creates new form allPokemonsInfo
     */
    public allPokemonsInfo() {
        initComponents();
    }

    public JLabel getLblNameModify() {
        return lblNameModify;
    }

    public void setLblNameModify(JLabel lblNameModify) {
        this.lblNameModify = lblNameModify;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableModifyEvolution = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableModifyAbilities = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableModifyType = new javax.swing.JTable();
        lblNameModify = new javax.swing.JLabel();
        btnAddType = new javax.swing.JButton();
        btnRemoveType = new javax.swing.JButton();
        txtNewName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnChangeName = new javax.swing.JButton();
        btnAddEvolution = new javax.swing.JButton();
        btnRemoveEvolution = new javax.swing.JButton();
        btnAddAbilitie = new javax.swing.JButton();
        btnRemoveAbi = new javax.swing.JButton();
        btnModifyEvolution = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Name:");

        jLabel2.setText("Type/s");

        jLabel3.setText("Evolution/s");

        jLabel4.setText("Abilities");

        tableModifyEvolution.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "LvlEvolve"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableModifyEvolution.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableModifyEvolutionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableModifyEvolution);
        if (tableModifyEvolution.getColumnModel().getColumnCount() > 0) {
            tableModifyEvolution.getColumnModel().getColumn(0).setResizable(false);
            tableModifyEvolution.getColumnModel().getColumn(1).setResizable(false);
        }

        tableModifyAbilities.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableModifyAbilities.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableModifyAbilitiesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableModifyAbilities);
        if (tableModifyAbilities.getColumnModel().getColumnCount() > 0) {
            tableModifyAbilities.getColumnModel().getColumn(0).setResizable(false);
        }

        tableModifyType.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableModifyType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableModifyTypeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableModifyType);
        if (tableModifyType.getColumnModel().getColumnCount() > 0) {
            tableModifyType.getColumnModel().getColumn(0).setResizable(false);
        }

        lblNameModify.setText("jLabel5");

        btnAddType.setText("Add type");
        btnAddType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTypeActionPerformed(evt);
            }
        });

        btnRemoveType.setText("Remove selected type");
        btnRemoveType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveTypeActionPerformed(evt);
            }
        });

        txtNewName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewNameActionPerformed(evt);
            }
        });

        jLabel5.setText("New name");

        btnChangeName.setText("Change name");
        btnChangeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeNameActionPerformed(evt);
            }
        });

        btnAddEvolution.setText("Add evolution");
        btnAddEvolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEvolutionActionPerformed(evt);
            }
        });

        btnRemoveEvolution.setText("Remove selected evolution");
        btnRemoveEvolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveEvolutionActionPerformed(evt);
            }
        });

        btnAddAbilitie.setText("Add abilitie");
        btnAddAbilitie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAbilitieActionPerformed(evt);
            }
        });

        btnRemoveAbi.setText("Remove selected abilitie");
        btnRemoveAbi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAbiActionPerformed(evt);
            }
        });

        btnModifyEvolution.setText("Modify selected evolution");
        btnModifyEvolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyEvolutionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRemoveType))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblNameModify)
                                        .addGap(79, 79, 79)
                                        .addComponent(jLabel5))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNewName)
                                    .addComponent(btnChangeName, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddEvolution)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemoveEvolution)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModifyEvolution))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddAbilitie)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemoveAbi)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNameModify)
                    .addComponent(txtNewName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChangeName)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddType)
                    .addComponent(btnRemoveType))
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddEvolution)
                    .addComponent(btnRemoveEvolution)
                    .addComponent(btnModifyEvolution))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAbilitie)
                    .addComponent(btnRemoveAbi))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTypeActionPerformed
        if (!controlador.getAllPokemonsAddType().isVisible())
        {
           controlador.getAllPokemonsAddType().setVisible(true);
           controlador.getModelo().btnTypes();
           controlador.getPrincipal().getDesktop().add(controlador.getAllPokemonsAddType(),0);
        }
    }//GEN-LAST:event_btnAddTypeActionPerformed

    private void btnRemoveTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveTypeActionPerformed
        if (controlador.getModelo().removeType(controlador.getModelo().getAuxType().getId()))
        {
            JOptionPane.showMessageDialog(null, "Deleted type");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btnRemoveTypeActionPerformed

    private void tableModifyTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableModifyTypeMouseClicked
    int fila = tableModifyType.getSelectedRow();
    if (fila==-1)
    {
        JOptionPane.showMessageDialog(null, "Error");
    }
    else
    {
        String name = tableModifyType.getValueAt(fila,0).toString();
        controlador.getModelo().setAuxType(controlador.getModelo().createTypeObject(name));
    }
    }//GEN-LAST:event_tableModifyTypeMouseClicked

    public JButton getBtnAddType() {
        return btnAddType;
    }

    public void setBtnAddType(JButton btnAddType) {
        this.btnAddType = btnAddType;
    }

    public JButton getBtnChangeName() {
        return btnChangeName;
    }

    public void setBtnChangeName(JButton btnChangeName) {
        this.btnChangeName = btnChangeName;
    }

    public JButton getBtnRemoveType() {
        return btnRemoveType;
    }

    public void setBtnRemoveType(JButton btnRemoveType) {
        this.btnRemoveType = btnRemoveType;
    }

    public JTextField getTxtNewName() {
        return txtNewName;
    }

    public void setTxtNewName(JTextField txtNewName) {
        this.txtNewName = txtNewName;
    }

    private void txtNewNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewNameActionPerformed

    }//GEN-LAST:event_txtNewNameActionPerformed

    private void btnChangeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeNameActionPerformed
        if (controlador.getModelo().changePokemonName(controlador.getModelo().getAuxPokemon().getId()))
        {
            JOptionPane.showMessageDialog(null, "Name changed");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btnChangeNameActionPerformed

    private void btnAddEvolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEvolutionActionPerformed
        if (!controlador.getNewEvolution().isVisible())
        {
            controlador.getNewEvolution().setVisible(true);
            controlador.getPrincipal().getDesktop().add(controlador.getNewEvolution(),0);
        }
    }//GEN-LAST:event_btnAddEvolutionActionPerformed

    private void tableModifyEvolutionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableModifyEvolutionMouseClicked
       int fila= tableModifyEvolution.getSelectedRow();
       if (fila==-1){
           JOptionPane.showMessageDialog(null,"Error");
       }
       else
       {      
          controlador.getModelo().setAuxEvo(controlador.getModelo().createObjectEvolution(tableModifyEvolution.getValueAt(fila,0).toString()));
          controlador.getNewEvolution().dispose();
          controlador.getAllPokemonsModifyEvolution().dispose();
        } 
    }//GEN-LAST:event_tableModifyEvolutionMouseClicked

    private void btnRemoveEvolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveEvolutionActionPerformed
        
        int idpkm=controlador.getModelo().getAuxPokemon().getId();
        int idevo=controlador.getModelo().getAuxEvo().getId();
        if (controlador.getModelo().removeEvolution(idevo, idpkm))
        {
            controlador.getModelo().removeDatabaseEvolution(idevo);
            JOptionPane.showMessageDialog(null, "Deleted");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btnRemoveEvolutionActionPerformed

    private void tableModifyAbilitiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableModifyAbilitiesMouseClicked
     int fila = tableModifyAbilities.getSelectedRow();
     if (fila==-1){
         JOptionPane.showMessageDialog(null, "Error");
     }
     else{
         controlador.getModelo().setAuxAbi(controlador.getModelo().createObjectAbilities(tableModifyAbilities.getValueAt(fila, 0).toString()));
         controlador.getNewAbilitie().dispose();
         
     }
    }//GEN-LAST:event_tableModifyAbilitiesMouseClicked

    public JButton getBtnAddAbilitie() {
        return btnAddAbilitie;
    }

    public void setBtnAddAbilitie(JButton btnAddAbilitie) {
        this.btnAddAbilitie = btnAddAbilitie;
    }

    public JButton getBtnAddEvolution() {
        return btnAddEvolution;
    }

    public void setBtnAddEvolution(JButton btnAddEvolution) {
        this.btnAddEvolution = btnAddEvolution;
    }

    public JButton getBtnRemoveAbi() {
        return btnRemoveAbi;
    }

    public void setBtnRemoveAbi(JButton btnRemoveAbi) {
        this.btnRemoveAbi = btnRemoveAbi;
    }

    public JButton getBtnRemoveEvolution() {
        return btnRemoveEvolution;
    }

    public void setBtnRemoveEvolution(JButton btnRemoveEvolution) {
        this.btnRemoveEvolution = btnRemoveEvolution;
    }

    private void btnAddAbilitieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAbilitieActionPerformed
        if(!controlador.getNewAbilitie().isVisible())
        {
            controlador.getNewAbilitie().setVisible(true);
            controlador.getPrincipal().getDesktop().add(controlador.getNewAbilitie(),0);
        }
    }//GEN-LAST:event_btnAddAbilitieActionPerformed

    private void btnRemoveAbiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAbiActionPerformed
       if (controlador.getModelo().removeAbilitie(controlador.getModelo().getAuxPokemon().getId(),controlador.getModelo().getAuxAbi().getId())){
           JOptionPane.showMessageDialog(null, "Deleted");
           controlador.getModelo().removeDatabaseAbilitie(controlador.getModelo().getAuxAbi().getId());
       }    
       else
       {
           JOptionPane.showMessageDialog(null, "Error");
       }
    }//GEN-LAST:event_btnRemoveAbiActionPerformed

    private void btnModifyEvolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyEvolutionActionPerformed
        controlador.getModelo().cargarTablaEvoType(controlador.getAllPokemonsModifyEvolution().getTableEvoType());
        controlador.getModelo().cargarTablaEvoAbilities(controlador.getAllPokemonsModifyEvolution().getTableAbilitiesEvo());
        if (!controlador.getAllPokemonsModifyEvolution().isVisible())
        {
            controlador.getAllPokemonsModifyEvolution().setVisible(true);
            controlador.getPrincipal().getDesktop().add(controlador.getAllPokemonsModifyEvolution(),0);
            controlador.getAllPokemonsModifyEvolution().getLblName().setText(controlador.getModelo().getAuxEvo().getName());
        }
    }//GEN-LAST:event_btnModifyEvolutionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAbilitie;
    private javax.swing.JButton btnAddEvolution;
    private javax.swing.JButton btnAddType;
    private javax.swing.JButton btnChangeName;
    private javax.swing.JButton btnModifyEvolution;
    private javax.swing.JButton btnRemoveAbi;
    private javax.swing.JButton btnRemoveEvolution;
    private javax.swing.JButton btnRemoveType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNameModify;
    private javax.swing.JTable tableModifyAbilities;
    private javax.swing.JTable tableModifyEvolution;
    private javax.swing.JTable tableModifyType;
    private javax.swing.JTextField txtNewName;
    // End of variables declaration//GEN-END:variables
}
