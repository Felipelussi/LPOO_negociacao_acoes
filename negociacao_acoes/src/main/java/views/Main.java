/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;
import com.mycompany.negociacao_acoes.dao.PersistenciaJPA;
import views.Usuarios;
/**
 *
 * @author felipe
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    PersistenciaJPA jpa;
    public Main() {
        jpa = new PersistenciaJPA();
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

        pnlAcoes = new javax.swing.JTabbedPane();
        views.Usuarios usuarios = new views.Usuarios(jpa);
        acoes1 = new views.Acoes(jpa);
        negocios1 = new views.Negocios(jpa);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlAcoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlAcoesMouseReleased(evt);
            }
        });

        usuarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usuariosFocusGained(evt);
            }
        });
        pnlAcoes.addTab("Usuários", usuarios);
        pnlAcoes.addTab("Acoes", acoes1);

        negocios1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                negocios1MouseReleased(evt);
            }
        });
        pnlAcoes.addTab("Negocios", negocios1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAcoes)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlAcoesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAcoesMouseReleased
       acoes1.carregarAcoes();
    }//GEN-LAST:event_pnlAcoesMouseReleased

    private void usuariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usuariosFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_usuariosFocusGained

    private void negocios1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_negocios1MouseReleased
       negocios1.carregarAcoes();
       negocios1.carregarParticipantes();
    }//GEN-LAST:event_negocios1MouseReleased

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private views.Acoes acoes1;
    private views.Negocios negocios1;
    private javax.swing.JTabbedPane pnlAcoes;
    // End of variables declaration//GEN-END:variables
}
