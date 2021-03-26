import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        Socket soc = null;
        ServerSocket socServidor = null;
        try {
            socServidor = new ServerSocket(5001);
            soc = socServidor.accept();
            DataInputStream recebido = new DataInputStream(soc.getInputStream());
            DataOutputStream enviado = new DataOutputStream(soc.getOutputStream());
            System.out.println("(cliente): " + recebido.readUTF());
            enviado.writeUTF("O servidor recebeu sua mensagem.");
        } catch (IOException ex) {
            System.err.println("Falha na conexão");
        } finally {
            try {
                soc.close();
                socServidor.close();
            } catch (IOException e) {
                System.err.println("Falha ao encerrar a conexão");
            }
        }
    }
    
}
