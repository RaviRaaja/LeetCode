import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public static void main(String[] args) {
        // input given in question
        int[][] costs = new int[][]{{10,20},{30,200},{400,50},{30,20}};

        // below set will perform sorting on [-10, -170, 350, 10]
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));
        //  or do as below
        //  Arrays.sort(costs, (a,b) -> {
        //  return (a[0] - a[1]) - (b[0] - b[1]);
        //  });
        System.out.println("After sorting");
        printArr(costs);

        int minCost = 0;
        int n = costs.length/2;

        for(int i=0; i<costs.length; i++) {
            if(i<n) {
                minCost += costs[i][0];
            } else {
                minCost += costs[i][1];
            }
        }
        System.out.println(minCost);
    }

    public static void printArr(int[][] arr) {
        for(int[] i: arr) {
            System.out.println(Arrays.toString(i));
        }
    }
}
