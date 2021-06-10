package com.example;

import java.sql.*;

public class JDBC_create_table_example {
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

        String sql = "CREATE TABLE przedmioty ( "
                + " przedmiot VARCHAR(20), semestr INT );";

        statement.executeUpdate(sql);

        String sqlSelect = "SELECT * FROM studenci; ";

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
