package com.yedam.app.dept.web;

import java.util.List;
<<<<<<< HEAD
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class DeptController {
	private DeptService deptService;

	@Autowired
	DeptController(DeptService deptService) {
		this.deptService = deptService;
	}

	// 전체조회
	@GetMapping("deptList")
	public String deptList(Model model) {
		List<DeptVO> list = deptService.deptList();
		model.addAttribute("depts", list);
		return "dept/list";
		
	}

	// 단건조회
	@GetMapping("deptInfo") 
	public String deptInfo(DeptVO DeptVO, Model model) {
		DeptVO findVO = deptService.deptInfo(DeptVO);
		model.addAttribute("dept", findVO);
		return "dept/info";
	}

	// 등록 - 페이지
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}
	
	// 등록 - 처리
	@PostMapping("deptInsert")
	public String empInsertProcess(DeptVO DeptVO) {
		int did = deptService.deptInsert(DeptVO);
		
		String url = null;
		
		if(did > -1) {
			// 정상적으로 등록된 경우
			url = "redirect:deptInfo?departmentId="+did;
			// "redirect:" 가 가능한 경우 GetMapping
		}else {
			// 등록되지 않은 경우
			url = "redirect:deptList";
		}		
		return url;
	}	

	// 수정 - 페이지
	@GetMapping("deptUpdate") // empUpdate?employeeId=value
	public String empUpdateForm(DeptVO DeptVO, Model model) {
		DeptVO findVO = deptService.deptInfo(DeptVO);
		model.addAttribute("emp", findVO);
		return "dept/update";
	}

	// 수정 - 처리 : JSON
	@PostMapping("deptUpdate")
	@ResponseBody // AJAX
	public Map<String, Object>
	deptUpdateAJAXJSON(@RequestBody DeptVO DeptVO){
		return deptService.deptUpdate(DeptVO);
	}

	// 삭제 - 처리
	@GetMapping("deptDelete")
	public String empDelete(Integer departmentId) {
		deptService.deptDelete(departmentId);
		return "redirect:empList";
	}
}
=======

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Controller
public class DeptController {
	private DeptService deptService;
	
	@Autowired
	DeptController(DeptService deptService){
		this.deptService = deptService;
	}
	
	// 전체조회
	@GetMapping("deptList")
	public String deptList(Model model) {
		List<DeptVO> list = deptService.deptList();
		System.out.println(list);
		// 페이지에 전달
		model.addAttribute("depts", list);
		return "dept/list";
		// classpath: /templates/dept/list.html
		
	}
	// 단건조회
	
	// 등록 - 페이지
	
	// 등록 - 처리
	
	// 수정 - 페이지
	
	// 수정 - 처리 : JSON
	
	// 삭제 - 처리
}
>>>>>>> branch 'master' of https://github.com/kangwonjun/Spring.git
