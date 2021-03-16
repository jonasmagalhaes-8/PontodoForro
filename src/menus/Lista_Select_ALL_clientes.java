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
public class Lista_Select_ALL_clientes extends javax.swing.JDialog
{
    String nome="",rua="",num="",bairro="",cep="",email="",telefone1="",telefone2="",cpf="",cnpj="";
    int id;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Lista_Select_ALL_clientes fecha_frame()
    {
        this.dispose();
        try
        { conexao.close(); }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null, e); }
        return null;
    }
    
    public Lista_Select_ALL_clientes()
    {
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
        Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        this.setBounds(bounds);
        Background_image tela_acessar = new Background_image
        ( new ImageIcon("src/imagens/visuais_busca_1.png").getImage() );
        this.getContentPane().add(tela_acessar);
        show_cliente();
        
      this.tblClientes.addMouseListener(new MouseAdapter()
      {
        public void mouseClicked(MouseEvent me)
        {
          if (me.getClickCount() == 1)  // to detect doble click events
          {    
            JTable target = (JTable)me.getSource(); // select a row
            int row = target.getSelectedRow(); // select a column
            int column = target.getSelectedColumn(); // get the value of a row and column.
            id = (int) tblClientes.getValueAt(row, 0);
            nome = (String) tblClientes.getValueAt(row, 1);
            email = (String) tblClientes.getValueAt(row, 2);
            cpf = (String) tblClientes.getValueAt(row, 3);
            cnpj = (String) tblClientes.getValueAt(row, 4);
            rua = (String) tblClientes.getValueAt(row, 5);
            num = (String) tblClientes.getValueAt(row, 6);
            bairro = (String) tblClientes.getValueAt(row, 7);
            cep = (String) tblClientes.getValueAt(row, 8);
            telefone1 = (String) tblClientes.getValueAt(row, 9);
            telefone2 = (String) tblClientes.getValueAt(row, 10);
            fecha_frame();
          }
        }
      });  
    }
    private void pesquisar_cliente()
    {  
      String sql="";
      sql="SELECT clientes.Codigo_Cliente as Codigo,clientes.Nome_Cliente as Nome,clientes.Email_Cliente as Email,clientes.CPF_Cliente as CPF,CNPJ_CLiente as CNPJ,endereco_cliente.Nome_rua as Rua,endereco_cliente.Num_Rua as Nº,endereco_cliente.Bairro as Bairro,endereco_cliente.CEP as CEP,telefones_cliente.Num_telefone1 as Tel1,Num_telefone2 as Tel2 FROM clientes INNER JOIN endereco_cliente on clientes.Codigo_Cliente = endereco_cliente.Codigo_Cliente INNER JOIN telefones_cliente on clientes.Codigo_cliente=telefones_cliente.Codigo_cliente WHERE clientes.Nome_cliente like ?;";
      try
      {
        conexao = ModuloConexao.conector();
        pst=conexao.prepareStatement(sql);
        pst.setString(1, this.txtCliPesquisar.getText() + "%");
        rs=pst.executeQuery();
        this.tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(null, e);}
    }
    
    private void show_cliente()
    {
      String sql="";
      sql="SELECT clientes.Codigo_Cliente as Codigo,clientes.Nome_Cliente as Nome,clientes.Email_Cliente as Email,clientes.CPF_Cliente as CPF,CNPJ_CLiente as CNPJ,endereco_cliente.Nome_rua as Rua,endereco_cliente.Num_Rua as Nº,endereco_cliente.Bairro as Bairro,endereco_cliente.CEP as CEP,telefones_cliente.Num_telefone1 as Tel1,Num_telefone2 as Tel2 FROM clientes INNER JOIN endereco_cliente on clientes.Codigo_Cliente = endereco_cliente.Codigo_Cliente INNER JOIN telefones_cliente on clientes.Codigo_cliente=telefones_cliente.Codigo_cliente;";
      try
      {
        conexao = ModuloConexao.conector();
        pst=conexao.prepareStatement(sql);
        //pst.setString(1, this.txtCliPesquisar.getText());
        rs=pst.executeQuery();
        this.tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(null, e);}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtCliPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(20, 22, 120));
        setBounds(new java.awt.Rectangle(0, 0, 8, 0));

        tblClientes.setBackground(new java.awt.Color(240, 240, 240));
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        txtCliPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliPesquisarKeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(20, 22, 121));
        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Informe como deseja realizar a busca:");

        jLabel2.setBackground(new java.awt.Color(20, 22, 121));
        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Informe como deseja realizar a busca:");

        jLabel3.setBackground(new java.awt.Color(20, 22, 121));
        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Informe o nome do cliente:");

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
                        .addGap(238, 238, 238)
                        .addComponent(jLabel3)))
                .addContainerGap(201, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(173, 173, 173)
                    .addComponent(jLabel1)
                    .addContainerGap(173, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(173, 173, 173)
                    .addComponent(jLabel2)
                    .addContainerGap(173, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(13, 13, 13)
                .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(278, 278, 278)
                    .addComponent(jLabel1)
                    .addContainerGap(278, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(278, 278, 278)
                    .addComponent(jLabel2)
                    .addContainerGap(278, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(816, 628));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCliPesquisarKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtCliPesquisarKeyReleased
    {//GEN-HEADEREND:event_txtCliPesquisarKeyReleased
        pesquisar_cliente();
    }//GEN-LAST:event_txtCliPesquisarKeyReleased

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tblClientesMouseClicked
    {//GEN-HEADEREND:event_tblClientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblClientesMouseClicked

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                Lista_Select_ALL_clientes dialog = new Lista_Select_ALL_clientes();
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCliPesquisar;
    // End of variables declaration//GEN-END:variables
}
