package forro_CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import banco.ModuloConexao;

public class Insert_forro extends Forro//Principal filho da classe Clientes, aqui é realizado a validação dos dados e cadastro no Banco de Dados informados nos menus de inserção de dados
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
          this.nome_forro = nome_informado; //Setagem do dado para o campo da Class
        }
        else
        JOptionPane.showMessageDialog(null,"Nome invalido!");
    }
    
     public void setcor_informada(String cor_informada)
     {
      //Os comentários deste primeiro métodos são pertinentes para todos os outros métodos Setter, com apenas algumas diferenças referentes aos dados
        if(cor_informada.length()>3) //Caso o campo não esteja em branco (tamanho da string maior que 0...)
        {
          this.checkin = checkin+1; //Contador avança com o objetivo de ao final garantir que todos os checkins de coerência foram cumpridos
          this.cor = cor_informada; //Setagem do dado para o campo da Class
         }
        else
        JOptionPane.showMessageDialog(null,"Cor invalida!");
    }
   
    public void settamanho_informado(double tamanho_informado)
    {
      //Os comentários deste primeiro métodos são pertinentes para todos os outros métodos Setter, com apenas algumas diferenças referentes aos dados
        if(tamanho_informado>0) //Caso o campo não esteja em branco (tamanho da string maior que 0...)
        {
          this.checkin = checkin+1; //Contador avança com o objetivo de ao final garantir que todos os checkins de coerência foram cumpridos
          this.tamanho_peca = tamanho_informado; //Setagem do dado para o campo da Class
        }
        else
        JOptionPane.showMessageDialog(null,"Tamanho da peça informado invalido!");
    }
    
    public void setqt_pecas_informado(double qt_pecas_informado)
    {
      //Os comentários deste primeiro métodos são pertinentes para todos os outros métodos Setter, com apenas algumas diferenças referentes aos dados
        if(qt_pecas_informado>0) //Caso o campo não esteja em branco (tamanho da string maior que 0...)
        {
          this.checkin = checkin+1; //Contador avança com o objetivo de ao final garantir que todos os checkins de coerência foram cumpridos
          this.qt_pecas = qt_pecas_informado; //Setagem do dado para o campo da Class
        }
        else
        JOptionPane.showMessageDialog(null,"Quantidade de peças informadas invalida!");
    }
    
    public void setqt_M2(double qt_M2)
    {
      //Os comentários deste primeiro métodos são pertinentes para todos os outros métodos Setter, com apenas algumas diferenças referentes aos dados
        if(qt_M2>0) //Caso o campo não esteja em branco (tamanho da string maior que 0...)
        {
          this.checkin = checkin+1; //Contador avança com o objetivo de ao final garantir que todos os checkins de coerência foram cumpridos
          this.qt_m2 = qt_M2; //Setagem do dado para o campo da Class
        }
        else
        JOptionPane.showMessageDialog(null,"Quantidade em M² informada invalida!");
    }
    
     public void setvalor_M2(double valor_M2)
    {
      //Os comentários deste primeiro métodos são pertinentes para todos os outros métodos Setter, com apenas algumas diferenças referentes aos dados
        if(valor_M2>0) //Caso o campo não esteja em branco (tamanho da string maior que 0...)
        {
          this.checkin = checkin+1; //Contador avança com o objetivo de ao final garantir que todos os checkins de coerência foram cumpridos
          this.valor_m2 = valor_M2; //Setagem do dado para o campo da Class
        }
        else
        JOptionPane.showMessageDialog(null,"Valor em M² informada invalida!");
    }
    
    public void SetCheckin(int checkin)
    { this.checkin=checkin; }
     
    public int getCheckin()
    { return checkin; } //Retorna o valor do contador para a classe do menu para que os eventos sejam realizados a partir da verificação
    
    public int cadastro_banco(int validador,int id_fornecedor) //O método recebe o valor de checkin para garantir que os dados foram corretamente inseridos
    {
        if(validador==6 && id_fornecedor>0) //caso todas as validações estarem corretas
        {
            /*conexao = ModuloConexao.conector();*/
            sql = "insert into Forro(Codigo_Fornecedor,Nome_Forro,Cor,Descricao,Tamanho_Peca,Quantidade_Pecas,Quantidade_Metro2,Valor_M2) values(?,?,?,?,?,?,?,?)";
            conexao = ModuloConexao.conector();
            //Instrução ao banco para que seja inserido respectivamente nos campos entre parenteses os dados que serão informados por passagem de parâmetro \/
            try
            {
              pst=conexao.prepareStatement(sql);
              pst.setInt(1, id_fornecedor);
              pst.setString(2, this.nome_forro); //primeiro ? referente ao nome setado na class caso esteja correto
              pst.setString(3, this.cor); //e assim sucessivamente...
              pst.setString(4, this.descricao);
              pst.setDouble(5, this.tamanho_peca);
              pst.setDouble(6, this.qt_pecas);
              pst.setDouble(7, this.qt_m2);
              pst.setDouble(8, this.valor_m2);
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
            
            this.checkin=0;
            this.nome_forro="";
            this.cor="";
            this.descricao="";
            this.tamanho_peca=0;
            this.qt_m2=0;
            this.qt_pecas=0;
            this.valor_m2=0;
            id_fornecedor=0;
            if(checkin==-1)
            {
                JOptionPane.showMessageDialog(null, "O cadastro não foi sucedido!");
                checkin=0;
            }
            else
            {
                checkin=0;
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