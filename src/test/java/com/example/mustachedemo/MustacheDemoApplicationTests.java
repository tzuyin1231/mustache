package com.example.mustachedemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;

@SpringBootTest
class MustacheDemoApplicationTests {

    @Test
    void contextLoads() {
    }

//    @Test
//    public void givenTodoObject_whenGetHtml_thenSuccess()
//            throws IOException {
//
//        Todo todo = new Todo("Todo 1", "Todo description");
//        Mustache m = MustacheUtil.getMustacheFactory()
//                .compile("todo.mustache");
//        Map<String, Object> context = new HashMap<>();
//        context.put("todo", todo);
//
//        String expected = "<h2>Todo 1</h2>";
//        assertThat(executeTemplate(m, todo)).contains(expected);
//    }
//    @Test
//    public void givenTodoList_whenGetHtml_thenSuccess()
//            throws IOException {
//
//        Mustache m = MustacheUtil.getMustacheFactory()
//                .compile("todos.mustache");
//
//        List<Todo> todos = Arrays.asList(
//                new Todo("Todo 1", "Todo description"),
//                new Todo("Todo 2", "Todo description another"),
//                new Todo("Todo 3", "Todo description another")
//        );
//        Map<String, Object> context = new HashMap<>();
//        context.put("todos", todos);
//
//        assertThat(executeTemplate(m, context))
//                .contains("<h2>Todo 1</h2>")
//                .contains("<h2>Todo 2</h2>")
//                .contains("<h2>Todo 3</h2>");
//    }
//    @Test
//    public void givenNullTodoObject_whenGetHtml_thenEmptyHtml()
//            throws IOException {
//        Mustache m = MustacheUtil.getMustacheFactory()
//                .compile("todo-section.mustache");
//        Map<String, Object> context = new HashMap<>();
//        assertThat(executeTemplate(m, context)).isEmpty();
//    }
}
