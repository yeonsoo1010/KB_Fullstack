package org.scoula.frontcontroller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TodoController {
    // 모두 command interface와 동일한 구조

    // getList
    public String getList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> list = Arrays.asList("Todo 1", "Todo 2", "Todo 3");
        request.setAttribute("todoList", list);
        System.out.println("GET /todo/list");
        return "todo/list";
    }

    // getView
    public String getView(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET /todo/view");
        return "todo/view";
    }

    // getCreate
    public String getCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET /todo/create");
        return "todo/create";
    }

    // postCreate
    public String postCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("POST /todo/create");
        return "redirect:/todo/list";
    }

    // getUpdate
    public String getUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET /todo/update");
        return "todo/update";
    }

    // postUpdate
    public String postUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("POST /todo/update");
        return "redirect:/todo/update";
    }

    // postDelete
    public String postDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("POST /todo/delete");
        return "redirect:/todo/delete";
    }
}
