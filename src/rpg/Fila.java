/*
 * =====================================================================================
 *
 *       ProjectName: 3D&T Online
 *
 *        Version:  1.0
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Anderson de França Queiroz , anderson.f.queiroz(.AT,)gmail dot com
 *                  Felipe Jun Ichi Shimura , felipe-shimura(.AT,)hotmail dot com
 *		    Tiago de França Queiroz , tiago.f.q(.AT,)gmail dot com
 *        Company:  Universidade Federal do ABC - UFABC
 *	  License: GPL 3.0
 *
 * =====================================================================================
 */

package rpg;

class Fila<Tipo>
{

        private Tipo[] elementos;
        private int n_elementos;
        private int primeiro, ultimo;

        Fila (int tamanho)
        {
                elementos = (Tipo[]) new Object[tamanho];
                n_elementos = primeiro = 0;
                ultimo = -1;
        }

        public synchronized void insere (Tipo el) throws InterruptedException
        {
                while (n_elementos == elementos.length)
                {
                        this.wait();
                }
                ultimo++;
                if (ultimo == elementos.length)
                {
                        ultimo = 0;
                }
                elementos[ultimo] = el;
                n_elementos++;
                this.notifyAll();
        }

        public synchronized Tipo retira () throws InterruptedException
        {

                while (n_elementos == 0)
                {
                        this.wait();
                }
                Tipo el = elementos[primeiro];
                primeiro++;
                if (primeiro == elementos.length)
                {
                        primeiro = 0;
                }
                n_elementos--;
                this.notifyAll();
                return el;
        }

        public boolean cheia ()
        {
                return n_elementos == elementos.length;
        }

        public boolean vazia ()
        {
                return n_elementos == 0;
        }
}
