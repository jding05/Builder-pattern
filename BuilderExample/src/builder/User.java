package builder;

public class User {
	private final String firstName;
	private final String lastName;
	private final int age;
	private String phone;
	private String address;

	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void showProfile() {
		System.out.println("firstName: " + this.firstName);
		System.out.println("lastName: " + this.lastName);
		System.out.println("age: " + this.age);
		System.out.println("phone: " + this.phone);
		System.out.println("address: " + this.address);
	}

	public static class UserBuilder{
		private String firstName; // mandatory
		private String lastName; // mandatory
		private int age = 0; // default value is 0
		private String phone = ""; // default value is empty string
		private String address; // default is null
		
		public UserBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public UserBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}
		
		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public User build() {
			if (firstName == null || lastName == null) {
				throw new IllegalArgumentException("required fields are not set!");
			}
			return new User(this);
		}
	}
	

	public static void main(String[] args) {
		User user = new User.UserBuilder()
						.lastName("Ding")
						.firstName("Jeff")
						.age(42)
						.phone("1234567890")
						.address("one seattle way, Seattle, WA")
						.build();
		
		user.showProfile();
	}
}
