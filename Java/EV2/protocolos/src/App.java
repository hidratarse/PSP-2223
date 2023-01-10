import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class App {
    public static void main(String[] args) {
        try {
            Socket con = new Socket("192.168.20.200", 8000);
            BufferedOutputStream out = new BufferedOutputStream(con.getOutputStream());
            out.write("mondongo".getBytes());
            out.close();
            con.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}