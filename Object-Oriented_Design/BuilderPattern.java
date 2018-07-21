public class BuilderPattern {
	private final String name; // required
	private final String gender; // required
	private final String tell; // optional
	private final int age; // optional
	public String getName() {
		return this.name;
	}
	public String getGender() {
		return this.gender;
	}
	public String getTell() {
		return this.tell;
	}
	public int getAge() {
		return this.age;
	}

	public static class Builder {
		// Required parameters
		private final String name;
		private final String gender;
		// Optional parameters
		private String tell = "000-000-0000";
		private int age = 0;
		public Builder(String name, String gender) {
			this.name = name;
			this.gender = gender;
		}
		
		public Builder tell(String val) {
			tell = val;
			return this;
		}
		public Builder age(int val) {
			age = val;
			return this;
		}
		public BuilderPattern build() {
			return new BuilderPattern(this);
		}
	}
	public void showBuilder() {
		System.out.println("Name: " + this.name);
		System.out.println("Gender: " + this.gender);
		System.out.println("Tell: " + this.tell);
		System.out.println("Age: " + this.age);
	}
	private BuilderPattern(Builder builder) {
		name = builder.name;
		gender = builder.gender;
		tell = builder.tell;
		age = builder.age;
	}
	public static void main(String[] args) {
		BuilderPattern bp = new BuilderPattern.Builder("Frank", "male")
										.tell("202-257-7520")
										.age(24)
										.build();
		bp.showBuilder();

	}
}