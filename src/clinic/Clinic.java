/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic;

import WaitingRoom.WaitingRoomList;
import appointments.Appointment;
import appointments.AppointmentsList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import patients.Patient;
import patients.PatientsList;

/**
 *
 * @author Aaron
 */
public class Clinic {
    private PatientsList patients;
    private AppointmentsList appointments;
    private WaitingRoomList waitingroom;
    
    public boolean addPatient(Patient patient) {
        return patients.add(patient);
    }

    public Patient findPatient(String id) {
        return patients.get(id);
    }

    public boolean removePatient(String id) {
        return patients.remove(id);
    }

    public Iterator<Patient> getPatients() {
        return patients.getAll();
    }

    public boolean scheduleAppointment(Appointment appointment) {
        return appointments.add(appointment);
    }

    public Appointment findAppointment(String code) {
        if(appointments.isEmpty()) return null;
        return appointments.get(code);
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime) {
        Appointment Cita = appointments.get(code);
        if (Cita!= null) {
        Cita.reschedule(newDate, newTime);
        return true;
    }
        return false;
    }

    public boolean cancelAppointment(String code) {
        return appointments.remove(code);
    }

    public Iterator<Appointment> getAppointments() {
        return appointments.getAll();
    }

    public boolean checkInPatient(String patientId) {
         if(patients.get(patientId)!=null) return true;
         return false;
    }

    public Patient getNextPatient() {
        return waitingroom.get();
    }

    public Patient attendNextPatient() {
       Patient patient = waitingroom.get();
    waitingroom.remove();
    return patient;
    }

    public int getWaitingPatientCount() {
        return waitingroom.size();
    }

    public boolean isPatientWaiting(String patientId) {
        Iterator<Patient> i = waitingroom.getAll();
    while (i.hasNext()) {
        Patient p = i.next();
        if (p.getId().equals(patientId)) {
            return true;
        }
    }
    return false;
    
}
    
}
