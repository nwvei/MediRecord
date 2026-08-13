/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicalrecords;

import clinic.SequentialDynamicList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Adriel
 */
public class MedicalRecordsList implements SequentialDynamicList<MedicalRecord>{
    private Stack<MedicalRecord>medicalHistory;

    public MedicalRecordsList(){
        this.medicalHistory = new Stack();
    }
    
@Override
    public MedicalRecord get() {
        try{
            
        
        return medicalHistory.peek();
        }catch(EmptyStackException e){
            return null;
        }
    }

    @Override
    public boolean remove() {
        try{
       return medicalHistory.pop()!=null;
          }catch(EmptyStackException e){
            return false ;
        }
        
    }

    @Override
    public boolean add(MedicalRecord item) {
        return medicalHistory.add(item); 
    }

    @Override
    public Iterator getAll() {
       if(medicalHistory.isEmpty())return null;
       return medicalHistory.iterator();
    }

    @Override
    public int size() {
       return medicalHistory.size();
    }

    @Override
    public boolean isEmpty() {
        return medicalHistory.isEmpty();
    }

    
   
    
    
    
    
   
}
