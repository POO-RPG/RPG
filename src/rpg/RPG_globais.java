/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.ArrayList;
import javax.swing.JList;

/**
 *
 * @author belimawr
 */
public class RPG_globais
{

        static private JList lista_jogadores;
        static private ArrayList<Ficha> fichas = new ArrayList<Ficha>();
        static private ArrayList<String> jogadores = new ArrayList<String>();
        static private Ficha minha_ficha = new Ficha();
        static private Fila<Ficha> fila_fichas = new Fila<Ficha>(1000);

        public synchronized static void setfichas (ArrayList<Ficha> rfichas)
        {
                fichas = rfichas;
        }

        public synchronized static ArrayList<Ficha> getfichas ()
        {
                return fichas;
        }

        public synchronized static void setLista_jogadores (JList rlista_jogadores)
        {
                lista_jogadores = rlista_jogadores;
        }

        public synchronized static JList getLista_jogadores ()
        {
                return lista_jogadores;
        }

        public synchronized static void setJogadores (ArrayList<String> rjogadores)
        {
                jogadores = rjogadores;
        }

        public synchronized static ArrayList<String> getJogadores ()
        {
                return jogadores;
        }

        public synchronized static void setMinha_ficha (Ficha minha_ficha)
        {
                RPG_globais.minha_ficha = minha_ficha;
        }

        public synchronized static Ficha getMinha_ficha ()
        {
                return minha_ficha;
        }

        public synchronized static void setFila_fichas (Fila<Ficha> fila_fichas)
        {
                RPG_globais.fila_fichas = fila_fichas;
        }

        public synchronized static Fila<Ficha> getFila_fichas ()
        {
                return fila_fichas;
        }
}
