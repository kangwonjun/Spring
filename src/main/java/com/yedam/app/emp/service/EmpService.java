package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

<<<<<<< HEAD
// 실제로 사용자에게 제공하는 기능
public interface EmpService {
	// 전체 사원정보 조회
	public List<EmpVO> empList();
	// 사원정보 단건 조회
	public EmpVO empInfo(EmpVO empVO);
	// 사원정보 단건 등록
	public int empInsert(EmpVO empVO);
	// 사원정보 단건 수정
	public Map<String, Object> empUpdate(EmpVO empVO);
	// 사원정보 단건 삭제
	public Map<String, Object> empDelete(int empId);
=======
// 실제로 제공하는 기능 
public interface EmpService {
		//전체 사원정보 조회
		public List<EmpVO> empList();
		//사원정보 단건 조회
		public EmpVO empInfo(EmpVO empVO);
		//사원정보 단건 등록
		public int empInsert(EmpVO empVO);
		//사원정보 단건 수정
		public Map<String, Object> empUpdate(EmpVO empVO);
		//사원정보 단건 삭제
		public Map<String, Object> empDelete(int empId);
>>>>>>> branch 'master' of https://github.com/kangwonjun/Spring.git
}
