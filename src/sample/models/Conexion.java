package sample.models;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static String server = "127.0.0.1";
    private static String user   = "topicos2021";
    private static String pwd    = "123456789";
    private static String db     = "musicadb";

    public static Connection conexion;
    public static void getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://"+server+":3306/"+db,user,pwd);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}