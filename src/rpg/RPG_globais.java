/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rpg;

import javax.swing.JList;

/**
 *
 * @author belimawr
 */
public class RPG_globais
{
        static private JList lista_jogadores;

        public static JList getLista_jogadores ()
        {
                return lista_jogadores;
        }

        public static void setLista_jogadores (JList lista_jogadores)
        {
                RPG_globais.lista_jogadores = lista_jogadores;
        }

}
