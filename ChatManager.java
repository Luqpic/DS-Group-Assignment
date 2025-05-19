/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package groupassignment2;

// Group Tutorial [Tutorial Number]
// Group Members:
// Student 1: [Luqman] – Singly Linked List
// Student 2: [Muaz] – Indexed List
// Student 3: [Syakir] – Doubly Linked List with Cursor
// Student 4: [Amir] – Undo/Redo with Stack
// Student 5: [Adam] – Testing
// Student 6: [Meng] – Doubly Linked List with Cursor

import java.util.*;

public class ChatManager {
    // ===== Student 1 =====
    // [Luqman] – Singly Linked List
    static class SinglyLinkedList {
        static class Node {
            String data;
            Node next;
            Node(String data) {
                this.data = data;
            }
        }

        private Node head, tail;

        public void addFirst(String msg) {
            Node newNode = new Node(msg);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }

        public void addLast(String msg) {
            Node newNode = new Node(msg);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public String removeFirst() {
            if (head == null) {
                return null;
            }
            String removedData = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return removedData;
        }

        public void print() {
            Node current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }
}
