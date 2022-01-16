package test;

public class test3<TYPE> {
	private TYPE data;
	public void SetData(TYPE x) {
		data = x;
	}
	public void display() {
		if (data instanceof Integer) {
			System.out.println("integer");
		}
		if (data instanceof Double) {
			System.out.println("double");
		}
		if (data instanceof String) {
			System.out.println("string");
		}
	}
	
	public static void main(String args[]) {
		test3<String> s = new test3<String>();
		
		s.SetData("hola");
		s.display();
	}
}