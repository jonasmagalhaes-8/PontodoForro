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
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
public class Lista_Select_Forro extends javax.swing.JDialog
{
    String sql="SELECT Forro.Codigo_Forro as Codigo_Forro,Forro.Codigo_Fornecedor as Codigo_Fornecedor,Forro.Nome_Forro as Nome,Fornecedores.Nome_Fornecedor as Fornecedor,Forro.Cor as Cor,Forro.Tamanho_Peca as Tamanho_Peca,Forro.Quantidade_Pecas as Quantidade_Pecas,Forro.Quantidade_Metro2 as QuantidadeM²,Forro.Valor_M2 as Valor_M² FROM Forro INNER JOIN Fornecedores on Forro.Codigo_Fornecedor=Fornecedores.Codigo_Fornecedor WHERE Forro.Nome_Forro like ?;",nome,cor,fornecedor;
    double tpeca,qt_forroM2,qt_forroPec,valorM2;
    int cod_forro,cod_fornecedor;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Lista_Select_Forro fecha_frame()
    {
        this.dispose();
        try
        { conexao.close(); }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null, e); }
        return null;
    }
    
    public Lista_Select_Forro()
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
        
        this.tblForro.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent me)
          {
            if (me.getClickCount() == 1)  // to detect doble click events
            {    
              JTable target = (JTable)me.getSource(); // select a row
              int row = target.getSelectedRow(); // select a column
              int column = target.getSelectedColumn(); // get the value of a row and column.
              cod_forro = (int) tblForro.getValueAt(row, 0);
              cod_fornecedor = (int) tblForro.getValueAt(row, 1);
              nome = (String) tblForro.getValueAt(row, 2);
              fornecedor = (String)tblForro.getValueAt(row, 3);
              cor = (String) tblForro.getValueAt(row, 4);
              tpeca = (double) tblForro.getValueAt(row, 5);
              qt_forroPec = (double) tblForro.getValueAt(row, 6);
              qt_forroM2 = (double) tblForro.getValueAt(row, 7);
              valorM2 = (double) tblForro.getValueAt(row, 8);
              fecha_frame();
            }
          }
        });  
    }
    private void pesquisar_forro()
    {
      try
      {
        conexao = ModuloConexao.conector();
        pst=conexao.prepareStatement(sql);
        pst.setString(1, this.txtCliPesquisar.getText() + "%");
        rs=pst.executeQuery();
        this.tblForro.setModel(DbUtils.resultSetToTableModel(rs));
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(null, e);}
    }
    
    private void show_forro()
    {
      String sql="SELECT Forro.Codigo_Forro as Codigo_Forro,Forro.Codigo_Fornecedor as Codigo_Fornecedor,Forro.Nome_Forro as Nome,Fornecedores.Nome_Fornecedor as Fornecedor,Forro.Cor as Cor,Forro.Tamanho_Peca as Tamanho_Peca,Forro.Quantidade_Pecas as Quantidade_Pecas,Forro.Quantidade_Metro2 as QuantidadeM²,Forro.Valor_M2 as Valor_M² FROM Forro INNER JOIN Fornecedores on Forro.Codigo_Fornecedor=Fornecedores.Codigo_Fornecedor;";
      try
      {
        conexao = ModuloConexao.conector();
        pst=conexao.prepareStatement(sql);
        rs=pst.executeQuery();
        this.tblForro.setModel(DbUtils.resultSetToTableModel(rs));
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(null, e);}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblForro = new javax.swing.JTable();
        txtCliPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tipo_busca = new javax.swing.JComboBox();
        bt_imprimirProdutos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(20, 22, 120));
        setBounds(new java.awt.Rectangle(0, 0, 8, 0));

        tblForro.setBackground(new java.awt.Color(240, 240, 240));
        tblForro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblForro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblForroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblForro);

        txtCliPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliPesquisarKeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(20, 22, 121));
        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Informe como deseja realizar a busca:");

        tipo_busca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Por Nome do Produto", "Por Codigo do Produto" }));
        tipo_busca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipo_buscaItemStateChanged(evt);
            }
        });

        bt_imprimirProdutos.setBackground(new java.awt.Color(20, 22, 121));
        bt_imprimirProdutos.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        bt_imprimirProdutos.setForeground(new java.awt.Color(240, 240, 240));
        bt_imprimirProdutos.setText("Imprimir Lista de Produtos");
        bt_imprimirProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirProdutosActionPerformed(evt);
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
                        .addComponent(bt_imprimirProdutos)
                        .addGap(19, 19, 19)
                        .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_imprimirProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCliPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(816, 628));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCliPesquisarKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtCliPesquisarKeyReleased
    {//GEN-HEADEREND:event_txtCliPesquisarKeyReleased
        pesquisar_forro();
    }//GEN-LAST:event_txtCliPesquisarKeyReleased

    private void tblForroMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tblForroMouseClicked
    {//GEN-HEADEREND:event_tblForroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblForroMouseClicked

    private void tipo_buscaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipo_buscaItemStateChanged
        Object selected = this.tipo_busca.getSelectedItem();
        if(selected.toString().equals("Por Nome do Produto"))
        sql="SELECT Forro.Codigo_Forro as Codigo_Forro,Forro.Codigo_Fornecedor as Codigo_Fornecedor,Forro.Nome_Forro as Nome,Fornecedores.Nome_Fornecedor as Fornecedor,Forro.Cor as Cor,Forro.Tamanho_Peca as Tamanho_Peca,Forro.Quantidade_Pecas as Quantidade_Pecas,Forro.Quantidade_Metro2 as QuantidadeM²,Forro.Valor_M2 as Valor_M² FROM Forro INNER JOIN Fornecedores on Forro.Codigo_Fornecedor=Fornecedores.Codigo_Fornecedor WHERE Forro.Nome_Forro like ?;";
        else
        sql="SELECT Forro.Codigo_Forro as Codigo_Forro,Forro.Codigo_Fornecedor as Codigo_Fornecedor,Forro.Nome_Forro as Nome,Fornecedores.Nome_Fornecedor as Fornecedor,Forro.Cor as Cor,Forro.Tamanho_Peca as Tamanho_Peca,Forro.Quantidade_Pecas as Quantidade_Pecas,Forro.Quantidade_Metro2 as QuantidadeM²,Forro.Valor_M2 as Valor_M² FROM Forro INNER JOIN Fornecedores on Forro.Codigo_Fornecedor=Fornecedores.Codigo_Fornecedor WHERE Forro.Codigo_Forro like ?;";
    }//GEN-LAST:event_tipo_buscaItemStateChanged

    private void bt_imprimirProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirProdutosActionPerformed
        conexao = ModuloConexao.conector();        // TODO add your handling code here:
        try
        { 
            JasperPrint imprimir = JasperFillManager.fillReport("reports/lista_produtos.jasper",null,conexao);
            JasperViewer.viewReport(imprimir,false);
            fecha_frame();
        }
        catch (Exception e)
        { JOptionPane.showMessageDialog(null,e); }
    }//GEN-LAST:event_bt_imprimirProdutosActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                Lista_Select_Forro dialog = new Lista_Select_Forro();
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
    private javax.swing.JButton bt_imprimirProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblForro;
    private javax.swing.JComboBox tipo_busca;
    private javax.swing.JTextField txtCliPesquisar;
    // End of variables declaration//GEN-END:variables
}
