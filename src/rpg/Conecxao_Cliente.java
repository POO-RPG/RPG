/*
 * Essa Classe é a responsável por gerenciar a conecxão com o cliente:
 *  - Responsável por recevber as mensagens do cliente e coloca-las na fila;
 *  - Enviar mensagens para o cliente;
 *  - Imprimir a mensagem de desconeção no servidor;
 */

package rpg;

/**
 *
 * @author belimawr
 */
import java.net.*;
import java.io.*;
import javax.swing.JTextArea;

public class Conecxao_Cliente extends Thread
{
	private static int cont = 0;
	private int eu;
	private Socket cliente;
	private DataInputStream in;
	private DataOutputStream out;
	private Fila<Mensagem> f;
        private JTextArea txt_chat;


	Conecxao_Cliente(Socket c, Fila<Mensagem> ff, JTextArea txt_chat)
	{
                this.txt_chat = txt_chat;
		eu = ++cont;
		f = ff;
		cliente = c;
		try
		{
			in = new DataInputStream(cliente.getInputStream());
			out = new DataOutputStream(cliente.getOutputStream());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

        //Envia uma mensagem para o cliente
	public void Escrever_Mensagem(String m) throws Exception
	{
		out.writeUTF(m);
	}

        //Fica escutando o cliente e coloca as mensagens na fila
        @Override
	public void run()
	{
                String texto;
		boolean ok = true;
		while(ok)
		{
			try
			{
				f.insere(new Mensagem(in.readUTF()));
			}
			catch(Exception e) //Se a conecxão cair....
			{

				System.out.printf("\nCliente %d desconectou!\n", eu);
                                texto = "\nCliente Desconectado!";
                                txt_chat.append(texto);
                                txt_chat.setCaretPosition(txt_chat.getText().length());
				ok = false;
			}
		}
	}
}


