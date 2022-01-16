import java.util.Random;

public class method5 {
	public static void main(String args[]) {
		char[][] board = {
				{'X', 'O', 'X'},
				{'O', 'X', 'X'},
				{'O', 'X', 'O'}
		};
		
		System.out.println(RandomMove(board));
	}
	
	public static char[][] RandomMove(char board[][]) {
		Random random = new Random();
		int sumX = 0, sumO = 0, sumBlank = 0;
		
		if(BoardValidate(board)) {
			if(WinDetect(board) == 0) { //no winner present check
				for(int i=0; i<board.length; i++) {
					for (int j=0; j<board[i].length; j++) {
						if('X' == board[i][j]) sumX++;
						if('O' == board[i][j]) sumO++;
					}
				}
				
				int[][] blankCells = new int[9-(sumX + sumO)][2];
				
				for(int i=0; i<board.length; i++) {
					for (int j=0; j<board[i].length; j++) {
						if('.' == board[i][j]) { 
							sumBlank++;
							blankCells[sumBlank-1][0] = i;
							blankCells[sumBlank-1][1] = j;
						}
					}
				}
				
				int rBlankCell = random.nextInt(blankCells.length);
				board[blankCells[rBlankCell][0]][blankCells[rBlankCell][1]] = ((sumX+sumO)%2 == 0)?'X':'O';
				return board; //return board with random move
			}else {
				return null;
			}
		}
		return null; //return null if errors found
	}
	
	public static Boolean BoardValidate(char board[][]) {
		int sumX = 0, sumO = 0;
		
		if(board == null || board.length == 0) {
			return false; //null pointer exception or empty board
		}else {
			for(int i = 0; i<board.length; i++) {
				if(board.length != 3 || board[i].length != 3 ) return false; //invalid board, not 3x3
			}
			
			for(int i = 0; i<board.length; i++) {
				for(int j = 0; j<board[i].length; j++) {
					if(board[i][j] != '.' && board[i][j] != 'X' && board[i][j] != 'O') return false; //invalid board if illegal characters found
					if('X' == board[i][j]) sumX++;
					if('O' == board[i][j]) sumO++;
				}
			}
			//valid board if X=O or X is 1 more than O
			if(sumX == sumO || sumX == sumO+1) {
				//check if O has won
				if(WinDetect(board) == 2) {
					//check if X has also won
					if(WinDetect(board) == 1) return false; //return invalid
					return true; //return valid
				}
				//if X has won, sum of X must be 1 more
				if(WinDetect(board) == 1 && sumX != sumX+1) return false; //invalid board
				//if O has not won
				return true; //valid board
			}
		}
		return false; //return default invalid
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
