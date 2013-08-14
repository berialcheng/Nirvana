class Simple{
	def def_member 

	Simple(){
		def_member = "string"
	}

	def def_method(){
		def member_clousure = { a, b ->
			println "statement_one ${a}."
			println "statement_two ${b}."
			return "return str"
		}

		member_clousure("my name" , "abc")
	}

	def def_method2(String param1){
		println param1
	}
} 

