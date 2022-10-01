import java.net.ServerSocket;       // For Server Socket
import java.net.Socket;             // For Server
import java.io.BufferedReader;      //  For
import java.io.InputStreamReader;   //
import java.io.PrintWriter;         //

/*
  System.in  --> is used to read one bit at the time
  InputStream -->Only deals with bit Stream of data;
  So we use
  InputStreamReader-->take bit stream and give the char Stream
  It only read one char at the time that why we use BufferedReader
  BufferedReader  --> Capable to read entire input

  .readLine --> Method use to wait for the user to enter the string
  PrintWriter --> To sent it to server and we pass the true(We want to fflash(Auto fflash) it unless it not sent the data)

*/

public class serverForFact{
  public static void main(String arg[]){
    try{
      ServerSocket serSoc = new ServerSocket(9999);
      System.out.println("Waiting for Client....");
      Socket soc = serSoc.accept();
      System.out.println("Client Connected !!");
      System.out.println("----Waiting for input----");
      BufferedReader input = new BufferedReader(new InputStreamReader(soc.getInputStream()));
      int num = Integer.parseInt(input.readLine());
      System.out.println("The Number is "+num);
      num = fact(num);
      PrintWriter resAns = new PrintWriter(soc.getOutputStream(),true);
      resAns.println(num);
    }
    catch(Exception exp){
      exp.printStackTrace();
    }
  }
  static int ans = 0;
  static int fact(int num){
    if(num == 0) return 1;
    ans = num * fact(num-1);
    return ans;
  }
}
