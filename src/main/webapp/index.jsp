<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/cssform.css" rel="stylesheet" type="text/css">
        <title>Conectar ao Servidor</title>
    </head>
    <body>
        <div id="top_bar">
            <div id="home"></div>
        </div>
        <div id="wrapper">
            <div id="box">
                <div id="top_header">
                    <h3>Conectar ao Servidor</h3>
                    <br>
                </div>
                <form name="conectar" method="POST" action="Principal">
                    <di id="inputs"> 
                        <input type="text" name="ip" placeholder="IP" required="true">                        
                        <input type="submit" value="Conectar"> 
                        <h1> ${result} </h1>
                    </di>
                </form>
                <br>
            </div>
        </div>
    </body>
</html>
