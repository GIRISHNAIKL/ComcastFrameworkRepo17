package Command_prompt;

public class JavaCmdTest {

	public static void main(String[] args) 
	{

		System.out.println(args.length);
		//length is used in string array how many arguments we have
		//by default it is zero
		for(String var:args)
		{
			System.out.println(var);
		}
	
		
	}

}
