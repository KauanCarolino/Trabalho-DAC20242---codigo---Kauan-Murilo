package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.UsuarioDao;
import entidade.Usuario;

public class main {
    public static void main(String[] args) {
//        try {
//            // Create a new Usuario object
//            Usuario newUser = new Usuario();
//            newUser.setNome("Maria");
//            newUser.setSenha("1234443");
//            newUser.setSexo("F");
//            
//            // Convert String to Date
//            String dataNascimentoStr = "1996-08-15"; // Example date string
//            Date dataNascimento = parseDate(dataNascimentoStr);
//            newUser.setDataNascimento(dataNascimento);
//            
//            // Save the new user
//            UsuarioDao.salvar(newUser);
//            System.out.println("Usuário criado com sucesso!");
//            
//            // Optionally, retrieve and display the newly created user
//            Usuario createdUser = UsuarioDao.achar(newUser.getId());
//            System.out.println("Usuário criado: " + createdUser.getNome());
//            
//        } catch (ParseException e) {
//            System.out.println("Erro ao converter a data: " + e.getMessage());
//        } catch (RuntimeException e) {
//            System.out.println("Erro ao salvar o usuário: " + e.getMessage());
//        }
    	
    	Usuario user = UsuarioDao.achar(3);
    	System.out.println(user);
    	user.setNome("Kauan");
    	UsuarioDao.editar(user);
    	System.out.println(user);
    }
    
    private static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(dateString);
    }
}
