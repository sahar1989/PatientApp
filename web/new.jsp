<%--
  Created by IntelliJ IDEA.
  User: sahar
  Date: 7/20/2020
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Add new patient</title>
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
      <h2>Add new patient</h2>
      <div class="form-group">
        <form method="post" action="/save">
          <table class="table">
            <tr><td>First Name: </td><td><input class="form-control" type="text" id="first_name" name="first_name"></td></tr>
            <tr><td>Last Name: </td><td><input class="form-control" type="text" id="last_name" name="last_name"></td></tr>
            <tr><td>Age: </td><td><input class="form-control" type="text" id="age" name="age"></td></tr>
            <tr><td>Birth Date: </td><td><input class="form-control" placeholder="yyyy/MM/dd" type="text" id="birth_date" name="birth_date" onkeyup="checkFormat();"></td></tr>
          </table>
          <button onclick="location.href='/list'" class="btn btn-info">Back</button>
          <button type="submit" value="Submit" class="btn btn-success">Save</button>
        </form>
      </div>
    </div>
  </div>
  </body>
</html>
