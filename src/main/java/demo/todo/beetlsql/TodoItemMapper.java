package demo.todo.beetlsql;

import org.beetl.sql.mapper.BaseMapper;

import java.util.List;


public interface TodoItemMapper extends BaseMapper<TodoItem> {
	 List<TodoItem> selectAll();
}
