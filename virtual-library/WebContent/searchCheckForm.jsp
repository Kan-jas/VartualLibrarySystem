<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="form">
		<h2>資料検索</h2>
		<ul>
			<form action="">
			<li class="searchArea">
				<label>会員ID：</label>
				<input id="firstName" type="text" name="name" placeholder="IDを入力してください" size="30">
				<p>または</p>
				<label>資料ID：</label>
				<input id="firstName" type="text" name="name" placeholder="IDを入力してください" size="30">
				<input id="serachBtn" type="submit" value="検索">
			</li>
			</form>
		</ul>
	</div>
	<style type="text/css">
	/*装飾部分*/
	.form{
		width:800px;
		margin: 0 auto;
	}
	ul li {
    	list-style: none;
	}
	li{
	margin: 10px 0;
	}
	label {
    	margin-right: 10px;
    	width:70px;
    	float: left;
	}
	ul {
    	width: 700px;
    	margin: 0 auto;
	}
	#serachBtn{
		width:50px;
		background-color: #dae8fc;
	}
	h2{
		width: 700px;
    	margin: 10px auto;
    	text-decoration:underline;
    }
    #serachBtn{
    	width:70px;
    	border-style:none;
		background-color: #dae8fc;
		display: inline-block;
		font-size: 1em;/*文字サイズ*/
		line-height: 1;
		text-decoration: none;
		letter-spacing: 0.05em;/*字間*/
		padding: 0.2em 1em;/*ボタン内の余白*/
		border-radius: 3px;/*角の丸み*/
		cursor: pointer;
		box-shadow: 0 2px 2px 0 rgba(0,0,0,0.14), 0 1px 5px 0 rgba(0,0,0,0.12), 0 3px 1px -2px rgba(0,0,0,0.2);/*影*/
		-webkit-tap-highlight-color: transparent;
		transition: .3s ease-out;/*変化を緩やかに*/
	}
	#serachBtn:hover{
    	box-shadow: 0 3px 3px 0 rgba(0,0,0,0.14), 0 1px 7px 0 rgba(0,0,0,0.12), 0 3px 1px -1px rgba(0,0,0,0.2);/*浮き上がるように*/
	}
	</style>
</body>
</html>