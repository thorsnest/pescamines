package Model;

import Controlador.CtrlPartida;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author nesgon
 */
public class Casella2 extends javax.swing.JButton {

    int ubiX;
    int ubiY;
    boolean destapat;

    public Casella2(int ubiX, int ubiY) {
        this.ubiX = ubiX;
        this.ubiY = ubiY;
        this.destapat = false;
    }

    public int getUbiX() {
        return ubiX;
    }

    public int getUbiY() {
        return ubiY;
    }

    public void setDestapat(boolean destapat) {
        this.destapat = destapat;

    }

    public String ubiToString() {
        return ubiX + " " + ubiY;
    }

    public void descobreixTauler(JPanel tauler, Tauler t, int x, int y) {

        String ubi = t.trobaCasella(this.ubiX, this.ubiY);

        escriuCasella(ubi);

//        Es comprova que la casella no es una mina, no esta marcada y no te bombes adjacents
        if (!t.trobaCasella(this.ubiX, this.ubiY).equals("#") && !t.trobaCasella(this.ubiX, this.ubiY).equals("*") && t.trobaCasella(this.ubiX, this.ubiY).equals("") && !this.destapat) {

            this.setDestapat(true);
            t.descoberta(x - 1, y - 1);
//        Es comproven a les caselles envoltades 
            for (int k = this.getUbiX() - 1; k <= this.getUbiX() + 1; k++) {
                for (int l = this.getUbiY() - 1; l <= this.getUbiY() + 1; l++) {
                    if (k >= 0 && l >= 0 && k < x && l < y) {
                        for (Component c : tauler.getComponents()) {
                            if (((Casella2) c).getUbiX() == k && ((Casella2) c).getUbiY() == l && !((Casella2) c).destapat) {
                                ((Casella2) c).descobreixTauler(tauler, t, x, y);
                            }
                        }
                    }
                }
            }
        }
    }

    public void descobreixCasella(JPanel tauler, Tauler t, int x, int y) {
        String ubi = t.trobaCasella(this.ubiX, this.ubiY);
        if (ubi.equals("")) {
            this.descobreixTauler(tauler, t, x, y);
        } else if (ubi.equals("#")) {
            CtrlPartida.mina();
        } else {
            this.setText(ubi);
        }
        escriuCasella(ubi);
        this.setDestapat(true);
        t.descoberta(x - 1, y - 1);
        System.out.println(this.getText());
    }

    private void escriuCasella(String ubi) {
        switch (ubi) {
            case "1" ->
                this.setBackground(Color.GREEN);
            case "2" ->
                this.setBackground(Color.YELLOW);
            case "3" ->
                this.setBackground(Color.ORANGE);
            case "4" ->
                this.setBackground(Color.PINK);
            case "5" ->
                this.setBackground(Color.RED);
            case "6" ->
                this.setBackground(Color.MAGENTA);
            case "7" ->
                this.setBackground(Color.CYAN);
            case "8" ->
                this.setBackground(Color.BLACK);
            default ->
                this.setBackground(Color.LIGHT_GRAY);
        }
        this.setText(ubi);
    }

}
