package menus;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Observação: os trechos de código referentes ao JFrame (posicionamento de botões, imagem de fundo, etc) estão detalhados na classe "Tela_inicial" (tela inicial) e o detalhamento é pertinente para todas as outras classes deste pacote (menus)

public class Area_do_Cliente
{   
  public void area_clientes()
  {
    Background_image tela_clientes = new Background_image
    ( 
        new ImageIcon("src/imagens/visuais_background_clientes1.gif").getImage()
    );

    Icon icone_cadastrar = new ImageIcon("src/imagens/visuais_botao_cadastrar.gif");
    Icon icone_acesso = new ImageIcon("src/imagens/visuais_botao_acess_cl.gif");

    JButton bt_cadastrar = new JButton(icone_cadastrar);
    JButton bt_acesso = new JButton(icone_acesso);
    JButton bt_voltar = new JButton("Voltar");
    bt_cadastrar.setBounds(219, 152, 366 , 116);
    bt_acesso.setBounds(218, 285, 366 , 115);
    bt_voltar.setBounds(-1,-1,120,33);
    
    //Adiciona cor ao botão voltar:
    bt_voltar.setBackground(Color.decode("#141679"));
    bt_voltar.setForeground(Color.yellow);
        
    final JFrame frame_clientes = new JFrame();
    frame_clientes.setTitle("Área do Cliente");
    frame_clientes.getContentPane().add(bt_cadastrar);
    frame_clientes.getContentPane().add(bt_acesso);
    frame_clientes.getContentPane().add(bt_voltar);
    frame_clientes.getContentPane().add(tela_clientes);
    frame_clientes.pack();
    frame_clientes.setVisible(true);
    frame_clientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame_clientes.setResizable(false);
    frame_clientes.setLocationRelativeTo(null);
        
    bt_voltar.addMouseListener(new MouseAdapter() //Volta pra tela anterior
    {
      public void mouseClicked(MouseEvent e)
      { 
       frame_clientes.dispose();
       Tela_inicial call = new Tela_inicial();
       call.tela_inicial();
      }
    }
                              );
    
    bt_cadastrar.addMouseListener(new MouseAdapter() //Evento do clique esquerdo do mouse no botão "Cadastrar cliente"(bt_cadastrar)
    {
      public void mouseClicked(MouseEvent e)
      {
        int opcao_escolhida=0; //Variável inteira que vai receber o retorno do JOptionPane
            
        String[] opcoes_adm = {"Pessoa Fisica", "Juridica"}; //Vetor de string que armazena as opções que serão exibidas no JOptionPane
             
        opcao_escolhida = JOptionPane.showOptionDialog(null, "Informe o tipo de cliente:",null,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes_adm, opcoes_adm[0]); // <- Passagem do vetor de strings para exibição das opções
            
        if(opcao_escolhida==0 || opcao_escolhida==1)
        { 
          Cadastro_Cliente novo_cadastro = new Cadastro_Cliente(opcao_escolhida);
          novo_cadastro.setVisible(true);
          //Caso a opção escolhida seja "Pessoa Física" (retorno 0) a tela seguinte irá ter como preenchimento o campo "CPF", caso Pessoa Juridica (retorno 1) CNPJ
          frame_clientes.dispose();
        }
      }
    }
                                  ); 
    
    bt_acesso.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        int opcao_escolhida=0;
            
        String[] opcoes_adm = {"Pessoa Fisica", "Juridica"};
          
        opcao_escolhida = JOptionPane.showOptionDialog(null, "Informe o tipo de cliente:",null,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes_adm, opcoes_adm[0]); 
            
        if(opcao_escolhida==0 || opcao_escolhida==1)
        { 
          Acesso_Cliente novo_cadastro = new Acesso_Cliente(opcao_escolhida);
          novo_cadastro.setVisible(true);
          //Caso a opção escolhida seja "Pessoa Física" (retorno 0) a tela seguinte irá ter como preenchimento o campo "CPF", caso Pessoa Juridica (retorno 1) CNPJ
          frame_clientes.dispose();
        }
      }
    }
                                  ); 
    
    
  }
}