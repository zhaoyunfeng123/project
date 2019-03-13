package caiservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bean.CaiBean;
import common.Page;
import dao.CaiDao;

/**
 * Servlet implementation class CaiListServlet
 */
@WebServlet("/CaiListServlet")
public class CaiListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaiListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CaiDao caiDao = new CaiDao();
		String currentPageStr = request.getParameter("currentPage");
		int currentPage = 1;
		if(currentPageStr != null && !currentPageStr.equals("")) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		HttpSession session = request.getSession();
		List<CaiBean> caiList = null;
		if(session.getAttribute("caiList") == null) {
			caiList = caiDao.getAllCai();
		}else {
			caiList = (List<CaiBean>)session.getAttribute("caiList");
		}
		session.setAttribute("caiList", caiList);
		Page page = new Page();
		page.setColumnCount(caiList.size());
		page.setCurrentPage(currentPage);
		List<CaiBean> subCaiList = new ArrayList<CaiBean>();
		int fromIndex = (currentPage-1) * page.getColumnPage();
		int yuShu = page.getColumnCount() % page.getColumnPage();
		int toIndex = (currentPage < page.getPageCount())?(fromIndex + page.getColumnPage()):(fromIndex + yuShu);
		subCaiList = caiList.subList(fromIndex, toIndex);
		request.setAttribute("subCaiList", subCaiList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("cailist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
