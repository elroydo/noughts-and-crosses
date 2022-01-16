
public class testing4 {
	public static void main(String args[]) {
		char[][] board = {
				{'.', '.', 'X'},
				{'X', 'X', 'O'},
				{'X', 'O', 'O'}
		};
		
		System.out.println(WhoHasWonXO(board));
	}
	
	public static char WhoHasWonXO(char board[][]) {
		int countX = 0, countO = 0, total = 0;
		
		if(!validateBoard(board)) {
			return 'E';
		}if(!squareValidate(board)) {
			return 'E';
		}else {
			for(int i = 0; i<board.length; i++) {
                for(int j = 0; j<board[i].length; j++) {
                    if('X' == board[i][j]) {
                        countX++;
                    }
                    if('O' == board[i][j]) {
                        countO++;
                    }
                }
            }
			
			total = countX + countO;
			
			if(XOValidate(board, 'X')) {
				return 'X';
			}else if(XOValidate(board, 'O')) {
				return 'O';
			}else if(total == 9) {
				return 'D';
			}else {
				return 'N';
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
	
	public static Boolean squareValidate(char board[][]) {
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[i].length; j++) {
				if(board[i][j] != '.' && board[i][j] != 'X' && board[i][j] != 'O') {
					return false;
				}
			}
		}
		return true;
	}
	
	public static Boolean XOValidate(char board[][], char character) {
		if(board[0][0] == character && board[0][1] == character && board[0][2] == character) {
			return true;
		}else if(board[1][0] == character && board[1][1] == character && board[1][2] == character) {
			return true;
		}else if(board[2][0] == character && board[2][1] == character && board[2][2] == character) {
			return true;
		}else if(board[0][0] == character && board[1][0] == character && board[2][0] == character) {
			return true;
		}else if(board[0][1] == character && board[1][1] == character && board[2][1] == character) {
			return true;
		}else if(board[0][2] == character && board[1][2] == character && board[2][2] == character) {
			return true;
		}else if(board[0][0] == character && board[1][1] == character && board[2][2] == character) {
			return true;
		}else if(board[0][2] == character && board[1][1] == character && board[2][0] == character) {
			return true;
		}
		return false;
	}
}
