<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${subCaiList }" var="cai">
<img src="${cai.caiImageUrl} " width="350px" height="235px" />
		<p>${cai.caiId }	
		菜名:${cai.caiName }<br/>
		菜系:${cai.caiClass }<br/>	
		需要材料:${cai.caiRaw }<br/>
		制作方法:${cai.caiOperandi }
		</p>
</c:forEach>
<c:if test="${page.currentPage != 1 }">
	<a href="CaiServlet?currentPage=${page.currentPage - 1}">上一页</a>
</c:if>
<c:if test="${page.currentPage != page.pageCount }">
	<a href="CaiServlet?currentPage=${page.currentPage + 1}">下一页</a>
</c:if>
<c:forEach begin="1" end="${page.pageCount }" var="i">
	<a href="CaiServlet?currentPage=${i}">${i }</a>
</c:forEach>
</body>
</html>