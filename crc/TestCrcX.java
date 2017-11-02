import java.util.*;
import java.io.*;

class TestCrcX {
	public static String div(String num1, String num2) {
		int pointer = num2.length();
		String result = num1.substring(0, pointer);
		String remainder = "";
		for(int i = 0; i < num2.length(); i++) {
			if(result.charAt(i) == num2.charAt(i))
				remainder += "0";
			else
				remainder += "1";
		}
		while(pointer < num1.length()) {
			if(remainder.charAt(0) == '0') {
				remainder = remainder.substring(1, remainder.length());
				remainder = remainder + String.valueOf(num1.charAt(pointer));
				pointer++;
			}
			result = remainder;
			remainder = "";
			for(int i = 0; i < num2.length(); i++) {
				if(result.charAt(i) == num2.charAt(i))
					remainder += "0";
				else
					remainder += "1";
			}
		}
		return remainder.substring(1, remainder.length());
	}
	public static void main(String[] args) throws IOException {
		String gen, data, code, recv;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gen = br.readLine();
		data = br.readLine();
		code = data;
		code = code + div(code, gen);
		System.out.println(code);
		recv = br.readLine();
		if(Integer.parseInt(div(recv, gen)) == 0)
			System.out.println("No errors");
		else
			System.out.println("Error detected");
	}
}
