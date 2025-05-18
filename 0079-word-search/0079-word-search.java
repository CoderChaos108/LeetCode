class Solution {
    static boolean check(char board[][], int i, int j, String s) {
       if (s.length() == 0) return true; // If we've matched all characters, return true
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != s.charAt(0)) 
            return false; // Out of bounds or character doesn't match
        
        // Temporarily mark the cell as visited
        char temp = board[i][j];
        board[i][j] = ' '; // Mark as visited
        
        // Explore all four directions
        boolean found = check(board, i + 1, j, s.substring(1)) ||
                        check(board, i - 1, j, s.substring(1)) ||
                        check(board, i, j + 1, s.substring(1)) ||
                        check(board, i, j - 1, s.substring(1));
        
        // Restore the board (backtracking)
        board[i][j] = temp;

        return found;
    
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (check(board, i, j, word)) {
                        return true; // Stop early if found
                    }
                }
            }
        }
        return false;
    }
}
