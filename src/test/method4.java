
public class method4 {
	public static void main(String args[]) {
		char[][] board = {
				{'X', 'X', 'O'},
				{'O', 'O', 'X'},
				{'X', 'X', 'O'}
		};
		
		System.out.println(WhoHasWonXO(board));
	}
	
	public static char WhoHasWonXO(char board[][]) {
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
		
		if(board == null || board.length == 0 || !boardSize(board)) {
			return 'E';
		}else if(!invalidCharacter(board)) {
			return 'E';
		}else {
			for(int i = 0; i<8; i++) {
				if(board[sequence[i][0]][sequence[i][1]] == 'X' && board[sequence[i][2]][sequence[i][3]] == 'X' && board[sequence[i][4]][sequence[i][5]] == 'X') return 'X'; //return X win
				if((board[sequence[i][0]][sequence[i][1]] == 'O' && board[sequence[i][2]][sequence[i][3]] == 'O' && board[sequence[i][4]][sequence[i][5]] == 'O')) return 'O'; //return O win
			}
			
			for(int i=0; i<board.length; i++) {
				for (int j=0; j<board[i].length; j++) {
					if('X' == board[i][j]) sumX++;
					if('O' == board[i][j]) sumO++;
				}
			}
			
			if((sumX+sumO) == 9) return 'D'; //return draw
			return 'N'; //return no present winner
		}
	}
	
	public static Boolean boardSize(char board[][]) {
		for(int i = 0; i<board.length; i++) {
			if(board.length != 3 || board[i].length != 3 ) return false; //invalid board, not 3x3
		}
		return true;
	}
	
	public static Boolean invalidCharacter(char board[][]) {
		int sumX = 0, sumO = 0;
		
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[i].length; j++) {
				if(board[i][j] != '.' && board[i][j] != 'X' && board[i][j] != 'O') return false; //invalid board if illegal characters found
				if('X' == board[i][j]) sumX++;
				if('O' == board[i][j]) sumO++;
			}
		}
		return true;
	}
}
