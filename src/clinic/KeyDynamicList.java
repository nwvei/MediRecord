/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clinic;

/**
 *
 * @author UTN
 * @param <T>
 * @param <K>
 */
public interface KeyDynamicList<T,K> extends DynamicList<T,K>{
    public T get(K id);
    public boolean remove(K id);
}
