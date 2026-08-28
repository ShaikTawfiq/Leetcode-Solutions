class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char [n] [n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        backtrack(0, n, board, result);
        return result;
    }
    private void backtrack(int row, int n, char[][] board, List<List<String>> result){
        if(row==n){
            result.add(constructBoard(board));
            return;
        }
        for(int col =0; col<n; col++){
            if(isSafe(row,col,board,n)){
                board[row][col] = 'Q';
                backtrack(row+1,n,board,result);
                board[row][col]= '.';
            }
        }
    }
            private boolean isSafe(int row, int col, char[][]board, int n){
                for(int i=1; i<=row;i++){
                    if (board[row - i][col] == 'Q') return false;
            if (col - i >= 0 && board[row - i][col - i] == 'Q') return false;
            if (col + i < n && board[row - i][col + i] == 'Q') return false;
        }
        return true;
            }
                
                private List<String> constructBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
            }
            return list;
        }

    }
