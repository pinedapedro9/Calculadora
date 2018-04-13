/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javerianacali.controllers;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//import co.edu.javerianacali.email.EmailInfo;
//import co.edu.javerianacali.email.EmailSenderUtil;
//import co.edu.javerianacali.email.EmailServer;

/**
 *
 * @author afgomez
 */
public class CorreoRequerimiento {

    String correoRequerimientos;
    String claveCorreoRemitente;
    String servidorCorreo;
    int puerto;
  //  EmailServer smtp;

    private void configEnvio(HttpServletRequest request) throws IOException {
        Configuration configuration;

        HttpServletRequestWrapper srw = new HttpServletRequestWrapper(request);
        String ruta = srw.getRealPath("");
        ruta += "/WEB-INF/appServlet/jdbc.properties";
        
        configuration = new Configuration(ruta);


        this.correoRequerimientos = configuration.getProperty(Configuration.MAIL_REQUERIMIENTOS);
        this.claveCorreoRemitente = configuration.getProperty(Configuration.MAIL_PASSWORD);
        this.servidorCorreo = configuration.getProperty(Configuration.MAIL_HOST);
        this.puerto = Integer.parseInt(configuration.getProperty(Configuration.MAIL_PORT));
        if (this.servidorCorreo.equals("correos.javerianacali.edu.co"))
        	;//this.smtp = EmailServer.CORREOS;
        //else
        	//this.smtp = EmailServer.TEST;
    }

    public void enviarCorreo(HttpServletRequest request, String mensaje, String asunto, String emailUsuario) throws MessagingException, IOException {

        
        //---inicia envio de correo electronico 
        
        configEnvio(request);

        
        /*EmailInfo info = new EmailInfo();
        info.setHTML(true);
        info.setFrom(emailUsuario);
        info.setTo(correoRequerimientos);
        info.setSubject(asunto);

        info.setText(mensaje);

        EmailSenderUtil.EnviarEmail(info, this.smtp);*/


        //--termina envio de correo electronico 

    }
}
