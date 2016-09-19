import java.sql.*;

class MysqlCon 
{
   public static void main(String args[])
   {
      try
      {
         Class.forName("com.mysql.jdbc.Driver");
         
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bj","root","4leafco");
         //here sonoo is the database name, root is the username and root is the password
         Statement stmt = con.createStatement();
         
         ResultSet rs = stmt.executeQuery("select * from blackjackdatabase");
         
         while(rs.next())
         System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3));
         
         con.close();
         
      }catch(Exception e){System.out.println(e);}
   }
}