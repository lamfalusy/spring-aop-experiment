package hu.lamsoft.experiment.aop.vo;

public class UserVO {

	private String name;

	public UserVO() {
		// Nothing to do here
	}
	
	public UserVO(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
