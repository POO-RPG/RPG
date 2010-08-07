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
    private Fila<Ficha> fila_ficha;
    Consumidor_Ficha consome_ficha;

    public Servidor_Fichas (ArrayList<Conexao_ficha> conexao_fichas, ArrayList<String> jogadores, int porta)
    {
                fila_ficha = new  Fila<Ficha>(100);
                consome_ficha = new Consumidor_Ficha(fila_ficha, conexao_fichas);
                consome_ficha.start();

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

    public void Enviar_ficha(Ficha f)
    {
                try
                {
                        fila_ficha.insere(f);
                }
                catch (InterruptedException ex)
                {
                        ex.printStackTrace();
                        System.exit(1);
                }
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

        while(true)
        {

                try
                {
                    socket = server_fichas.accept();
                    cficha = new Conexao_ficha(socket);
                    cficha.start();
                    conexao_fichas.add(cficha);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
        }
    }
}
