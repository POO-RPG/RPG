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
import java.util.ArrayList;

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
        private Conexao_ficha conecxao_ficha;
        private ArrayList<String> jogadores;

        Cliente(JTextArea txt_chat)
        {
                this.txt_chat = txt_chat;
                try
		{
                        //Pergunda as informações da conecxão e do jogador
			nick = JOptionPane.showInputDialog("Qual o seu nick?", "Jogador");
                        ip_servidor = JOptionPane.showInputDialog("Digite o IP do servidor", "127.0.0.1");
                        porta = Integer.parseInt(JOptionPane.showInputDialog("Digite a porta do servidor:","2010"));
			if (nick == null)
				nick = "Sem nick";

                        //Cria o soket, o input e output stream para o chat, e o escrevedor
			s = new Socket(ip_servidor, porta);
			in = new DataInputStream(s.getInputStream());
			out = new DataOutputStream(s.getOutputStream());
			e = new Escrevedor(in, txt_chat);
			e.start();
                        JOptionPane.showMessageDialog(null, "Conecxão do chat concluida");

                        //Cria o socket para as fichas
                        Socket s1 = new Socket(ip_servidor,porta + 1);
                        JOptionPane.showMessageDialog(null, "Socket da ficha criado");
                        conecxao_ficha = new Conexao_ficha(s1, jogadores);
                        JOptionPane.showMessageDialog(null, "Conecxão Cliente criada");
                        conecxao_ficha.start();
                        JOptionPane.showMessageDialog(null, "Fim do criador da classe Cliente");


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

        public String getNick()
        {
                return nick;
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
