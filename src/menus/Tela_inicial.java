package menus;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Tela_inicial
{     
  public void tela_inicial()
  { 
    //Cria-se um objeto da classe background_image que recebe como argumento uma imagem qualquer e a desenha na tela  
    Background_image imagem_tela_inicial = new Background_image
    ( 
      //Todas as imagens estão no pacote e podem ser acessadas a partir de qualquer classe, neste projeto todas foram acessadas a partir da função getResource pela classe Tela_inicial   
      new ImageIcon("src/imagens/visuais_background_home.gif").getImage()
    );
    
    final JFrame frame_inicio = new JFrame(); //Criação do JFrame da classe
    //Criação dos ícones dos botões \/
    Icon icone_clientes = new ImageIcon("src/imagens/visuais_botao_clientes.gif");
    Icon icone_venda = new ImageIcon("src/imagens/visuais_botao_venda.gif");
    Icon icone_historico = new ImageIcon("src/imagens/visuais_botao_historico.gif");
    //Criação dos botões
    JButton bt_clientes = new JButton(icone_clientes);
    JButton bt_venda = new JButton(icone_venda);
    JButton bt_historico = new JButton(icone_historico);    
    //Posicionamento dos botões na tela e tamanho do botão
    bt_clientes.setBounds(217, 190, 366 , 115); // -> (respectivamente x,y,width, height)
    bt_venda.setBounds(217, 335, 366 , 115); // -> (respectivamente x,y,width, height)
    //bt_historico.setBounds(217, 385, 366 , 115); // -> (respectivamente x,y,width, height)
    //bt_historico.setEnabled(true); //Desativa o botão, esta função está em desenvolvimento. 
    
    //Adicionando os botões e imagem de fundo anteriormentes criados ao JFrame
    frame_inicio.getContentPane().add(bt_clientes);
    frame_inicio.getContentPane().add(bt_venda);
    //frame_inicio.getContentPane().add(bt_historico);
    frame_inicio.getContentPane().add(imagem_tela_inicial);
    
    bt_clientes.addMouseListener(new MouseAdapter() //Evento do clique esquerdo do mouse no botão "Clientes"(bt_clientes)
    {
      public void mouseClicked(MouseEvent e)
      { 
        //Ao clicar no botão, cria-se um objeto da tela Área do cliente, elimina-se o frame da Tela_inicial e passa-se pra próxima tela onde o mesmo processo ocorrido nesta classe se repete
        Area_do_Cliente call = new Area_do_Cliente();
        frame_inicio.dispose();
        call.area_clientes();
      }
    }
                                );
    
    bt_venda.addMouseListener(new MouseAdapter() //Evento do clique esquerdo do mouse no botão "Clientes"(bt_clientes)
    {
      public void mouseClicked(MouseEvent e)
      { 
        //Ao clicar no botão, cria-se um objeto da tela Área do cliente, elimina-se o frame da Tela_inicial e passa-se pra próxima tela onde o mesmo processo ocorrido nesta classe se repete
        Area_do_menu_vendas vendas = new Area_do_menu_vendas();
        frame_inicio.dispose();
        vendas.tela_vendas();
      }
    }
                                );
    
   frame_inicio.pack();
   frame_inicio.setTitle("Menu Inicial");
   frame_inicio.setVisible(true);
   frame_inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fecha o programa na saída
   frame_inicio.setResizable(false); //Impede que a tela seja redimensionada
   frame_inicio.setLocationRelativeTo(null); //Posiciona o frame ao centro da tela
  }
}