package fornecedores_CRUD;

import classes_externas.validador_de_digitos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import banco.ModuloConexao;

public class Insert_fornecedor extends Fornecedor//Principal filho da classe Clientes, aqui é realizado a validação dos dados e cadastro no Banco de Dados informados nos menus de inserção de dados
{
    private int checkin=0; //Variável responsável por contar se todos os dados informados foram devidamente validados
    String sql,id,id_representante,nome_representante="",email_representante="",telefone1_representante="",telefone2_representante="";
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private boolean fornecedor;
    
    public void setNome_informado(String nome_informado)
    {
      //Os comentários deste primeiro métodos são pertinentes para todos os outros métodos Setter, com apenas algumas diferenças referentes aos dados
        
        if(nome_informado.length()>2) //Caso o campo não esteja em branco (tamanho da string maior que 0...)
        {
          this.checkin = checkin+1; //Contador avança com o objetivo de ao final garantir que todos os checkins de coerência foram cumpridos
          this.nome = nome_informado; //Setagem do dado para o campo da Class
        }
        else
        JOptionPane.showMessageDialog(null,"Nome invalido!");
    }
    
    public void setLocalizacao_informada(String Localizacao_informada)
    {
      //Os comentários deste primeiro métodos são pertinentes para todos os outros métodos Setter, com apenas algumas diferenças referentes aos dados
        if(Localizacao_informada.length()>2) //Caso o campo não esteja em branco (tamanho da string maior que 0...)
        {
          this.checkin = checkin+1; //Contador avança com o objetivo de ao final garantir que todos os checkins de coerência foram cumpridos
          this.localizacao = Localizacao_informada; //Setagem do dado para o campo da Class
         }
        else
        JOptionPane.showMessageDialog(null,"Localização invalida!");
    }
    
     public void setrua_informada(String rua_informada)
     {
      //Os comentários deste primeiro métodos são pertinentes para todos os outros métodos Setter, com apenas algumas diferenças referentes aos dados
        if(rua_informada.length()>2) //Caso o campo não esteja em branco (tamanho da string maior que 0...)
        {
          this.checkin = checkin+1; //Contador avança com o objetivo de ao final garantir que todos os checkins de coerência foram cumpridos
          this.rua = rua_informada; //Setagem do dado para o campo da Class
         }
        else
        JOptionPane.showMessageDialog(null,"Rua invalida!");
    }
     
     public void setnumrua_informado(String numrua_informada)
     {
      //Os comentários deste primeiro métodos são pertinentes para todos os outros métodos Setter, com apenas algumas diferenças referentes aos dados
        if(numrua_informada.length()>0) //Caso o campo não esteja em branco (tamanho da string maior que 0...)
        {
          this.checkin = checkin+1; //Contador avança com o objetivo de ao final garantir que todos os checkins de coerência foram cumpridos
          this.num = numrua_informada; //Setagem do dado para o campo da Class
        }
        else
        JOptionPane.showMessageDialog(null,"Numero da rua invalido!");
     }
   
    public void setbairro_informado(String bairro_informado)
    {
      //Os comentários deste primeiro métodos são pertinentes para todos os outros métodos Setter, com apenas algumas diferenças referentes aos dados
        if(bairro_informado.length()>2) //Caso o campo não esteja em branco (tamanho da string maior que 0...)
        {
          this.checkin = checkin+1; //Contador avança com o objetivo de ao final garantir que todos os checkins de coerência foram cumpridos
          this.bairro = bairro_informado; //Setagem do dado para o campo da Class
        }
        else
        JOptionPane.showMessageDialog(null,"Bairro invalido!");
    }
    
    public void setlocalizacao_informado(String localizacao_informada)
    {
      //Os comentários deste primeiro métodos são pertinentes para todos os outros métodos Setter, com apenas algumas diferenças referentes aos dados
        if(localizacao_informada.length()>2) //Caso o campo não esteja em branco (tamanho da string maior que 0...)
        {
          this.checkin = checkin+1; //Contador avança com o objetivo de ao final garantir que todos os checkins de coerência foram cumpridos
          this.bairro = localizacao_informada; //Setagem do dado para o campo da Class
        }
        else
        JOptionPane.showMessageDialog(null,"Localização invalida!");
    }
    
