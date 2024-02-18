package presentation;

import Exceptions.NombreNegatifException;
import metier.EntierNaturel;

public class main {
    public static void main(String[] args) {
        EntierNaturel entierNaturel = new EntierNaturel();
        try {
            entierNaturel.setVal(-2);
            entierNaturel.decremente();
        } catch (NombreNegatifException e) {
            System.out.println(e.getMessage());
        }
    }
}
