/**
 * Created by sahar on 7/20/2020.
 */
package app.model;

public class Patient {
    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private String birth_date;

    public Patient(int id, String first_name, String last_name,int age,String birth_date) {
        super();
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.birth_date = birth_date;
    }

    //id
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //first name
    public String getFirstName() {
        return this.first_name;
    }
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    //last name
    public String getLastName() {
        return this.last_name;
    }
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    //age
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //birth date
    public String getBirthDate() {
        return this.birth_date;
    }
    public void setBirthDate(String birth_date) {
        this.birth_date = birth_date;
    }
}
