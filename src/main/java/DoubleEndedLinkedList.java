
public class DoubleEndedLinkedList {
    Neighbor firstLink;
    Neighbor lastLink;

    public void insertInFirstPosition(String houseOwnerName, int houseNumber){
        Neighbor newLink = new Neighbor(houseOwnerName, houseNumber);

        if(isEmpty()) lastLink = newLink;

        newLink.next = firstLink;
        firstLink = newLink;

    }

    public void insertInLastPosition(String houseOwnerName, int houseNumber){
        Neighbor newLink = new Neighbor(houseOwnerName, houseNumber);

        if(isEmpty()){
            firstLink = newLink;
        } else {
            lastLink.next = newLink;
        }
        lastLink = newLink;
    }

    public void insertAfterKey(String houseOwnerName, int houseNumber, int key){

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

        linkedList.insertInFirstPosition("Harry", 5);
        linkedList.insertInFirstPosition("Ron", 8);
        linkedList.insertInLastPosition("Hermione", 1);
        linkedList.insertInFirstPosition("Luna", 10);

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

