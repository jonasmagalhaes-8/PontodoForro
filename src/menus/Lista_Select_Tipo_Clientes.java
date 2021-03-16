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
public class Lista_Select_Tipo_Clientes extends javax.swing.JDialog
{
    String nome="",rua="",num="",bairro="",cep="",email="",telefone1="",telefone2="",cpf="",cnpj="";
    int id;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Lista_Select_Tipo_Clientes fecha_frame()
    {
        this.dispose();
        try
        { conexao.close(); }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null, e); }
        return null;
    }
    
    public Lista_Select_Tipo_Clientes()
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
            if(Acesso_Cliente.label_c.getText().equals(" CPF:")) 
            cpf = (String) tblClientes.getValueAt(row, 3);
            else if(Acesso_Cliente.label_c.getText().equals(" CNPJ:")) 
            cnpj = (String) tblClientes.getValueAt(row, 3);
            rua = (String) tblClientes.getValueAt(row, 4);
            num = (String) tblClientes.getValueAt(row, 5);
            bairro = (String) tblClientes.getValueAt(row, 6);
            cep = (String) tblClientes.getValueAt(row, 7);
            telefone1 = (String) tblClientes.getValueAt(row, 8);
            telefone2 = (String) tblClientes.getValueAt(row, 9);
            fecha_frame();
          }
        }
      });  
    }
    private void pesquisar_cliente()
    {  
      String sql="";
      if(Acesso_Cliente.label_c.getText().equals(" CPF:")) 
      sql="SELECT clientes.Codigo_Cliente as Codigo,clientes.Nome_Cliente as Nome,clientes.Email_Cliente as Email,clientes.CPF_Cliente as CPF,endereco_cliente.Nome_rua as Rua,endereco_cliente.Num_Rua as Nº,endereco_cliente.Bairro as Bairro,endereco_cliente.CEP as CEP,telefones_cliente.Num_telefone1 as Tel1,Num_telefone2 as Tel2 FROM clientes INNER JOIN endereco_cliente on clientes.Codigo_Cliente = endereco_cliente.Codigo_Cliente INNER JOIN telefones_cliente on clientes.Codigo_cliente=telefones_cliente.Codigo_cliente WHERE clientes.Nome_cliente like ? AND LENGTH(CPF)>3;";
      else if(Acesso_Cliente.label_c.getText().equals(" CNPJ:")) 
      sql="SELECT clientes.Codigo_Cliente as Codigo,clientes.Nome_Cliente as Nome,clientes.Email_Cliente as Email,clientes.CNPJ_Cliente as CNPJ,endereco_cliente.Nome_rua as Rua,endereco_cliente.Num_Rua as Nº,endereco_cliente.Bairro as Bairro,endereco_cliente.CEP as CEP,telefones_cliente.Num_telefone1 as Tel1,Num_telefone2 as Tel2 FROM clientes INNER JOIN endereco_cliente on clientes.Codigo_Cliente = endereco_cliente.Codigo_Cliente INNER JOIN telefones_cliente on clientes.Codigo_cliente=telefones_cliente.Codigo_cliente WHERE clientes.Nome_cliente like ? AND LENGTH(CNPJ)>3;";
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
      if(Acesso_Cliente.label_c.getText().equals(" CPF:")) 
      sql="SELECT clientes.Codigo_Cliente as Codigo,clientes.Nome_Cliente as Nome,clientes.Email_Cliente as Email,clientes.CPF_Cliente as CPF,endereco_cliente.Nome_rua as Rua,endereco_cliente.Num_Rua as Nº,endereco_cliente.Bairro as Bairro,endereco_cliente.CEP as CEP,telefones_cliente.Num_telefone1 as Tel1,Num_telefone2 as Tel2 FROM clientes INNER JOIN endereco_cliente on clientes.Codigo_Cliente = endereco_cliente.Codigo_Cliente INNER JOIN telefones_cliente on clientes.Codigo_cliente=telefones_cliente.Codigo_cliente WHERE LENGTH(CPF)>3 order by Nome;";
      if(Acesso_Cliente.label_c.getText().equals(" CNPJ:")) 
      sql="SELECT clientes.Codigo_Cliente as Codigo,clientes.Nome_Cliente as Nome,clientes.Email_Cliente as Email,clientes.CNPJ_Cliente as CNPJ,endereco_cliente.Nome_rua as Rua,endereco_cliente.Num_Rua as Nº,endereco_cliente.Bairro as Bairro,endereco_cliente.CEP as CEP,telefones_cliente.Num_telefone1 as Tel1,Num_telefone2 as Tel2 FROM clientes INNER JOIN endereco_cliente on clientes.Codigo_Cliente = endereco_cliente.Codigo_Cliente INNER JOIN telefones_cliente on clientes.Codigo_cliente=telefones_cliente.Codigo_cliente WHERE LENGTH(CNPJ)>3 order by Nome;";
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
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
                Lista_Select_Tipo_Clientes dialog = new Lista_Select_Tipo_Clientes();
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCliPesquisar;
    // End of variables declaration//GEN-END:variables
}
