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
        static private ArrayList<Ficha> fichas;
        static private ArrayList<String> jogadores;

        public static void setfichas(ArrayList<Ficha> rfichas)
        {
            fichas = rfichas;
        }

        public static ArrayList<Ficha> getfichas()
        {
            return fichas;
        }

        public static JList getLista_jogadores ()
        {
                return lista_jogadores;
        }

        public static void setLista_jogadores (JList rlista_jogadores)
        {
                lista_jogadores = rlista_jogadores;
        }

        public static ArrayList<String> getJogadores ()
        {
                return jogadores;
        }

        public static void setJogadores (ArrayList<String> rjogadores)
        {
                jogadores = rjogadores;
        }



}
