import java.net.*;

public class exp8client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();

        InetAddress serverAddress = InetAddress.getByName("localhost");

        byte[] sendData = "TIME".getBytes();

        DatagramPacket request = new DatagramPacket(
                sendData,
                sendData.length,
                serverAddress,
                5000
        );

        socket.send(request);

        byte[] receiveData = new byte[1024];
        DatagramPacket response = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(response);

        String time = new String(response.getData(), 0, response.getLength());
        System.out.println("Server Time: " + time);

        socket.close();
    }
}




