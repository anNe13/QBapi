package db;

import model.Post;

import java.sql.*;
import java.util.ArrayList;

public class Statements {
    private Connector connector = new Connector();
    private Connection con;
    private ResultSet rs = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public ArrayList<Post> getAllPosts() {

        con = connector.getConnection();
        String query = "SELECT * FROM post";
        ArrayList<Post> postList = new ArrayList<>();
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(query);
            String title, content, location, username;
            int id;
            try {
                while (rs.next()) {
                    title = rs.getString("title");
                    content = rs.getString("content");
                    location = rs.getString("location");
                    username = rs.getString("username");
                    id = rs.getInt("id");
                    postList.add(new Post(title, content, username, location, id));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeAll();
        }
        return postList;
    }

    public String getPostLocationById(int idPar) {
        con = connector.getConnection();
        String query = "SELECT location FROM `post` WHERE post.id = ?";
        preparedStatement = null;
        rs = null;
        String result = null;

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, idPar);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                result = rs.getString("location");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return result;
    }


    private void closeAll() {
        try {
            if (con != null) {
                con.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}