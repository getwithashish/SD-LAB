import java.io.*;
import java.net.*;

public class EchoServerSum{

	ServerSocket server;

	public EchoServerSum(int portnum) throws Exception{
		server = new ServerSocket(portnum);
	}

	public void serve() throws Exception{
		
		while(true){
			Socket client = server.accept();
			BufferedReader clientRead = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter w = new PrintWriter(client.getOutputStream(),true);
			String operandString1 = "";
			String operandString2 = "";
			String yesOrNo = "continue";
			do{
				w.println("Welcome to Sum Server. Enter two numbers to find sum");
				operandString1 = clientRead.readLine();
				operandString2 = clientRead.readLine();
				int sum = Sum(operandString1, operandString2);
				w.println("Sum = "+sum);
				w.println("Type continue to find sum again");
				yesOrNo = clientRead.readLine();
			}while(yesOrNo.equals("continue"));
		}
	}

	public int Sum(String operandString1, String operandString2){
		int operand1 = Integer.parseInt(operandString1);
		int operand2 = Integer.parseInt(operandString2);
		int sum = operand1 + operand2;
		return sum;
	}

	public static void main(String[] args) throws Exception{
		EchoServerSum echoServerSum = new EchoServerSum(4543);
		echoServerSum.serve();
	}

	
}
