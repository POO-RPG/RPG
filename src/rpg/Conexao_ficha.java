package rpg;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.net.*;
/**
 *
 * @author HP
 */
public class Conexao_ficha extends Thread
{
    private ArrayList<Ficha> fichas_r;
    private ArrayList<String> jogadores;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket conexao_cliente;

    Conexao_ficha(Socket conexao_cliente, ArrayList<String> jogadores)
    {
        this.conexao_cliente = conexao_cliente;
        this.fichas_r = fichas_r;
        this.jogadores = jogadores;

        try
        {
            out = new ObjectOutputStream(conexao_cliente.getOutputStream());
            in = new ObjectInputStream(conexao_cliente.getInputStream());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
            Ficha ficha;

        while(true)
        {
            try
            {
                ficha = (Ficha)in.readObject();
                for(int i = 0; i < fichas_r.size(); i++)
                {
                    //Se já existir esse personagem, a ficha existente é sobrescrita
                    if(fichas_r.get(i).getNome_personagem().equals(ficha.getNome_personagem()))
                        fichas_r.add(i, ficha);
                    else
                    {
                        fichas_r.add(ficha);
                        jogadores.add(ficha.getNome_jogador());
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public Ficha get_ficha(String Nome_jogador)
    {
        for(int i = 0; i < fichas_r.size(); i++)
        {
            if(fichas_r.get(i).getNome_jogador().equals(Nome_jogador))
                return (fichas_r.get(i));
        }
        JOptionPane.showMessageDialog(null, "Ficha não encontrada");

        return (null);
    }
}