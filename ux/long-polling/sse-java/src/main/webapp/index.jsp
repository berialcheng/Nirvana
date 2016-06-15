<html>
  <head>
    <script src="http://cdn.bootcss.com/jquery/2.2.1/jquery.js"></script>
    <!--<script src="eventsource.js"></script>-->
  </head>
<body>
<h2>Hello World!</h2>

Time:
<textarea id="foo">
</textarea>

<br><br>
<button id="start">Start</button>
<script type="text/javascript">
  $(document).ready(function(){
    $("#start").click(function(){
		var eventSource=new EventSource("SSEServlet");
		eventSource.onmessage=function(event){
			document.getElementById('foo').innerHTML += event.data + "\n";
    };})
	})
</script>
</body>
</html>
