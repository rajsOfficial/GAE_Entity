package com.gae;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.*;

@SuppressWarnings("serial")
public class second extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		 PrintWriter out = resp.getWriter();
		 long id=Long.parseLong(req.getParameter("u1"));
	 Key ke = KeyFactory.createKey("Office table", id);
	
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 
	 	Filter f= new FilterPredicate(Entity.KEY_RESERVED_PROPERTY, FilterOperator.EQUAL,ke);
		 Query query = new Query("Office table");
		    PreparedQuery pq = ds.prepare(query);


		    for (Entity entity :pq.asIterable())

		    {
		        resp.getWriter().println(entity.getProperty("Name") );
		        resp.getWriter().println(entity.getProperty("Office") );
		    }
	 
		/*Entity e1;
		try {
			e1 = ds.get(ke);
			resp.getWriter().print("Name is <br>:"+e1.getProperty("Name"));
			resp.getWriter().print("Office  :"+e1.getProperty("Office"));
			
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}}
