/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javerianacali.controllers;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author afgomez
 */
public class Configuration {
    
     Properties properties = null;

    /** Configuration file name */
//    public final static String CONFIG_FILE_NAME = "/com/puj/config/config.properties";
    /** Data base server */
    public final static String DATABASE_URL = "ProjectDataSource.url";

    /** Data base driver */
    public final static String DATABASE_DRIVER = "ProjectDataSource.driverClassName";

    /** Data base user */
    public final static String DATABASE_USER = "ProjectDataSource.username";

    /** Data base password */
    public final static String DATABASE_PSWD = "ProjectDataSource.password";

    /** Mail User */
    public final static String MAIL_USER = "ProjectDataSource.email_user";

    /** Mail User */
    public final static String MAIL_PASSWORD = "ProjectDataSource.email_pwd";
    public final static String MAIL_HOST = "ProjectDataSource.email_host";
    public final static String MAIL_PORT = "ProjectDataSource.email_port";
    
    public final static String MAIL_REQUERIMIENTOS = "ProjectDataSource.email_requerimientos";
    
    
    /*
    public Configuration() throws IOException {
        
        
        String fileSeparator =System.getProperty("file.separator");  
        String rutaConfiguracion = Path.ruta + fileSeparator+"com"+fileSeparator+"puj"+fileSeparator+"config"+fileSeparator+"config.properties";
        
        this.properties = new Properties();
        properties.load(new java.io.FileInputStream(rutaConfiguracion));
    }*/
    
    
    public Configuration(String rutaConfiguracion) throws IOException {
        
        this.properties = new Properties();
        
        this.properties = new Properties();
        properties.load(new java.io.FileInputStream(rutaConfiguracion));
        //properties.load(Configuration.class.getClassLoader().getResourceAsStream(rutaConfiguracion));
    }



    /**
     * Retorna la propiedad de configuracion solicitada
     *
     * @param key
     * @return
     */
    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }//getProperty
    
}
