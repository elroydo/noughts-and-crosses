import java.util.Scanner;

public class XandO{
	public static void main(String[] args) throws InterruptedException {
		Boolean newGame = true;
		char[][] board = new char[3][3];
		char symbol;
		int turn = 0, validatedPosition, xScore = 0, oScore = 0, boardCell = 0;
		
		while(newGame) {
			boardCell = displayGrid(board, xScore, oScore);
			if(boardCell != 9) {
				symbol = (turn%2==0)?'X':'O';
				validatedPosition = validation(symbol);
				newGame = (validatedPosition==0)?false:true;
				gridInput(board, validatedPosition, symbol);
				if(threeCheck(board, symbol)) {
					System.out.println("\nThree in a row! " + symbol + " wins!\n");
					if(turn%2==0) {
						xScore++;
					}else {
						oScore++;
					}
					board = new char[board.length][board.length];
					Thread.sleep(1000);
				}else {
					turn++;
				}
			}else {
				System.out.println("No winner!");
				board = new char[board.length][board.length];
				turn=0;
			}
		}
	}
	
	static private int displayGrid(char[][] board, int xScore, int oScore) {
		int populatedBoard = 0;
		
		System.out.println("Score: X = " + xScore + " | O = " + oScore );
		for(int i=0; i<board.length; i++) {
			System.out.print(" ");
			for(int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j]);
				if(j<2) {
					System.out.print(" | ");
				}
				if(board[i][j]=='X' || board[i][j]=='O') {
					populatedBoard++;
				}
			}
			System.out.println();
			if(i<2) {
				System.out.println("--- --- ---");
			}
		}
		return populatedBoard;
	}
	
	static private int validation(char symbol) {
		int position; 
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println("Please enter a number corresponding to the grid position for " + symbol + ":");
			while(!input.hasNextInt()) {
				System.out.println("Please enter a valid number.");
				input.next();
			}
			position = input.nextInt();
		} while (position < 0 || position > 9);
		return position;
	}
	
	static private void gridInput(char[][] board, int gridPosition, char symbolTurn) {
		switch(gridPosition) {
			case 1:
				if(board[0][0] == 0) {
					board[0][0] = symbolTurn;
				}else {
					System.out.println("Grid position already has a value.");
					gridPosition = validation(symbolTurn);
					gridInput(board, gridPosition, symbolTurn);
				}
				break;
			case 2:
				if(board[0][1] == 0) {
					board[0][1] = symbolTurn;
				}else {
					System.out.println("Grid position already has a value.");
					gridPosition = validation(symbolTurn);
					gridInput(board, gridPosition, symbolTurn);
				}
				break;
			case 3:
				if(board[0][2] == 0) {
					board[0][2] = symbolTurn;
				}else {
					System.out.println("Grid position already has a value.");
					gridPosition = validation(symbolTurn);
					gridInput(board, gridPosition, symbolTurn);
				}
				break;
			case 4:
				if(board[1][0] == 0) {
					board[1][0] = symbolTurn;
				}else {
					System.out.println("Grid position already has a value.");
					gridPosition = validation(symbolTurn);
					gridInput(board, gridPosition, symbolTurn);
				}
				break;
			case 5:
				if(board[1][1] == 0) {
					board[1][1] = symbolTurn;
				}else {
					System.out.println("Grid position already has a value.");
					gridPosition = validation(symbolTurn);
					gridInput(board, gridPosition, symbolTurn);
				}
				break;
			case 6:
				if(board[1][2] == 0) {
					board[1][2] = symbolTurn;
				}else {
					System.out.println("Grid position already has a value.");
					gridPosition = validation(symbolTurn);
					gridInput(board, gridPosition, symbolTurn);
				}
				break;
			case 7:
				if(board[2][0] == 0) {
					board[2][0] = symbolTurn;
				}else {
					System.out.println("Grid position already has a value.");
					gridPosition = validation(symbolTurn);
					gridInput(board, gridPosition, symbolTurn);
				}
				break;
			case 8:
				if(board[2][1] == 0) {
					board[2][1] = symbolTurn;
				}else {
					System.out.println("Grid position already has a value.");
					gridPosition = validation(symbolTurn);
					gridInput(board, gridPosition, symbolTurn);
				}
				break;
			case 9:
				if(board[2][2] == 0) {
					board[2][2] = symbolTurn;
				}else {
					System.out.println("Grid position already has a value.");
					gridPosition = validation(symbolTurn);
					gridInput(board, gridPosition, symbolTurn);
				}
				break;
		}
	}
	
	private static Boolean threeCheck(char[][] board, char symbol) {
		if(board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) {
			return true;
		}else if(board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) {
			return true;
		}else if(board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) {
			return true;
		}else if(board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) {
			return true;
		}else if(board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) {
			return true;
		}else if(board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) {
			return true;
		}else if(board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
			return true;
		}else if(board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
			return true;
		}
		return false;
	}
}
