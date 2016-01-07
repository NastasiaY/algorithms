/**
 * Created by Anastasia on 07/01/16.
 */
public class Link {
    public String bookName;
    public int millionsSold;
    public Link next;

    public Link(String bookName, int millionsSold) {
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }

    public void display(){
        System.out.println(bookName + ": " + millionsSold + "000 000");
    }

    @Override
    public String toString() {
        return bookName;
    }

    public static void main(String[] args) {

    }
}

class LinkedList {
    public Link firstLink;

    LinkedList(Link firstLink) {
        firstLink = null;
    }
    public boolean isEmpty() {
        return firstLink == null;
    }

    public void removeFirst(){
        if(!isEmpty()) {
            firstLink = firstLink.next;
        } else {
            System.out.println("Empty LinkedList");
        }
    }

    public void insertFirstLink(String bookName, int millionsSold) {
        Link newLink = new Link(bookName, millionsSold);
        newLink.next = firstLink;
        firstLink = newLink;
    }

    public void display() {
        Link link = firstLink;

        while (firstLink != null) {
            link.display();
            System.out.println("The next Link: " + firstLink.next);
            firstLink = firstLink.next;
            System.out.println();
        }
    }

    public Link findName(String bookName){
        Link result = firstLink;

        if(!isEmpty()){
            while(!result.bookName.equals(bookName)){
                if(firstLink.next == null) {
                    return null;
                } else {
                    result = firstLink.next;
                }
            }
        } else {
            return null;
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
    public static void main(String[] args) {

    }
}
