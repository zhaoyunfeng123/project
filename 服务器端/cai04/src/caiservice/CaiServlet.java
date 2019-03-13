package caiservice;

import java.io.IOException;
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
 * Servlet implementation class BookServlet
 */
@WebServlet("/CaiServlet")
public class CaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CaiDao caiDao = new CaiDao();
		HttpSession session = request.getSession();
		List<CaiBean> caiList = null;
		if(session.getAttribute("caiList")==null) {
			caiList = caiDao.getAllCai();
			session.setAttribute("caiList", caiList);
		}else {
			caiList = (List<CaiBean>)session.getAttribute("caiList");
		}
		String currentPageStr = request.getParameter("currentPage");
		int currentPage;
		if(currentPageStr == null || currentPageStr.equals("")) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setColumnCount(caiList.size());
		int fromIndex = (currentPage-1) * page.getColumnPage();
		boolean b = currentPage == page.getPageCount();
		int yuShu = page.getColumnCount() % page.getColumnPage();
		int toIndex ;
		if(yuShu == 0) {
			toIndex =  fromIndex + page.getColumnPage();
		}else {
			toIndex = b?(fromIndex + yuShu):(fromIndex + page.getColumnPage());
		}
		List<CaiBean> subCaiList = caiList.subList(fromIndex, toIndex);
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
