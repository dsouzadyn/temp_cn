import java.io.*;
import java.util.*;
import java.net.*;

class StopClient {
	public static void main(String[] args) throws IOException {
		Socket soc;
		int[] data = {0, 1, 2, 3};
		PrintWriter out;
		BufferedReader in;
		int ack;
		int sequenceNumber = 0;
		for(int i = 0; i < data.length; i++) {
			boolean timeout = true;
			while(timeout) {
				try {
					soc = new Socket("localhost", 8765);
					soc.setSoTimeout(1000);
					out = new PrintWriter(soc.getOutputStream(), true);
					in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
					out.println(data[sequenceNumber++]);
					if((ack = Integer.parseInt(in.readLine())) == sequenceNumber-1) {
						timeout = false;
						System.out.println("Recieved ack for :" +ack);
					}
				} catch (SocketTimeoutException e) {
					sequenceNumber--;
					System.out.println("Ack for:"+sequenceNumber + " not recieved, resending.");
				}
			}
		}
	}
}
