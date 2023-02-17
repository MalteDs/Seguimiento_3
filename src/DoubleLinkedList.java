public class DoubleLinkedList {

    private Node head;

    private Node tail;

    public void addNodeAtHead(Node node){
        if(head==null){ // lista vacia
            tail=node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
        }
        head=node;
    }
    public void addNodeAtTail(Node node){
        if(head==null){ // lista vacia
            head=node;
            tail=node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail=node;
            tail.setNext(head);
            head.setPrevious(tail);
        }

    }


    public void deleteNodeAtHead(){
        if(head!=null){
            head=head.getNext();
            head.setPrevious(null);
        }
    }


    public void deleteNodeAtTail(){
        if(tail!=null){
            tail=tail.getPrevious();
            tail.setNext(null);
        }
    }

    public int findInHead(Node pointer, int value) {
        if (pointer.getValue() == value) {
            return pointer.getValue();
        }
        else findNode(pointer, value);
        return findNode(pointer, value);
    }
    public int findNode(Node pointer, int value){
        if(pointer.getValue()!=value){ // hace la recursion cuando no encunetra al nodo
            findNode(pointer.getNext(),value);
        }else if (pointer!=null && pointer.getValue()==value){
            return pointer.getValue(); // null cuando no lo encuentra
        }
       return pointer.getValue();
    }

    public void deleteNode(Node pointer, int value){
        if(pointer!=null && pointer.getValue()!=value) {
            findNode(pointer.getNext(), value);
        }
        else if (pointer!=null && pointer.getValue()==value){
            pointer.setNext(pointer.getNext().getNext());
            pointer.getNext().getNext().setPrevious(pointer);
            pointer.getNext().setPrevious(null);
        }
    }

    public void nextNode(Node pointer, int turno){

    }
    public void print(){
        print(head);
    }

    private void print(Node pointer){
        if(pointer!=null){
            System.out.println(pointer);
            print(pointer.getNext());
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() { return tail; }
}
