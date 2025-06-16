package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Member;

public class MemberDAO {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String user = "postgres";
    private String password = "1234";

    private Connection getConnection() throws Exception{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    public int insertMember(Member m){
        String sql = "INSERT INTO member (name, email) VALUES (?, ?)";
        int result = 0;
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, m.getName());
            pstmt.setString(2, m.getEmail());
            result = pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public List<Member> getAllMembers(){
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM member";

        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Member m = new Member();
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                m.setEmail(rs.getString("email"));
                list.add(m);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

}
