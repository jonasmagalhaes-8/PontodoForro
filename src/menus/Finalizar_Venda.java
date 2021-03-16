package menus;

import classes_externas.gera_data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import venda_CRUD.Venda;

public class Finalizar_Venda extends javax.swing.JFrame
{
    String nome_cliente,fornecedor,nome_produto;
    int n_parcelas,id_cliente,id_produto,opcao_escolhida=0;
    double valor,estoque_atual,tamanho_m2,quantidade_comprada;
    
    public void preenche_dadosCliente(List<String> cliente)
    {
        this.txt_nome.setText(cliente.get(1));
        this.txt_email.setText(cliente.get(2));
        this.txt_c.setText(cliente.get(3));
        this.txt_rua.setText(cliente.get(5));
        this.txt_num.setText(cliente.get(6));
        this.txt_bairro.setText(cliente.get(7));
        this.txt_cep.setText(cliente.get(8));
        this.txt_tel1.setText(cliente.get(9));
        this.txt_tel2.setText(cliente.get(10));
    }
    
    public void preenche_dadosProduto(List<String> produto)
    {
        this.txt_produto.setText(produto.get(2));
        this.txt_fornecedor.setText(produto.get(3));
        this.txt_cor.setText(produto.get(4));
        this.txt_tpeca.setText(produto.get(5));
        this.txt_valor.setText(produto.get(6));
        this.txt_qt_pecas.setText(produto.get(7));
        this.txt_valortotal.setText(produto.get(8));
    }
    
    public Finalizar_Venda(List<String> cliente,List<String> produto,String tipo_quantidade,Double estoque)
    {
        initComponents();
        this.label_tpeca1.setText(tipo_quantidade);
             
        id_cliente = Integer.parseInt(cliente.get(0));
        id_produto = Integer.parseInt(produto.get(0));
        nome_cliente = cliente.get(1);
        nome_produto = produto.get(2);
        fornecedor = produto.get(3);
        quantidade_comprada =  Double.parseDouble(produto.get(7));
        valor = Float.parseFloat(produto.get(8));
        estoque_atual = estoque;
        
        preenche_dadosCliente(cliente);
        preenche_dadosProduto(produto);
        
        if(tipo_quantidade.toString().equals(" Metro quadrado:"))
        {
            tamanho_m2 = Double.parseDouble(txt_qt_pecas.getText().replaceAll(",", "."));
            quantidade_comprada = Double.parseDouble(txt_tpeca.getText())*0.2;
            quantidade_comprada = tamanho_m2/quantidade_comprada;
        }
        
        Background_image tela_cadastrar = new Background_image
        ( new ImageIcon("src/imagens/visuais_finalizar_venda.png").getImage() );
        this.getContentPane().add(tela_cadastrar);
    }

    private Finalizar_Venda()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_tel2 = new java.awt.Label();
        txt_tel2 = new java.awt.TextField();
        txt_tel1 = new java.awt.TextField();
        label_tel1 = new java.awt.Label();
        label_email = new java.awt.Label();
        txt_email = new java.awt.TextField();
        txt_cep = new java.awt.TextField();
        label_nome = new java.awt.Label();
        txt_nome = new java.awt.TextField();
        label_c = new java.awt.Label();
        label_rua = new java.awt.Label();
        txt_c = new java.awt.TextField();
        bt_voltar = new javax.swing.JButton();
        txt_rua = new java.awt.TextField();
        label_num = new java.awt.Label();
        txt_num = new java.awt.TextField();
        label_bairro = new java.awt.Label();
        label_cep = new java.awt.Label();
        txt_bairro = new java.awt.TextField();
        label_cor = new java.awt.Label();
        txt_cor = new java.awt.TextField();
        label_tpeca = new java.awt.Label();
        txt_tpeca = new java.awt.TextField();
        txt_qt_pecas = new java.awt.TextField();
        label_produtor = new java.awt.Label();
        txt_produto = new java.awt.TextField();
        label_valor = new java.awt.Label();
        txt_valor = new java.awt.TextField();
        label_fornecedor = new java.awt.Label();
        txt_fornecedor = new java.awt.TextField();
        label_tpeca1 = new java.awt.Label();
        bt_orcamento = new javax.swing.JButton();
        txt_valortotal = new java.awt.TextField();
        label_nome1 = new java.awt.Label();
        label_nome2 = new java.awt.Label();
        txt_pagamento = new javax.swing.JTextField();
        bt_venda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_tel2.setBackground(new java.awt.Color(20, 22, 121));
        label_tel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tel2.setForeground(new java.awt.Color(255, 255, 255));
        label_tel2.setText(" Telefone 2:");

