<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Practice</title>
</head>
<body>
    <%!
        String[] names = {"Alice", "Bob", "Charlie"};
        int[] scores = {95,78,82};

        public String getGrade(int score){
            if(score >= 90){
                return "A";
            } else if (score >= 80){
                return "B";
            } else if (score >= 70){
                return "C";
            } else if (score >= 60){
                return "D";
            } else{ return "F"; }
        }

        public double getAvg(int[] scores){
            int sum = 0;
            for(int i = 0; i < scores.length; i++){
                sum += scores[i];
            }

            if(scores.length == 0){
                return 0;
            }

            double avg = (double)sum / (double)scores.length;
            return avg;
        }
    %>

    <h2>Student Grade Calculator</h2>
    <br>

    <% for(int i = 0; i < names.length; i++) { %>
            <p><%= names[i] %>:<%= scores[i]%>점 - <%= getGrade(scores[i]) %>등급</p>
    <% } %>

    <br>
    <p>Class Average : <%= String.format("%.2f", getAvg(scores)) %>점</p>
    <p>Total Students : <%= names.length %>명</p>
</body>
</html>
