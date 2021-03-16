package menus;

import forro_e_CRUD.Delete_forro;
import forro_CRUD.Update_forro;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import banco.ModuloConexao;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Acesso_Forro extends javax.swing.JFrame
{
    int checkin=0,id_forro,id_fornecedor,qtp=0,qtM2=0;
    float tamanho_m2,tamnho_peca,qt_peca;
    double qt_forroPec,qt_forroM2;
    Connection conexao;
    String nome_atual,cor_atual,tpeca_atual,fornecedor_atual,qt_forro_atual;
    NumberFormat nf = new DecimalFormat("0.0");
    NumberFormat nf_M2 = new DecimalFormat("0.00");
    
    
    public Acesso_Forro textfields(String nome,String cor,String tpeca,String fornecedor)
    {
        nome_atual = nome;
        cor_atual = cor;
        tpeca_atual = tpeca;
        fornecedor_atual = fornecedor;
        
        this.txt_nome.setText(nome);
        this.txt_cor.setText(cor);
        this.txt_tpeca.setText(tpeca);
        this.txt_fornecedor.setText(fornecedor);
        return null;
    }
    
    public Acesso_Forro reload()
    {
        this.dispose();
        Area_dos_Forros restart = new Area_dos_Forros();
        restart.area_produtos();
        return null;
    }
    
    public Acesso_Forro()
    {
        initComponents();
        
        Icon icone_alterar = new ImageIcon("src/imagens/visuais_botao_alterar.gif");
        JButton bt_alterar = new JButton(icone_alterar);
        bt_alterar.setBounds(125, 142, 106, 46);

        Icon icone_excluir = new ImageIcon("src/imagens/visuais_botao_excluir.gif");
        JButton bt_excluir = new JButton(icone_excluir);
        bt_excluir.setBounds(260, 142, 106 , 46);

        JButton bt_tabela = new JButton("Exibir lista de produtos cadastrados"); 
        bt_tabela.setBounds(218, 350, 366 , 116);
        
        bt_voltar.setBackground(Color.decode("#141679"));
        bt_voltar.setForeground(Color.yellow);  

        this.getContentPane().add(bt_voltar);
        this.getContentPane().add(bt_alterar);
        this.getContentPane().add(bt_excluir);
        this.getContentPane().add(bt_tabela);
        
        Background_image tela_acessar = new Background_image
        ( new ImageIcon("src/imagens/visuais_acesso_produto.png").getImage() );
        
        this.getContentPane().add(tela_acessar);
        
        bt_tabela.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent me)
          { 
            conexao = ModuloConexao.conector();
            
            Lista_Select_Forro lista_forros = new Lista_Select_Forro();
            
            lista_forros.setVisible(true);
            
            id_forro = lista_forros.cod_forro;
            qt_forroM2 = lista_forros.qt_forroM2;
            qt_forroPec = lista_forros.qt_forroPec;
                
            textfields(lista_forros.nome,lista_forros.cor,String.valueOf(lista_forros.tpeca),lista_forros.fornecedor);      
          }
        }
                                   );
        
        bt_alterar.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent me)
          { 
            if(id_forro>0)
            {
              Update_forro update = new Update_forro();
              update.setId(Integer.toString(id_forro));
              if(!nome_atual.equals(txt_nome.getText()))
              update.update_nome(txt_nome.getText());
              if(!cor_atual.equals(txt_cor.getText()))
              update.update_cor(txt_cor.getText());
              if(!tpeca_atual.equals(txt_tpeca.getText()))
              update.update_tamanho_peca(Float.parseFloat(txt_tpeca.getText()));
              
              tamnho_peca = Float.parseFloat(txt_tpeca.getText());
              
              if(qtp==1)
              {
                   if(txt_qt_forro.getText().contains(",") || txt_qt_forro.getText().contains("."))
                   JOptionPane.showMessageDialog(null, "Não são permitidos valores fracionados!");
                   else
                   {
                        if(Float.parseFloat(txt_qt_forro.getText())!=qt_forroPec)
                        {
                            tamanho_m2 = (float) (tamnho_peca*0.2);
                            qt_peca = Float.parseFloat(txt_qt_forro.getText());
                            tamanho_m2 = tamanho_m2*qt_peca;
                            //String tamanho_m2_decimal = String.valueOf(tamanho_m2);
                            if(tamanho_m2!=qt_forroM2)
                            {
                                //int m2_casas_decimais=tamanho_m2_decimal.indexOf(".");
                                //update.update_quantidade(qt_peca, Float.parseFloat(tamanho_m2_decimal.substring(0, m2_casas_decimais+2)));
                                update.update_quantidade(qt_peca, tamanho_m2);
                            }
                        }
                   }
              }
              
              if(qtM2==1 && Float.parseFloat(txt_qt_forro.getText())!=qt_forroM2)
              {
                  int m2_casas_decimais=txt_qt_forro.getText().indexOf(".");
                  qt_peca = (float) (tamnho_peca*0.2);
                  tamanho_m2 = Float.parseFloat(txt_qt_forro.getText());
                  qt_peca = tamanho_m2/qt_peca;
                  
                  String str_qt_peca = String.valueOf(qt_peca);
                  int valor_inteiro=str_qt_peca.indexOf(".");
                  str_qt_peca = str_qt_peca.substring(0,valor_inteiro);
                  qt_peca = Float.parseFloat(str_qt_peca);
                  
                  if(qt_peca!=qt_forroPec)
                  update.update_quantidade(qt_peca, tamanho_m2);
              }

              if(!fornecedor_atual.equals(txt_fornecedor.getText()))
              update.update_fornecedor(id_fornecedor);
              
                          
              reload();
            }
            else
            JOptionPane.showMessageDialog(null, "Favor pesquisar um produto para realizar uma alteração!"); 
          }
         });
        
        bt_excluir.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent me)
          { 
            if(id_forro>0)
            {
              Delete_forro exclusao = new Delete_forro();
              exclusao.setId_forro(Integer.toString(id_forro));
              int excluiu=exclusao.delete();
              
              if(excluiu==1)
              {
                textfields("","","","");
                txt_qt_forro.setText("");
                id_forro = 0;
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

        txt_fornecedor = new java.awt.TextField();
        bt_voltar = new javax.swing.JButton();
        bt_select_fornecedor = new javax.swing.JButton();
        label_fornecedor = new java.awt.Label();
        txt_nome = new java.awt.TextField();
        label_nome = new java.awt.Label();
        txt_tpeca = new java.awt.TextField();
        label_tpeca = new java.awt.Label();
        label_cor = new java.awt.Label();
        txt_cor = new java.awt.TextField();
        txt_qt_forro = new java.awt.TextField();
        label_tpeca1 = new java.awt.Label();
        bt_qtp = new javax.swing.JButton();
        bt_qtM2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txt_fornecedor.setEditable(false);
        txt_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fornecedorActionPerformed(evt);
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

        bt_select_fornecedor.setText("Mudar Fornecedor do Forro");
        bt_select_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_select_fornecedorActionPerformed(evt);
            }
        });

        label_fornecedor.setBackground(new java.awt.Color(20, 22, 121));
        label_fornecedor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_fornecedor.setForeground(new java.awt.Color(255, 255, 255));
        label_fornecedor.setText("Fornecedor:");

        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });

        label_nome.setBackground(new java.awt.Color(20, 22, 121));
        label_nome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_nome.setForeground(new java.awt.Color(255, 255, 255));
        label_nome.setText(" Nome:");

        txt_tpeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tpecaActionPerformed(evt);
            }
        });

        label_tpeca.setBackground(new java.awt.Color(20, 22, 121));
        label_tpeca.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tpeca.setForeground(new java.awt.Color(255, 255, 255));
        label_tpeca.setText(" Exibir quantidade disponivel em:");

        label_cor.setBackground(new java.awt.Color(20, 22, 121));
        label_cor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_cor.setForeground(new java.awt.Color(255, 255, 255));
        label_cor.setText(" Cor:");

        txt_cor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_corActionPerformed(evt);
            }
        });

        txt_qt_forro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_qt_forroActionPerformed(evt);
            }
        });

        label_tpeca1.setBackground(new java.awt.Color(20, 22, 121));
        label_tpeca1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tpeca1.setForeground(new java.awt.Color(255, 255, 255));
        label_tpeca1.setText("Tamanho da peça:");

        bt_qtp.setText("Peças");
        bt_qtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_qtpActionPerformed(evt);
            }
        });

        bt_qtM2.setText("Metro Quadrado");
        bt_qtM2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_qtM2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 728, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_cor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(label_fornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_tpeca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_fornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(bt_select_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(bt_qtp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_qtM2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label_tpeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_qt_forro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(bt_select_fornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_tpeca1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_cor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(label_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_qtp)
                    .addComponent(bt_qtM2))
                .addGap(1, 1, 1)
                .addComponent(txt_qt_forro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 292, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(816, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_fornecedorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_fornecedorActionPerformed
    {//GEN-HEADEREND:event_txt_fornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fornecedorActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_voltarActionPerformed
    {//GEN-HEADEREND:event_bt_voltarActionPerformed
        Area_dos_Forros produtos = new Area_dos_Forros();
        this.dispose();
        produtos.area_produtos();
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void bt_select_fornecedorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_select_fornecedorActionPerformed
    {//GEN-HEADEREND:event_bt_select_fornecedorActionPerformed
        conexao = ModuloConexao.conector();

        Lista_Select_Fornecedor lista_fornecdores = new Lista_Select_Fornecedor();

        lista_fornecdores.setVisible(true);
        id_fornecedor = lista_fornecdores.id;
        
        if(id_fornecedor>0)
        this.txt_fornecedor.setText(lista_fornecdores.nome);
    }//GEN-LAST:event_bt_select_fornecedorActionPerformed

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_nomeActionPerformed
    {//GEN-HEADEREND:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void txt_tpecaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tpecaActionPerformed
    {//GEN-HEADEREND:event_txt_tpecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tpecaActionPerformed

    private void txt_corActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_corActionPerformed
    {//GEN-HEADEREND:event_txt_corActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_corActionPerformed

    private void txt_qt_forroActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_qt_forroActionPerformed
    {//GEN-HEADEREND:event_txt_qt_forroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qt_forroActionPerformed

    private void bt_qtpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_qtpActionPerformed
    {//GEN-HEADEREND:event_bt_qtpActionPerformed
       int valor_inteiro = String.valueOf(qt_forroPec).indexOf(".");
       String qt_peca_inteiro = String.valueOf(qt_forroPec);
       this.txt_qt_forro.setText(qt_peca_inteiro.substring(0, valor_inteiro));
       qtp=1;
       qtM2=0;
    }//GEN-LAST:event_bt_qtpActionPerformed

    private void bt_qtM2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_qtM2ActionPerformed
    {//GEN-HEADEREND:event_bt_qtM2ActionPerformed
       this.txt_qt_forro.setText(nf_M2.format(qt_forroM2).replaceAll(",", "."));
       qtM2=1;
       qtp=0;
    }//GEN-LAST:event_bt_qtM2ActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Acesso_Forro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_qtM2;
    private javax.swing.JButton bt_qtp;
    private javax.swing.JButton bt_select_fornecedor;
    private javax.swing.JButton bt_voltar;
    private java.awt.Label label_cor;
    private java.awt.Label label_fornecedor;
    private java.awt.Label label_nome;
    private java.awt.Label label_tpeca;
    private java.awt.Label label_tpeca1;
    private java.awt.TextField txt_cor;
    private java.awt.TextField txt_fornecedor;
    private java.awt.TextField txt_nome;
    private java.awt.TextField txt_qt_forro;
    private java.awt.TextField txt_tpeca;
    // End of variables declaration//GEN-END:variables
}
