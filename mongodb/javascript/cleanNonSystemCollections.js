/*
 * collection clean up  
 */
db.system.js.save({
        _id:"cleanNonSystemCollections",
        value:function(){ 
                var col_list = db.getCollectionNames()
                print('=============CLean Start==================')
                for( e in col_list){
                        if(col_list[e].indexOf('system.') < 0){
                                var code = "db."+col_list[e]+".drop()"
                                db.eval(code)
                                print(col_list[e]+" has been dropped.")
                        }
                }
                print('=============Clean Done===================')
        }
})
