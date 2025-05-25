
  class DoublyLinkedListWithCursor {
    static class Node {
        String data;
        Node prev, next;
        Node(String data) {
            this.data = data;
        }
    }

    Node head, tail, cursor;

    // Insert a new node at the cursor position
    void insertAtCursor(String msg) {
        Node newNode = new Node(msg);
        if (head == null) {
            // Empty list
            head = tail = cursor = newNode;
        } else {
            // Add a new node after cursor
            newNode.next = cursor.next;
            if(newNode.next!=null)
            newNode.next.prev = newNode;
            newNode.prev = cursor;
            cursor.next = newNode;
            cursor = newNode;
        }
    }

    // Move the cursor one node to the left
    void moveLeft() {
        if (cursor != null && cursor.prev != null) {
            cursor = cursor.prev;
        }
    }

    // Move the cursor one node to the right
    void moveRight() {
        if (cursor != null && cursor.next != null) {
            cursor = cursor.next;
        }
    }

    // Print the list, highlighting the cursor node with brackets
    void print() {
        Node current = head;
        while (current != null) {
            if (current == cursor) {
                System.out.print("[" + current.data + "] <-> ");
            } else {
                System.out.print(current.data + " <-> ");
            }
            current = current.next;
        }
        System.out.println("null");
    }
}
