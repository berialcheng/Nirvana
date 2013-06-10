// environment specific settings
environments {
    development {
		grails {
			mongo {
				host = "localhost"
				port = 27017
				databaseName = "foo"
			}
		}
    }
    test {
        
    }
    production {
        
    }
}

