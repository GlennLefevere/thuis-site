<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value='Frituur  Frida' />
</c:import>
</head>
<body>
	<div id="contents" class="clearfix">
		<c:import url='/WEB-INF/JSP/menu.jsp' />
		<c:if test="${not empty folders}">
			<c:forEach items="${folders}" var="entry">
				<c:url value='/images.htm' var='folderURL'>
					<c:param name="location" value="${entry.key}" />
				</c:url>
				<c:choose>
					<c:when test="${not empty entry.value}">
						<img alt="" src="${entry.key}">
					</c:when>
					<c:otherwise>
						<a href="${folderURL}"><img alt="folder" src="images/folder_blue.png"></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>