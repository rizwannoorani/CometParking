package com.cometpark;

import com.cometpark.server.model.SpotsUpdate;
import com.cometpark.server.util.Utils;
import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.CharBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignGuestbookServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6262806185256788819L;

	private static final Logger log = Logger
			.getLogger(SignGuestbookServlet.class.getName());
	String channelKey = "test";
	String token = "";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		log.setLevel(Level.INFO);
		log.info(" GET");

		// create channel
		ChannelService channelService = ChannelServiceFactory
				.getChannelService();
		token = channelService.createChannel(channelKey);
		log.info("GET " + token);

		// set response
		FileReader reader = new FileReader("guestbook.jsp");
		CharBuffer buffer = CharBuffer.allocate(16384);
		reader.read(buffer);
		String index = new String(buffer.array());
		index = index.replaceAll("\\{\\{ token \\}\\}", token);
		resp.setContentType("text/html");
		resp.getWriter().write(index);

		// push origin data store to client

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		log.setLevel(Level.INFO);
		log.info(" Post");
		// String guestbookName = req.getParameter("guestbookName");
		// Key guestbookKey = KeyFactory.createKey("Guestbook", guestbookName);
//		String content = req.getHeader("content");
//		if (content == null || content.length() == 0) {
//			return;
//		}

		String jsonMessage = req.getParameter("message");
		log.info("POST input: " + jsonMessage);
		processJson(jsonMessage);
		log.setLevel(Level.INFO);
//		log.info(content + " Post");
		// Date date = new Date();
		// DatastoreService datastore = DatastoreServiceFactory
		// .getDatastoreService();
		// // Place greeting in same entity group as guestbook
		// Entity greeting = new Entity("Greeting", guestbookKey);
		// greeting.setProperty("user", user);
		// greeting.setProperty("date", date);
		// greeting.setProperty("content", content);
		// Query query = new Query("Greeting", guestbookKey).setAncestor(
		// guestbookKey).addSort("date", Query.SortDirection.DESCENDING);
		//
		// List<Entity> greetings = datastore.prepare(query).asList(
		// FetchOptions.Builder.withLimit(10));
		// datastore.put(greeting);
		// TODO
		/*
		 * so for here we just do query, and put them into a list and pass to
		 * client java script
		 */
		// This is what actually sends the message.
		resp.getWriter().println(token);
	}

	private void processJson(String jsonString) {
		JsonParser parser = new JsonParser();
		try {
			Object obj = parser.parse(jsonString);
			JsonObject jsonObject = (JsonObject) obj;
			int type = jsonObject.get("type").getAsInt();
			JsonElement controllerId = jsonObject.get("controllerId");
			switch (1) {
			case Utils.TYPE_SPOTS_UPDATE:
				JsonObject spotsJsonObject = jsonObject
						.getAsJsonObject("spots");
				updateRequest(spotsJsonObject);
				break;
			}
		} catch (JsonSyntaxException e) {
			log.info("processJson JsonSyntaxException");
		}
	}

	private void updateRequest(JsonObject spotsJsonObject) {
		updateClientView(spotsJsonObject.toString());
		Iterator<Entry<String, JsonElement>> iterator = spotsJsonObject
				.entrySet().iterator();
		
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    DateFormat dateFormat = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
		//HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		while (iterator.hasNext()) {
			Entry<String, JsonElement> entry = iterator.next();
			int spotId = Integer.parseInt(entry.getKey());
			int availability = entry.getValue().getAsInt();
			Date current = new Date();
			
			Entity statusEntity = new Entity("information",dateFormat.format(current));
			statusEntity.setProperty("date",dateFormat.format(current));
			statusEntity.setProperty("spotId",spotId);
			statusEntity.setProperty("availability", availability);
			
			 datastore.put(statusEntity);
	//		map.put(spotId, availability);
		}
		
	}
	
//	private void updateDb(HashMap<Integer, Integer> map) {
//		DatastoreService datastore = DatastoreServiceFactory
//				.getDatastoreService();
//		// Place greeting in same entity group as guestbook
//		Entity lot = new Entity("Lot", "A");
//		lot.setProperty("Id", user);
//		lot.setProperty("Availability", user);
//		Query query = new Query("Lot", "A").setAncestor("A");
//
//		List<Entity> greetings = datastore.prepare(query).asList(
//				FetchOptions.Builder.withLimit(10));
//		datastore.put(lot);
//	}

	private void updateClientView(String jsonObjectString) {
		ChannelService channelService = ChannelServiceFactory
				.getChannelService();
		log.info(" Post " + token);
		channelService.sendMessage(new ChannelMessage(token, jsonObjectString));

	}
}