/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javerianacali.entities;

import java.util.Vector;

/**
 *
 * @author afgomez
 */
public class Fila {

    private Vector fila;

    /**
     * Creates a new instance of Fila
     */
    public Fila() {
        fila = new Vector();
    }

    public void adicionar(String pAtributo, String pValor) {
        AtributoValor av = new AtributoValor(pAtributo, pValor);
        getFila().addElement(av);
    }

    // retorna error si no encontro 
    public String getValor(String pAtributo) throws Exception {
        for (int i = 0; i < getFila().size(); i++) {
            AtributoValor av = (AtributoValor) getFila().elementAt(i);
            if (av.getAtributo().equals(pAtributo)) {
                return av.getValor();
            }
        }
        throw new Exception("Fila.getValor: No se encontro el atributo " + pAtributo);
    }

    public String getValor(int idAtributo) {
        return ((AtributoValor) getFila().elementAt(idAtributo)).valor;
    }

    public int size() {
        return getFila().size();
    }

    public AtributoValor getAtributoValor(int pIndex) throws Exception {
        if (pIndex >= getFila().size()) {
            throw new Exception("Fila.getAtributoValor: index mayor al total del vector. " + pIndex + ":" + getFila().size());
        }
        AtributoValor av = (AtributoValor) getFila().elementAt(pIndex);
        return av;

    }

    public AtributoValor getAtributoValor(String pAtributo) throws Exception {
        for (int i = 0; i < this.getFila().size(); i++) {
            AtributoValor av = (AtributoValor) getFila().elementAt(i);
            if (av.getAtributo().equals(pAtributo)) {
                return av;
            }

        }
        throw new Exception("Fila.getAtributoValor(pAtributo): No se encontro el atributo " + pAtributo);
    }

    public String toString() {
        String s = null;
        for (int i = 0; i < getFila().size(); i++) {
            AtributoValor av = (AtributoValor) getFila().elementAt(i);
            if (s == null) {
                s = " " + av.getAtributo() + ":" + av.getValor();
            } else {
                s += " " + av.getAtributo() + ":" + av.getValor();
            }
        }
        return s;
    }

    /**
     * @return the fila
     */
    public Vector getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(Vector fila) {
        this.fila = fila;
    }
}
