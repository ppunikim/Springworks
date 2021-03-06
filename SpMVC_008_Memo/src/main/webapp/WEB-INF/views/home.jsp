<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>메인 화면</title>
<style>
* {
	background-color: #f2eddc;
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
}

body {
	width: 85%;
	height: 100%;
	display: flex;
	flex-direction: column;
	margin: auto;
}

.hs_block {
	display: none;
}

.hs_fix {
	position: fixed;
}

.hs_flex {
	display: flex;
}

.hs_sa {
	justify-content: space-between;
	margin-top: 10px;
}

.z_log {
	line-height: 50px;
	margin-left: auto;
	color: #3f4338;
	text-decoration: none;
	font-weight: 500;
	font-size: 20px;
}

.hs_menu {
	position: relative;
	display: inline-block;
	cursor: pointer;
	vertical-align: top;
}

.hs_top {
	outline: none;
	cursor: pointer;
}

.hs_head {
	flex: 1;
}

.hs_drop {
	min-height: 0;
	visibility: hidden;
	opacity: 0;
	transform: translateY(-2rem);
	list-style: none;
	position: absolute;
	min-width: 100px;
	transition: 1.2s;
	cursor: pointer;
}

.hs_drop a {
	color: #eee;
	border-radius: 25px;
	background-color: gray;
	padding: 10px;
	font-weight: 300;
	text-decoration: none;
}

.hs_menu:hover .hs_drop {
	cursor: pointer;
	visibility: visible;
	opacity: 1;
	transform: translateY(0);
}

div img {
	margin-right: 20px;
}

section {
	flex: 1;
	font-size: larger;
	text-align: center;
	margin: 250px 0 150px 0;
	line-height: 40px;
}

section h3 {
	font-weight: 500;
}

footer {
	text-align: center;
}

footer a {
	line-height: 100px;
	font-size: 30px;
}
</style>
</head>
<body>
	<header class="hs_flex hs_sa">
		<img src="static/images/logo.jpg" width="50vw">
		<c:choose>
			<c:when test="${empty USERNAME}">
				<h4 class="z_log">
					<a href="${rootPath}/user/login" class="z_log">login</a>
				</h4>
			</c:when>
			<c:otherwise>
				<div class="hs_fix">
					<div class="hs_flex">
						<div class="z_log hs_menu">
							<div class="z_log hs_top hs_head">about</div>
							<div class="hs_drop">
								<a href="${rootPath}/memo/m-list">메모장</a> <br> <a
									href="${rootPath}/diary/d-add">일기장</a> <br> <a
									href="${rootPath}/book/b-add">독후감</a> <br> <a
									href="${rootPath}/user/logout" class="z_log">logout</a>
							</div>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</header>
	<section>
		<h1>sunny's web page</h1>
		<h3>diary, memo, books.. etc</h3>
	</section>
	<footer>
		<a>▼</a>
	</footer>
	<p>Flamingos are famous for their bright pink feathers, stilt-like
		legs, and S-shaped neck. When a flamingo spots potential
		dinner—favorite foods include shrimp, snails, and plantlike water
		organisms called algae—it plunges its head into the water, twists it
		upside down, and scoops the fish using its upper beak like a shovel.
		They are able to "run" on water, thanks to their webbed feet, to gain
		speed before lifting up into the sky. Flamingos build nests that look
		like mounds of mud along waterways. At the top of the mound, in a
		shallow hole, the female lays one egg. The parents take turns sitting
		on the egg to keep it warm. After about 30 days, the egg hatches.</p>
	<p>Flamingos are famous for their bright pink feathers, stilt-like
		legs, and S-shaped neck. When a flamingo spots potential
		dinner—favorite foods include shrimp, snails, and plantlike water
		organisms called algae—it plunges its head into the water, twists it
		upside down, and scoops the fish using its upper beak like a shovel.
		They are able to "run" on water, thanks to their webbed feet, to gain
		speed before lifting up into the sky. Flamingos build nests that look
		like mounds of mud along waterways. At the top of the mound, in a
		shallow hole, the female lays one egg. The parents take turns sitting
		on the egg to keep it warm. After about 30 days, the egg hatches.</p>
	<p>Flamingos are famous for their bright pink feathers, stilt-like
		legs, and S-shaped neck. When a flamingo spots potential
		dinner—favorite foods include shrimp, snails, and plantlike water
		organisms called algae—it plunges its head into the water, twists it
		upside down, and scoops the fish using its upper beak like a shovel.
		They are able to "run" on water, thanks to their webbed feet, to gain
		speed before lifting up into the sky. Flamingos build nests that look
		like mounds of mud along waterways. At the top of the mound, in a
		shallow hole, the female lays one egg. The parents take turns sitting
		on the egg to keep it warm. After about 30 days, the egg hatches.</p>
	<p>Flamingos are famous for their bright pink feathers, stilt-like
		legs, and S-shaped neck. When a flamingo spots potential
		dinner—favorite foods include shrimp, snails, and plantlike water
		organisms called algae—it plunges its head into the water, twists it
		upside down, and scoops the fish using its upper beak like a shovel.
		They are able to "run" on water, thanks to their webbed feet, to gain
		speed before lifting up into the sky. Flamingos build nests that look
		like mounds of mud along waterways. At the top of the mound, in a
		shallow hole, the female lays one egg. The parents take turns sitting
		on the egg to keep it warm. After about 30 days, the egg hatches.</p>

</body>
</html>