package me.onykot.app.helper;

import me.onykot.app.Roles;
import ua.oxooocb.fxlib.stage.StageBuilder;
import ua.oxooocb.fxlib.utils.StageUtils;

import java.sql.*;

import static me.onykot.app.Roles.MANEGER;

public class SQLHelper {
    private Connection connection;

    private String connectionURL;
    public SQLHelper(){
        this.connectionURL = String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s", "remotemysql.com", 3306, "9tR4tmS9Qz", "9tR4tmS9Qz", "za9dbNM74i");

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(this.connectionURL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Cannot connect to database!");
        }
    }

    public void login(String user, String password) throws IllegalStateException, SQLException{
        PreparedStatement statement = this.connection.prepareStatement("SELECT users.*, roles.* FROM users INNER JOIN roles ON roles.id=users.roleid WHERE login=?");
        statement.setString(1, user.toLowerCase());

        statement.execute();
        if(!statement.getResultSet().first()){
            throw new IllegalStateException("Invalid login data");
        }

        String upass = statement.getResultSet().getString("users.password");

        if(!upass.equalsIgnoreCase(password)){
            throw new IllegalStateException("Invalid login data");
        }

        String roleString = statement.getResultSet().getString("roles.name");

        WindowHelper.showWindow1();


        System.out.println(roleString);
    }

    public void register(String user, String password, Roles role ) {
        System.out.println("мы тут");
        try{
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO users (login, password, roleid) values (?, ?, ? )");
            statement.setString(1, user);
            statement.setString(2, password);
            int roleid = 0;
            switch (role)
            {
                case MANEGER:
                    roleid = 2;
                    break;
                case DIREKCIA:
                    roleid = 4;
                    break;
                case ZAKAZHIK:
                    roleid = 1;
                    break;
                case KLADOVSHIK:
                    roleid = 3;
                    break;
            }
            statement.setInt(3,roleid);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }




    }
}
