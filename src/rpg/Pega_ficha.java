package rpg;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.net.*;
/**
 *
 * @author HP
 */
public class Pega_ficha extends Thread{
    private ArrayList<Ficha> fichas_r;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Cliente jogador;
    private Socket conexao_cliente;
    int porta;
    String ip_cliente;
    private Ficha ficha;

    Pega_ficha(Socket conexao_cliente, ArrayList<Ficha> fichas_r){
        this.conexao_cliente = conexao_cliente;
        this.fichas_r = fichas_r;

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
    public void run(){

        while(true){
            try
            {
                ficha = (Ficha)in.readObject();
                for(int i = 0; i < fichas_r.size(); i++)
                {
                    if(fichas_r.get(i).getNome_jogador().equals(ficha.getNome_jogador()))
                        fichas_r.add(i, ficha);
                    else
                        fichas_r.add(ficha);
                }

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public Ficha envia_ficha(String Nome_jogador){
        for(int i = 0; i < fichas_r.size(); i++)
        {
            if(fichas_r.get(i).getNome_jogador().equals(Nome_jogador))
                return (fichas_r.get(i));
        }
        JOptionPane.showMessageDialog(null, "Ficha não encontrada");

        return (null);
    }
}