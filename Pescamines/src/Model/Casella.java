package Model;

/**
 *
 * @author David
 */
public class Casella{

    //private char cassella;
    private int nMines;
    private boolean esMina;
    private boolean descoberta;
    private boolean marcada;

    public Casella() {
        nMines = 0;
        esMina = false;
        descoberta = false;
        marcada = false;
    }

    public int getnMines() {
        return nMines;
    }

    public void setnMines(int nMines) {
        this.nMines = nMines;
    }

    public boolean getEsMina() {
        return esMina;
    }

    public void setEsMina(boolean esMina) {
        this.esMina = esMina;
    }

    public boolean getDescoberta() {
        return descoberta;
    }

    public void setDescoberta(boolean descoberta) {
        this.descoberta = descoberta;
    }

    public boolean getMarcada() {
        return marcada;
    }

    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
    }

    @Override
    public String toString() {

        if (marcada) {
            return "*";
        } else if (esMina) {
            return "#";
        } else if (!descoberta) {
            if(nMines != 0)
            return Integer.toString(nMines);
            else return "";
        } else {
            return ".";
        }

    }

}
