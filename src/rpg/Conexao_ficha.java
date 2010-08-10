package rpg;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
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

        Conexao_ficha (Socket conexao_cliente)
        {
                this.conexao_cliente = conexao_cliente;

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
                ArrayList<String> jogadores = RPG_globais.getJogadores();
                boolean ok = true;

                while (ok)
                {
                        ArrayList<String> nomes = new ArrayList<String>();
                        try
                        {
                                ficha = (Ficha) in.readObject();
                                RPG_globais.getFila_fichas().insere(ficha);

                                RPG_globais.getfichas().put(ficha.getNome_jogador(), ficha);

                                for(Ficha f: RPG_globais.getfichas().values())
                                        nomes.add(f.getNome_jogador());

                                RPG_globais.getLista_jogadores().setListData(nomes.toArray());

                        }
                        catch (Exception e)
                        {
                                e.printStackTrace();
                                System.out.println("***********************Cliente Ficha DESCONECTADO*******************");
                                ok = false;
                        }
                }
        }

        public Ficha get_ficha (String Nome_jogador)
        {
                for (int i = 0; i < RPG_globais.getfichas().size(); i++)
                {
                        if (RPG_globais.getfichas().get(i).getNome_jogador().equals(Nome_jogador))
                        {
                                return (RPG_globais.getfichas().get(i));
                        }
                }
                JOptionPane.showMessageDialog(null, "Ficha não encontrada");

                return (null);
        }
}
