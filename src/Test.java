
public class Test {

	
	public static void main(String[] args)
	{
		Family fam = new Family(); //root
		fam.setName1("Bob");
		fam.setName2("Sarah");
		fam.getChildren().add(new Family());
		fam.getChildren().get(0).setName1("Charlie");
		fam.getChildren().get(0).setName2("Laura");
		
		Family ob = fam.findPersonRec(fam, "Bob");
		System.out.println(ob.getName1());
	}
}
