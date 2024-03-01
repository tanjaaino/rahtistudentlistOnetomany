package fi.haagahelia.course.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

	// StudentRepository inherits services like findAll(), findByid(), save(), deleteById()
	
    List<Student> findByLastName(String lastName);
    
}