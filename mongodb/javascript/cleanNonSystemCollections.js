/*
 * collection clean up  
 */
db.system.js.save({
	_id:"cleanNonSystemCollections",
	value:function(){ 
		var col_list = db.getCollectionNames() 
		print('=================================================') 
		for( e in col_list){ 
			if(col_list[e] != 'system.users' && col_list[e] != 'system.indexes' && col_list[e] != 'system.js'){ 
				var code = "db."+col_list[e]+".drop()" 
				db.eval(code) 
				print(col_list[e]+" has been dropped.") 
			} 
		} 
		print('=================================================') 
	}
})
//db.loadServerScripts()
