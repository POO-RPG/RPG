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

import java.util.*;
import javax.swing.JTextArea;

public class Consumidor extends Thread
{

        private Fila<Mensagem> f;
        private ArrayList<Conexao_Cliente> clientes;
        private JTextArea txt_chat;

        Consumidor (Fila<Mensagem> ff, ArrayList<Conexao_Cliente> clientes, JTextArea txt_chat)
        {
                f = ff;
                this.clientes = clientes;
                this.txt_chat = txt_chat;
        }

        //Retira uma mensagem da fila, escreve na área de chat, e envia essa mensagem para todos os outros clientes
        @Override
        public void run ()
        {
                Mensagem m = null;
                String texto;
                while (true)
                {
                        try
                        {

                                m = f.retira();
                        }
                        catch (Exception e)
                        {
                                e.printStackTrace();
                        }

                        //Escreve para o servidor
                        txt_chat.append("\n" + m.getMensagem());
                        txt_chat.setCaretPosition(txt_chat.getText().length());

                        //Envia a mensagem para todos os clientes
                        for (Conexao_Cliente c : clientes)
                        {
                                try
                                {
                                        c.Escrever_Mensagem(String.format("%s\n", m.getMensagem()));
                                }
                                catch (Exception e)
                                {
                                        clientes.remove(c);
                                        if (clientes.isEmpty())
                                        {
                                                break;
                                        }
                                }
                        }
                }
        }
}

