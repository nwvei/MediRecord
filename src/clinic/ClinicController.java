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
       
   }
   
   private ClinicController(Views view){
       this.clinic=new Clinic();
       this.view=view;
   }
   public void addPatient(Patient patient){

    }

    public void findPatient(String id){
        
    }

    public void removePatient(String id){
        
    }

    public Iterator<Patient> getPatients(){
        
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
        return false;
    }

    public Iterator<Appointment> getAppointments(){
        return null;
    }

    public boolean checkInPatient(String patientId){
        return false;
    }

    public Patient getNextPatient(){
        return null;
    }

    public Patient attendNextPatient(){
        return null;
    }

    public int getWaitingPatientCount(){
        return 0;
    }

    public boolean isPatientWaiting(String patientId){
        return false;
    }
}