     public void setcep_informado(String cep_informado)
     {
      //Os comentários deste primeiro métodos são pertinentes para todos os outros métodos Setter, com apenas algumas diferenças referentes aos dados
        if(cep_informado.length()==8 && validador_de_digitos.isNumeric(cep_informado)==true) //Caso o campo não esteja em branco (tamanho da string maior que 0...)
        {
          this.checkin = checkin+1; //Contador avança com o objetivo de ao final garantir que todos os checkins de coerência foram cumpridos
          this.cep = cep_informado; //Setagem do dado para o campo da Class
        }
        else
        JOptionPane.showMessageDialog(null,"CEP invalido!");
    }
     
    public void setEmail_informado(String email_informado)
    {
         //Caso o campo não esteja em banco e contenha no minimo 10 digitos (usei como referência que um e-mail precisa ter ao menos um "@", um ".com" e um servidor "gmail/hotmail/yahoo, etc" e isso dá no mínimo 10 dígitos
         if(email_informado.length()>=10 && email_informado.contains("@") && email_informado.contains("."))
         {
           conexao = ModuloConexao.conector();
           String sql="select * from fornecedores where Email_Fornecedor=?";
           try
           {
              pst = conexao.prepareStatement(sql);
              pst.setString(1, email_informado);
              rs = pst.executeQuery();
              
              if(rs.next())
              JOptionPane.showMessageDialog(null, "Email já cadastrado!");
              else
              { 
                this.checkin = checkin+1;
                this.email = email_informado;
              }
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
         }
         else //Caso contrário se o campo conter menos de 10 digitos:
         JOptionPane.showMessageDialog(null,"E-mail invalido!");
    }
    
    public void setTelefone1_informado(String telefone1_informado)
    {
        if(telefone1_informado.length()==10 && validador_de_digitos.isNumeric(telefone1_informado)==true) //Verificação do número ter ao menos 11 dígitos (DDD+9+XXXXXXXX) valida-se se os digitos informados foram realmente números com a classe externa is_numeric
        {
          conexao = ModuloConexao.conector();
          String sql="select * from telefones_fornecedor where Num_Telefone1=? or Num_Telefone2=?";
          try
          {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, telefone1_informado);
            pst.setString(2, telefone1_informado);
            rs = pst.executeQuery();  
            
            if(rs.next())
            JOptionPane.showMessageDialog(null, "Telefone já cadastrado!");
            else
            { 
              this.checkin = checkin+1;
              this.telefone1 = telefone1_informado;
            }
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
        }
        else
        JOptionPane.showMessageDialog(null,"Telefone invalido! Verifique se os 10 digitos foram informados corretamente! Exe: 7186905914");
    }
    
    public void setTelefone2_informado(String telefone2_informado,String telefone1_informado)
    {
        if(telefone2_informado.length()==0)
        this.checkin = checkin+1;
        else if(telefone2_informado.length()==10 && validador_de_digitos.isNumeric(telefone2_informado)==true && !telefone2_informado.equals(telefone1_informado)) //Verificação do número ter ao menos 11 dígitos (DDD+9+XXXXXXXX) valida-se se os digitos informados foram realmente números com a classe externa is_numeric
        {
          conexao = ModuloConexao.conector();
          String sql="select * from telefones_fornecedor where Num_Telefone1=? or Num_Telefone2=?";
          try
          {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, telefone2_informado);
            pst.setString(2, telefone2_informado);
            rs = pst.executeQuery();  
            
            if(rs.next())
            JOptionPane.showMessageDialog(null, "Telefone 2 já cadastrado!");
            else
            { 
              this.checkin = checkin+1;
              this.telefone2 = telefone2_informado;
            }
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
        }
        else
        JOptionPane.showMessageDialog(null,"Telefone 2 invalido! Verifique se os 10 digitos foram informados corretamente! Exe: 7186905914");
    }
    
    public void setCNPJ_informado(String CNPJ_informado)
    {
        if(CNPJ_informado.length()==14 && validador_de_digitos.isNumeric(CNPJ_informado)==true) //Mas caso um CPF de 11 digitos seja informado:
        {
            conexao = ModuloConexao.conector();
            String sql="select * from fornecedores where CNPJ_Fornecedor=?";
            try
            {
              pst = conexao.prepareStatement(sql);
              pst.setString(1, CNPJ_informado);
              rs = pst.executeQuery();
              
              if(rs.next())
              JOptionPane.showMessageDialog(null, "CNPJ já cadastrado!");
              else
              { 
                this.checkin = checkin+1;
                this.cnpj = CNPJ_informado;
              }
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
        }
        else
        JOptionPane.showMessageDialog(null,"CNPJ invalido!");  
    }
    
    public void setInscricao(String inscricao)
    {
        if(inscricao.length()==0)
        this.checkin = checkin+1;
        else if(inscricao.length()==8 && validador_de_digitos.isNumeric(inscricao)==true) //Mas caso um CPF de 11 digitos seja informado:
        {
            conexao = ModuloConexao.conector();
            String sql="select * from fornecedores where Inscricao=?";
            try
            {
              pst = conexao.prepareStatement(sql);
              pst.setString(1, inscricao);
              rs = pst.executeQuery();
              
              if(rs.next())
              JOptionPane.showMessageDialog(null, "Número de Inscrição já cadastrado!");
              else
              { 
                this.checkin = checkin+1;
                this.inscricao = inscricao;
              }
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
        }
        else
        JOptionPane.showMessageDialog(null,"Inscrição invalida!");  
    }
    
    public void setNome_Representante_informado(String nome_representante_informado)
    {
      //Os comentários deste primeiro métodos são pertinentes para todos os outros métodos Setter, com apenas algumas diferenças referentes aos dados
        
        if(nome_representante_informado.length()==0)
        {
        //Caso o campo não esteja em branco (tamanho da string maior que 0...)
            this.checkin = checkin+1; 
            this.fornecedor = false;
        }//Contador avança com o objetivo de ao final garantir que todos os checkins de coerência foram cumpridos
        else if(nome_representante_informado.length()>0)
        {
          nome_representante = nome_representante_informado;
          this.checkin = checkin+1;
          this.fornecedor=true;
        }
        else
        JOptionPane.showMessageDialog(null,"Nome do representante invalido!");
    }

    public void setEmail_Representante_informado(String email_representante_informado)
    {
        if(email_representante_informado.length()==0) //Caso o e-mail (dado não obrigatorio) esteja com o campo em branco, o contador de validação também avança pois é permitida a entrada em branco do campo
        this.checkin = checkin+1;
        //Caso o campo não esteja em banco e contenha no minimo 10 digitos (usei como referência que um e-mail precisa ter ao menos um "@", um ".com" e um servidor "gmail/hotmail/yahoo, etc" e isso dá no mínimo 10 dígitos
        else if(email_representante_informado.length()>=10 && email_representante_informado.toLowerCase().contains("@") && email_representante_informado.toLowerCase().contains(".com".toLowerCase()))
         {
           conexao = ModuloConexao.conector();
           String sql="select * from Representante_Fornecedor where Email_Representante=?";
           try
           {
              pst = conexao.prepareStatement(sql);
              pst.setString(1, email_representante_informado);
              rs = pst.executeQuery();
              
              if(rs.next())
              JOptionPane.showMessageDialog(null, "Email do representante do Fornecedor já cadastrado!");
              else
              { 
                this.checkin = checkin+1;
                email_representante = email_representante_informado;
              }
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
         }
         else //Caso contrário se o campo conter menos de 10 digitos:
         JOptionPane.showMessageDialog(null,"E-mail invalido!");
    }
    
    public void setTelefone1_Representante_informado(String telefone1_representante_informado)
    {
        if(telefone1_representante_informado.length()==0)
        this.checkin = checkin+1;
        else if(telefone1_representante_informado.length()==10 && validador_de_digitos.isNumeric(telefone1_representante_informado)==true)//Verificação do número ter ao menos 11 dígitos (DDD+9+XXXXXXXX) valida-se se os digitos informados foram realmente números com a classe externa is_numeric
        {
          conexao = ModuloConexao.conector();
          String sql="select * from Representante_Fornecedor_Telefone where Num_Telefone1=? or Num_Telefone2=?";
          try
          {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, telefone1_representante_informado);
            pst.setString(2, telefone1_representante_informado);
            rs = pst.executeQuery();  
            
            if(rs.next())
            JOptionPane.showMessageDialog(null, "Telefone 1 do Fornecedor já cadastrado!");
            else
            { 
              this.checkin = checkin+1;
              telefone1_representante = telefone1_representante_informado;
            }
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
        }
        else
        JOptionPane.showMessageDialog(null,"Telefone 1 do Rrepresentante do Fornecedor invalido! Verifique se os 10 digitos foram informados corretamente! Exe: 7186905914");
    }
    
    public void setTelefone2_Representante_informado(String telefone2_representante_informado)
    {
        if(telefone2_representante_informado.length()==0)
        this.checkin = checkin+1;
        else if(telefone2_representante_informado.length()==10 && validador_de_digitos.isNumeric(telefone2_representante_informado)==true)//Verificação do número ter ao menos 11 dígitos (DDD+9+XXXXXXXX) valida-se se os digitos informados foram realmente números com a classe externa is_numeric
        {
          conexao = ModuloConexao.conector();
          String sql="select * from Representante_Fornecedor_Telefone where Num_Telefone1=? or Num_Telefone2=?";
          try
          {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, telefone2_representante_informado);
            pst.setString(2, telefone2_representante_informado);
            rs = pst.executeQuery();  
            
            if(rs.next())
            JOptionPane.showMessageDialog(null, "Telefone 2 do Fornecedor já cadastrado!");
            else
            { 
              this.checkin = checkin+1;
              telefone2_representante = telefone2_representante_informado;
            }
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
        }
        else
        JOptionPane.showMessageDialog(null,"Telefone 1 do Rrepresentante do Fornecedor invalido! Verifique se os 10 digitos foram informados corretamente! Exe: 7186905914");
    }
    
    public void SetCheckin(int checkin)
    { this.checkin=checkin; }
    
    public int getCheckin()
    { return checkin; } //Retorna o valor do contador para a classe do menu para que os eventos sejam realizados a partir da verificação
    
    public int cadastro_banco(int validador) //O método recebe o valor de checkin para garantir que os dados foram corretamente inseridos
    {
        if(validador==15) //caso todas as validações estarem corretas
        {
            String sql = "insert into fornecedores(Nome_Fornecedor,Email_Fornecedor,CNPJ_Fornecedor,Inscricao) values(?,?,?,?)";
            conexao = ModuloConexao.conector();
            //Instrução ao banco para que seja inserido respectivamente nos campos entre parenteses os dados que serão informados por passagem de parâmetro \/
            try
            {
              pst=conexao.prepareStatement(sql);
              pst.setString(1, this.nome); //primeiro ? referente ao nome setado na class caso esteja correto
              pst.setString(2, this.email); //e assim sucessivamente...
              pst.setString(3, this.cnpj);
              pst.setString(4, this.inscricao);
              pst.executeUpdate(); //Cadastro no banco realizado e limpeza dos campos de dados:
            }
            catch (Exception e)
            {   
                checkin=-1;
                JOptionPane.showMessageDialog(null,e);
            }
            finally
            {
              try
              { conexao.close(); }
              catch (Exception e)
              { JOptionPane.showMessageDialog(null,e); }
            }
            
            conexao = ModuloConexao.conector();
            try
            {
              pst=conexao.prepareStatement("SELECT MAX(Codigo_Fornecedor) FROM fornecedores");
              rs = pst.executeQuery();
              if(rs.next())
              id = rs.getString(1);
            }
            catch (Exception e)
            {   
                checkin=-1;
                JOptionPane.showMessageDialog(null,e);
            }
            finally
            {
              try
              { conexao.close(); }
              catch (Exception e)
              { JOptionPane.showMessageDialog(null,e); }
            }
            
            conexao = ModuloConexao.conector();
            try
            {
              sql = "insert into endereco_fornecedor(Codigo_Fornecedor,Localizacao,Nome_Rua,Num_Rua,Bairro,CEP) values(?,?,?,?,?,?)";
              pst=conexao.prepareStatement(sql);
              pst.setString(1, id);
              pst.setString(2, this.localizacao);
              pst.setString(3, this.rua);
              pst.setString(4, this.num);
              pst.setString(5, this.bairro);
              pst.setString(6, this.cep);
              pst.executeUpdate();
            }
            catch (Exception e)
            {   
                checkin=-1;
                JOptionPane.showMessageDialog(null,e);
            }
            finally
            {
              try
              { conexao.close(); }
              catch (Exception e)
              { JOptionPane.showMessageDialog(null,e); }
            }
            
            conexao = ModuloConexao.conector();
            try
            {
              sql = "insert into telefones_fornecedor(Codigo_Fornecedor,Num_Telefone1,Num_Telefone2) values(?,?,?)";
              pst=conexao.prepareStatement(sql);
              pst.setString(1, id);
              pst.setString(2, this.telefone1);
              pst.setString(3, this.telefone2);
              pst.executeUpdate();
            }
            catch (Exception e)
            {   
                checkin=-1;
                JOptionPane.showMessageDialog(null,e);
            }
            finally
            {
              try
              { conexao.close(); }
              catch (Exception e)
              { JOptionPane.showMessageDialog(null,e); }
            }
            
            if(this.fornecedor==true)
            {
            conexao = ModuloConexao.conector();
            try
            {
              sql = "insert into Representante_Fornecedor(Codigo_Fornecedor,Nome_Representante,Email_Representante) values(?,?,?)";
              pst=conexao.prepareStatement(sql);
              pst.setString(1, id);
              pst.setString(2, nome_representante);
              pst.setString(3, email_representante);
              pst.executeUpdate();
            }
            catch (Exception e)
            {   
                checkin=-1;
                JOptionPane.showMessageDialog(null,e);
            }
            finally
            {
              try
              { conexao.close(); }
              catch (Exception e)
              { JOptionPane.showMessageDialog(null,e); }
            }
            
            conexao = ModuloConexao.conector();
            try
            {
              pst=conexao.prepareStatement("SELECT MAX(Codigo_Representante) FROM Representante_Fornecedor");
              rs = pst.executeQuery();
              if(rs.next())
              id_representante = rs.getString(1);
            }
            catch (Exception e)
            {   
                checkin=-1;
                JOptionPane.showMessageDialog(null,e);
            }
            finally
            {
              try
              { conexao.close(); }
              catch (Exception e)
              { JOptionPane.showMessageDialog(null,e); }
            }
            
            conexao = ModuloConexao.conector();
            try
            {
              sql = "insert into Representante_Fornecedor_Telefone(Codigo_Representante,Num_Telefone1,Num_Telefone2) values(?,?,?)";
              pst=conexao.prepareStatement(sql);
              pst.setString(1, id_representante);
              pst.setString(2, telefone1_representante);
              pst.setString(3, telefone2_representante);
              pst.executeUpdate();
            }
            catch (Exception e)
            {   
                checkin=-1;
                JOptionPane.showMessageDialog(null,e);
            }
            finally
            {
              try
              { conexao.close(); }
              catch (Exception e)
              { JOptionPane.showMessageDialog(null,e); }
            }
            }
            
            this.nome="";
            this.inscricao="";
            this.localizacao="";
            this.rua="";
            this.num="";
            this.bairro="";
            this.cep="";
            this.email="";
            this.cnpj="";
            this.telefone1="";
            this.telefone2="";
            nome_representante="";
            email_representante="";
            telefone1_representante="";
            telefone2_representante="";
            id = "";
            id_representante = "";
            if(checkin==-1)
            {
                JOptionPane.showMessageDialog(null, "O cadastro não foi bem sucedido!");
            }
            else
            {
                this.checkin=0;
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            }
        }
        else
        { 
            this.checkin=0;        
            JOptionPane.showInputDialog(null, "Um ou mais dados estão inválidos!"); 
        }
        return 0;
       }
}