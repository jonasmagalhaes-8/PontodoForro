package menus;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

//Observação: os trechos de código referentes ao JFrame (posicionamento de botões, imagem de fundo, etc) estão detalhados na classe "Tela_inicial" (tela inicial) e o detalhamento é pertinente para todas as outras classes deste pacote (menus)

public class Area_dos_Forros
{   
  public void area_produtos()
  {
    Background_image tela_clientes = new Background_image
    ( 
        new ImageIcon("src/imagens/visuais_background_produtos.gif").getImage()
    );

    Icon icone_cadastrar = new ImageIcon("src/imagens/visuais_botao_cadastrar_produto_1.gif");
    Icon icone_acesso = new ImageIcon("src/imagens/visuais_botao_acessar_produto_1.gif");

    JButton bt_cadastrar = new JButton(icone_cadastrar);
    JButton bt_acesso = new JButton(icone_acesso);
    JButton bt_voltar = new JButton("Voltar");
    bt_cadastrar.setBounds(219, 152, 366 , 116);
    bt_acesso.setBounds(218, 285, 366 , 115);
    bt_voltar.setBounds(-1,-1,120,33);
    
    //Adiciona cor ao botão voltar:
    bt_voltar.setBackground(Color.decode("#141679"));
    bt_voltar.setForeground(Color.yellow);
        
    final JFrame frame_produtos = new JFrame();
    frame_produtos.setTitle("Área Produtos");
    frame_produtos.getContentPane().add(bt_cadastrar);
    frame_produtos.getContentPane().add(bt_acesso);
    frame_produtos.getContentPane().add(bt_voltar);
    frame_produtos.getContentPane().add(tela_clientes);
    frame_produtos.pack();
    frame_produtos.setVisible(true);
    frame_produtos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame_produtos.setResizable(false);
    frame_produtos.setLocationRelativeTo(null);
        
    bt_voltar.addMouseListener(new MouseAdapter() //Volta pra tela anterior
    {
      public void mouseClicked(MouseEvent e)
      { 
        Area_do_menu_vendas vendas = new Area_do_menu_vendas();
        frame_produtos.dispose();
        vendas.tela_vendas();
      }
    }
                              );
    
    bt_cadastrar.addMouseListener(new MouseAdapter() //Evento do clique esquerdo do mouse no botão "Cadastrar cliente"(bt_cadastrar)
    {
      public void mouseClicked(MouseEvent e)
      {
        Cadastro_Forro cadastro_forro = new Cadastro_Forro();
        frame_produtos.dispose();
        cadastro_forro.setVisible(true);
      }
    }
                                  ); 
    
    bt_acesso.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        Acesso_Forro acesso_forro = new Acesso_Forro();
        frame_produtos.dispose();
        acesso_forro.setVisible(true);
      }
    }
                                  ); 
    
    
  }
}