import java.util.Scanner;

public class Brainfuck {
	static int pointer = 0;
	static int[] values = new int[256];

	public static void interpret(Scanner scanner, String code) {
		for (int i = 0; i < code.length(); i++) {
        	int loopCounter = 0;
        	switch(code.charAt(i)) {
        	case '>':
        		pointer++;
        		break;
        	case '<':
        		pointer--;
        		break;
        	case '+':
        		values[pointer]++;
        		break;
        	case '-':
        		values[pointer]--;
        		break;
	        case '.':
	        	System.out.println((char)(values[pointer]));
	    		break;
	        case ',':
	        	values[pointer] = (byte)scanner.next().charAt(0);
	        case '[':
	        	if (values[pointer] == 0) {
	        		i++;
	        		while (loopCounter > 0 || code.charAt(i) != ']') {
						if (code.charAt(i) == '[') {
							loopCounter++;
						}
						if (code.charAt(i) == ']') {
							loopCounter--;
						}
						i++;
					}
				}
	        	break;
	        case ']':
	        	if (values[pointer] != 0) {
	        		i--;
	        		while (loopCounter > 0 || code.charAt(i) != '[') {
						if (code.charAt(i) == ']') {
							loopCounter++;
						}
						if (code.charAt(i) == '[') {
							loopCounter--;
						}
						i--;
					}
	        	}
	    	}
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter the code:");
		Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        System.out.println("Output:");
        interpret(scanner, code);
	}
}
