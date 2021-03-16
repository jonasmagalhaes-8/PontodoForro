package clientes_CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import banco.ModuloConexao;

public class Delete_cliente
{
  private String id;
  String sql;
  Connection conexao = null;
  PreparedStatement pst = null;
    
  public void setId(String id) //*** Setter para receber o ID do cliente a ser alterado
  { this.id = id; } 
    
  public int delete()
  {
    String[] confirmacao = {"Sim", "Nao"};
    int confirma_exclusao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja realizar a exclusão? ",null,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, confirmacao, confirmacao[0]);
        
    if(confirma_exclusao==0)
    {
      sql="delete from endereco_cliente where Codigo_Cliente=?";
      conexao = ModuloConexao.conector();
      try
      {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, this.id);
        pst.executeUpdate();
      }     
      catch (Exception e)
      { JOptionPane.showMessageDialog(null,e); }
      
      sql="delete from telefones_cliente where Codigo_Cliente=?";
      try
      {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, this.id);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Exclusão realizada!");
      }     
      catch (Exception e)
      { JOptionPane.showMessageDialog(null,e); }
      
      sql="delete from clientes where Codigo_Cliente=?";
      try
      {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, this.id);
        pst.executeUpdate();
      }     
      catch (Exception e)
      { JOptionPane.showMessageDialog(null,e); }
      finally
      {
        try
        { conexao.close(); }
        catch (Exception e)
        { JOptionPane.showMessageDialog(null,e); }
      }
      return 1; 
    }
    else
    return 0;
  }
}