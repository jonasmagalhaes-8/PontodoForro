package menus;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

//Observação: os trechos de código referentes ao JFrame (posicionamento de botões, imagem de fundo, etc) estão detalhados na classe "Tela_inicial" (tela inicial) e o detalhamento é pertinente para todas as outras classes deste pacote (menus)

public class Area_do_Fornecedor
{   
  public void area_fornecedor()
  {
    Background_image tela_clientes = new Background_image
    ( 
        new ImageIcon("src/imagens/visuais_background_fornecedor.gif").getImage()
    );

    Icon icone_cadastrar = new ImageIcon("src/imagens/visuais_botao_cadastrar_fornecedor_1.gif");
    Icon icone_acesso = new ImageIcon("src/imagens/visuais_botao_acessar_fornecedor_1.gif");

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
    frame_clientes.setTitle("Área do Fornecedor");
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
        Area_do_menu_vendas vendas = new Area_do_menu_vendas();
        frame_clientes.dispose();
        vendas.tela_vendas();
      }
    }
                              );
    
    bt_cadastrar.addMouseListener(new MouseAdapter() //Evento do clique esquerdo do mouse no botão "Cadastrar cliente"(bt_cadastrar)
    {
      public void mouseClicked(MouseEvent e)
      {
        Cadastro_Fornecedor fornecedor = new Cadastro_Fornecedor();
        frame_clientes.dispose();
        fornecedor.setVisible(true);
      }
    }
                                  ); 
    
    bt_acesso.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        Acesso_Fornecedor acesso_fornecedor = new Acesso_Fornecedor();
        frame_clientes.dispose();
        acesso_fornecedor.setVisible(true);
      }
    }
                                  ); 
    
    
  }
}