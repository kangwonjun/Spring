package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class DeptRestController {
	private final DeptService deptService;


	// 전체조회 :
	// REST => 사실상 Model 객체 사용하지 않음
	@GetMapping("depts")
	public List<DeptVO> deptList() {
		return deptService.deptList();
	}

	// 단건조회 :
	@GetMapping("depts/{departmentId}")
	public DeptVO empInfo(@PathVariable Integer departmentId) {
		DeptVO DeptVO = new DeptVO();
		DeptVO.setDepartmentId(departmentId);

		return deptService.deptInfo(DeptVO);
	}

	// 등록 : 
	@PostMapping("depts")
	public int deptInsert(@RequestBody DeptVO DeptVO) {
		return deptService.deptInsert(DeptVO);
	}

	// 수정 :
	@PutMapping("depts/{departmentId}")
	public Map<String, Object> empUpdate(@PathVariable Integer departmentId, @RequestBody DeptVO DeptVO) {
		DeptVO.setDepartmentId(departmentId);

		return deptService.deptUpdate(DeptVO);
	}

	// 삭제 : 
	@DeleteMapping("depts/{departmentId}")
	public Map<String, Object> empDelete(@PathVariable Integer departmentId) {
		return deptService.deptDelete(departmentId);
	}
}
