package com.nanosoft.springbootstarter.lesson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanosoft.springbootstarter.course.Course;

@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
	public List<Lesson> getAllLessons(String courseId){
		List<Lesson> lessons = new ArrayList<Lesson>();
		lessonRepository.findByCourseId(courseId).forEach(lessons::add);
		return lessons;
	}
	
	public Lesson getLesson(String id) {
		return lessonRepository.findOne(id);
	}
	
	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}
	
	
	public void updateLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}
	
	public void deleteLesson(String id) {
		lessonRepository.delete(id);

	}
}
