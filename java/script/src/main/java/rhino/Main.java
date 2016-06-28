package rhino;

import javax.script.*;

public class Main {

	public static void main(String[] args) {
		listEngines();
		evalScript();
		invocableScript();
	}

	public static void listEngines(){
		ScriptEngineManager mgr = new ScriptEngineManager();
		for(ScriptEngineFactory factory : mgr.getEngineFactories()){
			System.out.printf("Name: %s%n" +
							"Version: %s%n" +
							"Language name: %s%n" +
							"Language version: %s%n" +
							"Extensions: %s%n" +
							"Mime types: %s%n" +
							"Names: %s%n",
							factory.getEngineName(),
							factory.getEngineVersion(),
							factory.getLanguageName(),
							factory.getLanguageVersion(),
							factory.getExtensions(),
							factory.getMimeTypes(),
							factory.getNames());
		}
	}

	public static void evalScript(){
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");

		try{
			engine.put("name", "Alex");
			engine.eval("var message = 'Hello, ' + name;");
			System.out.println(engine.eval("message"));
		}catch(ScriptException e){
			e.printStackTrace();
		}
	}

	public static void compileScript(){
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");

		try {
			Compilable compilable = (Compilable)engine;
			CompiledScript cs = compilable.compile("var test = function(p){return p * 12;}");
			//System.out.println(cs.eval("test"));
		}catch (ScriptException e){

		}
	}

	public static void invocableScript(){
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");

		try{
			engine.eval("var test = function(p){return p * 12;}");
			Invocable inv = (Invocable) engine;
			System.out.println(inv.invokeFunction("test", "13").getClass());
		}catch(ScriptException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
