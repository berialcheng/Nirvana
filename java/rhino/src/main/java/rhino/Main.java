package rhino;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

	public static void main(String[] args) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		try{
			engine.eval("var i = 1; print(i);");
		}catch(ScriptException e){
			e.printStackTrace();
		}
	}
}
