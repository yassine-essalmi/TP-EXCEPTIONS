package metier;

import Exceptions.NombreNegatifException;

public class EntierNaturel {

    private int val;

    public EntierNaturel(int val) throws NombreNegatifException {
            if (val < 0) {
                throw new NombreNegatifException("Nombre négatif");
            } else {
                this.val = val;
            }
    }

    public EntierNaturel() {
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) throws NombreNegatifException {
            if (val < 0) {
                throw new NombreNegatifException("Nombre négatif exception!!");
            } else {
                this.val = val;
                System.out.println("value setted to : " + val);
            }
    }

    public void decremente() throws NombreNegatifException {
            if (val < 0) {
                throw new NombreNegatifException("Nombre négatif exception!!");
            } else {
                val--;
                System.out.println("value decremented to : " + val--);
            }

    }
}
