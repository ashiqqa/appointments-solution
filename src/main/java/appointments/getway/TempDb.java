/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.getway;

/**
 *
 * @author Md Ashiqur Rahman
 */
import appointments.models.*;

public class TempDb {
    public IQueryable<UserModel> users;   
    public IQueryable<DoctorModel> doctors;   
    public IQueryable<PatientModel> patients;

    public TempDb(){
        users = new Users();        
        doctors = new Doctors();     
        patients = new Patients();
        
        //setting a default user
        users.save(new UserModel("admin","123"));
    }
}
