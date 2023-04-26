<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <%-- jstl 사용을 선언 --%>
<html>
<head>
    <title>사원 리스트</title>
</head>
<body>
<h1>사원 리스트</h1>
<table border="1" width="750px" cellpadding="10px" cellspacing="0">
    <tr><th>사원번호</th><th>이름</th><th>이메일</th><th>직책</th><th>부서번호</th></tr>
    <c:forEach items="${emps}" var="emp">   <!-- 컨트롤러가 보낸 값을 EL을 사용해서 출력 -->
        <tr style="text-align: right">
            <td>${emp.empid}</td>
            <td>${emp.fname}</td>
            <td>${emp.email}</td>
            <td>${emp.jobid}</td>
            <td>${emp.deptid}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
