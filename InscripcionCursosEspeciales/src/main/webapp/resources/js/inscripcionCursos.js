/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    
    $(".salir").click(function(){
        var form = $('<form></form>');

        form.attr("method", "post");
        form.attr("action", "login");
        $(document.body).append(form);
        form.submit();
    });
    
});
