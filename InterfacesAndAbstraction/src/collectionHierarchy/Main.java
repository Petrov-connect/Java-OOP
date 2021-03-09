package collectionHierarchy;
//created by J.M.

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static List<MyList>collections=new ArrayList<>(){{
        add((MyList) new AddCollection());
        add((MyList) new AddRemoveCollection());
        add((MyList) new AddRemoveCollection());}};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());

        addToCollection(input,0);
        addToCollection(input,1);
        addToCollection(input,2);
        removeFromCollection(n,2);
        removeFromCollection(n,3);
    }

    private static void removeFromCollection(int range , int index) {
        IntStream.range(0, range).forEach(i -> System.out.printf("%s ", collections.get(index).remove()));
        System.out.println();
    }

    private static void addToCollection(String[] input, int index) {
        Arrays.stream(input).forEach(e -> System.out.printf("%d ", collections.get(index).add(e)));
        System.out.println();
    }
}
