import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

public class DoubleEndedLinkedList {
    Neighbor firstLink;
    Neighbor lastLink;

    public void insertInFirstPosition(String houseOwnerName, int houseNumber){
        Neighbor newLink = new Neighbor(houseOwnerName, houseNumber);

        if(isEmpty()) {
            lastLink = newLink;
        } else {
            firstLink.previous = newLink;
        }

        newLink.next = firstLink;
        firstLink = newLink;

    }

    public void insertInLastPosition(String houseOwnerName, int houseNumber){
        Neighbor newLink = new Neighbor(houseOwnerName, houseNumber);

        if(isEmpty()){
            firstLink = newLink;
        } else {
            lastLink.next = newLink;
            newLink.previous = lastLink;
        }
        lastLink = newLink;
    }

    public void insertAfterKey(String houseOwnerName, int houseNumber, int key){
        Neighbor newLink = new Neighbor(houseOwnerName, houseNumber);
        Neighbor currentLink = firstLink;

        while (currentLink.houseNumber != key) {
            currentLink = currentLink.next;
            if (currentLink == null) {
                System.out.println("No matches");
                return;
            }
        }

        if (currentLink == lastLink) {
            newLink.next = null;
            lastLink = newLink;
        } else {
            newLink.next = currentLink.next;
            currentLink.next.previous = newLink;
        }

        newLink.previous = currentLink;
        currentLink.next = newLink;
    }

    public void insertInOrder(String houseOwnerName, int houseNumber){
        Neighbor newLink = new Neighbor(houseOwnerName, houseNumber);

        Neighbor previousNeighbor = null;
        Neighbor currentNeighbor = firstLink;

        while((currentNeighbor != null) && (currentNeighbor.houseNumber < houseNumber)){
            previousNeighbor = currentNeighbor;
            currentNeighbor = currentNeighbor.next;
        }
        if(previousNeighbor == null) {
            firstLink = newLink;
        } else {
            previousNeighbor.next = newLink;
        }

        newLink.next = currentNeighbor;
    }

    public void display(){
        Neighbor tempLink = firstLink;
        if(tempLink == null) {
            System.out.println("Sorry, empty DoubleLinkedList");
        }
        while (tempLink != null) {
            tempLink.display();
            System.out.println("The next Link: " + tempLink.next);
            tempLink = tempLink.next;
            System.out.println();
        }
    }

    public boolean isEmpty(){
        return firstLink == null;
    }

    public static void main(String[] args) {
        DoubleEndedLinkedList linkedList = new DoubleEndedLinkedList();


        linkedList.insertInOrder("Harry", 5);
        linkedList.insertInOrder("Ron", 8);
        linkedList.insertInOrder("Hermione", 1);
        linkedList.insertInOrder("Luna", 10);

        linkedList.insertAfterKey("Me", 6, 1);

        NeighborIterator iterator = new NeighborIterator(linkedList);

        linkedList.display();

        System.out.println("---After remove method---");

        iterator.remove();

        linkedList.display();



    }

}

class Neighbor {
    public String houseOwnerName;
    public int houseNumber;
    public Neighbor next;
    public Neighbor previous;

    public Neighbor(String houseOwner, int houseNumber) {
        this.houseOwnerName = houseOwner;
        this.houseNumber = houseNumber;
    }

    public void display() {
        System.out.println(houseOwnerName + ": " + houseNumber + ", Wall str.");
    }

    @Override
    public String toString() {
        return houseOwnerName;
    }
}

class NeighborIterator {
    Neighbor currentNeighbor;
    Neighbor previousNeighbor;

    DoubleEndedLinkedList neighbors;

    public NeighborIterator(DoubleEndedLinkedList neighbors) {
        this.currentNeighbor = neighbors.firstLink ;
        this.previousNeighbor = neighbors.lastLink;
        this.neighbors = neighbors;
    }

    public boolean hasNext(){
        return currentNeighbor.next != null;
    }

    public Neighbor next(){
        if(hasNext()) {
            previousNeighbor = currentNeighbor;
            currentNeighbor = currentNeighbor.next;
            return currentNeighbor;
        }
        return null;
    }

    public void remove(){
        if(currentNeighbor == null) {
            System.out.println("Sorry, the list is empty");
        } else {
            if(currentNeighbor == previousNeighbor) { //Is we have only one row
                neighbors.firstLink = null;
            } else {
                neighbors.firstLink = neighbors.firstLink.next;
            }
        }
    }
}
