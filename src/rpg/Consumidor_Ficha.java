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

        Consumidor_Ficha (Fila<Ficha> fila_ficha, ArrayList<Conexao_ficha> conecxao_ficha)
        {
                this.conecxao_ficha = conecxao_ficha;
        }

        @Override
        public void run ()
        {
                Ficha ficha = null;
                boolean adicionado = false;

                while (true)
                {
                        adicionado = false;
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
                        for (int i = 0; i < RPG_globais.getfichas().size(); i++)
                        {
                                //System.out.printf("Tamanho: %d Array: |%s|, Retirada: |%s|\n", RPG_globais.getfichas().size(), RPG_globais.getfichas().get(i).getNome_jogador(), ficha.getNome_jogador() );
                                if (RPG_globais.getfichas().get(i).getNome_jogador().equalsIgnoreCase(ficha.getNome_jogador()))
                                {
                                        adicionado = true;
                                        RPG_globais.getfichas().add(i, ficha);
                                        break;
                                }
                        }

                        if (adicionado == false) //Se a ficha não foi adicionada, adiciona ela
                        {
                                RPG_globais.getfichas().add(ficha);
                                adicionado = true;
                                RPG_globais.getJogadores().add(ficha.getNome_jogador());
                                RPG_globais.getLista_jogadores().setListData(RPG_globais.getJogadores().toArray());
                        }

                        //Envia para os clientes
                        for (Conexao_ficha c : conecxao_ficha)
                        {
                                try
                                {
                                        c.Enviar_ficha(ficha);
                                }
                                catch (Exception e)
                                {
                                        System.out.println("Cliente de FICHAS Desconectado!!");
                                        conecxao_ficha.remove(c);
                                        RPG_globais.getJogadores().remove(ficha.getNome_jogador());
                                        RPG_globais.getfichas().remove(ficha);
                                        RPG_globais.getLista_jogadores().setListData(RPG_globais.getJogadores().toArray());
                                        if (conecxao_ficha.isEmpty())
                                        {
                                                break;
                                        }
                                }
                        }
                }
        }
}
