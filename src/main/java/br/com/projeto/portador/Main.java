package br.com.projeto.portador;


import br.com.projeto.portador.entity.Portador;
import br.com.projeto.portador.portadorDAO.PortadorDAO;

public class Main {

	public static void main(String[] args) {

        Portador portador = new Portador();
        PortadorDAO portadorDAO = new PortadorDAO();

		portador.setNome("Maria");
		portador.setCNPJ("11212312345");
		portador.setCPF("11212312345");

		//portadorDAO.create(portador);

		//for(Portador p : portadorDAO.getPortador()){
			//System.out.println("ID: " + p.getId() + " Nome: " + p.getNome() + " CNPJ: " + p.getCNPJ() + " CPF: " + p.getCPF());

		Portador p1 = new Portador();
		p1.setNome("Rodrigo");
		p1.setCNPJ("2");
		p1.setCPF("123456789123");
		p1.setId(1);

		//PortadorDAO.update(p1);

		portadorDAO.deleteByID(2);




	}


}

