package fornecedores_CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import banco.ModuloConexao;

public class Delete_fornecedor
{
  private String id,id_representante;
  String sql;
  Connection conexao = null;
  PreparedStatement pst = null;
    
  public void setId(String id) //*** Setter para receber o ID do cliente a ser alterado
  { this.id = id; } 
  
  public void setId_representante(String id_representante) //*** Setter para receber o ID do cliente a ser alterado
  { this.id_representante = id_representante; }
  
  public int delete()
  {
    String[] confirmacao = {"Sim", "Nao"};
    int confirma_exclusao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja realizar a exclusão? ",null,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, confirmacao, confirmacao[0]);
        
    if(confirma_exclusao==0)
    {
      sql="delete from endereco_fornecedor where Codigo_Fornecedor=?";
      conexao = ModuloConexao.conector();
      try
      {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, this.id);
        pst.executeUpdate();
      }     
      catch (Exception e)
      { JOptionPane.showMessageDialog(null,e); }
      
      sql="delete from telefones_fornecedor where Codigo_Fornecedor=?";
      try
      {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, this.id);
        pst.executeUpdate();
        
      }     
      catch (Exception e)
      { JOptionPane.showMessageDialog(null,e); }
    
      sql="delete from Representante_Fornecedor_Telefone where Codigo_Representante=?";
      try
      {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, this.id_representante);
        pst.executeUpdate();
      }     
      catch (Exception e)
      { JOptionPane.showMessageDialog(null,e); }
      
      sql="delete from Representante_Fornecedor where Codigo_Fornecedor=?";
      try
      {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, this.id);
        pst.executeUpdate();
      }     
      catch (Exception e)
      { JOptionPane.showMessageDialog(null,e); }
      
      sql="delete from Fornecedores where Codigo_Fornecedor=?";
      try
      {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, this.id);
        pst.executeUpdate();
      }     
      catch (Exception e)
      { JOptionPane.showMessageDialog(null,e); }

      return 1; 
    }
    else
    return 0;
  }
}