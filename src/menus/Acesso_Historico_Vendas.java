package menus;

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
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import venda_CRUD.Delete_venda;

public class Acesso_Historico_Vendas extends javax.swing.JFrame
{
    public Acesso_Historico_Vendas fechar()
    {   
        this.dispose();
        return null;
    }
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int pecas_compradas,id_venda/*,id_cliente=0,id_forro=0*/;
    double m2_comprado;
    String nome,email,cnpj,rua,num,localizacao,bairro,cep,telefone1,telefone2;//,forma_pagamento,parcelamento,data;
    //double pecas_compradas,m2_comprado,valor_total;
    //preenche_dados(id_venda, id_forro, id_cliente, pecas_compradas, m2_comprado, valor_total, forma_pagamento, parcelamento,data)
    //preenche_dados(id_venda, historico_vendas.cod_forro, historico_vendas.cod_cliente, historico_vendas.qt_forroPec, historico_vendas.qt_forroM2, historico_vendas.valor_total, historico_vendas.pagamento, historico_vendas.parcelas,historico_vendas.data);
    public Acesso_Historico_Vendas preenche_dados(int id_forro,int id_cliente,int pecas_compradas,double m2_comprado,double valor_total,String forma_pagamento,int parcelamento,String data,String fornecedor,double valor_m2,String produto)
    {
        Object selected = this.tipo_venda_quantidade.getSelectedItem();
        
        if(selected.toString().equals(" Qtd vendida em peças:"))
        txt_qt_pecas.setText(String.valueOf(pecas_compradas));
        else
        txt_qt_pecas.setText(String.valueOf(m2_comprado));
        
        txt_valortotal.setText(String.valueOf(valor_total));
        txt_pagamento.setText(forma_pagamento);
        txt_parcelamento.setText(String.valueOf(parcelamento));
        txt_data.setText(data);
        txt_fornecedor.setText(fornecedor);
        txt_valor.setText(String.valueOf(valor_m2));
        txt_produto.setText(produto);
        
        //String sql="select * from Clientes where Codigo_Cliente=?";
        String sql="SELECT clientes.Codigo_Cliente as Codigo,clientes.Nome_Cliente as Nome,clientes.Email_Cliente as Email,clientes.CPF_Cliente as CPF,CNPJ_CLiente as CNPJ,endereco_cliente.Nome_rua as Rua,endereco_cliente.Num_Rua as Nº,endereco_cliente.Bairro as Bairro,endereco_cliente.CEP as CEP,telefones_cliente.Num_telefone1 as Tel1,Num_telefone2 as Tel2 FROM clientes INNER JOIN endereco_cliente on clientes.Codigo_Cliente = ? INNER JOIN telefones_cliente on clientes.Codigo_cliente=?;";
        //String de instrução SQL para buscar (select) no Banco de Dados na tabela "tb_login" dados do campo onde (where) login e senha sejam iguais aos argumentos que serão passados (utiliza-se o ? para indicar que um argumento será utilizado na instrução)  
        try
        {
          pst = conexao.prepareStatement(sql); //Abre-se uma conexão com o Banco de Dados juntamente com a passagem da instrução sql anteriormente informada
          pst.setInt(1, id_cliente);
          pst.setInt(2, id_cliente);
          //em "setString" passa-se como argumento para busca no Banco de maneira respectiva a instrução SQL a instrução que será enviada ao Banco, neste caso será utilizado a string do campo login digitado e extraida atráves da função .getText para que uma busca seja realizada
          rs = pst.executeQuery(); //rs recebe e armazena o resultado das instruções preparadas anteriormente e enviadas com a função executeQuery
          if(rs.next()) // Aqui é realizada a verificação da condição do rs/Result Set, onde um cursor percorre a tabela do banco de dados e enquanto a função .next retornar true o cursor é deslocado pro próximo registro.Quando o retorno chegar ao fim, a condição retorna false e não existem mais registros na tabela.
          {
            txt_nome.setText(rs.getString(2)); //Armazena-se na string criada o dado presente na 3ª coluna da tabela, neste caso, o campo onde encontra-se os logins existentes na tabela  
            txt_email.setText(rs.getString(3));
            
            String cpf = rs.getString(4);
            String cnpj = rs.getString(5);
            
            if(cpf.length()==0)
            {
                if(cnpj.length()!=0)
                txt_c.setText(cnpj);
                else
                txt_c.setText("");    
            }
            else
            txt_c.setText(cpf);
            
            txt_rua.setText(rs.getString(6));
            txt_num.setText(rs.getString(7));
            txt_bairro.setText(rs.getString(8));
            txt_cep.setText(rs.getString(9));
            txt_tel1.setText(rs.getString(10));
            txt_tel2.setText(rs.getString(11));
          }
        }
        catch (Exception e)
        { JOptionPane.showMessageDialog(null, e); }
        
        sql="SELECT Forro.Cor as Cor,Forro.Tamanho_Peca as Tamanho_Peca FROM Forro where Forro.Codigo_Forro=?";
        //String de instrução SQL para buscar (select) no Banco de Dados na tabela "tb_login" dados do campo onde (where) login e senha sejam iguais aos argumentos que serão passados (utiliza-se o ? para indicar que um argumento será utilizado na instrução)  
        try
        {
          pst = conexao.prepareStatement(sql); //Abre-se uma conexão com o Banco de Dados juntamente com a passagem da instrução sql anteriormente informada
          pst.setInt(1, id_forro);
          //em "setString" passa-se como argumento para busca no Banco de maneira respectiva a instrução SQL a instrução que será enviada ao Banco, neste caso será utilizado a string do campo login digitado e extraida atráves da função .getText para que uma busca seja realizada
          rs = pst.executeQuery(); //rs recebe e armazena o resultado das instruções preparadas anteriormente e enviadas com a função executeQuery
          if(rs.next()) // Aqui é realizada a verificação da condição do rs/Result Set, onde um cursor percorre a tabela do banco de dados e enquanto a função .next retornar true o cursor é deslocado pro próximo registro.Quando o retorno chegar ao fim, a condição retorna false e não existem mais registros na tabela.
          {
            txt_cor.setText(rs.getString(1)); //Armazena-se na string criada o dado presente na 3ª coluna da tabela, neste caso, o campo onde encontra-se os logins existentes na tabela  
            txt_tpeca.setText(rs.getString(2));
          }
        }
        catch (Exception e)
        { JOptionPane.showMessageDialog(null, e); }
        
        return null;
    }
    
