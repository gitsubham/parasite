package org.nasscom.parasite.base;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionManager implements HttpSessionListener{

	
	public void sessionCreated(HttpSessionEvent App) {
		AppUser user = new AppUser();
		App.getSession().setAttribute("user", user);
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	}

}
