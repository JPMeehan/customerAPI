package com.bah.customer.Repository;

public class Customer {
		String name;
		String email;
		String password;
		
		public Customer(String name, String email, String password) {
			super();
			this.name = name;
			this.email = email;
			this.password = password;
		}

		public Customer() {
			
		}
		
		public String getName() {
			return name;
		}

		public String getEmail() {
			return email;
		}

		public String getPassword() {
			return password;
		}
		
		
}
