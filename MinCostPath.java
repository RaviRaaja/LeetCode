https://leetcode.com/problems/minimum-path-sum/
import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        // example 1
        int[][] grid1 = {{3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},{0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},{8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},{1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},{8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},{4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},{6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},{8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},{9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},{0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},{4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},{2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},{0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},{0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},{6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},{7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},{3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},{5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}};
        // example 2
        int[][] grid2 = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(basicSolution(grid1));
        System.out.println(solution(grid1));
    }

    public static int basicSolution(int[][] grid) {
         int m = grid.length-1;
         int n = grid[0].length-1;
         return minPathSumHelper(0,0,m,n,grid);
     }
     public static int minPathSumHelper(int x, int y, int m, int n,int[][] grid) {
         if(x>m || y>n) return  Integer.MAX_VALUE;

         if(x==m && y==n) return grid[m][n];

         int right = minPathSumHelper(x, y+1, m, n, grid);
         int down = minPathSumHelper(x+1, y, m, n,grid);

         return grid[x][y]+Math.min(right,down);
     }


    public static int solution(int[][] grid) {
        int[][] minCostGrid = new int[grid.length][grid[0].length];
        int cost;
        // filling columns
        cost = 0;
        for(int j=0; j<grid[0].length; j++) {
            cost += grid[0][j];
            minCostGrid[0][j] = cost;
        }
        // filling rows
        cost = 0;
        for(int i=0; i<grid.length; i++) {
            cost += grid[i][0];
            minCostGrid[i][0] = cost;
        }

        for(int i=1; i<grid.length; i++) {
            for(int j=1; j<grid[0].length; j++) {
                minCostGrid[i][j] = grid[i][j] + Math.min(minCostGrid[i-1][j],minCostGrid[i][j-1]);
            }
        }

        return minCostGrid[grid.length-1][grid[0].length-1];
    }

    // visualize the min cost path
    public static void printGrids(int[][] grid) {
        for(int[] i: grid) {
            System.out.println(Arrays.toString(i));
        }
    }
}
