package com.example;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class JDBC_select_example {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
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
        String sql = "SELECT * FROM studenci; ";
        resultset = statement.executeQuery(sql);


        while (resultset.next()){
            int id = resultset.getInt("id");
            String name = resultset.getString("inne");
            String surname = resultset.getString("nazwisko");
            int age = resultset.getInt("wiek");
            System.out.println("id: " + id + " imie: " + name + " nazwisko: " + surname + " wiek: " + age);

        }
    } catch(SQLException e){
        e.printStackTrace();
    } catch (Exception e){
        e.printStackTrace();
    } finally {
        try {
            resultset.close();
        } catch (Exception e){
            e.printStackTrace();
        }
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
