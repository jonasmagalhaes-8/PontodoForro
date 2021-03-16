package forro_CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import banco.ModuloConexao;

public class Update_forro extends Forro
{
    private String id;
    String sql;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void setId(String id) //*** Setter para receber o ID do cliente a ser alterado
    { this.id = id; }
    
    public void update_nome(String nome_informado)
    {
        if(nome_informado.length()>0)
        {
           conexao = ModuloConexao.conector();
           sql = "update Forro set Nome_Forro=? where Codigo_Forro=?";
           try
           {
             pst=conexao.prepareStatement(sql);
             pst.setString(1, nome_informado);
             pst.setString(2, this.id);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Nome atualizado!");
           }
           catch (Exception e)
           { JOptionPane.showMessageDialog(null,e); } 
        }
        else
        JOptionPane.showMessageDialog(null,"Nome invalido!");  
    }

    public void update_cor(String cor_informada)
    {
        if(cor_informada.length()>0)
        {
           conexao = ModuloConexao.conector();
           sql = "update Forro set Cor=? where Codigo_Forro=?";
           try
           {
             pst=conexao.prepareStatement(sql);
             pst.setString(1, cor_informada);
             pst.setString(2, this.id);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Cor atualizada!");
           }
           catch (Exception e)
           { JOptionPane.showMessageDialog(null,e); } 
        }
        else
        JOptionPane.showMessageDialog(null,"Cor invalida!");  
    }
    
    public void update_descricao(String descricao_informada)
    {
        if(descricao_informada.length()>0)
        {
           conexao = ModuloConexao.conector();
           sql = "update Forro set Descricao=? where Codigo_Forro=?";
           try
           {
             pst=conexao.prepareStatement(sql);
             pst.setString(1, descricao_informada);
             pst.setString(2, this.id);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Descrição atualizada!");
           }
           catch (Exception e)
           { JOptionPane.showMessageDialog(null,e); } 
        }
        else
        JOptionPane.showMessageDialog(null,"Descrição invalida!");  
    }
    
    public void update_tamanho_peca(float t_peca)
    {
        if(t_peca>0)
        {
           conexao = ModuloConexao.conector();
           sql = "update Forro set Tamanho_Peca=? where Codigo_Forro=?";
           try
           {
             pst=conexao.prepareStatement(sql);
             pst.setFloat(1, t_peca);
             pst.setString(2, this.id);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Tamanho da peça atualizada!");
           }
           catch (Exception e)
           { JOptionPane.showMessageDialog(null,e); } 
        }
        else
        JOptionPane.showMessageDialog(null,"Tamanho da peça invalido!");  
    }
     
    public void update_quantidade(float qt_peca,float qt_M2)
    {
        if(qt_peca>0 && qt_M2>0)
        {
           conexao = ModuloConexao.conector();
           sql = "update Forro set Quantidade_Pecas=?, Quantidade_Metro2=? where Codigo_Forro=?";
           try
           {
             pst=conexao.prepareStatement(sql);
             pst.setFloat(1, qt_peca);
             pst.setFloat(2, qt_M2);
             pst.setString(3, this.id);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Quantidade atualizada!");
           }
           catch (Exception e)
           { JOptionPane.showMessageDialog(null,e); } 
        }
        else
        JOptionPane.showMessageDialog(null,"Quantidade invalida!");  
    }
    
    public void update_fornecedor(int codigo_fornecedor)
    {
      conexao = ModuloConexao.conector();
      sql = "update Forro set Codigo_Fornecedor=? where Codigo_Forro=?";
      try
      {
        pst=conexao.prepareStatement(sql);
        pst.setInt(1, codigo_fornecedor);
        pst.setString(2, this.id);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Fornecedor atualizado!");
       }
       catch (Exception e)
       { JOptionPane.showMessageDialog(null,e); } 
     }
}