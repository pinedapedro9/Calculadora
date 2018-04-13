<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <html xmlns="http://www.w3.org/1999/xhtml">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <title>Paso 3</title>
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
                <div id="contenido">
                    <form action="enviar" method="post">
                        <div id="titulo3">
                            <div class="contenidos">
                                Si la informaci&oacute;n es correcta presione Finalizar, de lo contrario presione Atr&aacute;s para realizar sus cambios.
                            </div>
                        </div>
                        <fieldset>
                            <legend class="Titulos">Cursos ${periodo} </legend>
                            <table width="700" border="0" cellspacing="0" cellpadding="0"><tbody>
                                    <tr>
                                        <td height="10" width="319"  align="left" valign="bottom"></td>
                                        <td height="10" width="17" align="left" valign="bottom"></td>
                                        <td height="10" width="100"  align="left" valign="bottom"></td>
                                        <td height="10" width="17"  align="left" valign="bottom"></td>
                                        <td height="10" width="60"  align="left" valign="bottom"></td>
                                        <td height="10" width="17"  align="left" valign="bottom"></td>
                                        <td height="10" width="170"  align="left" valign="bottom"></td>
                                    </tr>
                                    <tr>
                                        <td height="20" width="319"  align="left" valign="top"><span class="Titulos">Nombre del curso</span></td>
                                        <td height="20" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                        <td height="20" width="100"  align="left" valign="top" class="Titulos">C&oacute;digo</td>
                                        <td height="20" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                        <td height="20" width="60"  align="left" valign="top"><span class="Titulos">Grupo</span></td>
                                        <td height="20" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                        <td height="20" width="170"  align="left" valign="top"><span class="Titulos">Copia de contenidos</span></td>
                                    </tr>
                                    <tr>
                                        <td height="10" width="319" align="left" valign="bottom"></td>
                                        <td height="10" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                        <td height="10" width="100"  align="left" valign="bottom"></td>
                                        <td height="10" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                        <td height="10" width="60"  align="left" valign="bottom"></td>
                                        <td height="10" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                        <td height="10" width="170"  align="left" valign="bottom"></td>


                                    </tr>
                                
                                
                            
                                    <c:forEach var="curso" items="${listaCursos}" varStatus="i">
                                        <tr>
                                            <td height="20" width="319" align="left" valign="middle"><span class="contenidos"><c:out value="${curso.nombreCurso}"/></span></td>
                                            <td height="20" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                            <td height="20" width="100" align="left" valign="middle"><span class="contenidos"><c:out value="${curso.codigoCurso}"/></span></td>
                                            <td height="20" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png" class="Titulos">&nbsp;</td>
                                            <td height="20" width="60" align="left" valign="middle" class="Contenido"><span class="contenidos"><c:out value="${curso.grupo}"/></span></td>
                                            <td height="20" width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                            <td height="20" width="170" align="left" valign="middle" class="contenidos">
                                                
                                                <c:choose>
                                                    <c:when test="${curso.solicitudManual}">
                                                        <div class="comentario">
                                                            
                                                            <div class="contenidos">
                                                                <c:out value="${curso.copiaContenido}"/> 
                                                                &nbsp;&nbsp;&nbsp;
                                                            </div>
                                                            <div class="icono_advertencia"></div>
                                                        </div> 
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:out value="${curso.copiaContenido}"/> 
                                                    </c:otherwise>
                                                </c:choose>
                                                    
                                                    
                                            </td>
                                        </tr>
                                    </c:forEach>

                            </tbody></table>
                            <br />
                            
                            
                            
                        
                            <label class="Titulos"> Observaciones </label>
                            <br />
                            <textarea name="observaciones" cols="80" rows="6"></textarea>  
                            <br />
                            <label class="Titulos" for="correoAlterno">Correo Alternativo: </label>
                            <input id="correoAlterno" name="correoAlterno" type="text" size="20" />
                        </fieldset>

                        <div class="navegacion">
                            <input type="button" class="contenidos" value=" Atr&aacute;s " onClick="javascript:history.back()" /> 
                            <input name="continuar" type="submit" class="contenidos" value="Finalizar" />
                        </div>
                        <c:if test="${solicitudesManuales}">
                            <div class="comentario">
                                <div class="icono_advertencia"></div>
                                <label>
                                    Estos cursos serán creados vacíos. En un plazo máximo de 3 días hábiles Javevirtual se pondrá <br />en contacto con usted para resolver la copia de contenidos.
                                </label>
                            </div>    
                        </c:if>
                        
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
