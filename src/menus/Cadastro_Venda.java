package menus;

import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import banco.ModuloConexao;
import java.util.ArrayList;
import java.util.List;
public class Cadastro_Venda extends javax.swing.JFrame
{
    int checkin=0,id_produto,id_cliente;
    float tamanho_m2,tamnho_peca,qt_peca,valor;
    double valor_m2=0,qt_m2,estoque,qt_desejada_pec=0;
    List<String> cliente = new ArrayList<String>();
    List<String> produto = new ArrayList<String>();
    Connection conexao;
    String tipo_quantidade;
    
    public void calcula_valor()
    { 
            Object selected = this.tipo_venda_quantidade.getSelectedItem();

            if(selected.toString().equals(" Qtd desejada em peças:"))
            {
                if(txt_qt_pecas.getText().contains(",") || txt_qt_pecas.getText().contains("."))
                JOptionPane.showMessageDialog(null, "Não são permitidos valores fracionados!");
                else
                {
                    tipo_quantidade=" Qtd desejada em peças:";
                    qt_desejada_pec = Float.parseFloat(txt_qt_pecas.getText());
                    valor=Float.parseFloat(txt_valor.getText())*Float.parseFloat(txt_qt_pecas.getText());
                    this.txt_valortotal.setText(String.valueOf(valor));
                }
            }
            else if(selected.toString().equals(" Qtd desejada em M²:"))
            {
                tipo_quantidade=" Qtd desejada em M²:";
                double tamanho_m2 = Double.parseDouble(txt_qt_pecas.getText().replaceAll(",", "."));
                valor_m2 = Float.parseFloat(txt_tpeca.getText())*0.2;
                qt_desejada_pec = tamanho_m2/valor_m2;
                
                String str_qt_peca = String.valueOf(qt_desejada_pec);
  
                int valor_inteiro=str_qt_peca.indexOf(".");
                str_qt_peca = str_qt_peca.substring(0,valor_inteiro);

                qt_desejada_pec = Double.parseDouble(str_qt_peca);
                
                valor_m2 = qt_desejada_pec*Float.parseFloat(txt_valor.getText());
                this.txt_valortotal.setText(String.valueOf(valor_m2));
            }
    }
    
