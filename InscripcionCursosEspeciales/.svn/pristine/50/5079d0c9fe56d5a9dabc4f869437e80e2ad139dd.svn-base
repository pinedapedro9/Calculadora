package co.edu.javerianacali.controllers;

import co.edu.javerianacali.entities.TblConfiguracion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author afgomez
 */
public class ConfiguracionLdap {

    public String INITIAL_CONTEXT_FACTORY;
    public String PROVIDER_URL;
    public String SECURITY_AUTHENTICATION;
    public String SECURITY_PRINCIPAL;
    public String ANSWER;

    /**
     * Creates a new instance of ConfiguracionLdap
     */
    public ConfiguracionLdap(String pUser, List lis) {

        List l = lis;
        try {

            TblConfiguracion f0 = (TblConfiguracion) l.get(0);
            this.INITIAL_CONTEXT_FACTORY = f0.getVcValor();
            TblConfiguracion f1 = (TblConfiguracion) l.get(1);
            this.PROVIDER_URL = f1.getVcValor();
            TblConfiguracion f2 = (TblConfiguracion) l.get(2);
            this.SECURITY_AUTHENTICATION = f2.getVcValor();
            TblConfiguracion f3 = (TblConfiguracion) l.get(3);
            this.SECURITY_PRINCIPAL = f3.getVcValor();
            TblConfiguracion f4 = (TblConfiguracion) l.get(4);
            this.ANSWER = f4.getVcValor();

            this.ANSWER = this.ANSWER.substring(0, 3) + pUser + this.ANSWER.substring(10);
        } catch (Exception e) {
            Logger.getLogger(ConfiguracionLdap.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
