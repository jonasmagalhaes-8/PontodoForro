package menus;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

//Observação: os trechos de código referentes ao JFrame (posicionamento de botões, imagem de fundo, etc) estão detalhados na classe "Tela_inicial" (tela inicial) e o detalhamento é pertinente para todas as outras classes deste pacote (menus)

public class Area_do_Submenu_vendas
{   
  public void area_vendas()
  {
    Background_image tela_clientes = new Background_image
    ( 
        new ImageIcon("src/imagens/visuais_background_vendas.gif").getImage()
    );

    Icon icone_nova_venda = new ImageIcon("src/imagens/visuais_botao_nova_venda_1.gif");
    Icon icone_acesso = new ImageIcon("src/imagens/visuais_botao_historico.gif");

    JButton bt_nova_venda = new JButton(icone_nova_venda);
    JButton bt_acesso = new JButton(icone_acesso);
    JButton bt_voltar = new JButton("Voltar");
    bt_nova_venda.setBounds(219, 152, 366 , 116);
    bt_acesso.setBounds(218, 285, 366 , 115);
    bt_voltar.setBounds(-1,-1,120,33);
    
    //Adiciona cor ao botão voltar:
    bt_voltar.setBackground(Color.decode("#141679"));
    bt_voltar.setForeground(Color.yellow);
        
    final JFrame frame_vendas = new JFrame();
    frame_vendas.setTitle("Vendas");
    frame_vendas.getContentPane().add(bt_nova_venda);
    frame_vendas.getContentPane().add(bt_acesso);
    frame_vendas.getContentPane().add(bt_voltar);
    frame_vendas.getContentPane().add(tela_clientes);
    frame_vendas.pack();
    frame_vendas.setVisible(true);
    frame_vendas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame_vendas.setResizable(false);
    frame_vendas.setLocationRelativeTo(null);
        
    bt_voltar.addMouseListener(new MouseAdapter() //Volta pra tela anterior
    {
      public void mouseClicked(MouseEvent e)
      { 
        Area_do_menu_vendas vendas = new Area_do_menu_vendas();
        frame_vendas.dispose();
        vendas.tela_vendas();
      }
    }
                              );
    
    bt_nova_venda.addMouseListener(new MouseAdapter() //Evento do clique esquerdo do mouse no botão "Cadastrar cliente"(bt_nova_venda)
    {
      public void mouseClicked(MouseEvent e)
      {
        Cadastro_Venda venda = new Cadastro_Venda();
        frame_vendas.dispose();
        venda.setVisible(true);
      }
    }
                                  ); 
    
    bt_acesso.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        Acesso_Historico_Vendas acesso = new Acesso_Historico_Vendas();
        frame_vendas.dispose();
        acesso.setVisible(true);
      }
    }
                                  ); 
  }
}