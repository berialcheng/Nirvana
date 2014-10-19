public class Main{
	public static void main(String args[]){
		FooEnum foo = FooEnum.ENUM_ONE;
		switch(foo){
			case ENUM_ONE: System.out.println("One");break;
			default : System.out.println("Default");
		}
		
	}
}
