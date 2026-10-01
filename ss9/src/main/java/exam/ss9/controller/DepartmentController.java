package exam.ss9.controller;

import exam.ss9.dto.DepartmentDTO;
import exam.ss9.entity.Department;
import exam.ss9.service.DepartmentService;
import exam.ss9.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Department>> createDepartment(
            @Valid @RequestBody DepartmentDTO departmentDTO) {

        Department department = departmentService.createDepartment(departmentDTO);

        ApiResponse<Department> response = new ApiResponse<>(
                "SUCCESS",
                "Tạo phòng ban thành công",
                department
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}