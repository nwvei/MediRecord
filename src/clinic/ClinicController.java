/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic;

import appointments.Appointment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import patients.Patient;

/**
 *
 * @author HP
 */
public class ClinicController {
    private Clinic clinic;
    private Views view;
    private static ClinicController controller;
    
   public static ClinicController getInstance(Views view){
       if(controller==null)
           controller=new ClinicController(view);
       return controller;
   } 
   
   public void setView(Views view){
       this.view=view;
   }
   
   private ClinicController(Views view){
       this.clinic=new Clinic();
       this.view=view;
   }
   public void addPatient(Patient patient){
       boolean status=clinic.addPatient(patient);
        if(status){
            view.showMessage("El paciente se ha registrado correctamente");
        }else{
            view.showError("Ocurrio un error no se logro registrar el paciente");
        }
    }

    public Patient findPatient(String id){
         Patient patient=clinic.findPatient(id);
        if(patient==null){
            view.showError("No se encontro un paciente con el id ingresado");
            view.clear();
        }
        return patient;
    } 

    public void removePatient(String id){
        boolean status=clinic.removePatient(id);
        if(status){
            view.showMessage("El paciente se ha eliminado correctamente");
        }else{
            view.showError("Ocurrio un error no se logro eliminar el paciente");
        }
    }

    public Iterator<Patient> getPatients(){
        return clinic.getPatients();
    }

    public boolean scheduleAppointment(Appointment appointment){
        boolean status=clinic.scheduleAppointment(appointment);
        if(status){
            view.showMessage("La cita se ha agendado correctamente");
        }else{
            view.showError("Ocurrio un error no se logro agendar la cita");
        }
        return status;
    }

    public Appointment findAppointment(String code){
        Appointment appo=clinic.findAppointment(code);
        if(appo==null){
            view.showError("No se encontro una cita con el codigo ingresado");
            view.clear();
        }
        view.showData(appo);
        return appo;
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime){
        boolean status=clinic.rescheduleAppointment(code, newDate, newTime);
        if(clinic.rescheduleAppointment(code, newDate, newTime)){
            view.showMessage("La cita se ha reagendado correctamente");
        }else{
            view.showError("Ocurrio un error no se logro reagendar la cita");
        }
        return status;
    }

    public boolean cancelAppointment(String code){
        boolean status=clinic.cancelAppointment(code);
        if(status){
            view.showMessage("La cita se ha cancelado correctamente");
        }else{
            view.showError("Ocurrio un error no se logro cancelar la cita");
        }
        return status;
    }

    public Iterator<Appointment> getAppointments(){
        return clinic.getAppointments();
    }

    public boolean checkInPatient(String patientId){
       boolean status=clinic.checkInPatient(patientId);
        if(status){
            view.showMessage("El paciente se ha registrado en la sala de espera correctamente");
        }else{
            view.showError("Ocurrio un error no se logro registrar al paciente en la sala de espera");
        }
        return status;
    }

    public Patient getNextPatient(){
        Patient patient=clinic.getNextPatient();
        if(patient==null){
            view.showError("No hay pacientes en espera");
            view.clear();
        }
        view.showData(patient);
        return patient;
    }

    public Patient attendNextPatient(){
         Patient patient=clinic.attendNextPatient();
        if(patient==null){
            view.showError("No hay pacientes en espera para atender");
            view.clear();
        }else{
            view.showMessage("Se ha atendido al paciente correctamente");
            view.showData(patient);
        }
        return patient;
    }

    public int getWaitingPatientCount(){
        return clinic.getWaitingPatientCount();
    }

    public boolean isPatientWaiting(String patientId){
        return clinic.isPatientWaiting(patientId);
    }
}
