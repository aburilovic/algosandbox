

public class LinkedList {
    Element head = null;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addElement(5);
        list.addElement(7);
        list.addElement(9);
        list.addElement(2);
        list.addElement(1);
        list.addElement(9);
        list.addElement(4);
        list.printList();
        System.out.println("__________________________");
        list.addElement(6);
        list.printList();
    }

    private Element addElement(int newValue) {
        Element createdElement = new Element(newValue);
        if (head == null) {
            head = createdElement;
            return head;
        } else {
            Element currentElement = head;
            Element nextElement;
            int currentValue = currentElement.value;
            int nextValue;
            boolean elementInserted = false;
            while (currentElement.next != null) {
                nextElement = currentElement.next;
                nextValue = nextElement.value;
                if (newValue > currentValue && newValue < nextValue) {
                    //insert element here
                    currentElement.next = createdElement;
                    createdElement.next = nextElement;
                    elementInserted = true;
                    break;
                } else if (newValue < currentValue) {
                    // insert at beginning
                    nextElement = head;
                    head = createdElement;
                    head.next = nextElement;
                    elementInserted = true;
                    break;
                } else if (newValue == currentValue) {
                    return currentElement;
                }
                currentElement = currentElement.next;
            }
            if (!elementInserted) {
                //add it to the end
                currentElement.next = createdElement;
            }
        }
        return createdElement;
    }

    private void printList() {
        Element current = head;
        while (current.next != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}

class Element {
    Element next;
    int value;

    Element(int value) {
        this.value = value;
        next = null;
    }
}