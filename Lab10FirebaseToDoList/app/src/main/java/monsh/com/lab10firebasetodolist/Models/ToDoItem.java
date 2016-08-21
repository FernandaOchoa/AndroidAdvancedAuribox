package monsh.com.lab10firebasetodolist.Models;

/**
 * Created by monsh on 18/08/2016.
 */
public class ToDoItem {

    String username;
    String item;
    boolean completed;

    public ToDoItem(){
        super();
    }
    public ToDoItem(String item,String username){
        this.username = username;
        this.item = item;
        this.completed = false;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
