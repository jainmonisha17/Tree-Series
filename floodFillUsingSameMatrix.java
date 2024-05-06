// Name: Monisha Jain
// Qualifications: MCA
// College: PES University

import java.util.*;

public class floodFillUsingSameMatrix {
    public int[][] floodFill(int[][] grid, int row, int col, int newColor) {
        if (grid[row][col] != newColor) {
            DFS(grid, row, col, grid[row][col], newColor);
        }

        return grid;
    }

    private static void DFS(int[][] grid, int row, int col, int oldColor, int newColor) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return; // return if it is not valild cell
        if (grid[row][col] != oldColor)
            return; // return if it is not the requeired color

        grid[row][col] = newColor; // updata the cell to the new color

        // recursively visit all the neighbouring cell(horizantally & vertically)
        DFS(grid, row + 1, col, oldColor, newColor); // lower cell
        DFS(grid, row - 1, col, oldColor, newColor); // upper cell
        DFS(grid, row, col + 1, oldColor, newColor); // right cell
        DFS(grid, row, col - 1, oldColor, newColor); // left cell
    }

    public static void main(String[] args) {
        floodFillUsingSameMatrix sol = new floodFillUsingSameMatrix();
        System.out.print(Arrays.deepToString(sol.floodFill(
                new int[][] {
                        { 0, 1, 1, 1, 0 },
                        { 0, 0, 0, 1, 1 },
                        { 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }, 1, 3, 2)));

        System.out.print(Arrays.deepToString(sol.floodFill(
                new int[][] {
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }, 3, 2, 5)));
    }
}



// Time Complexity: O(M * N), where 'M' is the number of rows and 'N' is the number of columns of the input matrix. This is due to the fact that, in the worst case we might have to fill the whole matrix
// Space Complexity: DFS recursion stack can go M * N deep when we have to fill the whole matrix. Hence the sc will be O(M * N), where 'M' is the number of rows and 'N' is the number of columns of the input matrix.
