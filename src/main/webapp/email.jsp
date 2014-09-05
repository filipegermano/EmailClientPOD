<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <link href="css/cssform.css" rel="stylesheet" type="text/css">
        <script src="carregaemail.js" type="text/javascript">
            
        </script>
        
        <title>Enviar E-mail</title>
    </head>
    <body>
        <div id="top_bar">
            <div id="home"></div>
        </div>
        <div id="wrapper">
            <div id="box">
                <div id="top_header">
                    <h3>Enviar E-mail</h3>
                    <br>
                </div>
                <form name="cadastro_pessoa" method="POST" action="SendEmail">
                    <di id="inputs">                         
                        <input type="text" name="remetente" placeholder="Nome do remetente" required="true">
                        <div id="email">
                            <c:forEach var="item" items="${pessoas}">
                                <input type="submit" value="${item.email}" id="${item.nome} ${item.email}" onclick="carregaremail(this)" class="emails">
                                
                            </c:forEach>                            
                        </div>
                        <input type="text" id="destinatarios" name="destinatarios" placeholder="E-mails destinatário" required="true"> 
                        <input type="text" name="assunto" placeholder="Assunto" required="true">
                        <textarea type="text" name="mensagem" placeholder="Mensagem"></textarea>
                        <input type="submit" value="Enviar"> 
                        <p> ${result} </p>
                    </di>
                </form>
                <br>
            </div>
        </div>
    </body>
</html>

