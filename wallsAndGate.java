/*
*You are given an m x n grid rooms initialized with these three possible values.
*
* -1 A wall or an obstacle.
*  0 A gate.
*  INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
*
* Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
*/
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int[][] dirs = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<rooms.length; i++) {
            for(int j=0; j<rooms[i].length; j++) {
                if(rooms[i][j] == 0) q.offer(new int[]{i,j});
            }
        }
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            
            for(int[] dir: dirs) {
                int newI = i + dir[0];
                int newJ = j + dir[1];
                // check invalid
                if(newI<0 || newJ<0 || newI>=rooms.length || newJ>=rooms[0].length ||
                  rooms[newI][newJ] == -1 || rooms[newI][newJ] != Integer.MAX_VALUE)
                continue;
                q.offer(new int[]{newI, newJ});
                rooms[newI][newJ] = rooms[i][j] + 1;
            }
        }
        
    }
}
