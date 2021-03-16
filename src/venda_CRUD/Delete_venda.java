package venda_CRUD;

import banco.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Delete_venda
{
  private int id;
  String sql;
  Connection conexao = null;
  PreparedStatement pst = null;
  int exclusao=0;  
  public void setId(int id)
  { this.id = id; } 
    
  public int delete_Status_Pedidos()
  {
      sql="delete from Status_Pedidos where ID_Pedido=?";
      try
      {
        conexao = ModuloConexao.conector();
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, this.id);
        pst.executeUpdate();
      }     
      catch (Exception e)
      { 
        JOptionPane.showMessageDialog(null,e);
        exclusao=-1;
      }
            
      sql="delete from Pedidos where OS=?";
            try
            {
              pst = conexao.prepareStatement(sql);
              pst.setInt(1, this.id);
              pst.executeUpdate();
              exclusao=1;
            }     
            catch (Exception e)
            { 
                JOptionPane.showMessageDialog(null,e);
                exclusao=-1;
            }
            finally
            {
              try
              { conexao.close(); }
              catch (Exception e)
              { JOptionPane.showMessageDialog(null,e); }
            } 
            return exclusao;
        }
  }