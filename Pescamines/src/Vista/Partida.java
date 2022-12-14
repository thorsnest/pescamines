package Vista;

import Model.Casella;
import Model.Casella2;
import Model.Tauler;
import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author nesgon
 */
public class Partida extends javax.swing.JFrame {

    static int x;
    static int y;
    static int nm;

    /**
     * Creates new form Partida
     *
     * @param x
     * @param y
     */
    public Partida(int x, int y, int nm) {
        initComponents();
        Partida.x = x;
        Partida.y = y;
        Partida.nm = nm;
        setTauler();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tauler = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tauler.setBackground(new java.awt.Color(255, 255, 255));
        tauler.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout taulerLayout = new javax.swing.GroupLayout(tauler);
        tauler.setLayout(taulerLayout);
        taulerLayout.setHorizontalGroup(
            taulerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        taulerLayout.setVerticalGroup(
            taulerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(tauler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(tauler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Partida(x, y, nm).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel tauler;
    // End of variables declaration//GEN-END:variables

    
    // En aquest m??tode agafem el JPanel i el configurem per que tingui una maquetaci?? de tipus graella on anirem ficant les caselles del tauler
    public void setTauler() {
        GridLayout gl = new java.awt.GridLayout(x, y);
        this.tauler.setLayout(gl);
        Tauler t = new Tauler(x, y, nm);
        for (int i = 0; i < Partida.x; i++) {
            for (int j = 0; j < Partida.y; j++) {
                Casella2 b = new Casella2(i, j);
                b.setMargin(new Insets(0, 0, 0, 0));
                b.addActionListener((java.awt.event.ActionEvent e) -> {
                    b.descobreixCasella(tauler, t, x, y);
                    t.toString();
                });
                b.setFocusable(false);
                tauler.add(b);
            }
        }
    }
}
