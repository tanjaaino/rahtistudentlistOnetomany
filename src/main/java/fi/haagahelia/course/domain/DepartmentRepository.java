package fi.haagahelia.course.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

	// DepartmentRepository inherits services like findAll(), findByid(), save(), deleteById()
	
    List<Department> findByName(String name);
    
}