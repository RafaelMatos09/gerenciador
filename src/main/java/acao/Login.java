package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		System.out.println("Logando" + login);

		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login,senha);
		
		if(usuario != null) {
			System.out.println("Usuario existe");;
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			System.out.println("Usuario não existe");
			return "redicrect:entrada?acao=LoginForm";
		}

		
	}

}
