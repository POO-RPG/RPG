/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rpg;

import java.util.ArrayList;

/**
 *
 * @author belimawr
 */
public class Consumidor_Ficha extends Thread
{
        private Fila<Ficha> fila_ficha = RPG_globais.getFila_fichas();
        private ArrayList<Conexao_ficha> conecxao_ficha;

        Consumidor_Ficha(Fila<Ficha> fila_ficha, ArrayList<Conexao_ficha> conecxao_ficha)
        {
                this.conecxao_ficha = conecxao_ficha;
        }

        @Override
	public void run()
        {
                Ficha ficha = null;
                int i;
                boolean adicionado = false;
                
                while(true)
                {
                        try
                        {
                                ficha = fila_ficha.retira();
			}
                        catch(Exception e)
                        {
                                e.printStackTrace();
                                System.exit(1);
                        }
                        //Coloca a ficha no servidor
                        for(i=0; i < RPG_globais.getJogadores().size() ; i++)
                        {
                                if(RPG_globais.getfichas().get(i).getNome_personagem().equals(ficha.getNome_personagem()))
                                {
                                        adicionado = true;
                                        RPG_globais.getfichas().add(i, ficha);
                                        break;
                                }
                        }

                        if(!adicionado) //Se a ficha não foi adicionada, adiciona ela
                        {
                                 RPG_globais.getfichas().add(ficha);
                                 adicionado = true;
                                 RPG_globais.getJogadores().add(ficha.getNome_jogador());
                                 RPG_globais.getLista_jogadores().setListData(RPG_globais.getJogadores().toArray());
                        }

                        //Envia para os clientes
                        for(Conexao_ficha c : conecxao_ficha)
                        {
                                try
                                {
                                        c.Envia_ficha(ficha);
                                }
                                catch(Exception e)
                                {
                                        conecxao_ficha.remove(c);
                                        if(conecxao_ficha.isEmpty())
                                                break;
                                }
                        }
                }
        }
        


}
