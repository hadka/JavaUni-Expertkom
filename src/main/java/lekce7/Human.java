package lekce7;

public class Human {
	private String name;
	private Integer age;
	
	public Human(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Human() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public static Integer compareByNameThenAge(Human lhs, Human rhs) {
	    if (lhs.name.equals(rhs.name)) {
	        return lhs.age - rhs.age;
	    } else {
	        return lhs.name.compareTo(rhs.name);
	    }
	}
	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + "]";
	}
	
	public boolean equals(Object o) {
		/*ak objekt porovnavame so samym sebou, musi sa rovnat, preto equals vrati true*/
		if (o == this) { 
            return true; 
        /*ak porovnavyný, druhý objekt nie je typu Human, nemůžu sa rovnat, equals vrati false */
        }else if(!(o instanceof Human)) { 
            return false; 
        }else {
        	Human h = (Human) o; /*Object o pretypujeme na typ Human. Ak nerozumiete preco, skuste tento riadok zmazat a potom az napisat riadok 51.*/
        						 /*Pretypovanie by nemal byť problém, ak je Object o typu Human, čo sme overili v else if*/
        						 /*viac informácií o pretypovaní: google : type casting java */
        	return h.getAge() == this.getAge() && h.getName() == this.getName();
        }
	}
}
