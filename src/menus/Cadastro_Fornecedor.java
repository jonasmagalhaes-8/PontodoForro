package menus;

import fornecedores_CRUD.Insert_fornecedor;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Cadastro_Fornecedor extends javax.swing.JFrame
{
    int checkin=0;
    
    public Cadastro_Fornecedor()
    {
        initComponents();

        Background_image tela_fornecedor = new Background_image
        ( new ImageIcon("src/imagens/visuais_fornecedor_1.png").getImage() );
        this.getContentPane().add(tela_fornecedor);
    }
    
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
        label_cnpj = new java.awt.Label();
        txt_cnpj = new java.awt.TextField();
        txt_cep = new java.awt.TextField();
        label_cep = new java.awt.Label();
        txt_localizacao = new java.awt.TextField();
        label_localizacao = new java.awt.Label();
        txt_num = new java.awt.TextField();
        label_num = new java.awt.Label();
        bt_voltar = new javax.swing.JButton();
        label_tel2 = new java.awt.Label();
        txt_tel2 = new java.awt.TextField();
        txt_inscricao = new java.awt.TextField();
        label_inscricao = new java.awt.Label();
        label_representante = new java.awt.Label();
        txt_nome_representante = new java.awt.TextField();
        label_email_representane = new java.awt.Label();
        txt_email_representante = new java.awt.TextField();
        label_tel1representante = new java.awt.Label();
        txt_tel1representante = new java.awt.TextField();
        label_tel2representante = new java.awt.Label();
        txt_tel2representante = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        label_nome.setBackground(new java.awt.Color(20, 22, 121));
        label_nome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_nome.setForeground(new java.awt.Color(255, 255, 255));
        label_nome.setText(" Nome:");

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

        bt_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/visuais_botao_cadastrar_fornecedor_1.gif"))); // NOI18N
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

        label_cnpj.setBackground(new java.awt.Color(20, 22, 121));
        label_cnpj.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_cnpj.setForeground(new java.awt.Color(255, 255, 255));
        label_cnpj.setText(" CNPJ:");

        txt_cnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cnpjActionPerformed(evt);
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

        label_localizacao.setBackground(new java.awt.Color(20, 22, 121));
        label_localizacao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label_localizacao.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_localizacao.setForeground(new java.awt.Color(255, 255, 255));
        label_localizacao.setText(" Localização:");

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

        txt_inscricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_inscricaoActionPerformed(evt);
            }
        });

        label_inscricao.setBackground(new java.awt.Color(20, 22, 121));
        label_inscricao.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_inscricao.setForeground(new java.awt.Color(255, 255, 255));
        label_inscricao.setText(" Inscrição:");

        label_representante.setBackground(new java.awt.Color(20, 22, 121));
        label_representante.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_representante.setForeground(new java.awt.Color(255, 255, 255));
        label_representante.setText(" Representante:");

        txt_nome_representante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nome_representanteActionPerformed(evt);
            }
        });

        label_email_representane.setBackground(new java.awt.Color(20, 22, 121));
        label_email_representane.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_email_representane.setForeground(new java.awt.Color(255, 255, 255));
        label_email_representane.setText(" E-mail:");

        txt_email_representante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_email_representanteActionPerformed(evt);
            }
        });

        label_tel1representante.setBackground(new java.awt.Color(20, 22, 121));
        label_tel1representante.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tel1representante.setForeground(new java.awt.Color(255, 255, 255));
        label_tel1representante.setText(" Telefone:");

        txt_tel1representante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel1representanteActionPerformed(evt);
            }
        });

        label_tel2representante.setBackground(new java.awt.Color(20, 22, 121));
        label_tel2representante.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tel2representante.setForeground(new java.awt.Color(255, 255, 255));
        label_tel2representante.setText(" Telefone 2:");

        txt_tel2representante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel2representanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_inscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txt_inscricao, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_rua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_bairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_tel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_localizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txt_localizacao, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_cnpj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label_cep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(label_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_tel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_cep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_num, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_cnpj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(bt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_representante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_tel1representante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_tel1representante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_nome_representante, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_tel2representante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_email_representane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_email_representante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tel2representante, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_localizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_localizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_num, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_inscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_inscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nome_representante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_representante, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email_representante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_email_representane, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_tel1representante, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel1representante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_tel2representante, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel2representante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(bt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
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
      Insert_fornecedor cadastro = new Insert_fornecedor(); //Cria um objeto da classe Insert_cliente para cadastro de um cliente
      //Passagem do conteúdo dos campos de texto para a classe de cadastro:
      cadastro.setNome_informado(txt_nome.getText()); 
      cadastro.setLocalizacao_informada(txt_localizacao.getText());
      cadastro.setrua_informada(txt_rua.getText());
      cadastro.setnumrua_informado(txt_num.getText());
      cadastro.setbairro_informado(txt_bairro.getText());
      cadastro.setcep_informado(txt_cep.getText());
      cadastro.setEmail_informado(txt_email.getText());
      cadastro.setTelefone1_informado(txt_tel1.getText());
      cadastro.setTelefone2_informado(txt_tel2.getText(),txt_tel1.getText());
      cadastro.setCNPJ_informado(txt_cnpj.getText());
      cadastro.setInscricao(txt_inscricao.getText());
      cadastro.setNome_Representante_informado(txt_nome_representante.getText()); 
      cadastro.setEmail_Representante_informado(txt_email_representante.getText());
      cadastro.setTelefone1_Representante_informado(txt_tel1representante.getText());
      cadastro.setTelefone2_Representante_informado(txt_tel2representante.getText());
      checkin = cadastro.getCheckin(); //Recebe o retorno da validação de cada campo (mais detalhe na classe Insert_cliente)
      if(checkin==15) //Se o contador for igual a 6 (isto é, todos os campos estiverem corretos), limpa-se os campos e finaliza o cadastro
      {
        cadastro.cadastro_banco(checkin); //Chamada do método que finaliza o cadastro
        txt_nome.setText("");
        txt_localizacao.setText("");
        txt_rua.setText("");
        txt_bairro.setText("");
        txt_cep.setText("");
        txt_email.setText("");
        txt_tel1.setText("");
        txt_tel2.setText("");
        txt_num.setText("");
        txt_cnpj.setText("");
        txt_inscricao.setText("");
        txt_nome_representante.setText("");
        txt_email_representante.setText("");
        txt_tel1representante.setText("");
        txt_tel2representante.setText("");
        checkin = cadastro.getCheckin();
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

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_voltarActionPerformed
    {//GEN-HEADEREND:event_bt_voltarActionPerformed
        Area_do_menu_vendas vendas = new Area_do_menu_vendas();
        this.dispose();
        vendas.tela_vendas();
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void txt_tel2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel2ActionPerformed
    {//GEN-HEADEREND:event_txt_tel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel2ActionPerformed

    private void txt_inscricaoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_inscricaoActionPerformed
    {//GEN-HEADEREND:event_txt_inscricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_inscricaoActionPerformed

    private void txt_nome_representanteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_nome_representanteActionPerformed
    {//GEN-HEADEREND:event_txt_nome_representanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nome_representanteActionPerformed

    private void txt_email_representanteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_email_representanteActionPerformed
    {//GEN-HEADEREND:event_txt_email_representanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email_representanteActionPerformed

    private void txt_tel1representanteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel1representanteActionPerformed
    {//GEN-HEADEREND:event_txt_tel1representanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel1representanteActionPerformed

    private void txt_tel2representanteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel2representanteActionPerformed
    {//GEN-HEADEREND:event_txt_tel2representanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel2representanteActionPerformed

    private void txt_cnpjActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_cnpjActionPerformed
    {//GEN-HEADEREND:event_txt_cnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cnpjActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Cadastro_Fornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cadastrar;
    private javax.swing.JButton bt_voltar;
    private java.awt.Label label_bairro;
    private java.awt.Label label_cep;
    private java.awt.Label label_cnpj;
    private java.awt.Label label_email;
    private java.awt.Label label_email_representane;
    private java.awt.Label label_inscricao;
    private java.awt.Label label_localizacao;
    private java.awt.Label label_nome;
    private java.awt.Label label_num;
    private java.awt.Label label_representante;
    private java.awt.Label label_rua;
    private java.awt.Label label_tel;
    private java.awt.Label label_tel1representante;
    private java.awt.Label label_tel2;
    private java.awt.Label label_tel2representante;
    private java.awt.TextField txt_bairro;
    private java.awt.TextField txt_cep;
    private java.awt.TextField txt_cnpj;
    private java.awt.TextField txt_email;
    private java.awt.TextField txt_email_representante;
    private java.awt.TextField txt_inscricao;
    private java.awt.TextField txt_localizacao;
    private java.awt.TextField txt_nome;
    private java.awt.TextField txt_nome_representante;
    private java.awt.TextField txt_num;
    private java.awt.TextField txt_rua;
    private java.awt.TextField txt_tel1;
    private java.awt.TextField txt_tel1representante;
    private java.awt.TextField txt_tel2;
    private java.awt.TextField txt_tel2representante;
    // End of variables declaration//GEN-END:variables
}
