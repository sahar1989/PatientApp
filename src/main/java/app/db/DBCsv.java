/**
 * Created by sahar on 7/20/2020.
 */
package app.db;

import app.model.Patient;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DBCsv {

    private boolean isTest;
    //private String dataPath;

    public void setIsTest(boolean test){
        this.isTest=test;
    }

    public boolean getIsTest() {
        return this.isTest;
    }
    public DBCsv(Boolean isTest){
        setIsTest(isTest);
    }

    private String getDataPath(){
        //fetch data file path
        if(getIsTest()){
            URL res = getClass().getClassLoader().getResource("testdata.csv");
            try{
                File file = Paths.get(res.toURI()).toFile();
                return file.getAbsolutePath();
            }
            catch (URISyntaxException e){
                return  "E:\\Practise Project\\java\\PatientApp\\src\\main\\resources\\testdata.csv";
            }
        }
        else{
            URL res = getClass().getClassLoader().getResource("data.csv");
            try{
                File file = Paths.get(res.toURI()).toFile();
                return file.getAbsolutePath();
            }
            catch (URISyntaxException e){
                return  "E:\\Practise Project\\java\\PatientApp\\src\\main\\resources\\data.csv";
            }
        }
    }

    public void insertNewPatient(Patient patient) throws IOException{
        FileWriter fstream = new FileWriter(getDataPath(), true);
        BufferedWriter out = new BufferedWriter(fstream);
        List<Patient> listPatients = selectAllPatients();
        int lastId = 1;
        String param="";
        if(listPatients.size()>0){
            lastId = listPatients.get(listPatients.size()-1).getId()+1;
            param+="\n";
        }
        param+= lastId+","+patient.getFirstName()+","+patient.getLastName()+","+patient.getAge()+","+patient.getBirthDate()+"\n";
        out.write(param);
        out.newLine();
        out.close();
    }

    public Patient getPatientById(int id) {
        List<Patient> listPatients = selectAllPatients();
        for (Patient patient : listPatients) {
            if (patient.getId()==id) {
                return patient;
            }
        }
        return null;
    }

    public List < Patient > selectAllPatients() {
        List < Patient > patients = new ArrayList < > ();
        try{
            BufferedReader csvReader = new BufferedReader(new FileReader(getDataPath()));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if(data!=null && data.length>1 && data[0]!=""){
                    int id = Integer.parseInt(data[0]);
                    String first_name =data[1];
                    String last_name = data[2];
                    int age = Integer.parseInt(data[3]);
                    String birth_date = data[4];
                    patients.add(new Patient(id, first_name, last_name, age, birth_date));
                }
            }
            csvReader.close();
        }
        catch(IOException e){
            printIOException(e);
        }
        return patients;
    }

    private void printIOException(IOException ex) {
        ex.printStackTrace(System.err);
        System.err.println("Message: " + ex.getMessage());
        Throwable t = ex.getCause();
        while (t != null) {
            System.out.println("Cause: " + t);
            t = t.getCause();
        }
    }
}
