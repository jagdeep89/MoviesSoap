/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviessoap.resources;

import com.mycompany.moviessoap.models.MovieType;
import com.mycompany.moviessoap.models.MoviesType;
import java.sql.*;

/**
 *
 * @author forev
 */
public class MovieDAO {
 
static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
static final String DB_URL = "jdbc:derby://localhost:1527/Movie";
static final String DB_USERNAME = "";
static final String DB_PASSWORD = "";
 
Connection connection;
Statement statement;
public MovieDAO()
{
initialize();
}
 
/*
This initialize method will initialize database connection to MySQL database
*/
public void initialize()
{
try
{
System.out.println("Initializing DB Connection");
Class.forName(DB_DRIVER);
connection=DriverManager.getConnection(DB_URL);
System.out.println("Connected");
}
catch (Exception e) {e.printStackTrace();}
}
 
/*
This method adds a movie object in the database
*/
public String addMovie(MovieType u)
{ String ResponseMessage="";
try {
 
statement=connection.createStatement();
String addSQL="INSERT INTO TBL_USERS (IDCONTENT, IDCOLLECTION, TITLE, PLOT, RELEASED, CONTENTRATING)VALUES ("
+u.getIdContent() +","+
        +u.getIDCollection()+",'"+
u.getTitle() +"','"+
u.getPlot()+"',"+
u.getReleased()+",'"+
u.getContentRating()+"')";
System.out.println(addSQL);
int count= statement.executeUpdate(addSQL);
ResponseMessage= (count==1)? "Movie Added Successfully": "Error Inserting Database";
return ResponseMessage;
 
}
catch (Exception e) {
e.printStackTrace();
ResponseMessage="Error Inserting Database";
return ResponseMessage;
}
finally
{
if (connection !=null)
try {
connection.close();
}
catch (Exception e) {}
}
}
 
/*
This method returns a user object based on the userName. In real scenarios, we can have multiple users with same name and for such cases, userId should be used instead but here for the sake of simplicity, we will use userName as argument.
*/
public MovieType getMovie(int idContent)
{MovieType u=null;
try
{
String getuser_sql="SELECT idcontent, title, plot, released, contentrating FROM content WHERE IDCONTENT="+idContent+"";
System.out.println(getuser_sql);
statement=connection.createStatement();
ResultSet resultset= statement.executeQuery(getuser_sql);
 
while (resultset.next())
{ u=new MovieType();
u.setIdContent(resultset.getInt(1));
u.setTitle(resultset.getString(2));
u.setPlot(resultset.getString(3));
u.setReleased(resultset.getString(4));
u.setContentRating(resultset.getDouble(5));
break; //As we want to get only one record
}
return u;
 
}
catch (Exception e)
{
e.printStackTrace();
return u;
}
finally
{
if (connection !=null)
try {
connection.close();
}
catch (Exception e) {}
}
 
}
 
/*
This method is used to update any existing movie
*/
 
public String updateMovie(MovieType u)
{ String ResponseMessage="";
try {
 
statement=connection.createStatement();
String update_sql="UPDATE CONTENT SET TITLE='"+u.getTitle()+"', PLOT='"+u.getPlot()+"', RELEASED="+u.getReleased()+", CONTENTRATING="+u.getContentRating()+" WHERE IDCONTENT="+u.getIdContent();
 
System.out.println(update_sql);
int count= statement.executeUpdate(update_sql);
ResponseMessage= (count==1)? "Movie Updated Successfully": "Error Updating Movie";
System.out.println("Returning response message: "+ResponseMessage);
return ResponseMessage;
 
}
catch (Exception e) {
e.printStackTrace();
ResponseMessage="Error Updating Movie";
return ResponseMessage;
}
finally
{
if (connection !=null)
try {
connection.close();
}
catch (Exception e) {}
}
}
 
/*
This method will delete a movie from database based on the provided user id
*/
public String deleteMovie(int idContent)
{ String ResponseMessage="";
try {
 
statement=connection.createStatement();
String delete_sql="DELETE FROM content WHERE IDCONTENT="+idContent;
 
System.out.println(delete_sql);
int count=statement.executeUpdate(delete_sql);
ResponseMessage= (count==1)? "Movie deleted Successfully": "Error deleting Movie";
System.out.println("Returning response message: "+ResponseMessage);
return ResponseMessage;
 
}
catch (Exception e) {
e.printStackTrace();
ResponseMessage="Error deleting Movie";
return ResponseMessage;
}
finally
{
if (connection !=null)
try {
connection.close();
}
catch (Exception e) {}
}
}
 
/*
This method returns all movies available in the database table
*/
public MoviesType getAllMovies()
{ MoviesType users=new MoviesType();
try
{
String getalluser_sql="SELECT idcontent, title, plot, released, contentrating FROM content";
System.out.println(getalluser_sql);
statement=connection.createStatement();
ResultSet resultset= statement.executeQuery(getalluser_sql);
 
while (resultset.next())
{ MovieType u=new MovieType();
u.setIdContent(resultset.getInt(1));
u.setTitle(resultset.getString(2));
u.setPlot(resultset.getString(3));
u.setReleased(resultset.getString(4));
u.setContentRating(resultset.getDouble(5));
users.getMovie().add(u);
}
return users;
 
}
catch (Exception e) {
e.printStackTrace();
 
return users;
}
finally
{
if (connection !=null)
try {
connection.close();
}
catch (Exception e) {}
}
}
}