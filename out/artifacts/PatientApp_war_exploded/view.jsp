<%--
  Created by IntelliJ IDEA.
  User: sahar
  Date: 7/20/2020
--%>
<%@ page import="app.model.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>View patient</title>
    <script src="js/patient.js" type="text/javascript"></script>
    <link rel="stylesheet"  href="css/patient.css" >
    <link rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >
  </head>
  <body>
  <header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="form-inline my-2 my-lg-0">
        <span class="navbar-brand" >Patient Application </span>
        <button class="btn" onclick="location.href='/new'">New Patient</button>
      </div>
    </nav>
  </header>
  <div class="content">
    </br>
    </br>
    <div class="container">
      <h3>View patient details</h3>
      <table class="table">
        <% Patient patient =(Patient)request.getAttribute("patient"); %>
        <tr><td>Id:</td><td><%=patient.getId()%></td><tr>
        <tr><td>First Name:</td><td> <%=patient.getFirstName()%></td><tr>
        <tr><td>Last Name:</td><td> <%=patient.getLastName()%></td></tr>
        <tr><td>Age: </td><td> <%=patient.getAge()%></td></tr>
        <tr><td>Birth Date:</td><td><%=patient.getBirthDate()%></td></tr>
      </table>
      <button onclick="location.href='/list'" class="btn btn-info">Back to list</button>
    </div>
  </div>
  </body>
</html>
