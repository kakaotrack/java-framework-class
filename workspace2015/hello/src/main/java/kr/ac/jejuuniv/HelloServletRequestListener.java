package kr.ac.jejuuniv;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class HelloServletRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("******   request destroy ***********");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("******   request init ***********");
	}

}
