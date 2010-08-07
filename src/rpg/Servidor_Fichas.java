/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rpg;
import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author belimawr
 */
public class Servidor_Fichas extends Thread
{
    private ArrayList<String> jogadores;
    private ArrayList<Conexao_ficha> conexao_fichas;
    private ServerSocket server_fichas;

    public Servidor_Fichas (ArrayList<Conexao_ficha> conexao_fichas, ArrayList<String> jogadores, int porta)
    {
        try
        {
            server_fichas = new ServerSocket(porta + 1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        this.conexao_fichas = conexao_fichas;
        this.jogadores = jogadores;
    }

    public ArrayList<Conexao_ficha> getconexao_fichas()
    {
        return conexao_fichas;
    }

    public ArrayList<String> getJogadores()
    {
        return jogadores;
    }

    public void run()
    {
        Conexao_ficha cficha;
        Socket socket;

        try
        {
            socket = server_fichas.accept();
            cficha = new Conexao_ficha(socket, jogadores);
            cficha.start();
            conexao_fichas.add(cficha);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
