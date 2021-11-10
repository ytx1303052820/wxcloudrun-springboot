package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CreateToDoRequest;
import com.tencent.wxcloudrun.dto.UpdateToDoRequest;
import com.tencent.wxcloudrun.model.ToDo;
import com.tencent.wxcloudrun.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

/**
 * todo控制器
 */
@RestController
@RequestMapping(value = "/api/todos")
public class ToDoController {

  final ToDoService todoService;

  public ToDoController(@Autowired ToDoService todoService) {
    this.todoService = todoService;
  }

  /**
   * 获取所有todo
   * @return API response json
   */
  @GetMapping
  ApiResponse getAll() {
    Optional<List<ToDo>> todoList = todoService.getAll();
    if (todoList.isPresent()) {
      return ApiResponse.ok(todoList);
    }

    ApiResponse rsp = ApiResponse.error("todo not exist");
    rsp.setCode(-1);
    return rsp;
  }

  /**
   * 创建todo
   * @param request {@link CreateToDoRequest}
   * @return API response json
   */
  @PostMapping
  ApiResponse create(@RequestBody CreateToDoRequest request) {

    ToDo todo = new ToDo();
    todo.setTitle(request.getTitle());
    todo.setStatus(request.getStatus());
    todo.setCreateTime(LocalDateTime.now());
    todo.setUpdateTime(LocalDateTime.now());

    return todoService.create(todo) ? ApiResponse.ok() : ApiResponse.error("创建失败");
  }

  /**
   * 根据ID删除todo
   * @param id todoID
   * @return API response json
   */
  @DeleteMapping("/{id}")
  ApiResponse delete(@PathVariable Integer id) {
    Optional<ToDo> todo = todoService.getById(id);
    if (!todo.isPresent()) {
      ApiResponse rsp = ApiResponse.error("todo not exist");
      rsp.setCode(-1);
      return rsp;
    }
    return todoService.removeById(id) ? ApiResponse.ok() : ApiResponse.error("删除失败");
  }

  /**
   * 根据todoID查询todo
   * @param id todoID
   * @return API response json
   */
  @GetMapping("/{id}")
  ApiResponse get(@PathVariable Integer id) {
    Optional<ToDo> todo = todoService.getById(id);
    if (todo.isPresent()) {
      return ApiResponse.ok(todo);
    }

    ApiResponse rsp = ApiResponse.error("todo not exist");
    rsp.setCode(-1);
    return rsp;
  }

  /**
   * @param request {@link UpdateToDoRequest}
   * @return API response json
   */
  @PutMapping
  ApiResponse update(@RequestBody UpdateToDoRequest request) {
    Optional<ToDo> queryToDo = todoService.getById(request.getId());
    if (!queryToDo.isPresent()) {
      ApiResponse rsp = ApiResponse.error("todo not exist");
      rsp.setCode(-1);
      return rsp;
    }

    // ToDo qTodo = queryToDo.get();
    // String title = request.getTitle();
    // if (title == null) {
    //   title = qTodo.getTitle();
    // }
    // String status = request.getStatus();
    // if (status == null) {
    //   status = qTodo.getStatus();
    // }

    ToDo todo = new ToDo();
    todo.setId(request.getId());
    todo.setTitle(request.getTitle());
    todo.setStatus(request.getStatus());
    todo.setUpdateTime(LocalDateTime.now());

    return todoService.updateById(todo) ? ApiResponse.ok() : ApiResponse.error("更新失败");
  }
}