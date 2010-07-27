/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rpg;

import java.io.IOException;

/**
 *
 * @author fenix
 */
class Erro_Ficha extends IOException
{
	private String erro;

	Erro_Ficha(String s)
	{
		erro = s;
	}

	public String toString()
	{
		return erro;
	}
}
