import java.io.*;
import java.util.ArrayList;

public class User implements Serializable {
    /**
	 * Needed to Load file to user_list at the start of Game
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<User> user_list;
    private static String filename = "userList.ser"; 
    
	private String name;
    private int id; 
    private int score;
    
 
   

     public User(String name){
         this.name = name;
         id = User.getUserList().size() + 1;
         score = 0;
     }
     
     public static ArrayList<User> getUserList()
     {
    	 return user_list;
     }
     
     public String getName()
     {
    	 return name;
     }
     
     public int getId()
     {
    	 return id;
     }
     
     public int getScore()
     {
    	 return score;
     }
     
     public void modifyScore(int input)
     {
    	 score = score + input;
     }
     
     public static void save()
     {
     	try
     	{    
     		FileOutputStream file = new FileOutputStream(filename); 
     		ObjectOutputStream out = new ObjectOutputStream(file); 
     		out.writeObject(user_list); 
     		out.close(); 
     		file.close(); 
     		System.out.println("Users List Saved"); 

     	} 

     	catch(IOException ex) 
     	{ 
     		System.out.println("IOException is caught"); 
     	} 
     }
     
     public static void loadUserList()
     {
    	 user_list = new ArrayList<User>();
     	 try
          {    
              // Reading from the file 
              FileInputStream file = new FileInputStream(filename); 
              ObjectInputStream in = new ObjectInputStream(file); 
                
              // Read UserList File to user_list Array 
              user_list = (ArrayList<User>)in.readObject(); 
                
              in.close(); 
              file.close(); 
                
              System.out.println("Object has been deserialized "); 
          } 
            
          catch(IOException ex) 
          { 
              System.out.println("IOException is caught"); 
          } 
            
          catch(ClassNotFoundException ex) 
          { 
              System.out.println("ClassNotFoundException is caught"); 
          } 
     }

    
     
     
}