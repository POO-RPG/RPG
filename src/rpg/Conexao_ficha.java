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
import java.net.*;

public class Conexao_ficha extends Thread implements Envia_ficha
{

        private ObjectOutputStream out;
        private ObjectInputStream in;
        private Socket conexao_cliente;
        private boolean mestrando;

        Conexao_ficha (Socket conexao_cliente, boolean mestrando)
        {
                this.conexao_cliente = conexao_cliente;
                this.mestrando = mestrando;

                try
                {
                        out = new ObjectOutputStream(conexao_cliente.getOutputStream());
                        in = new ObjectInputStream(conexao_cliente.getInputStream());
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                        System.exit(1);
                }
        }

        public void Enviar_ficha (Ficha ficha)
        {
                try
                {
                        out.writeObject(ficha);
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                }
        }

        @Override
        public void run ()
        {
                Ficha ficha;
                boolean ok = true;

                while (ok)
                {
                        try
                        {
                                ficha = null;
                                ficha = (Ficha) in.readObject();

                                if (mestrando)
                                {
                                        RPG_globais.getFila_fichas().insere(ficha);
                                }

                                RPG_globais.getfichas().put(ficha.getNome_jogador(), ficha);
                                RPG_globais.Atualiza_lista_jogadores();

                        }
                        catch (Exception e)
                        {
                                e.printStackTrace();
                                System.out.println("***********************Cliente Ficha DESCONECTADO*******************");
                                ok = false;
                        }
                }
        }
}
