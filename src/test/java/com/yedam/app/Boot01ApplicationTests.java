package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot01ApplicationTests {
	@Autowired // 필드주입 
	private EmpMapper empMapper;
	
	/*@Test
	void contextLoads() {
		assertNotNull(empMapper);
	}*/
	
	
	 //@Test
	  void empList(){
	  //전체조회 : 입력,X -> 출력, 1건이상
	  List<EmpVO> list = empMapper.selectEmpAllList();
	  assertTrue(!list.isEmpty());
	 }
	 
	 //@Test
	 void empInfo() {
		 //단건조회 : 입력, 사원번호(101) -> 출력, 사원이름(Kochhar)
		 EmpVO empVO = new EmpVO();
		 empVO.setEmployeeId(101);
		 
		 EmpVO findVO = empMapper.selectEmpInfo(empVO);
		 assertEquals(findVO.getLastName(),"Kochhar");
	 }
	  	 
	
	// @Test
	 void empInsert() {
		 // 사원등록 : 입력,사원, 업무
		 //        -> 출력, 1
		 EmpVO empVO = new EmpVO();
		 empVO.setLastName("Hong");
		 empVO.setEmail("kdHong@naver.com");
		 empVO.setJobId("IT PROG");
	 }
	 
	 

	 //@Test
	 void empInsertFUll() throws ParseException {
		 // 사원등록 : 입력,사원이름,이메일,입사일자,업무,급여
		 //        -> 출력, 1
		 EmpVO empVO = new EmpVO();
		 empVO.setLastName("HAN");
		 empVO.setEmail("jhHan@naver.com");
		 SimpleDateFormat sdf 
		 	= new SimpleDateFormat("yyyy-MM-dd");
		 Date today = sdf.parse("2024-08-15");
		 empVO.setHireDate(today);
		 empVO.setJobId("SA_REP");
	 }
	 
	 //@Test
	 void empDelete() {
		 int result = empMapper.delectEmpInfo(207);
		 assertEquals(result, 1);
		 
		 result = empMapper.delectEmpInfo(208);
		 assertEquals(result, 1);
	 }
	 
	 //@Test
	 void empUpdate() {
		 EmpVO empVO = new EmpVO();
		 empVO.setEmployeeId(149);
		 
		 EmpVO findVO = empMapper.selectEmpInfo(empVO);
		 findVO.setEmail("kjHong@naver.com");
		 
		 int result
		 = empMapper.updateEmpInfo(findVO.getEmployeeId(), findVO);
		 assertEquals(result, 1);
	 }
	 
	 @Test
	 void empUpdateDynamic() {
		 EmpVO empVO = new EmpVO();
		 empVO.setEmployeeId(149);
		 empVO.setLastName("kang");
		 empVO.setJobId("HR_REP");
		 
		 
		 int result
		 = empMapper.updateEmpInfo(empVO.getEmployeeId(), empVO);
		 assertEquals(result, 1);
	 }
	 
	 
}
