package Controlador;

import Vista.Partida;
import javax.swing.JOptionPane;

/**
 *
 * @author nesgon
 */
public class CtrlPartida implements java.io.Serializable {

    public static Partida partida;

    public CtrlPartida(int row, int col, int nm) {
        this.partida = new Partida(row, col, nm);
        partida.setVisible(true);
    }
    
    
        
    public static void mina() {
        JOptionPane.showMessageDialog(partida, partida);
                
    }
    
}
