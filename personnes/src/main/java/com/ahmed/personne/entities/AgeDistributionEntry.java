package com.ahmed.personne.entities;

public class AgeDistributionEntry {
	 private int age;
	    private long count;

	    public AgeDistributionEntry(int age, long count) {
	        this.age = age;
	        this.count = count;
	    }

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public long getCount() {
			return count;
		}

		public void setCount(long count) {
			this.count = count;
		}

}
