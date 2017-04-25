package com.fidelity.aws.web.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RetrieveBean {

	@NotNull
	@NotEmpty(message = "CMK ARN field cannot be empty")
    @Size(min = 1)
	@Pattern(regexp = "[0-9]{10}", message="enter valid arn number")
	private String cmkArn;

	public String getCmkArn() {
		return cmkArn;
	}

	public void setCmkArn(String cmkArn) {
		this.cmkArn = cmkArn;
	}

}
