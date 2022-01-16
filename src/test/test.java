
public class test {
	public static void main(String args[]) {
		char[][] board = {
				{'X', 'O', 'O'},
				{'O', 'X', 'X'},
				{'X', 'O', 'O'}
		};
		
		System.out.println(WinDetect(board));
	}
	
	public static int WinDetect(char board[][]) {
		int sumX = 0, sumO = 0;
		int[][] sequence = {
				{0, 0, 0, 1, 0, 2}, 
				{1, 0, 1, 1, 1, 2}, 
				{2, 0, 2, 1, 2, 2},
				{0, 0, 1, 1, 2, 2},
				{0, 2, 1, 1, 2, 0},
				{0, 2, 1, 2, 2, 2}, 
				{0, 1, 1, 1, 2, 1}, 
				{0, 0, 1, 0, 2, 0}
		};
		
		for(int i = 0; i<8; i++) {
			if(board[sequence[i][0]][sequence[i][1]] == 'X' && board[sequence[i][2]][sequence[i][3]] == 'X' && board[sequence[i][4]][sequence[i][5]] == 'X') return 1; //return X win
			if((board[sequence[i][0]][sequence[i][1]] == 'O' && board[sequence[i][2]][sequence[i][3]] == 'O' && board[sequence[i][4]][sequence[i][5]] == 'O')) return 2; //return O win
		}
		
		for(int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				if('X' == board[i][j]) sumX++;
				if('O' == board[i][j]) sumO++;
			}
		}
		
		if((sumX+sumO) == 9) return 3; //return draw
		return 0; //return no present winner
	}
}
