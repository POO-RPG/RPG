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
        private Fila<Ficha> fila_ficha;
        private ArrayList<Conexao_ficha> conecxao_ficha;

        Consumidor_Ficha(Fila<Ficha> fila_ficha, ArrayList<Conexao_ficha> conecxao_ficha)
        {
                this.fila_ficha = fila_ficha;
                this.conecxao_ficha = conecxao_ficha;
        }

        @Override
        public void run()
        {
                System.out.println("A thread consumidora foi iniciada!");
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
                        System.out.println("Ficha retirada da fila com sucesso, verificando se a ficha já existe no servidor...");
                        //Coloca a ficha no servidor
                        for(i=0; i < RPG_globais.getJogadores().size() ; i++)
                        {
                                if(RPG_globais.getfichas().get(i).getNome_personagem().equals(ficha.getNome_personagem()))
                                {
                                        adicionado = true;
                                        RPG_globais.getfichas().add(i, ficha);
                                        System.out.println("A ficha " + ficha.getNome_jogador() + " já existe no servidor, e foi sobreescrita");
                                        break;
                                }
                        }

                        System.out.println("Verificando se a ficha já foi adicionada");
                        if(!adicionado) //Se a ficha não foi adicionada, adiciona ela
                        {
                                 RPG_globais.getfichas().add(ficha);
                                 adicionado = true;
                                 RPG_globais.getJogadores().add(ficha.getNome_jogador());
                                 RPG_globais.getLista_jogadores().setListData(RPG_globais.getJogadores().toArray());
                                 System.out.println("A Ficha " + ficha.getNome_jogador() + "não existia, adicionando nova ficha");
                        }

                        //Envia para os clientes
                        System.out.println("Estou antes do for de envio");
                        for(Conexao_ficha c : conecxao_ficha)
                        {
                                try
                                {
                                        c.Envia_ficha(ficha);
                                        System.out.println("Ficha de " + ficha.getNome_jogador() + " Enviada!");
                                }
                                catch(Exception e)
                                {
                                        conecxao_ficha.remove(c);
                                        if(conecxao_ficha.isEmpty())
                                                break;
                                }
                        }
                }
                
                System.out.println("A thread consumidora MORREU!!");
        }
        


}
