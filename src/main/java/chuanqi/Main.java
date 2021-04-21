package chuanqi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        long total = 0;
        int numTest = 10;
        int numExecution = 100;
        for (int j = 0; j < numTest; j++) {
            long startTime = System.currentTimeMillis();
            for (int i = 0 ; i < numExecution; i++) {
                main.testFlaskPOS();
            }
            long elapse = System.currentTimeMillis() - startTime;
            System.out.println("Time used: " + elapse);
            total += elapse;
        }

        System.out.println("平均100次总计用时：" + total/10);
    }

    public void testFlaskPOS() throws IOException {

        URLConnection connection = new URL("http://localhost:5000/pos").openConnection();
        connection.connect();
        InputStream inputStream = connection.getInputStream();

        String result = IOUtil.getString(inputStream);
    }

    public void testFlaskString() throws IOException {
        URLConnection connection = new URL("http://localhost:5000").openConnection();
        connection.connect();
        InputStream inputStream = connection.getInputStream();
//        System.out.println(inputStream.available());
        String result = IOUtil.getString(inputStream);

//        System.out.println(result);
    }

    public void testSocket() throws IOException {
        Socket socket = new Socket("127.0.0.1", 5000);
        OutputStream out = socket.getOutputStream();
        out.write("some data".getBytes());
        out.flush();
        out.close();

        socket.close();
    }
}
