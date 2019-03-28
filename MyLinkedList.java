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
public class MyLinkedList <E>{ 
    protected int size = 0 ;
    
    public MyLinkedList () {   //default constructor
        
    }
    
    Node<E> head = null ;   //nodes for head and tail
    Node<E> tail = null ;
    
    public void addFirst (E e) {
        Node<E> newNode = new Node<>(e); 
        newNode.next = head ; //create pointer to current head
        head = newNode ; // new node created and assigned to new head
        size++ ; // increase size 
        if (tail== null ) {
            tail = head ;
        }
    }
        
    public void addLast(E e) {
        if (tail == null) {
            head=tail= new Node<>(e) ;
        }
        else {
            tail.next = new Node<>(e) ; 
            tail = tail.next ;
        }
        size++ ;    
    }    
        
     public void add(int index,E e){
        if(index==0) addFirst(e);
        else if(index>=size) addLast(e);
        else{
            Node<E> current =head;
            for(int i =1 ;i<index;i++)
                current = current.next;
            Node<E> temp =current.next;
            current.next = new Node<>(e);
            (current.next).next =temp;
            size++;
        }   
    }
    
    public E removeFirst(){
        if(size ==0) return null;
        else{
            Node<E> temp = head ;
            head = head.next;
            size--;
            if(head==null) tail = null;
            return (E) temp.element;
        }
    }
    
    public E removeLast(){
        if(size==0) return null;
        else if(size==1){
            Node<E> temp = tail;
            tail = head = null;
            size=0;
            return (E) temp.element;
        }else{
            Node<E> current = head ;
            for(int i =0;i<size-2;i++){
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current ;
            tail.next = null;
            size--;
            return (E) temp.element;
        }
    }
    
    public E remove(int index){
        if(size==0 || index >= size) return null;
        else if(index ==0) return removeFirst();
        else if(index == size - 1) return removeLast();
        else{
            Node<E> previous =head;
            for(int i =1;i<index;i++){
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return (E) current.element;
        }
    }
    
    public void add(E e){
        addLast(e);
    }
    
    public boolean contains(E e){
        boolean flag = false;
        Node<E> current = head;
        while(current!=null){
            if(current.element == e){
                flag = true;
            }
            current = current.next;
        }
        return flag;
    }
    
    public E get(int index){
        if(size==0 || index >= size) return null;
        else{
            Node<E> current = head;
            for(int i = 0 ; i< index;i++){
                current = current.next;
            }
            return (E) current.element;
        }   
    }
    
    public E getFirst(){
        return get(0);
    }
    
    public E getLast(){
        return get(size -1);
    }
    
    public int indexOf(E e){
        Node<E> current = head;
        for(int i = 0; i < size; i++){
            if(current.element == e){
                return i;
            }
            current = current.next;
        }
        return -1;
    }
    
    public int lastIndexOf(E e){
        Node<E> current = head;
        int index = -1;
        for(int i = 0; i < size; i++){
            if(current.element == e){
                index = i;
            }
            current = current.next;
        }
        return index;
    }

    
    public E set(int index, E e){
        E temp = remove(index);
        add(index,e);
        return temp;
    }

    public void clear(){
        while (head.next != null){
            removeLast();
        }
        head = null;
        size = 0;
    }

    public void print(){
        Node<E> current = head;
        while (current != null){
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void reverse(){
        for (int i = size-1; i >= 0; i--){
            System.out.print(get(i) + " ");
        }
        System.out.println();
           
    }
    
 
}


