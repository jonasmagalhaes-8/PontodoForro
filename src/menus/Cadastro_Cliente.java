package menus;

import clientes_CRUD.Insert_cliente;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Cadastro_Cliente extends javax.swing.JFrame
{
    int checkin=0;
    Insert_cliente cadastro = new Insert_cliente();
    public Cadastro_Cliente(int tipo)
    {
        initComponents();
        if(tipo==0)
        this.label_c.setText(" CPF:");
        else if(tipo==1)
        this.label_c.setText(" CNPJ:");  
        Background_image tela_cadastrar = new Background_image
        ( new ImageIcon("src/imagens/visuais_cadastro.png").getImage() );
        this.getContentPane().add(tela_cadastrar);
    }
    private Cadastro_Cliente()
    { throw new UnsupportedOperationException("Not supported yet."); }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nome = new java.awt.Label();
        txt_nome = new java.awt.TextField();
        label_rua = new java.awt.Label();
        txt_rua = new java.awt.TextField();
        txt_bairro = new java.awt.TextField();
        label_bairro = new java.awt.Label();
        label_email = new java.awt.Label();
        txt_email = new java.awt.TextField();
        bt_cadastrar = new javax.swing.JButton();
        txt_tel1 = new java.awt.TextField();
        label_tel = new java.awt.Label();
        label_c = new java.awt.Label();
        txt_c = new java.awt.TextField();
        txt_cep = new java.awt.TextField();
        label_cep = new java.awt.Label();
        txt_num = new java.awt.TextField();
        label_num = new java.awt.Label();
        bt_voltar = new javax.swing.JButton();
        label_tel2 = new java.awt.Label();
        txt_tel2 = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        label_nome.setBackground(new java.awt.Color(20, 22, 121));
        label_nome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_nome.setForeground(new java.awt.Color(255, 255, 255));
        label_nome.setText(" Nome:");

        txt_nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nomeFocusLost(evt);
            }
        });

        label_rua.setBackground(new java.awt.Color(20, 22, 121));
        label_rua.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_rua.setForeground(new java.awt.Color(255, 255, 255));
        label_rua.setText(" Rua:");

        txt_rua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ruaActionPerformed(evt);
            }
        });

        txt_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bairroActionPerformed(evt);
            }
        });

        label_bairro.setBackground(new java.awt.Color(20, 22, 121));
        label_bairro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_bairro.setForeground(new java.awt.Color(255, 255, 255));
        label_bairro.setText(" Bairro:");

        label_email.setBackground(new java.awt.Color(20, 22, 121));
        label_email.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_email.setForeground(new java.awt.Color(255, 255, 255));
        label_email.setText(" E-mail:");

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        bt_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/visuais_botao_cadastrar.gif"))); // NOI18N
        bt_cadastrar.setPreferredSize(new java.awt.Dimension(366, 116));
        bt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarActionPerformed(evt);
            }
        });

        txt_tel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel1ActionPerformed(evt);
            }
        });

        label_tel.setBackground(new java.awt.Color(20, 22, 121));
        label_tel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tel.setForeground(new java.awt.Color(255, 255, 255));
        label_tel.setText(" Telefone:");

        label_c.setBackground(new java.awt.Color(20, 22, 121));
        label_c.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_c.setForeground(new java.awt.Color(255, 255, 255));

        txt_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cActionPerformed(evt);
            }
        });
        txt_c.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cFocusLost(evt);
            }
        });

        txt_cep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cepActionPerformed(evt);
            }
        });

        label_cep.setBackground(new java.awt.Color(20, 22, 121));
        label_cep.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_cep.setForeground(new java.awt.Color(255, 255, 255));
        label_cep.setText(" CEP:");

        txt_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numActionPerformed(evt);
            }
        });

        label_num.setBackground(new java.awt.Color(20, 22, 121));
        label_num.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_num.setForeground(new java.awt.Color(255, 255, 255));
        label_num.setText(" Nº:");

        bt_voltar.setBackground(new java.awt.Color(20, 22, 121));
        bt_voltar.setForeground(java.awt.Color.yellow);
        bt_voltar.setText("Voltar");
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        label_tel2.setBackground(new java.awt.Color(20, 22, 121));
        label_tel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tel2.setForeground(new java.awt.Color(255, 255, 255));
        label_tel2.setText(" Telefone 2:");

        txt_tel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(txt_rua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_bairro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_cep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_cep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                    .addComponent(txt_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_num, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txt_tel2, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(bt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_rua, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_email, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_num, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_c, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(bt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(214, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(816, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ruaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_ruaActionPerformed
    {//GEN-HEADEREND:event_txt_ruaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ruaActionPerformed

    private void txt_bairroActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_bairroActionPerformed
    {//GEN-HEADEREND:event_txt_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bairroActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_emailActionPerformed
    {//GEN-HEADEREND:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void bt_cadastrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_cadastrarActionPerformed
    {//GEN-HEADEREND:event_bt_cadastrarActionPerformed
       //Cria um objeto da classe Insert_cliente para cadastro de um cliente
      //Passagem do conteúdo dos campos de texto para a classe de cadastro:
      cadastro.setNome_informado(txt_nome.getText()); 
      cadastro.setrua_informada(txt_rua.getText());
      cadastro.setnumrua_informado(txt_num.getText());
      cadastro.setbairro_informado(txt_bairro.getText());
      cadastro.setcep_informado(txt_cep.getText());
      cadastro.setEmail_informado(txt_email.getText());
      cadastro.setTelefone1_informado(txt_tel1.getText());
      cadastro.setTelefone2_informado(txt_tel2.getText(),txt_tel1.getText());
      cadastro.setCp(txt_c.getText());
      checkin = cadastro.getCheckin(); //Recebe o retorno da validação de cada campo (mais detalhe na classe Insert_cliente)
      if(checkin==9) //Se o contador for igual a 9 (isto é, todos os campos estiverem corretos), limpa-se os campos e finaliza o cadastro
      {
        cadastro.cadastro_banco(checkin); //Chamada do método que finaliza o cadastro
        txt_nome.setText("");
        txt_rua.setText("");
        txt_bairro.setText("");
        txt_cep.setText("");
        txt_email.setText("");
        txt_tel1.setText("");
        txt_tel2.setText("");
        txt_num.setText("");
        txt_c.setText("");
        checkin=0; //Zeragem da variável para evitar lixo de memória
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
      }
      else
      {
          JOptionPane.showMessageDialog(null, "Um ou mais dados informados estão inválidos!");
          checkin=0;
          cadastro.SetCheckin(0);
      }
      
    }//GEN-LAST:event_bt_cadastrarActionPerformed

    private void txt_tel1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel1ActionPerformed
    {//GEN-HEADEREND:event_txt_tel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel1ActionPerformed

    private void txt_cepActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_cepActionPerformed
    {//GEN-HEADEREND:event_txt_cepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cepActionPerformed

    private void txt_numActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_numActionPerformed
    {//GEN-HEADEREND:event_txt_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numActionPerformed

    private void txt_cActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_cActionPerformed
    {//GEN-HEADEREND:event_txt_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_voltarActionPerformed
    {//GEN-HEADEREND:event_bt_voltarActionPerformed
        Area_do_Cliente call = new Area_do_Cliente();
        call.area_clientes();
        this.dispose(); 
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void txt_tel2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel2ActionPerformed
    {//GEN-HEADEREND:event_txt_tel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel2ActionPerformed

    private void txt_nomeFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_txt_nomeFocusLost
    {//GEN-HEADEREND:event_txt_nomeFocusLost
       // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeFocusLost

    private void txt_nomeFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_txt_nomeFocusGained
    {//GEN-HEADEREND:event_txt_nomeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeFocusGained

    private void txt_cFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_txt_cFocusLost
    {//GEN-HEADEREND:event_txt_cFocusLost

    }//GEN-LAST:event_txt_cFocusLost

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Cadastro_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cadastrar;
    private javax.swing.JButton bt_voltar;
    private java.awt.Label label_bairro;
    private java.awt.Label label_c;
    private java.awt.Label label_cep;
    private java.awt.Label label_email;
    private java.awt.Label label_nome;
    private java.awt.Label label_num;
    private java.awt.Label label_rua;
    private java.awt.Label label_tel;
    private java.awt.Label label_tel2;
    private java.awt.TextField txt_bairro;
    private java.awt.TextField txt_c;
    private java.awt.TextField txt_cep;
    private java.awt.TextField txt_email;
    private java.awt.TextField txt_nome;
    private java.awt.TextField txt_num;
    private java.awt.TextField txt_rua;
    private java.awt.TextField txt_tel1;
    private java.awt.TextField txt_tel2;
    // End of variables declaration//GEN-END:variables
}
