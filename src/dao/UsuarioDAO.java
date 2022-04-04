
package dao;

import factory.Conexao;
import gui.Login;
import gui.MenuEmpresa;
import gui.MenuPrincipal;
import gui.Menualuno;
import gui.Menuorientador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class UsuarioDAO {
    
    private Connection connection;
    private int id;
    private String username;
    private String senha;
    private final Login gui;
    private String perfil;
    
     public UsuarioDAO(Login gui){ 
        this.connection = new Conexao().getConnection();
        this.gui = gui;
    }
     
     public void logar(){
       
         
         String username = gui.getTxtUsername().getText();
         String senha = gui.getTxtSenha().getText();
         
         try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        try (Connection conn = (Connection) 
                
                DriverManager.getConnection("jdbc:mysql://localhost:3306/bdjr?useTimezone=true&serverTimezone=UTC","root","12345678"); 
                Statement stmt = (Statement) conn.createStatement()) {

            String query = "select * from usuarios where username = '" + username +"' and senha = '" + senha + "'";

                try (ResultSet rs = stmt.executeQuery(query)) {
                    if (rs.next()) {
                        
                        String perfil = rs.getString("perfil");
                        
                        if("Aluno".equals(perfil)){
                           
                        
                           JOptionPane.showMessageDialog(null,"Conectado com sucesso");
                          
                              Menualuno menu = new Menualuno();
                              menu.setVisible(true);
                              this.gui.dispose();
                              
                           
                        
                          
                        }
                        else if("Administrador".equals(perfil)){
                           
                        
                           JOptionPane.showMessageDialog(null,"Conectado com sucesso");
                          
                              MenuPrincipal menuAdm = new MenuPrincipal();
                              menuAdm.setVisible(true);
                              this.gui.dispose();
                              
                           
                        
                          
                        } 
                        
                        else if("Orientador".equals(perfil)){
                           
                        
                           JOptionPane.showMessageDialog(null,"Conectado com sucesso");
                          
                              Menuorientador menuOtd = new Menuorientador();
                              menuOtd.setVisible(true);
                              this.gui.dispose();
                              
                           
                        
                          
                        } 
                        
                        else if("Empresa".equals(perfil)){
                           
                        
                           JOptionPane.showMessageDialog(null,"Conectado com sucesso");
                          
                              MenuEmpresa menuEmp = new MenuEmpresa();
                              menuEmp.setVisible(true);
                              this.gui.dispose();
                              
                           
                        
                          
                        } 
                        
                        
                    }
                    

                    else {
                        JOptionPane.showMessageDialog(null,"Usuário e/ou senha incorretos.");
                        gui.getTxtUsername().setText("");
                        gui.getTxtSenha().setText("");
                        
                    }   
                }
        
                    //caso seja preciso mais tipos de acesso, copie e cole o código do IF para cada cargo

    
        }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

       
      
}
      private void add(){
          String sql ="insert into usuarios(id,username,email,senha,curso) values(?,?,?,?,?)";
          try{
              pst = conexao.prepareStatement(sql);
              pst.setString(1,txtUsername.get.text());
          } catch(Exception e) {
              JOptionPane.showMessageDialog(null,e);
          }
          
     }
     
     
   }
     

    
