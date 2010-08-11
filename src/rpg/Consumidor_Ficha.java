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
					System.out.printf("Servidor enviou:\n Jogador %s | Personagem %s\n", ficha.getNome_jogador(), ficha.getNome_personagem());
                                }
                                catch (Exception e)
                                {
                                        System.out.println("Cliente de FICHAS Desconectado!!");
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
