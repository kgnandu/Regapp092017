package regapp.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import regapp.domain.Student;
import regapp.service.StudentService;

@Path("/student")
public class StudentController {
	
	@GET
	@Path("/{id}")
	public Student getStudent(@PathParam("id") int id)  {
		StudentService ss = new StudentService();
		Student student = ss.getStudent(id);
		
		
		return student;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Student> getAllStudents() {
		StudentService ss = new StudentService();
		
		return ss.getAllStudents();
	}
	
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addStudent(Student student) {
		
		StudentService ss = new StudentService();
		Student newStudent = ss.addStudent(student);
		
		return Response.status(Status.CREATED).entity(newStudent).build();
	}
}
