package clientes_CRUD;

import classes_externas.validador_de_digitos;
import classes_externas.validador_cpf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import banco.ModuloConexao;

public class Insert_cliente extends Cliente//Principal filho da classe Clientes, aqui é realizado a validação dos dados e cadastro no Banco de Dados informados nos menus de inserção de dados
{
    private int checkin=0; //Variável responsável por contar se todos os dados informados foram devidamente validados
    String sql,id;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
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
         if(email_informado.length()==0) //Caso o e-mail (dado não obrigatorio) esteja com o campo em branco, o contador de validação também avança pois é permitida a entrada em branco do campo
         this.checkin = checkin+1;
         //Caso o campo não esteja em banco e contenha no minimo 10 digitos (usei como referência que um e-mail precisa ter ao menos um "@", um ".com" e um servidor "gmail/hotmail/yahoo, etc" e isso dá no mínimo 10 dígitos
         else if(email_informado.length()>=10 && email_informado.contains("@") && email_informado.contains("."))
         {
           conexao = ModuloConexao.conector();
           String sql="select * from clientes where Email_Cliente=?";
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
          String sql="select * from telefones_cliente where Num_Telefone2=?";
          try
          {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, telefone1_informado);
            rs = pst.executeQuery();  
            
            if(rs.next())
            JOptionPane.showMessageDialog(null, "Telefone 1 já cadastrado!");
            else
            { 
              this.checkin = checkin+1;
              this.telefone1 = telefone1_informado;
            }
          }
          catch (Exception e)
          { JOptionPane.showMessageDialog(null, "Telefone 1 já cadastrado!");}
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
          String sql="select * from telefones_cliente where Num_Telefone1=? or Num_Telefone2=?";
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
    
    public void setCp(String cp_informado)
    {
        if(cp_informado.length()==0)
        {//O cliente (meu pai) afirmou-me que o CPF não era obrigatorio, portanto o campo em branco é permitido
            this.checkin = checkin+1;
            this.cpf = "Não informado";
            this.cnpj = "Não informado";
        }
        else if(cp_informado.length()==11 && validador_de_digitos.isNumeric(cp_informado)==true && validador_cpf.validador_cpf(cp_informado)==true) //Mas caso um CPF de 11 digitos seja informado:
        {
            conexao = ModuloConexao.conector();
            String sql="select * from clientes where CPF_Cliente=?";
            try
            {
              pst = conexao.prepareStatement(sql);
              pst.setString(1, cp_informado);
              rs = pst.executeQuery();
              
              if(rs.next())
              JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
              else
              { 
                this.checkin = checkin+1;
                this.cpf = cp_informado;
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
        else if(cp_informado.length()==14 && validador_de_digitos.isNumeric(cp_informado)==true) //Mas caso um CPF de 11 digitos seja informado:
        {
            conexao = ModuloConexao.conector();
            String sql="select * from clientes where CNPJ_Cliente=?";
            try
            {
              pst = conexao.prepareStatement(sql);
              pst.setString(1, cp_informado);
              rs = pst.executeQuery();
              
              if(rs.next())
              JOptionPane.showMessageDialog(null, "CNPJ já cadastrado!");
              else
              { 
                this.checkin = checkin+1;
                this.cnpj = cp_informado;
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
        JOptionPane.showMessageDialog(null,"CPF/CNPJ invalido!");  
    }
    
    public void SetCheckin(int checkin)
    { this.checkin=checkin; }
    
    public int getCheckin()
    { return this.checkin; } //Retorna o valor do contador para a classe do menu para que os eventos sejam realizados a partir da verificação
    
    public int cadastro_banco(int validador) //O método recebe o valor de checkin para garantir que os dados foram corretamente inseridos
    {
        if(validador==9) //caso todas as validações estarem corretas
        {
            /*conexao = ModuloConexao.conector();*/
            String sql = "insert into clientes(Nome_Cliente,Email_Cliente,CPF_Cliente,CNPJ_Cliente) values(?,?,?,?)";
            conexao = ModuloConexao.conector();
            //Instrução ao banco para que seja inserido respectivamente nos campos entre parenteses os dados que serão informados por passagem de parâmetro \/
            try
            {
              pst=conexao.prepareStatement(sql);
              pst.setString(1, this.nome); //primeiro ? referente ao nome setado na class caso esteja correto
              pst.setString(2, this.email); //e assim sucessivamente...
              pst.setString(3, this.cpf);
              pst.setString(4, this.cnpj);
              pst.executeUpdate(); //Cadastro no banco realizado e limpeza dos campos de dados:
            }
            catch (Exception e)
            {
                this.checkin = -1;
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
              pst=conexao.prepareStatement("SELECT MAX(Codigo_Cliente) FROM clientes");
              rs = pst.executeQuery();
              if(rs.next())
              id = rs.getString(1);
            }
            catch (Exception e)
            {
                this.checkin = -1;
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
              sql = "insert into endereco_cliente(Codigo_Cliente,Nome_Rua,Num_Rua,Bairro,CEP) values(?,?,?,?,?)";
              pst=conexao.prepareStatement(sql);
              pst.setString(1, id);
              pst.setString(2, this.rua);
              pst.setString(3, this.num);
              pst.setString(4, this.bairro);
              pst.setString(5, this.cep);
              pst.executeUpdate();
            }
            catch (Exception e)
            {
                this.checkin = -1;
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
              sql = "insert into telefones_cliente(Codigo_Cliente,Num_Telefone1,Num_Telefone2) values(?,?,?)";
              pst=conexao.prepareStatement(sql);
              pst.setString(1, id);
              pst.setString(2, this.telefone1);
              pst.setString(3, this.telefone2);
              pst.executeUpdate();
            }
            catch (Exception e)
            {
                this.checkin = -1;
                JOptionPane.showMessageDialog(null,e);
            }
            finally
            {
              try
              { conexao.close(); }
              catch (Exception e)
              { JOptionPane.showMessageDialog(null,e); }
            }
            
            this.checkin=0;
            this.nome="";
            this.rua="";
            this.num="";
            this.bairro="";
            this.cep="";
            this.email="";
            this.cpf="";
            this.cnpj="";
            this.telefone1="";
            this.telefone2="";
            id="";
            if(checkin==-1)
            {
                JOptionPane.showMessageDialog(null, "O cadastro não foi realizado!");
                checkin=0;
            }
            else
            {
                checkin=0;
                validador=0;
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            }
        }
        else
        { 
            checkin=0;   
            JOptionPane.showInputDialog(null, "Um ou mais dados estão inválidos!"); 
        }
        return 0;
       }
}