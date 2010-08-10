/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JList;

/**
 *
 * @author belimawr
 */
public class RPG_globais
{

        static private JList lista_jogadores;
        static private Map<String, Ficha> fichas = new HashMap<String, Ficha>();
        static private Ficha minha_ficha = new Ficha();
        static private Fila<Ficha> fila_fichas = new Fila<Ficha>(1000);

        public synchronized  static void Atualiza_lista_jogadores()
        {
                ArrayList<String> nomes = new ArrayList<String>();
                for(Ficha f: fichas.values())
                        nomes.add(f.getNome_jogador());

                Collections.sort(nomes, new Comparator() {

                        public int compare (Object arg0, Object arg1)
                        {
                                String s1 = (String) arg0, s2 = (String) arg1;
                                return s1.compareToIgnoreCase(s2);
                        }
                });

                lista_jogadores.setListData(nomes.toArray());
        }

        public synchronized static void setfichas (Map<String, Ficha> rfichas)
        {
                fichas = rfichas;
        }

        public synchronized static Map<String, Ficha> getfichas ()
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
