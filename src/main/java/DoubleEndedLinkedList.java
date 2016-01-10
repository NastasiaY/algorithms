
public class DoubleEndedLinkedList {

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

