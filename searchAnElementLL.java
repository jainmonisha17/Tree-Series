import java.util.Scanner;

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class searchAnElementLL {
    ListNode head;

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            head = newNode;
            return;
        }

        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    // Method to search for an element in the linked list
    public boolean search(int target) {
        ListNode current = head;

        while (current != null) {
            if (current.data == target) {
                return true; // Element found
            }
            current = current.next;
        }

        return false; // Element not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        searchAnElementLL list = new searchAnElementLL();

        System.out.print("Enter the number of nodes in the linked list: ");
        int n = scanner.nextInt();

        System.out.println("Enter the values for each node:");

        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            list.insert(data);
        }

        System.out.print("Enter the value to search: ");
        int target = scanner.nextInt();

        boolean found = list.search(target);

        if (found) {
            System.out.println("Element " + target + " found in the linked list.");
        } else {
            System.out.println("Element " + target + " not found in the linked list.");
        }
    }
}
