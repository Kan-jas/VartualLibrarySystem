<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="listSection">
		<h2>資料目録</h2>
		<table class="matList">
			<tr>
				<th class="mainCell" id="cell1"></th>
				<th class="mainCell" id="cell2">ISBN番号</th>
				<th class="mainCell" id="cell3">資料名</th>
				<th class="mainCell" id="cell4">分類コード</th>
				<th class="mainCell" id="cell5">著者</th>
				<th class="mainCell" id="cell6">出版社</th>
				<th class="mainCell" id="cell7">出版日</th>
				<th class="mainCell" id="cell8">資料ID</th>
			</tr>
			<tr>
				<td class="subCell">1</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td class="subCell">2</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td class="subCell">3</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td class="subCell">4</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td class="subCell">5</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<div class="buttons">
			<a class="button" >メインメニューへ</a>
		</div>
	</div>
	<style type="text/css">
/* 	//装飾部分 */
	.listSection{
		width:1100px;
		margin: 0 auto;
	}
	h2{
		width: 100%;
    	margin: 10px auto;
    	text-decoration:underline;
	}
	.matList{
		width:100%;
		border:1px solid #333;
		border-color:#333;
		border-collapse:separate;
		border-spacing: 0;
	}
	.mainCell,.subCell{
		background-color: #dae8fc;
		border-left: 1px solid #333;
		border-bottom: 1px solid #333;
		text-align: left;
	}
	.subCell{
		text-align: center;
	}
	td{
	border-left: 1px solid #333;
	border-bottom: 1px solid #333;
	}
	#cell1{
		width:4%;
	}
	#cell2{
		width:16%;
	}
	#cell3{
		width:20%;
	}
	#cell4{
		width:12%;
	}
	#cell5, #cell6, #cell7,#cell8{
		width:12%;
	}
	.buttons{
		width:167px;
		margin:10px 0 auto auto;
	}
	.button{
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
	button:hover{
    	box-shadow: 0 3px 3px 0 rgba(0,0,0,0.14), 0 1px 7px 0 rgba(0,0,0,0.12), 0 3px 1px -1px rgba(0,0,0,0.2);/*浮き上がるように*/
	}
	</style>
</body>
</html>