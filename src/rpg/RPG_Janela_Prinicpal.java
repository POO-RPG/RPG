/*
 * RPG_Janela_Prinicpal.java
 */
package rpg;

import java.io.IOException;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static java.lang.Math.*;

/**
 * The application's main frame.
 */
public class RPG_Janela_Prinicpal extends FrameView
{
        //Atribuos
        boolean mestrando = false;
        ArrayList<String> jogadores = new ArrayList<String>();
        ArrayList<Conexao_ficha> conexao_fichas;
        Cliente cliente;
        Servidor_Chat mestre;
        Servidor_Fichas mestre_ficha;

        //Auto explcativo
        private void Inicializa_componentes ()
        {
                lista_jogadores.setListData(jogadores.toArray());
                txt_chat.setEditable(false);
                bt_enviar.setEnabled(false);
                bt_limpar.setEnabled(false);
                bt_rolar_dados.setEnabled(false);
                bt_ve_ficha.setEnabled(false);
                bt_editar_ficha.setEnabled(false);
                bt_editar_ficha.setEnabled(false);

                jogadores = new ArrayList<String>();
                conexao_fichas = new ArrayList<Conexao_ficha>();
                RPG_globais.setLista_jogadores(lista_jogadores);               

        }

        public RPG_Janela_Prinicpal (SingleFrameApplication app)
        {
                super(app);

                initComponents();
                Inicializa_componentes();

                // status bar initialization - message timeout, idle icon and busy animation, etc
                ResourceMap resourceMap = getResourceMap();
                int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
                messageTimer = new Timer(messageTimeout, new ActionListener()
                {

                        public void actionPerformed (ActionEvent e)
                        {
                                statusMessageLabel.setText("");
                        }
                });
                messageTimer.setRepeats(false);
                int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
                for (int i = 0; i < busyIcons.length; i++)
                {
                        busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
                }
                busyIconTimer = new Timer(busyAnimationRate, new ActionListener()
                {

                        public void actionPerformed (ActionEvent e)
                        {
                                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
                        }
                });
                idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
                statusAnimationLabel.setIcon(idleIcon);
                progressBar.setVisible(false);

                // connecting action tasks to status bar via TaskMonitor
                TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
                taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener()
                {

                        public void propertyChange (java.beans.PropertyChangeEvent evt)
                        {
                                String propertyName = evt.getPropertyName();
                                if ("started".equals(propertyName))
                                {
                                        if (!busyIconTimer.isRunning())
                                        {
                                                statusAnimationLabel.setIcon(busyIcons[0]);
                                                busyIconIndex = 0;
                                                busyIconTimer.start();
                                        }
                                        progressBar.setVisible(true);
                                        progressBar.setIndeterminate(true);
                                }
                                else if ("done".equals(propertyName))
                                {
                                        busyIconTimer.stop();
                                        statusAnimationLabel.setIcon(idleIcon);
                                        progressBar.setVisible(false);
                                        progressBar.setValue(0);
                                }
                                else if ("message".equals(propertyName))
                                {
                                        String text = (String) (evt.getNewValue());
                                        statusMessageLabel.setText((text == null) ? "" : text);
                                        messageTimer.restart();
                                }
                                else if ("progress".equals(propertyName))
                                {
                                        int value = (Integer) (evt.getNewValue());
                                        progressBar.setVisible(true);
                                        progressBar.setIndeterminate(false);
                                        progressBar.setValue(value);
                                }
                        }
                });
        }

        @Action
        public void showAboutBox ()
        {
                if (aboutBox == null)
                {
                        JFrame mainFrame = RPG.getApplication().getMainFrame();
                        aboutBox = new RPGAboutBox(mainFrame);
                        aboutBox.setLocationRelativeTo(mainFrame);
                }
                RPG.getApplication().show(aboutBox);
        }

        /** This method is called from within the constructor to
         * initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                mainPanel = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                txt_chat = new javax.swing.JTextArea();
                txt_enviar = new javax.swing.JTextField();
                bt_enviar = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                lista_jogadores = new javax.swing.JList();
                jLabel1 = new javax.swing.JLabel();
                bt_rolar_dados = new javax.swing.JButton();
                jLabel2 = new javax.swing.JLabel();
                txt_modificador = new javax.swing.JTextField();
                jLabel3 = new javax.swing.JLabel();
                txt_num_dados = new javax.swing.JTextField();
                bt_limpar = new javax.swing.JButton();
                bt_ve_ficha = new javax.swing.JButton();
                bt_editar_ficha = new javax.swing.JButton();
                jLabel4 = new javax.swing.JLabel();
                menuBar = new javax.swing.JMenuBar();
                javax.swing.JMenu fileMenu = new javax.swing.JMenu();
                menu_metrar = new javax.swing.JMenuItem();
                menu_jogar = new javax.swing.JMenuItem();
                javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
                javax.swing.JMenu helpMenu = new javax.swing.JMenu();
                javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
                statusPanel = new javax.swing.JPanel();
                javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
                statusMessageLabel = new javax.swing.JLabel();
                statusAnimationLabel = new javax.swing.JLabel();
                progressBar = new javax.swing.JProgressBar();

                mainPanel.setName("mainPanel"); // NOI18N

                jScrollPane1.setName("jScrollPane1"); // NOI18N

                txt_chat.setColumns(20);
                txt_chat.setRows(5);
                txt_chat.setName("txt_chat"); // NOI18N
                jScrollPane1.setViewportView(txt_chat);

                org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(rpg.RPG.class).getContext().getResourceMap(RPG_Janela_Prinicpal.class);
                txt_enviar.setText(resourceMap.getString("txt_enviar.text")); // NOI18N
                txt_enviar.setName("txt_enviar"); // NOI18N
                txt_enviar.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyReleased(java.awt.event.KeyEvent evt) {
                                txt_enviarKeyReleased(evt);
                        }
                });

                javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(rpg.RPG.class).getContext().getActionMap(RPG_Janela_Prinicpal.class, this);
                bt_enviar.setAction(actionMap.get("bt_enviar")); // NOI18N
                bt_enviar.setText(resourceMap.getString("bt_enviar.text")); // NOI18N
                bt_enviar.setName("bt_enviar"); // NOI18N
                bt_enviar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                bt_enviarActionPerformed(evt);
                        }
                });

                jScrollPane2.setName("jScrollPane2"); // NOI18N

                lista_jogadores.setModel(new javax.swing.AbstractListModel() {
                        String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
                        public int getSize() { return strings.length; }
                        public Object getElementAt(int i) { return strings[i]; }
                });
                lista_jogadores.setName("lista_jogadores"); // NOI18N
                jScrollPane2.setViewportView(lista_jogadores);

                jLabel1.setName("jLabel1"); // NOI18N

                bt_rolar_dados.setAction(actionMap.get("bt_rolar_dado")); // NOI18N
                bt_rolar_dados.setText(resourceMap.getString("bt_rolar_dados.text")); // NOI18N
                bt_rolar_dados.setName("bt_rolar_dados"); // NOI18N

                jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
                jLabel2.setName("jLabel2"); // NOI18N

                txt_modificador.setText(resourceMap.getString("txt_modificador.text")); // NOI18N
                txt_modificador.setName("txt_modificador"); // NOI18N

                jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
                jLabel3.setName("jLabel3"); // NOI18N

                txt_num_dados.setText(resourceMap.getString("txt_num_dados.text")); // NOI18N
                txt_num_dados.setName("txt_num_dados"); // NOI18N

                bt_limpar.setAction(actionMap.get("bt_Limpar")); // NOI18N
                bt_limpar.setText(resourceMap.getString("bt_limpar.text")); // NOI18N
                bt_limpar.setName("bt_limpar"); // NOI18N

                bt_ve_ficha.setAction(actionMap.get("bt_ver_ficha")); // NOI18N
                bt_ve_ficha.setText(resourceMap.getString("bt_ve_ficha.text")); // NOI18N
                bt_ve_ficha.setName("bt_ve_ficha"); // NOI18N
                bt_ve_ficha.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                bt_ve_fichaActionPerformed(evt);
                        }
                });

                bt_editar_ficha.setAction(actionMap.get("bt_editar_ficha")); // NOI18N
                bt_editar_ficha.setText(resourceMap.getString("bt_editar_ficha.text")); // NOI18N
                bt_editar_ficha.setName("bt_editar_ficha"); // NOI18N

                jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
                jLabel4.setName("jLabel4"); // NOI18N

                javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
                mainPanel.setLayout(mainPanelLayout);
                mainPanelLayout.setHorizontalGroup(
                        mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addComponent(txt_enviar, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bt_enviar))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_modificador, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_num_dados, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                .addComponent(bt_rolar_dados)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bt_limpar))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                        .addComponent(bt_ve_ficha, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt_editar_ficha, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                                .addGap(468, 468, 468)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                mainPanelLayout.setVerticalGroup(
                        mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addComponent(jLabel1))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txt_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bt_enviar)
                                                        .addComponent(bt_ve_ficha))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(txt_modificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txt_num_dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bt_limpar)
                                                        .addComponent(bt_rolar_dados)
                                                        .addComponent(bt_editar_ficha))))
                                .addContainerGap(23, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addContainerGap(346, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addContainerGap())
                );

                menuBar.setName("menuBar"); // NOI18N

                fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
                fileMenu.setName("fileMenu"); // NOI18N

                menu_metrar.setAction(actionMap.get("mestrar")); // NOI18N
                menu_metrar.setText(resourceMap.getString("menu_metrar.text")); // NOI18N
                menu_metrar.setName("menu_metrar"); // NOI18N
                fileMenu.add(menu_metrar);

                menu_jogar.setAction(actionMap.get("jogar")); // NOI18N
                menu_jogar.setText(resourceMap.getString("menu_jogar.text")); // NOI18N
                menu_jogar.setName("menu_jogar"); // NOI18N
                fileMenu.add(menu_jogar);

                exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
                exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
                exitMenuItem.setName("exitMenuItem"); // NOI18N
                fileMenu.add(exitMenuItem);

                menuBar.add(fileMenu);

                helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
                helpMenu.setName("helpMenu"); // NOI18N

                aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
                aboutMenuItem.setText(resourceMap.getString("aboutMenuItem.text")); // NOI18N
                aboutMenuItem.setName("aboutMenuItem"); // NOI18N
                helpMenu.add(aboutMenuItem);

                menuBar.add(helpMenu);

                statusPanel.setName("statusPanel"); // NOI18N

                statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

                statusMessageLabel.setName("statusMessageLabel"); // NOI18N

                statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

                progressBar.setName("progressBar"); // NOI18N

                javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
                statusPanel.setLayout(statusPanelLayout);
                statusPanelLayout.setHorizontalGroup(
                        statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 1243, Short.MAX_VALUE)
                        .addGroup(statusPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(statusMessageLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1059, Short.MAX_VALUE)
                                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statusAnimationLabel)
                                .addContainerGap())
                );
                statusPanelLayout.setVerticalGroup(
                        statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(statusPanelLayout.createSequentialGroup()
                                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(statusMessageLabel)
                                        .addComponent(statusAnimationLabel)
                                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3))
                );

                setComponent(mainPanel);
                setMenuBar(menuBar);
                setStatusBar(statusPanel);
        }// </editor-fold>//GEN-END:initComponents

    private void txt_enviarKeyReleased (java.awt.event.KeyEvent evt)//GEN-FIRST:event_txt_enviarKeyReleased
    {//GEN-HEADEREND:event_txt_enviarKeyReleased
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
            {
                    bt_enviar();
            }
    }//GEN-LAST:event_txt_enviarKeyReleased

    private void bt_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_enviarActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_bt_enviarActionPerformed

    private void bt_ve_fichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ve_fichaActionPerformed
    }//GEN-LAST:event_bt_ve_fichaActionPerformed

        //Chamado quando o botão enviar é pressionado
        @Action
        public void bt_enviar ()
        {
                enviar(txt_enviar.getText());

                txt_enviar.setText("");
        }

        public void enviar (String s)
        {
                if (mestrando)
                {
                        mestre.Enviar_mensagem(s);
                }
                else
                {
                        cliente.Escrever_mensagem(s);
                }
        }

        //Chamado quando o botão rolar dado é pressionado
        @Action
        public void bt_rolar_dado ()
        {
                String s = "";
                try
                {
                        int dado, tot = 0, i, i_f = Integer.parseInt(txt_num_dados.getText());

                        if (!(i_f > 0))
                        {
                                JOptionPane.showMessageDialog(null, "Você só pode rolar um número maior que zero de dados!");
                                txt_modificador.setText("0");
                                txt_num_dados.setText("1");
                                return;
                        }


                        for (i = 0; i < i_f; i++)
                        {
                                dado = (int) (1 + (6 * random()));
                                dado += Integer.parseInt(txt_modificador.getText());
                                tot += dado;
                                if (mestrando)
                                {
                                        s += "\nO dado rolado por <Mestre> " + "foi: " + dado;
                                }
                                else
                                {
                                        s += "\nO dado rolado por <" + cliente.getNick() + "> " + "foi: " + dado;
                                }
                        }

                        if (mestrando)
                        {
                                s += "\nForam rolados " + i_f + " dados por " + "<Mestre>, com o modificador: " + Integer.parseInt(txt_modificador.getText()) + ". O total é: " + tot;
                        }
                        else
                        {
                                s += "\nForam rolados " + i_f + " dados por " + "<" + cliente.getNick() + ">, com o modificador: " + Integer.parseInt(txt_modificador.getText()) + ". O total é: " + tot;
                        }

                        enviar(s);
                }
                catch (NumberFormatException e)
                {
                        JOptionPane.showMessageDialog(null, "Digite números em \"Modificador\" e \"Número de dados\"");
                        txt_modificador.setText("0");
                        txt_num_dados.setText("1");
                }

        }

        //Chamado quando o botão limpar é pressionado
        @Action
        public void bt_Limpar ()
        {
                txt_chat.setText("");
                txt_enviar.setText("");
                txt_modificador.setText("0");
                txt_num_dados.setText("1");
        }

        //Chamado quando o botão ver ficha é presionado
        @Action
        public void bt_ver_ficha ()
        {
                JFrame jan;
                String jogador;
                Ficha f = RPG_globais.getMinha_ficha();
                jogador = (String) RPG_globais.getLista_jogadores().getSelectedValue();

                for (Ficha ff : RPG_globais.getfichas().values())
                {
                        if (jogador.equals(ff.getNome_jogador()))
                        {
                                f = ff;
                                break;
                        }
                }

                jan = new Frame_Ficha(f);
                jan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jan.setVisible(true);
        }

        //Chamado quando o botão travar todas as fichas é presionado
        @Action
        public void bt_travar_todas_fichas ()
        {
                String s;
                RPG_globais.Atualiza_lista_jogadores();
                s = String.format("\n\nMinha Ficha:\nNome: %s Personagem: %s\n\n", RPG_globais.getMinha_ficha().getNome_jogador(), RPG_globais.getMinha_ficha().getNome_personagem());
                for (Ficha f : RPG_globais.getfichas().values())
                {
                        s += String.format("Nome: |%s| Personagem: |%s|\n", f.getNome_jogador(), f.getNome_personagem());
                }

                JOptionPane.showMessageDialog(null, s);
        }

        //Método para colocar uma string no final de um vetor de strings
        public String[] concatena (String[] v, String s)
        {
                String[] vv = new String[v.length + 1];
                int i;
                for (i = 0; i < v.length; i++)
                {
                        vv[i] = v[i];
                }
                vv[i] = s;

                return vv;
        }

        //Método responsável por iniciar o servidor
        @Action
        public void mestrar ()
        {
                RPG_globais.setMinha_ficha(new Ficha("Mestre", "NPC"));
                try
                {
                        mestrando = true;
                        int porta;
                        while (true)
                        {
                                try
                                {
                                        porta = Integer.parseInt(JOptionPane.showInputDialog("Digite a porta:", "2010"));
                                        if (porta < 1)
                                        {
                                                JOptionPane.showMessageDialog(null, "A porta deve ser um número inteiro e positivo!");
                                        }
                                        else
                                        {
                                                break;
                                        }
                                }
                                catch (NumberFormatException e)
                                {
                                        JOptionPane.showMessageDialog(null, "A porta deve ser um número inteiro e positivo!");
					mestrando = false;
					return;
                                }
                        }
                        mestre = new Servidor_Chat(porta, txt_chat);

                        menu_jogar.setEnabled(false);
                        menu_metrar.setEnabled(false);

                        mestre.start();
                        mestre_ficha = new Servidor_Fichas(conexao_fichas, jogadores, porta);
                        mestre_ficha.start();
                        //Torna os botões clicáveis
                        bt_enviar.setEnabled(true);
                        bt_limpar.setEnabled(true);
                        bt_rolar_dados.setEnabled(true);
                        bt_ve_ficha.setEnabled(true);
                        bt_editar_ficha.setEnabled(true);
                        bt_editar_ficha.setEnabled(true);
                }
                catch (IOException ex)
                {
                        ex.printStackTrace();
                }
        }

        //Método responsável por iniciar o modo jogador
        @Action
        public void jogar ()
        {
		try
		{
			cliente = new Cliente(txt_chat);
		}
		catch(Exception e)
		{
			return;
		}
                menu_metrar.setEnabled(false);
                menu_jogar.setEnabled(false);

                //Torna os botões clicáveis
                bt_enviar.setEnabled(true);
                bt_limpar.setEnabled(true);
                bt_rolar_dados.setEnabled(true);
                bt_ve_ficha.setEnabled(true);
                bt_editar_ficha.setEnabled(true);
                bt_editar_ficha.setEnabled(true);
        }

        @Action
        public void bt_editar_ficha ()
        {
                JFrame jan;
                if (mestrando)
                {
                        jan = new Frame_Ficha(RPG_globais.getMinha_ficha(), mestre_ficha);
                }
                else
                {
                        jan = new Frame_Ficha(RPG_globais.getMinha_ficha(), cliente.getConecxao_ficha());
                }

                jan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jan.setVisible(true);
        }
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton bt_editar_ficha;
        private javax.swing.JButton bt_enviar;
        private javax.swing.JButton bt_limpar;
        private javax.swing.JButton bt_rolar_dados;
        private javax.swing.JButton bt_ve_ficha;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JList lista_jogadores;
        private javax.swing.JPanel mainPanel;
        private javax.swing.JMenuBar menuBar;
        private javax.swing.JMenuItem menu_jogar;
        private javax.swing.JMenuItem menu_metrar;
        private javax.swing.JProgressBar progressBar;
        private javax.swing.JLabel statusAnimationLabel;
        private javax.swing.JLabel statusMessageLabel;
        private javax.swing.JPanel statusPanel;
        private javax.swing.JTextArea txt_chat;
        private javax.swing.JTextField txt_enviar;
        private javax.swing.JTextField txt_modificador;
        private javax.swing.JTextField txt_num_dados;
        // End of variables declaration//GEN-END:variables
        private final Timer messageTimer;
        private final Timer busyIconTimer;
        private final Icon idleIcon;
        private final Icon[] busyIcons = new Icon[15];
        private int busyIconIndex = 0;
        private JDialog aboutBox;
}
