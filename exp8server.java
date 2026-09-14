import java.net.*;
import java.util.Date;

public class exp8server {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(5000);
        byte[] receiveData = new byte[1024];

        System.out.println("Time Server is running...");

        while (true) {
            DatagramPacket request = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(request);

            String currentTime = new Date().toString();
            byte[] sendData = currentTime.getBytes();

            DatagramPacket response = new DatagramPacket(
                    sendData,
                    sendData.length,
                    request.getAddress(),
                    request.getPort()
            );

            socket.send(response);
            System.out.println("Time sent to " + request.getAddress());
        }
    }
}
