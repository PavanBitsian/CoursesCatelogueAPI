package com.nanosoft.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","Spring Framework","Spring Framework Description"),
			new Topic("java","Core Java","core Java Description"),
			new Topic("javascript","Javascript","Javascript Description")
			));

	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topicList = new ArrayList<>();
		topicRepository.findAll().forEach(topicList::add);
		return topicList;
		
	}
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(p->p.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}
	
	
	public void updateTopic(String id,Topic topic) {
//		Topic topic1 = topics.stream().filter(p->p.getId().equals(id)).findFirst().get();
//		topic1.setDescription(topic.getDescription());
//		topic1.setName(topic.getName());
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
//		for(int i=topics.size()-1;i>=0;--i) {
//			Topic topic1 = topics.get(i);
//			if(topic1.getId().equals(id)) {
//				topics.remove(i);
//				break;
//			}
//		}
		topicRepository.delete(id);
		//topics.removeIf(t->t.getId().equals(id));

	}
}
