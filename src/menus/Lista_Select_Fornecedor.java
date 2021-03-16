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
public class Lista_Select_Fornecedor extends javax.swing.JDialog
{
    String sql="SELECT fornecedores.Codigo_fornecedor as Codigo,fornecedores.Nome_fornecedor as Nome,fornecedores.Email_fornecedor as Email,fornecedores.CNPJ_fornecedor as CNPJ,fornecedores.Inscricao as Inscricao,endereco_fornecedor.localizacao as Localizacao,endereco_fornecedor.Nome_rua as Rua,endereco_fornecedor.Num_Rua as Nº,endereco_fornecedor.Bairro as Bairro,endereco_fornecedor.CEP as CEP,telefones_fornecedor.Num_telefone1 as Tel1,telefones_fornecedor.Num_telefone2 as Tel2, Representante_Fornecedor.Nome_Representante as Representante, Representante_Fornecedor.Codigo_Representante as Rep_Codigo,Representante_Fornecedor.Email_Representante as Rep_Email, Representante_Fornecedor_Telefone.Num_Telefone1 as Rep_Telefone1,Representante_Fornecedor_Telefone.Num_Telefone2 as Rep_Telefone2 FROM fornecedores INNER JOIN endereco_fornecedor on fornecedores.Codigo_fornecedor = endereco_fornecedor.Codigo_fornecedor INNER JOIN telefones_fornecedor on fornecedores.Codigo_fornecedor=telefones_fornecedor.Codigo_fornecedor INNER JOIN Representante_Fornecedor on fornecedores.Codigo_fornecedor=Representante_Fornecedor.Codigo_fornecedor INNER JOIN Representante_Fornecedor_Telefone on Representante_Fornecedor.Codigo_Representante=Representante_Fornecedor_Telefone.Codigo_Representante WHERE fornecedores.Nome_fornecedor like ?;",nome="",rua="",num="",bairro="",cep="",email="",telefone1="",telefone2="",cnpj="",inscricao="",localizacao="",representante="",representante_telefone1="",representante_telefone2="",representante_email="";
    int id,representante_id;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Lista_Select_Fornecedor fecha_frame()
    {
        this.dispose();
        try
        { conexao.close(); }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null, e); }
        return null;
    }
    
    public Lista_Select_Fornecedor()
    {
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
        Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        this.setBounds(bounds);
        Background_image tela_acessar = new Background_image
        ( new ImageIcon("src/imagens/visuais_busca_1.png").getImage() );
        this.getContentPane().add(tela_acessar);
        show_fornecedor("SELECT fornecedores.Codigo_fornecedor as Codigo,fornecedores.Nome_fornecedor as Nome,fornecedores.Email_fornecedor as Email,fornecedores.CNPJ_fornecedor as CNPJ,fornecedores.Inscricao as Inscricao,endereco_fornecedor.localizacao as Localizacao,endereco_fornecedor.Nome_rua as Rua,endereco_fornecedor.Num_Rua as Nº,endereco_fornecedor.Bairro as Bairro,endereco_fornecedor.CEP as CEP,telefones_fornecedor.Num_telefone1 as Tel1,telefones_fornecedor.Num_telefone2 as Tel2, Representante_Fornecedor.Nome_Representante as Representante, Representante_Fornecedor.Codigo_Representante as Rep_Codigo,Representante_Fornecedor.Email_Representante as Rep_Email, Representante_Fornecedor_Telefone.Num_Telefone1 as Rep_Telefone1,Representante_Fornecedor_Telefone.Num_Telefone2 as Rep_Telefone2 FROM fornecedores INNER JOIN endereco_fornecedor on fornecedores.Codigo_fornecedor = endereco_fornecedor.Codigo_fornecedor INNER JOIN telefones_fornecedor on fornecedores.Codigo_fornecedor=telefones_fornecedor.Codigo_fornecedor INNER JOIN Representante_Fornecedor on fornecedores.Codigo_fornecedor=Representante_Fornecedor.Codigo_fornecedor INNER JOIN Representante_Fornecedor_Telefone on Representante_Fornecedor.Codigo_Representante=Representante_Fornecedor_Telefone.Codigo_Representante;");
        
      this.tblfornecedores.addMouseListener(new MouseAdapter()
      {
        public void mouseClicked(MouseEvent me)
        {
          if (me.getClickCount() == 1)  // to detect doble click events
          {    
            JTable target = (JTable)me.getSource(); // select a row
            int row = target.getSelectedRow(); // select a column
            int column = target.getSelectedColumn(); // get the value of a row and column.
            id = (int) tblfornecedores.getValueAt(row, 0);
            nome = (String) tblfornecedores.getValueAt(row, 1);
            email = (String) tblfornecedores.getValueAt(row, 2);
            cnpj = (String) tblfornecedores.getValueAt(row, 3);
            inscricao = (String) tblfornecedores.getValueAt(row, 4);
            localizacao = (String) tblfornecedores.getValueAt(row, 5);
            rua = (String) tblfornecedores.getValueAt(row, 6);
            num = (String) tblfornecedores.getValueAt(row, 7);
            bairro = (String) tblfornecedores.getValueAt(row, 8);
            cep = (String) tblfornecedores.getValueAt(row, 9);
            telefone1 = (String) tblfornecedores.getValueAt(row, 10);
            telefone2 = (String) tblfornecedores.getValueAt(row, 11);
            representante = (String) tblfornecedores.getValueAt(row, 12);
            representante_id = (int) tblfornecedores.getValueAt(row, 13);
            representante_email = (String) tblfornecedores.getValueAt(row, 14);
            representante_telefone1 = (String) tblfornecedores.getValueAt(row, 15);
            representante_telefone2 = (String) tblfornecedores.getValueAt(row, 16);
            fecha_frame();
          }
        }
      });  
    }
    private void pesquisar_fornecedor()
    {
      try
      {
        conexao = ModuloConexao.conector();
        pst=conexao.prepareStatement(sql);
        pst.setString(1, this.txtForPesquisar.getText() + "%");
        rs=pst.executeQuery();
        this.tblfornecedores.setModel(DbUtils.resultSetToTableModel(rs));
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(null, e);}
    }
    
    private void show_fornecedor(String sql)
    {
      try
      {
        conexao = ModuloConexao.conector();
        pst=conexao.prepareStatement(sql);
        rs=pst.executeQuery();
        this.tblfornecedores.setModel(DbUtils.resultSetToTableModel(rs));
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(null, e);}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblfornecedores = new javax.swing.JTable();
        txtForPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tipo_busca = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(20, 22, 120));
        setBounds(new java.awt.Rectangle(0, 0, 8, 0));
        setForeground(new java.awt.Color(20, 22, 120));

        tblfornecedores.setBackground(new java.awt.Color(240, 240, 240));
        tblfornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblfornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblfornecedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblfornecedores);

        txtForPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtForPesquisarKeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(20, 22, 121));
        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Informe como deseja realizar a busca:");

        tipo_busca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Por Nome do Fornecedor", "Por CNPJ" }));
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
                        .addComponent(txtForPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(txtForPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(816, 628));
    }// </editor-fold>//GEN-END:initComponents

    private void txtForPesquisarKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtForPesquisarKeyReleased
    {//GEN-HEADEREND:event_txtForPesquisarKeyReleased
        pesquisar_fornecedor();
    }//GEN-LAST:event_txtForPesquisarKeyReleased

    private void tblfornecedoresMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tblfornecedoresMouseClicked
    {//GEN-HEADEREND:event_tblfornecedoresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblfornecedoresMouseClicked

    private void tipo_buscaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipo_buscaItemStateChanged
        Object selected = this.tipo_busca.getSelectedItem();
        if(selected.toString().equals("Por Nome do Fornecedor"))
        sql="SELECT fornecedores.Codigo_fornecedor as Codigo,fornecedores.Nome_fornecedor as Nome,fornecedores.Email_fornecedor as Email,fornecedores.CNPJ_fornecedor as CNPJ,fornecedores.Inscricao as Inscricao,endereco_fornecedor.localizacao as Localizacao,endereco_fornecedor.Nome_rua as Rua,endereco_fornecedor.Num_Rua as Nº,endereco_fornecedor.Bairro as Bairro,endereco_fornecedor.CEP as CEP,telefones_fornecedor.Num_telefone1 as Tel1,telefones_fornecedor.Num_telefone2 as Tel2, Representante_Fornecedor.Nome_Representante as Representante, Representante_Fornecedor.Codigo_Representante as Rep_Codigo,Representante_Fornecedor.Email_Representante as Rep_Email, Representante_Fornecedor_Telefone.Num_Telefone1 as Rep_Telefone1,Representante_Fornecedor_Telefone.Num_Telefone2 as Rep_Telefone2 FROM fornecedores INNER JOIN endereco_fornecedor on fornecedores.Codigo_fornecedor = endereco_fornecedor.Codigo_fornecedor INNER JOIN telefones_fornecedor on fornecedores.Codigo_fornecedor=telefones_fornecedor.Codigo_fornecedor INNER JOIN Representante_Fornecedor on fornecedores.Codigo_fornecedor=Representante_Fornecedor.Codigo_fornecedor INNER JOIN Representante_Fornecedor_Telefone on Representante_Fornecedor.Codigo_Representante=Representante_Fornecedor_Telefone.Codigo_Representante WHERE fornecedores.Nome_fornecedor like ?;";
        else
        sql="SELECT fornecedores.Codigo_fornecedor as Codigo,fornecedores.Nome_fornecedor as Nome,fornecedores.Email_fornecedor as Email,fornecedores.CNPJ_fornecedor as CNPJ,fornecedores.Inscricao as Inscricao,endereco_fornecedor.localizacao as Localizacao,endereco_fornecedor.Nome_rua as Rua,endereco_fornecedor.Num_Rua as Nº,endereco_fornecedor.Bairro as Bairro,endereco_fornecedor.CEP as CEP,telefones_fornecedor.Num_telefone1 as Tel1,telefones_fornecedor.Num_telefone2 as Tel2, Representante_Fornecedor.Nome_Representante as Representante, Representante_Fornecedor.Codigo_Representante as Rep_Codigo,Representante_Fornecedor.Email_Representante as Rep_Email, Representante_Fornecedor_Telefone.Num_Telefone1 as Rep_Telefone1,Representante_Fornecedor_Telefone.Num_Telefone2 as Rep_Telefone2 FROM fornecedores INNER JOIN endereco_fornecedor on fornecedores.Codigo_fornecedor = endereco_fornecedor.Codigo_fornecedor INNER JOIN telefones_fornecedor on fornecedores.Codigo_fornecedor=telefones_fornecedor.Codigo_fornecedor INNER JOIN Representante_Fornecedor on fornecedores.Codigo_fornecedor=Representante_Fornecedor.Codigo_fornecedor INNER JOIN Representante_Fornecedor_Telefone on Representante_Fornecedor.Codigo_Representante=Representante_Fornecedor_Telefone.Codigo_Representante WHERE fornecedores.CNPJ_fornecedor like ?;";
    }//GEN-LAST:event_tipo_buscaItemStateChanged

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                Lista_Select_Fornecedor dialog = new Lista_Select_Fornecedor();
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
    private javax.swing.JTable tblfornecedores;
    private javax.swing.JComboBox tipo_busca;
    private javax.swing.JTextField txtForPesquisar;
    // End of variables declaration//GEN-END:variables
}
