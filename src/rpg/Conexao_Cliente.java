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

package rpg;


import java.net.*;
import java.io.*;
import javax.swing.JTextArea;

public class Conexao_Cliente extends Thread
{

        private static int cont = 0;
        private int eu;
        private Socket cliente;
        private DataInputStream in;
        private DataOutputStream out;
        private Fila<Mensagem> f;
        private JTextArea txt_chat;

        Conexao_Cliente (Socket c, Fila<Mensagem> ff, JTextArea txt_chat)
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
                catch (Exception e)
                {
                        e.printStackTrace();
                }
        }

        //Envia uma mensagem para o cliente
        public void Escrever_Mensagem (String m) throws Exception
        {
                out.writeUTF(m);
        }

        //Fica escutando o cliente e coloca as mensagens na fila
        @Override
        public void run ()
        {
                String texto;
                boolean ok = true;
                while (ok)
                {
                        try
                        {
                                f.insere(new Mensagem(in.readUTF()));
                        }
                        catch (Exception e) //Se a conecxão cair....
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


