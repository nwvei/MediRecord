/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WaitingRoom;

import clinic.SequentialDynamicList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import patients.Patient;

/**
 *
 * @author HP
 */
public class WaitingRoomList implements SequentialDynamicList<Patient> {
    Queue<Patient> waitingList;

    public WaitingRoomList(Queue<Patient> waitingList) {
        this.waitingList = new LinkedList();
    }

    @Override
    public Patient get() {
        waitingList.peek();
        return null;
    }

    @Override
    public boolean remove() {
       return waitingList.poll()!=null;
    }

    @Override
    public boolean add(Patient item) {
       try{
        return waitingList.add(item);
       }catch(IllegalStateException e){
           return false;
       }
    }

    @Override
    public Iterator getAll() {
    return waitingList.iterator();
    }

    @Override
    public int size() {
    return waitingList.size();
    }

    @Override
    public boolean isEmpty() {
        return waitingList.isEmpty();
    }

   
    
}
