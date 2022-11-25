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
        socket = new Socket(address, port);
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),true);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));


        reader.readLine();
        writer.write("HELO localhost\r\n");
        writer.flush();
        String line = reader.readLine();

        if(!line.startsWith("250")){
            throw new IOException("SMTP error: " + line);
        }

        writer.write("MAIL FROM:");
        writer.write(mail.getSender() + "\r\n");
        writer.flush();

        for(String receiver : mail.getReceivers()){
            writer.write("RCPT TO:");
            writer.write(receiver + "\r\n");
            writer.flush();
        }

//        for(String cc : mail.getCc()){
//            writer.write("RCPT TO:");
//            writer.write(cc);
//            writer.write("\r\n");
//            writer.flush();
//        }

        writer.write("DATA\r\n");
        writer.flush();

        writer.write("Content-Type: text/plain; charset=\"utf8\"\r\n");
        writer.write("From: " + mail.getSender() + "\r\n");

        writer.write("To: ");
        for (int i = 0; i < mail.getReceivers().length; i++){
            writer.write(mail.getReceivers()[i] + (i != mail.getReceivers().length - 1 ? "," : ""));
        }
        writer.write("\r\n");
        writer.flush();

        writer.write(mail.getText());
        writer.write("\r\n.\r\n");
        writer.flush();

        writer.write("QUIT\r\n");
        writer.flush();

        reader.close();
        writer.close();
        socket.close();







    }
}
