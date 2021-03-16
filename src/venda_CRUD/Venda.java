package venda_CRUD;

import banco.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

public class Venda
{
    boolean sucesso=true;
    private double qt_M2,nova_quantidade;
    int id_forro;
    String sql;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private Date time = new Date();
    public void setData(long time)
    { this.time.setTime(time); }
    
    public boolean cadastro_banco(int codigo_cliente,int codigo_forro,String nome_cliente, String nome_produto, String fornecedor,double quantidade, double valor_total, String pagamento,int parcelamento,String data,double tamnho_peca,double valor_m2) //O método recebe o valor de checkin para garantir que os dados foram corretamente inseridos
    {
            id_forro=codigo_forro;
            this.qt_M2 = tamnho_peca*0.2;
            this.qt_M2 = this.qt_M2*quantidade;
            
            String sql = "insert into Vendas(Codigo_cliente,Codigo_Forro,Cliente,Produto,Fornecedor,Pecas,M2,Valor_Total,Pagamento,Parcelas,Data,Preco_M2) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            conexao = ModuloConexao.conector();
            //Instrução ao banco para que seja inserido respectivamente nos campos entre parenteses os dados que serão informados por passagem de parâmetro \/
            try
            {
              pst=conexao.prepareStatement(sql);
              pst.setInt(1, codigo_cliente); //primeiro ? referente ao nome setado na class caso esteja correto
              pst.setInt(2, codigo_forro); //e assim sucessivamente...
              pst.setString(3, nome_cliente);
              pst.setString(4, nome_produto);
              pst.setString(5, fornecedor);
              pst.setDouble(6, quantidade);
              pst.setDouble(7, this.qt_M2);
              pst.setDouble(8, valor_total);
              pst.setString(9, pagamento);
              pst.setInt(10, parcelamento);
              pst.setString(11, data);
              pst.setDouble(12, valor_m2);
              pst.executeUpdate(); //Cadastro no banco realizado e limpeza dos campos de dados:
            }
            catch (Exception e)
            { 
                sucesso=false;
                JOptionPane.showMessageDialog(null,e);
            }
            finally
            {
              try
              { conexao.close(); }
              catch (Exception e)
              { JOptionPane.showMessageDialog(null,e); }
            }
            
            return sucesso;
       }

    public void atualiza_quantidade(double quantidade_comprada, double estoque_atual,double tamnho_peca)
    {
        double qt_M2,nova_quantidade = estoque_atual-quantidade_comprada;
        
        qt_M2 = tamnho_peca*0.2;
        qt_M2 = qt_M2*nova_quantidade;
        
        conexao = ModuloConexao.conector();
        sql = "update Forro set Quantidade_Pecas=?, Quantidade_Metro2=? where Codigo_Forro=?";
        try
        {
          pst=conexao.prepareStatement(sql);
          pst.setDouble(1, nova_quantidade);
          pst.setDouble(2, qt_M2);
          pst.setInt(3, id_forro);
          pst.executeUpdate();
         }
         catch (Exception e)
         { JOptionPane.showMessageDialog(null,e); } 
    }
}
