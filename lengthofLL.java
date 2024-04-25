import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class lengthofLL {
    Node head;

    public int findLength() {
        int length = 0;
        Node current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        lengthofLL list = new lengthofLL();

        System.out.print("Enter the number of nodes in the linked list: ");
        int n = scanner.nextInt();

        System.out.println("Enter the values for each node:");

        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            list.insert(data);
        }

        int length = list.findLength();
        System.out.println("Length of the linked list: " + length);
    }
}
