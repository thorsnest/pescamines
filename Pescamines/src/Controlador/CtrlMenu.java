package Controlador;

import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nesgon
 */
public class CtrlMenu implements ActionListener{
    Menu m;

    public CtrlMenu() {
        m = new Menu();
        m.getMostrarButton().addActionListener(this);
    }
    
    public void run() {
        m.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("")){
            
        }
        
    }
    
}
