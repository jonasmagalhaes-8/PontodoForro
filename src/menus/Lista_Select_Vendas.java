package menus;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.proteanit.sql.DbUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import banco.ModuloConexao;
public class Lista_Select_Vendas extends javax.swing.JDialog
{
    String cliente,produto,fornecedor,pagamento,data,sql="SELECT Vendas.N_venda as Codigo_Venda,Vendas.Cliente as Cliente,Vendas.Codigo_cliente as Cliente_Codigo,Vendas.Produto as Produto,Vendas.Codigo_Forro as Codigo_Forro,Vendas.Fornecedor as Fornecedor,Vendas.Data as Data,Preco_M2 as Valor_M2,Vendas.Valor_Total as Valor,Vendas.Pecas as Peças,Vendas.M2 as M2,Vendas.Parcelas as Parcelas,Vendas.Pagamento as Pagamento WHERE Vendas.Cliente like ?;";;
    double valor_total,qt_forroM2,valor_m2;
    int cod_venda,cod_forro,cod_fornecedor,cod_cliente,parcelas,qt_forroPec;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Lista_Select_Vendas fecha_frame()
    {
        this.dispose();
        try
        { conexao.close(); }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null, e); }
        return null;
    }
    
    public Lista_Select_Vendas()
    {
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
        Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        this.setBounds(bounds);
        Background_image tela_acessar = new Background_image
        ( new ImageIcon("src/imagens/visuais_busca_1.png").getImage() );
        this.getContentPane().add(tela_acessar);
        show_forro();
        
        this.tblVendas.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent me)
          {
            if (me.getClickCount() == 1)  // to detect doble click events
            {    
              JTable target = (JTable)me.getSource(); // select a row
              int row = target.getSelectedRow(); // select a column
              int column = target.getSelectedColumn(); // get the value of a row and column.
              cod_venda = (int) tblVendas.getValueAt(row, 0);
              cliente = (String) tblVendas.getValueAt(row, 1);
              cod_cliente = (int) tblVendas.getValueAt(row, 2);
              produto = (String) tblVendas.getValueAt(row, 3);
              cod_forro = (int) tblVendas.getValueAt(row, 4);
              fornecedor = (String)tblVendas.getValueAt(row, 5);
              data = (String) tblVendas.getValueAt(row, 6); 
              valor_m2 = (double) tblVendas.getValueAt(row, 7);
              valor_total = (double) tblVendas.getValueAt(row, 8);
              qt_forroPec = (int) tblVendas.getValueAt(row, 9);
              qt_forroM2 = (double) tblVendas.getValueAt(row, 10);
              parcelas = (int) tblVendas.getValueAt(row, 11);
              pagamento = (String) tblVendas.getValueAt(row, 12);              
              fecha_frame();
            }
          }
        });  
    }
    private void pesquisar_forro()
    {
      //String sql="SELECT Vendas.N_venda as Codigo_Venda,Vendas.Cliente as Cliente,Vendas.Codigo_cliente as Cliente_Codigo,Vendas.Produto as Produto,Vendas.Codigo_Forro as Codigo_Forro,Vendas.Fornecedor as Fornecedor,Vendas.Data as Data,Preco_M2 as Valor_M2,Vendas.Valor_Total as Valor,Vendas.Pecas as Peças,Vendas.M2 as M2,Vendas.Parcelas as Parcelas,Vendas.Pagamento as Pagamento;";
      try
      {
        conexao = ModuloConexao.conector();
        pst=conexao.prepareStatement(sql);
        pst.setString(1, this.txtCliPesquisar.getText() + "%");
        rs=pst.executeQuery();
        this.tblVendas.setModel(DbUtils.resultSetToTableModel(rs));
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(null, e);}
    }
    
    private void show_forro()
    {
      String sql="SELECT Vendas.N_venda as Codigo_Venda,Vendas.Cliente as Cliente,Vendas.Codigo_cliente as Cliente_Codigo,Vendas.Produto as Produto,Vendas.Codigo_Forro as Codigo_Forro,Vendas.Fornecedor as Fornecedor,Vendas.Data as Data,Preco_M2 as Valor_M2,Vendas.Valor_Total as Valor,Vendas.Pecas as Peças,Vendas.M2 as M2,Vendas.Parcelas as Parcelas,Vendas.Pagamento as Pagamento FROM Vendas;";
      //String sql="SELECT Vendas.Codigo_Forro as Codigo_Forro,Vendas.Codigo_Fornecedor as Codigo_Fornecedor,Vendas.Nome_Forro as Nome,Fornecedores.Nome_Fornecedor as Fornecedor,Vendas.Cor as Cor,Vendas.Tamanho_Peca as Tamanho_Peca,Vendas.Quantidade_Pecas as Quantidade_Pecas,Vendas.Quantidade_Metro2 as QuantidadeM²,Vendas.Valor_M2 as Valor_M² FROM Forro INNER JOIN Fornecedores on Vendas.Codigo_Fornecedor=Fornecedores.Codigo_Fornecedor;";
      try
      {
        conexao = ModuloConexao.conector();
        pst=conexao.prepareStatement(sql);
        rs=pst.executeQuery();
        this.tblVendas.setModel(DbUtils.resultSetToTableModel(rs));
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(null, e);}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        txtCliPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tipo_busca = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(20, 22, 120));
        setBounds(new java.awt.Rectangle(0, 0, 8, 0));

        tblVendas.setBackground(new java.awt.Color(240, 240, 240));
        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVendas);

        txtCliPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliPesquisarActionPerformed(evt);
            }
        });
        txtCliPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliPesquisarKeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(20, 22, 121));
        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Informe como deseja realizar a busca:");

        tipo_busca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Por Nome do Cliente", "Por Numero da Venda" }));
        tipo_busca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipo_buscaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tipo_busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(tipo_busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(816, 628));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCliPesquisarKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtCliPesquisarKeyReleased
    {//GEN-HEADEREND:event_txtCliPesquisarKeyReleased
        pesquisar_forro();
        //pesquisar_forro();
    }//GEN-LAST:event_txtCliPesquisarKeyReleased

    private void tblVendasMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tblVendasMouseClicked
    {//GEN-HEADEREND:event_tblVendasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblVendasMouseClicked

    private void txtCliPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliPesquisarActionPerformed

    private void tipo_buscaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipo_buscaItemStateChanged
        Object selected = this.tipo_busca.getSelectedItem();
        if(selected.toString().equals("Por Nome do Cliente"))
        sql="SELECT Vendas.N_venda as Codigo_Venda,Vendas.Cliente as Cliente,Vendas.Codigo_cliente as Cliente_Codigo,Vendas.Produto as Produto,Vendas.Codigo_Forro as Codigo_Forro,Vendas.Fornecedor as Fornecedor,Vendas.Data as Data,Preco_M2 as Valor_M2,Vendas.Valor_Total as Valor,Vendas.Pecas as Peças,Vendas.M2 as M2,Vendas.Parcelas as Parcelas,Vendas.Pagamento as Pagamento WHERE Vendas.Cliente like ?;";
        else
        sql="SELECT Vendas.N_venda as Codigo_Venda,Vendas.Cliente as Cliente,Vendas.Codigo_cliente as Cliente_Codigo,Vendas.Produto as Produto,Vendas.Codigo_Forro as Codigo_Forro,Vendas.Fornecedor as Fornecedor,Vendas.Data as Data,Preco_M2 as Valor_M2,Vendas.Valor_Total as Valor,Vendas.Pecas as Peças,Vendas.M2 as M2,Vendas.Parcelas as Parcelas,Vendas.Pagamento as Pagamento WHERE Vendas.N_venda like ?;";
    }//GEN-LAST:event_tipo_buscaItemStateChanged

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                Lista_Select_Vendas dialog = new Lista_Select_Vendas();
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVendas;
    private javax.swing.JComboBox tipo_busca;
    private javax.swing.JTextField txtCliPesquisar;
    // End of variables declaration//GEN-END:variables
}
