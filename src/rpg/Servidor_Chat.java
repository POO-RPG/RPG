/*
 * Essa Classe é a responsável por:
 *  - Ficar escutando a porta selecionada por novas conecxões;
 *  - Criar um objeto Conecxao_Cliente para cada nova conecxão;
 *  - Manter a Lista de clientes;
 *  - Criar o consumidor;
 *  - Manter a fila de mensagens
 */

package rpg;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author belimawr
 */
public class Servidor_Chat extends Thread
{
        private static int cont_clientes = 0;
        private String[] nome_clientes = {};
        private ServerSocket servidor;
        private Fila<Mensagem> f;
        private ArrayList<Conecxao_Cliente> clientes;
        private Consumidor c;
        private JTextArea txt_chat;
        private String nick = "Mestre";

        Servidor_Chat(int porta, JTextArea txt_chat)
        {
                try
                {
                        this.txt_chat = txt_chat;
                        servidor = new ServerSocket(porta);
                        f = new Fila<Mensagem>(1000);
                        clientes = new ArrayList<Conecxao_Cliente>();
                        c = new Consumidor(f, clientes, txt_chat);
                        c.start();

                }
                catch(Exception e)
                {
                        e.printStackTrace();
                        System.exit(1);
                }
        }

        public ArrayList<Conecxao_Cliente> getClientes ()
        {
                return clientes;
        }

        public void Enviar_mensagem(String s)
        {
                try
                {
                        f.insere(new Mensagem("<" + nick + "> " + s));
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                }
        }
        
        @Override
        public void run()
        {
                Conecxao_Cliente novo_jogador;
                Socket novo_soket;
                while(true)
                {
                        try
                        {
                                novo_soket = servidor.accept();
                                novo_jogador = new Conecxao_Cliente(novo_soket, f, txt_chat);
                                novo_jogador.start();
                                clientes.add(novo_jogador);
                                txt_chat.append("\nCliente Conectado!");
                                txt_chat.setCaretPosition(txt_chat.getText().length());// Rola a caixa de texto.
                        }
                        catch(Exception e)
                        {
                                e.printStackTrace();
                        }
                }
        }
}
