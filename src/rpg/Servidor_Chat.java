/*
 * =====================================================================================
 *
 *       ProjectName: 3D&T Online
 *
 *        Version:  1.0
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Anderson de França Queiroz , anderson.f.queiroz(.AT,)gmail dot com
 *                  Felipe Jun Ichi Shimura , felipe-shimura(.AT,)hotmail dot com
 *		    Tiago de França Queiroz , tiago.f.q(.AT,)gmail dot com
 *        Company:  Universidade Federal do ABC - UFABC
 *	  License: GPL 3.0
 *
 * =====================================================================================
 */

/*
 * Essa Classe é a responsável por:
 *  - Ficar escutando a porta selecionada por novas conecxões;
 *  - Criar um objeto Conecxao_Cliente para cada nova conecxão;
 *  - Manter a Lista de clientes;
 *  - Criar o consumidor;
 *  - Manter a fila de mensagens
 */
package rpg;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Servidor_Chat extends Thread
{

        private static int cont_clientes = 0;
        private String[] nome_clientes =
        {
        };
        private ServerSocket servidor;
        private Fila<Mensagem> f;
        private ArrayList<Conexao_Cliente> clientes;
        private Consumidor c;
        private JTextArea txt_chat;
        private String nick = "Mestre";

        Servidor_Chat (int porta, JTextArea txt_chat) throws IOException
        {
                try
                {
                        this.txt_chat = txt_chat;
                        servidor = new ServerSocket(porta);
                        f = new Fila<Mensagem>(1000);
                        clientes = new ArrayList<Conexao_Cliente>();
                        c = new Consumidor(f, clientes, txt_chat);
                        c.start();

                }
                catch (Exception e)
                {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "A porta " + porta + " já está em uso!");
                        throw new IOException("porta em uso");
                }
        }

        public ArrayList<Conexao_Cliente> getClientes ()
        {
                return clientes;
        }

        public void Enviar_mensagem (String s)
        {
                if (s.equals(""))
                {
                        return;
                }

                try
                {
                        f.insere(new Mensagem("<" + nick + "> " + s));
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                }
        }

        @Override
        public void run ()
        {
                Conexao_Cliente novo_jogador;
                Socket novo_soket;
                while (true)
                {
                        try
                        {
                                novo_soket = servidor.accept();
                                novo_jogador = new Conexao_Cliente(novo_soket, f, txt_chat);
                                novo_jogador.start();
                                clientes.add(novo_jogador);
                                txt_chat.append("\nCliente Conectado!");
                                txt_chat.setCaretPosition(txt_chat.getText().length());// Rola a caixa de texto.
                        }
                        catch (Exception e)
                        {
                                e.printStackTrace();
                                break;
                        }
                }
        }
}
