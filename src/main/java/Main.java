//import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();

        myList.add("Islam");
        myList.add("Kerimov");
        myList.add("Best");
        myList.add("Student");

//        myList.remove("Best");
        System.out.println(myList.delete("Best1"));

        System.out.println(myList);

//        System.out.println(myList.size());
//        System.out.println(myList.getFirst());
//        System.out.println(myList.getLast());
    }
}
