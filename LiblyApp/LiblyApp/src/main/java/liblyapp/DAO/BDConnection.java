/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package liblyapp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BDConnection {
    private String driver;
    private String url;
    private String username;
    private String password;
    private Connection con;
    
    public void conectarBanco(){
            try{
                driver = "com.mysql.cj.jdbc.Driver";
                url = "jdbc:mysql://localhost:3308/teste";
                username = "root";
                password = "";

                Class.forName(driver);

                con = DriverManager.getConnection(url, username, password);

                System.out.println("Conexão feita com sucesso!");

                
            } catch(Exception e){
                e.printStackTrace();
            }
    }
    
    public String bdConsultarLoginAluno(String email){
            String senha = null;
                
            try{
                String query = "select email, senha from aluno where email = '"+email+"'";
                Statement stm = con.createStatement();
                
                ResultSet rs = stm.executeQuery(query);
                
                if(rs.next()){
                    senha = rs.getString("senha");
                }
                
            } catch(Exception e){
                e.printStackTrace();
            }
            return senha;
    }
            
    public void bdCadastrarAluno(String nome, String email, String senha, String telefone, String cpf){
            try{
                String query = "insert into aluno(nome, email, senha, telefone, CPF) values('"+ nome + "','" + email + "', '"+ senha +"','" + telefone + "','" + cpf+"')";
                System.out.println(query);
                Statement stm = con.createStatement();
                stm.execute(query);
                
            } catch(Exception e){
                e.printStackTrace();
            }
    }
            
}
