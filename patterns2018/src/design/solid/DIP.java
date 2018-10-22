package design.solid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

enum Relationship {
	PARENT,
	CHILD,
	SIBLING
}

class Triplet<T, U, V> {

    private final T first;
    private final U second;
    private final V third;

    public Triplet(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() { return first; }
    public U getSecond() { return second; }
    public V getThird() { return third; }
}

class Person {
	public String name;

	public Person(String name) {		
		this.name = name;
	}
	
}

interface RelationshipBrowser {
	List<Person> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser {
	private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
	
	
	
	public List<Triplet<Person, Relationship, Person>> getRelations() {
		return relations;
	}



	public void addParentAndChild(Person parent, Person child) {
		relations.add(new Triplet<>(parent, Relationship.PARENT, child));
		relations.add(new Triplet<>(child, Relationship.CHILD, parent));
	}



	@Override
	public List<Person> findAllChildrenOf(String name) {		
		return relations.stream()
			.filter(x -> Objects.equals(x.getFirst().name, name) 
						&& x.getSecond() == Relationship.PARENT)
			.map(Triplet::getThird)
			.collect(Collectors.toList());
	}
}

class Research {
	
/*	
	public Research(Relationships relationships) {
		List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
		relations.stream()
			.filter(x -> x.getFirst().name.equals("John") 
						&& x.getSecond() == Relationship.PARENT)
			.forEach(ch -> System.out.println("John has a child called "+ch.getThird().name));		
	}
	
*/	
	public Research(RelationshipBrowser browser) {
		List<Person> children = browser.findAllChildrenOf("John");
		for (Person person : children) {
			System.out.println("John has a child called: " + person.name);
		}		
	}
}


public class DIP {

	public static void main(String[] args) {
	
		Person parent = new Person("John");
		Person child1 = new Person("Chris");
		Person child2 = new Person("Matt");
		
		Relationships relationships = new Relationships();
		relationships.addParentAndChild(parent, child1);
		relationships.addParentAndChild(parent, child2);
		
		new Research(relationships);
		
	}

}
