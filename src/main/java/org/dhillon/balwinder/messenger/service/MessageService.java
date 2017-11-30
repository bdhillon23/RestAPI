package org.dhillon.balwinder.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.dhillon.balwinder.messenger.model.Message;

public class MessageService {

	
	public List<Message> getAllMessages(){
		Message m1=new Message(1,"This is the first Message","Balwinder");
		Message m2=new Message(2,"This is the Second Message","Balwinder");
		
		List <Message> list=new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}
}
