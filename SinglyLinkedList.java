public class SinglyLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public boolean insertAtPosition(int value, int position) {
        if (position < 1) {
            return false;
        }

        if (position == 1) {
            insertAtBeginning(value);
            return true;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        return true;
    }

    public boolean insertAfter(int target, int value) {
        Node current = head;

        while (current != null) {
            if (current.data == target) {
                Node newNode = new Node(value);
                newNode.next = current.next;
                current.next = newNode;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public boolean insertBefore(int target, int value) {
        if (head == null) {
            return false;
        }

        if (head.data == target) {
            insertAtBeginning(value);
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == target) {
                Node newNode = new Node(value);
                newNode.next = current.next;
                current.next = newNode;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public Integer deleteFromBeginning() {
        if (head == null) {
            return null;
        }

        int removed = head.data;
        head = head.next;
        return removed;
    }

    public Integer deleteFromEnd() {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return deleteFromBeginning();
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        int removed = current.next.data;
        current.next = null;
        return removed;
    }

    public Integer deleteAtPosition(int position) {
        if (position < 1 || head == null) {
            return null;
        }

        if (position == 1) {
            return deleteFromBeginning();
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            return null;
        }

        int removed = current.next.data;
        current.next = current.next.next;
        return removed;
    }

    public boolean deleteByValue(int value) {
        if (head == null) {
            return false;
        }

        if (head.data == value) {
            deleteFromBeginning();
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public int search(int value) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data == value) {
                return position;
            }
            current = current.next;
            position++;
        }

        return -1;
    }

    public boolean update(int oldValue, int newValue) {
        Node current = head;

        while (current != null) {
            if (current.data == oldValue) {
                current.data = newValue;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public int countNodes() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public Integer findMaximum() {
        if (head == null) {
            return null;
        }

        int maximum = head.data;
        Node current = head.next;

        while (current != null) {
            maximum = Math.max(maximum, current.data);
            current = current.next;
        }

        return maximum;
    }

    public Integer findMinimum() {
        if (head == null) {
            return null;
        }

        int minimum = head.data;
        Node current = head.next;

        while (current != null) {
            minimum = Math.min(minimum, current.data);
            current = current.next;
        }

        return minimum;
    }

    public Integer findMiddleElement() {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public void reverse() {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = head;

            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temporary = current.data;
                    current.data = current.next.data;
                    current.next.data = temporary;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void removeDuplicates() {
        Node current = head;

        while (current != null) {
            Node runner = current;

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }

    public String display() {
        if (head == null) {
            return "NULL";
        }

        StringBuilder result = new StringBuilder();
        Node current = head;

        while (current != null) {
            result.append(current.data).append(" -> ");
            current = current.next;
        }

        result.append("NULL");
        return result.toString();
    }
}
