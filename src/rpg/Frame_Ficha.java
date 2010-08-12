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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;

public class Frame_Ficha extends javax.swing.JFrame {

	Ficha ficha;
	Envia_ficha envia_ficha;
	boolean travada;

	/** Creates new form Frame_Ficha
	public Frame_Ficha() {
	travada = false;
	String nada[] = new String[0];
	ficha = new Ficha();
	initComponents();
	List_Vantagens.setListData(nada);
	List_Desvantagens.setListData(nada);
	List_Itens.setListData(nada);
	List_Magias.setListData(nada);
	txt_A.setText("");
	txt_Agua.setText("");
	txt_Ar.setText("");
	txt_Experiencia.setText("");
	txt_Dinheiro.setText(null);
	txt_F.setText("");
	txt_Fogo.setText("");
	txt_Forca.setText(null);
	txt_H.setText(null);
	txt_Jogador.setText(null);
	txt_Luz.setText(null);
	txt_PM.setText(null);
	txt_PV.setText(null);
	txt_PdF.setText(null);
	txt_Personagem.setText(null);
	txt_PoderDeFogo.setText(null);
	txt_R.setText(null);
	txt_Terra.setText(null);
	txt_Trevas.setText(null);
	txt_area_Historia.setText(null);

	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	 * }
	 * @param ficha
	 */
	public Frame_Ficha(Ficha ficha) {
		travada = false;
		this.ficha = ficha;
		initComponents();
		List_Vantagens.setListData(ficha.getVantagens());
		List_Desvantagens.setListData(ficha.getDesvantagens());
		List_Itens.setListData(ficha.getItens());
		List_Magias.setListData(ficha.getMagias());
		txt_A.setText(Integer.toString(ficha.getA()));
		txt_Agua.setText(Integer.toString(ficha.getAgua()));
		txt_Ar.setText(Integer.toString(ficha.getAr()));
		txt_Experiencia.setText(Integer.toString(ficha.getExperiencia()));
		txt_Dinheiro.setText(Double.toString(ficha.getDinheiro()));
		txt_F.setText(Integer.toString(ficha.getF()));
		txt_Fogo.setText(Integer.toString(ficha.getFogo()));
		txt_Forca.setText(ficha.getTD_Forca());
		txt_H.setText(Integer.toString(ficha.getH()));
		txt_Jogador.setText(ficha.getNome_jogador());
		txt_Luz.setText(Integer.toString(ficha.getLuz()));
		txt_PM.setText(Integer.toString(ficha.getPM()));
		txt_PV.setText(Integer.toString(ficha.getPV()));
		txt_PdF.setText(Integer.toString(ficha.getPdF()));
		txt_Personagem.setText(ficha.getNome_personagem());
		txt_PoderDeFogo.setText(ficha.getTD_PdF());
		txt_R.setText(Integer.toString(ficha.getR()));
		txt_Terra.setText(Integer.toString(ficha.getTerra()));
		txt_Trevas.setText(Integer.toString(ficha.getTrevas()));
		txt_area_Historia.setText(ficha.getHistoria());

		BT_Atualiza_Ficha.setEnabled(false);
		BT_Limpa_Ficha.setEnabled(false);
		txt_Jogador.setEnabled(false);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	//Construtor II
	Frame_Ficha(Ficha ficha, Envia_ficha envia_ficha) {
		this.envia_ficha = envia_ficha;
		travada = false;
		this.ficha = ficha;
		initComponents();
		List_Vantagens.setListData(ficha.getVantagens());
		List_Desvantagens.setListData(ficha.getDesvantagens());
		List_Itens.setListData(ficha.getItens());
		List_Magias.setListData(ficha.getMagias());
		txt_A.setText(Integer.toString(ficha.getA()));
		txt_Agua.setText(Integer.toString(ficha.getAgua()));
		txt_Ar.setText(Integer.toString(ficha.getAr()));
		txt_Experiencia.setText(Integer.toString(ficha.getExperiencia()));
		txt_Dinheiro.setText(Double.toString(ficha.getDinheiro()));
		txt_F.setText(Integer.toString(ficha.getF()));
		txt_Fogo.setText(Integer.toString(ficha.getFogo()));
		txt_Forca.setText(ficha.getTD_Forca());
		txt_H.setText(Integer.toString(ficha.getH()));
		txt_Jogador.setText(ficha.getNome_jogador());
		txt_Luz.setText(Integer.toString(ficha.getLuz()));
		txt_PM.setText(Integer.toString(ficha.getPM()));
		txt_PV.setText(Integer.toString(ficha.getPV()));
		txt_PdF.setText(Integer.toString(ficha.getPdF()));
		txt_Personagem.setText(ficha.getNome_personagem());
		txt_PoderDeFogo.setText(ficha.getTD_PdF());
		txt_R.setText(Integer.toString(ficha.getR()));
		txt_Terra.setText(Integer.toString(ficha.getTerra()));
		txt_Trevas.setText(Integer.toString(ficha.getTrevas()));
		txt_area_Historia.setText(ficha.getHistoria());

		txt_Jogador.setEnabled(false);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                txt_Jogador = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                txt_Personagem = new javax.swing.JTextField();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                jLabel7 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                jLabel10 = new javax.swing.JLabel();
                txt_F = new javax.swing.JTextField();
                txt_H = new javax.swing.JTextField();
                txt_R = new javax.swing.JTextField();
                txt_A = new javax.swing.JTextField();
                txt_PdF = new javax.swing.JTextField();
                txt_PV = new javax.swing.JTextField();
                txt_PM = new javax.swing.JTextField();
                jLabel11 = new javax.swing.JLabel();
                jLabel12 = new javax.swing.JLabel();
                jLabel13 = new javax.swing.JLabel();
                txt_PoderDeFogo = new javax.swing.JTextField();
                txt_Forca = new javax.swing.JTextField();
                jLabel14 = new javax.swing.JLabel();
                jLabel15 = new javax.swing.JLabel();
                jLabel16 = new javax.swing.JLabel();
                jLabel17 = new javax.swing.JLabel();
                jLabel18 = new javax.swing.JLabel();
                jLabel19 = new javax.swing.JLabel();
                jLabel20 = new javax.swing.JLabel();
                txt_Trevas = new javax.swing.JTextField();
                txt_Luz = new javax.swing.JTextField();
                txt_Terra = new javax.swing.JTextField();
                txt_Fogo = new javax.swing.JTextField();
                txt_Ar = new javax.swing.JTextField();
                txt_Agua = new javax.swing.JTextField();
                jLabel21 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                List_Vantagens = new javax.swing.JList();
                jLabel22 = new javax.swing.JLabel();
                jScrollPane2 = new javax.swing.JScrollPane();
                List_Desvantagens = new javax.swing.JList();
                BT_Add_Vantagem = new javax.swing.JButton();
                BT_Add_Desvantagem = new javax.swing.JButton();
                jLabel23 = new javax.swing.JLabel();
                jScrollPane3 = new javax.swing.JScrollPane();
                List_Magias = new javax.swing.JList();
                jButton3 = new javax.swing.JButton();
                jScrollPane4 = new javax.swing.JScrollPane();
                List_Itens = new javax.swing.JList();
                BT_Add_Item = new javax.swing.JButton();
                jLabel24 = new javax.swing.JLabel();
                jScrollPane5 = new javax.swing.JScrollPane();
                txt_area_Historia = new javax.swing.JTextArea();
                jLabel25 = new javax.swing.JLabel();
                jLabel26 = new javax.swing.JLabel();
                txt_Dinheiro = new javax.swing.JTextField();
                jLabel27 = new javax.swing.JLabel();
                txt_Experiencia = new javax.swing.JTextField();
                BT_Atualiza_Ficha = new javax.swing.JButton();
                BT_Rm_Vantegem = new javax.swing.JButton();
                BT_Rm_Desvantagem = new javax.swing.JButton();
                BT_Rm_Magia = new javax.swing.JButton();
                BT_Rm_Item = new javax.swing.JButton();
                BT_Limpa_Ficha = new javax.swing.JButton();
                BT_Abre_Ficha = new javax.swing.JButton();
                BT_Salva_Ficha = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(rpg.RPG.class).getContext().getResourceMap(Frame_Ficha.class);
                setTitle(resourceMap.getString("Form.title")); // NOI18N
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                setName("Form"); // NOI18N
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosed(java.awt.event.WindowEvent evt) {
                                formWindowClosed(evt);
                        }
                        public void windowClosing(java.awt.event.WindowEvent evt) {
                                formWindowClosing(evt);
                        }
                });

                jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
                jLabel1.setName("jLabel1"); // NOI18N

                txt_Jogador.setText(resourceMap.getString("txt_Jogador.text")); // NOI18N
                txt_Jogador.setName("txt_Jogador"); // NOI18N
                txt_Jogador.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_JogadorActionPerformed(evt);
                        }
                });

                jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
                jLabel2.setName("jLabel2"); // NOI18N

                jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
                jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
                jLabel3.setName("jLabel3"); // NOI18N

                txt_Personagem.setText(resourceMap.getString("txt_Personagem.text")); // NOI18N
                txt_Personagem.setName("txt_Personagem"); // NOI18N
                txt_Personagem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_PersonagemActionPerformed(evt);
                        }
                });

                jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
                jLabel4.setName("jLabel4"); // NOI18N

                jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
                jLabel5.setName("jLabel5"); // NOI18N

                jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
                jLabel6.setName("jLabel6"); // NOI18N

                jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
                jLabel7.setName("jLabel7"); // NOI18N

                jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
                jLabel8.setName("jLabel8"); // NOI18N

                jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
                jLabel9.setName("jLabel9"); // NOI18N

                jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
                jLabel10.setName("jLabel10"); // NOI18N

                txt_F.setText(resourceMap.getString("txt_F.text")); // NOI18N
                txt_F.setName("txt_F"); // NOI18N
                txt_F.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_FActionPerformed(evt);
                        }
                });

                txt_H.setText(resourceMap.getString("txt_H.text")); // NOI18N
                txt_H.setName("txt_H"); // NOI18N
                txt_H.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_HActionPerformed(evt);
                        }
                });

                txt_R.setText(resourceMap.getString("txt_R.text")); // NOI18N
                txt_R.setName("txt_R"); // NOI18N
                txt_R.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_RActionPerformed(evt);
                        }
                });

                txt_A.setText(resourceMap.getString("txt_A.text")); // NOI18N
                txt_A.setName("txt_A"); // NOI18N
                txt_A.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_AActionPerformed(evt);
                        }
                });

                txt_PdF.setText(resourceMap.getString("txt_PdF.text")); // NOI18N
                txt_PdF.setName("txt_PdF"); // NOI18N
                txt_PdF.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_PdFActionPerformed(evt);
                        }
                });

                txt_PV.setText(resourceMap.getString("txt_PV.text")); // NOI18N
                txt_PV.setName("txt_PV"); // NOI18N
                txt_PV.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_PVActionPerformed(evt);
                        }
                });

                txt_PM.setText(resourceMap.getString("txt_PM.text")); // NOI18N
                txt_PM.setName("txt_PM"); // NOI18N
                txt_PM.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_PMActionPerformed(evt);
                        }
                });

                jLabel11.setFont(resourceMap.getFont("jLabel11.font")); // NOI18N
                jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
                jLabel11.setName("jLabel11"); // NOI18N

                jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
                jLabel12.setName("jLabel12"); // NOI18N

                jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
                jLabel13.setName("jLabel13"); // NOI18N

                txt_PoderDeFogo.setText(resourceMap.getString("txt_PoderDeFogo.text")); // NOI18N
                txt_PoderDeFogo.setName("txt_PoderDeFogo"); // NOI18N

                txt_Forca.setText(resourceMap.getString("txt_Forca.text")); // NOI18N
                txt_Forca.setName("txt_Forca"); // NOI18N

                jLabel14.setFont(resourceMap.getFont("jLabel14.font")); // NOI18N
                jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
                jLabel14.setName("jLabel14"); // NOI18N

                jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
                jLabel15.setName("jLabel15"); // NOI18N

                jLabel16.setText(resourceMap.getString("jLabel16.text")); // NOI18N
                jLabel16.setName("jLabel16"); // NOI18N

                jLabel17.setText(resourceMap.getString("jLabel17.text")); // NOI18N
                jLabel17.setName("jLabel17"); // NOI18N

                jLabel18.setText(resourceMap.getString("jLabel18.text")); // NOI18N
                jLabel18.setName("jLabel18"); // NOI18N

                jLabel19.setText(resourceMap.getString("jLabel19.text")); // NOI18N
                jLabel19.setName("jLabel19"); // NOI18N

                jLabel20.setText(resourceMap.getString("jLabel20.text")); // NOI18N
                jLabel20.setName("jLabel20"); // NOI18N

                txt_Trevas.setText(resourceMap.getString("txt_Trevas.text")); // NOI18N
                txt_Trevas.setName("txt_Trevas"); // NOI18N
                txt_Trevas.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_TrevasActionPerformed(evt);
                        }
                });

                txt_Luz.setText(resourceMap.getString("txt_Luz.text")); // NOI18N
                txt_Luz.setName("txt_Luz"); // NOI18N
                txt_Luz.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_LuzActionPerformed(evt);
                        }
                });

                txt_Terra.setText(resourceMap.getString("txt_Terra.text")); // NOI18N
                txt_Terra.setName("txt_Terra"); // NOI18N
                txt_Terra.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_TerraActionPerformed(evt);
                        }
                });

                txt_Fogo.setText(resourceMap.getString("txt_Fogo.text")); // NOI18N
                txt_Fogo.setName("txt_Fogo"); // NOI18N
                txt_Fogo.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_FogoActionPerformed(evt);
                        }
                });

                txt_Ar.setText(resourceMap.getString("txt_Ar.text")); // NOI18N
                txt_Ar.setName("txt_Ar"); // NOI18N
                txt_Ar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_ArActionPerformed(evt);
                        }
                });

                txt_Agua.setText(resourceMap.getString("txt_Agua.text")); // NOI18N
                txt_Agua.setName("txt_Agua"); // NOI18N
                txt_Agua.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txt_AguaActionPerformed(evt);
                        }
                });

                jLabel21.setFont(resourceMap.getFont("jLabel21.font")); // NOI18N
                jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel21.setText(resourceMap.getString("jLabel21.text")); // NOI18N
                jLabel21.setName("jLabel21"); // NOI18N

                jScrollPane1.setName("jScrollPane1"); // NOI18N

                List_Vantagens.setModel(new javax.swing.AbstractListModel() {
                        String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
                        public int getSize() { return strings.length; }
                        public Object getElementAt(int i) { return strings[i]; }
                });
                List_Vantagens.setName("List_Vantagens"); // NOI18N
                jScrollPane1.setViewportView(List_Vantagens);

                jLabel22.setFont(resourceMap.getFont("jLabel22.font")); // NOI18N
                jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel22.setText(resourceMap.getString("jLabel22.text")); // NOI18N
                jLabel22.setName("jLabel22"); // NOI18N

                jScrollPane2.setName("jScrollPane2"); // NOI18N

                List_Desvantagens.setModel(new javax.swing.AbstractListModel() {
                        String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
                        public int getSize() { return strings.length; }
                        public Object getElementAt(int i) { return strings[i]; }
                });
                List_Desvantagens.setName("List_Desvantagens"); // NOI18N
                jScrollPane2.setViewportView(List_Desvantagens);

                javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(rpg.RPG.class).getContext().getActionMap(Frame_Ficha.class, this);
                BT_Add_Vantagem.setAction(actionMap.get("BT_Add_VAntagem")); // NOI18N
                BT_Add_Vantagem.setText(resourceMap.getString("BT_Add_Vantagem.text")); // NOI18N
                BT_Add_Vantagem.setName("BT_Add_Vantagem"); // NOI18N

                BT_Add_Desvantagem.setAction(actionMap.get("BT_Add_Desvantagem")); // NOI18N
                BT_Add_Desvantagem.setText(resourceMap.getString("BT_Add_Desvantagem.text")); // NOI18N
                BT_Add_Desvantagem.setName("BT_Add_Desvantagem"); // NOI18N

                jLabel23.setFont(resourceMap.getFont("jLabel23.font")); // NOI18N
                jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel23.setText(resourceMap.getString("jLabel23.text")); // NOI18N
                jLabel23.setName("jLabel23"); // NOI18N

                jScrollPane3.setName("jScrollPane3"); // NOI18N

                List_Magias.setModel(new javax.swing.AbstractListModel() {
                        String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
                        public int getSize() { return strings.length; }
                        public Object getElementAt(int i) { return strings[i]; }
                });
                List_Magias.setName("List_Magias"); // NOI18N
                jScrollPane3.setViewportView(List_Magias);

                jButton3.setAction(actionMap.get("BT_Add_Magia")); // NOI18N
                jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
                jButton3.setName("jButton3"); // NOI18N

                jScrollPane4.setName("jScrollPane4"); // NOI18N

                List_Itens.setModel(new javax.swing.AbstractListModel() {
                        String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
                        public int getSize() { return strings.length; }
                        public Object getElementAt(int i) { return strings[i]; }
                });
                List_Itens.setName("List_Itens"); // NOI18N
                jScrollPane4.setViewportView(List_Itens);

                BT_Add_Item.setAction(actionMap.get("BT_Add_Item")); // NOI18N
                BT_Add_Item.setText(resourceMap.getString("BT_Add_Item.text")); // NOI18N
                BT_Add_Item.setName("BT_Add_Item"); // NOI18N

                jLabel24.setFont(resourceMap.getFont("jLabel24.font")); // NOI18N
                jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel24.setText(resourceMap.getString("jLabel24.text")); // NOI18N
                jLabel24.setName("jLabel24"); // NOI18N

                jScrollPane5.setName("jScrollPane5"); // NOI18N

                txt_area_Historia.setColumns(20);
                txt_area_Historia.setRows(5);
                txt_area_Historia.setName("txt_area_Historia"); // NOI18N
                jScrollPane5.setViewportView(txt_area_Historia);

                jLabel25.setFont(resourceMap.getFont("jLabel25.font")); // NOI18N
                jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel25.setText(resourceMap.getString("jLabel25.text")); // NOI18N
                jLabel25.setName("jLabel25"); // NOI18N

                jLabel26.setText(resourceMap.getString("jLabel26.text")); // NOI18N
                jLabel26.setName("jLabel26"); // NOI18N

                txt_Dinheiro.setText(resourceMap.getString("txt_Dinheiro.text")); // NOI18N
                txt_Dinheiro.setName("txt_Dinheiro"); // NOI18N

                jLabel27.setText(resourceMap.getString("jLabel27.text")); // NOI18N
                jLabel27.setName("jLabel27"); // NOI18N

                txt_Experiencia.setText(resourceMap.getString("txt_Experiencia.text")); // NOI18N
                txt_Experiencia.setName("txt_Experiencia"); // NOI18N

                BT_Atualiza_Ficha.setAction(actionMap.get("BT_AtualizaFicha")); // NOI18N
                BT_Atualiza_Ficha.setText(resourceMap.getString("BT_Atualiza_Ficha.text")); // NOI18N
                BT_Atualiza_Ficha.setName("BT_Atualiza_Ficha"); // NOI18N

                BT_Rm_Vantegem.setAction(actionMap.get("BT_Rm_Vantagem")); // NOI18N
                BT_Rm_Vantegem.setText(resourceMap.getString("BT_Rm_Vantegem.text")); // NOI18N
                BT_Rm_Vantegem.setName("BT_Rm_Vantegem"); // NOI18N

                BT_Rm_Desvantagem.setAction(actionMap.get("BT_Rm_Desvantagem")); // NOI18N
                BT_Rm_Desvantagem.setText(resourceMap.getString("BT_Rm_Desvantagem.text")); // NOI18N
                BT_Rm_Desvantagem.setName("BT_Rm_Desvantagem"); // NOI18N

                BT_Rm_Magia.setAction(actionMap.get("BT_Rm_Magia")); // NOI18N
                BT_Rm_Magia.setText(resourceMap.getString("BT_Rm_Magia.text")); // NOI18N
                BT_Rm_Magia.setName("BT_Rm_Magia"); // NOI18N

                BT_Rm_Item.setAction(actionMap.get("BT_Rm_Item")); // NOI18N
                BT_Rm_Item.setText(resourceMap.getString("BT_Rm_Item.text")); // NOI18N
                BT_Rm_Item.setName("BT_Rm_Item"); // NOI18N

                BT_Limpa_Ficha.setAction(actionMap.get("BT_Limpar_Ficha")); // NOI18N
                BT_Limpa_Ficha.setText(resourceMap.getString("BT_Limpa_Ficha.text")); // NOI18N
                BT_Limpa_Ficha.setName("BT_Limpa_Ficha"); // NOI18N

                BT_Abre_Ficha.setAction(actionMap.get("Abrir_Ficha")); // NOI18N
                BT_Abre_Ficha.setText(resourceMap.getString("BT_Abre_Ficha.text")); // NOI18N
                BT_Abre_Ficha.setName("BT_Abre_Ficha"); // NOI18N

                BT_Salva_Ficha.setAction(actionMap.get("Salvar_Ficha")); // NOI18N
                BT_Salva_Ficha.setText(resourceMap.getString("BT_Salva_Ficha.text")); // NOI18N
                BT_Salva_Ficha.setName("BT_Salva_Ficha"); // NOI18N

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(8, 8, 8)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(BT_Rm_Desvantagem, 0, 0, Short.MAX_VALUE)
                                                                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(BT_Add_Desvantagem, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(27, 27, 27)
                                                                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(39, 39, 39)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(BT_Atualiza_Ficha, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(BT_Abre_Ficha, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel1)
                                                                                        .addComponent(jLabel2))
                                                                                .addGap(7, 7, 7)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(txt_Personagem, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(txt_Jogador, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(jLabel9)
                                                                                                        .addComponent(jLabel10)
                                                                                                        .addComponent(jLabel8)
                                                                                                        .addComponent(jLabel7)
                                                                                                        .addComponent(jLabel6)
                                                                                                        .addComponent(jLabel5)
                                                                                                        .addComponent(jLabel4))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                        .addComponent(txt_PM, 0, 0, Short.MAX_VALUE)
                                                                                                        .addComponent(txt_PV, 0, 0, Short.MAX_VALUE)
                                                                                                        .addComponent(txt_PdF, 0, 0, Short.MAX_VALUE)
                                                                                                        .addComponent(txt_A, 0, 0, Short.MAX_VALUE)
                                                                                                        .addComponent(txt_R, 0, 0, Short.MAX_VALUE)
                                                                                                        .addComponent(txt_H, 0, 0, Short.MAX_VALUE)
                                                                                                        .addComponent(txt_F, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(jLabel20)
                                                                                                        .addComponent(jLabel19)
                                                                                                        .addComponent(jLabel17)
                                                                                                        .addComponent(jLabel18)
                                                                                                        .addComponent(jLabel16)
                                                                                                        .addComponent(jLabel15))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(txt_Agua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(txt_Ar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(txt_Fogo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(txt_Luz, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(txt_Terra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(txt_Trevas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(38, 38, 38)))))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel12)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(BT_Rm_Magia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                                                                                        .addComponent(jLabel13))
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(36, 36, 36))
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                                .addComponent(txt_Forca, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(txt_PoderDeFogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                                                .addComponent(BT_Rm_Item, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                .addComponent(BT_Add_Item, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE))))
                                                                                .addGap(18, 18, 18))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(BT_Rm_Vantegem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(jLabel26)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txt_Dinheiro, 0, 0, Short.MAX_VALUE))
                                                        .addComponent(BT_Add_Vantagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel27)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_Experiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(BT_Limpa_Ficha, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BT_Salva_Ficha, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(txt_Jogador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(txt_Personagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel12)
                                                .addComponent(txt_Forca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_PoderDeFogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(txt_F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(txt_H, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(txt_R, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(txt_A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(txt_PdF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel9)
                                                                        .addComponent(txt_PV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel24)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(35, 35, 35))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel23)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jButton3)
                                                                        .addComponent(BT_Add_Item))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel10)
                                                                .addComponent(txt_PM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(BT_Rm_Magia)
                                                                .addComponent(BT_Rm_Item))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel15)
                                                        .addComponent(txt_Agua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel16)
                                                        .addComponent(txt_Ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel17)
                                                        .addComponent(txt_Fogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel18)
                                                        .addComponent(txt_Luz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel19)
                                                        .addComponent(txt_Terra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel20)
                                                        .addComponent(txt_Trevas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel22)
                                                        .addComponent(jLabel25))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel21)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(BT_Add_Vantagem)
                                                        .addComponent(BT_Add_Desvantagem))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BT_Rm_Vantegem)
                                        .addComponent(BT_Atualiza_Ficha)
                                        .addComponent(BT_Rm_Desvantagem)
                                        .addComponent(BT_Abre_Ficha))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(txt_Experiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel26))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel27)
                                                                .addComponent(txt_Dinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(BT_Limpa_Ficha)
                                                        .addComponent(BT_Salva_Ficha))))
                                .addContainerGap())
                );

                BT_Rm_Vantegem.getAccessibleContext().setAccessibleName(resourceMap.getString("jButton6.AccessibleContext.accessibleName")); // NOI18N

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void txt_JogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_JogadorActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_JogadorActionPerformed

    private void txt_PersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PersonagemActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_PersonagemActionPerformed

    private void txt_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_FActionPerformed

    private void txt_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_HActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_HActionPerformed

    private void txt_RActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_RActionPerformed

    private void txt_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_AActionPerformed

    private void txt_PdFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PdFActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_PdFActionPerformed

    private void txt_PVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PVActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_PVActionPerformed

    private void txt_PMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PMActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_PMActionPerformed

    private void txt_TrevasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TrevasActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_TrevasActionPerformed

    private void txt_LuzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_LuzActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_LuzActionPerformed

    private void txt_TerraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TerraActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_TerraActionPerformed

    private void txt_FogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FogoActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_FogoActionPerformed

    private void txt_ArActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ArActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_ArActionPerformed

    private void txt_AguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AguaActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_txt_AguaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
	    // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
	    //RPG_globais.setMinha_ficha(ficha);
	    //envia_ficha.Enviar_ficha(ficha);
    }//GEN-LAST:event_formWindowClosing
	/**
	 * @param args the command line arguments
	 */
	/*    public static void main(String args[]) {
	java.awt.EventQueue.invokeLater(new Runnable() {

	public void run() {
	new Frame_Ficha().setVisible(true);
	}
	});
	}*/
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton BT_Abre_Ficha;
        private javax.swing.JButton BT_Add_Desvantagem;
        private javax.swing.JButton BT_Add_Item;
        private javax.swing.JButton BT_Add_Vantagem;
        private javax.swing.JButton BT_Atualiza_Ficha;
        private javax.swing.JButton BT_Limpa_Ficha;
        private javax.swing.JButton BT_Rm_Desvantagem;
        private javax.swing.JButton BT_Rm_Item;
        private javax.swing.JButton BT_Rm_Magia;
        private javax.swing.JButton BT_Rm_Vantegem;
        private javax.swing.JButton BT_Salva_Ficha;
        private javax.swing.JList List_Desvantagens;
        private javax.swing.JList List_Itens;
        private javax.swing.JList List_Magias;
        private javax.swing.JList List_Vantagens;
        private javax.swing.JButton jButton3;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel13;
        private javax.swing.JLabel jLabel14;
        private javax.swing.JLabel jLabel15;
        private javax.swing.JLabel jLabel16;
        private javax.swing.JLabel jLabel17;
        private javax.swing.JLabel jLabel18;
        private javax.swing.JLabel jLabel19;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel20;
        private javax.swing.JLabel jLabel21;
        private javax.swing.JLabel jLabel22;
        private javax.swing.JLabel jLabel23;
        private javax.swing.JLabel jLabel24;
        private javax.swing.JLabel jLabel25;
        private javax.swing.JLabel jLabel26;
        private javax.swing.JLabel jLabel27;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JScrollPane jScrollPane4;
        private javax.swing.JScrollPane jScrollPane5;
        private javax.swing.JTextField txt_A;
        private javax.swing.JTextField txt_Agua;
        private javax.swing.JTextField txt_Ar;
        private javax.swing.JTextField txt_Dinheiro;
        private javax.swing.JTextField txt_Experiencia;
        private javax.swing.JTextField txt_F;
        private javax.swing.JTextField txt_Fogo;
        private javax.swing.JTextField txt_Forca;
        private javax.swing.JTextField txt_H;
        private javax.swing.JTextField txt_Jogador;
        private javax.swing.JTextField txt_Luz;
        private javax.swing.JTextField txt_PM;
        private javax.swing.JTextField txt_PV;
        private javax.swing.JTextField txt_PdF;
        private javax.swing.JTextField txt_Personagem;
        private javax.swing.JTextField txt_PoderDeFogo;
        private javax.swing.JTextField txt_R;
        private javax.swing.JTextField txt_Terra;
        private javax.swing.JTextField txt_Trevas;
        private javax.swing.JTextArea txt_area_Historia;
        // End of variables declaration//GEN-END:variables

	//Getters and setters
	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public String[] concatena(String[] v, String s) {
		String[] vv = new String[v.length + 1];
		int i;
		for (i = 0; i < v.length; i++) {
			vv[i] = v[i];
		}
		vv[i] = s;

		return vv;
	}

	public String[] remove_s_from_Svet(String[] sv, int i) {
		for (int j = i + 1; j < sv.length; j++) {
			sv[j - 1] = sv[j];
		}

		String[] nv = new String[sv.length - 1];
		for (int j = 0; j < nv.length; j++) {
			nv[j] = sv[j];
		}

		return nv;
	}

	@Action
	public void BT_AtualizaFicha() {
		try {
			ficha.setA(Integer.parseInt(txt_A.getText()));
			ficha.setAgua(Integer.parseInt(txt_Agua.getText()));
			ficha.setAr(Integer.parseInt(txt_Ar.getText()));
			ficha.setExperiencia(Integer.parseInt(txt_Experiencia.getText()));
			ficha.setDinheiro(Double.parseDouble(txt_Dinheiro.getText()));
			ficha.setF(Integer.parseInt(txt_F.getText()));
			ficha.setFogo(Integer.parseInt(txt_Fogo.getText()));
			ficha.setTD_Forca(txt_Forca.getText());
			ficha.setH(Integer.parseInt(txt_H.getText()));
			ficha.setNome_jogador(txt_Jogador.getText());
			ficha.setLuz(Integer.parseInt(txt_Luz.getText()));
			ficha.setPM(Integer.parseInt(txt_PM.getText()));
			ficha.setPV(Integer.parseInt(txt_PV.getText()));
			ficha.setPdF(Integer.parseInt(txt_PdF.getText()));
			ficha.setNome_personagem(txt_Personagem.getText());
			ficha.setTD_PdF(txt_PoderDeFogo.getText());
			ficha.setR(Integer.parseInt(txt_R.getText()));
			ficha.setTerra(Integer.parseInt(txt_Terra.getText()));
			ficha.setTrevas(Integer.parseInt(txt_Trevas.getText()));

			ficha.setNome_jogador(txt_Jogador.getText());
			ficha.setNome_personagem(txt_Personagem.getText());
			ficha.setTD_Forca(txt_Forca.getText());
			ficha.setTD_PdF(txt_PoderDeFogo.getText());
			ficha.setHistoria(txt_area_Historia.getText());

			RPG_globais.setMinha_ficha(ficha);
			envia_ficha.Enviar_ficha(ficha);

			JOptionPane.showMessageDialog(this, "Ficha Atualizada!");
		} catch (Erro_Ficha e) {
			JOptionPane.showMessageDialog(this, e);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, e);
		}

	}

	@Action
	public void BT_Add_VAntagem() {
		String v;
		String[] s = ficha.getVantagens();
		v = JOptionPane.showInputDialog("Digite a nova vantagem");
		s = concatena(s, v);
		ficha.setVantagens(s);
		List_Vantagens.setListData(s);
	}

	@Action
	public void BT_Rm_Vantagem() {
		int i = List_Vantagens.getSelectedIndex();
		String[] s = remove_s_from_Svet(ficha.getVantagens(), i);
		ficha.setVantagens(s);
		List_Vantagens.setListData(ficha.getVantagens());
	}

	@Action
	public void BT_Add_Desvantagem() {
		String v;
		String[] s = ficha.getDesvantagens();
		v = JOptionPane.showInputDialog("Digite a nova desvantagem");
		s = concatena(s, v);
		ficha.setDesvantagens(s);
		List_Desvantagens.setListData(s);
	}

	@Action
	public void BT_Rm_Desvantagem() {
		int i = List_Desvantagens.getSelectedIndex();
		String[] s = remove_s_from_Svet(ficha.getDesvantagens(), i);
		ficha.setDesvantagens(s);
		List_Desvantagens.setListData(ficha.getDesvantagens());
	}

	@Action
	public void BT_Add_Magia() {
		String v;
		String[] s = ficha.getMagias();
		v = JOptionPane.showInputDialog("Digite a nova magia");
		s = concatena(s, v);
		ficha.setMagias(s);
		List_Magias.setListData(s);
	}

	@Action
	public void BT_Rm_Magia() {
		int i = List_Magias.getSelectedIndex();
		String[] s = remove_s_from_Svet(ficha.getMagias(), i);
		ficha.setMagias(s);
		List_Magias.setListData(ficha.getMagias());
	}

	@Action
	public void BT_Add_Item() {
		String v;
		String[] s = ficha.getItens();
		v = JOptionPane.showInputDialog("Digite o novo item");
		s = concatena(s, v);
		ficha.setItens(s);
		List_Itens.setListData(s);
	}

	@Action
	public void BT_Rm_Item() {
		int i = List_Itens.getSelectedIndex();
		String[] s = remove_s_from_Svet(ficha.getItens(), i);
		ficha.setItens(s);
		List_Itens.setListData(ficha.getItens());
	}

	@Action
	public void BT_Limpar_Ficha() {
		String nada[] = new String[0];
		ficha = new Ficha();
		List_Vantagens.setListData(nada);
		List_Desvantagens.setListData(nada);
		List_Itens.setListData(nada);
		List_Magias.setListData(nada);
		txt_A.setText("");
		txt_Agua.setText("");
		txt_Ar.setText("");
		txt_Experiencia.setText("");
		txt_Dinheiro.setText(null);
		txt_F.setText("");
		txt_Fogo.setText("");
		txt_Forca.setText(null);
		txt_H.setText(null);
		txt_Jogador.setText(null);
		txt_Luz.setText(null);
		txt_PM.setText(null);
		txt_PV.setText(null);
		txt_PdF.setText(null);
		txt_Personagem.setText(null);
		txt_PoderDeFogo.setText(null);
		txt_R.setText(null);
		txt_Terra.setText(null);
		txt_Trevas.setText(null);
		txt_area_Historia.setText(null);
	}

	public void trava_ficha() {
		List_Vantagens.setEnabled(false);
		List_Desvantagens.setEnabled(false);
		List_Itens.setEnabled(false);
		List_Magias.setEnabled(false);
		txt_A.setEnabled(false);
		txt_Agua.setEnabled(false);
		txt_Ar.setEnabled(false);
		txt_Experiencia.setEnabled(false);
		txt_Dinheiro.setEnabled(false);
		txt_F.setEnabled(false);
		txt_Fogo.setEnabled(false);
		txt_Forca.setEnabled(false);
		txt_H.setEnabled(false);
		txt_Jogador.setEnabled(false);
		txt_Luz.setEnabled(false);
		txt_PM.setEnabled(false);
		txt_PV.setEnabled(false);
		txt_PdF.setEnabled(false);
		txt_Personagem.setEnabled(false);
		txt_PoderDeFogo.setEnabled(false);
		txt_R.setEnabled(false);
		txt_Terra.setEnabled(false);
		txt_Trevas.setEnabled(false);
		txt_area_Historia.setEnabled(false);
	}

	public void destrava_ficha() {
		List_Vantagens.setEnabled(true);
		List_Desvantagens.setEnabled(true);
		List_Itens.setEnabled(true);
		List_Magias.setEnabled(true);
		txt_A.setEnabled(true);
		txt_Agua.setEnabled(true);
		txt_Ar.setEnabled(true);
		txt_Experiencia.setEnabled(true);
		txt_Dinheiro.setEnabled(true);
		txt_F.setEnabled(true);
		txt_Fogo.setEnabled(true);
		txt_Forca.setEnabled(true);
		txt_H.setEnabled(true);
		txt_Jogador.setEnabled(true);
		txt_Luz.setEnabled(true);
		txt_PM.setEnabled(true);
		txt_PV.setEnabled(true);
		txt_PdF.setEnabled(true);
		txt_Personagem.setEnabled(true);
		txt_PoderDeFogo.setEnabled(true);
		txt_R.setEnabled(true);
		txt_Terra.setEnabled(true);
		txt_Trevas.setEnabled(true);
		txt_area_Historia.setEnabled(true);
	}

	@Action
	public void Salvar_Ficha() {
		try {
			String file = JOptionPane.showInputDialog("Informe o caminho onde a ficha será salva");
			FileOutputStream fs = new FileOutputStream(file);
			ObjectOutputStream save_obj = new ObjectOutputStream(fs);
			BT_AtualizaFicha();


			save_obj.writeObject(RPG_globais.getMinha_ficha());
			save_obj.close();

			JOptionPane.showMessageDialog(this, "Ficha Salva no arquivo \"ficha\"!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Falha ao salvar a ficha!");
			e.printStackTrace();
		}
	}

	@Action
	public void Abrir_Ficha() {
		Ficha f;
		try {
			String file = JOptionPane.showInputDialog("Qual o caminho para a ficha que desejas abrir?");
			FileInputStream fs = new FileInputStream(file);
			ObjectInputStream read_obj = new ObjectInputStream(fs);

			f = (Ficha) read_obj.readObject();
			read_obj.close();

			RPG_globais.setMinha_ficha(f);
			this.ficha = f;

			List_Vantagens.setListData(ficha.getVantagens());
			List_Desvantagens.setListData(ficha.getDesvantagens());
			List_Itens.setListData(ficha.getItens());
			List_Magias.setListData(ficha.getMagias());
			txt_A.setText(Integer.toString(ficha.getA()));
			txt_Agua.setText(Integer.toString(ficha.getAgua()));
			txt_Ar.setText(Integer.toString(ficha.getAr()));
			txt_Experiencia.setText(Integer.toString(ficha.getExperiencia()));
			txt_Dinheiro.setText(Double.toString(ficha.getDinheiro()));
			txt_F.setText(Integer.toString(ficha.getF()));
			txt_Fogo.setText(Integer.toString(ficha.getFogo()));
			txt_Forca.setText(ficha.getTD_Forca());
			txt_H.setText(Integer.toString(ficha.getH()));
			txt_Jogador.setText(ficha.getNome_jogador());
			txt_Luz.setText(Integer.toString(ficha.getLuz()));
			txt_PM.setText(Integer.toString(ficha.getPM()));
			txt_PV.setText(Integer.toString(ficha.getPV()));
			txt_PdF.setText(Integer.toString(ficha.getPdF()));
			txt_Personagem.setText(ficha.getNome_personagem());
			txt_PoderDeFogo.setText(ficha.getTD_PdF());
			txt_R.setText(Integer.toString(ficha.getR()));
			txt_Terra.setText(Integer.toString(ficha.getTerra()));
			txt_Trevas.setText(Integer.toString(ficha.getTrevas()));
			txt_area_Historia.setText(ficha.getHistoria());

			JOptionPane.showMessageDialog(this, "Ficha aberta!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Falha ao abrir a ficha!\nTalvez ela não exista!");
			e.printStackTrace();
		}
	}
}
