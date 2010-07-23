/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rpg;

import java.util.ArrayList;

/**
 *
 * @author fenix
 */
class Ficha
{
	protected String Nome_jogador, Nome_personagem;
	protected String TD_Forca, TD_PdF, Historia;
	protected ArrayList<String> Magias, Vantagens, Desvantagens;

    public ArrayList<String> getDesvantagens() {
        return Desvantagens;
    }

    public ArrayList<String> getMagias() {
        return Magias;
    }

    public ArrayList<String> getVantagens() {
        return Vantagens;
    }

	//Características
	protected int F, H, R, A, PdF, PV, PM;

    public int getA() {
        return A;
    }

    public int getAgua() {
        return Agua;
    }

    public int getAr() {
        return Ar;
    }

    public double getDinheiro() {
        return Dinheiro;
    }

    public int getExperiencia() {
        return Experiencia;
    }

    public int getF() {
        return F;
    }

    public int getFogo() {
        return Fogo;
    }

    public int getH() {
        return H;
    }

    public String getHistoria() {
        return Historia;
    }

    public int getLuz() {
        return Luz;
    }

    public String getNome_jogador() {
        return Nome_jogador;
    }

    public String getNome_personagem() {
        return Nome_personagem;
    }

    public int getPM() {
        return PM;
    }

    public int getPV() {
        return PV;
    }

    public int getPdF() {
        return PdF;
    }

    public int getR() {
        return R;
    }

    public String getTD_Forca() {
        return TD_Forca;
    }

    public String getTD_PdF() {
        return TD_PdF;
    }

    public int getTerra() {
        return Terra;
    }

    public int getTrevas() {
        return Trevas;
    }

	//Caminhos da Magia
	protected int Agua, Ar, Fogo, Luz, Terra, Trevas;

	protected int Experiencia;
	protected double Dinheiro;

        Ficha()
	{
                F = H = R =A = PdF = PV = PM = 0;
                Agua = Ar = Fogo = Luz = Terra = Trevas = 0;
                Dinheiro = Experiencia = 0;
	}

        Ficha(String Nome_jogador, String Nome_personagem)
	{
		this.Nome_jogador = Nome_jogador;
		this.Nome_personagem = Nome_personagem;

                F = H = R =A = PdF = PV = PM = 0;
                Agua = Ar = Fogo = Luz = Terra = Trevas = 0;
                Dinheiro = Experiencia = 0;
	}

	Ficha(String Nome_jogador, String Nome_personagem, String Historia)
	{

		this.Nome_jogador = Nome_jogador;
		this.Nome_personagem = Nome_personagem;
		this.Historia = Historia;

                F = H = R =A = PdF = PV = PM = 0;
                Agua = Ar = Fogo = Luz = Terra = Trevas = 0;
                Dinheiro = Experiencia = 0;
	}

	public void setF(int F) throws Erro_Ficha
	{
		if( F < 0 )
			throw new Erro_Ficha("Força não pode ser menor que zero");
		this.F = F;
	}

	public void setH(int H) throws Erro_Ficha
	{
		if( H < 0 )
			throw new Erro_Ficha("Habilidade não pode ser menor que zero");
		this.H = H;
	}

	public void setR(int R) throws Erro_Ficha
	{
		if ( R < 0 )
			throw new Erro_Ficha("Resistência não pode ser menor que zero");
		this.R = R;
	}

	public void setA(int A) throws Erro_Ficha
	{
		if ( A < 0 )
			throw new Erro_Ficha("Armadura não pode ser menor que zero");
		this.A = A;
	}

	public void setPdF(int PdF) throws Erro_Ficha
	{
		if ( PdF < 0 )
			throw new Erro_Ficha("Poder de Fogo não pode ser menor que zero");
		this.PdF = PdF;
	}

	public void setPV(int PV) throws Erro_Ficha
	{
		if ( PV < 0 )
			throw new Erro_Ficha("Pontos de Vida não podem ser menor que zero");
		this.PV = PV;
	}

	public void setPM(int PM) throws Erro_Ficha
	{
		if (PM < 0 )
			throw new Erro_Ficha("Pontos de Magia não podem ser menor que zero");
		this.PM = PM;
	}

	public void setDinheiro(double Dinheiro) throws Erro_Ficha
	{
		this.Dinheiro = Dinheiro;
	}

	public void setAgua(int Agua) throws Erro_Ficha
	{
		if ( Agua < 0 )
			throw new Erro_Ficha("O caminho da magia Agua não podem ser menor que zero");
		this.Agua = Agua;
	}

	public void setAr(int Ar) throws Erro_Ficha
	{
		if (Ar < 0 )
			throw new Erro_Ficha("O caminho da magia Ar não podem ser menor que zero");
		this.Ar = Ar;
	}

	public void setFogo(int Fogo) throws Erro_Ficha
	{
		if ( Fogo < 0 )
			throw new Erro_Ficha("O caminho da magia Fogo não podem ser menor que zero");
		this.Fogo = Fogo;
	}

	public void setLuz(int Luz) throws Erro_Ficha
	{
		if ( Luz < 0 )
			throw new Erro_Ficha("O caminho da magia Luz não podem ser menor que zero");
		this.Luz = Luz;
	}

	public void setTerra(int Terra) throws Erro_Ficha
	{
		if ( Terra < 0 )
			throw new Erro_Ficha("O caminho da magia Terra não podem ser menor que zero");
		this.Terra = Terra;
	}

	public void setTrevas(int Trevas) throws Erro_Ficha
	{
		if ( Terra < 0 )
			throw new Erro_Ficha("O caminho da magia Trevas não podem ser menor que zero");
		this.Trevas = Trevas;
	}

	public void setExperiencia(int Experiencia) throws Erro_Ficha
	{
		if ( Experiencia < 0 )
			throw new Erro_Ficha("Experiencia não podem ser menor que zero");
		this.Experiencia = Experiencia;
	}

}
