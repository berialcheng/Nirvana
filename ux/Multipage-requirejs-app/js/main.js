require.config({
	paths:{
		"animal":"animal",
		"cat":"cat",
		"dddog":"dog",
		"jquery":"http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min"
	}
})

require(["animal"], function(util) {
	require(["cat","dddog","jquery"], function(argument) {

		// Load extra scirpts if necessary
		var scripts = $("script[data-extra]").data("extra");
		if(scripts){
			var extraScirpts = scripts.split("|");
			require(extraScirpts, function(argument) {
				// TODO
			})
		}
	})
});