    public Cadastro_Venda()
    {
        initComponents(); 
        Background_image tela_cadastrar = new Background_image
        ( new ImageIcon("src/imagens/visuais_nova_venda.png").getImage() );
        this.getContentPane().add(tela_cadastrar);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_cliente = new java.awt.Label();
        txt_cliente = new java.awt.TextField();
        txt_cor = new java.awt.TextField();
        label_cor = new java.awt.Label();
        label_tpeca = new java.awt.Label();
        txt_tpeca = new java.awt.TextField();
        bt_venda = new javax.swing.JButton();
        txt_qt_pecas = new java.awt.TextField();
        txt_valor = new java.awt.TextField();
        label_valor = new java.awt.Label();
        label_produtor = new java.awt.Label();
        bt_voltar = new javax.swing.JButton();
        bt_select_produto = new javax.swing.JButton();
        txt_produto = new java.awt.TextField();
        tipo_venda_quantidade = new javax.swing.JComboBox();
        bt_select_cliente = new javax.swing.JButton();
        label_fornecedor = new java.awt.Label();
        txt_fornecedor = new java.awt.TextField();
        bt_parcelamento = new javax.swing.JButton();
        txt_valortotal = new java.awt.TextField();
        label_cliente1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        label_cliente.setBackground(new java.awt.Color(20, 22, 121));
        label_cliente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_cliente.setForeground(new java.awt.Color(255, 255, 255));
        label_cliente.setText(" Cliente:");

        txt_cliente.setEditable(false);
        txt_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_clienteActionPerformed(evt);
            }
        });

        txt_cor.setEditable(false);
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

        txt_tpeca.setEditable(false);
        txt_tpeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tpecaActionPerformed(evt);
            }
        });

        bt_venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/visuais_botao_venda.gif"))); // NOI18N
        bt_venda.setPreferredSize(new java.awt.Dimension(366, 116));
        bt_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_vendaActionPerformed(evt);
            }
        });

        txt_qt_pecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_qt_pecasMouseExited(evt);
            }
        });
        txt_qt_pecas.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                txt_qt_pecasTextValueChanged(evt);
            }
        });
        txt_qt_pecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_qt_pecasActionPerformed(evt);
            }
        });
        txt_qt_pecas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_qt_pecasFocusLost(evt);
            }
        });

        txt_valor.setEditable(false);
        txt_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valorActionPerformed(evt);
            }
        });

        label_valor.setBackground(new java.awt.Color(20, 22, 121));
        label_valor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_valor.setForeground(new java.awt.Color(255, 255, 255));
        label_valor.setText(" Valor do M2:");

        label_produtor.setBackground(new java.awt.Color(20, 22, 121));
        label_produtor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_produtor.setForeground(new java.awt.Color(255, 255, 255));
        label_produtor.setText(" Produto:");

        bt_voltar.setBackground(new java.awt.Color(20, 22, 121));
        bt_voltar.setForeground(java.awt.Color.yellow);
        bt_voltar.setText("Voltar");
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        bt_select_produto.setText("Selecionar Produto:");
        bt_select_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_select_produtoActionPerformed(evt);
            }
        });

        txt_produto.setEditable(false);
        txt_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_produtoActionPerformed(evt);
            }
        });

        tipo_venda_quantidade.setBackground(new java.awt.Color(20, 22, 121));
        tipo_venda_quantidade.setForeground(new java.awt.Color(240, 240, 240));
        tipo_venda_quantidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " Qtd desejada em peças:", " Qtd desejada em M²:" }));
        tipo_venda_quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_venda_quantidadeActionPerformed(evt);
            }
        });

        bt_select_cliente.setText("Selecionar Cliente comprador:");
        bt_select_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_select_clienteActionPerformed(evt);
            }
        });

        label_fornecedor.setBackground(new java.awt.Color(20, 22, 121));
        label_fornecedor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_fornecedor.setForeground(new java.awt.Color(255, 255, 255));
        label_fornecedor.setText(" Fornecedor:");

        txt_fornecedor.setEditable(false);
        txt_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fornecedorActionPerformed(evt);
            }
        });

        bt_parcelamento.setBackground(new java.awt.Color(20, 22, 121));
        bt_parcelamento.setForeground(new java.awt.Color(240, 240, 240));
        bt_parcelamento.setText("Ver valor parcelado");
        bt_parcelamento.setEnabled(false);
        bt_parcelamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_parcelamentoActionPerformed(evt);
            }
        });

        txt_valortotal.setEditable(false);
        txt_valortotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_valortotalMouseExited(evt);
            }
        });
        txt_valortotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valortotalActionPerformed(evt);
            }
        });

        label_cliente1.setBackground(new java.awt.Color(20, 22, 121));
        label_cliente1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_cliente1.setForeground(new java.awt.Color(255, 255, 255));
        label_cliente1.setText(" Valor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 728, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(bt_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bt_select_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_cor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tipo_venda_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_valortotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_tpeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_qt_pecas, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label_valor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label_produtor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txt_valor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_produto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(bt_select_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(label_cliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(bt_parcelamento)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_select_produto)
                    .addComponent(bt_select_cliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_cor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_produtor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_qt_pecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo_venda_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_cliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_parcelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(bt_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );

        setSize(new java.awt.Dimension(816, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_clienteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_clienteActionPerformed
    {//GEN-HEADEREND:event_txt_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_clienteActionPerformed

    private void txt_corActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_corActionPerformed
    {//GEN-HEADEREND:event_txt_corActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_corActionPerformed

    private void txt_tpecaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tpecaActionPerformed
    {//GEN-HEADEREND:event_txt_tpecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tpecaActionPerformed

    private void bt_vendaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_vendaActionPerformed
    {//GEN-HEADEREND:event_bt_vendaActionPerformed
        if(!cliente.isEmpty() && !produto.isEmpty())
        {
            if(!txt_qt_pecas.getText().equals("") || !txt_valortotal.getText().equals(""))
            { 
                if(qt_desejada_pec==0)
                JOptionPane.showMessageDialog(null, "Quantidade inválida!");
                else if(qt_desejada_pec>estoque)
                JOptionPane.showMessageDialog(null, "A quantidade desejada é maior do que a existente em estoque!");
                else
                {
                    produto.add(String.valueOf(qt_desejada_pec)); //7
                    produto.add(txt_valortotal.getText()); //8
                    Finalizar_Venda call = new Finalizar_Venda(cliente,produto,tipo_quantidade,estoque);
                    call.setVisible(true);
                    this.dispose();
                }
            }
            else
            JOptionPane.showMessageDialog(null, "Informe uma quantidade desejada para que o valor seja calculado!"); 
        }
        else
        JOptionPane.showMessageDialog(null, "Selecione um cliente e um produto!");
    }//GEN-LAST:event_bt_vendaActionPerformed

    private void txt_valorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_valorActionPerformed
    {//GEN-HEADEREND:event_txt_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valorActionPerformed

    private void txt_qt_pecasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_qt_pecasActionPerformed
    {//GEN-HEADEREND:event_txt_qt_pecasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qt_pecasActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_voltarActionPerformed
    {//GEN-HEADEREND:event_bt_voltarActionPerformed
        Area_do_Submenu_vendas vendas = new Area_do_Submenu_vendas();
        this.dispose();
        vendas.area_vendas();
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void txt_produtoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_produtoActionPerformed
    {//GEN-HEADEREND:event_txt_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_produtoActionPerformed

    private void bt_select_produtoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_select_produtoActionPerformed
    {//GEN-HEADEREND:event_bt_select_produtoActionPerformed
      conexao = ModuloConexao.conector();
            
      Lista_Select_Forro lista_produtos = new Lista_Select_Forro();
            
      lista_produtos.setVisible(true);
      
      estoque = lista_produtos.qt_forroPec;
      
      txt_produto.setText(lista_produtos.nome);
      txt_fornecedor.setText(lista_produtos.fornecedor);
      txt_cor.setText(lista_produtos.cor);
      String t_peca = String.valueOf(lista_produtos.tpeca);
      txt_tpeca.setText(t_peca.replaceAll(",", "."));
      double valor_m2_real = lista_produtos.valorM2;
      String t_valor = String.valueOf(lista_produtos.valorM2);
      txt_valor.setText(t_valor.replaceAll(",", "."));
      
      produto.add(String.valueOf(lista_produtos.cod_forro)); //0
      produto.add(String.valueOf(lista_produtos.cod_fornecedor)); //1
      produto.add(lista_produtos.nome); //2
      produto.add(String.valueOf(lista_produtos.fornecedor)); //3
      produto.add(lista_produtos.cor); //4
      produto.add(String.valueOf(lista_produtos.tpeca)); //5
      produto.add(String.valueOf(lista_produtos.valorM2)); //6
    }//GEN-LAST:event_bt_select_produtoActionPerformed

    private void bt_select_clienteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_select_clienteActionPerformed
    {//GEN-HEADEREND:event_bt_select_clienteActionPerformed
      conexao = ModuloConexao.conector();
      Lista_Select_ALL_clientes lista_clientes = new Lista_Select_ALL_clientes();
            
      lista_clientes.setVisible(true);
      id_cliente = lista_clientes.id;
      cliente.add(String.valueOf(lista_clientes.id)); //0
      cliente.add((lista_clientes.nome)); //1
      cliente.add((lista_clientes.email)); //2
      cliente.add((lista_clientes.cpf)); //3
      cliente.add((lista_clientes.cnpj)); //4
      cliente.add((lista_clientes.rua));
      cliente.add((lista_clientes.num));
      cliente.add((lista_clientes.bairro));
      cliente.add((lista_clientes.cep));
      cliente.add((lista_clientes.telefone1));
      cliente.add((lista_clientes.telefone2));
      txt_cliente.setText(lista_clientes.nome);
    }//GEN-LAST:event_bt_select_clienteActionPerformed

    private void txt_fornecedorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_fornecedorActionPerformed
    {//GEN-HEADEREND:event_txt_fornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fornecedorActionPerformed

    private void txt_orcamentoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_orcamentoActionPerformed
    {//GEN-HEADEREND:event_txt_orcamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_orcamentoActionPerformed

    private void txt_valortotalActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_valortotalActionPerformed
    {//GEN-HEADEREND:event_txt_valortotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valortotalActionPerformed

    private void tipo_venda_quantidadeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tipo_venda_quantidadeActionPerformed
    {//GEN-HEADEREND:event_tipo_venda_quantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipo_venda_quantidadeActionPerformed

    private void bt_parcelamentoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_parcelamentoActionPerformed
    {//GEN-HEADEREND:event_bt_parcelamentoActionPerformed
        if(valor==0)
        valor=(float) valor_m2;
        int i=2;
        JOptionPane.showMessageDialog(null,i+" vezes: "+valor/i+"\n"+(i+1)+" vezes: "+valor/(i+1)+"\n"+(i+2)+" vezes: "+valor/(i+2)+"\n"+(i+3)+" vezes: "+valor/(i+3)+"\n"+(i+4)+" vezes: "+valor/(i+4)+"\n"+(i+5)+" vezes: "+valor/(i+5)+"\n"+(i+6)+" vezes: "+valor/(i+6)+"\n"+(i+7)+" vezes: "+valor/(i+7)+"\n"+(i+8)+" vezes: "+valor/(i+8)+"\n"+(i+9)+" vezes: "+valor/(i+9)+"\n"+(i+10)+" vezes: "+valor/(i+10));
    }//GEN-LAST:event_bt_parcelamentoActionPerformed

    private void txt_qt_pecasFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_txt_qt_pecasFocusLost
    {//GEN-HEADEREND:event_txt_qt_pecasFocusLost

    }//GEN-LAST:event_txt_qt_pecasFocusLost

    private void txt_valortotalMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_txt_valortotalMouseExited
    {//GEN-HEADEREND:event_txt_valortotalMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valortotalMouseExited

    private void txt_qt_pecasMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_txt_qt_pecasMouseExited
    {//GEN-HEADEREND:event_txt_qt_pecasMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qt_pecasMouseExited

    private void txt_qt_pecasTextValueChanged(java.awt.event.TextEvent evt)//GEN-FIRST:event_txt_qt_pecasTextValueChanged
    {//GEN-HEADEREND:event_txt_qt_pecasTextValueChanged
        calcula_valor();
        bt_parcelamento.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qt_pecasTextValueChanged

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Cadastro_Venda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_parcelamento;
    private javax.swing.JButton bt_select_cliente;
    private javax.swing.JButton bt_select_produto;
    private javax.swing.JButton bt_venda;
    private javax.swing.JButton bt_voltar;
    private java.awt.Label label_cliente;
    private java.awt.Label label_cliente1;
    private java.awt.Label label_cor;
    private java.awt.Label label_fornecedor;
    private java.awt.Label label_produtor;
    private java.awt.Label label_tpeca;
    private java.awt.Label label_valor;
    private javax.swing.JComboBox tipo_venda_quantidade;
    private java.awt.TextField txt_cliente;
    private java.awt.TextField txt_cor;
    private java.awt.TextField txt_fornecedor;
    private java.awt.TextField txt_produto;
    private java.awt.TextField txt_qt_pecas;
    private java.awt.TextField txt_tpeca;
    private java.awt.TextField txt_valor;
    private java.awt.TextField txt_valortotal;
    // End of variables declaration//GEN-END:variables
}
