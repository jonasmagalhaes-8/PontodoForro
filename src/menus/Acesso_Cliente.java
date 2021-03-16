package menus;

import clientes_CRUD.Delete_cliente;
import clientes_CRUD.Update_cliente;
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

public class Acesso_Cliente extends javax.swing.JFrame
{
    int checkin=0,tipo_cliente;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int id;
    String nome_atual,email_atual,cpf_cnpjatual,rua_atual,num_atual,bairro_atual,cep_atual,telefone1_atual,telefone2_atual;
    
    public Acesso_Cliente textfields(String nome,String email,String cpf_cnpj,String rua,String num,String bairro,String cep,String telefone1,String telefone2)
    {
        nome_atual = nome;
        email_atual = email;
        cpf_cnpjatual = cpf_cnpj;
        rua_atual = rua;
        num_atual = num;
        bairro_atual = bairro;
        cep_atual = cep;
        telefone1_atual = telefone1;
        telefone2_atual = telefone2;
        
        this.txt_nome.setText(nome);
        this.txt_email.setText(email);
        this.txt_c.setText(cpf_cnpj);
        this.txt_rua.setText(rua);
        this.txt_num.setText(num);
        this.txt_bairro.setText(bairro);
        this.txt_cep.setText(cep);
        this.txt_tel1.setText(telefone1);
        this.txt_tel2.setText(telefone2);
        return null;
    }
    
    public Acesso_Cliente(int tipo)
    {
        initComponents();
        if(tipo==0)
        {
            this.label_c.setText(" CPF:");
            tipo_cliente=0;
        }
        else if(tipo==1)
        {
            this.label_c.setText(" CNPJ:");  
            tipo_cliente=1;
        }
        
        Icon icone_alterar = new ImageIcon("src/imagens/visuais_botao_alterar.gif");
        JButton bt_alterar = new JButton(icone_alterar);
        bt_alterar.setBounds(514, 112, 106, 46);

        Icon icone_excluir = new ImageIcon("src/imagens/visuais_botao_excluir.gif");
        JButton bt_excluir = new JButton(icone_excluir);
        bt_excluir.setBounds(651, 112, 106 , 46);

        JButton bt_tabela = new JButton("Exibir lista de cadastrados"); 
        bt_tabela.setBounds(218, 350, 366 , 116);
        
        bt_voltar.setBackground(Color.decode("#141679"));
        bt_voltar.setForeground(Color.yellow);  

        this.getContentPane().add(bt_voltar);
        this.getContentPane().add(bt_alterar);
        this.getContentPane().add(bt_excluir);
        this.getContentPane().add(bt_tabela);
        
        Background_image tela_acessar = new Background_image
        ( new ImageIcon("src/imagens/visuais_acesso_fisico.png").getImage() );
        
        this.getContentPane().add(tela_acessar);
        
        bt_tabela.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent me)
          { 
            conexao = ModuloConexao.conector();
            
            Lista_Select_Tipo_Clientes lista_clientes = new Lista_Select_Tipo_Clientes();
            
            lista_clientes.setVisible(true);
            
            id = lista_clientes.id;
            if(tipo_cliente==0)
            textfields(lista_clientes.nome, lista_clientes.email, lista_clientes.cpf, lista_clientes.rua,lista_clientes.num, lista_clientes.bairro, lista_clientes.cep, lista_clientes.telefone1,lista_clientes.telefone2);
            else if(tipo_cliente==1)
            textfields(lista_clientes.nome, lista_clientes.email, lista_clientes.cnpj, lista_clientes.rua,lista_clientes.num, lista_clientes.bairro, lista_clientes.cep, lista_clientes.telefone1,lista_clientes.telefone2);
          }
        }
                                   );
        
        bt_alterar.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent me)
          { 
            if(id>0)
            {
              Update_cliente update = new Update_cliente();
              update.setId(Integer.toString(id));
              if(!nome_atual.equals(txt_nome.getText()))
              update.update_nome(txt_nome.getText());
              if(!email_atual.equals(txt_email.getText()))
              update.update_email(txt_email.getText());
              if(!cpf_cnpjatual.equals(txt_c.getText()) && tipo_cliente==0)
              update.update_cpf(txt_c.getText());
              if(!cpf_cnpjatual.equals(txt_c.getText()) && tipo_cliente==1)
              update.update_cnpj(txt_c.getText());
              if(!rua_atual.equals(txt_rua.getText()))
              update.update_rua(txt_rua.getText());
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
              textfields("", "", "", "","", "", "", "", "");
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
              Delete_cliente exclusao = new Delete_cliente();
              exclusao.setId(Integer.toString(id));
              int excluiu=exclusao.delete();
              
              if(excluiu==1)
              {
                textfields("", "", "", "","", "", "", "", "");
                id = 0;
              }
            }
            else
            JOptionPane.showMessageDialog(null, "Favor pesquisar um usuário para realizar uma alteração!");
            }
        }
        ); 
    }
    private Acesso_Cliente()
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
        txt_tel1 = new java.awt.TextField();
        label_tel1 = new java.awt.Label();
        label_c = new java.awt.Label();
        txt_c = new java.awt.TextField();
        txt_cep = new java.awt.TextField();
        label_cep = new java.awt.Label();
        txt_num = new java.awt.TextField();
        label_num = new java.awt.Label();
        bt_voltar = new javax.swing.JButton();
        txt_tel2 = new java.awt.TextField();
        label_tel2 = new java.awt.Label();

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

        txt_tel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel1ActionPerformed(evt);
            }
        });

        label_tel1.setBackground(new java.awt.Color(20, 22, 121));
        label_tel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tel1.setForeground(new java.awt.Color(255, 255, 255));
        label_tel1.setText(" Telefone:");

        label_c.setBackground(new java.awt.Color(20, 22, 121));
        label_c.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_c.setForeground(new java.awt.Color(255, 255, 255));

        txt_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cActionPerformed(evt);
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

        txt_tel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel2ActionPerformed(evt);
            }
        });

        label_tel2.setBackground(new java.awt.Color(20, 22, 121));
        label_tel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tel2.setForeground(new java.awt.Color(255, 255, 255));
        label_tel2.setText(" Telefone 2:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
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
                    .addComponent(label_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(316, Short.MAX_VALUE))
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

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Acesso_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_voltar;
    private java.awt.Label label_bairro;
    public static java.awt.Label label_c;
    private java.awt.Label label_cep;
    private java.awt.Label label_email;
    private java.awt.Label label_nome;
    private java.awt.Label label_num;
    private java.awt.Label label_rua;
    private java.awt.Label label_tel1;
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
