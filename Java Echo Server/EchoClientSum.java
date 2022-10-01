import java.io.*;
import java.net.*;

public class EchoClientSum{

	public static void main(String[] args) throws Exception{
		//EchoClientSum echoClientSum = new EchoClientSum(4543);
		Socket client = new Socket("127.0.0.1", 4543);
		client.connect();
		client.
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter w = new PrintWriter(client.getOutputStream());
		String yesOrNo = "continue";
		do{
			System.out.println(fromServer.readLine());
			w.println(stdInput.readLine());
			w.println(stdInput.readLine());
			System.out.println(fromServer.readLine());
			System.out.println(fromServer.readLine());
			yesOrNo = stdInput.readLine();
			w.println(yesOrNo);
		}while(yesOrNo.equals("continue"));
	}
}
