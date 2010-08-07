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

        public static void setfichas(ArrayList<Ficha> fichas)
        {
            RPG_globais.fichas = fichas;
        }

        public ArrayList<Ficha> setfichas()
        {
            return fichas;
        }

        public static JList getLista_jogadores ()
        {
                return lista_jogadores;
        }

        public static void setLista_jogadores (JList lista_jogadores)
        {
                RPG_globais.lista_jogadores = lista_jogadores;
        }

}
