import java.net.*;
import java.io.*;

class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8765);
		Socket soc;
		PrintWriter out;
		BufferedReader in;
		while(true) {
			try {
				soc = server.accept();
				out = new PrintWriter(soc.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				String data;
				while((data = in.readLine()) != null) {
					System.out.print("Data recieved: ");
					System.out.println(data);
					out.println(data);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
