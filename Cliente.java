import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        Socket soc = null;
        try {
            soc = new Socket("127.0.0.1", 5001);
            DataInputStream recebido = new DataInputStream(soc.getInputStream());
            DataOutputStream enviado = new DataOutputStream(soc.getOutputStream());

            enviado.writeUTF("Aqui é um cliente falando...");
            System.out.println("(servidor): " + recebido.readUTF());
        } catch (IOException ex) {
            System.err.println("Falha ao inicializar o server");
        } finally {
            try {
                soc.close();
            } catch (IOException e) {
                System.err.println("Falha ao encerrar a conexão");
            }
        }
    }
}