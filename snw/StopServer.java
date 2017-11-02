import java.util.*;
import java.net.*;
import java.io.*;

class StopServer {
	public static void main(String[] args) throws IOException {
		Socket soc;
		ServerSocket server;
		PrintWriter out;
		BufferedReader in;
		int data = 0;
			try {
				server = new ServerSocket(8765);
				while(true) {
					soc = server.accept();
					out = new PrintWriter(soc.getOutputStream(), true);
					in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
					data = Integer.parseInt(in.readLine());
					System.out.println(data);
					Random random = new Random();
					int chance = random.nextInt(100);
					if((chance % 2) == 0) {
						System.out.println("Frame " + data + " recieved");
						out.println(data);
					} else {
						System.out.println("Oops! Sequence Number: " + data + " was dropped.");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
