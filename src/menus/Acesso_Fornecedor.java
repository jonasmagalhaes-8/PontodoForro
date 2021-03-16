package menus;

import fornecedores_CRUD.Delete_fornecedor;
import fornecedores_CRUD.Update_fornecedor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import banco.ModuloConexao;

public class Acesso_Fornecedor extends javax.swing.JFrame
{
    int checkin=0,tipo_cliente;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int id=0,representante_id=0;
    String nome_atual,email_atual,cnpj_atual,rua_atual,num_atual,localizacao_atual,bairro_atual,cep_atual,telefone1_atual,telefone2_atual,inscricao_atual="",representante_telefone1_atual="",representante_email_atual="",representante_nome_atual="",representante_telefone2_atual="";
    
    public Acesso_Fornecedor textfields(String nome,String email,String cnpj,String rua,String num,String bairro,String cep,String telefone1,String telefone2,String inscricao,String localizacao,String representante_telefone1,String representante_telefone2,String representante_email,String representante_nome)
    {
        nome_atual = nome;
        email_atual = email;
        inscricao_atual = inscricao;
        cnpj_atual = cnpj;
        localizacao_atual = localizacao;
        rua_atual = rua;
        num_atual = num;
        bairro_atual = bairro;
        cep_atual = cep;
        telefone1_atual = telefone1;
        telefone2_atual = telefone2;
        representante_nome_atual = representante_nome;
        representante_email_atual = representante_email;
        representante_telefone1_atual = representante_telefone1;
        representante_telefone2_atual = representante_telefone2;
        this.txt_nome.setText(nome);
        this.txt_email.setText(email);
        this.txt_cnpj.setText(cnpj);
        this.txt_rua.setText(rua);
        this.txt_num.setText(num);
        this.txt_bairro.setText(bairro);
        this.txt_cep.setText(cep);
        this.txt_tel1.setText(telefone1);
        this.txt_tel2.setText(telefone2);
        this.txt_inscricao.setText(inscricao);
        this.txt_localizacao.setText(localizacao);
        this.txt_tel1representante.setText(representante_telefone1);
        this.txt_tel2representante.setText(representante_telefone2);
        this.txt_nome_representante.setText(representante_nome);
        this.txt_email_representante.setText(representante_email);
        return null;
    }
    
