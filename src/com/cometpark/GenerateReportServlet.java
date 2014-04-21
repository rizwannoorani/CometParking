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
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GenerateReportServlet extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

	  //String userNameLoginVal = request.getParameter("userNameLogin");
		List<InformationObj> informationList = new ArrayList ();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter spotIdFilter1 =
				  new FilterPredicate("spotId",
				                      FilterOperator.EQUAL,
				                      1);
		Query q = new Query("information").setFilter(spotIdFilter1);
		PreparedQuery pq = datastore.prepare(q);
		for (Entity result : pq.asIterable()) {
			  String spotId = (String) result.getProperty("spotId");
			  String dateValue = (String) result.getProperty("date");
			  String availibilty = (String) result.getProperty("availability");
			  InformationObj newInfo = new InformationObj();
			  newInfo.setAvailability(availibilty);
			  newInfo.setSpotId(spotId);
			  newInfo.setDateValue(dateValue);
			  informationList.add(newInfo);
			  //System.out.println(firstName + " " + lastName + ", " + height + " inches tall");
			
			}
		
			response.sendRedirect("/admin1.jsp/?infoList="+informationList);
		
	  
    
  }
}