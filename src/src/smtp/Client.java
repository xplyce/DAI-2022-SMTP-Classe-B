package smtp;

import model.mail.Mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {

    private final String address;
    private final int port;
    Socket socket;
    PrintWriter writer;
    BufferedReader reader;

    public Client(String addr, int port) {
        address = addr;
        this.port = port;
    }

    public void sendMail(Mail mail) throws IOException {

        StringBuilder test = new StringBuilder();

        socket = new Socket(address, port);
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

        writer.write("HELO localhost\r\n");
        test.append("HELO localhost\r\n"); //TEST
        writer.flush();
        String line = reader.readLine();

        while(!line.startsWith("250 ")){ //ou un readLine
            System.out.println("test : " + line);
            line = reader.readLine();
        }

//        if(!line.startsWith("250")){
//            throw new IOException("SMTP error: " + line);
//        }

        writer.write("MAIL FROM:" + mail.getSender() + "\r\n");
        test.append("MAIL FROM:" + mail.getSender() + "\r\n"); //TEST
        writer.flush();

        for(String receiver : mail.getReceivers()){
            writer.write("RCPT TO:" + receiver + "\r\n");
            test.append("RCPT TO:" + receiver + "\r\n"); //TEST
            writer.flush();
        }

//        for(String cc : mail.getCc()){
//            writer.write("RCPT TO:");
//            writer.write(cc);
//            writer.write("\r\n");
//            writer.flush();
//        }

        writer.write("DATA\r\n");
        test.append("DATA\r\n"); //TEST
        writer.flush();

        writer.write("Content-Type: text/plain; charset=\"utf8\"\r\n");
        test.append("Content-Type: text/plain; charset=\"utf8\"\r\n"); //TEST

        writer.write("From:" + mail.getSender() + "\r\n");
        test.append("From:" + mail.getSender() + "\r\n"); //TEST


        writer.write("To:");
        test.append("To:");
        for (int i = 0; i < mail.getReceivers().length; i++){
            writer.write(mail.getReceivers()[i] + (i != mail.getReceivers().length - 1 ? "," : ""));
            test.append(mail.getReceivers()[i] + (i != mail.getReceivers().length - 1 ? "," : "")); //TEST

        }
        writer.write("\r\n");
        test.append("\r\n"); //TEST

        writer.flush();

        writer.write(mail.getText() + "\r\n.\r\n");
        test.append(mail.getText() + "\r\n.\r\n"); //TEST
        writer.flush();

        writer.write("QUIT\r\n");
        test.append("QUIT\r\n"); //TEST
        writer.flush();

        System.out.print(test);
        reader.close();
        writer.close();
        socket.close();
    }
}
