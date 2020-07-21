/**
 * Created by sahar on 7/20/2020.
 */
package app.db;

import app.model.Patient;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBSql {

    private String jdbcURL = "jdbc:mysql://localhost:3306/PatientDB";
    private String jdbcUsername = "Admin";
    private String jdbcPassword = "Admin123";

    private static final String SQL_INSERT_NEW = "INSERT INTO patienttbl" + "  (first_name, last_name, age, birth_date) VALUES " +
            " (?, ?, ?, ?);";
    private static final String SQL_SELECT_BY_ID = "select * from patienttbl where id =?";
    private static final String SQL_SELECT_ALL = "select * from patienttbl";

    public DBSql(){}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void insertNewPatient(Patient patient) throws IOException /*throws SQLException */{
        System.out.println(SQL_INSERT_NEW);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_NEW)) {
            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setInt(3, patient.getAge());
            preparedStatement.setString(4, patient.getBirthDate());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Patient getPatientById(int id) {
        Patient patient=null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                int age = rs.getInt("age");
                String birth_date = rs.getString("birth_date");
                patient = new Patient(id, first_name, last_name, age,birth_date);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return patient;
    }

    public List < Patient > selectAllPatients() {
        List < Patient > patients = new ArrayList < > ();

       // Step 1: Establishing a Connection
       try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                int age = rs.getInt("age");
                String birth_date= rs.getString("birth_date");
                patients.add(new Patient(id, first_name, last_name, age, birth_date));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return patients;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
