import java.util.Scanner;
import java.util.Random;

public class examination {
	public static void main(String args[]) {
		char[][] board = {
				{'X', '.', '.'}, 
				{'.', '.', '.'}, 
				{'.', '.', '.'}};
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter input:");
		
		char userInput = input.next().charAt(0);

		System.out.println(SquareValidation(userInput));
		System.out.println(CountBoard(board, userInput));
		System.out.println(ValidateBoard(board));
		System.out.println(DetectWin(board, userInput));
		RandomMove(board);
		
		for(int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static Boolean SquareValidation(char userinput) {
		if (userinput != ' ' && (userinput == 'X' || userinput == 'O')) {
			return true; //valid character
		}else {
			return false; //invalid character
		}
	}
	
	public static int CountBoard(char board[][], char input) {
		int charAppear = 0;

		for(int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j]);
				if(input == board[i][j]) charAppear++;
			}
			System.out.println();
		}
		return charAppear; //number of times input appears
	}
	
	public static Boolean ValidateBoard(char board[][]) {
		int countX = 0, countO = 0;
		
		for(int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				if(board[i][j] == 0 || board[i][j] == ' ') return false; //invalid characters on board
				if('X' == board[i][j]) countX++;
				if('O' == board[i][j]) countO++;
			}
		}
		
		if(countX==countO || countX==countO+1) {
			if(DetectWin(board, 'O') == 1) {
				if(DetectWin(board, 'X') == 1) return false;
				return true; //board is valid
			}
			if(DetectWin(board, 'X') == 1 && countX != countX+1) return false;
			return true; //board is valid
		}
		System.out.println("X = " + countX + "\n" + "O = " + countO);
		return false; //board is invalid
	}
	
	public static int DetectWin(char board[][], char input) {
		int countX = 0, countO = 0;
		int[][] Sequence = {
				{0, 0, 0, 1, 0, 2}, 
				{1, 0, 1, 1, 1, 2}, 
				{2, 0, 2, 1, 2, 2},
				{0, 0, 1, 1, 2, 2},
				{0, 2, 1, 1, 2, 0},
				{0, 2, 1, 2, 2, 2}, 
				{0, 1, 1, 1, 2, 1}, 
				{0, 0, 1, 0, 2, 0}};
		
		for(int i=0; i<8; i++) {
			if(board[Sequence[i][0]][Sequence[i][1]] == input && board[Sequence[i][2]][Sequence[i][3]] == input && board[Sequence[i][4]][Sequence[i][5]] == input) {
				System.out.println("Three " + input + "'s" + " in a row");
				return 1; //return win for character
			}
		}
		
		for(int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				if('X' == board[i][j]) countX++;
				if('O' == board[i][j]) countO++;
			}
		}
		
		if((countX+countO) == 9) return 2; //return draw
		return 0; //return no winner so far
	}
	
	public static char[][] RandomMove(char board[][]) {
		int countX = 0, countO = 0, countEmpty = 0;
		
		if(ValidateBoard(board)) {
			for(int i=0; i<board.length; i++) {
				for (int j=0; j<board[i].length; j++) {
					if('X' == board[i][j]) countX++;
					if('O' == board[i][j]) countO++;
				}
			}
			
			int[][] emptySpaces = new int[9-(countX + countO)][2];
			
			for(int i=0; i<board.length; i++) {
				for (int j=0; j<board[i].length; j++) {
					if('.' == board[i][j]) { 
						countEmpty++;
						emptySpaces[countEmpty-1][0] = i;
						emptySpaces[countEmpty-1][1] = j;
					}
				}
			}
			
			char input = ((countX+countO)%2==0)?'X':'O';
			
			int rEmptyCell = GenerateRandom(emptySpaces.length);
			
			board[emptySpaces[rEmptyCell][0]][emptySpaces[rEmptyCell][1]] = input;
			
			return board;
		}
		return null;
	}
	
	public static int GenerateRandom(int range) {
		Random random = new Random();
		System.out.println(random.nextInt(range));
		return random.nextInt(range);
	}
}
