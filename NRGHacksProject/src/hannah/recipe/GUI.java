/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hannah.recipe;
import javax.swing.*;

/**
 *
 * @author sarak
 */
public class GUI extends javax.swing.JFrame {
    
    private DefaultListModel recipeModel;
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        
        this.recipeModel = new DefaultListModel();
        initComponents();
        
        recipeModel = (DefaultListModel)recipeList.getModel();
        updateRecipes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rPanel = new hannah.recipe.recipePanel();
        recipescrollPane = new javax.swing.JScrollPane();
        recipeList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("recipeBook");
        setPreferredSize(new java.awt.Dimension(Const.WIDTH, Const.HEIGHT));
        setResizable(false);
        setSize(new java.awt.Dimension(Const.WIDTH, Const.HEIGHT));

        rPanel.setPreferredSize(new java.awt.Dimension(1000, 600));

        recipeList.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        recipeList.setModel(new DefaultListModel());
        recipeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        recipeList.setToolTipText("");
        recipeList.setAutoscrolls(false);
        recipeList.setPreferredSize(new java.awt.Dimension(Const.listWIDTH, Const.panelHEIGHT));
        recipeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                recipeListValueChanged(evt);
            }
        });
        recipescrollPane.setViewportView(recipeList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recipescrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                    .addComponent(recipescrollPane))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recipeListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_recipeListValueChanged
        // something in list changed, sets selected to index of selection 
        if (recipeList.hasFocus() && ! evt.getValueIsAdjusting()) {
            int selected = recipeList.getSelectedIndex();
            rPanel.updatePanel(selected);
        }
    }//GEN-LAST:event_recipeListValueChanged

    private void updateRecipes() {
        recipeModel.clear();
        recipeModel.addAll(rPanel.titles);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hannah.recipe.recipePanel rPanel;
    private javax.swing.JList<String> recipeList;
    private javax.swing.JScrollPane recipescrollPane;
    // End of variables declaration//GEN-END:variables
}
