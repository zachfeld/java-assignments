package shell; 

public class GoKart {
	//declare instance variables 
	private String name; 
	private int powerSource; 
	private int condition = 10; 
	private int experience = 1; 
	
	public void setName(String name) { 
		int nameLength = name.length();
		if(nameLength>0) {
			name = name.toLowerCase();
			this.name = name;
		} else {
			System.out.println("Error: invalid name parameters");
		}
		
	}
	
	public void setPowerSource(int powerSource) {
		if (powerSource == 1 || powerSource == 2 || powerSource == 3) {
			this.powerSource = powerSource;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPowerSource() {
		return this.powerSource;
	}
	
	public int getCondition() {
		return this.condition;
	}
	
	public int getExperience() {
		return this.experience;
	}
	
	public boolean driveOneLap() {
		boolean valid;
		if (this.condition>1) {
			this.condition --;
			if (this.experience < 5) {
				this.experience ++;
			}
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}
	
	public int fixKart() {
		final int top_condition = 10;
		if(condition != top_condition) {
			if(powerSource == 1 || powerSource == 2) {
				if (this.condition <= top_condition - 2)
					this.condition += 2;
					return 2;
			} else {
				if (this.condition <= top_condition - 1)
					this.condition ++;
					return 1;
			}
		}
		return 0;
	}
	public boolean isCompatibleWith(GoKart otherKart) {
		if(this.powerSource == 3 || otherKart.getPowerSource() == 3) {
			return true;
		} else if (this.powerSource == 2 && otherKart.getPowerSource() == 2) {
			return true;
		} else if (this.powerSource == 1 && otherKart.getPowerSource() == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
