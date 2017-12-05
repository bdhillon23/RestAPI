package org.dhillon.balwinder.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.dhillon.balwinder.messenger.database.DatabaseClass;
import org.dhillon.balwinder.messenger.model.Message;

public class MessageService {

	private Map<Long,Message> messages=DatabaseClass.getMessage();
	
	public MessageService(){
		
		messages.put(1L, new Message(1,"This is the first Message","Balwinder"));
		messages.put(2L, new Message(2,"This is the Second Message","Dhillon"));
		messages.put(3L, new Message(3,"This is the Third Message","Kaushik"));
		
	}
	
	public List<Message> getAllMessages(){
	return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessageForYear(int year){
		List<Message> messagesForYear=new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		for(Message message: messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)== year){
				messagesForYear.add(message);
			}
		}return messagesForYear;
	}
	
	public List<Message> getAllMessagePaginated(int start,int size){
		ArrayList<Message> list=new ArrayList<Message>(messages.values());
		if(start+size>list.size()) return new ArrayList<Message>();
		return list.subList(start, start+size);
	}
	
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<= 0){
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	public Message removeMessage(Long id){
		return messages.remove(id);
	}
	
	
}
