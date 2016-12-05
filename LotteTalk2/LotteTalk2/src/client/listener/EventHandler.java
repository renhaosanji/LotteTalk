package client.listener;

import entity.NotifyObject;

public interface EventHandler {
	public void handleEvent (NotifyObject notifyObject);
}
