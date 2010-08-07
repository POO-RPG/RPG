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
                Ficha ficha = null;
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

                        for(Conexao_ficha c : conecxao_ficha)
                        {
                                try
                                {
                                        c.Envia_ficha(ficha);
                                }
                                catch(Exception e)
                                {
                                        conecxao_ficha.remove(c);
                                }
                        }
                }
        }


}
