import java.sql.*;
import javax.swing.JOptionPane;
public class BD {
	
	public Connection c = null;
	private final String driver = "com.mysql.jdbc.Driver";
	private final String dbname = "pizzaria";
	// Credenciais lidas de variáveis de ambiente (com os valores locais padrão como fallback)
	private final String url = env("DB_URL", "jdbc:mysql://localhost:3306/" + dbname);
	private final String login = env("DB_USER", "root");
	private final String senha = env("DB_PASSWORD", "");

	private static String env(String nome, String padrao) {
		String valor = System.getenv(nome);
		return valor != null ? valor : padrao;
	}
	
	
	public boolean getConnection(){
		try{
			Class.forName(driver);
			c = DriverManager.getConnection(url,login,senha);
			System.out.println("Conectou");
			return true;
		}
			catch (ClassNotFoundException erro){
				JOptionPane.showMessageDialog(null,"Driver não encontrado\n" + erro.toString());
				return false;
			}
			catch (SQLException erro){
				JOptionPane.showMessageDialog(null,"Problema de conexão com a fonte de dados\n" + erro.toString());
				return false;
			}
			
		}
	public void close(){
		try{
			c.close();
			System.out.println("Desconectou");
		}catch(SQLException erro){
			System.out.println("Erro ao desconectar: " + erro.getMessage());
		}
	}
	
	}
