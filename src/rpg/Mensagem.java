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

import java.util.*;

public class Mensagem
{

        private String mensagem;
        private Date data;

        Mensagem (String m)
        {
                mensagem = new String(m);
                data = new Date();
        }

        public String getMensagem ()
        {
                return String.format("[%d:%d:%d] %s", data.getHours(), data.getMinutes(), data.getSeconds(), mensagem);
        }
}
