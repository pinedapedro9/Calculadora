<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Paso 2</title>
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
        <script src="resources/js/inscripcionCursos.js"></script>
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
            <div id="contenido2">
                <form action="paso3" method="post">
                    <div id="titulo2">
                        <div class="contenidos">
                            Seleccione si desea copiar el contenido del periodo acad&eacute;mico anterior para cada curso.
                        </div>
                    </div>
                    <fieldset>
                        <legend class="Titulos">Copia de Contenidos</legend>
                        <table width="700" border="0" cellspacing="0" cellpadding="0"><tbody>
                                <tr>
                                    <td height="10" width="319"  align="left" valign="bottom"></td>
                                    <td height="10" width="17" align="left" valign="bottom"></td>
                                    <td height="10" width="100"  align="left" valign="bottom"></td>
                                    <td height="10" width="17"  align="left" valign="bottom"></td>
                                    <td height="10" width="60"  align="left" valign="bottom"></td>
                                    <td height="10" width="17"  align="left" valign="bottom"></td>
                                    <td height="10" width="170" colspan="2" align="left" valign="bottom"></td>
                                </tr>
                                <tr>
                                    <td height="20" width="319"  align="left" valign="top"><span class="Titulos">Nombre del curso</span></td>
                                    <td height="20" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                    <td height="20" width="100"  align="left" valign="top" class="Titulos">C&oacute;digo</td>
                                    <td height="20" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                    <td height="20" width="60"  align="left" valign="top"><span class="Titulos">Grupo</span></td>
                                    <td height="20" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                    <td height="20" width="170" colspan="2" align="left" valign="top"><span class="Titulos">¿Copiar contenidos?</span></td>
                                </tr>
                                <tr>
                                    <td height="10" width="319" align="left" valign="bottom"></td>
                                    <td height="10" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                    <td height="10" width="100"  align="left" valign="bottom"></td>
                                    <td height="10" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                    <td height="10" width="60"  align="left" valign="bottom"></td>
                                    <td height="10" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                    <td height="10" width="170" colspan="2"  align="left" valign="bottom"></td>


                                </tr>
                            
                            
                            
                           

                            <c:forEach var="curso" items="${listaCursos}" varStatus="i">
                                <tr>
                                    <td height="20" width="319" align="left" valign="middle"><span class="contenidos"><c:out value="${curso.nombreCurso}"/></span></td>
                                    <td height="20" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                    <td height="20" width="100" align="left" valign="middle"><span class="contenidos"><c:out value="${curso.codigoCurso}"/></span></td>
                                    <td height="20" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png" class="Titulos">&nbsp;</td>
                                    <td height="20" width="60" align="left" valign="middle" class="Contenido"><span class="contenidos"><c:out value="${curso.grupo}"/></span></td>
                                    <td height="20" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                    <td align="left" valign="middle"><input type="radio" name="radio${i.index}" id="si${i.index}" value="si${i.index}" />
                                        <label for="si${i.index}" class="contenidos"> S&iacute;</label></td>
                                    <td align="left" valign="middle"><input type="radio" name="radio${i.index}" id="no${i.index}" value="no${i.index}" checked/>
                                        <label for="no${i.index}" class="contenidos"> No</label></td>
                                </tr>
                            </c:forEach>
                        </tbody></table>
            <br />
                      
                       
                        
                    </fieldset>
                   

                    <div class="navegacion">
                        <input type="button" class="contenidos" value=" Atr&aacute;s " onClick="javascript:history.back()" /> 
                        <input name="continuar" type="submit" class="contenidos" value="Siguiente" />
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
