package com.nanosoft.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	

	public List<Course> getAllCourses(String topicId){
		//return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
		
	}
	
	public Course getCourse(String id) {
		//return topics.stream().filter(p->p.getId().equals(id)).findFirst().get();
		return courseRepository.findOne(id);
	}
	
	public List<Course> getCourseByName(String name) {
		//return topics.stream().filter(p->p.getId().equals(id)).findFirst().get();
		return courseRepository.findByName(name);
	}
	
	public void addCourse(Course course) {
		//topics.add(topic);
		courseRepository.save(course);
	}
	
	
	public void updateCourse(Course course) {
//		Topic topic1 = topics.stream().filter(p->p.getId().equals(id)).findFirst().get();
//		topic1.setDescription(topic.getDescription());
//		topic1.setName(topic.getName());
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
//		for(int i=topics.size()-1;i>=0;--i) {
//			Topic topic1 = topics.get(i);
//			if(topic1.getId().equals(id)) {
//				topics.remove(i);
//				break;
//			}
//		}
		courseRepository.delete(id);
		//topics.removeIf(t->t.getId().equals(id));

	}
}
