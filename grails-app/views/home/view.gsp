<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Keys</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${resource(dir: 'css', file: 'bootstrap.min.css')}" rel="stylesheet" media="screen">
</head>

<body>
<div class="container">
    <h1>Product List</h1>

    <g:each in="${products}" var="p" status="i">
        <div onclick="showKey(${i},'${p}')">${p}</div>
        <div class="well" style="display:none" id="keys${i}">
        </div>
    </g:each>
</div>
<script src="http://code.jquery.com/jquery.js"></script>
<script src="${resource(dir: 'js', file: 'bootstrap.min.js')}"></script>
<script type="text/javascript">
	function showKey(productId,productName){
		var div=$('#keys'+productId)
		$.post('keys','product='+productName,function(data){
			var keys=eval(data)
			var code=""
			$.each(keys,function(index,value){
				code+=value+"<br>"
			})
			div.html(code)
		})
		div.toggle()
	}
</script>
</body>

</html>
