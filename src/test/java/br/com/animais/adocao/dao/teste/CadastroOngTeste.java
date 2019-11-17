package br.com.animais.adocao.dao.teste;

import junit.framework.Test;
import junit.framework.TestCase;

import br.com.animais.adocao.model.Endereco;
import br.com.animais.adocao.model.Ong;
import br.com.animais.adocao.model.Usuario;

class CadastroOngTeste extends TestCase {

	private Ong ong;

	public CadastroOngTeste(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ong = new Ong();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
	
	public void testCadastroOng() {
		Usuario usu = new Usuario();
		usu.setLogin("@gmail");
		usu.setSenha("senha");

		Endereco end = new Endereco();
		end.setLogradouro("log");
		end.setNumero("123");
		end.setBairro("Barra");
		end.setCep("89212-128");
		end.setCidade("Floria");
		end.setEstado("SC");

		ong.setUsuario(usu);
		ong.setEndereco(end);

		ong.setNome("Acao animal");
		ong.setTelefone("(99) 99999-9999");
		ong.setEmail("@gmail");
		ong.setDescricao("Animais de rua");
		ong.setCnpj("99.999.999/9999-99");
		assertEquals(ong.getNome(), "Acao animal");
		System.out.println("Ong:" + ong.getNome());
	}
}
