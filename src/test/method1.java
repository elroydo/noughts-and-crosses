public class method1 {
	public static void main(String args[]) {		
		System.out.println(charSquareValidate('X'));
		System.out.println(CharacterSquareValidate('O'));
		System.out.println(StringSquareValidate("X"));
	}
	
	public static Boolean charSquareValidate(char c) {
		if(c == 'X' || c == 'O' || c == '.') {
			return true;
		}
		return false;
	}
	
	public static Boolean CharacterSquareValidate(Character symbol) {
		if(symbol != null && symbol != ' ' && (symbol == 'X' || symbol == 'O')) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Boolean StringSquareValidate(String symbol) {
		if(symbol != null && symbol != " " && (symbol.charAt(0) == 'X' || symbol.charAt(0) == 'O')) {
			return true;
		}else {
			return false;
		}
	}
}
