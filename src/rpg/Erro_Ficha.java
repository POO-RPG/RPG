package rpg;

import java.io.IOException;

public class Erro_Ficha extends IOException
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
