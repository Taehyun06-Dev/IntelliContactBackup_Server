package sample;

import javafx.application.Platform;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Thread_Server implements Runnable{

    private Controller controller;

    public Thread_Server(Controller ct){
        controller = ct;
    }

    public void writedata(String str){
        Platform.runLater(() -> controller.Write_data(str));
    }
    @Override
    public void run() {
        try(ServerSocket serverSocket = new ServerSocket(51137)){
            writedata("console> 클라이언트 연결 대기중...");
            System.out.println("대기");
            while(true) {
                Socket socket = serverSocket.accept();
                writedata("console> 클라이언트와 " +
                        socket.getLocalPort() + " 포트로 연결되었습니다.");
                System.out.println("연결!");
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String in;
                while((in = reader.readLine()) != null){
                    writedata(in);
                    System.out.println(in);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
