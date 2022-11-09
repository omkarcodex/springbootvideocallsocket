package com.websocket;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketTextHandler extends TextWebSocketHandler {
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {
		String payload = message.getPayload();
		JSONObject jsonObject = new JSONObject(payload);
		System.out.println("Json:"+jsonObject);
		String json=jsonObject.toString();
		System.out.println("Json String:"+json);
		session.sendMessage(new TextMessage(json));
	}



}