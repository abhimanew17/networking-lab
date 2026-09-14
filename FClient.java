import java.net.*;
import java.io.*;
import java.util.*;

public class FClient{
	public static void main(String[] args) throws Exception{
		Socket s = new Socket("localhost",5002);
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println("Enter the file name:");
        Scanner sc=new Scanner(System.in);
        String filename= sc.nextLine();
        out.println(filename);
        System.out.println(in.readLine());
        String status= in.readLine();
        if (status.equals("FILE_FOUND")){
            String line;
            while(!((line=in.readLine()).equals("END_OF_FILE"))){
                System.out.println(line);
            }
        }
        else{
            System.out.println(in.readLine());
        }
        s.close(); 
	}
}
