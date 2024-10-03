<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="io.kyleaure.knitting.util.Measure.Unit"%>
<html>
<head>
<title>Machine Knitting Calculators</title>
</head>
<body>
    <h1>Machine Knitting Calculators</h1>

    <!-- TODO - include forms/buttons/etc -->
    <form action = "gauge.jsp" method = "POST" target = "_blank">
        Stitches: <input type = "text" name = "stitches" />
        Rows: <input type = "text" name = "rows"  />
        Size: <input type = "text" name = "size"  />
        Units squared: 
            <select name = "unit">
                <c:forEach items="<%=Unit.values()%>" var="entry">
                    <option value="${entry.toString()}">${entry.toString()}</option>
                </c:forEach>
            </select>
        <input type = "submit" value = "Set Gauge" />
    </form>
</body>
</html>