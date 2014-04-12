package com.cometpark;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.cometpark.server.model.*;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

	  Entity userEntity = new Entity("UserObject", req.getParameter("Username"));
	  userEntity.setUnindexedProperty("userName", req.getParameter("Username") );
	  userEntity.setUnindexedProperty("password", req.getParameter("password") );
	  userEntity.setUnindexedProperty("email", req.getParameter("email") );
	  userEntity.setUnindexedProperty("permitType", req.getParameter("permitType") );
	  
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    datastore.put(userEntity);
    
    resp.sendRedirect("/success.jsp?successMsg=" + "The use has been added successfuly" );
  }
}