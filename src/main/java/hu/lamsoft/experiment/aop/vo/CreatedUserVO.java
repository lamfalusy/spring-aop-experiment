package hu.lamsoft.experiment.aop.vo;

import java.util.Date;

public class CreatedUserVO extends UserVO {

	private Date createDate;

	public CreatedUserVO() {
		// Nothing to do here
	}
	
	public CreatedUserVO(UserVO user, Date loginDate) {
		super(user.getName());
		this.setCreateDate(loginDate);
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
