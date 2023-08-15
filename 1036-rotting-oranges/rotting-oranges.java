class Solution {
    private int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int orangesRotting(int[][] grid) {
        List<int[]> rotten = new ArrayList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 2)
                    rotten.add(new int[] {i, j});
                else if (grid[i][j] == 1)
                    fresh++;
        
        int min = 0;
        while (!rotten.isEmpty() && fresh > 0) {
            rotten = nextMinute(grid, rotten);
            fresh -= rotten.size();
            min++;
        }
        return fresh > 0 ? -1 : min;
    }
    
    List<int[]> nextMinute(int[][] g, List<int[]> rotten) {
        List<int[]> newRotten = new ArrayList<>();
        for (int[] rot: rotten) {
            for(int[] dir: dirs) {
                int i = rot[0] + dir[0];
                int j = rot[1] + dir[1];
                
                if (i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] != 1)
                    continue;
                g[i][j] = 2;
                newRotten.add(new int[] {i, j});
            }
        }
        return newRotten;
    }
}