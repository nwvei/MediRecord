/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic;

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
}
