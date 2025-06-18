package servlet;

import dto.Reservation;
import dao.ReservationDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.*;

@WebServlet("/reservation")
public class ReservationListServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");


        Reservation r = new Reservation();
        String patient_name = request.getParameter("patient_name");
        String patient_phone = request.getParameter("patient_phone");
        String doctor_name = request.getParameter("doctor_name");
        String department = request.getParameter("department");
        String symptoms = request.getParameter("symptoms");
        String status = request.getParameter("status");


        r.setPatient_name(patient_name);
        r.setPatient_phone(patient_phone);
        r.setDoctor_name(doctor_name);
        r.setDepartment(department);
        r.setSymptoms(symptoms);
        r.setStatus(status);

        SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeSdf = new SimpleDateFormat("HH:mm");

        try {
            Date tDate = timeSdf.parse(request.getParameter("reservation_time"));

            Date reservation_date = dateSdf.parse(request.getParameter("reservation_date"));
            Time reservation_time = new Time(tDate.getTime());

            r.setReservation_date(new java.sql.Date(reservation_date.getTime()));
            r.setReservation_time(reservation_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ReservationDAO dao = new ReservationDAO();

        int result = dao.insertReservation(r);

        request.setAttribute("resultName", patient_name);
        request.setAttribute("resultDate", request.getParameter("reservation_date"));

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ReservationDAO dao = new ReservationDAO();
        List<Reservation> list = dao.getAllReservations();

        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/reservationList.jsp");
        dispatcher.forward(request, response);
    }
}
