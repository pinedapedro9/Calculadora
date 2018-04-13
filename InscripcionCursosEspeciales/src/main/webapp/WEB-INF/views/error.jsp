<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Formulario de inscripción de cursos - Pontificia Universidad Javeriana, Cali</title>
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
<!--
body,td,th {
	color: #EBE9ED;
}
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
-->
</style></head>

<body>
<script language="JavaScript">
function openPageG()
{
   document.resumen.action="../";	 
   document.resumen.submit();
}
</script>
    
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="70" align="center" background="resources/Imagenes/Encabezado.png" bgcolor="#D4D4D4" class="Titulos">&nbsp;</td>
  </tr>
</table>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="12" align="center" valign="top" background="resources/Imagenes/Sombra.png" bgcolor="#FFFFFF"></td>
  </tr>
  <tr> 
    <td height="421" align="center" valign="middle" bgcolor="#FFFFFF" class="Titulos">
        <table width="500" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="25" height="18" align="left" valign="top">
            <c:choose>
                <c:when test="${isError}">
                    <img src="resources/Imagenes/Error.png" width="16" height="16" />
                </c:when>
                <c:otherwise>
                    <img src="resources/Imagenes/Advertencia.png" width="16" height="16" />
                </c:otherwise>
            </c:choose>
          </td>
            <td  align="left" valign="top" class="Titulos"> 
              ${mensaje}
            
            </td>
        </tr>
      </table>
      </p></td>
  </tr>
  <tr>
    <td height="20" align="center" valign="top" bgcolor="#FFFFFF">&nbsp;</td>
  </tr>
</table>
              

<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td height="20" align="center" valign="top" bgcolor="#FFFFFF"></td>
  </tr>
  <tr> 
    <td width="740" height="21"  align="center" valign="top" bgcolor="#FFFFFF">
        <table width="100%">
            <body>
                <tr>
                    <td align="right">
                         <form action="login" method="post">
                            <input name="terminar" type="submit" class="contenidos" value="Terminar"/>
                         </form>
                    </td>
                    <td>
                         <form action="consulta" method="post">
                            <input name="Continuar" type="submit" class="contenidos" value="Continuar"/>
                         </form>
                    </td>
                </tr>
            </body>
        </table>
     </td>
  </tr>
  <tr> 
    <td height="20" align="center" valign="bottom" bgcolor="#FFFFFF"></td>
  </tr>
  <tr> 
    <td height="25" align="center" valign="middle" background="resources/Imagenes/Piedepagina.png" bgcolor="#D4D4D4">
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
    </td>
  </tr>
</table>
    
        
</body>
</html>
