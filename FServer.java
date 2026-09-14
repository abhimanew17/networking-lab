import java.net.*;
import java.io.*;
import java.nio.file.*;
import java.lang.management.ManagementFactory;
public class FServer{
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(5002);
		System.out.println("Server is waiting...");
		while(true){
            Socket s = server.accept();
            System.out.println("Server is connected!!");
            
                try{
                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    PrintWriter out = new PrintWriter(s.getOutputStream(),true);
                    String filename = in.readLine();
                    String pid= ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
                    System.out.println("PID:"+pid);
                    out.println("PID:"+pid);
                    File file=new File(filename);
                    if (file.exists()){
                        out.println("FILE_FOUND");
                        BufferedReader fr = new BufferedReader(new FileReader(file));
                        String line;
                        while((line=fr.readLine())!=null){
                            out.println(line);
                        }
                        out.println("END_OF_FILE");
                    }
                    else{
                        out.println("FILE_NOT_FOUND");
                        out.println("Requested file does not exists.");
                    }
                    
            }catch(Exception e){};
            
            s.close();
        }
            
	}
}
