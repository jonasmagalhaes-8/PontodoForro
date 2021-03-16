package menus;

import forro_CRUD.Insert_forro;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import banco.ModuloConexao;
public class Cadastro_Forro extends javax.swing.JFrame
{
    int checkin=0,id_fornecedor;
    double tamanho_m2,tamnho_peca,qt_peca;
    Connection conexao;
    public Cadastro_Forro()
    {
        initComponents(); 
        Background_image tela_cadastrar = new Background_image
        ( new ImageIcon("src/imagens/visuais_cadastro_forro.png").getImage() );
        this.getContentPane().add(tela_cadastrar);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nome = new java.awt.Label();
        txt_nome = new java.awt.TextField();
        txt_cor = new java.awt.TextField();
        label_cor = new java.awt.Label();
        label_tpeca = new java.awt.Label();
        txt_tpeca = new java.awt.TextField();
        bt_cadastrar = new javax.swing.JButton();
        txt_qt_pecas = new java.awt.TextField();
        label_fornecedor = new java.awt.Label();
        bt_voltar = new javax.swing.JButton();
        bt_select_fornecedor = new javax.swing.JButton();
        txt_fornecedor = new java.awt.TextField();
        tipo_estoque = new javax.swing.JComboBox();
        label_valor = new java.awt.Label();
        txt_valor = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        label_nome.setBackground(new java.awt.Color(20, 22, 121));
        label_nome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_nome.setForeground(new java.awt.Color(255, 255, 255));
        label_nome.setText(" Nome:");

        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });

        txt_cor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_corActionPerformed(evt);
            }
        });

        label_cor.setBackground(new java.awt.Color(20, 22, 121));
        label_cor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_cor.setForeground(new java.awt.Color(255, 255, 255));
        label_cor.setText(" Cor:");

        label_tpeca.setBackground(new java.awt.Color(20, 22, 121));
        label_tpeca.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tpeca.setForeground(new java.awt.Color(255, 255, 255));
        label_tpeca.setText(" Tamanho da peça:");

        txt_tpeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tpecaActionPerformed(evt);
            }
        });

        bt_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/visuais_botao_cadastrar_produto_1.gif"))); // NOI18N
        bt_cadastrar.setPreferredSize(new java.awt.Dimension(366, 116));
        bt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarActionPerformed(evt);
            }
        });

        txt_qt_pecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_qt_pecasActionPerformed(evt);
            }
        });

        label_fornecedor.setBackground(new java.awt.Color(20, 22, 121));
        label_fornecedor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_fornecedor.setForeground(new java.awt.Color(255, 255, 255));
        label_fornecedor.setText(" Fornecedor:");

        bt_voltar.setBackground(new java.awt.Color(20, 22, 121));
        bt_voltar.setForeground(java.awt.Color.yellow);
        bt_voltar.setText("Voltar");
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        bt_select_fornecedor.setText("Selecionar Fornecedor para o Forro");
        bt_select_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_select_fornecedorActionPerformed(evt);
            }
        });

        txt_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fornecedorActionPerformed(evt);
            }
        });

        tipo_estoque.setBackground(new java.awt.Color(20, 22, 121));
        tipo_estoque.setForeground(new java.awt.Color(240, 240, 240));
        tipo_estoque.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " Quantidade de peças:", " Metro quadrado:" }));
        tipo_estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_estoqueActionPerformed(evt);
            }
        });

        label_valor.setBackground(new java.awt.Color(20, 22, 121));
        label_valor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_valor.setForeground(new java.awt.Color(255, 255, 255));
        label_valor.setText(" Valor do M2:");

        txt_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(bt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_valor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_select_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label_fornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tipo_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tpeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_fornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_qt_pecas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))))))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
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
                    .addComponent(label_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_cor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_qt_pecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(bt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(816, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_nomeActionPerformed
    {//GEN-HEADEREND:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void txt_corActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_corActionPerformed
    {//GEN-HEADEREND:event_txt_corActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_corActionPerformed

    private void txt_tpecaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tpecaActionPerformed
    {//GEN-HEADEREND:event_txt_tpecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tpecaActionPerformed

    private void bt_cadastrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_cadastrarActionPerformed
    {//GEN-HEADEREND:event_bt_cadastrarActionPerformed
      Insert_forro cadastro = new Insert_forro(); //Cria um objeto da classe Insert_cliente para cadastro de um cliente
      //Passagem do conteúdo dos campos de texto para a classe de cadastro:
      cadastro.setNome_informado(txt_nome.getText()); 
      cadastro.setcor_informada(txt_cor.getText());
      if(!txt_tpeca.getText().equals(""))
      {
        tamnho_peca = Double.parseDouble(txt_tpeca.getText().replaceAll(",", "."));
        cadastro.settamanho_informado(tamnho_peca);
      }
      else
      JOptionPane.showMessageDialog(null, "Informe o tamanho!");
      
      cadastro.setvalor_M2(Double.parseDouble(txt_valor.getText().replaceAll(",", ".")));
      
      Object selected = this.tipo_estoque.getSelectedItem();
      if(selected.toString().equals(" Quantidade de peças:") && !txt_qt_pecas.getText().equals(""))
      {
          if(txt_qt_pecas.getText().contains(",") || txt_qt_pecas.getText().contains("."))
          JOptionPane.showMessageDialog(null, "Não são permitidos valores fracionados!");
          else
          {
            tamanho_m2 = tamnho_peca*0.2;
            qt_peca = Integer.parseInt(txt_qt_pecas.getText().replaceAll(",", "."));
            tamanho_m2 = tamanho_m2*qt_peca;
            cadastro.setqt_pecas_informado(qt_peca);
            cadastro.setqt_M2(tamanho_m2);
          }
      }
      else if(selected.toString().equals(" Metro quadrado:") && !txt_qt_pecas.getText().equals(""))
      {
          tamanho_m2 = Double.parseDouble(txt_qt_pecas.getText().replaceAll(",", "."));
          qt_peca = tamnho_peca*0.2;
          qt_peca = tamanho_m2/qt_peca;
          
          String str_qt_peca = String.valueOf(qt_peca);
  
          int valor_inteiro=str_qt_peca.indexOf(".");
          str_qt_peca = str_qt_peca.substring(0,valor_inteiro);

          qt_peca = Double.parseDouble(str_qt_peca);
          
          cadastro.setqt_pecas_informado(qt_peca);
          cadastro.setqt_M2(tamanho_m2);
      }
      else
      JOptionPane.showMessageDialog(null, "Quantidade informada inválida!");

      checkin = cadastro.getCheckin(); //Recebe o retorno da validação de cada campo (mais detalhe na classe Insert_cliente)
      if(checkin==6) //Se o contador for igual a 6 (isto é, todos os campos estiverem corretos), limpa-se os campos e finaliza o cadastro
      {
        cadastro.cadastro_banco(checkin,id_fornecedor); //Chamada do método que finaliza o cadastro
        txt_nome.setText("");
        txt_cor.setText("");
        txt_fornecedor.setText("");
        txt_tpeca.setText("");
        txt_qt_pecas.setText("");
        txt_valor.setText("");
        checkin=0; //Zeragem da variável para evitar lixo de memória
      }
      else
      {
          JOptionPane.showMessageDialog(null, "Um ou mais dados informados estão inválidos!");
          checkin=0;
          cadastro.SetCheckin(0);
      }
      
    }//GEN-LAST:event_bt_cadastrarActionPerformed

    private void txt_qt_pecasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_qt_pecasActionPerformed
    {//GEN-HEADEREND:event_txt_qt_pecasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qt_pecasActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_voltarActionPerformed
    {//GEN-HEADEREND:event_bt_voltarActionPerformed
        Area_dos_Forros produtos = new Area_dos_Forros();
        this.dispose();
        produtos.area_produtos();
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void txt_fornecedorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_fornecedorActionPerformed
    {//GEN-HEADEREND:event_txt_fornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fornecedorActionPerformed

    private void bt_select_fornecedorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_select_fornecedorActionPerformed
    {//GEN-HEADEREND:event_bt_select_fornecedorActionPerformed
      conexao = ModuloConexao.conector();
            
      Lista_Select_Fornecedor lista_fornecdores = new Lista_Select_Fornecedor();
            
      lista_fornecdores.setVisible(true);
      id_fornecedor = lista_fornecdores.id;
      txt_fornecedor.setText(lista_fornecdores.nome);
    }//GEN-LAST:event_bt_select_fornecedorActionPerformed

    private void txt_valorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_valorActionPerformed
    {//GEN-HEADEREND:event_txt_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valorActionPerformed

    private void tipo_estoqueActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tipo_estoqueActionPerformed
    {//GEN-HEADEREND:event_tipo_estoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipo_estoqueActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Cadastro_Forro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cadastrar;
    private javax.swing.JButton bt_select_fornecedor;
    private javax.swing.JButton bt_voltar;
    private java.awt.Label label_cor;
    private java.awt.Label label_fornecedor;
    private java.awt.Label label_nome;
    private java.awt.Label label_tpeca;
    private java.awt.Label label_valor;
    private javax.swing.JComboBox tipo_estoque;
    private java.awt.TextField txt_cor;
    private java.awt.TextField txt_fornecedor;
    private java.awt.TextField txt_nome;
    private java.awt.TextField txt_qt_pecas;
    private java.awt.TextField txt_tpeca;
    private java.awt.TextField txt_valor;
    // End of variables declaration//GEN-END:variables
}
