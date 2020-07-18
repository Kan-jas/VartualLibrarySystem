<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>infoRegist</title>
<!-- //登録系の画面の構成用jspファイルです。 -->
<!-- //これに子のjspファイルをインクルードします。 -->
</head>

<body>
	<header>
		<div class="title">
			<div><h3 id="t1">新宿図書館</h3></div>
			<div><h1 id="t2">図書館管理システム</h1></div>
		</div>
	</header>

	<section id="main">
		<%@ include file="/updateMatForm.jsp"  %>
	</section>
<!-- 	//下記画面をインクルード -->
<!-- 	//会員登録(/registMemForm.jsp) -->
<!-- 	//会員更新(updateMemForm.jsp") -->
<!-- 	//資料登録(registMatForm.jsp) -->
<!-- 	//資料登録(updateMatForm.jsp) -->
<!-- 	//貸出登録 -->

	<section id="buttonPart">
		<button>確認画面へ</button>
	</section>
<!-- 	//ボタン部分をインクルード -->

	<style type="text/css">
/* 	//装飾部分 */
		.title{
			width: 1000px;
			height:80px;
			margin: 0 auto;
			display: -webkit-flex;
    		display: flex;
		}
		#t1{
			width: 100px;
			text-align: center;
			text-align: center;
		}
		#t2{
			width: 900px;
		}
		#buttonPart{
			height: 100px;
			position: relative;
		}
		button{
			position: absolute;
			top: 10%;
			right: 38%;
  			padding: 0.25em 0.5em;
			text-decoration: none;
			color: #00BCD4;
			background: #ECECEC;
			transition: .4s;
		}
		button:hover{
			background: #00bcd4;
			color: white;
		}
	</style>
</body>
</html>