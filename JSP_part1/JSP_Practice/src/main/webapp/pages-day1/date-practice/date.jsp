<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Practice</title>
</head>
<body>
    <%!
        Calendar cal = Calendar.getInstance();
        public String printHello(int hour){
            if(hour >= 6 && hour < 12){
                return "Good Morning";
            } else if (hour >= 12 && hour < 18) {
                return "Good Afternoon";
            } else if (hour >= 18 && hour < 24) {
                return "Good Evening";
            } else {
                return "Good Night";
            }
        }

        String[] weeks = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    %>

    <h2>Current Time Information</h2>
    <p>Year : <%= cal.get(Calendar.YEAR) %></p>
    <p>Month : <%= cal.get(Calendar.MONTH)+1 %></p>
    <p>Day : <%= cal.get(Calendar.DAY_OF_MONTH) %></p>
    <p>Hour : <%= cal.get(Calendar.HOUR_OF_DAY) %></p>
    <br>
    <p><%= printHello(cal.get(Calendar.HOUR_OF_DAY))%></p>
    <br>
    <p>Today is <%= weeks[cal.get(Calendar.DAY_OF_WEEK)-1] %></p>
    <p>Current timestamp : <%= cal.getTime() %></p>
</body>
</html>
