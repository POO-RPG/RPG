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
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket conexao_cliente;

    Conexao_ficha(Socket conexao_cliente)
    {
        this.conexao_cliente = conexao_cliente;

        try
        {
            out = new ObjectOutputStream(conexao_cliente.getOutputStream());
            in = new ObjectInputStream(conexao_cliente.getInputStream());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void Envia_ficha(Ficha f)
    {
            try
            {
                out.writeObject(f);
            }
            catch(Exception e)
            {
                    e.printStackTrace();
                    System.exit(1);
            }
    }

    @Override
    public void run()
    {
            Ficha ficha;
            ArrayList<Ficha> fichas_r = RPG_globais.getfichas();
            ArrayList<String> jogadores = RPG_globais.getJogadores();

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

                        Collections.sort(jogadores, new Comparator()
                        {

                                                        public int compare (Object arg0, Object arg1)
                                                        {
                                                                String s1 = (String) arg0, s2 = (String) arg1;
                                                                return s1.compareTo(s2);
                                                        }
                        });

                        RPG_globais.getLista_jogadores().setListData(jogadores.toArray());
                    }
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Teste");
                //System.exit(1);
            }
            catch(ClassNotFoundException ce)
            {
                    ce.printStackTrace();
            }
        }
    }

    public Ficha get_ficha(String Nome_jogador)
    {
        for(int i = 0; i < RPG_globais.getfichas().size(); i++)
        {
            if(RPG_globais.getfichas().get(i).getNome_jogador().equals(Nome_jogador))
                return (RPG_globais.getfichas().get(i));
        }
        JOptionPane.showMessageDialog(null, "Ficha não encontrada");

        return (null);
    }
}