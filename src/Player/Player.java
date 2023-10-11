package Player;

public class Player {
	
	String backNum;
	String name;
	String age;
	String height;
	String weight;
	String position;
	
	public Player() {
		
	}

	public Player(String backNum, String name, String age, String height, String weight, String position) {
		this.backNum = backNum;
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.position = position;
	}
	
	public String getBackNum() {
		return backNum;
	}
	public void setBackNum(String backNum) {
		this.backNum = backNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Player [backNum=" + backNum + ", name=" + name + ", age=" + age + ", height=" + height + ", weight="
				+ weight + ", position=" + position + "]";
	}
	
	

}
