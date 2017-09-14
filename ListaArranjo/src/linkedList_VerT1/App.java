package linkedList_VerT1;


public class App {
    public static void main(String[] args) {
        LinkedListOfInteger l1 = new LinkedListOfInteger();
        LinkedListOfInteger l2 = new LinkedListOfInteger();
        LinkedListOfInteger l3 = new LinkedListOfInteger();
        LinkedListOfInteger l4 = new LinkedListOfInteger();
        LinkedListOfInteger l5 = new LinkedListOfInteger();
        
        l1.add(1);l1.add(2);l1.add(3);l1.add(4);l1.add(5);l1.add(6);
        l2 = l1.clone();
        System.out.println("l2={1,2,3,4,5,6}\n" + l2);
        
        l3.add(2);l3.add(2);l3.add(3);l3.add(4);l3.add(5);l3.add(6);
        boolean b = l3.removeEvenNumbers();
        System.out.println("l3={3,5} " + "Removeu?" + b + "\n" + l3);
        
        l4.add(2);l4.add(4);l4.add(6);
        b = l4.removeEvenNumbers();
        System.out.println("l4={} "+ "Removeu?" + b + "\n" + l4);
        
        l5.add(3);l5.add(5);l5.add(7);
        b = l5.removeEvenNumbers();
        System.out.println("l4={3,5,7} "+ "Removeu?" + b + "\n" + l5);        
        
    }
}

