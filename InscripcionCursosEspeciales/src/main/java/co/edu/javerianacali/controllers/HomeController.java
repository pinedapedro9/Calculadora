package co.edu.javerianacali.controllers;

//import co.edu.javerianacali.email.EmailSenderUtil;
import co.edu.javerianacali.entities.CursoPeopleSoft;
import co.edu.javerianacali.entities.Parametro;
import co.edu.javerianacali.entities.Periodo;
import co.edu.javerianacali.entities.Profesor;
import co.edu.javerianacali.interfaces.services.IConsultaService;
import co.edu.javerianacali.interfaces.services.IExcelService;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

    @Autowired
    IConsultaService consultaService;
    @Autowired
    IExcelService excelService;
  //  EmailSenderUtil despachadorCorreo;
    @Autowired
    HttpSession sesion;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("mensaje", "");
        
        return mav;
    }

    @RequestMapping(value = "/ingreso", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request) {
        @SuppressWarnings("unused")
        String usuario = request.getParameter("campo_usuario");
        String pass = request.getParameter("campo_password");
        ModelAndView mav = new ModelAndView();
        boolean autenticado;

        if (usuario.length() == 0 || pass.length() == 0) {
            mav.addObject("mensaje", "Datos Incompletos");
            mav.setViewName("index");
            return mav;
         }
         try {
             List listaLDAP = consultaService.getParametrosLDAP();
             if(usuario.equals("orlando.arcos") || usuario.equals("ptoro") || usuario.equals("angelapaz") || usuario.equals("adrianamorales") || usuario.equals("miguzman") || usuario.equals("mfortiz")|| usuario.equals("yennifer")|| usuario.equals("mivelasquez")|| usuario.equals("luis.echeverri")|| usuario.equals("cpbolanos") || usuario.equals("yoana.perdomo")|| usuario.equals("wilson.gomez") || usuario.equals("albap") || usuario.equals("cvvelasco") || usuario.equals("mfrobles"))
             {
                 autenticado = autenticarLDAP(usuario, pass, listaLDAP);
                 sesion = request.getSession(true);
                 sesion.setAttribute("usuario", usuario);
                 sesion.setMaxInactiveInterval(1800); //la sesion expira en 30 minutos
                 mav=consulta(request);
             }
             else{
                mav.addObject("mensaje", "Usuario o clave incorrecta"); 
                mav.setViewName("index");
                return mav;
             }
             return mav;
             
        }catch (AuthenticationException ae) {
             mav.addObject("mensaje", "Usuario o clave incorrecta");
             mav.setViewName("index");
             return mav;
         } catch (NamingException NEx){
             mav.addObject("mensaje", "Usuario o clave incorrecta");
             mav.setViewName("index");
             return mav;
         } catch (Exception e){
             mav.addObject("mensaje", "Error desconocido.");
             mav.addObject("isError", true);
             mav.setViewName("error");
             return mav;
         }
     }
    
    @RequestMapping(value = "/consulta", method = RequestMethod.POST)
    public ModelAndView consulta(HttpServletRequest request) {
        @SuppressWarnings("unused")
        ModelAndView mav = new ModelAndView();
       
        List listaPeriodo = consultaService.getPeriodoActual();
        Periodo per = (Periodo) listaPeriodo.get(0); //siempre devuelve una sola fila en la que esta el periodo actual
        String periodo = per.getPeriodo();
        mav.addObject("periodo", periodo);
        mav.setViewName("filtro");
        return mav;

    }  
    
     @RequestMapping(value = "/paso1", method = RequestMethod.POST)
     public ModelAndView filtro(HttpServletRequest request)//se realiza la consulta por usuario del profesor y se envia la lista de profesores en este caso devuelve solo un registro, a metodo de filtro
     {
          try {
             @SuppressWarnings("unused")
                String Usuario = request.getParameter("campo_usuario");
                String Consulta = request.getParameter("selCombo");
                //System.out.println("consulta:"+Consulta);                 
                ModelAndView mav= new ModelAndView();
                List profesores = new ArrayList();
                List CursoEnPeople = new ArrayList();
                List listaPeriodo = consultaService.getPeriodoActual();
                Periodo per = (Periodo) listaPeriodo.get(0); //siempre devuelve una sola fila en la que esta el periodo actual
                String periodo = per.getStrm();
                
                if(Consulta.equals("Seleccione"))
                {
                    mav.addObject("mensaje", "Debe seleccionar el tipo de busqueda");
                    mav.setViewName("filtro");
                    return mav;
                }
                
                else if(Consulta.equals("Usuario"))
                {
                    if(Usuario.equals(""))
                    {
                       mav.addObject("mensaje", "Debe ingresar el usuario del profesor");
                       mav.setViewName("filtro");
                       return mav;
                    }
                     else{
                        System.out.println("encontro usuario:");  
                         profesores=consultaService.getCursosNombreCorreoDeProfesor(Usuario);
                      
                         if(profesores.size()!=0)
                             {
                                sesion.setAttribute("usuarioUsu", Usuario);
                                sesion.setAttribute("profesores", profesores);
                                mav=paso1(request);
                        //System.out.println("entrooo if");
                             }else
                            {
                               mav.addObject("mensaje", "Usuario incorrecto o no existe");
                               mav.setViewName("filtro");
                               return mav;
                            }
                        } 
                }
                else if(Consulta.equals("Catalogo"))
                {
                    String catalogo=request.getParameter("campo_usuario");
                    
                    if(catalogo.equals(""))
                    {
                        mav.addObject("mensaje", "Debe ingresar el catalogo del curso");
                        mav.setViewName("filtro");
                        return mav;
                    }
                     
                    else{
                        profesores=consultaService.getCursosExistePeople(periodo, catalogo);
                        System.out.println("tam:"+CursoEnPeople.size()); 
                        if(profesores.size()!=0)
                        {
                          //sesion.setAttribute("usuario", Usuario);
                          sesion.setAttribute("profesores", profesores);
                          sesion.setAttribute("catalogo", catalogo);
                          mav=paso1C(request);
                          return mav;
                        }

                            else{
                                 mav.addObject("mensaje", "Curso incorrecto o no existe");
                                 mav.setViewName("filtro");
                                 return mav;
                             }
                        }                   
                }
                
                 return mav;
                
             
         }  catch (Exception e) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("mensaje", "La sesi�n ha expirado, intentelo de nuevo en filtro.");
            mav.addObject("isError", true);
            mav.setViewName("error");
            return mav;
        }
        
     }

    @RequestMapping(value = "/paso", method = RequestMethod.POST)
    public ModelAndView paso1(HttpServletRequest request) {
        try {
            @SuppressWarnings("unused")
            String usuario = (String) sesion.getAttribute("usuarioUsu");
            List profesores= (List) sesion.getAttribute("profesores");
            
            List listaPeriodo = consultaService.getPeriodoActual();
           

            Periodo per = (Periodo) listaPeriodo.get(0); //siempre devuelve una sola fila en la que esta el periodo actual

            String periodo = per.getStrm();
            String descPeriodo = per.getPeriodo();
            
            System.out.println("Periodo actual:"+descPeriodo);
            
            List cursos = consultaService.getCursosProfesorEnUnPeriodo(periodo, usuario);
            List cursosSinDuplicados = new ArrayList();
            List cursosYaSolicitados = new ArrayList();

            //se inserta en cursosSinDuplicados si no esta en la tabla cursos_origen una fila con el mismo codigo, perioodo y grupo

            for (int i = 0; i < cursos.size(); i++) {
                CursoPeopleSoft cur = (CursoPeopleSoft) cursos.get(i);
                String codigo = cur.getCodigoCurso();
                String grupo = cur.getGrupo();
                List cursosCopiados = consultaService.getCursosCopiadosPorCodigo(codigo, periodo, grupo);
                if (cursosCopiados.size() == 0) {
                    cursosSinDuplicados.add(cur);
                }else{
                    cursosYaSolicitados.add(cur);
                }

            }

            int numeroCursos = cursosSinDuplicados.size() + cursosYaSolicitados.size();

            sesion.setAttribute("periodo", periodo);
            sesion.setAttribute("descPeriodo", descPeriodo);
            sesion.setAttribute("cursos", cursosSinDuplicados);

            ModelAndView mav = new ModelAndView();

            if (numeroCursos > 0) {
                mav.setViewName("paso01");
                mav.addObject("usuario", usuario);
                mav.addObject("cursos", numeroCursos);
                mav.addObject("periodo", descPeriodo);
                mav.addObject("listaCursos", cursosSinDuplicados);
                mav.addObject("profesores", profesores);
                mav.addObject("cursosYaSolicitados", cursosYaSolicitados);
            } else {
                String mensaje = "<div class='Titulos'>El usuario " + usuario + " no tiene cursos asignados en registro acad�mico para el periodo " + descPeriodo + ".</div><br />";
                mensaje += "<div class='contenidos'>Para mayor informaci�n comun�quese con Javevirtual <br />Tel. 3218200 ext. 8490 <br />Correo javevirtual@javerianacali.edu.co</div>";
                mav.addObject("mensaje", mensaje);
                mav.addObject("isError", false);
                mav.setViewName("error");
                

            }
            return mav;

        } catch (IllegalStateException e) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("mensaje", "La sesi�n ha expirado, intentelo de nuevo.");
            mav.addObject("isError", true);
            mav.setViewName("error");
            return mav;
        }
    }
    
    
    @RequestMapping(value = "/paso1C", method = RequestMethod.POST)
    public ModelAndView paso1C(HttpServletRequest request) {
        try {
            @SuppressWarnings("unused")
            String catalogo = (String) sesion.getAttribute("catalogo");
            List profesores= (List) sesion.getAttribute("profesores");
            
            List listaPeriodo = consultaService.getPeriodoActual();
           

            Periodo per = (Periodo) listaPeriodo.get(0); //siempre devuelve una sola fila en la que esta el periodo actual

            String periodo = per.getStrm();
            String descPeriodo = per.getPeriodo();
            
            System.out.println("Periodo actual:"+descPeriodo);
            
            List cursos = consultaService.getCursosPorCatalogo(periodo, catalogo);
            List cursosSinDuplicados = new ArrayList();
            List cursosYaSolicitados = new ArrayList();

            //se inserta en cursosSinDuplicados si no esta en la tabla cursos_origen una fila con el mismo codigo, perioodo y grupo

            for (int i = 0; i < cursos.size(); i++) {
                CursoPeopleSoft cur = (CursoPeopleSoft) cursos.get(i);
                String codigo = cur.getCodigoCurso();
                String grupo = cur.getGrupo();
                List cursosCopiados = consultaService.getCursosCopiadosPorCodigo(codigo, periodo, grupo);
                if (cursosCopiados.size() == 0) {
                    cursosSinDuplicados.add(cur);
                }else{
                    cursosYaSolicitados.add(cur);
                }

            }

            int numeroCursos = cursosSinDuplicados.size() + cursosYaSolicitados.size();

            sesion.setAttribute("periodo", periodo);
            sesion.setAttribute("descPeriodo", descPeriodo);
            sesion.setAttribute("cursos", cursosSinDuplicados);

            ModelAndView mav = new ModelAndView();

            if (numeroCursos > 0) {
                mav.setViewName("paso01C");
                mav.addObject("cursos", numeroCursos);
                mav.addObject("periodo", descPeriodo);
                mav.addObject("listaCursos", cursosSinDuplicados);
                mav.addObject("profesores", profesores);
                mav.addObject("cursosYaSolicitados", cursosYaSolicitados);
            } else {
                String mensaje = "<div class='Titulos'>El usuario  no tiene cursos asignados en registro acad�mico para el periodo " + descPeriodo + ".</div><br />";
                mensaje += "<div class='contenidos'>Para mayor informaci�n comun�quese con Javevirtual <br />Tel. 3218200 ext. 8490 <br />Correo javevirtual@javerianacali.edu.co</div>";
                mav.addObject("mensaje", mensaje);
                mav.addObject("isError", false);
                mav.setViewName("error");
                

            }
            return mav;

        } catch (IllegalStateException e) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("mensaje", "La sesi�n ha expirado, intentelo de nuevo.");
            mav.addObject("isError", true);
            mav.setViewName("error");
            return mav;
        }
    }
    
    @RequestMapping(value = "/paso2", method = RequestMethod.POST)
    public ModelAndView paso2(HttpServletRequest request) {
        try {
            @SuppressWarnings("unused")
            ModelAndView mav = new ModelAndView();
            List cursos = (List) sesion.getAttribute("cursos");
            String descPeriodo = (String) sesion.getAttribute("descPeriodo");
            List cursosCopiar = new ArrayList();

            try {
                String[] elegidos = request.getParameterValues("checkCopiar");

                for (int i = 0; i < elegidos.length; i++) {
                    int indice = Integer.parseInt(elegidos[i]);
                    cursosCopiar.add(cursos.get(indice));
                }
                sesion.setAttribute("cursosCopia", cursosCopiar);

                mav.setViewName("paso02");
                mav.addObject("listaCursos", cursosCopiar);
                mav.addObject("periodo", descPeriodo);
            } catch (Exception e) {
                mav.setViewName("error");
                mav.addObject("isError", true);
                mav.addObject("mensaje", "No eligi� ning�n curso.");                
            }
            return mav;
        } catch (IllegalStateException e) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("mensaje", "La sesi�n ha expirado, int�ntelo de nuevo.");
            mav.addObject("isError", true);
            mav.setViewName("error");
            return mav;
        }
    }
    
    @RequestMapping(value = "/paso3", method = RequestMethod.POST)
    public ModelAndView paso3(HttpServletRequest request) {
        try {
            @SuppressWarnings("unused")
            List<CursoPeopleSoft> cursosCopia = (List<CursoPeopleSoft>) sesion.getAttribute("cursosCopia");
            String descPeriodo = (String) sesion.getAttribute("descPeriodo");
            String usuario = (String) sesion.getAttribute("usuarioUsu");
            boolean solicitudesManuales = false;
            
            List<CursoPeopleSoft> cursosCopiaContenido = new ArrayList<CursoPeopleSoft>();

            for (int i = 0; i < cursosCopia.size(); i++) {
                String aux = request.getParameter("radio" + i);
                CursoPeopleSoft curso = (CursoPeopleSoft) cursosCopia.get(i);
                if (aux.equals("si" + i)) {
                    curso.setCopiaContenido("Si");
                    String codigo = curso.getCodigoCurso();
                    curso.setCopiaContenidoAnterior(excelService.getPlantillaDeExcel(request, usuario, codigo));
                    if(curso.getCopiaContenidoAnterior().equals("plantilla")){
                        solicitudesManuales=true;
                        curso.setSolicitudManual(solicitudesManuales);
                    }
                } else {
                    curso.setCopiaContenido("No");
                    curso.setSolicitudManual(false);
                }
                cursosCopiaContenido.add(curso);

            }
            sesion.setAttribute("cursosCopiaContenido", cursosCopiaContenido);
            

            ModelAndView mav = new ModelAndView();

            mav.setViewName("paso03");
            mav.addObject("listaCursos", cursosCopiaContenido);
            mav.addObject("periodo", descPeriodo);
            mav.addObject("solicitudesManuales", solicitudesManuales);
            

            return mav;

        } catch (IllegalStateException e) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("mensaje", "La sesi�n ha expirado, int�ntelo de nuevo.");
            mav.addObject("isError", true);
            mav.setViewName("error");
            return mav;
        }


    }

    @RequestMapping(value = "/enviar", method = RequestMethod.POST)
    public ModelAndView enviar(HttpServletRequest request) {
        try {
            @SuppressWarnings("unused")
            String usuario = (String) sesion.getAttribute("usuario");
            List<CursoPeopleSoft> cursosCopiaContenido = (List<CursoPeopleSoft>) sesion.getAttribute("cursosCopiaContenido");
            String observaciones = request.getParameter("observaciones");
            sesion.setAttribute("observaciones", observaciones);
            String periodo = (String) sesion.getAttribute("periodo");

            String plantilla = "";

            ModelAndView mav = new ModelAndView();

            try {
                for (int i = 0; i < cursosCopiaContenido.size(); i++) {
                    CursoPeopleSoft curso = (CursoPeopleSoft) cursosCopiaContenido.get(i);
                    String codigo = curso.getCodigoCurso();
                    String grupo = curso.getGrupo();

                    if (curso.getCopiaContenido().equals("No")) {
                        plantilla = "plantilla";
                    } else {

                        plantilla = curso.getCopiaContenidoAnterior();
                    }

                    consultaService.insertCopiaCurso(codigo, grupo, periodo, plantilla);
                }
            } catch (Exception e) {
                mav.addObject("mensaje", "Ha ocurrido un error en la copia de cursos.");
                mav.addObject("isError", true);
                mav.setViewName("error");
                return mav;
            }

            String asunto, correoProfe, nombreProfe, correoAlternativo;
            StringBuffer mensaje;
            
            try {
                
                CorreoRequerimiento correo = new CorreoRequerimiento();
                
                correoProfe = usuario+"@javerianacali.edu.co";
                correoAlternativo = request.getParameter("correoAlterno");
                nombreProfe = (String) sesion.getAttribute("nombreProfe");
                asunto="Inscripcion de Cursos De Blackboard";

                mensaje = new StringBuffer("<html><body>");
                mensaje.append("Nombre: ").append(nombreProfe).append(" <br />");
                mensaje.append("Correo: ").append(correoProfe).append(" <br />");
                if(correoAlternativo!=null&& !correoAlternativo.equals("")) {
                    mensaje.append("Correo Alternativo: ").append(correoAlternativo).append(" <br />");
                }
                mensaje.append("<br /><br />");
                for (int i = 0; i < cursosCopiaContenido.size(); i++) {
                    CursoPeopleSoft curso = (CursoPeopleSoft) cursosCopiaContenido.get(i);
                    mensaje.append("Curso: ").append(curso.getNombreCurso()).append(" <br />");
                    mensaje.append("Codigo: ").append(curso.getCodigoCurso()).append(" <br />");
                    mensaje.append("Grupo: ").append(curso.getGrupo()).append(" <br />");
                    mensaje.append("Con copia: ").append(curso.getCopiaContenido()).append(" <br />");
                    if(curso.isSolicitudManual()){
                        mensaje.append("Realizar copia manual: ").append("Si").append(" <br />");
                    }
                    mensaje.append("<br /><br />");
                }
                mensaje.append("Observaciones: ").append(observaciones).append(" <br />");
                mensaje.append("</body></html>");

                correo.enviarCorreo(request, mensaje.toString(), asunto, correoProfe);

            } catch (Exception e) {
                mav.addObject("mensaje", "Se ha insertado el curso pero ha ocurrido un error en la creación del requerimiento");
                
                mav.addObject("isError", false);
                mav.setViewName("error");


                String usu = (String) sesion.getAttribute("usuario");
                String nombre = (String) sesion.getAttribute("nombreProfe");
                String correo = (String) sesion.getAttribute("correoProfe");

                HttpServletRequestWrapper srw = new HttpServletRequestWrapper(request);
                String nombreArchivo = srw.getRealPath("");
                nombreArchivo += "/resources/archivos/ErroresEnvioCorreo.txt";

                //escritura en el txt en caso de error
                try {
                    FileWriter fichero = new FileWriter(nombreArchivo, true);

                    fichero.append("-----------------------\r\n");

                    fichero.append("No se pudo enviar correo de la solicitud de copia de cursos: \r\n");
                    fichero.append("Nombre de usuario: " + usu + "\r\n");
                    fichero.append("Nombre: " + nombre + "\r\n");
                    fichero.append("Correo: " + correo + "\r\n");

                    fichero.close();

                } catch (Exception ex) {
                    
                    ex.printStackTrace();
                }
               
                return mav;
            }
            mav.setViewName("exito");
            return mav;
        } catch (IllegalStateException e) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("mensaje", "La sesi�n ha expirado, int�ntelo de nuevo.");
            mav.addObject("isError", true);
            mav.setViewName("error");
            return mav;
        }


    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView cerrar(HttpServletRequest request) {
        
        ModelAndView mav = new ModelAndView();
        
        try {
            sesion.invalidate();
        } catch (IllegalStateException e) {
            mav.addObject("mensaje", "!");
        }
        
        mav.setViewName("index");
        return mav;
    }
    
    @RequestMapping(value = "/continuar", method = RequestMethod.POST)
    public ModelAndView Continuar(HttpServletRequest request)
    {
        try {
             ModelAndView mav = new ModelAndView();
             mav.addObject("mensaje", "");
             mav.setViewName("filtro");
             
             return mav;
        } catch (Exception e) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("mensaje", "La sesi�n ha expirado, intentelo de nuevo en filtro.");
            mav.addObject("isError", true);
            mav.setViewName("error");
            return mav;
        }
                 
    }

    //metodo para la autenticacion
    public boolean autenticarLDAP(String pUser, String pPassword, List lista) throws AuthenticationException, NamingException {

        // Set up environment for creating initial context
        ConfiguracionLdap ConfLdap = new ConfiguracionLdap(pUser, lista);
        Hashtable<String,String> env = new Hashtable<String,String>(11);
        env.put(Context.INITIAL_CONTEXT_FACTORY, ConfLdap.INITIAL_CONTEXT_FACTORY);
        env.put(Context.PROVIDER_URL, ConfLdap.PROVIDER_URL);
        env.put(Context.SECURITY_AUTHENTICATION, ConfLdap.SECURITY_AUTHENTICATION);
        env.put(Context.SECURITY_PRINCIPAL, pUser + ConfLdap.SECURITY_PRINCIPAL);  // se requiere concatenar el dominio
        env.put(Context.SECURITY_CREDENTIALS, pPassword);

        try {
            // Createinitial context.  Ya con esto verificas si se pudo o no conectar al LDAP.
            // Si no puede, dispara una excepcion..  que es atrapada en el catch.
            DirContext ctx = new InitialDirContext(env);


        } catch (AuthenticationException ae) {
            throw ae;

        } catch (NamingException NEx) {
            throw NEx;
        }
        return true;
    }
    
    @RequestMapping(value = "/monitor", method = RequestMethod.GET)
    public ModelAndView monitor(HttpSession session) {
        try {
            ModelAndView mav = new ModelAndView();
            List<Parametro> parametros = consultaService.getMonitorPool();
            mav.addObject("parametros", parametros);
            mav.setViewName("monitor");
            return mav;
        } catch (Exception e) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("mensaje", "Error interno.");
            mav.addObject("isError", true);
            mav.setViewName("error");
            return mav;
        }
    }

}