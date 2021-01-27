package builder;

public class Pizza {
	private int size;
	private boolean cheese;
	private boolean pepperoni;
	private boolean bacon;
	
	public static class Builder {
		private final int size;
		private boolean cheese = false;
		private boolean pepperoni = false;
		private boolean bacon = false;
		
		public Builder(int size) {
			this.size = size;
		}
		
		public Builder cheese(boolean value) {
			cheese = value;
			return this;
		}
		
		public Builder pepperoni(boolean value) {
			pepperoni = value;
			return this;
		}
		
		public Builder bacon(boolean value) {
			pepperoni = value;
			return this;
		}
		
		public Pizza build() {
			return new Pizza(this);
		}
	}
	public void printRecipe() {
		System.out.println("size: " + size);
		System.out.println("cheese: " + cheese);
		System.out.println("pepperoni: " + pepperoni);
		System.out.println("bacon: " + bacon);
	}
	
	private Pizza(Builder builder) {
		size = builder.size;
		cheese = builder.cheese;
		pepperoni = builder.pepperoni;
		bacon = builder.bacon;
	}
	
	public static void main(String[] args) {
		Pizza pizza = new Pizza.Builder(12)
				.cheese(true)
				.pepperoni(true)
				.bacon(true)
				.build();
		pizza.printRecipe();
	}
}

