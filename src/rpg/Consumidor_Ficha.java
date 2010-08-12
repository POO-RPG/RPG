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

import java.util.ArrayList;

public class Consumidor_Ficha extends Thread
{

        private Fila<Ficha> fila_ficha = RPG_globais.getFila_fichas();
        private ArrayList<Conexao_ficha> conecxao_ficha;

        Consumidor_Ficha (Fila<Ficha> fila_ficha, ArrayList<Conexao_ficha> conecxao_ficha)
        {
                this.conecxao_ficha = conecxao_ficha;
        }

        @Override
        public void run ()
        {
                Ficha ficha = null;

                while (true)
                {
                        try
                        {
                                ficha = fila_ficha.retira();
                        }
                        catch (Exception e)
                        {
                                e.printStackTrace();
                                System.exit(1);
                        }
                        //Coloca a ficha no servidor
                        RPG_globais.getfichas().put(ficha.getNome_jogador(), ficha);

                        RPG_globais.Atualiza_lista_jogadores();

                        //Envia para os clientes
                        for (Conexao_ficha c : conecxao_ficha)
                        {
                                try
                                {
                                        c.Enviar_ficha(ficha);
                                }
                                catch (Exception e)
                                {
                                        conecxao_ficha.remove(c);
                                        if (conecxao_ficha.isEmpty())
                                        {
                                                break;
                                        }
                                }
                        }
                }
        }
}