    public Acesso_Fornecedor()
    {
        initComponents();
        
        Icon icone_alterar = new ImageIcon("src/imagens/visuais_botao_alterar.gif");
        JButton bt_alterar = new JButton(icone_alterar);
        bt_alterar.setBounds(514, 112, 106, 46);

        Icon icone_excluir = new ImageIcon("src/imagens/visuais_botao_excluir.gif");
        JButton bt_excluir = new JButton(icone_excluir);
        bt_excluir.setBounds(651, 112, 106 , 46);

        JButton bt_tabela = new JButton("Exibir lista de Fornecedores"); 
        bt_tabela.setBounds(218, 450, 366 , 116);
        
        bt_voltar.setBackground(Color.decode("#141679"));
        bt_voltar.setForeground(Color.yellow);  

        this.getContentPane().add(bt_voltar);
        this.getContentPane().add(bt_alterar);
        this.getContentPane().add(bt_excluir);
        this.getContentPane().add(bt_tabela);
        
        Background_image tela_acessar = new Background_image
        ( new ImageIcon("src/imagens/visuais_acesso_fornecedores.png").getImage() );
        
        this.getContentPane().add(tela_acessar);
        
        bt_tabela.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent me)
          { 
            conexao = ModuloConexao.conector();
            
            Lista_Select_Fornecedor lista_fornecdores = new Lista_Select_Fornecedor();
            
            lista_fornecdores.setVisible(true);
            
            id = lista_fornecdores.id;
            representante_id = lista_fornecdores.representante_id;
            textfields(lista_fornecdores.nome,lista_fornecdores.email,lista_fornecdores.cnpj,lista_fornecdores.rua,lista_fornecdores.num,lista_fornecdores.bairro,lista_fornecdores.cep,lista_fornecdores.telefone1,lista_fornecdores.telefone2,lista_fornecdores.inscricao,lista_fornecdores.localizacao,lista_fornecdores.representante_telefone1,lista_fornecdores.representante_telefone2,lista_fornecdores.representante_email,lista_fornecdores.representante);
          }
        }
                                   );
        
        bt_alterar.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent me)
          { 
            if(id>0)
            {
              Update_fornecedor update = new Update_fornecedor();
              update.setId(Integer.toString(id));
              update.setId_representante(Integer.toString(representante_id));
              if(!nome_atual.equals(txt_nome.getText()))
              update.update_nome(txt_nome.getText());
              if(!email_atual.equals(txt_email.getText()))
              update.update_email(txt_email.getText());
              if(!cnpj_atual.equals(txt_cnpj.getText()))
              update.update_cnpj(txt_cnpj.getText());
              if(!rua_atual.equals(txt_rua.getText()))
              update.update_rua(txt_rua.getText());
              if(!localizacao_atual.equals(txt_localizacao.getText()))
              update.update_localizacao(txt_localizacao.getText());
              if(!inscricao_atual.equals(txt_inscricao.getText()))
              update.update_inscricao(txt_inscricao.getText());
              if(!num_atual.equals(txt_num.getText()))
              update.update_num(txt_num.getText());
              if(!bairro_atual.equals(txt_bairro.getText()))
              update.update_bairro(txt_bairro.getText());
              if(!cep_atual.equals(txt_cep.getText()))
              update.update_cep(txt_cep.getText());
              if(!telefone1_atual.equals(txt_tel1.getText()))
              update.update_telefone1(txt_tel1.getText());
              if(!telefone2_atual.equals(txt_tel2.getText()))
              update.update_telefone2(txt_tel2.getText());
              if(!representante_telefone1_atual.equals(txt_tel1representante.getText()))
              update.update_representante_telefone1(txt_tel1representante.getText());
              if(!representante_telefone2_atual.equals(txt_tel2representante.getText()))
              update.update_representante_telefone2(txt_tel2representante.getText());
              if(!representante_nome_atual.equals(txt_nome_representante.getText()))
              update.update_representante_nome(txt_nome_representante.getText());
              if(!representante_email_atual.equals(txt_email_representante.getText()))
              update.update_representante_email(txt_email_representante.getText());
              textfields("", "", "", "","", "", "", "", "","","","","","","");
            }
            else
            JOptionPane.showMessageDialog(null, "Favor pesquisar um usuário para realizar uma alteração!"); 
          }
         });
        
        bt_excluir.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent me)
          { 
            if(id>0)
            {
              Delete_fornecedor exclusao = new Delete_fornecedor();
              exclusao.setId(Integer.toString(id));
              int excluiu=exclusao.delete();
              
              if(excluiu==1)
              {
                JOptionPane.showMessageDialog(null, "Exclusão realizada!");
                textfields("", "", "", "","", "", "", "", "","","","","","","");
                id = 0;
              }
            }
            else
            JOptionPane.showMessageDialog(null, "Favor pesquisar um usuário para realizar uma alteração!");
            }
        }
        ); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_nome_representante = new java.awt.TextField();
        label_email_representane = new java.awt.Label();
        label_inscricao = new java.awt.Label();
        label_representante = new java.awt.Label();
        txt_tel2 = new java.awt.TextField();
        txt_inscricao = new java.awt.TextField();
        bt_voltar = new javax.swing.JButton();
        label_tel2 = new java.awt.Label();
        txt_email_representante = new java.awt.TextField();
        label_tel1representante = new java.awt.Label();
        label_num = new java.awt.Label();
        txt_num = new java.awt.TextField();
        label_localizacao = new java.awt.Label();
        txt_localizacao = new java.awt.TextField();
        label_cep = new java.awt.Label();
        txt_cep = new java.awt.TextField();
        txt_cnpj = new java.awt.TextField();
        label_cnpj = new java.awt.Label();
        label_tel = new java.awt.Label();
        txt_tel1 = new java.awt.TextField();
        txt_email = new java.awt.TextField();
        label_email = new java.awt.Label();
        label_bairro = new java.awt.Label();
        txt_bairro = new java.awt.TextField();
        label_tel2representante = new java.awt.Label();
        txt_rua = new java.awt.TextField();
        txt_tel2representante = new java.awt.TextField();
        label_rua = new java.awt.Label();
        txt_nome = new java.awt.TextField();
        label_nome = new java.awt.Label();
        txt_tel1representante = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txt_nome_representante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nome_representanteActionPerformed(evt);
            }
        });

        label_email_representane.setBackground(new java.awt.Color(20, 22, 121));
        label_email_representane.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_email_representane.setForeground(new java.awt.Color(255, 255, 255));
        label_email_representane.setText(" E-mail:");

        label_inscricao.setBackground(new java.awt.Color(20, 22, 121));
        label_inscricao.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_inscricao.setForeground(new java.awt.Color(255, 255, 255));
        label_inscricao.setText(" Inscrição:");

        label_representante.setBackground(new java.awt.Color(20, 22, 121));
        label_representante.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_representante.setForeground(new java.awt.Color(255, 255, 255));
        label_representante.setText(" Representante:");

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

        txt_email_representante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_email_representanteActionPerformed(evt);
            }
        });

        label_tel1representante.setBackground(new java.awt.Color(20, 22, 121));
        label_tel1representante.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tel1representante.setForeground(new java.awt.Color(255, 255, 255));
        label_tel1representante.setText(" Telefone:");

        label_num.setBackground(new java.awt.Color(20, 22, 121));
        label_num.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_num.setForeground(new java.awt.Color(255, 255, 255));
        label_num.setText(" Nº:");

        txt_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numActionPerformed(evt);
            }
        });

        label_localizacao.setBackground(new java.awt.Color(20, 22, 121));
        label_localizacao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label_localizacao.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_localizacao.setForeground(new java.awt.Color(255, 255, 255));
        label_localizacao.setText(" Localização:");

        label_cep.setBackground(new java.awt.Color(20, 22, 121));
        label_cep.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_cep.setForeground(new java.awt.Color(255, 255, 255));
        label_cep.setText(" CEP:");

        txt_cep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cepActionPerformed(evt);
            }
        });

        txt_cnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cnpjActionPerformed(evt);
            }
        });

        label_cnpj.setBackground(new java.awt.Color(20, 22, 121));
        label_cnpj.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_cnpj.setForeground(new java.awt.Color(255, 255, 255));
        label_cnpj.setText(" CNPJ:");

        label_tel.setBackground(new java.awt.Color(20, 22, 121));
        label_tel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tel.setForeground(new java.awt.Color(255, 255, 255));
        label_tel.setText(" Telefone:");

        txt_tel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel1ActionPerformed(evt);
            }
        });

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        label_email.setBackground(new java.awt.Color(20, 22, 121));
        label_email.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_email.setForeground(new java.awt.Color(255, 255, 255));
        label_email.setText(" E-mail:");

        label_bairro.setBackground(new java.awt.Color(20, 22, 121));
        label_bairro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_bairro.setForeground(new java.awt.Color(255, 255, 255));
        label_bairro.setText(" Bairro:");

        txt_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bairroActionPerformed(evt);
            }
        });

        label_tel2representante.setBackground(new java.awt.Color(20, 22, 121));
        label_tel2representante.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tel2representante.setForeground(new java.awt.Color(255, 255, 255));
        label_tel2representante.setText(" Telefone 2:");

        txt_rua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ruaActionPerformed(evt);
            }
        });

        txt_tel2representante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel2representanteActionPerformed(evt);
            }
        });

        label_rua.setBackground(new java.awt.Color(20, 22, 121));
        label_rua.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_rua.setForeground(new java.awt.Color(255, 255, 255));
        label_rua.setText(" Rua:");

        label_nome.setBackground(new java.awt.Color(20, 22, 121));
        label_nome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_nome.setForeground(new java.awt.Color(255, 255, 255));
        label_nome.setText(" Nome:");

        txt_tel1representante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel1representanteActionPerformed(evt);
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
                                .addComponent(label_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txt_tel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_rua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(txt_bairro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGap(131, 131, 131)
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
                .addContainerGap(216, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(816, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nome_representanteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_nome_representanteActionPerformed
    {//GEN-HEADEREND:event_txt_nome_representanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nome_representanteActionPerformed

    private void txt_tel2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel2ActionPerformed
    {//GEN-HEADEREND:event_txt_tel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel2ActionPerformed

    private void txt_inscricaoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_inscricaoActionPerformed
    {//GEN-HEADEREND:event_txt_inscricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_inscricaoActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_voltarActionPerformed
    {//GEN-HEADEREND:event_bt_voltarActionPerformed
        Area_do_menu_vendas vendas = new Area_do_menu_vendas();
        this.dispose();
        vendas.tela_vendas();
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void txt_email_representanteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_email_representanteActionPerformed
    {//GEN-HEADEREND:event_txt_email_representanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email_representanteActionPerformed

    private void txt_numActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_numActionPerformed
    {//GEN-HEADEREND:event_txt_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numActionPerformed

    private void txt_cepActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_cepActionPerformed
    {//GEN-HEADEREND:event_txt_cepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cepActionPerformed

    private void txt_cnpjActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_cnpjActionPerformed
    {//GEN-HEADEREND:event_txt_cnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cnpjActionPerformed

    private void txt_tel1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel1ActionPerformed
    {//GEN-HEADEREND:event_txt_tel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel1ActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_emailActionPerformed
    {//GEN-HEADEREND:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_bairroActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_bairroActionPerformed
    {//GEN-HEADEREND:event_txt_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bairroActionPerformed

    private void txt_ruaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_ruaActionPerformed
    {//GEN-HEADEREND:event_txt_ruaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ruaActionPerformed

    private void txt_tel2representanteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel2representanteActionPerformed
    {//GEN-HEADEREND:event_txt_tel2representanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel2representanteActionPerformed

    private void txt_tel1representanteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel1representanteActionPerformed
    {//GEN-HEADEREND:event_txt_tel1representanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel1representanteActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Acesso_Fornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
