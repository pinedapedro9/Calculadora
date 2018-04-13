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
                <div id="contenido">
                    <form action="paso4" method="post">
                        <div id="titulo3"><span class="textos"><span class="contenidos">Si la informaci&oacute;n es correcta presione Finalizar, de lo contrario presione Atr&aacute;s para realizar sus cambios.</span></span><br />

                        </div>
                        <fieldset>
                            <legend class="Titulos">Cursos ${periodo} </legend>
                            <table width="493" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td height="10" colspan="7" align="left" valign="bottom"></td>
                                </tr>
                                <tr>
                                    <td width="166" rowspan="2" align="left" valign="top"><span class="Titulos">Nombre del curso</span></td>
                                    <td width="17" align="left" valign="bottom"></td>
                                    <td width="81" rowspan="2" align="left" valign="top" class="Titulos">C&oacute;digo</td>
                                    <td width="16" rowspan="2" align="center" valign="top" background="resources/Imagenes/divider_g.png" class="Titulos">&nbsp;</td>
                                    <td width="56" rowspan="2" align="left" valign="top"><span class="Titulos">Grupo</span></td>
                                    <td width="16" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                    <td width="141" rowspan="2" align="left" valign="top"><span class="Titulos">Origen Contenido</span></td>
                                </tr>
                                <tr>
                                    <td width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                    <td width="16" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                </tr>
                                <tr>
                                    <td height="15" align="right" valign="middle" class="Contenido"></td>
                                    <td width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                    <td height="15" align="right" valign="middle" class="Contenido"></td>
                                    <td width="16" align="center" valign="top" background="resources/Imagenes/divider_g.png" class="Titulos"></td>
                                    <td height="15" align="right" valign="middle" class="Contenido"></td>
                                    <td width="16" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                    <td align="right" valign="middle" class="Contenido"></td>
                                </tr>

                                <c:forEach var="curso" items="${listaCursos}" varStatus="i">
                                    <tr>
                                        <td height="25" align="left" valign="middle"><span class="contenidos"><c:out value="${curso.nombreCurso}"/></span></td>
                                        <td width="17" align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                        <td align="left" valign="middle"><span class="contenidos"><c:out value="${curso.codigoCurso}"/></span></td>
                                        <td align="center" valign="top" background="resources/Imagenes/divider_g.png" class="Titulos">&nbsp;</td>
                                        <td align="left" valign="middle" class="Contenido"><span class="contenidos"><c:out value="${curso.grupo}"/></span></td>
                                        <td align="center" valign="top" background="resources/Imagenes/divider_g.png"></td>
                                        <td align="left" valign="middle" class="contenidos">
                                            <select id="cursoPlantilla${i.index}" name="cursoPlantilla${i.index}" required>
                                                <c:forEach var="cursoBlackboard" items="${listaCursosBlackboard}" varStatus="j">
                                                    <option value="${cursoBlackboard.codigo}"><c:out value="${cursoBlackboard.nombre}"/></option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </table>
                            <br />
                        </fieldset>

                        <p>
                            <input type="button" class="contenidos" value=" Atr&aacute;s " onClick="javascript:history.back()" /> 
                            <input name="continuar" type="submit" class="contenidos" value="Siguiente" />
                        </p>

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