        txt_tel2.setEditable(false);
        txt_tel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel2ActionPerformed(evt);
            }
        });

        txt_tel1.setEditable(false);
        txt_tel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel1ActionPerformed(evt);
            }
        });

        label_tel1.setBackground(new java.awt.Color(20, 22, 121));
        label_tel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tel1.setForeground(new java.awt.Color(255, 255, 255));
        label_tel1.setText(" Telefone:");

        label_email.setBackground(new java.awt.Color(20, 22, 121));
        label_email.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_email.setForeground(new java.awt.Color(255, 255, 255));
        label_email.setText(" E-mail:");

        txt_email.setEditable(false);
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        txt_cep.setEditable(false);
        txt_cep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cepActionPerformed(evt);
            }
        });

        label_nome.setBackground(new java.awt.Color(20, 22, 121));
        label_nome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_nome.setForeground(new java.awt.Color(255, 255, 255));
        label_nome.setText(" Nome:");

        txt_nome.setEditable(false);
        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });

        label_c.setBackground(new java.awt.Color(20, 22, 121));
        label_c.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_c.setForeground(new java.awt.Color(255, 255, 255));
        label_c.setText(" CPF/CNPJ:");

        label_rua.setBackground(new java.awt.Color(20, 22, 121));
        label_rua.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_rua.setForeground(new java.awt.Color(255, 255, 255));
        label_rua.setText(" Rua:");

        txt_c.setEditable(false);
        txt_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cActionPerformed(evt);
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

        txt_rua.setEditable(false);
        txt_rua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ruaActionPerformed(evt);
            }
        });

        label_num.setBackground(new java.awt.Color(20, 22, 121));
        label_num.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_num.setForeground(new java.awt.Color(255, 255, 255));
        label_num.setText(" Nº:");

        txt_num.setEditable(false);
        txt_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numActionPerformed(evt);
            }
        });

        label_bairro.setBackground(new java.awt.Color(20, 22, 121));
        label_bairro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_bairro.setForeground(new java.awt.Color(255, 255, 255));
        label_bairro.setText(" Bairro:");

        label_cep.setBackground(new java.awt.Color(20, 22, 121));
        label_cep.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_cep.setForeground(new java.awt.Color(255, 255, 255));
        label_cep.setText(" CEP:");

        txt_bairro.setEditable(false);
        txt_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bairroActionPerformed(evt);
            }
        });

        label_cor.setBackground(new java.awt.Color(20, 22, 121));
        label_cor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_cor.setForeground(new java.awt.Color(255, 255, 255));
        label_cor.setText(" Cor:");

        txt_cor.setEditable(false);
        txt_cor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_corActionPerformed(evt);
            }
        });

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

        txt_qt_pecas.setEditable(false);
        txt_qt_pecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_qt_pecasActionPerformed(evt);
            }
        });

        label_produtor.setBackground(new java.awt.Color(20, 22, 121));
        label_produtor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_produtor.setForeground(new java.awt.Color(255, 255, 255));
        label_produtor.setText(" Produto:");

        txt_produto.setEditable(false);
        txt_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_produtoActionPerformed(evt);
            }
        });

        label_valor.setBackground(new java.awt.Color(20, 22, 121));
        label_valor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_valor.setForeground(new java.awt.Color(255, 255, 255));
        label_valor.setText(" Valor do M2:");

        txt_valor.setEditable(false);
        txt_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valorActionPerformed(evt);
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

        label_tpeca1.setBackground(new java.awt.Color(20, 22, 121));
        label_tpeca1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tpeca1.setForeground(new java.awt.Color(255, 255, 255));
        label_tpeca1.setText(" ");

        bt_orcamento.setBackground(new java.awt.Color(20, 22, 121));
        bt_orcamento.setForeground(java.awt.Color.yellow);
        bt_orcamento.setText("Definir forma de pagamento:");
        bt_orcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_orcamentoActionPerformed(evt);
            }
        });

        txt_valortotal.setEditable(false);
        txt_valortotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valortotalActionPerformed(evt);
            }
        });

        label_nome1.setBackground(new java.awt.Color(20, 22, 121));
        label_nome1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_nome1.setForeground(new java.awt.Color(255, 255, 255));
        label_nome1.setText(" Valor Total:");

        label_nome2.setBackground(new java.awt.Color(20, 22, 121));
        label_nome2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_nome2.setForeground(new java.awt.Color(255, 255, 255));
        label_nome2.setText(" Venda para o Cliente:");

        txt_pagamento.setEditable(false);

        bt_venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/visuais_botao_venda.gif"))); // NOI18N
        bt_venda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 3));
        bt_venda.setPreferredSize(new java.awt.Dimension(366, 116));
        bt_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_vendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label_nome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(label_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(label_tpeca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_qt_pecas, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(label_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_tpeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(label_produtor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(txt_produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_rua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_bairro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_tel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_cep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_tel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_valor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_cor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_num, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_orcamento))
                                .addGap(69, 69, 69)
                                .addComponent(bt_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(label_nome2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(label_email, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_produtor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_qt_pecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_tpeca1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_num, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(label_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(label_c, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(label_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txt_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txt_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_cor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bt_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_orcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(816, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tel2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel2ActionPerformed
    {//GEN-HEADEREND:event_txt_tel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel2ActionPerformed

    private void txt_tel1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel1ActionPerformed
    {//GEN-HEADEREND:event_txt_tel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel1ActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_emailActionPerformed
    {//GEN-HEADEREND:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_cepActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_cepActionPerformed
    {//GEN-HEADEREND:event_txt_cepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cepActionPerformed

    private void txt_cActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_cActionPerformed
    {//GEN-HEADEREND:event_txt_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_voltarActionPerformed
    {//GEN-HEADEREND:event_bt_voltarActionPerformed
        Cadastro_Venda venda = new Cadastro_Venda();
        this.dispose();
        venda.setVisible(true);
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void txt_ruaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_ruaActionPerformed
    {//GEN-HEADEREND:event_txt_ruaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ruaActionPerformed

    private void txt_numActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_numActionPerformed
    {//GEN-HEADEREND:event_txt_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numActionPerformed

    private void txt_bairroActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_bairroActionPerformed
    {//GEN-HEADEREND:event_txt_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bairroActionPerformed

    private void txt_corActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_corActionPerformed
    {//GEN-HEADEREND:event_txt_corActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_corActionPerformed

    private void txt_tpecaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tpecaActionPerformed
    {//GEN-HEADEREND:event_txt_tpecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tpecaActionPerformed

    private void txt_qt_pecasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_qt_pecasActionPerformed
    {//GEN-HEADEREND:event_txt_qt_pecasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qt_pecasActionPerformed

    private void txt_produtoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_produtoActionPerformed
    {//GEN-HEADEREND:event_txt_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_produtoActionPerformed

    private void txt_valorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_valorActionPerformed
    {//GEN-HEADEREND:event_txt_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valorActionPerformed

    private void txt_fornecedorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_fornecedorActionPerformed
    {//GEN-HEADEREND:event_txt_fornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fornecedorActionPerformed

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_nomeActionPerformed
    {//GEN-HEADEREND:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void bt_orcamentoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_orcamentoActionPerformed
    {//GEN-HEADEREND:event_bt_orcamentoActionPerformed
 
        int i=2;
        String[] forma_pagamento = {"A vista", "Parcelado", "Parcelado no Cartão"}; 
        opcao_escolhida = JOptionPane.showOptionDialog(null, "Informe o tipo de pagamento:",null,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, forma_pagamento, forma_pagamento[0]); 
        
        if(opcao_escolhida==0)
        {
            n_parcelas=1;
            txt_pagamento.setText("Pagamento a vista de R$" + valor);
        }   
        else if(opcao_escolhida==1)
        {
            do{
                n_parcelas=Integer.parseInt(JOptionPane.showInputDialog(null,i+" vezes: "+valor/i+"\n"+(i+1)+" vezes: "+valor/(i+1)+"\n"+(i+2)+" vezes: "+valor/(i+2)+"\n"+(i+3)+" vezes: "+valor/(i+3)+"\n"+(i+4)+" vezes: "+valor/(i+4)+"\n"+(i+5)+" vezes: "+valor/(i+5)+"\n"+(i+6)+" vezes: "+valor/(i+6)+"\n"+(i+7)+" vezes: "+valor/(i+7)+"\n"+(i+8)+" vezes: "+valor/(i+8)+"\n"+(i+9)+" vezes: "+valor/(i+9)+"\n"+(i+10)+" vezes: "+valor/(i+10)+"\n\nInforme a quantidade de quantas vezes quer realizar o pagamento:"));
                if(n_parcelas>12 || n_parcelas<2)
                JOptionPane.showMessageDialog(null, "Numero de parcelas inválido!");
            }while(n_parcelas>12 || n_parcelas<2);
            txt_pagamento.setText("Parcelado em " + n_parcelas + " vezes"+" de R$"+valor/n_parcelas);
        }
        else if(opcao_escolhida==2)
        {
            do{
                n_parcelas=Integer.parseInt(JOptionPane.showInputDialog(null,i+" vezes: "+valor/i+"\n"+(i+1)+" vezes: "+valor/(i+1)+"\n"+(i+2)+" vezes: "+valor/(i+2)+"\n"+(i+3)+" vezes: "+valor/(i+3)+"\n"+(i+4)+" vezes: "+valor/(i+4)+"\n"+(i+5)+" vezes: "+valor/(i+5)+"\n"+(i+6)+" vezes: "+valor/(i+6)+"\n"+(i+7)+" vezes: "+valor/(i+7)+"\n"+(i+8)+" vezes: "+valor/(i+8)+"\n"+(i+9)+" vezes: "+valor/(i+9)+"\n"+(i+10)+" vezes: "+valor/(i+10)+"\n\nInforme a quantidade de quantas vezes quer realizar o pagamento:"));
                if(n_parcelas>12 || n_parcelas<1)
                JOptionPane.showMessageDialog(null, "Numero de parcelas inválido!");
            }while(n_parcelas>12 || n_parcelas<1);
            txt_pagamento.setText("Parcelado no Cartão em " + n_parcelas + " vezes"+" de R$"+valor/n_parcelas);
            
        }  
        else
        JOptionPane.showMessageDialog(null, "Nenhuma opção foi informada");
    }//GEN-LAST:event_bt_orcamentoActionPerformed

    private void txt_valortotalActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_valortotalActionPerformed
    {//GEN-HEADEREND:event_txt_valortotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valortotalActionPerformed

    private void bt_vendaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_vendaActionPerformed
    {//GEN-HEADEREND:event_bt_vendaActionPerformed
       
       if(!txt_pagamento.getText().equals(""))
       {
            try
            {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
                Date time = gera_data.gera_data();
                Venda nova_venda = new Venda();
                boolean sucesso=false;

                if(opcao_escolhida==0)
                sucesso=nova_venda.cadastro_banco(id_cliente,id_produto,nome_cliente,nome_produto,fornecedor,quantidade_comprada,valor,"A vista",n_parcelas,dateFormat.format(time),Double.parseDouble(txt_tpeca.getText()),Double.parseDouble(txt_valor.getText()));
                if(opcao_escolhida==1)
                sucesso=nova_venda.cadastro_banco(id_cliente,id_produto,nome_cliente,nome_produto,fornecedor,quantidade_comprada,valor,"Parcelado",n_parcelas,dateFormat.format(time),Double.parseDouble(txt_tpeca.getText()),Double.parseDouble(txt_valor.getText()));
                if(opcao_escolhida==2)
                sucesso=nova_venda.cadastro_banco(id_cliente,id_produto,nome_cliente,nome_produto,fornecedor,quantidade_comprada,valor,"Cartão Parcelado",n_parcelas,dateFormat.format(time),Double.parseDouble(txt_tpeca.getText()),Double.parseDouble(txt_valor.getText()));

                if(sucesso==true)
                {
                     nova_venda.atualiza_quantidade(quantidade_comprada,estoque_atual,Double.parseDouble(txt_tpeca.getText()));
                     JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
                     this.dispose();
                     Area_do_menu_vendas call = new Area_do_menu_vendas();
                     call.tela_vendas();
                }
                else
                JOptionPane.showMessageDialog(null, "Venda não realizada"); 
            }
            catch (Exception ex)
            { Logger.getLogger(Finalizar_Venda.class.getName()).log(Level.SEVERE, null, ex); }
       }
       else
       JOptionPane.showMessageDialog(null, "Informe como o pagamento será realizado!");
    }//GEN-LAST:event_bt_vendaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Finalizar_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Finalizar_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Finalizar_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Finalizar_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Finalizar_Venda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_orcamento;
    private javax.swing.JButton bt_venda;
    private javax.swing.JButton bt_voltar;
    private java.awt.Label label_bairro;
    private java.awt.Label label_c;
    private java.awt.Label label_cep;
    private java.awt.Label label_cor;
    private java.awt.Label label_email;
    private java.awt.Label label_fornecedor;
    private java.awt.Label label_nome;
    private java.awt.Label label_nome1;
    private java.awt.Label label_nome2;
    private java.awt.Label label_num;
    private java.awt.Label label_produtor;
    private java.awt.Label label_rua;
    private java.awt.Label label_tel1;
    private java.awt.Label label_tel2;
    private java.awt.Label label_tpeca;
    private java.awt.Label label_tpeca1;
    private java.awt.Label label_valor;
    private java.awt.TextField txt_bairro;
    private java.awt.TextField txt_c;
    private java.awt.TextField txt_cep;
    private java.awt.TextField txt_cor;
    private java.awt.TextField txt_email;
    private java.awt.TextField txt_fornecedor;
    private java.awt.TextField txt_nome;
    private java.awt.TextField txt_num;
    private javax.swing.JTextField txt_pagamento;
    private java.awt.TextField txt_produto;
    private java.awt.TextField txt_qt_pecas;
    private java.awt.TextField txt_rua;
    private java.awt.TextField txt_tel1;
    private java.awt.TextField txt_tel2;
    private java.awt.TextField txt_tpeca;
    private java.awt.TextField txt_valor;
    private java.awt.TextField txt_valortotal;
    // End of variables declaration//GEN-END:variables
}
