/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author WIG180005
 */
public class Node<T> { 
    protected Node element ;
    protected Node next ;
    
    public Node () {
        element = null ;
        next = null ;
        
    }
    
    public Node ( T o ) {
        next = null ;
        element = null ;
        
    }
    
    
}
