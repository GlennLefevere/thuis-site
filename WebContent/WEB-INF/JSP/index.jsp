<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ page contentType='text/html' pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value='Kalonline private server' />
</c:import>
</head>
<body>
	<div id="contents" class="clearfix">
		<c:import url='/WEB-INF/JSP/menu.jsp' />
		<aside class="clearfix">
			<article>
				<c:if test="${empty UID }">
					<h1>Login</h1>
					<form method="post">
					<label>Username:</label><br>
						<input type="text" name="id" id="username" required placeholder="Username"> <br>
						<label>Password:</label><br>
						<input type="password" name="pwd" id="password" required placeholder="Password"> <br>
						<input type="submit" name="login" value="Login" id="login">
					</form>
					<a href="/">register</a>
				</c:if>
				<c:if test="${not empty UID }">
				<h1>Welcome</h1>
				<p>Nice to see you again <br>${user}</p>
				</c:if>
			</article>
			<article>
				<h1>Castle owner</h1>
				<p>Glenn</p>
			</article>
		</aside>
		<section id="content" class="clearfix">
  <article>
    <h1>Some info</h1>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam tortor metus, tristique non malesuada sed, tincidunt vel lectus. Phasellus risus quam, laoreet ut velit in, accumsan ultricies erat. Donec et ligula metus. Vivamus at tortor dapibus, sollicitudin metus at, malesuada sapien. Proin in euismod purus. Vivamus eget velit pharetra, luctus lectus ut, convallis augue. Sed condimentum convallis risus a iaculis. Ut gravida velit eu massa ultrices tincidunt. Donec a lacus venenatis, fringilla justo quis, adipiscing lorem. Curabitur est eros, pellentesque a sagittis et, mollis sit amet metus. Nam massa urna, suscipit sit amet sapien quis, tempor tincidunt nulla. Donec gravida, erat molestie iaculis faucibus, ligula magna tristique tortor, ac rutrum ante diam id est. In mauris lorem, aliquet et purus sed, euismod tincidunt elit.</p>
    <p>Nullam vehicula convallis ipsum et bibendum. Nunc ornare odio at felis lacinia, quis mollis elit fringilla. Aliquam sollicitudin rhoncus neque, vel gravida lacus condimentum et. Nam lobortis lacus felis, eget mattis turpis dapibus ut. Curabitur quis lorem sed diam venenatis cursus. Quisque consectetur mauris ut enim aliquet tristique a id elit. Vivamus eu lorem vel ligula pulvinar feugiat vitae et eros. Sed urna nisi, tempor at adipiscing a, vehicula non tellus.</p>
    <p>Vivamus lobortis, elit eu pellentesque venenatis, erat ante ultricies turpis, eget mattis magna nisl vel sem. Quisque dui lacus, iaculis ut dignissim nec, pellentesque in diam. Duis quis nibh facilisis, condimentum mauris eu, aliquet ligula. Quisque posuere erat eget purus consectetur, id vehicula orci rutrum. Aliquam suscipit pulvinar ornare. Donec eu euismod lacus. Fusce ac leo neque. Aenean a odio eu nisi pharetra iaculis at pulvinar lectus.</p>
    <p>Vivamus consectetur ultricies placerat. Phasellus placerat lobortis lacus quis volutpat. Vestibulum blandit mi eu velit congue, in adipiscing leo semper. Nunc ac luctus tellus, et porttitor eros. Quisque varius mi ac laoreet sodales. Suspendisse ac scelerisque eros. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec nec eros sit amet metus tempor sodales a quis diam. Donec rutrum convallis mi non feugiat. Ut facilisis arcu in lacus fringilla, sed auctor urna mattis. Donec sollicitudin sem nec eleifend tristique. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec consectetur turpis et consequat feugiat. Ut imperdiet risus non leo pretium pulvinar. Donec mollis eleifend tincidunt. Sed consequat ipsum ac velit consectetur, vitae ullamcorper arcu iaculis.</p>
    <p>Ut nec est erat. Aliquam eleifend odio nibh, eget luctus eros imperdiet ac. Phasellus varius sodales varius. Integer tincidunt sodales blandit. Sed non egestas enim. Donec non erat vitae odio sodales volutpat. Mauris et ante quis ligula varius iaculis.</p>
  </article>
</section>
<section id="side" class="clearfix">
  <article>
    <h1>Server Status</h1>
    <p id="${server}">${server}</p>
  </article>
  <article>
    <h1>Vote</h1>
    <a>Vote</a> </article>
</section>
	</div>
	<footer> &copy;Glenn Lefevere </footer>
</body>
</html>