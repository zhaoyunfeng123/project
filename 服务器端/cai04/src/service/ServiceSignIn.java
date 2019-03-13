package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import bean.User;
import control.SignIn;

/**
 * Servlet implementation class ServiceSignIn
 */
@WebServlet("/ServiceSignIn")
public class ServiceSignIn extends HttpServlet {
	int number = 0;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceSignIn() {
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
		number++;
        System.out.println("已经进入... ,第"+number+"次");
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		List<User> list = SignIn.signIn(account,password);
		String name = "error";
		String email = "error";
		String messages = "error";
		String sex = "error";
		String employment = "error";
		String problem = "error";
		for(User user :list) {
			name = user.getName();
			email = user.getEmail();
			messages = user.getMessage();
			sex = user.getSex();
			employment = user.getEmployment();
			problem = user.getProblem();
		}
		//把数据编码成JSON格式
		JSONObject obj1 = new JSONObject();
		obj1.put("name", name);
		obj1.put("sex", sex);
		obj1.put("employment", employment);
		obj1.put("email", email);
		obj1.put("messages",messages);
		obj1.put("problem", problem);
		response.getWriter().print(obj1);
	}
}
