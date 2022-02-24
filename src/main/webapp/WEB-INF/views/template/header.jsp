<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   	<!--header시작 -->
   	
   	<header class="header">
		<nav class="nav_main">
			<ul>
				<li><a href="/s1/">HOME</a></li>
				<li><a href="/s1/notice/list">NOTICE</a></li>
				<li><a href="/s1/qna/list">QnA</a></li>
				<li><a href="/s1/bankbook/list">PRODUCT</a></li>
			</ul>
		</nav>
		<nav class="nav_sub">
			<ul>
				<c:choose>
					<c:when test="${not empty member}">
						<li><a href="/s1/member/mypage">MyPage</a></li>
						<li><a href="/s1/member/logout">Logout</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/s1/member/login">로그인	<span class="material-icons">login</span>
						</a></li>
						<li><a href="/s1/member/join">회원가입<span class="material-icons">person_add
						</span></a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</header>
		<!--header끝-->