package dao;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import dto.Reservation;
import util.DBConnection;

public class ReservationDAO {

    DBConnection connectionInstance = new DBConnection();

    public int insertReservation(Reservation r){
        String sql = "INSERT INTO reservations " +
                "(patient_name, patient_phone, doctor_name, department, reservation_date, reservation_time, symptoms, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int result = 0;

        try(Connection conn = connectionInstance.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeSdf = new SimpleDateFormat("HH:mm");

            pstmt.setString(1, r.getPatient_name());
            pstmt.setString(2, r.getPatient_phone());
            pstmt.setString(3, r.getDoctor_name());
            pstmt.setString(4, r.getDepartment());
            pstmt.setDate(5, r.getReservation_date());
            pstmt.setTime(6, new java.sql.Time(r.getReservation_time().getTime()));
            pstmt.setString(7, r.getSymptoms());
            pstmt.setString(8, r.getStatus());
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Reservation> getAllReservations(){
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservations";

        try(Connection conn = connectionInstance.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Reservation r = new Reservation();
                r.setId(Integer.parseInt(rs.getString("reservation_id")));
                r.setPatient_name(rs.getString("patient_name"));
                r.setPatient_phone(rs.getString("patient_phone"));
                r.setDoctor_name(rs.getString("doctor_name"));
                r.setDepartment(rs.getString("department"));
                r.setReservation_date(rs.getDate("reservation_date"));
                r.setReservation_time(rs.getTime("reservation_time"));
                r.setSymptoms(rs.getString("symptoms"));
                r.setStatus(rs.getString("status"));
                r.setCreated_at(rs.getTimestamp("created_at"));

                list.add(r);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
