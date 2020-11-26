/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.models;

/**
 *
 * @author Md Ashiqur Rahman
 */
import java.util.Date;
public abstract class PersonModel {

    private final long MILISECOND_IN_A_DAY = 86400000;
    private final long DAYS_IN_A_YEAR = 365;

    public int id;
    public String firstName;
    public String lastName;
    public String fathersName;
    public String mothersName;
    public String gender;
    public Date dateOfBirth;
    public String education;
    public String contactNo;
    public String address;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public byte getAge() {
        try {
            double birthTime = this.dateOfBirth.getTime();
            double currentTime = new Date().getTime();
            double years = ((currentTime - birthTime) / MILISECOND_IN_A_DAY) / DAYS_IN_A_YEAR;
            return (byte) years;
        }
        catch(Exception e){
            return 0;
        }
    }
}
