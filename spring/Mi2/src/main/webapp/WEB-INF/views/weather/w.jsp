<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>어제의 날씨</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: gray;
            padding: 40px;
        }

        .weather-box {
            background: white;
            border-radius: 12px;
            padding: 30px;
            max-width: 500px;
            margin: 0 auto;
           /*  box-shadow: 0 8px 16px rgba(0,0,0,0.1); */
            text-align: center;
        }

        .weather-box h1 {
            font-size: 24px;
            color: #red;
        }

        .weather-box p {
            font-size: 18px;
            margin: 10px 0;
            color: #blue;
        }

        .temperature {
            font-size: 28px;
            color: #007acc;
            margin: 20px 0;
        }

        .footer {
            margin-top: 40px;
            text-align: center;
            font-size: 12px;
            color: #aaa;
        }
    </style>
</head>
<body>

<div class="weather-box">
    <h1>${location} 지역의 어제 날씨</h1>
    <p class="temperature">🌡 최저 기온: <strong>${tMin}℃</strong></p>
    <p class="temperature">🔥 최고 기온: <strong>${tMax}℃</strong></p>
    <p>어제 하루도 수고하셨습니다 😊</p>
</div>

<div class="footer">
    &copy; 2025 날씨 정보 서비스
</div>

</body>
</html>