public class DoublyLinkedList {
    private static class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;

        if (head != null) {
            head.previous = newNode;
        } else {
            tail = newNode;
        }

        head = newNode;
        size++;
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        newNode.previous = tail;

        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }

        tail = newNode;
        size++;
    }

    public boolean insertAtPosition(int value, int position) {
        if (position < 1 || position > size + 1) {
            return false;
        }

        if (position == 1) {
            insertAtBeginning(value);
            return true;
        }

        if (position == size + 1) {
            insertAtEnd(value);
            return true;
        }

        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        Node newNode = new Node(value);
        newNode.previous = current;
        newNode.next = current.next;
        current.next.previous = newNode;
        current.next = newNode;
        size++;
        return true;
    }

    public boolean insertAfter(int target, int value) {
        Node current = findNode(target);
        if (current == null) {
            return false;
        }

        if (current == tail) {
            insertAtEnd(value);
            return true;
        }

        Node newNode = new Node(value);
        newNode.previous = current;
        newNode.next = current.next;
        current.next.previous = newNode;
        current.next = newNode;
        size++;
        return true;
    }

    public boolean insertBefore(int target, int value) {
        Node current = findNode(target);
        if (current == null) {
            return false;
        }

        if (current == head) {
            insertAtBeginning(value);
            return true;
        }

        Node newNode = new Node(value);
        newNode.previous = current.previous;
        newNode.next = current;
        current.previous.next = newNode;
        current.previous = newNode;
        size++;
        return true;
    }

    public Integer deleteFromBeginning() {
        if (head == null) {
            return null;
        }

        int removed = head.data;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        } else {
            head.previous = null;
        }

        return removed;
    }

    public Integer deleteFromEnd() {
        if (tail == null) {
            return null;
        }

        int removed = tail.data;
        tail = tail.previous;
        size--;

        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }

        return removed;
    }

    public Integer deleteAtPosition(int position) {
        if (position < 1 || position > size) {
            return null;
        }

        if (position == 1) {
            return deleteFromBeginning();
        }

        if (position == size) {
            return deleteFromEnd();
        }

        Node current = nodeAt(position);
        int removed = current.data;
        current.previous.next = current.next;
        current.next.previous = current.previous;
        size--;
        return removed;
    }

    public boolean deleteByValue(int value) {
        Node current = findNode(value);
        if (current == null) {
            return false;
        }

        if (current == head) {
            deleteFromBeginning();
        } else if (current == tail) {
            deleteFromEnd();
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
        }

        return true;
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
        Node current = findNode(oldValue);
        if (current == null) {
            return false;
        }

        current.data = newValue;
        return true;
    }

    public int countNodes() {
        return size;
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
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = current.previous;
            current.previous = next;
            current = next;
        }

        Node temporary = head;
        head = tail;
        tail = temporary;
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
            Node runner = current.next;

            while (runner != null) {
                Node next = runner.next;

                if (runner.data == current.data) {
                    if (runner == tail) {
                        tail = runner.previous;
                    }
                    runner.previous.next = runner.next;
                    if (runner.next != null) {
                        runner.next.previous = runner.previous;
                    }
                    size--;
                }

                runner = next;
            }

            current = current.next;
        }
    }

    public String displayForward() {
        if (head == null) {
            return "NULL";
        }

        StringBuilder result = new StringBuilder("NULL <- ");
        Node current = head;

        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(" <-> ");
            }
            current = current.next;
        }

        result.append(" -> NULL");
        return result.toString();
    }

    public String displayBackward() {
        if (tail == null) {
            return "NULL";
        }

        StringBuilder result = new StringBuilder("NULL <- ");
        Node current = tail;

        while (current != null) {
            result.append(current.data);
            if (current.previous != null) {
                result.append(" <-> ");
            }
            current = current.previous;
        }

        result.append(" -> NULL");
        return result.toString();
    }

    private Node findNode(int value) {
        Node current = head;

        while (current != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    private Node nodeAt(int position) {
        Node current;

        if (position <= size / 2) {
            current = head;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size; i > position; i--) {
                current = current.previous;
            }
        }

        return current;
    }
}
