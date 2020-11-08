// Oleg Kiselev
// 06.07.2020, 14:56

package ru.progwards.sever.testprogwards2.test_15;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
//        try (ServerSocket serverSocket = new ServerSocket(50000)) {
//            Socket socket = serverSocket.accept();
//
//            InputStream ips = socket.getInputStream();
//            OutputStream ops = socket.getOutputStream();
//
//            Scanner scanner = new Scanner(ips);
//            boolean done = false;
//            while (!done && scanner.hasNextLine()) {
//                String str = scanner.nextLine();
//                PrintWriter pw = new PrintWriter(ops);
//                pw.println("Echo: " + str);
//                pw.flush();
//                if (str.equalsIgnoreCase("EXIT"))
//                    done = true;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (ServerSocket serverSocket = new ServerSocket(50000)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ThreadServer(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadServer implements Runnable {
    Socket socket;

    public ThreadServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (OutputStream ops = socket.getOutputStream();
             InputStream ips = socket.getInputStream()) {

            Scanner scanner = new Scanner(ips);
            boolean done = false;
            while (!done && scanner.hasNextLine()) {
                String str = scanner.nextLine();
                PrintWriter pw = new PrintWriter(ops);
                pw.println("Echo: " + str);
                pw.flush();
                if (str.equalsIgnoreCase("EXIT"))
                    done = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
