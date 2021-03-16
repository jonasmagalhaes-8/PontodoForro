package menus;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Area_do_menu_vendas
{     
  public void tela_vendas()
  { 
    //Cria-se um objeto da classe background_image que recebe como argumento uma imagem qualquer e a desenha na tela  
    Background_image imagem_tela_inicial = new Background_image
    ( 
      //Todas as imagens estão no pacote e podem ser acessadas a partir de qualquer classe, neste projeto todas foram acessadas a partir da função getResource pela classe Tela_inicial   
      new ImageIcon("src/imagens/visuais_background_vendas_1.png").getImage()
            
    );
    
    final JFrame frame_vendas = new JFrame(); //Criação do JFrame da classe
    //Criação dos ícones dos botões \/
    Icon icone_fornecedores = new ImageIcon("src/imagens/visuais_botao_fornecedores.gif");
    Icon icone_produto = new ImageIcon("src/imagens/visuais_botao_produto.gif");
    Icon icone_vendas = new ImageIcon("src/imagens/visuais_botao_vendas.gif");
    //Criação dos botões
    JButton bt_fornecedores = new JButton(icone_fornecedores);
    JButton bt_produto = new JButton(icone_produto);
    JButton bt_vendas = new JButton(icone_vendas); 
    JButton bt_voltar = new JButton("Voltar");
    bt_fornecedores.setBounds(217, 155, 366 , 115);
    bt_produto.setBounds(217, 290, 366 , 115);
    bt_vendas.setBounds(217, 425, 366 , 115);
    bt_voltar.setBounds(0,0,120,33);
    bt_voltar.setBackground(Color.decode("#141679"));
    bt_voltar.setForeground(Color.yellow);
    frame_vendas.getContentPane().add(bt_fornecedores);
    frame_vendas.getContentPane().add(bt_produto);
    frame_vendas.getContentPane().add(bt_vendas); 
    
    //Adicionando os botões e imagem de fundo anteriormentes criados ao JFrame
    frame_vendas.getContentPane().add(bt_fornecedores);
    frame_vendas.getContentPane().add(bt_produto);
    frame_vendas.getContentPane().add(bt_vendas);
    frame_vendas.getContentPane().add(bt_voltar);
    frame_vendas.getContentPane().add(imagem_tela_inicial);
    
    bt_fornecedores.addMouseListener(new MouseAdapter() //Evento do clique esquerdo do mouse no botão "Clientes"(bt_fornecedores)
    {
      public void mouseClicked(MouseEvent e)
      { 
        Area_do_Fornecedor fornecedor = new Area_do_Fornecedor();
        frame_vendas.dispose();
        fornecedor.area_fornecedor();
      }
    }
                                );
    
    bt_produto.addMouseListener(new MouseAdapter() //Evento do clique esquerdo do mouse no botão "Clientes"(bt_fornecedores)
    {
      public void mouseClicked(MouseEvent e)
      { 
        //Ao clicar no botão, cria-se um objeto da tela Área do cliente, elimina-se o frame da Tela_inicial e passa-se pra próxima tela onde o mesmo processo ocorrido nesta classe se repete
        Area_dos_Forros produtos = new Area_dos_Forros();
        frame_vendas.dispose();
        produtos.area_produtos();
      }
    }
                                );
    
    bt_vendas.addMouseListener(new MouseAdapter() //Evento do clique esquerdo do mouse no botão "Clientes"(bt_fornecedores)
    {
      public void mouseClicked(MouseEvent e)
      { 
        Area_do_Submenu_vendas vendas = new Area_do_Submenu_vendas();
        frame_vendas.dispose();
        vendas.area_vendas();
      }
    }
                                );
    
    bt_voltar.addMouseListener(new MouseAdapter() //Volta pra tela anterior
    {
      public void mouseClicked(MouseEvent e)
      { 
       frame_vendas.dispose();
       Tela_inicial call = new Tela_inicial();
       call.tela_inicial();
      }
    }
                              ); 
    
   frame_vendas.pack();
   frame_vendas.setTitle("Área de Vendas");
   frame_vendas.setVisible(true);
   frame_vendas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fecha o programa na saída
   frame_vendas.setResizable(false); //Impede que a tela seja redimensionada
   frame_vendas.setLocationRelativeTo(null); //Posiciona o frame ao centro da tela
  }
}