<%-- 
    Document   : main
    Created on : 6 avr. 2017, 16:52:51
    Author     : severin
--%>

<%@page import="java.awt.Font"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>+ou-</title>
    </head>
    <body style="text-align: center;font-family: 'Roboto', 'Helvetica', 'Arial', sans-serif;font-size: 3em;">
        <jsp:useBean id="jeu" class="Jeu.Jeu" scope="session"/>
        <div style="margin:10%;border: solid 1px black;padding: 5px;">
         <h1>Othelo</h1>
         <% out.println("c'est au tour de "+jeu.statut()+"<br>");%>
         <% out.println(jeu.affichage()+"<br>");%>
         <% out.println("dernière action effectuée en "+jeu.derniereAction()+"<br>");%>
        <form method="get" action="main.jsp">
            <label for="choice">Entrez une position (colonneligne) : </label></br>
            <input type="number" name="answer" min="0" max="1000000" size="24" 
                   style="width:6%;height: 50px;font-family:'Roboto', 'Helvetica', 'Arial',sans-serif;font-size: 1em;"></br></br>
            <input type="submit" 
                   style="width:30%;height: 80px;font-family:'Roboto', 'Helvetica', 'Arial',sans-serif;font-size: 1em;" name="sendButton"></p></br>
        </form>
       
        <% 
            String answer = request.getParameter("answer");
            int newAnswer = Integer.valueOf(answer);
            jeu.init();
            if (jeu.statut() == "Joueur 1"){
                jeu.action(1,newAnswer);
            }else{
                jeu.action(2,newAnswer);
            }
            if(jeu.finDePartie()){
                out.println("la vainqueur est le joueur "+jeu.vainqueur()+"<br>");
            }
        %>
        </div>
    </body>
</html>
