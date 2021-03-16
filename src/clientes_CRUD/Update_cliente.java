package clientes_CRUD;

import classes_externas.validador_de_digitos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import banco.ModuloConexao;

public class Update_cliente extends Cliente
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
            sql="select * from clientes where Codigo_Cliente!=? and Nome_Cliente=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros clientes e não para o atualizado em questão
            try
            {
              conexao = ModuloConexao.conector();
              pst = conexao.prepareStatement(sql);
              pst.setString(1, this.id);
              pst.setString(2, nome_informado);
              rs = pst.executeQuery();
              
              if(rs.next()) //caso o dado inserido para atualização tenha sido encontrado em outro usuário:
              JOptionPane.showMessageDialog(null, "Nome já cadastrado!");
              else //caso contrário:
              { 
                  sql = "update clientes set Nome_Cliente=? where Codigo_Cliente=?";
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
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }
        else
        JOptionPane.showMessageDialog(null,"Nome invalido!");  
    }

    public void update_email(String email_informado)
    {
        if(email_informado.length()>=10 && email_informado.contains("@") && email_informado.contains("."))
        {
            sql="select * from clientes where Codigo_Cliente!=? and Email_Cliente=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros clientes e não para o atualizado em questão
            try
            {
              conexao = ModuloConexao.conector();
              pst = conexao.prepareStatement(sql);
              pst.setString(1, this.id);
              pst.setString(2, email_informado);
              rs = pst.executeQuery();
        
              if(rs.next()) //caso o dado inserido para atualização tenha sido encontrado em outro usuário:
              JOptionPane.showMessageDialog(null, "E-mail já cadastrado!");
              else //caso contrário:
              { 
                  sql = "update clientes set Email_Cliente=? where Codigo_Cliente=?";
                  try
                  {
                    pst=conexao.prepareStatement(sql);
                    pst.setString(1, email_informado);
                    pst.setString(2, this.id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "E-mail atualizado!");
                  }
                  catch (Exception e)
                  { JOptionPane.showMessageDialog(null,e); } 
              }
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }
        else
        JOptionPane.showMessageDialog(null,"E-mail invalido!");  
    }
    
    public void update_cpf(String cpf_informado)
    {
        if(cpf_informado.length()==11 && validador_de_digitos.isNumeric(cpf_informado)==true)
        {
            sql="select * from clientes where Codigo_Cliente!=? and CPF_Cliente=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros clientes e não para o atualizado em questão
            try
            {
              conexao = ModuloConexao.conector();
              pst = conexao.prepareStatement(sql);
              pst.setString(1, this.id);
              pst.setString(2, cpf_informado);
              rs = pst.executeQuery();
        
              if(rs.next()) //caso o dado inserido para atualização tenha sido encontrado em outro usuário:
              JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
              else //caso contrário:
              { 
                  sql = "update clientes set CPF_Cliente=? where Codigo_Cliente=?";
                  try
                  {
                    pst=conexao.prepareStatement(sql);
                    pst.setString(1, cpf_informado);
                    pst.setString(2, this.id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "CPF atualizado!");
                  }
                  catch (Exception e)
                  { JOptionPane.showMessageDialog(null,e); } 
              }
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }
        else
        JOptionPane.showMessageDialog(null,"CPF invalido!");  
    }
    
     public void update_cnpj(String cnpj_informado)
     {
        if(cnpj_informado.length()==14 && validador_de_digitos.isNumeric(cnpj_informado)==true)
        {
            sql="select * from clientes where Codigo_Cliente!=? and CNPJ_Cliente=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros clientes e não para o atualizado em questão
            try
            {
              conexao = ModuloConexao.conector();
              pst = conexao.prepareStatement(sql);
              pst.setString(1, this.id);
              pst.setString(2, cnpj_informado);
              rs = pst.executeQuery();
        
              if(rs.next()) //caso o dado inserido para atualização tenha sido encontrado em outro usuário:
              JOptionPane.showMessageDialog(null, "CNPJ já cadastrado!");
              else //caso contrário:
              { 
                  sql = "update clientes set CNPJ_Cliente=? where Codigo_Cliente=?";
                  try
                  {
                    pst=conexao.prepareStatement(sql);
                    pst.setString(1, cnpj_informado);
                    pst.setString(2, this.id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "CNPJ atualizado!");
                  }
                  catch (Exception e)
                  { JOptionPane.showMessageDialog(null,e); } 
              }
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }
        else
        JOptionPane.showMessageDialog(null,"CNPJ invalido!");  
    }
     
    public void update_rua(String rua_informada)
    {
        if(rua_informada.length()>2)
        {
          sql = "update Endereco_Cliente set Nome_Rua=? where Codigo_Cliente=?";
          try
          {
            conexao = ModuloConexao.conector();
            pst=conexao.prepareStatement(sql);
            pst.setString(1, rua_informada);
            pst.setString(2, this.id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rua atualizada!");
           }
           catch (Exception e)
           { JOptionPane.showMessageDialog(null,e); } 
        }
        else
        JOptionPane.showMessageDialog(null,"Rua invalida!");  
     }
    
    public void update_num(String num_informado)
    {
        if(num_informado.length()>0)
        {
          sql = "update Endereco_Cliente set Num_Rua=? where Codigo_Cliente=?";
          try
          {
            conexao = ModuloConexao.conector();
            pst=conexao.prepareStatement(sql);
            pst.setString(1, num_informado);
            pst.setString(2, this.id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Nº atualizado!");
           }
           catch (Exception e)
           { JOptionPane.showMessageDialog(null,e); } 
        }
        else
        JOptionPane.showMessageDialog(null,"Nº invalido!");  
     }
    
    public void update_bairro(String bairro_informado)
    {
        if(bairro_informado.length()>2)
        {
          sql = "update Endereco_Cliente set Bairro=? where Codigo_Cliente=?";
          try
          {
            conexao = ModuloConexao.conector();
            pst=conexao.prepareStatement(sql);
            pst.setString(1, bairro_informado);
            pst.setString(2, this.id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bairro atualizado!");
           }
           catch (Exception e)
           { JOptionPane.showMessageDialog(null,e); } 
        }
        else
        JOptionPane.showMessageDialog(null,"Bairro invalido!");  
     }
    
    public void update_cep(String cep_informado)
    {
        if(cep_informado.length()==8 && validador_de_digitos.isNumeric(cep_informado)==true)
        {
          sql = "update Endereco_Cliente set CEP=? where Codigo_Cliente=?";
          try
          {
            conexao = ModuloConexao.conector();
            pst=conexao.prepareStatement(sql);
            pst.setString(1, cep_informado);
            pst.setString(2, this.id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "CEP atualizado!");
           }
           catch (Exception e)
           { JOptionPane.showMessageDialog(null,e); } 
        }
        else
        JOptionPane.showMessageDialog(null,"CEP invalido!");  
     }

    public void update_telefone1(String telefone1_informado)
    {
        if(telefone1_informado.length()==10 && validador_de_digitos.isNumeric(telefone1_informado)==true)
        {
            sql="select * from Telefones_Cliente where Num_Telefone2=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros Fornecedores e não para o atualizado em questão
            try
            {
              conexao = ModuloConexao.conector();
              pst = conexao.prepareStatement(sql);
              pst.setString(1, telefone1);
              rs = pst.executeQuery();
        
              if(rs.next()) //caso o dado inserido para atualização tenha sido encontrado em outro usuário:
              JOptionPane.showMessageDialog(null, "Telefone 1 já cadastrado!");
              else //caso contrário:
              { 
                      sql = "update Telefones_Cliente set Num_Telefone1=? where Codigo_Cliente=?";
                      try
                      {
                        pst=conexao.prepareStatement(sql);
                        pst.setString(1, telefone1_informado);
                        pst.setString(2, this.id);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Telefone 1 atualizado!");
                      }
                      catch (Exception e)
                      { JOptionPane.showMessageDialog(null,e); } 
                  }
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null, "Telefone 1 já cadastrado!");} 
            }
        else
        JOptionPane.showMessageDialog(null,"Telefone 1 invalido!");  
    }  
    
    public void update_telefone2(String telefone2_informado)
    {
        if(telefone2_informado.length()==10 && validador_de_digitos.isNumeric(telefone2_informado)==true)
        {
            sql="select * from Telefones_Cliente where Codigo_Cliente!=? and Num_Telefone1=? or Num_Telefone2=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros clientes e não para o atualizado em questão
            try
            {
              conexao = ModuloConexao.conector();
              pst = conexao.prepareStatement(sql);
              pst.setString(1, this.id);
              pst.setString(2, telefone2_informado);
              pst.setString(3, telefone2_informado);
              rs = pst.executeQuery();
        
              if(rs.next()) //caso o dado inserido para atualização tenha sido encontrado em outro usuário:
              JOptionPane.showMessageDialog(null, "Telefone 2 já cadastrado!");
              else //caso contrário:
              { 
                  sql = "select * from Telefones_Cliente where Codigo_Cliente=? and Num_Telefone1=?";
                  try
                  {
                    pst=conexao.prepareStatement(sql);
                    pst.setString(1, this.id);
                    pst.setString(2, telefone2_informado);
                    rs = pst.executeQuery();
                    if(rs.next())
                    JOptionPane.showMessageDialog(null, "Telefone 2 já cadastrado!");
                    else
                    {
                      sql = "update Telefones_Cliente set Num_Telefone2=? where Codigo_Cliente=?";
                      try
                      {
                        pst=conexao.prepareStatement(sql);
                        pst.setString(1, telefone2_informado);
                        pst.setString(2, this.id);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Telefone 2 atualizado!");
                      }
                      catch (Exception e)
                      { JOptionPane.showMessageDialog(null,e); } }
                  }
                  catch (Exception e)
                  { JOptionPane.showMessageDialog(null,e); } 
              }
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }
        else
        JOptionPane.showMessageDialog(null,"Telefone 2 invalido!");  
    }   
}