package demo.todo.beetlsql;


import org.beetl.sql.core.mapper.BaseMapper;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TodoItem  {

	@Id
    private int id;

    private String desc;

    public TodoItem() {
    }

    public int getId() {
        return id;
    }

	public void setId(int id) {
		this.id = id;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


}
