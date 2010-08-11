package rpg;

import java.io.*;
import java.net.*;

/**
 *
 * @author HP
 */
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
                        System.out.println("\nConexão enviando:\nNome: " + ficha.getNome_jogador() + " Personagem: " + ficha.getNome_personagem());
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
                                ficha = (Ficha) in.readObject();
                                if (!mestrando)
                                {
                                        System.out.printf("\nCliente recebeu: Nome: %s Personagem: %s\n", ficha.getNome_jogador(), ficha.getNome_personagem());
                                }

                                if (mestrando)
                                {
                                        RPG_globais.getFila_fichas().insere(ficha);
                                        System.out.printf("\nMestre recebeu: Nome: %s Personagem: %s\n", ficha.getNome_jogador(), ficha.getNome_personagem());
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
