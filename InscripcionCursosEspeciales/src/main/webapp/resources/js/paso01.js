/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
    $("#paso1").submit(function(){
        var cont = $(".checkCopiar:checked").length;
        if (cont>0){
            return true;
        }else{
            alert("Debe seleccionar almenos un curso para continuar con la solicitud");
            return false;
        }
    });
});