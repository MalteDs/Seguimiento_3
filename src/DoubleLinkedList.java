public class DoubleLinkedList {

    private Node head;

    private Node tail;

    private Node position;

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
            position=node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
            tail=node;
            head.setPrevious(tail);
            tail.setNext(head);
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

    public int findNode(Node pointer, int value){
        if(pointer.getValue()!=value){ // hace la recursion cuando no encunetra al nodo
            findNode(pointer.getNext(),value);
        }else if (pointer!=null && pointer.getValue()==value){
            return pointer.getValue(); // null cuando no lo encuentra
        }
       return pointer.getValue();
    }

    public void saltarTurno(Node pointer){
        position=pointer.getNext();
    }

    public int getTurn(){
        return position.getValue();
    }
    public void deleteNode(Node pointer){
        pointer.setNext(pointer.getNext().getNext());
        pointer.getNext().getNext().setPrevious(pointer);
        pointer.getNext().setPrevious(null);
        position=pointer.getNext();
    }

    public void print(int i){
        print(head, i);
    }

    private void print(Node pointer, int i){

        if(i>=1){
            System.out.println(i);
            System.out.println(pointer);
            print(pointer.getNext(), i-1);
        }

    }

    public Node getHead() {
        return head;
    }

    public Node getTail() { return tail; }

    public Node getPosition(){return position; }
}
