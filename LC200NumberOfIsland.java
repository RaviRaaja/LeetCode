// BFS version
class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int counter = 0;
        int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == '1') {
                    counter++;
                    grid[i][j] = '0';
                    q.offer(new int[]{i,j});
                    // explore
                    while(!q.isEmpty()) {
                        
                        int[] curr = q.poll();
                        int currR = curr[0];
                        int currC = curr[1];
                        
                        for(int[] dir: dirs) {
                            int newI = currR + dir[0];
                            int newJ = currC + dir[1];
                            
                            if(newI<0 || newJ<0 || newI>=r || newJ>=c || grid[newI][newJ] == '0') continue;
                            
                            grid[newI][newJ] = '0';
                            q.offer(new int[]{newI, newJ});
                        }
                    }
                }
            }
        }
        return counter;
    }
}


// DFS version
class Solution {
    
    int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int numIslands(char[][] grid) {
        int counter = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    counter++;
                    dfs(grid, i, j);
                }            
            }
        }
        return counter;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for(int[] dir: dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if(newI < 0 || newJ < 0 || newI >= grid.length || newJ >= grid[i].length || grid[newI][newJ] == '0') continue;
            dfs(grid, newI, newJ);
        }
    }
}

// union find version

class Solution {
  class UnionFind {
    int count; // # of connected components
    int[] parent;
    int[] rank;

    public UnionFind(char[][] grid) { // for problem 200
      count = 0;
      int m = grid.length;
      int n = grid[0].length;
      parent = new int[m * n];
      rank = new int[m * n];
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          if (grid[i][j] == '1') {
            parent[i * n + j] = i * n + j;
            ++count;
          }
          rank[i * n + j] = 0;
        }
      }
    }

    public int find(int i) { // path compression
      if (parent[i] != i) parent[i] = find(parent[i]);
      return parent[i];
    }

    public void union(int x, int y) { // union with rank
      int rootx = find(x);
      int rooty = find(y);
      if (rootx != rooty) {
        if (rank[rootx] >= rank[rooty]) {
            parent[rooty] = rootx;
            rank[rootx] += rank[rooty];
        } else {
            parent[rootx] = rooty;
            rank[rooty] += rank[rootx];
        }
        --count;
      }
    }

    public int getCount() {
      return count;
    }
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;
    UnionFind uf = new UnionFind(grid);
    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          grid[r][c] = '0';
          if (r - 1 >= 0 && grid[r-1][c] == '1') {
            uf.union(r * nc + c, (r-1) * nc + c);
          }
          if (r + 1 < nr && grid[r+1][c] == '1') {
            uf.union(r * nc + c, (r+1) * nc + c);
          }
          if (c - 1 >= 0 && grid[r][c-1] == '1') {
            uf.union(r * nc + c, r * nc + c - 1);
          }
          if (c + 1 < nc && grid[r][c+1] == '1') {
            uf.union(r * nc + c, r * nc + c + 1);
          }
        }
      }
    }

    return uf.getCount();
  }
}
