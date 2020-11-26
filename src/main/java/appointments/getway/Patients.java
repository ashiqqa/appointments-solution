/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.getway;

import appointments.models.PatientModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Md Ashiqur Rahman
 */
class Patients implements IQueryable<PatientModel> {
      private static List<PatientModel> patientList;

    public Patients() {
        patientList = new ArrayList<>();
    }

    @Override
    public List<PatientModel> get() {
        return Patients.patientList;
    }
    @Override
    public PatientModel get(int id) {
        for (PatientModel user : Patients.patientList) {
            if (user.id == id) {
                return user;
            }
        }
        return null;
    }
    @Override
    public PatientModel save(PatientModel patient) {
        if (patient.id > 0) {
            if (this.update(patient)) {
                return patient;
            } else {
                return null;
            }

        } else {
            if (this.insert(patient)) {
                return patient;
            } else {
                return null;
            }
        }
    }
    @Override
    public boolean delete(int id) {
        PatientModel patient = this.get(id);
        return Patients.patientList.remove(patient);
    }
      @Override
    public List<PatientModel> search(String searchText){
        return null;
    }
    @Override
    public int size() {
        return Patients.patientList.size(); //To change body of generated methods, choose Tools | Templates.
    }
    private boolean insert(PatientModel patient) {
        patient.id = this.getNewId();
          return Patients.patientList.add(patient);
    }
    private boolean update(PatientModel patient) {
        PatientModel existUser = this.get(patient.id);
        int index = Patients.patientList.indexOf(existUser);
        return Patients.patientList.set(index, patient) != null;
    }
    private int getNewId() {
        int id = 0;
        if (Patients.patientList.size() > 0) {
            id = Patients.patientList.get(Patients.patientList.size() - 1).id;
            return id + 1;
        } else {
            return id + 1;
        }
    }
}
