<html>
<body>
<h2>Hello World!</h2>

Time:
<textarea id="foo">
</textarea>
 
<br><br>
<button onclick="start()">Start</button>
<script type="text/javascript">
	function start(){
		var eventSource=new EventSource("SSEServlet");
		eventSource.onmessage=function(event){
			document.getElementById('foo').innerHTML += event.data + "\n";
		};
	}
</script>
</body>
</html>
