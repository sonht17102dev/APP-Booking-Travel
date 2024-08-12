<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/admin/layouts/taglib.jsp"%>

<%@ include file="/views/client/layouts/header.jsp"%>

<!-- Form search start -->
<div class="hero-wrap js-fullheight"
	style="background-image: url('<c:url value="/views/client/images/bg_4.jpg"/>');">
	<div class="overlay"></div>
	<div class="container">
		<div
			class="row no-gutters slider-text js-fullheight align-items-center justify-content-center"
			data-scrollax-parent="true">
			<div class="col-md-9 ftco-animate"
				data-scrollax=" properties: { translateY: '70%' }">
				<h1 class="mb-4 text-center"
					data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">
					<strong>${post.name} <br></strong>
				</h1>
			</div>
		</div>
	</div>
</div>
<!-- Form search end -->


<section class="ftco-section bg-light px-5">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1>${post.name}</h1>
				<div class="w-100 text-center">
					<img class="w-75"
						src="${pageContext.servletContext.contextPath}/resources/images/${post.image}"
						title="${post.name}" alt="${post.name}">
				</div>
				<div class="content-news">${post.description}</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<h3 class="heading mb-4">Star Rating</h3>
				<form method="post" class="star-rating">
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">
							<p class="rate">
								<span><i class="icon-star"></i><i class="icon-star"></i><i
									class="icon-star"></i><i class="icon-star"></i><i
									class="icon-star"></i></span>
							</p>
						</label>
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">
							<p class="rate">
								<span><i class="icon-star"></i><i class="icon-star"></i><i
									class="icon-star"></i><i class="icon-star"></i><i
									class="icon-star-o"></i></span>
							</p>
						</label>
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">
							<p class="rate">
								<span><i class="icon-star"></i><i class="icon-star"></i><i
									class="icon-star"></i><i class="icon-star-o"></i><i
									class="icon-star-o"></i></span>
							</p>
						</label>
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">
							<p class="rate">
								<span><i class="icon-star"></i><i class="icon-star"></i><i
									class="icon-star-o"></i><i class="icon-star-o"></i><i
									class="icon-star-o"></i></span>
							</p>
						</label>
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">
							<p class="rate">
								<span><i class="icon-star"></i><i class="icon-star-o"></i><i
									class="icon-star-o"></i><i class="icon-star-o"></i><i
									class="icon-star-o"></i></span>
							</p>
						</label>
					</div>
					<div class="form-group">
						<label for="message">Message</label>
						<textarea name="" id="" cols="30" rows="7" class="form-control"
							placeholder="Message"></textarea>
					</div>
					<div class="form-group">
						<input type="submit" value="Post Comment"
							class="btn btn-primary py-3 px-5">
					</div>
				</form>
			</div>
		</div>
	</div>
</section>


<!-- Footer start -->
<%@ include file="/views/client/layouts/footer.jsp"%>
<!-- Footer end -->
