package linkedList;


public class App {
    public static void main(String[] args) {
        LinkedListOfInteger l = new LinkedListOfInteger();
        LinkedListOfInteger l2 = new LinkedListOfInteger();
        l.add(35);
        l.add(0,90);
        l.add(1,41);
        l.add(2,26);
        l.add(78);
        l.add(10);
        
        l2.add(0,85);
        l2.add(1,3);
        l2.add(0,90);
        System.out.println(l);
        System.out.println(l2);
        
        
    }
}
