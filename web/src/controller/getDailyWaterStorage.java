package src.controller;

import com.google.gson.*;
import src.model.waterStorageDAO;
import src.model.waterStorageDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/getDailyWaterStorage")
public class getDailyWaterStorage extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String month = request.getParameter("month");
        System.out.println(month);
        waterStorageDAO dao = new waterStorageDAO();

        ArrayList<waterStorageDTO> arr = dao.getDwaterStorage(month);

        System.out.println("getS : " + arr.size());

        response.setContentType("aplication/x-jon; charset=utf-8");

        Gson gson = new Gson();
        response.setCharacterEncoding("utf-8");

        if(arr.size() > 0){
            response.getWriter().print(gson.toJson(arr));
        }else {
            System.out.print("error");
        }
    }
}
