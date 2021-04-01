/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;
import java.util.*;

/**
 *
 * @author Adjeman-Cofie Gerald
 */
class DoublyLinkedList {    
    //A node class for doubly linked list
    class Node{  
        String name;  
        Node previous;  
        Node next;  
   
        public Node(String name) {  
            this.name = name;  
        }  
    }  
    //Initially, heade and tail is set to null
    Node head, tail = null;  
   
    //add a node to the list  
    public void addNodehead(String name) {  
        //Create a new node  
        Node newNode = new Node(name);  
   
        //if list is empty, head and tail points to newNode  
        if(head == null) {  
            head = tail = newNode;  
            //head's previous will be null  
            head.previous = null;  
            //tail's next will be null  
            tail.next = null;  
        }  
        else {  
            //add newNode to the end of list. tail->next set to newNode  
            tail.next = newNode;  
            //newNode->previous set to tail  
            newNode.previous = tail;  
            //newNode becomes new tail  
            tail = newNode;  
            //tail's next point to null  
            tail.next = null;  
        }  
    }  
   
//print all the nodes of doubly linked list  
    public void printNodes() {  
        //Node current will point to head  
        Node current = head;  
        
        if(head == null) {  
            System.out.println("The Playlist empty.");  
            return;  
        }  
        System.out.println("SONGS IN THE PLAYLIST :");  
        while(current != null) {  
            //Print each node and then go to next. 
            System.out.print(current.name + " \n");
            current = current.next; 
            
        } 
        
         Node last = tail;
        if(tail == null) {  
            System.out.println("The Playlist is empty.");  
            return;  
        }  
         System.out.println("\nSongs in the reverse direction ");
    while (last != null) {
         //Print each node and then go to next.  
        System.out.print(last.name + " \n");
        last = last.previous;
        
    }
    }
    /* Given a node as previous node, insert a new node after the given node */
public void addNode(Node previous,String name)
{
 //Node newNode = new Node(name);  
    /*1. check if the given prev_node is NULL */
    if (previous == null) {
        System.out.println("The given previous node cannot be NULL ");
        return;
    }
 
    /* 2. allocate node 
    * 3. put in the data */
    Node new_node = new Node(name);
 
    /* 4. Make next of new node as next of previous node */
    new_node.next = previous.next;
 
    /* 5. Make the next of prev_node as new_node */
    previous.next = new_node;
 
    /* 6. Make prev_node as previous of new_node */
    new_node.previous = previous;
 
    /* 7. Change previous of new_node's next node */
    if (new_node.next != null)
        new_node.next.previous = new_node;
}
    public void deleteFromStart() {  
        //Checks whether list is empty  
        if(head == null) {  
            return;  
        }  
        else {  
            //Checks whether the list contains only one element  
            if(head != tail) {  
                //head will point to next node in the list  
                head = head.next;  
                //Previous node to current head will be made null  
                head.previous = null;  
            }  
            //If the list contains only one element  
            //then, it will remove node and now both head and tail will point to null  
            else {  
                head = tail = null;  
            }  
        }  
    }  

    public static void main(String[] args) {  
        //create a DoublyLinkedList object
        DoublyLinkedList dl_List = new DoublyLinkedList();  
        Scanner Gerald = new Scanner(System.in);
        dl_List.addNodehead("CONFESSION");
        dl_List.addNodehead("LOVE");
        dl_List.addNodehead("WE NEED PEACE");
        dl_List.addNodehead("NHYIRA");
        dl_List.addNodehead("JOWO");
        dl_List.addNodehead("ASSURANCE");
        dl_List.addNodehead("GREAT GOD");
        dl_List.addNodehead("FORGIVE");
        dl_List.addNodehead("HOW GREAT THOU ART");
        dl_List.addNodehead("CONFESSION");
        dl_List.printNodes();  
        int treesize;
        System.out.println("Please enter the number of songs to add");
        treesize = Gerald.nextInt();
         System.out.println("Please enter the title of the songs ");
        String node;
        int count =0;
        while(count<=treesize) 
        {
            //System.out.println("Name: " + count);
            node = Gerald.nextLine();
            //Inserting the nodes
             dl_List.addNodehead(node.toUpperCase());  
              count++;
        } 
   
        //print the nodes of DoublyLinkedList  
        dl_List.printNodes();  
        
       /* System.out.println("\nPlease enter the new family head ");
        node = Gerald.nextLine();
        dl_List.addNode(dl_List.head.next.previous, node);
        dl_List.printNodes();  
        
        System.out.println("\nPlease enter the new name to add ");
        node = Gerald.nextLine();
        
        dl_List.addNodehead(node);
        dl_List.printNodes();
        
        dl_List.deleteFromStart();
        dl_List.printNodes();

        
        System.out.println("\nThe size of the list is: "+node.length());
        */
        
        
    } 
}
    