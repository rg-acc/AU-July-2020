package com.au2020.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC {
    public static void displayTransaction(Integer userid ) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank","root","root");


          String query = "SELECT * FROM Audit where senderAccountId= ? or recieverAccountId=?" ;
          
          PreparedStatement pstmt = con.prepareStatement(query);
          pstmt.setInt(1, userid);
          pstmt.setInt(2, userid);
          ResultSet rs = pstmt.executeQuery();
          
          while(rs.next()){
              
               Integer id  = rs.getInt("auditid");
               Double amount= rs.getDouble("amount");
               Integer sender = rs.getInt("senderAccountId");
               Integer receiver = rs.getInt("recieverAccountId");

               //Display values
               System.out.print("transaction id: " + id);
               System.out.print(", senderAccountId: " + sender);
               System.out.print(", recieverAccountId: " + receiver);
               System.out.println(", amount: " + amount);
            }
            rs.close();
      

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


