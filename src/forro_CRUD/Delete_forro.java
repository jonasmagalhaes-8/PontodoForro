package forro_e_CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import banco.ModuloConexao;

public class Delete_forro
{
  private String id_forro;
  String sql;
  Connection conexao = null;
  PreparedStatement pst = null;
  
  public void setId_forro(String id_forro)
  { this.id_forro = id_forro; }
  
  public int delete()
  {
    String[] confirmacao = {"Sim", "Nao"};
    int confirma_exclusao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja realizar a exclusão? ",null,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, confirmacao, confirmacao[0]);
        
    if(confirma_exclusao==0)
    {
      sql="delete from Forro where Codigo_Forro=?";
      conexao = ModuloConexao.conector();
      try
      {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, this.id_forro);
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