package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpVO {
	private Integer employeeId; //사원번호 primary key
	private String firstName;  //이름
	private String lastName;	//성 : Not Null
	private String email;		//이메일 : Not Null
	private String phoneNumber; //연락처 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;		//입사일자
	private String jobId;		//업무
	private Double salary;		//급여 : > 0
	private Double commissionPct;	//상여금
	private Integer managerId;   //상사번호 : Foreign key
	private Integer departmentId; //부서번호: Foreign key
}
