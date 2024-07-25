<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
	<!-- Navbar Brand-->
	<a class="navbar-brand ps-3" href="${pageContext.servletContext.contextPath}/admin">Manage Tour</a>
	<!-- Sidebar Toggle-->
	<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
		id="sidebarToggle" href="#!">
		<i class="fas fa-bars"></i>
	</button>
	<!-- Navbar Search-->
	<form
		class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">

	</form>
	<!-- Navbar-->
	<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
		<li class="nav-item dropdown"><a th:if="${session.admin}"
			class="nav-link dropdown-toggle" href="${pageContext.servletContext.contextPath}/admin/logout" role="button"><i
				class="fas fa-user fa-fw"></i><span> Logout</span></a>
			<ul class="dropdown-menu dropdown-menu-end"
				aria-labelledby="navbarDropdown1">
				<li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/admin/#">Settings</a></li>
				<li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/admin/#">Activity Log</a></li>
				<li>
					<hr class="dropdown-divider" />
				</li>
				<li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/admin/logout">Logout</a></li>
			</ul></li>
	</ul>
</nav>