
public class testing3 {
	public static void main(String args[]) {
		char[][] board = {
				{'.', '.', '.'},
				{'X', 'X', 'O'},
				{'X', '.', 'O'}
		};
		
		System.out.println(CountGameBoard('X', board));
	}
	
	public static int CountGameBoard(char c, char board[][]) {
		int count = 0;
		
		if(board == null || board.length == 0 || !boardLength(board) || !charValidation(c)) {
			return -1;
		} 
		if(squareValidCharacter(board)) {
			return -2;
		}
		
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[i].length; j++) {
				if(c == board[i][j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	//check input character
	public static Boolean charValidation(char c) {
		if(c == 'X' || c == 'O' || c == '.') {
			return true;
		}else {
			return false;
		}
	}
	
	//check length of the board
	public static Boolean boardLength(char board[][]) {
		for(int i = 0; i<board.length; i++) {
			if(board.length != 3) {
				return false;
			}else if(board[i].length != 3){
				return false;
			}
		}
		return true;
	}
	
	//check each square character is correct
	public static Boolean squareValidCharacter(char board[][]) {
		for(int x = 0; x<board.length; x++) {
			for(int y = 0; y<board[x].length; y++) {
				if(board[x][y] != 'O' && board[x][y] != 'X' && board[x][y] != '.' ) {
					return true;
				}else {
					return false;
				}

			}
		}
		return false;
	}
}
