package clientes_CRUD;

public abstract class Cliente
{ protected String nome="",rua="",num="",bairro="",cep="",email="",telefone1="",telefone2="",cpf="",cnpj=""; }
//Classe abstrata referente a Cliente, foi utilizada uma classe abstrata para que ela pode-se ser acessada apenas pelos seus filhos
//esta classe não contém "CPF" ou "CNPJ" como dados porque estes dados são características dos filhos cliente_fisico e cliente_empresa