package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_drop_table_example {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
    try{
        connection =
                DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/osoby",
                        "root", "");

        if(connection == null){
            System.out.println("Brak połączenia z bazą danych.");
        } else {
            System.out.println("Połącozno z baza danych.");
        }
        statement = connection.createStatement();

        String sql = "DROP TABLE przedmioty";

        statement.executeUpdate(sql);

    } catch(SQLException e){
        e.printStackTrace();
    } catch (Exception e){
        e.printStackTrace();
    } finally {

        try {
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    }
}
