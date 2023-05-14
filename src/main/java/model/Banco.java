package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Usuario;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSquencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSquencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSquencial++);
		empresa2.setNome("Caelum");
		lista.add(empresa);
		lista.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("raf");
		u1.setSenha("123");
		Usuario u2 = new Usuario();
		u2.setLogin("eluf");
		u2.setSenha("123");

		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSquencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
		
		/*
		 * for (Empresa empresa : lista) { if(empresa.getId() == id) {
		 * lista.remove(empresa); } }
		 */
		
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario u : listaUsuarios) {
			if(u.ehIgual(login, senha)) {
				return u;
			}
		}
		return null;
	}

}