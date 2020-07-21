package app.servlets;
import app.db.DBSql;
import app.model.Patient;
import app.db.DBCsv;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sahar on 7/20/2020.
 */
@WebServlet(
        urlPatterns = "/"
)
public class Index extends  HttpServlet {

    private DBCsv PatientDB;
    public void init() {
        PatientDB = new DBCsv(false);
    }

    //if you want to create mysql please uncomment
    /*private DBSql PatientDB;
    public void init() {
        PatientDB = new DBSql();
    }*/

    //POST action
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/save":
                   insertPatient(request, response);
                    break;
                default:
                    getAllPatients(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    //GET action
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    displayNewForm(request, response);
                    break;
                case "/view":
                    getPatientById(request, response);
                    break;
                default:
                    getAllPatients(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    //fetch all patients
    private void getAllPatients(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Patient> listPatients = PatientDB.selectAllPatients();
        request.setAttribute("listPatients", listPatients);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    //display new form to add new patient
    private void displayNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("new.jsp");
        dispatcher.forward(request, response);
    }

    //insert new patient
    private void insertPatient(HttpServletRequest request, HttpServletResponse response)
            throws  /* SQLException,*/ IOException {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        int age = Integer.parseInt(request.getParameter("age"));
        String birth_date = request.getParameter("birth_date");
        Patient newUser = new Patient(0, first_name, last_name, age, birth_date);
        PatientDB.insertNewPatient(newUser);
        response.sendRedirect("list");
    }

    //fetch patient by id
    private void getPatientById(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Patient existingUser = PatientDB.getPatientById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
        request.setAttribute("patient", existingUser);
        dispatcher.forward(request, response);
    }
}


