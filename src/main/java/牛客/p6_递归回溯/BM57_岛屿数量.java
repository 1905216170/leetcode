package 牛客.p6_递归回溯;

public class BM57_岛屿数量 {

    public void recursionHandle(char[][] grid, int row, int col){
        grid[row][col] = 0;
        // 当前是岛屿，把周围相连的岛屿递归变成海洋
        if((row - 1 >= 0 && grid[row - 1][col] == '1')){
            // 上面
            recursionHandle(grid, row - 1, col);
        }
        if((row + 1 < grid.length && grid[row + 1][col] == '1')){
            // 下面
            recursionHandle(grid, row + 1, col);
        }
        if((col - 1 >= 0 && grid[row][col - 1] == '1')){
            // 左边
            recursionHandle(grid, row, col - 1);
        }
        if((col + 1 < grid[0].length && grid[row][col + 1] == '1')){
            recursionHandle(grid, row, col + 1);
        }
    }

    public int solve (char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 当前是岛屿，且（上面为边界 或者 上面为海洋）且（左边为边界 或者 左边为海洋）
                if(grid[i][j] == '1'){
                    count++;
                    recursionHandle(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BM57_岛屿数量 test = new BM57_岛屿数量();
        int count = test.solve(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '1', '1'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '1', '1', '1'}

        });
//        int count = test.solve(new char[][]{
//                {'1','1'},
//                {'1','1'}
//        });
        System.out.println(count);
    }
}
