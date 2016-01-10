
public class Link {
    public String bookName;
    public int millionsSold;
    public Link next;

    public Link(String bookName, int millionsSold) {
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }

    public void display(){
        System.out.println(bookName + ": " + millionsSold + " 000 000");
    }

    @Override
    public String toString() {
        return bookName;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertFirstLink("The Lord of the Rings", 150);
        linkedList.insertFirstLink("Harry Potter and Half-Blood Prince", 500);
        linkedList.insertFirstLink("It", 200);
        linkedList.display();
        linkedList.removeFirst();
        System.out.println("---After remove method---\n");
        linkedList.display();
        System.out.println("Result of find method: " + linkedList.findName("Harry Potter and Half-Blood Prince"));
        linkedList.removeLink("Harry Potter and Half-Blood Prince");
        System.out.println("\n---After removeLink method, for Harry Potter---\n");
        linkedList.display();


    }
}

class LinkedList {
    public Link firstLink;

    LinkedList() {
        firstLink = null;
    }
    public boolean isEmpty() {
        return firstLink == null;
    }

    public void removeFirst(){
        if(!isEmpty()) {
            firstLink = firstLink.next;
        } else {
            System.out.println("Sorry, the LinkedList is empty");
        }
    }

    public void insertFirstLink(String bookName, int millionsSold) {
        Link newLink = new Link(bookName, millionsSold);
        newLink.next = firstLink;
        firstLink = newLink;
    }

    public void display() {
        Link link = firstLink;

        if(link == null) {
            System.out.println("Sorry, empty LinkedList");
        }
        while (link != null) {
            link.display();
            System.out.println("The next Link: " + link.next);
            link = link.next;
            System.out.println();
        }
    }

    public Link findName(String bookName){
        Link result = firstLink;

        if (isEmpty()){
            System.out.println("Sorry, the LinkedList is empty");
            return null;
        }

        while (result != null) {
            if(result.bookName.equals(bookName)) return result;

            if(result.next != null) {
                result = result.next;
            } else {
                result = null;
                System.out.println("There is no such book in the LinkedList");
            }
        }
        return result;
    }

    public void removeLink(String bookName){
        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while (!currentLink.bookName.equals(bookName)){
            if (currentLink == null) {
                return;
            } else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }

        if(currentLink.bookName.equals(firstLink.bookName)){
            firstLink = firstLink.next;
        } else {
            previousLink.next = currentLink.next;
        }
    }
}
