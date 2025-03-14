package com.felipefariasdev.simple_todolist;

import com.felipefariasdev.simple_todolist.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class SimpleTodolistApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void createTodoSuccess() {
		Todo todo = new Todo("Fazer macarrão", false,4);
		webTestClient
				.post().uri("/todos")
				.bodyValue(todo).exchange()
				.expectStatus().isOk()
				.expectBody().jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].description").isEqualTo(todo.getDescription());
	}
	@Test
	void createTodoFailure() {
		Todo todo = new Todo("", false,4);
		webTestClient
				.post().uri("/todos")
				.bodyValue(todo).exchange()
				.expectStatus().isBadRequest();
	}

	@Test
	void findAllTodoSuccess(){
		Todo todo = new Todo("Fazer macarrão", false,4);
		Todo todo1 = new Todo("Fazer panqueca", false,2);
		webTestClient
				.post().uri("/todos")
				.bodyValue(todo).exchange();
		webTestClient
				.post().uri("/todos")
				.bodyValue(todo1).exchange();

		webTestClient.get().uri("/todos").exchange().expectStatus()
				.isOk().expectBody().jsonPath("$.length()")
				.isEqualTo(2).jsonPath("$[0].priority").isEqualTo(4)
				.jsonPath("$[1].priority").isEqualTo(2);
	}
	@Test
	void findTodoByIdSuccess(){
		Todo todo = new Todo("Fazer macarrão", false,4);
		webTestClient
				.post().uri("/todos")
				.bodyValue(todo).exchange();

		webTestClient.get().uri("/todos/1").exchange().expectStatus()
				.isOk().expectBody().jsonPath("$.description").isEqualTo(todo.getDescription())
				.jsonPath("$.id").isEqualTo(1);

	}

}
