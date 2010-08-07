package rpg;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.net.*;
/**
 *
 * @author HP
 */
public class Conexao_ficha extends Thread implements Envia_ficha
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

    public void Envia_ficha(Ficha ficha)
    {
            try
            {
                out.writeObject(ficha);
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
            boolean ok = true;
            boolean adicionado;

        while(ok)
        {
            adicionado = false;
            try
            {
                ficha = (Ficha)in.readObject();
                System.out.println( "Ficha recebida " + ficha.getNome_personagem());
                
                if(fichas_r.isEmpty())
                {
                        fichas_r.add(ficha);
                        adicionado = true;
                        jogadores.add(ficha.getNome_jogador());
                        RPG_globais.getLista_jogadores().setListData(jogadores.toArray());
                }
                else
                {
                        
                        for(int i = 0; i < fichas_r.size(); i++)
                        {
                            //Se já existir esse personagem, a ficha existente é sobrescrita
                            if(fichas_r.get(i).getNome_personagem().equals(ficha.getNome_personagem()))
                            {
                                fichas_r.add(i, ficha);
                                adicionado = true;
                                break;
                            }
                        }
                        if (adicionado == false)
                        {
                               int size = fichas_r.size();
                               fichas_r.add(size-1,ficha);
                               jogadores.add(ficha.getNome_personagem());
                               adicionado = true;

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

                catch(Exception e)
                {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Deu erro na thread de recebimento de fichas");
                    ok = false;
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