/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javerianacali.entities;

/**
 *
 * @author afgomez
 */
public class CursoPeopleSoft {

    String usuario;
    String codigoCurso;
    String nombreCurso;
    String grupo;
    String tipoCurso;
    int idCurso;
    String copiaContenido;
    String copiaContenidoAnterior;
    String periodo;
    private boolean solicitudManual;

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the codigoCurso
     */
    public String getCodigoCurso() {
        return codigoCurso;
    }

    /**
     * @param codigoCurso the codigoCurso to set
     */
    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    /**
     * @return the nombreCurso
     */
    public String getNombreCurso() {
        return nombreCurso;
    }

    /**
     * @param nombreCurso the nombreCurso to set
     */
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    /**
     * @return the grupo
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the tipoCurso
     */
    public String getTipoCurso() {
        return tipoCurso;
    }

    /**
     * @param tipoCurso the tipoCurso to set
     */
    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    /**
     * @return the idCurso
     */
    public int getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCopiaContenido() {
        return copiaContenido;
    }

    public void setCopiaContenido(String copiaContenido) {

        this.copiaContenido = copiaContenido;
    }

    public String getCopiaContenidoAnterior() {
        return copiaContenidoAnterior;
    }

    public void setCopiaContenidoAnterior(String copiaContenidoAnterior) {

        this.copiaContenidoAnterior = copiaContenidoAnterior;
    }

    /**
     * @return the solicitudManual
     */
    public boolean isSolicitudManual() {
        return solicitudManual;
    }
    
    public boolean getSolicitudManual() {
        return solicitudManual;
    }

    /**
     * @param solicitudManual the solicitudManual to set
     */
    public void setSolicitudManual(boolean solicitudManual) {
        this.solicitudManual = solicitudManual;
    }
}
