package edu.sjsu.cs151.tetris.model;



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.sjsu.cs151.tetris.model.User;

import java.io.*;
import java.util.ArrayList;

public class User implements Serializable,Comparable<User> {
    /**
	 * Needed to Load file to user_list at the start of Game
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<User> user_list;
    private static String filename = "userList.ser"; 
    private static User CurrentUser;
	private String name;
    private static int id; 
    private int score;
    



     public User(String name){
         this.name = name;
         
         score = 0;
     }
     
     public static void main(String args[]) throws IOException
     {
    	 User u = new User("wang7");
    	 User.loadUserList();
    	 u.UpdateList();
    	 for(User c:User.user_list)
    	 {
    		 System.out.println(c.getName());
    	 }

    	 u.save();
    	 
     }

     public void UpdateList() {
		// TODO Auto-generated method stub
    	 user_list.add(this);
    	 CurrentUser = this;
	}

	public static ArrayList<User> getUserList()
     {
    	 return user_list;
     }
	
	 public static User getCurrentUser()
     {
    	 return User.CurrentUser;
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
     	 try
          {    
              // Reading from the file 
              FileInputStream file = new FileInputStream(filename); 
              ObjectInputStream in = new ObjectInputStream(file); 

              // Read UserList File to user_list Array 
              user_list = (ArrayList<User>)in.readObject(); 

              in.close(); 
              file.close(); 
              id = User.getUserList().size() + 1;
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
    
     