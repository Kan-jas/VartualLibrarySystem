<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>資料情報登録</h2>
	<ul>
		<form action="">
		<li class="ISBN">
			<label>ISBN番号：</label>
			<input id="ISBN" type="text" name="name" size="10">
		</li>
		<li class="materialName">
			<label>資料名：</label>
			<input id="firstName" type="text" name="name" placeholder="資料名" size="60">
		</li>
		<li class="specifyCode">
			<label>分類コード：</label>
            <select name=”specifyCode”>
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
			<option>6</option>
			<option>7</option>
			<option>8</option>
			<option>9</option>
			</select>
		</li>
		<li class="author">
			<label>著者：</label>
			<input id="author" type="text" name="name" size="10">
		</li>
		<li>
			<label>出版社：</label>
			<input id="publishing" type="text" name="name" size="20">
		</li>
		<li class="publishingDate">
			<label>出版日：</label>
			<input type="date">
		</li>
		<li class="author">
			<label>資料ID：</label>
			<input id="materialId" type="text" name="name" size="10">
		</li>
		<li class="storeDate">
			<label>入荷日：</label>
			<input type="date">
		</li>
		<li class="disposeDate">
			<label>廃棄日：</label>
			<input type="date">
		</li>
		<li class=column">
			<label>備考：</label>
			<textarea id="firstName" name="name" placeholder="何かあれば記入してください。" cols="50" rows="5"></textarea>
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
    	width:100px;
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