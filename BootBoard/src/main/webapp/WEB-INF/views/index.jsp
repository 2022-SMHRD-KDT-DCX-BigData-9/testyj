<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
	<title>Elements - Editorial by HTML5 UP</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Main -->
		<div id="main">
			<div class="inner">
				<!-- Header -->
				<header id="header">
					<a href="index.html" class="logo"><strong>Editorial</strong> byHTML5 UP</a>
				</header>
				<!-- Content -->
				<section>
					<header class="main">
						<h1>게시판 😊😊😊</h1>
					</header>
					<div class="row gtr-200">
						<div class="col-6 col-12-medium" style="width: 100%">
							<div class="table-wrapper">
								<table>
									<thead>
										<tr>
											<th>번호</th>
											<th>제목</th>
											<th>작성자</th>
											<th>작성일</th>
										</tr>
									</thead>
									<tbody>
									
										<c:forEach items="${list }" var="b">
										<tr>
											<td>${b.idx }</td>
											<td><a href="board/content/${b.idx }">${b.title }</a></td>
											<td>${b.writer }</td>
											<td>${b.indate }</td>
										</tr>
										</c:forEach>
										
										<tr>
											<td colspan="4">
											 <!-- onclick : 특정한 javascript 코드를 호출 속성 -->
											 <!-- javascript 코드를 사용해서 boardform 으로 요청! -->
											 <!-- location.href : 주소창의 주소 변경 (절대경로, 상대경로) -->
											 <!-- localhost:8087/bigdata/  -> index-->
											 <!-- localhost:8087/bigdata/boardform ->boardform -->
												<button onclick="location.href='boardform'" class="btn btn-sm btn-success">글작성</button>
											</td>
										</tr>
									</tbody>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
		<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">
				<!-- Search -->
				<section class="alt">
					<c:choose>
						<c:when test="${empty loginMember}">
							<form method="post" action="member/login" style="display:flex; align-items:stretch; flex-direction:column">
								<input type="text" placeholder="id" name="id"/>
								<input type="password" placeholder="password" name="pw">
								<input type="submit" value="LOGIN" lass="primary" />
							</form>	
						</c:when>
						<c:otherwise>
							${loginMember.nick }
							<form method="get" action="member/logout">
								<input type="submit" value="LOGOUT">
							</form>
						</c:otherwise>
					</c:choose>

				</section>

				<!-- Menu -->
				<nav id="menu">
					<header class="major">
						<h2>Menu</h2>
					</header>
					<ul>
						<li><a href="index.html">Homepage</a></li>
						<li><a href="#">Portfolio</a></li>
					</ul>
				</nav>

				<!-- Section -->
				<section>
					<header class="major">
						<h2>Get in touch</h2>
					</header>
					<p>스마트인재개발원</p>
					<ul class="contact">
						<li class="icon solid fa-envelope"><a href="#">smhrd@smhrd.or.kr</a></li>
						<li class="icon solid fa-phone">062-655-3506</li>
						<li class="icon solid fa-home">서울시 서초구 동작대로 132 9층</li>
					</ul>
				</section>

				<!-- Footer -->
				<footer id="footer">
					<p class="copyright">
						&copy; Untitled. All rights reserved. 
						Demo Images:<a href="https://unsplash.com">Unsplash</a>. 
						Design: <a href="https://html5up.net">HTML5 UP</a>.
					</p>
				</footer>
			</div>
		</div>
	</div>
	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>