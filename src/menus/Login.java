package menus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import banco.ModuloConexao;
public class Login extends javax.swing.JFrame //Classe criada automaticamente pelo Netbeans
{
  Connection conexao = null; //Inicialização da variável "conexão" responsável por estabelecer a ligação com o Banco de Dados
  PreparedStatement pst = null; //Inicialização da variável "pst" responsável por preparar e enviar as instruções ao Banco de Dados
  ResultSet rs = null; //Inicialização da variável "rs" responsável por receber os resultados das instruções previamente enviadas ao Banco de Dados
  public void logar()
  {
    String sql="select * from login where login=? and senha=?";
    //String de instrução SQL para buscar (select) no Banco de Dados na tabela "tb_login" dados do campo onde (where) login e senha sejam iguais aos argumentos que serão passados (utiliza-se o ? para indicar que um argumento será utilizado na instrução)  
    try
    {
      pst = conexao.prepareStatement(sql); //Abre-se uma conexão com o Banco de Dados juntamente com a passagem da instrução sql anteriormente informada
      pst.setString(1, campo_login.getText()); //em "setString" passa-se como argumento para busca no Banco de maneira respectiva a instrução SQL a instrução que será enviada ao Banco, neste caso será utilizado a string do campo login digitado e extraida atráves da função .getText para que uma busca seja realizada
      pst.setString(2, campo_senha.getText()); //o mesmo ocorre aqui mas na posição 2 pois foi informado que 2 argumentos seriam utilizados na instrução sql, login e senha, respectivamente posições 1 e 2 na instrução
      rs = pst.executeQuery(); //rs recebe e armazena o resultado das instruções preparadas anteriormente e enviadas com a função executeQuery
      if(rs.next()) // Aqui é realizada a verificação da condição do rs/Result Set, onde um cursor percorre a tabela do banco de dados e enquanto a função .next retornar true o cursor é deslocado pro próximo registro.Quando o retorno chegar ao fim, a condição retorna false e não existem mais registros na tabela.
      {
        String tipo_cadastro = rs.getString(3); //Armazena-se na string criada o dado presente na 3ª coluna da tabela, neste caso, o campo onde encontra-se os logins existentes na tabela  
            
        if(tipo_cadastro.equals("Luciano")) //caso o dado da string tipo_cadastro seja igual ao texto "admin" o bloco é executado, onde cria-se um objeto da tela inicial (Tela_inicial)
        {
          Tela_inicial call = new Tela_inicial();
          call.tela_inicial();
          conexao.close(); //Fecha-se a conexão com o banco de dados
          this.dispose(); //Fecha se a tela de login
        }
        else
        JOptionPane.showMessageDialog(null,"Usuario e/ou Senha invalidos!");             
      }
      else
      JOptionPane.showMessageDialog(null,"Usuario e/ou Senha invalidos!");
    }
    catch (Exception e)
    { JOptionPane.showMessageDialog(null, e); }
  }
    
  public Login()
  {
    initComponents();
    conexao = ModuloConexao.conector(); //É inicializada a conexão com o Bnco de Dados
  }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        lbl_senha = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        campo_senha = new javax.swing.JPasswordField();
        campo_login = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN - Ponto do Forro");
        setResizable(false);

        lbl_senha.setText("Senha:");

        lbl_usuario.setText("Usuario:");

        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn_loginActionPerformed(evt);
            }
        });

        campo_senha.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                campo_senhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_login)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_usuario)
                            .addComponent(lbl_senha))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campo_login)
                            .addComponent(campo_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_usuario)
                    .addComponent(campo_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_senha)
                    .addComponent(campo_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_login)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(346, 165));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_loginActionPerformed
    {//GEN-HEADEREND:event_btn_loginActionPerformed
        logar();
    }//GEN-LAST:event_btn_loginActionPerformed

    
    
    
    
    
    
    
    
    
    
    
    
    private void campo_senhaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_campo_senhaActionPerformed
    {//GEN-HEADEREND:event_campo_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_senhaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JTextField campo_login;
    private javax.swing.JPasswordField campo_senha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_senha;
    private javax.swing.JLabel lbl_usuario;
    // End of variables declaration//GEN-END:variables
}
