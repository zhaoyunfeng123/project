package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import control.SignUp;

/**
 * Servlet implementation class ServiceSignUp
 */
@WebServlet("/ServiceSignUp")
public class ServiceSignUp extends HttpServlet {
	int number = 0;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 	number++;
	        System.out.println("已经进入... ,第"+number+"次");
	        request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");
	        String name="";
	        String password = "";
	        String account = "";
	        name = request.getParameter("name");
	        password = request.getParameter("password");
	        account=request.getParameter("account");
	        String result = "";
	        //调用数据库方法并做出判断
	        if (SignUp.signUp(account,name,password)) {
	            result="success";
	        }else{
	            result = "error";
	        }
	        JSONObject jsonObject = new JSONObject();
	        jsonObject.put("result", result);
	        response.getWriter().print(jsonObject);
	        System.out.println("ending");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
