package app.db;
/**
 * Created by sahar on 7/20/2020.
 */
import app.model.Patient;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DBCsvTest {

    @Test
    public void insertNewPatient() throws Exception {
        Patient patient= new Patient(1,"Sahar","Hosseini",25,"1999/12/05");
        DBCsv DB = new DBCsv(true);
        DB.insertNewPatient(patient);
        Patient temp= DB.getPatientById(1);
        assertEquals(patient.getId(),temp.getId());
    }

    @Test
    public void getPatientById() throws Exception {
        Patient patient= new Patient(2,"Sarah","Hosseini",25,"1989/12/05");
        DBCsv DB = new DBCsv(true);
        DB.insertNewPatient(patient);
        Patient temp= DB.getPatientById(patient.getId());
        assertNotEquals(temp,null);
    }

    @Test
    public void selectAllPatients() throws Exception {

        DBCsv DB = new DBCsv(true);
        List< Patient > temp = DB.selectAllPatients();
        assertNotEquals(temp.size(),0);
    }
}
