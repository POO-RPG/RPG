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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Servidor_Fichas extends Thread implements Envia_ficha
{

        private ArrayList<String> jogadores;
        private ArrayList<Conexao_ficha> conexao_fichas;
        private ServerSocket server_fichas;
        private Fila<Ficha> fila_ficha;
        Consumidor_Ficha consome_ficha;

        public Servidor_Fichas (ArrayList<Conexao_ficha> conexao_fichas, ArrayList<String> jogadores, int porta)
        {
                this.conexao_fichas = conexao_fichas;
                this.jogadores = jogadores;
                this.fila_ficha = RPG_globais.getFila_fichas();
                this.consome_ficha = new Consumidor_Ficha(fila_ficha, this.conexao_fichas);
                this.consome_ficha.start();

                try
                {
                        server_fichas = new ServerSocket(porta + 1);
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                }
        }

        public void Enviar_ficha (Ficha ficha)
        {
                try
                {
                        fila_ficha.insere(ficha);

                }
                catch (InterruptedException ex)
                {
                        ex.printStackTrace();
                }
        }

        public ArrayList<Conexao_ficha> getconexao_fichas ()
        {
                return conexao_fichas;
        }

        public ArrayList<String> getJogadores ()
        {
                return jogadores;
        }

        public void run ()
        {
                Conexao_ficha cficha;
                Socket socket;

                while (true)
                {

                        try
                        {
                                socket = server_fichas.accept();
                                cficha = new Conexao_ficha(socket, true);
                                cficha.start();
                                conexao_fichas.add(cficha);

                                //Envia as fichas existentes para o novo cliente
                                for (Ficha f : RPG_globais.getfichas().values())
                                {
                                        cficha.Enviar_ficha(f);
                                }
                        }
                        catch (Exception e)
                        {
                                e.printStackTrace();
                        }
                }
        }
}
