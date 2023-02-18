import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i=1;
        Scanner sc = new Scanner(System.in);
        DoubleLinkedList list = new DoubleLinkedList();
        boolean out=false;
        while(!out){
            System.out.println("1. Dar turno");
            System.out.println("2. Mostrar truno actual");
            System.out.println("3. Pasar turno");
            System.out.println("4. Seguir");
            System.out.println("5. Salir");
            int sel=sc.nextInt();
            switch (sel) {
                case 1:
                    list.addNodeAtTail(new Node(i));
                    i++;
                    break;
                case 2:
                    System.out.println("Turno: "+list.getTurn());
                    break;
                case 3: list.saltarTurno(list.getPosition());
                    break;
                case 4: list.deleteNode(list.getHead());
                    break;
                case 5: out=true;

            }
        }
    }
}