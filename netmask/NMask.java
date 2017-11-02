import java.util.*;
import java.io.*;

class NMask {
	public static void printClass(String[] bytes) {
		int ip = Integer.parseInt(bytes[0]);
		if(ip >= 1 && ip < 127) {
			System.out.println("A");
		} else if (ip > 127 && ip <= 191) {
			System.out.println("B");
		} else if (ip > 191 && ip <= 223) {
			System.out.println("C");
		} else if (ip > 223 && ip <= 239) {
			System.out.println("D");
		} else {
			System.out.println("E");
		}
	}
	public static void printStartAddress(int[] bytes, int mask) {
		String s = "";
		for(int i = 0; i < bytes.length; i++) {
			s += String.format("%8s", Integer.toBinaryString(bytes[i])).replace(' ', '0');
		}
		int c = 0;
		String start = "";
		while (c < mask) {
			start += Character.toString(s.charAt(c));
			c++;
		}
		while (c < 31) {
			start += "0";
			c++;
		}
		start += "1";
		System.out.println(s);
		System.out.println(start);
	}
	public static void printEndAddress(int[] bytes, int mask) {
		String s = "";
		for(int i = 0; i < bytes.length; i++) {
			s += String.format("%8s", Integer.toBinaryString(bytes[i])).replace(' ', '0');
		}
		int c = 0;
		String end = "";
		while (c < mask) {
			end += Character.toString(s.charAt(c));
			c++;
		}
		while (c < 31) {
			end += '1';
			c++;
		}
		end += '0';
		System.out.println(end);
	}
	public static void printSubnetMask(String[] bytes, int mask) {
		int[] maskBytes = new int[4];
		String[] subnetMask = new String[4];
		String[] broadCast = new String[4];
		String[] startAddress = new String[4];
		String[] endAddress = new String[4];
		int c = 0;
		int bitcount = 1;
		String s = "";
		while (c < mask) {
			s += "1";
			c++;
		}
		while (c < 32) {
			s += "0";
			c++;
		}
		maskBytes[0] = Integer.parseInt(s.substring(0, 9-1), 2);
		maskBytes[1] = Integer.parseInt(s.substring(0+8*1, 9+8*1-1), 2);
		maskBytes[2] = Integer.parseInt(s.substring(0+8*2, 9+8*2-1), 2);
		maskBytes[3] = Integer.parseInt(s.substring(0+8*3, 9+8*3-1), 2);
//		printEndAddress(maskBytes, mask);
		for(int i = 0; i < maskBytes.length; i++) {
			subnetMask[i] = String.valueOf(Integer.parseInt(bytes[i]) & maskBytes[i]);
			maskBytes[i] = Integer.parseInt(bytes[i]) & maskBytes[i];
		}
		printStartAddress(maskBytes, mask);
		printEndAddress(maskBytes, mask);
		String ans = String.join(".", subnetMask);
		System.out.println(ans);
	}
	public static void main(String[] args) throws IOException {
		String[] bData;
		String[] data;
		String input;
		BufferedReader stdIn;
		try {
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			input = stdIn.readLine();
			System.out.println(input);
			data = input.split("/");
			System.out.print(data[0]);
			bData = data[0].split("\\.");
			System.out.println(bData[0]);
			printClass(bData);
			printSubnetMask(bData, Integer.parseInt(data[1]));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
