package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller // Route : 사용자의 요청(endpoint)와 그에 대한 처리
// URI + METHOD => Service => View

public class EmpController {
	//해당 컨트롤러에서 제공하는 서비스 
	private final EmpService empService;
	
	@Autowired
	EmpController(EmpService empService){
		this.empService = empService;
	}
	
	// GET : 조회, 빈페이지
	// POST : 데이터 조작(등록, 수정 삭제)
	
	//전체조회 :GET
	@GetMapping("empList")
	public String empList(Model model) {
						 // Model = Request + Response
		// 1) 기능 수행 => Service
		List<EmpVO> list = empService.empList();
		// 2) 클라이언트에 전달할 데이터 담기
		model.addAttribute("emps", list);
		return "emp/list";//3) 데이터를 출력할 페이지 결정
	}
	//단건조회 : Get => QueryString(커맨드 객체 or @RequestP)
	public String empInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("emp", findVO);
		// HttpServletReqeust.setAttribute();
		return "emp/info";
	}
	
	//등록 - 페이지 : Get
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	
	//등록 - 처리 : Post => form태그를 통한 submit(페이지)
	//				   => QueryString (커맨드 객체)
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.empInsert(empVO);
		
		String url = null;
		
		if(eid > -1) {
			// 정상적으로 등록된 경우
			url = "redirect:empInfo?employeeId="+eid;
			// "redirect:" 가 가능한 경우 GetMapping
		}else {
			// 등록되지 않은 경우
			url = "redirect:empList";
		}
		return url;
	}
	
	
	
	
	//수정 - 페이지 : Get, 조건이 필요 <=> 단건조회 
	@GetMapping("empUpdate")
	public String empUpdate(EmpVO empVO, Model model) {
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("emp", findVO);
		return "emp/update";
	} 
	//수정 - 처리 : Post, AJAX => QueryString 
	@PostMapping("empUpdate")
	@ResponseBody //AJAX
	public Map<String, Object>
		empUpdateAJAXQueryString(EmpVO empVO){
		return empService.empUpdate(empVO);
	}
	public String postMethodName(@RequestBody String entity) {		
		return entity;
	}	
	//수정 - 처리 : AJAX => JSON(@REquestBody)
	//@PostMapping("empUpdate")
	@ResponseBody //AJAX
	public Map<String, Object>
		empUpdateAJAXJSON(@RequestBody EmpVO empVO){
		return empService.empUpdate(empVO);
	}
	
	//삭제 - 처리 : Get => QueryString( @RequestParam)
	@GetMapping("empDelete")
	public String empDelete(Integer employeeId) {
		empService.empDelete(employeeId);
		return "redirect:empList";
	}
}
