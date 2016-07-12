package devmedia.mongodb;

import static org.junit.Assert.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import devmedia.mongodb.entidades.Cliente;
import devmedia.mongodb.entidades.Produto;

public class TestesMongoDB {

	private static ApplicationContext contexto;
	
	private static Cliente cliente;
	
	private static MongoTemplate template;
	
	@Before
	public void setUp() throws Exception {
		if (contexto == null) {
			contexto = new ClassPathXmlApplicationContext("spring-data-mongodb.xml");
			cliente = new Cliente();
			cliente.setNome("Henrique");
			cliente.setSobrenome("Lobo Weissmann");
			cliente.setCpf("11111111111");
			cliente.setCarteiraIdentidade("RG-123456");
			cliente.setCompras(new HashSet<Produto>());
			cliente.getCompras().add(new Produto("Joystick", "Joystick para Xbox", 100d));
			cliente.getCompras().add(new Produto("Halo 4", "Jogo para XBox", 99d));
			template = contexto.getBean(MongoTemplate.class);
		}
	}
	
	@After
	public void after() {
		if (template != null) {
			template.getCollection("clientes").drop();
		}
	}

	@Test
	public void testPersistir() {
		assertNotNull(contexto);
		assertNotNull(template);
		
		template.save(cliente);
		
		
		Cliente persistido = template.findOne(query(where("nome").is("Henrique")), Cliente.class);
		assertNotNull(persistido);
		assertEquals(cliente.getNome(), persistido.getNome());
		assertEquals(cliente.getSobrenome(), persistido.getSobrenome());
		assertEquals(cliente.getCpf(), persistido.getCpf());
		assertEquals(cliente.getCarteiraIdentidade(), persistido.getCarteiraIdentidade());
		assertNotNull(persistido.getCompras());
		assertEquals(cliente.getCompras().size(), persistido.getCompras().size());
		assertFalse(persistido.getCompras().isEmpty());
		for (Produto produto : cliente.getCompras()) {
			assertTrue(persistido.getCompras().contains(produto));
		}
		assertNotNull(persistido.getId());
		System.out.println(persistido.getId());
	}

}