    public Acesso_Historico_Vendas()
    {
        initComponents();
        
        Icon icone_excluir = new ImageIcon("src/imagens/visuais_botao_excluir.gif");
        JButton bt_excluir = new JButton(icone_excluir);
        bt_excluir.setBounds(414, 149, 106, 46);

        JButton bt_tabela = new JButton("Exibir histórico de Vendas"); 
        bt_tabela.setBounds(218, 485, 366 , 116);
        
        bt_voltar.setBackground(Color.decode("#141679"));
        bt_voltar.setForeground(Color.yellow);  

        this.getContentPane().add(bt_voltar);
        this.getContentPane().add(bt_excluir);
        this.getContentPane().add(bt_tabela);
        
        Background_image tela_acessar = new Background_image
        ( new ImageIcon("src/imagens/visuais_acesso_vendas.png").getImage() );
        
        this.getContentPane().add(tela_acessar);
        
        bt_tabela.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent me)
          { 
            conexao = ModuloConexao.conector();
            
            Lista_Select_Vendas historico_vendas = new Lista_Select_Vendas();
            
            historico_vendas.setVisible(true);
            
            id_venda = historico_vendas.cod_venda;
            pecas_compradas = historico_vendas.qt_forroPec;
            m2_comprado = historico_vendas.qt_forroM2;
            preenche_dados(historico_vendas.cod_forro, historico_vendas.cod_cliente, pecas_compradas, m2_comprado, historico_vendas.valor_total, historico_vendas.pagamento, historico_vendas.parcelas,historico_vendas.data,historico_vendas.fornecedor,historico_vendas.valor_m2,historico_vendas.produto);
            
          }
        }
                                   );
               
        bt_excluir.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent me)
          { 
            if(id_venda>0)
            {
              Delete_venda exclusao = new Delete_venda();
              exclusao.setId(id_venda);
              /*int excluiu=exclusao.delete();
              
              if(excluiu==1)
              {
                JOptionPane.showMessageDialog(null, "Exclusão realizada!");
                id_venda = 0;
                fechar();
                Area_do_Submenu_vendas vendas = new Area_do_Submenu_vendas();
                vendas.area_vendas();
              }*/
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

        txt_valortotal = new java.awt.TextField();
        bt_voltar = new javax.swing.JButton();
        txt_c = new java.awt.TextField();
        label_rua = new java.awt.Label();
        label_c = new java.awt.Label();
        txt_nome = new java.awt.TextField();
        label_cep = new java.awt.Label();
        txt_bairro = new java.awt.TextField();
        label_nome1 = new java.awt.Label();
        txt_num = new java.awt.TextField();
        label_nome2 = new java.awt.Label();
        label_bairro = new java.awt.Label();
        txt_rua = new java.awt.TextField();
        label_num = new java.awt.Label();
        txt_tel1 = new java.awt.TextField();
        txt_cor = new java.awt.TextField();
        txt_tel2 = new java.awt.TextField();
        label_cor = new java.awt.Label();
        txt_tpeca = new java.awt.TextField();
        label_tpeca = new java.awt.Label();
        label_tel2 = new java.awt.Label();
        label_email = new java.awt.Label();
        txt_email = new java.awt.TextField();
        txt_qt_pecas = new java.awt.TextField();
        label_produtor = new java.awt.Label();
        txt_cep = new java.awt.TextField();
        txt_produto = new java.awt.TextField();
        label_nome = new java.awt.Label();
        label_valor = new java.awt.Label();
        txt_valor = new java.awt.TextField();
        label_fornecedor = new java.awt.Label();
        txt_fornecedor = new java.awt.TextField();
        label_tel1 = new java.awt.Label();
        tipo_venda_quantidade = new javax.swing.JComboBox();
        label_data = new java.awt.Label();
        txt_data = new java.awt.TextField();
        label_parcelamento = new java.awt.Label();
        txt_parcelamento = new java.awt.TextField();
        label_pagamento = new java.awt.Label();
        txt_pagamento = new java.awt.TextField();
        bt_imprimirProdutos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txt_valortotal.setEditable(false);
        txt_valortotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valortotalActionPerformed(evt);
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

        txt_c.setEditable(false);
        txt_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cActionPerformed(evt);
            }
        });

        label_rua.setBackground(new java.awt.Color(20, 22, 121));
        label_rua.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_rua.setForeground(new java.awt.Color(255, 255, 255));
        label_rua.setText(" Rua:");

        label_c.setBackground(new java.awt.Color(20, 22, 121));
        label_c.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_c.setForeground(new java.awt.Color(255, 255, 255));
        label_c.setText(" CPF/CNPJ:");

        txt_nome.setEditable(false);
        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });

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

        label_nome1.setBackground(new java.awt.Color(20, 22, 121));
        label_nome1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_nome1.setForeground(new java.awt.Color(255, 255, 255));
        label_nome1.setText(" Valor Total:");

        txt_num.setEditable(false);
        txt_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numActionPerformed(evt);
            }
        });

        label_nome2.setBackground(new java.awt.Color(20, 22, 121));
        label_nome2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_nome2.setForeground(new java.awt.Color(255, 255, 255));
        label_nome2.setText(" Venda para o Cliente:");

        label_bairro.setBackground(new java.awt.Color(20, 22, 121));
        label_bairro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_bairro.setForeground(new java.awt.Color(255, 255, 255));
        label_bairro.setText(" Bairro:");

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

        txt_tel1.setEditable(false);
        txt_tel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel1ActionPerformed(evt);
            }
        });

        txt_cor.setEditable(false);
        txt_cor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_corActionPerformed(evt);
            }
        });

        txt_tel2.setEditable(false);
        txt_tel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel2ActionPerformed(evt);
            }
        });

        label_cor.setBackground(new java.awt.Color(20, 22, 121));
        label_cor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_cor.setForeground(new java.awt.Color(255, 255, 255));
        label_cor.setText(" Cor:");

        txt_tpeca.setEditable(false);
        txt_tpeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tpecaActionPerformed(evt);
            }
        });

        label_tpeca.setBackground(new java.awt.Color(20, 22, 121));
        label_tpeca.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tpeca.setForeground(new java.awt.Color(255, 255, 255));
        label_tpeca.setText(" Tamanho da peça:");

        label_tel2.setBackground(new java.awt.Color(20, 22, 121));
        label_tel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tel2.setForeground(new java.awt.Color(255, 255, 255));
        label_tel2.setText(" Telefone 2:");

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

        txt_cep.setEditable(false);
        txt_cep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cepActionPerformed(evt);
            }
        });

        txt_produto.setEditable(false);
        txt_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_produtoActionPerformed(evt);
            }
        });

        label_nome.setBackground(new java.awt.Color(20, 22, 121));
        label_nome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_nome.setForeground(new java.awt.Color(255, 255, 255));
        label_nome.setText(" Nome:");

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

        label_tel1.setBackground(new java.awt.Color(20, 22, 121));
        label_tel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_tel1.setForeground(new java.awt.Color(255, 255, 255));
        label_tel1.setText(" Telefone:");

        tipo_venda_quantidade.setBackground(new java.awt.Color(20, 22, 121));
        tipo_venda_quantidade.setForeground(new java.awt.Color(240, 240, 240));
        tipo_venda_quantidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " Qtd vendida em peças:", " Qtd vendida em M²:" }));
        tipo_venda_quantidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipo_venda_quantidadeItemStateChanged(evt);
            }
        });
        tipo_venda_quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_venda_quantidadeActionPerformed(evt);
            }
        });

        label_data.setBackground(new java.awt.Color(20, 22, 121));
        label_data.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_data.setForeground(new java.awt.Color(255, 255, 255));
        label_data.setText(" Data:");

        txt_data.setEditable(false);
        txt_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dataActionPerformed(evt);
            }
        });

        label_parcelamento.setBackground(new java.awt.Color(20, 22, 121));
        label_parcelamento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_parcelamento.setForeground(new java.awt.Color(255, 255, 255));
        label_parcelamento.setText(" Parcelas:");

        txt_parcelamento.setEditable(false);
        txt_parcelamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_parcelamentoActionPerformed(evt);
            }
        });

        label_pagamento.setBackground(new java.awt.Color(20, 22, 121));
        label_pagamento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        label_pagamento.setForeground(new java.awt.Color(255, 255, 255));
        label_pagamento.setText(" Pagamento:");

        txt_pagamento.setEditable(false);
        txt_pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pagamentoActionPerformed(evt);
            }
        });

        bt_imprimirProdutos.setBackground(new java.awt.Color(20, 22, 121));
        bt_imprimirProdutos.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        bt_imprimirProdutos.setForeground(new java.awt.Color(240, 240, 240));
        bt_imprimirProdutos.setText("imprimir Nota");
        bt_imprimirProdutos.setPreferredSize(new java.awt.Dimension(106, 46));
        bt_imprimirProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirProdutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_produtor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_tel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_bairro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_rua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipo_venda_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_parcelamento, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(txt_valortotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(txt_qt_pecas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tpeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(label_parcelamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(txt_c, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_cor, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_data, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txt_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_imprimirProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label_produtor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_tpeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tipo_venda_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_qt_pecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txt_valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label_parcelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txt_parcelamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label_num, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(label_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label_c, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(label_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(txt_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_cor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_fornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label_data, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txt_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(bt_imprimirProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 155, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(816, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_valortotalActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_valortotalActionPerformed
    {//GEN-HEADEREND:event_txt_valortotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valortotalActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_voltarActionPerformed
    {//GEN-HEADEREND:event_bt_voltarActionPerformed
        Area_do_Submenu_vendas vendas = new Area_do_Submenu_vendas();
        this.dispose();
        vendas.area_vendas();
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void txt_cActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_cActionPerformed
    {//GEN-HEADEREND:event_txt_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cActionPerformed

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_nomeActionPerformed
    {//GEN-HEADEREND:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void txt_bairroActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_bairroActionPerformed
    {//GEN-HEADEREND:event_txt_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bairroActionPerformed

    private void txt_numActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_numActionPerformed
    {//GEN-HEADEREND:event_txt_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numActionPerformed

    private void txt_ruaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_ruaActionPerformed
    {//GEN-HEADEREND:event_txt_ruaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ruaActionPerformed

    private void txt_tel1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel1ActionPerformed
    {//GEN-HEADEREND:event_txt_tel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel1ActionPerformed

    private void txt_corActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_corActionPerformed
    {//GEN-HEADEREND:event_txt_corActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_corActionPerformed

    private void txt_tel2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel2ActionPerformed
    {//GEN-HEADEREND:event_txt_tel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel2ActionPerformed

    private void txt_tpecaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tpecaActionPerformed
    {//GEN-HEADEREND:event_txt_tpecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tpecaActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_emailActionPerformed
    {//GEN-HEADEREND:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_qt_pecasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_qt_pecasActionPerformed
    {//GEN-HEADEREND:event_txt_qt_pecasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qt_pecasActionPerformed

    private void txt_cepActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_cepActionPerformed
    {//GEN-HEADEREND:event_txt_cepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cepActionPerformed

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

    private void tipo_venda_quantidadeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tipo_venda_quantidadeActionPerformed
    {//GEN-HEADEREND:event_tipo_venda_quantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipo_venda_quantidadeActionPerformed

    private void txt_dataActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_dataActionPerformed
    {//GEN-HEADEREND:event_txt_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataActionPerformed

    private void txt_parcelamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_parcelamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_parcelamentoActionPerformed

    private void txt_pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pagamentoActionPerformed

    private void tipo_venda_quantidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipo_venda_quantidadeItemStateChanged
        // TODO add your handling code here:
        Object selected = this.tipo_venda_quantidade.getSelectedItem();
        if(selected.toString().equals(" Qtd vendida em peças:"))
        txt_qt_pecas.setText(String.valueOf(String.valueOf(pecas_compradas)));
        else
        txt_qt_pecas.setText(String.valueOf(String.valueOf(m2_comprado)));
    }//GEN-LAST:event_tipo_venda_quantidadeItemStateChanged

    private void bt_imprimirProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirProdutosActionPerformed
        if(id_venda>0)
        {
            conexao = ModuloConexao.conector();        // TODO add your handling code here:
            try
            {
                HashMap filtro = new HashMap();
                filtro.put("N_Venda",id_venda);
                JasperPrint imprimir = JasperFillManager.fillReport("reports/Nota_Venda.jasper",filtro,conexao);
                JasperViewer.viewReport(imprimir,false);
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }
        else
        JOptionPane.showMessageDialog(null, "Selecione uma venda previamente realizada!");
    }//GEN-LAST:event_bt_imprimirProdutosActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Acesso_Historico_Vendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_imprimirProdutos;
    private javax.swing.JButton bt_voltar;
    private java.awt.Label label_bairro;
    private java.awt.Label label_c;
    private java.awt.Label label_cep;
    private java.awt.Label label_cor;
    private java.awt.Label label_data;
    private java.awt.Label label_email;
    private java.awt.Label label_fornecedor;
    private java.awt.Label label_nome;
    private java.awt.Label label_nome1;
    private java.awt.Label label_nome2;
    private java.awt.Label label_num;
    private java.awt.Label label_pagamento;
    private java.awt.Label label_parcelamento;
    private java.awt.Label label_produtor;
    private java.awt.Label label_rua;
    private java.awt.Label label_tel1;
    private java.awt.Label label_tel2;
    private java.awt.Label label_tpeca;
    private java.awt.Label label_valor;
    private javax.swing.JComboBox tipo_venda_quantidade;
    private java.awt.TextField txt_bairro;
    private java.awt.TextField txt_c;
    private java.awt.TextField txt_cep;
    private java.awt.TextField txt_cor;
    private java.awt.TextField txt_data;
    private java.awt.TextField txt_email;
    private java.awt.TextField txt_fornecedor;
    private java.awt.TextField txt_nome;
    private java.awt.TextField txt_num;
    private java.awt.TextField txt_pagamento;
    private java.awt.TextField txt_parcelamento;
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
