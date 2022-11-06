
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUserTest{

    @Test
    public void testingCreationUserNameMustThrowException(){
        String un="";
        String fn = "Serii";
        String ln = "Biriucov";

        TaskManager taskManager = new TaskManager();
        assertThrows(TaskManagerException.class,() ->{
            taskManager.createNewUsers(un, fn, ln);
        });

    }
    @Test
    public void testingCreationFirstNameMustThrowException(){
        String un="Treeme";
        String fn = "";
        String ln = "Biriucov";

        TaskManager taskManager = new TaskManager();
        assertThrows(TaskManagerException.class,() ->{
            taskManager.createNewUsers(un, fn, ln);
        });

    }
    @Test
    public void testingCreationLastNameMustThrowException(){
        String un="Treeme";
        String fn = "Sergiu";
        String ln = "";

        TaskManager taskManager = new TaskManager();
        assertThrows(TaskManagerException.class,() ->{
            taskManager.createNewUsers(un, fn, ln);
        });

    }

    @Test
    public void testingAddTaskUserMustThrowException(){
        String un = "";
        String tt = "Game";
        String td = "Develop";

        TaskManager taskManager = new TaskManager();
        assertThrows(TaskManagerException.class,() ->{
            taskManager.createNewUsers(un, tt, td);
        });
    }
    @Test
    public void testingAddTaskTaskTittleMustThrowException(){
        String un = "Sasa";
        String tt = "";
        String td = "Develop";

        TaskManager taskManager = new TaskManager();
        assertThrows(TaskManagerException.class,() ->{
            taskManager.createNewUsers(un, tt, td);
        });
    }
    @Test
    public void testingAddTaskTaskDescriptionMustThrowException(){
        String un = "Sasa";
        String tt = "Game";
        String td = "";

        TaskManager taskManager = new TaskManager();
        assertThrows(TaskManagerException.class,() ->{
            taskManager.createNewUsers(un, tt, td);
        });
    }

}




