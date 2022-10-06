<%--
  Created by IntelliJ IDEA.
  User: smhrd
  Date: 2022-09-24
  Time: 오전 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.DamDataDTO" %>
<%@ page import="model.DamDataDAO" %>
<%@ page import="model.DamStatusDAO" %>
<%@ page import="model.DamStatusDTO" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>


<table border="1">
    <tr>
        <th>높이</th>
        <th>길이</th>
        <th>정상표고</th>
        <th>체적</th>
        <th>유역면적</th>
        <th>연간용수공급용량</th>
    </tr>
    <%
        DamDataDTO dto = new DamDataDTO();
        DamDataDAO dao = new DamDataDAO();

        dto = dao.getDamDataDTO();

        String height = dto.getD_height();
        String length = dto.getD_length();
        String altitude = dto.getD_altitude();
        String volume = dto.getD_volume();
        String darea = dto.getD_area();
        String suparea = dto.getD_supArea();
        String area = dto.getD_area();
        String fwl = dto.getD_FWL();
        String nwl = dto.getD_NWL();
        String lwl = dto.getD_LWL();
        String maltitude = dto.getD_mAltitude();
        String lowlevelwater = dto.getD_lowLevelWater();
        String tsuparea = dto.getD_tSupArea();
        String valvol = dto.getD_valVol();

        DamStatusDTO dto2 = new DamStatusDTO();
        DamStatusDAO dao2 = new DamStatusDAO();
        dto2 = dao2.getDamStatusDTO();

        String s_time = dto2.getS_time();
        String s_lowlevelwater = dto2.getS_lowLevelWater();
        String s_waterstorage = dto2.getS_waterStorage();
        String s_pow = dto2.getS_POW();
        String s_inflow = dto2.getS_inflow();
        String s_outflow = dto2.getS_tOutflow();


    %>
    <tr>
        <td>
            <%=height%>
        </td>
        <td><%=length%>
        </td>
        <td><%=altitude%>
        </td>
        <td>
            <%=volume%>
        </td>
        <td><%=darea%>
        </td>
        <td><%=suparea%>
        </td>
    </tr>
</table>
<table border="1">
    <tr>
        <td>일시</td>
        <td>수위</td>
        <td>저수량</td>
        <td>저수율</td>
    </tr>
    <tr>
        <td>
            <%=s_time%>
        </td>
        <td>
            <%=s_lowlevelwater%>
        </td>
        <td>
            <%=s_waterstorage%>
        </td>
        <td>
            <%=s_pow%>
        </td>
    </tr>
</table>


</body>
</html>
