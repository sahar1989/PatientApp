<%--
  Created by IntelliJ IDEA.
  User: sahar
  Date: 7/20/2020
--%>
<%@ page import="app.model.Patient" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient list</title>
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
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Firs Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Birth Date</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%ArrayList<Patient> patient =
                (ArrayList<Patient>)request.getAttribute("listPatients");
            for(Patient p:patient){%>
        <tr>
            <td><%=p.getId()%></td>
            <td><%=p.getFirstName()%></td>
            <td><%=p.getLastName()%></td>
            <td><%=p.getAge()%></td>
            <td><%=p.getBirthDate()%></td>
            <td><a href="view?id=<%=p.getId()%>" class="btn btn-link" >View Details</a> </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</div>
</body>
</html>
