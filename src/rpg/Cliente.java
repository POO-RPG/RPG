/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rpg;

/**
 *
 * @author belimawr
 */
import javax.swing.*;
import java.net.*;
import java.io.*;

public class Cliente
{
	private String nick, ip_servidor;
        private Socket s = null;
        private DataInputStream in;
        private DataOutputStream out = null;
        private String m;
        private Escrevedor e;
        private int porta;
        private JTextArea txt_chat;

        Cliente(JTextArea txt_chat)
        {
                this.txt_chat = txt_chat;
                try
		{
			nick = JOptionPane.showInputDialog("Qual o seu nick?");
                        ip_servidor = JOptionPane.showInputDialog("Digite o IP do servidor");
                        porta = Integer.parseInt(JOptionPane.showInputDialog("Digite a porta do servidor:"));
			if (nick == null)
				nick = "Sem nick";

			s = new Socket(ip_servidor, porta);
			in = new DataInputStream(s.getInputStream());
			out = new DataOutputStream(s.getOutputStream());
			e = new Escrevedor(in, txt_chat);
			e.start();
		}
                catch (NumberFormatException eeeeee)
                {
                        JOptionPane.showMessageDialog(null, "A porta deve ser um número inteiro e positivo!");
                }
		catch(Exception eee)
		{
			System.out.printf("\nConexão recusada pelo servidor!\n");
			System.exit(1);
		}
        }

	public void Escrever_mensagem(String mensagem)
	{
                try
                {
                        if (mensagem == null)
                        {
                                s.close();
                                System.exit(0);
                        }
                        out.writeUTF("<" + nick + "> " + mensagem);
                }
                catch(Exception eee)
                {
                        System.out.printf("\n\nErro no servidor, conexão fechada!\n\n");
                        System.exit(1);
                }
	}
}
