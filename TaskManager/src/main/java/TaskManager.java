import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager extends DBConnection{
    private ArrayList<User> users;
    Scanner scanner = new Scanner(System.in);

    public TaskManager() {
        users = new ArrayList<>();
    }


    public void createNewUsers(String userName , String firstName , String lastName) throws TaskManagerException
    {
        if(userName==null || userName.equals("")){
            throw new TaskManagerException("The username must not be null or empty");
        }
        if(firstName==null || firstName.equals("")){
            throw new TaskManagerException("The firstname must not be null or empty");
        }
        if(lastName==null || lastName.equals("")){
            throw new TaskManagerException("The lastname must not be null or empty");
        }
        try{
            PreparedStatement statement = con.prepareStatement("insert into users(UserName , FirstName , LastName) values(?,?,?)");
            statement.setString(1,userName);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

        User user = new User(userName , firstName , lastName);
        users.add(user);

    }



    public void showAllUsers(){

        try {
            PreparedStatement statement = con.prepareStatement("select users.UserId, FirstName , LastName ,COUNT(TaskTittle) from users left join tasks on users.UserId = tasks.UserId group by users.UserId");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                int count = rs.getInt(4);

                System.out.println("Id: " +id + "| FirstName: " +firstName + "| LastName: "+ lastName + "| NrOfTasks: " + count );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }




    public void addATaskToTheUser(String userName, String taskTitle, String description) throws TaskManagerException
    {
        boolean check = false;

        if(userName==null || userName.equals("")){
            throw new TaskManagerException("The username must not be null or empty");
        }
        if(taskTitle==null || taskTitle.equals("")){
            throw new TaskManagerException("The task title must not be null or empty");
        }
        if(description==null || description.equals("")){
            throw new TaskManagerException("The description must not be null or empty");
        }

        for (int i = 0; i < users.size(); i++) {

            if(users.get(i).getUn().equals(userName)){
                Task task = new Task(taskTitle,description);
                users.get(i).getTasks().add(task);
                check = true;
                int id = users.get(i).getId();
                try {
                    PreparedStatement statement = con.prepareStatement("insert into tasks (TaskTittle ,TaskDescription ,UserId) values(?,?,?)");
                    statement.setString(1,taskTitle);
                    statement.setString(2,description);
                    statement.setInt(3,id);
                    statement.executeUpdate();
                    System.out.println("Recoreded!");
                }catch (SQLException e){
                    e.printStackTrace();
                }

            }
        }
        if(!check){
            throw new TaskManagerException("The user was not found!");
        }

    }


    public void showUsersTasks(String username){

        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUn().equals(username)){
                int id =users.get(i).getId();
                try {
                    PreparedStatement statement = con.prepareStatement("select UserName , TaskTittle , TaskDescription from users right join tasks on users.UserId = tasks.UserId where tasks.UserId = '" +id + "'");
                    ResultSet rs = statement.executeQuery();
                    while (rs.next()){
                        String userName = rs.getString(1);
                        String taskTittle = rs.getString(2);
                        String taskDescription = rs.getString(3);
                        System.out.println("UserName: " + userName + " TaskTittle: "+taskTittle+" TaskDescription: "+taskDescription);
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

    }
    public void readEvryfingFromDatabase(){
        try {
            PreparedStatement statement = con.prepareStatement("select * from users");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String userName = rs.getString(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                users.add(new User(userName,firstName,lastName));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
