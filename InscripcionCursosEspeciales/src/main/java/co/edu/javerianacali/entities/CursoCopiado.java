/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javerianacali.entities;

/**
 *
 * @author afgomez
 */
public class CursoCopiado {

    String catalog_nbr;
    String sesion;
    String periodo;
    String crse_id_template;

    public void setCatalog_nbr(String catalog_nbr) {
        this.catalog_nbr = catalog_nbr;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setCrse_id_template(String crse_id_template) {
        this.crse_id_template = crse_id_template;
    }

    public String getCatalog_nbr() {
        return catalog_nbr;
    }

    public String getSesion() {
        return sesion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getCrse_id_template() {
        return crse_id_template;
    }
}
