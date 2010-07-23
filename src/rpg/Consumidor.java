/*
 * Essa classe é responsável por:
 *  - Retirar as mensagens da fila e envia-la a todos os clientes;
 *  - Escrever as mensagens recebinas na área de chat do servidor
 */

package rpg;

/**
 *
 * @author belimawr
 */
import java.util.*;
import javax.swing.JTextArea;

public class Consumidor extends Thread
{
	private Fila<Mensagem> f;
	private ArrayList<Conecxao_Cliente> clientes;
        private JTextArea txt_chat;

	Consumidor(Fila<Mensagem> ff, ArrayList<Conecxao_Cliente> clientes, JTextArea txt_chat)
	{
		f = ff;
		this.clientes = clientes;
                this.txt_chat = txt_chat;
	}

        //Retira uma mensagem da fila, escreve na área de chat, e envia essa mensagem para todos os outros clientes
        @Override
	public void run()
	{
		Mensagem m = null;
                String texto;
		while(1>0)
		{
			try
			{

				m = f.retira();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

                        //Escreve a mensagem na área de chat
			System.out.printf("%s\n", m.getMensagem());
                        texto = txt_chat.getText();
                        texto += "\n" + m.getMensagem();
                        txt_chat.setText(texto);

                        //Envia a mensagem para todos os clientes
			for(Conecxao_Cliente c: clientes)
			{
				try
				{
					c.Escrever_Mensagem(String.format("%s\n", m.getMensagem()));
				}
				catch(Exception e)
				{
					clientes.remove(c);
				}
			}
		}
	}
}

