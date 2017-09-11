package listaComArranjo1;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ListaComArranjo minhaLista = new ListaComArranjo();
        ListaComArranjo lista2 = new ListaComArranjo();
        
        minhaLista.add(1);
        minhaLista.add(2);
        minhaLista.add(3);
        minhaLista.add(4);
        minhaLista.add(5);
        minhaLista.add(6);
        minhaLista.add(7);
       System.out.println(minhaLista+"\n");
       minhaLista.removeByIndex(2);
       System.out.println(minhaLista+"\n");
       
        
         // int [] aux = L1.subList(1, 4);
        // for(int i = 0 ; i < aux.length; i++){	
        //	System.out.print(aux[i] + ",");
       
        
        System.out.print(" Sub-List = ");
        System.out.println(Arrays.toString(minhaLista.sublist(0, 5)));
        System.out.print(" Reverse = ");
        minhaLista.reverse();
        System.out.println(minhaLista);
        System.out.print(" Add Increasing Order = " );
        lista2.addIncreasingOrder(7);
        lista2.addIncreasingOrder(5);
        lista2.addIncreasingOrder(3);
        lista2.addIncreasingOrder(1);
        lista2.addIncreasingOrder(2);
        lista2.addIncreasingOrder(8);
        lista2.addIncreasingOrder(4);
        lista2.addIncreasingOrder(2);
        lista2.addIncreasingOrder(2);
        System.out.print(lista2);
        System.out.print("\n" + " Count Occurrences = " + lista2.countOccurrences(2));
        
        
        
        
        
    }    
}
