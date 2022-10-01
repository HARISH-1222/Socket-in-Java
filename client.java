import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class client{
  public static void main(String arg[]){
    try{
      Socket soc = new Socket("localhost",9999);
      System.out.println("Connected");
      BufferedReader numOfFact = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter the Number :");
      int num = Integer.parseInt(numOfFact.readLine());
      PrintWriter reqNum = new PrintWriter(soc.getOutputStream(),true);
      reqNum.println(num);
      BufferedReader resAns = new BufferedReader(new InputStreamReader(soc.getInputStream()));
      // int val = Integer.parseInt(resAns.readLine());
      System.out.println("Factorial of "+num+" is "+Integer.parseInt(resAns.readLine()));
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }
}
