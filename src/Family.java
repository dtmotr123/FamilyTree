import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Family {
	
	private Boolean name1IsMale; //if true, then name2 is female and vice-versa
	private String name1;
	private String name2;
	private ArrayList<Family> children;
	
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
		//Check if parents exists
			//if they do exist, check they don't have a child under this name. Then create new child
		
		//test to see if root node has any parents
		if(name1 == null && name2 == null) { 
			name1 = parentName;
			children.add(new Family(childName));
			System.out.println("Created " + parentName + " with child " + childName);
			return;
		}
		
		//Check if parents exists
		Family parent = findPersonRec(this, parentName);
		if(parent != null) {
			System.out.println("Found parent with name " + parent.getName1());
			//Parent exists 
			//Check they don't already have a child under this name
			for(Family child : parent.getChildren())
			{
				if(child.getName1().equalsIgnoreCase(childName))
				{
					System.out.println("ERROR: A child already exists for this parent");
					return;
				}//IF-end
			} //FOR-end
			//If reached here, a child for this parent doesn't exist, so create the child for the parent
			parent.getChildren().add(new Family(childName));
		} else {
			//Parent does not exist, but check if a child exists to give them a new second parent
			Family child = findPersonRec(this, childName);
			if(child != null)
			{
				//Give the child a new parent assuming no duplicate!
				Family childsParent = returnParentWithSpecificChildRec(this, childName);
				if(childsParent.getName1() != null && childsParent.getName1().equalsIgnoreCase(parentName) 
						|| childsParent.getName2() != null && childsParent.getName2().equalsIgnoreCase(parentName))
				{
					//Is duplicate, so return with no changes
					System.out.println("ERROR: This parent already exists for this child");
					return;
				} else {
					//Is not duplicate, so continue
					if(childsParent.getName1() == null)
					{
						childsParent.setName1(parentName);
					} else if (childsParent.getName2() == null)
					{
						childsParent.setName2(parentName);
					} else {
						System.out.println("ERROR: This child already has 2 parents");
					}
				}
				
			} else 
			{
				//TODO block needed?
			}
		}
	}
	
	//DFS using recursion to find parent
	public Family findPersonRec(Family f, String nameSearch) 
	{
		if(f.getName1() != null && f.getName1().equalsIgnoreCase(nameSearch) 
				|| f.getName2() != null && f.getName2().equalsIgnoreCase(nameSearch))
		{
			return f;
		} else {
			if(f.getChildren() != null) {
				for(Family child : f.getChildren())
				{
					Family res = findPersonRec(child, nameSearch);
					if(res != null)
						return res;
				}
			} //END-if !null
			
		}
		return null;
	}
	
	//DFS using recursion to find a parent with a specific child
	public Family returnParentWithSpecificChildRec(Family f, String nameSearch) 
	{
		if(testChildren(f.getChildren(), nameSearch))
		{
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
	
	//Helper method for method above 'returnParentWithSpecificChildRec()'
	public boolean testChildren(ArrayList<Family> children, String childName)
	{
		for(Family child : children)
		{
			if(child.getName1() != null && child.getName1().equalsIgnoreCase(childName) 
					|| child.getName2() != null && child.getName2().equalsIgnoreCase(childName))
				return true;
		}
		return false;
	}
	
	public String[] getChildrenOf(String parent)
	{
		//getChildrenOf code
		Family childrenOfParent = findPersonRec(this, parent);
		if(childrenOfParent == null)
		{
			System.out.print("ERROR: Parent with this name not found");
			return null;
		}
		ArrayList<String> childrenNamesArray = new ArrayList<String>();
		
		for(Family child : childrenOfParent.getChildren())
		{
			childrenNamesArray.add(child.getName1());
		}
		Collections.sort(childrenNamesArray);
		
		String[] childrenNames = childrenNamesArray.toArray(new String[0]);

		return childrenNames;
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
	
	
	
	
	//GETTERS AND SETTERS\
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
