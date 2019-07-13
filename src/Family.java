import java.util.ArrayList;

public class Family {
	
	//TODO variables 
	private Boolean name1IsMale; //if true, then name2 is female and vice-versa
	private String name1;
	private String name2;
	private ArrayList<Family> children;
//	private ArrayList<Boolean> childrenGenders = new ArrayList<Boolean>();
	
	public Family() 
	{
		name1IsMale = null;
		name1 = null;
		name2 = null;
		children = new ArrayList<Family>();
	}
	
	public Family(String childName) //Creates new child
	{
		name1 = childName;
	}

	public void setParentOf(String childName, String parentName)
	{
		
	}
	
	public Family findPersonRec(Family f, String nameSearch) //DFS using recursion to find family member
	{
		if(f.getName1().equalsIgnoreCase(nameSearch) || f.getName2().equalsIgnoreCase(nameSearch))
		{
			System.out.println("found and returning");
			return f;
		} else {
			for(Family child : f.getChildren())
			{
				Family res = findPersonRec(child, nameSearch);
				if(res != null)
					return res;
			}
		}
		return null;
	}
	
	public void getChildrenOf(String parent)
	{
		//TODO getChildrenOf code
	}
	
	public void female()
	{
		//TODO setToFemale code
	}
	
	public void male()
	{
		//TODO setToMale code
	}
	
	public void isFemale()
	{
		//TODO Check if female
	}
	
	public void isMale()
	{
		//TODO Check if male
	}

	public Boolean getName1IsMale() {
		return name1IsMale;
	}

	public void setName1IsMale(Boolean name1IsMale) {
		this.name1IsMale = name1IsMale;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public ArrayList<Family> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Family> children) {
		this.children = children;
	}

}
