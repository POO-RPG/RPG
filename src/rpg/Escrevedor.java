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

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Escrevedor extends Thread
{

        private DataInputStream in;
        private JTextArea txt_chat;

        Escrevedor (DataInputStream i, JTextArea txt_chat)
        {
                in = i;
                this.txt_chat = txt_chat;
        }

        @Override
        public void run ()
        {
                String mensagem, texto;
                while (true)
                {
                        try
                        {
                                mensagem = in.readUTF();
                                txt_chat.append(mensagem);
                                txt_chat.setCaretPosition(txt_chat.getText().length());
                        }
                        catch (EOFException e)
                        {
                                JOptionPane.showMessageDialog(null, "A conexão com o servidor foi interrompida.");
                                System.exit(1);
                        }
                        catch (Exception e)
                        {
                                e.printStackTrace();
                                System.exit(1);
                        }
                }
        }
}
