/*
create
insert
delete
get
set
search
display
*/

public class Array {

    int[] arr;
    int size;
    int capacity;

    // 1. Create
    Array(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    // 2. Insert at a specific index
    boolean insert(int index, int element) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index, can't insert");
            return false;
        }
        if (size >= capacity) {
            System.out.println("Array is full, can't insert");
            return false;
        }
        // Shift elements to the right
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        size++;
        return true;
    }

    // 3. Delete at a specific index
    boolean delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index, can't delete");
            return false;
        }
        // Shift elements to the left
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = 0; // Clear the trailing duplicate
        size--;
        return true;
    }

    // 4. Get element at index
    int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return -1;
        }
        return arr[index];
    }

    // 5. Set (update) element at index
    boolean set(int index, int element) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index, can't update");
            return false;
        }
        arr[index] = element;
        return true;
    }

    // 6. Search for an element (returns index or -1 if not found)
    int search(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    // 7. Display all elements
    void display() {
        if (size == 0) {
            System.out.println("Array is empty");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array arr1 = new Array(5);
        
        arr1.insert(0, 5); // Array: [5]
        arr1.insert(4, 6); // Prints "Invalid index, can't insert" (size is 1)
        arr1.insert(1, 6); // Array: [5, 6]
        arr1.insert(0, 7); // Array: [7, 5, 6]
        arr1.insert(0, 9); // Array: [9, 7, 5, 6]
        
        arr1.display();    // Output: 9 7 5 6
        
        arr1.set(1, 8);    // Array: [9, 8, 5, 6]
        System.out.println("Element at index 2: " + arr1.get(2)); // Output: 5
        System.out.println("Index of 6: " + arr1.search(6));      // Output: 3
        
        arr1.delete(1);    // Removes 8 -> Array: [9, 5, 6]
        arr1.display();    // Output: 9 5 6
    }
}
