<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Filtro</title>
        <style type="text/css">
            <!--
            body {
                margin-left: 0px;
                margin-top: 0px;
                margin-right: 0px;
                margin-bottom: 0px;
                background-color: #F2F2F2;
            }
            -->
        </style>
        <link href="resources/css/Estilo.css" rel="stylesheet" type="text/css" />
        <script src="resources/js/jquery.min.1.9.1.js"></script>
        <script src="resources/js/salir.js"></script>
        <script src="resources/js/paso1Limpiar.js"></script>
        
        <style type="text/css">
            a:link {
                color: #0564B1;
                text-decoration: none;
            }
            a:visited {
                text-decoration: none;
                color: #0564B1;
            }
            a:hover {
                text-decoration: underline;
                color: #0564B1;
            }
            a:active {
                text-decoration: none;
                color: #0564B1;
            }
        </style>
    </head>

    <body>
        <div id="pagina">
            <div id="cabecera"></div>
            <div id="franja"></div>
            <div class="salir" title="Cancela la solicitud">
                <label>Salir</label>
                <div class="icono"></div>
            </div>
            <div id="contenidos">
                               
                    <br/><br/>
                    
                    <div id="titulo">
                        <div class="contenidos">
                            <br> <br>Consulte el profesor al que desea crearle los cursos para el  per&iacute;odo ${periodo}.
                        </div>
                        
                    </div>
                   
                    <br/>
               <form action="paso1" method="post">
                    
                   <div id="contenido">
                    <span class="textos"><span class="contenido" type="text">Consulta</span></span>
                     <tr>
                        <td colspan="3" align="left" class="Contenido"><input name="campo_usuario" type="text" id="campo_usuario" class="contenidos" size="25" /></td>
                     </tr>    
                   
                    <tr>
                        <td> <SELECT NAME="selCombo"> 
                                <OPTION VALUE="Seleccione">Seleccione</OPTION>
                                <OPTION VALUE="Usuario">Usuario</OPTION>
                                <OPTION VALUE="Catalogo">Catalogo</OPTION>
                             </SELECT>
                        </td>                        
                    </tr>
                    
                     <td colspan="3" align="center"><label>
                          <input name="buttonBuscar" type="submit"  class="contenidos" id="buttonBuscar" value="Buscar" onclick="document.getElementById('mensaje').value='' "  />
                      </label>
                     </td>
                     <tr>
                         <td class="Titulos" height="14" colspan="3" align="center"><span id="mensaje" class="contenidos">${mensaje}</span></td>
                     </tr>
                     
                   </div>
                        
                 </form>
                     
                    
            </div>

            <div id="pie">
                <div class="contacto"> 
                    <div class="institucion">
                        <span class="Piedepagina">&copy; Pontificia Universidad Javeriana, Cali</span>
                    </div>
                    <div class="separador"></div>
                    <div class="oficina">
                        <span class="Piedepagina"><a href="http://javevirtual.javerianacali.edu.co/" target="_blank">Javevirtual</a></span>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>