
public class method2 {
	public static void main(String args[]) {
		char[][] board = {
				{'.', '.', '.'},
				{'.', '.', '.'},
				{'.', '.', '.'}
		};
		
		Character[][] characterBoard = {
				{'.', '.', '.'},
				{'.', '.', '.'},
				{'.', '.', '.'}
		};
		
		String[][] stringBoard = {
				{".", ".", "."},
				{".", ".", "."},
				{".", ".", "."}
		};
		
		System.out.println(charBoardCount(board, '.'));
		System.out.println(characterBoardCount(characterBoard, '.'));
		System.out.println(stringBoardCount(stringBoard, "."));
	}
	
	public static int charBoardCount(char board[][], char symbol) {
		int appear = 0;
		
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[i].length; j++) {
				if(symbol == board[i][j]) appear++;
			}
		}
		return appear;
	}
	
	public static int characterBoardCount(Character[][] characterBoard, char symbol) {
		int appear = 0;
		
		for(int i = 0; i<characterBoard.length; i++) {
			for(int j = 0; j<characterBoard[i].length; j++) {
				if(symbol == characterBoard[i][j]) appear++;
			}
		}
		return appear;
	}
	
	public static int stringBoardCount(String[][] stringBoard, String symbol) {
		int appear = 0;
		
		for(int i = 0; i<stringBoard.length; i++) {
			for(int j = 0; j<stringBoard[i].length; j++) {
				//if(symbol == stringBoard[i][j].charAt(0)) appear++;
				if(symbol == stringBoard[i][j]) appear++;
			}
		}
		return appear;
	}
	
	public static int CountGameBoard(char c, char board[][]) {
		int appear = 0;
		
		if(board == null || board.length == 0 || !charSquareValidate(c) || !ValidGameBoard(board)) return -1;
		if(!invalidCharacter(board)) return -2;
		
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[i].length; j++) {
				if(c == board[i][j]) appear++;
			}
		}
		return appear;
	}
	
	public static Boolean charSquareValidate(char c) {
		if(c == 'X' || c == 'O' || c == '.') {
			return true;
		}
		return false;
	}
	
	public static Boolean ValidGameBoard(char board[][]) {
		for(int i = 0; i<board.length; i++) {
			if(board.length != 3 || board[i].length != 3 ) return false; //invalid board, not 3x3
		}
		return true;
	}
	
	public static Boolean invalidCharacter(char board[][]) {
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[i].length; j++) {
				if(board[i][j] != '.' && board[i][j] != 'X' && board[i][j] != 'O') return false; //invalid board if illegal characters found
			}
		}
		return true;
	}
}
