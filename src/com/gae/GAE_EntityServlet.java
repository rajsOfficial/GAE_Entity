package com.gae;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.*;


@SuppressWarnings("serial")
public class GAE_EntityServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		 PrintWriter out = resp.getWriter();
		 
		 String name= req.getParameter("s1");
		 String office= req.getParameter("s2");
		 long id=Long.parseLong(req.getParameter("s3"));
		 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		 Entity e = new Entity("Office table",id);
		 
		 e.setProperty("Name", name);
		 e.setProperty("Office", office);
		 ds.put(e);
		 out.print("VAlue of e entity key is"+e.getKey());
		 Entity e1= new Entity("ID value",e.getKey());
		 e1.setProperty("id no ",id);
		 ds.put(e1);
		 Key k= KeyFactory.createKey("Office Table", 38278937897489L);
		 try {
			ds.get(k);
		} catch (EntityNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		/* Transaction txn= ds.beginTransaction();
		 txn.commit();*/
		 out.println(e.getProperties());
		
		 out.print("<br><br><a href='update.jsp'> second page</a>" );	 
	}
}
