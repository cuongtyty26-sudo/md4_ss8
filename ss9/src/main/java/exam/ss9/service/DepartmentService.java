package exam.ss9.service;

import exam.ss9.dto.DepartmentDTO;
import exam.ss9.entity.Department;
import exam.ss9.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(DepartmentDTO departmentDTO) {

        Department department = new Department();

        department.setName(departmentDTO.getName());
        department.setDescription(departmentDTO.getDescription());

        return departmentRepository.save(department);
    }
}