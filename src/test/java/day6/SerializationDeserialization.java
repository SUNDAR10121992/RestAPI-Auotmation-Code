package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import day2.POJOpostRequest;

public class SerializationDeserialization {
//POJA --=Serialization=---json---=deserilization-----POJO
	@Test
	void convertPOJO2Json() throws JsonProcessingException {

		Student stupojo = new Student();

		stupojo.setName("Scott");
		stupojo.setLocation("France");
		stupojo.setPhone("123456");
		String courseArr[] = { "C", "C++" };
		stupojo.setCourse(courseArr);

		// convert java object to----- Json object

		ObjectMapper objectMapper = new ObjectMapper();

		String jsondata = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);

		System.out.println(jsondata);
	}

	@Test
	void json2POJO() throws JsonMappingException, JsonProcessingException {
		// Json-------to------Pojo

		String jsondata = "{\r\n" + "  \"name\" : \"Scott\",\r\n" + "  \"location\" : \"France\",\r\n"
				+ "  \"phone\" : \"123456\",\r\n" + "  \"course\" : [ \"C\", \"C++\" ]\r\n" + "}";

		// cnverting json data -----to -----java object

		ObjectMapper objectMapper = new ObjectMapper();

		Student student = objectMapper.readValue(jsondata, Student.class);

		System.out.println("Name="+student.getName());
		System.out.println("Location="+student.getLocation());
		System.out.println("pnone="+student.getPhone());
		System.out.println("Course1="+student.getCourse()[0]);
		System.out.println("Course2="+student.getCourse()[1]);

	}

}
