/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.getway;

import appointments.models.DoctorModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Md Ashiqur Rahman
 */
class Doctors implements IQueryable<DoctorModel> {
     private static List<DoctorModel> doctorList;

    public Doctors() {
        doctorList = new ArrayList<>();
    }

    @Override
    public List<DoctorModel> get() {
        return this.doctorList;
    }
    @Override
    public DoctorModel get(int id) {
        for (DoctorModel user : this.doctorList) {
            if (user.id == id) {
                return user;
            }
        }
        return null;
    }
    @Override
    public DoctorModel save(DoctorModel doctor) {
        if (doctor.id > 0) {
            if (this.update(doctor)) {
                return doctor;
            } else {
                return null;
            }

        } else {
            if (this.insert(doctor)) {
                return doctor;
            } else {
                return null;
            }
        }
    }
    @Override
    public boolean delete(int id) {
        DoctorModel doctor = this.get(id);
        return this.doctorList.remove(doctor);
    }
    public List<DoctorModel> search(String searchText){
        return null;
    }
     @Override
    public int size() {
        return this.doctorList.size(); //To change body of generated methods, choose Tools | Templates.
    }
    private boolean insert(DoctorModel doctor) {
        doctor.id = this.getNewId();
        if (this.doctorList.add(doctor)) {
            return true;
        } else {
            return false;
        }
    }
    private boolean update(DoctorModel doctor) {
        DoctorModel existUser = this.get(doctor.id);
        int index = this.doctorList.indexOf(existUser);
        return this.doctorList.set(index, doctor) != null;
    }
    private int getNewId() {
        int id = 0;
        if (this.doctorList.size() > 0) {
            id = this.doctorList.get(this.doctorList.size() - 1).id;
            return id + 1;
        } else {
            return id + 1;
        }
    }
}
