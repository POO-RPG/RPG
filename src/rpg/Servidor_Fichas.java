/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author belimawr
 */
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

        public void Envia_ficha (Ficha ficha)
        {
                ArrayList<Ficha> ff = RPG_globais.getfichas();
                boolean add = false;
                try
                {
                        fila_ficha.insere(ficha);

                }
                catch (InterruptedException ex)
                {
                        ex.printStackTrace();
                }

                for (int i = 0; i < ff.size(); i++)
                {
                        if (ff.get(i).getNome_jogador().equals(ficha.getNome_jogador()))
                        {
                                ff.remove(i);
                                ff.add(ficha);
                                add = true;
                                break;
                        }
                }

                if (add)
                {
                        ff.add(ficha);
                }

                for (Ficha f : ff)
                {
                        try
                        {
                                fila_ficha.insere(f);
                        }
                        catch (Exception e)
                        {
                                e.printStackTrace();
                        }
                }

                RPG_globais.getJogadores().add(ficha.getNome_jogador());
                Collections.sort(RPG_globais.getJogadores(), new Comparator()
                {

                        public int compare (Object arg0, Object arg1)
                        {
                                String s1 = (String) arg0, s2 = (String) arg1;
                                return s1.compareTo(s2);
                        }
                });
                RPG_globais.getLista_jogadores().setListData(RPG_globais.getJogadores().toArray());

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
                                cficha = new Conexao_ficha(socket);
                                cficha.start();
                                conexao_fichas.add(cficha);

                                //Envia as fichas existentes para o novo cliente
                                for (Ficha f : RPG_globais.getfichas())
                                {
                                        cficha.Envia_ficha(f);
                                }
                        }
                        catch (Exception e)
                        {
                                e.printStackTrace();
                        }
                }
        }
}
