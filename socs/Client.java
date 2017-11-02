import java.io.*;
import java.net.*;
class Client {
	public static void main(String[] args) throws IOException {
		try {
			Socket soc = new Socket("localhost", 8765);
			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String data;
			while((data = stdIn.readLine()) != null) {
				out.println(data);
				System.out.println("Echo: " + in.readLine());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
