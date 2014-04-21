package com.cometpark;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.cometpark.server.model.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

	  String userNameLoginVal = request.getParameter("userNameLogin");
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key loginKey = KeyFactory.createKey("UserObject",userNameLoginVal );
		try {
		Entity userName = datastore.get(loginKey);
		String retrievedUser = userName.getProperty("userName").toString();
		//request.setAttribute("userretrieve",retrievedUser);
		if(retrievedUser==null){
				String errorMessage="Invalid Login";
				response.sendRedirect("/Login.jsp?errMessage=" + errorMessage );
		 }
		else
		{
			response.sendRedirect("/guestbook.jsp");
			
		}
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		} //catch (ServletException e) {
			//e.printStackTrace();
		//}
 
		
	  
    
  }
}