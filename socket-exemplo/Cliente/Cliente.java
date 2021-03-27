import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Socket soc = null;
        try {
            soc = new Socket("127.0.0.1", 5001);
            DataInputStream recebido = new DataInputStream(soc.getInputStream());
            DataOutputStream enviado = new DataOutputStream(soc.getOutputStream());

            Scanner myObj = new Scanner(System.in);
            System.out.println("Digite a mensagem");
            System.out.println("(servidor): " + recebido.readUTF());
        } catch (IOException ex) {
            System.err.println("Falha ao inicializar o server");
        } finally {
            try {
                System.out.println("Conexão encerrada");
                soc.close();
            } catch (IOException e) {
                System.err.println("Falha ao encerrar a conexão");
            }
        }
    }
}