
public class testing2 {
	public static void main(String args[]) {
		char[][] board = {
				{'.', '.', '.'},
				{'X', 'X', 'O'},
				{'.', 'X', 'O'}
		};
		
		System.out.println(ValidGameBoard(board));
	}
	
	public static Boolean ValidGameBoard(char board[][]) {
		int countX = 0, countO = 0;
		
		//check the board for null
		if(!validateBoard(board)) {
			return false; 
		}else if(!boardSize(board)) {
			return false;
		}else {
			for(int i = 0; i<board.length; i++) {
				for(int j = 0; j<board[i].length; j++) {
					if(board[i][j] != '.' && board[i][j] != 'X' && board[i][j] != 'O') {
						return false;
					}
					if('X' == board[i][j]) {
						countX++;
					}
					if('O' == board[i][j]) {
						countO++;
					}
				}
			}
			
			if(XandOvalidate(countX, countO)) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public static Boolean validateBoard(char board[][]) {
		if(board == null || board.length == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	//check board size
	public static Boolean boardSize(char board[][]) {
		for(int i = 0; i<board.length; i++) {
			if(board.length != 3 || board[i].length != 3 ) {
				return false;
			}else{
				return true;
			}
		}
		return true;
	}
	
	public static Boolean XandOvalidate(int countX, int countO) {
		if(countX == countO || countX == countO+1) {
			return true;
		}
		return false;
	}
}
