import java.util.Scanner;

public class LinkedListManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SinglyLinkedList singlyList = new SinglyLinkedList();
    private static final DoublyLinkedList doublyList = new DoublyLinkedList();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMainMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> singlyMenu();
                case 2 -> doublyMenu();
                case 3 -> compareLists();
                case 4 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using Linked List Management System.");
        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\n==================================================");
        System.out.println("          LINKED LIST MANAGEMENT SYSTEM");
        System.out.println("==================================================");
        System.out.println("1. Singly Linked List");
        System.out.println("2. Doubly Linked List");
        System.out.println("3. Compare Singly vs Doubly Linked List");
        System.out.println("4. Exit");
    }

    private static void singlyMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n********** Operations on Singly Linked List **********");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display");
            System.out.println("13. Count Nodes");
            System.out.println("14. Find Maximum");
            System.out.println("15. Find Minimum");
            System.out.println("16. Find Middle Element");
            System.out.println("17. Reverse");
            System.out.println("18. Sort");
            System.out.println("19. Remove Duplicates");
            System.out.println("20. Exit");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> singlyList.insertAtBeginning(readInt("Enter value: "));
                case 2 -> singlyList.insertAtEnd(readInt("Enter value: "));
                case 3 -> insertSinglyAtPosition();
                case 4 -> insertSinglyAfter();
                case 5 -> insertSinglyBefore();
                case 6 -> printDeleted(singlyList.deleteFromBeginning());
                case 7 -> printDeleted(singlyList.deleteFromEnd());
                case 8 -> printDeleted(singlyList.deleteAtPosition(readInt("Enter position: ")));
                case 9 -> printStatus(singlyList.deleteByValue(readInt("Enter value to delete: ")), "Value deleted.", "Value not found.");
                case 10 -> printSearchResult(singlyList.search(readInt("Enter value to search: ")));
                case 11 -> updateSingly();
                case 12 -> System.out.println("List: " + singlyList.display());
                case 13 -> System.out.println("Number of nodes: " + singlyList.countNodes());
                case 14 -> printNullable("Maximum", singlyList.findMaximum());
                case 15 -> printNullable("Minimum", singlyList.findMinimum());
                case 16 -> printNullable("Middle element", singlyList.findMiddleElement());
                case 17 -> singlyList.reverse();
                case 18 -> singlyList.sort();
                case 19 -> singlyList.removeDuplicates();
                case 20 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }

            if (choice != 20) {
                pause();
            }
        }
    }

    private static void doublyMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n********** Operations on Doubly Linked List **********");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle Element");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Exit");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> doublyList.insertAtBeginning(readInt("Enter value: "));
                case 2 -> doublyList.insertAtEnd(readInt("Enter value: "));
                case 3 -> insertDoublyAtPosition();
                case 4 -> insertDoublyAfter();
                case 5 -> insertDoublyBefore();
                case 6 -> printDeleted(doublyList.deleteFromBeginning());
                case 7 -> printDeleted(doublyList.deleteFromEnd());
                case 8 -> printDeleted(doublyList.deleteAtPosition(readInt("Enter position: ")));
                case 9 -> printStatus(doublyList.deleteByValue(readInt("Enter value to delete: ")), "Value deleted.", "Value not found.");
                case 10 -> printSearchResult(doublyList.search(readInt("Enter value to search: ")));
                case 11 -> updateDoubly();
                case 12 -> System.out.println("Forward: " + doublyList.displayForward());
                case 13 -> System.out.println("Backward: " + doublyList.displayBackward());
                case 14 -> System.out.println("Number of nodes: " + doublyList.countNodes());
                case 15 -> printNullable("Maximum", doublyList.findMaximum());
                case 16 -> printNullable("Minimum", doublyList.findMinimum());
                case 17 -> printNullable("Middle element", doublyList.findMiddleElement());
                case 18 -> doublyList.reverse();
                case 19 -> doublyList.sort();
                case 20 -> doublyList.removeDuplicates();
                case 21 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }

            if (choice != 21) {
                pause();
            }
        }
    }

    private static void insertSinglyAtPosition() {
        int value = readInt("Enter value: ");
        int position = readInt("Enter 1-based position: ");
        printStatus(singlyList.insertAtPosition(value, position), "Value inserted.", "Invalid position.");
    }

    private static void insertSinglyAfter() {
        int target = readInt("Insert after which value: ");
        int value = readInt("Enter new value: ");
        printStatus(singlyList.insertAfter(target, value), "Value inserted.", "Target value not found.");
    }

    private static void insertSinglyBefore() {
        int target = readInt("Insert before which value: ");
        int value = readInt("Enter new value: ");
        printStatus(singlyList.insertBefore(target, value), "Value inserted.", "Target value not found.");
    }

    private static void updateSingly() {
        int oldValue = readInt("Enter value to update: ");
        int newValue = readInt("Enter new value: ");
        printStatus(singlyList.update(oldValue, newValue), "Value updated.", "Value not found.");
    }

    private static void insertDoublyAtPosition() {
        int value = readInt("Enter value: ");
        int position = readInt("Enter 1-based position: ");
        printStatus(doublyList.insertAtPosition(value, position), "Value inserted.", "Invalid position.");
    }

    private static void insertDoublyAfter() {
        int target = readInt("Insert after which value: ");
        int value = readInt("Enter new value: ");
        printStatus(doublyList.insertAfter(target, value), "Value inserted.", "Target value not found.");
    }

    private static void insertDoublyBefore() {
        int target = readInt("Insert before which value: ");
        int value = readInt("Enter new value: ");
        printStatus(doublyList.insertBefore(target, value), "Value inserted.", "Target value not found.");
    }

    private static void updateDoubly() {
        int oldValue = readInt("Enter value to update: ");
        int newValue = readInt("Enter new value: ");
        printStatus(doublyList.update(oldValue, newValue), "Value updated.", "Value not found.");
    }

    private static void compareLists() {
        System.out.println("\nSingly Linked List");
        System.out.println("- Each node stores data and a next reference.");
        System.out.println("- Traversal is forward only.");
        System.out.println("- Uses less memory per node.");
        System.out.println("- Deleting from the end requires finding the previous node.");

        System.out.println("\nDoubly Linked List");
        System.out.println("- Each node stores data, a previous reference, and a next reference.");
        System.out.println("- Traversal is possible in both directions.");
        System.out.println("- Uses more memory per node.");
        System.out.println("- Deletion and backward traversal are more convenient.");

        System.out.println("\nMost basic operations are O(n), while insertion at the beginning is O(1).");
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);

        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scanner.next();
            System.out.print(prompt);
        }

        return scanner.nextInt();
    }

    private static void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
        scanner.nextLine();
    }

    private static void printDeleted(Integer value) {
        if (value == null) {
            System.out.println("The list is empty or the position is invalid.");
        } else {
            System.out.println("Deleted value: " + value);
        }
    }

    private static void printSearchResult(int position) {
        if (position == -1) {
            System.out.println("Value not found.");
        } else {
            System.out.println("Value found at position: " + position);
        }
    }

    private static void printNullable(String label, Integer value) {
        if (value == null) {
            System.out.println("The list is empty.");
        } else {
            System.out.println(label + ": " + value);
        }
    }

    private static void printStatus(boolean success, String successMessage, String failureMessage) {
        System.out.println(success ? successMessage : failureMessage);
    }
}
