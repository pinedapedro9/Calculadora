<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Iniciar Sesi&oacute;n</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEE;
	
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
	color: #0564B1;
	text-decoration: none;
}
a:hover {
	color: #0564B1;
	text-decoration: underline;
}
a:active {
	color: #0564B1;
	text-decoration: none;
}
</style>
</head>

<body>
<div id="pagina">
<div id="cabecera"></div>
<div id="franja"></div>
<div id="contenido">
  <div id="tabla_sesion">
  <table width="250" border="0" align="center" cellpadding="0" cellspacing="0" background="resources/Imagenes/Fondo.png">
    <tr>
      <td width="235" height="214" align="center" valign="top" background="resources/Imagenes/Fondo.png" bgcolor="#CCCCCC"><table width="250" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="10" align="right" valign="middle"></td>
        </tr>
        <tr>
          <td height="30" align="center" valign="middle"><span class="Titulos"><span class="Titulo_sesion">Iniciar sesi&oacute;n</span></span></td>
        </tr>
      </table>
        <table width="150" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="150" height="10" colspan="3"></td>
          </tr>
          <tr>
            <td height="15" colspan="3" align="left" valign="top" class="Contenido"><span class="contenidos">Nombre de Usuario</span></td>
          </tr>
          <form action="ingreso" method="post">
            <tr>
              <td colspan="3" align="left" class="Contenido"><input name="campo_usuario" type="text" id="campo_usuario" class="contenidos" size="25" /></td>
            </tr>
            <tr>
              <td height="15" colspan="3"></td>
            </tr>
            <tr>
              <td height="15" colspan="3" align="left" class="Contenido"><span class="contenidos">Contrase&ntilde;a</span></td>
            </tr>
            <tr>
              <td colspan="3" align="left" class="Contenido"><input name="campo_password" type="password" id="campo_password" class="contenidos" size="25" /></td>
            </tr>
            <tr>
              <td height="14" colspan="3" align="center"><span class="contenidos">${mensaje}</span></td>
            </tr>
            <tr>
              <td colspan="3" align="center"><label>
                <input name="button2" type="submit" class="contenidos" id="button2" value="Iniciar Sesi&oacute;n" />
              </label></td>
            </tr>
            <tr>
              <td height="13" colspan="3" align="center"></td>
            </tr>
          </form>
        </table></td>
    </tr>
  </table>
  <legend></legend>
  </div>
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
