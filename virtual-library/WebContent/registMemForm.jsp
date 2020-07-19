<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegistMemForm</title>
</head>
<body>
	<h2>会員情報登録</h2>
	<ul>
		<form action="">
		<li class="name">
			<label>氏名：</label>
			姓<input id="firstName" type="text" name="name" placeholder="山田" size="18">
			名
			<input id="lastName" type="text" name="name" placeholder="太郎" size="20">
		</li>
		<li class="birthday">
			<label for="">生年月日：</label>
            <input type="date">
		</li>
		<li>
			<label>〒：</label>
			<input id="postalCode" type="text" name="name" size="20">
		</li>
		<li>
			<label>住所：</label>
			<input id="addres" type="text" name="name" size="60">
		</li>
		<li>
			<label>電話番号：</label>
			<input id="phoneNumber" type="text" name="name" size="20">
		</li>
		<li class="email">
			<label for="email">Email</label>
            <input id="email" type="text" name="email"  cols="40" rows="60">
		</li>
		</form>
	</ul>
	<style type="text/css">
/* 	//装飾部分 */
	ul li {
    	list-style: none;
	}
	li{
	margin: 10px 0;
	}
	label {
    	margin-right: 10px;
    	width:80px;
    	float: left;
	}
	ul {
    	width: 700px;
    	margin: 0 auto;
	}
	h2{
		width: 700px;
    	margin: 10px auto;
    	text-decoration:underline;
	}
	</style>

</body>
</html>