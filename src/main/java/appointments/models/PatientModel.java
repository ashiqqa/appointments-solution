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
public class PatientModel extends PersonModel {
    public String disease;
    public Date visitDate;
    public String description;
}
