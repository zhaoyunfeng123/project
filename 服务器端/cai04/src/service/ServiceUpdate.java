package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


import control.Update;

/**
 * Servlet implementation class ServiceUpdate
 */
@WebServlet("/ServiceUpdate")
public class ServiceUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("userName");
		String account = request.getParameter("account");
		String email = request.getParameter("email");
		String messages = request.getParameter("messages");
		String sex = request.getParameter("sex");
		String employment = request.getParameter("employment");
		String problem = request.getParameter("problem");
		String result = "error";
		String res = Update.upBate(name,sex,employment,email,messages,problem,account);
		if(res != null) {
			result = "success";
		}
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        response.getWriter().print(jsonObject);
        System.out.println("ending");
	}
}
