package edu.sjsu.cs151.tetris.model;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;


public class User implements Serializable,Comparable<User> {
    /**
	 * Needed to Load file to user_list at the start of Game
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<User> user_list;
    private static String filename = "userList.ser"; 
    private static User CurrentUser;
    
	private static String name;
    private static int id; 
    private static int score;

    
 
   

     public User(String name){
         this.name = name;
         id = User.getUserList().size() + 1;
         score = 0;
         creatUser(name);
//         while(creatUser(this.name)==3)
//         {
//        	 System.out.println("Please enter a new Name:\n");
//        	 Scanner in = new Scanner(System.in); 
//        	 this.name = in.nextLine();
//     
//         }
         
         
 }
     private int creatUser(String name)
     {
    	 int input=0;
    	 int temp = User.checkUserInList(name);

    	 
    	 if(temp!=0)
         {
        	 System.out.println(user_list.get(temp).getId()+" "+user_list.get(temp).getName()+" Score:"+user_list.get(temp).getScore());
        	 System.out.println("There is an previous user with same name, To use this profile above?(1)");
        	 System.out.println("To delect previous user's profile(2)");
        	 System.out.println("To use other Name?(3)");
        	 Scanner in = new Scanner(System.in); 
        	 boolean validInput = false;
             while (!validInput) {
                 try {
//                	 	input = in.nextInt();
//                	 	if (input < 1 || input > 4) {
//                    	    System.out.println("\nInvalid Option Please enter a option between 1-3");
//                    	    validInput = true;
//                	 	} else if (input == 1) {
//                	 		CurrentUser = user_list.get(temp);
//                	 		user_list.remove(temp);
//                	 		user_list.add(CurrentUser);
//                	 		user_list.removeAll(Collections.singleton(null));
//                	 		validInput = true;
//                	 	} else if (input == 2){
                	 		user_list.remove(temp);
                	 		user_list.removeAll(Collections.singleton(null));
                	 		validInput = true;
                	 		CurrentUser = this;
                	 		user_list.add(CurrentUser);
                     	//}else 
                     		
//                     		if (input == 3)
//                     	{
//                     		validInput = true;
//                     	}
                	 		
                     }
                  catch (InputMismatchException e) {
                     System.out.println("Invalid Option, please enter a number.");
        
                  	}
         
             }
         }else
         {	 user_list.add(this);
        	 CurrentUser = this;
         }
         return input;
     }
      
     
     public static User getCurrentUser()
     {
    	 return User.CurrentUser;
     }
     
     public static void RefreshUserList() {
    	 user_list.remove(CurrentUser);
    	 user_list.add(CurrentUser);
    	 
     }
 
     public static ArrayList<User> getUserList()
     {
    	 return user_list;
     }
     //check if users with same name in the list return the index of user.
     public static int checkUserInList(String name)
     {
    	 int out = 0;
    	 if(user_list.size()!=0) {
    		 System.out.println("Size:"+user_list.size());
    		 for(int i=0;i<user_list.size()-1;i++) {
    			 System.out.println(user_list.get(i));
         }
    	 for(int i=0;i<user_list.size();i++)
    	 {
    		 
    		 
    		if(user_list.get(i).getName().equals(name))
    		{
    			out = i;
    		}
    	 }}
    	 return out;
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
     
     public void addScore(int input)
     {
    	 score = score + input;
     }
     
     public static void save()
     {
    	user_list.add(User.CurrentUser);
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
    	 user_list.sort(null);
    	 
    	 //user_list.remove(7);
  
     	 try
          {    
              // Reading from the file 
              FileInputStream file = new FileInputStream(filename); 
              ObjectInputStream in = new ObjectInputStream(file); 
                
              // Read UserList File to user_list Array 
              user_list = (ArrayList<User>)in.readObject(); 
                
              in.close(); 
              file.close(); 
              while(user_list.remove(null));
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
	
	@Override
	public int compareTo(User o) {
		return  o.getScore()-this.getScore() ;
	}

    
     
     
}