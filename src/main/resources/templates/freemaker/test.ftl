
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							名字
						</th>
						<th>
							性别
						</th>
						<th>
							邮箱
						</th>
						<th colspan="2">
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<#list pageInfo.list as p>
						<tr>
							<td>
								${p.id}
							</td>
							<td>
								${p.lastname}
							</td>
							<td>
								${p.gender}
							</td>
							<td>
								${p.email}
							</td>
							<td>
								描述
							</td>
							<td>
								购买
							</td>
							
						</tr>			
					</#list>
				</tbody>
			</table>
		</div>
	
		<div class="col-md-12 column">
			<ul class="pagination pull-right" >
				<li>
					 <a href="/getemps?pageNum=${pageInfo.getPrePage() }">上一页</a>
				</li>
				<#list pageInfo.getNavigatepageNums() as index>
					<li>
					<#if index==2>
					<li class="disabled"><a href="/getemps?pageNum=${index}">${index }</a></li> 
					<#else>
					<li><a href="/getemps?pageNum=${index}">${index }</a></li>
					</#if>
					</li>
				</#list>
				
				<li>
					 <a href="/getemps?pageNum=${pageInfo.getNextPage() }">下一页</a>
				</li>
			</ul>
		</div>
	
	</div>
</div>
<a href="/testTransication">事务</a>
hello
<#list pageInfo.list as p>
${p.lastname}
</#list>
${pageInfo}
</body>
</html>