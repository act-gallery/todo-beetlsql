package demo.todo.beetlsql;

import static act.controller.Controller.Util.notFoundIfNull;

import act.Act;
import act.db.DbBind;
import act.db.beetlsql.BeetlSqlDao;
import act.db.beetlsql.BeetlSqlTransactional;
import act.db.sql.tx.Transactional;
import act.job.Every;
import org.osgl.http.H;
import org.osgl.mvc.annotation.*;
import org.osgl.util.Keyword;
import org.osgl.util.S;

import javax.inject.Inject;
import java.io.File;

/**
 * A Simple Todo application controller
 */
@SuppressWarnings("unused")
@With(BeetlSqlTransactional.class)
public class Todo {

    @Inject
    private BeetlSqlDao<Integer, TodoItem> dao;

    @GetAction
    public void home() {}

    @GetAction("file")
    public static File file() {
        return new File("target/classes/demo/todo/beetlsql/Todo.class");
    }

    @GetAction("/list")
    public Iterable<TodoItem> list(String q) {
        return dao.findAll();
    }

    @PostAction("/list")
    @Transactional
    public void post(String desc) {
        TodoItem item = new TodoItem();
        item.setDesc(desc);
        dao.save(item);
    }

    @DeleteAction("/list/{id}")
    public void delete(int id) {
        dao.deleteById(id);
    }

    @PutAction("/list/{item}")
    public void update(@DbBind TodoItem item, String desc) {
        notFoundIfNull(item);
        item.setDesc(desc);
        dao.save(item);
    }

    @GetAction("/list/{item}")
    public TodoItem showItem(@DbBind TodoItem item) {
        return item;
    }
    
    public static void main(String[] args) throws Exception {
        Act.start("TODO-BeetlSql");
    }


}
