import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.*;

public class Main extends DBConnection {
    public static void main(String[] args) {

        boolean state = true;
        TaskManager taskManager = new TaskManager();
        taskManager.readEvryfingFromDatabase();



        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose something from the menu:");
            System.out.println("----------------------------");
            System.out.println("1. CreateNewUsers");
            System.out.println("2. ShowAllUsers");
            System.out.println("3. AddATaskToTheUser");
            System.out.println("4. ShowUsersTasks");
            System.out.println("0. Quit");
            System.out.println("----------------------------");
            int choice = scanner.nextInt();

            if(choice==1){
                try{
                    System.out.println("Type the username");
                    String un = scanner.next();
                    System.out.println("Type the first name");
                    String fn = scanner.next();
                    System.out.println("Type the last name");
                    String ln = scanner.next();
                    taskManager.createNewUsers(un,fn,ln);

                    scanner.nextLine();



                }catch (TaskManagerException taskManagerException){
                    System.err.println(taskManagerException.getMessage());
                }

            }
            else if(choice==2){
                taskManager.showAllUsers();

            } else if(choice==3){
                try{

                    System.out.println("Type the username");
                    String un = scanner.next();
                    System.out.println("Type the task title");
                    String tt = scanner.next();
                    System.out.println("Type the description");
                    String td = scanner.next();
                    taskManager.addATaskToTheUser(un,tt,td);
                    scanner.nextLine();


                }
                catch (TaskManagerException taskManagerException){
                    System.err.println(taskManagerException.getMessage());
                }

            }
            else if(choice==4){
                System.out.println("Enter username!");
                String name = scanner.next();
                taskManager.showUsersTasks(name);
                scanner.nextLine();
            }
            else if(choice==0){
                state = false;
                scanner.close();
            }
        } while (state);
    }
}