package forro_CRUD;

public abstract class Forro
{ 
  protected String nome_forro="", cor="",descricao="";
  protected double tamanho_peca,qt_pecas,valor_m2,qt_m2;
}
//Classe abstrata referente a Cliente, foi utilizada uma classe abstrata para que ela pode-se ser acessada apenas pelos seus filhos
//esta classe não contém "CPF" ou "CNPJ" como dados porque estes dados são características dos filhos cliente_fisico e cliente_empresa