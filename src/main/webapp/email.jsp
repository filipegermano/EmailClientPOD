<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        
        <link href="css/cssform.css" rel="stylesheet" type="text/css">
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
                        <select multiple >
                            <c:forEach var="item" items="${pessoas}">
                                <option>${item.email}</option>
                            </c:forEach>                            
                        </select>
                        <input type="text" name="destinatarios" placeholder="E-mails destinatário" required="true"> 
                        <input type="text" name="assunto" placeholder="Assunto" required="true">
                        <textarea type="text" name="mensagem" placeholder="Mensagem"></textarea>
                        <input type="submit" value="Enviar"> 
                        <h1> ${result} </h1>
                    </di>
                </form>
                <br>
            </div>
        </div>
    </body>
</html>

