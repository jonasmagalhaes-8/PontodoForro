package fornecedores_CRUD;

import classes_externas.validador_de_digitos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import banco.ModuloConexao;

public class Update_fornecedor extends Fornecedor
{
    private String id,id_representante;
    String sql;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void setId(String id) //*** Setter para receber o ID do cliente a ser alterado
    { this.id = id; }
    
    public void setId_representante(String id_representante) //*** Setter para receber o ID do cliente a ser alterado
    { this.id_representante = id_representante; }
    
    public void update_nome(String nome_informado)
    {
        if(nome_informado.length()>0)
        {
            sql="select * from Fornecedores where Codigo_Fornecedor!=? and Nome_Fornecedor=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros Fornecedores e não para o atualizado em questão
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
                  sql = "update Fornecedores set Nome_Fornecedor=? where Codigo_Fornecedor=?";
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
        if(email_informado.length()>=10 && email_informado.toLowerCase().contains("@") && email_informado.contains("."))
        {
            sql="select * from Fornecedores where Codigo_Fornecedor!=? and Email_Fornecedor=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros Fornecedores e não para o atualizado em questão
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
                  sql = "update Fornecedores set Email_Fornecedor=? where Codigo_Fornecedor=?";
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
     
     public void update_cnpj(String cnpj_informado)
     {
        if(cnpj_informado.length()==14 && validador_de_digitos.isNumeric(cnpj_informado)==true)
        {
            sql="select * from Fornecedores where Codigo_Fornecedor!=? and CNPJ_Fornecedor=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros Fornecedores e não para o atualizado em questão
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
                  sql = "update Fornecedores set CNPJ_Fornecedor=? where Codigo_Fornecedor=?";
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
     
     public void update_inscricao(String inscricao_informada)
     {
        if(inscricao_informada.length()==8 && validador_de_digitos.isNumeric(inscricao_informada)==true)
        {
            sql="select * from Fornecedores where Codigo_Fornecedor!=? and Inscricao=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros Fornecedores e não para o atualizado em questão
            try
            {
              conexao = ModuloConexao.conector();
              pst = conexao.prepareStatement(sql);
              pst.setString(1, this.id);
              pst.setString(2, inscricao_informada);
              rs = pst.executeQuery();
        
              if(rs.next()) //caso o dado inserido para atualização tenha sido encontrado em outro usuário:
              JOptionPane.showMessageDialog(null, "Inscrição já cadastrada!");
              else //caso contrário:
              { 
                  sql = "update Fornecedores set Inscricao=? where Codigo_Fornecedor=?";
                  try
                  {
                    pst=conexao.prepareStatement(sql);
                    pst.setString(1, inscricao_informada);
                    pst.setString(2, this.id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Inscrição atualizada!");
                  }
                  catch (Exception e)
                  { JOptionPane.showMessageDialog(null,e); } 
              }
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }
        else
        JOptionPane.showMessageDialog(null,"Inscrição invalida!");  
    }
     
    public void update_rua(String rua_informada)
    {
        if(rua_informada.length()>2)
        {
          sql = "update Endereco_Fornecedor set Nome_Rua=? where Codigo_Fornecedor=?";
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
    
    public void update_localizacao(String localizacao_informada)
    {
        if(localizacao_informada.length()>2)
        {
          sql = "update Endereco_Fornecedor set Localizacao=? where Codigo_Fornecedor=?";
          try
          {
            conexao = ModuloConexao.conector();
            pst=conexao.prepareStatement(sql);
            pst.setString(1, localizacao_informada);
            pst.setString(2, this.id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Localização atualizada!");
           }
           catch (Exception e)
           { JOptionPane.showMessageDialog(null,e); } 
        }
        else
        JOptionPane.showMessageDialog(null,"Localização invalida!");  
     }
    
    public void update_num(String num_informado)
    {
        if(num_informado.length()>0)
        {
          sql = "update Endereco_Fornecedor set Num_Rua=? where Codigo_Fornecedor=?";
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
          sql = "update Endereco_Fornecedor set Bairro=? where Codigo_Fornecedor=?";
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
          sql = "update Endereco_Fornecedor set CEP=? where Codigo_Fornecedor=?";
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
            sql="select * from Telefones_Fornecedor where Codigo_Fornecedor!=? and Num_Telefone1=? or Num_Telefone2=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros Fornecedores e não para o atualizado em questão
            try
            {
              conexao = ModuloConexao.conector();
              pst = conexao.prepareStatement(sql);
              pst.setString(1, this.id);
              pst.setString(2, telefone1_informado);
              pst.setString(3, telefone1_informado);
              rs = pst.executeQuery();
        
              if(rs.next()) //caso o dado inserido para atualização tenha sido encontrado em outro usuário:
              JOptionPane.showMessageDialog(null, "Telefone 1 já cadastrado!");
              else //caso contrário:
              { 
                  sql = "select * from Telefones_Fornecedor where Codigo_Fornecedor=? and Num_Telefone2=?";
                  try
                  {
                    pst=conexao.prepareStatement(sql);
                    pst.setString(1, this.id);
                    pst.setString(2, telefone1_informado);
                    rs = pst.executeQuery();
                    if(rs.next())
                    JOptionPane.showMessageDialog(null, "Telefone 1 já cadastrado!");
                    else
                    {
                      sql = "update Telefones_Fornecedor set Num_Telefone1=? where Codigo_Fornecedor=?";
                      try
                      {
                        pst=conexao.prepareStatement(sql);
                        pst.setString(1, telefone1_informado);
                        pst.setString(2, this.id);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Telefone 1 atualizado!");
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
        JOptionPane.showMessageDialog(null,"Telefone 1 invalido!");  
    }    
    
    public void update_telefone2(String telefone2_informado)
    {
        if(telefone2_informado.length()==10 && validador_de_digitos.isNumeric(telefone2_informado)==true)
        {
            sql="select * from Telefones_Fornecedor where Codigo_Fornecedor!=? and Num_Telefone1=? or Num_Telefone2=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros Fornecedores e não para o atualizado em questão
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
                  sql = "select * from Telefones_Fornecedor where Codigo_Fornecedor=? and Num_Telefone1=?";
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
                      sql = "update Telefones_Fornecedor set Num_Telefone2=? where Codigo_Fornecedor=?";
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
    
    public void update_representante_nome(String representante_nome_informado)
    {
        if(representante_nome_informado.length()>0)
        {
            sql="select * from Representante_Fornecedor where Codigo_Fornecedor!=? and Nome_Representante=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros Fornecedores e não para o atualizado em questão
            try
            {
              conexao = ModuloConexao.conector();
              pst = conexao.prepareStatement(sql);
              pst.setString(1, this.id);
              pst.setString(2, representante_nome_informado);
              rs = pst.executeQuery();
              
              if(rs.next()) //caso o dado inserido para atualização tenha sido encontrado em outro usuário:
              JOptionPane.showMessageDialog(null, "Nome já cadastrado!");
              else //caso contrário:
              { 
                  sql = "update Representante_Fornecedor set Nome_Representante=? where Codigo_Fornecedor=?";
                  try
                  {
                    pst=conexao.prepareStatement(sql);
                    pst.setString(1, representante_nome_informado);
                    pst.setString(2, this.id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Nome do representante atualizado!");
                  }
                  catch (Exception e)
                  { JOptionPane.showMessageDialog(null,e); } 
              }
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }
        else
        JOptionPane.showMessageDialog(null,"Nome do representante invalido!");  
    }
    
    public void update_representante_email(String representante_email_informado)
    {
        if(representante_email_informado.length()>=10 && representante_email_informado.contains("@") && representante_email_informado.contains(".".toLowerCase()))
        {
            sql="select * from Representante_Fornecedor where Codigo_Fornecedor!=? and Email_Representante=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros Fornecedores e não para o atualizado em questão
            try
            {
              conexao = ModuloConexao.conector();
              pst = conexao.prepareStatement(sql);
              pst.setString(1, this.id);
              pst.setString(2, representante_email_informado);
              rs = pst.executeQuery();
        
              if(rs.next()) //caso o dado inserido para atualização tenha sido encontrado em outro usuário:
              JOptionPane.showMessageDialog(null, "E-mail do representante já cadastrado!");
              else //caso contrário:
              { 
                  sql = "update Representante_Fornecedor set Email_Representante=? where Codigo_Fornecedor=?";
                  try
                  {
                    pst=conexao.prepareStatement(sql);
                    pst.setString(1, representante_email_informado);
                    pst.setString(2, this.id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "E-mail do representante atualizado!");
                  }
                  catch (Exception e)
                  { JOptionPane.showMessageDialog(null,e); } 
              }
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }
        else
        JOptionPane.showMessageDialog(null,"E-mail do representante invalido!");  
    }
    
    public void update_representante_telefone1(String representante_telefone1_informado)
    {
        if(representante_telefone1_informado.length()==10 && validador_de_digitos.isNumeric(representante_telefone1_informado)==true)
        {
            sql="select * from Representante_Fornecedor_Telefone where Num_Telefone2=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros Fornecedores e não para o atualizado em questão
            try
            {
              conexao = ModuloConexao.conector();
              pst = conexao.prepareStatement(sql);
              pst.setString(1, representante_telefone1_informado);
              rs = pst.executeQuery();
        
              if(rs.next()) //caso o dado inserido para atualização tenha sido encontrado em outro usuário:
              JOptionPane.showMessageDialog(null, "erro 1");
              else //caso contrário:
              { 
                      sql = "update Representante_Fornecedor_Telefone set Num_Telefone1=? where Codigo_Representante=?";
                      try
                      {
                        pst=conexao.prepareStatement(sql);
                        pst.setString(1, representante_telefone1_informado);
                        pst.setString(2, this.id_representante);
                        pst.executeUpdate();
                      }
                      catch (Exception e)
                      { JOptionPane.showMessageDialog(null,e); } 
                  }
            }
            catch (Exception e)
            { 
              JOptionPane.showMessageDialog(null,e); } 
            }
        else
        JOptionPane.showMessageDialog(null,"Telefone 1 do representante invalido!");  
    }
          
    public void update_representante_telefone2(String representante_telefone2_informado)
    {
        if(representante_telefone2_informado.length()==10 && validador_de_digitos.isNumeric(representante_telefone2_informado)==true)
        {
            sql="select * from Representante_Fornecedor_Telefone where Codigo_Representante!=? and Num_Telefone1=? or Num_Telefone2=?";
            // ***** Aqui é passado a seguinte instrução ao banco de dados: procure no Banco de Dados onde o ID seja DIFERENTE do id recebido, isto foi realizado afim de evitar que os novos dados informados para atualização não estivessem em outros usuários mas a query para fazer uma busca apenas em ID diferentes é para que caso apenas um dado seja alterado (exemplo: telefone1) não seja impedido que os outros dados que permaneceram iguais acusem já estarem cadastrados (porque de fato, eles já estão no Banco de Dados), assim a validação de duplicação foi utilizada apenas para outros Fornecedores e não para o atualizado em questão
            try
            {
              conexao = ModuloConexao.conector();
              pst = conexao.prepareStatement(sql);
              pst.setString(1, this.id_representante);
              pst.setString(2, representante_telefone2_informado);
              pst.setString(3, representante_telefone2_informado);
              rs = pst.executeQuery();
        
              if(rs.next()) //caso o dado inserido para atualização tenha sido encontrado em outro usuário:
              JOptionPane.showMessageDialog(null, "Telefone 2 do Representante já cadastrado!");
              else //caso contrário:
              { 
                  sql = "select * from Representante_Fornecedor_Telefone where Codigo_Representante=? and Num_Telefone1=?";
                  try
                  {
                    pst=conexao.prepareStatement(sql);
                    pst.setString(1, this.id_representante);
                    pst.setString(2, representante_telefone2_informado);
                    rs = pst.executeQuery();
                    if(rs.next())
                    JOptionPane.showMessageDialog(null, "Telefone 2 do representante já cadastrado!");
                    else
                    {
                      sql = "update Representante_Fornecedor_Telefone set Num_Telefone2=? where Codigo_Representante=?";
                      try
                      {
                        pst=conexao.prepareStatement(sql);
                        pst.setString(1, representante_telefone2_informado);
                        pst.setString(2, this.id_representante);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Telefone 2 do representante atualizado!");
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
        JOptionPane.showMessageDialog(null,"Telefone 2 do representante invalido!");  
    }      
}

