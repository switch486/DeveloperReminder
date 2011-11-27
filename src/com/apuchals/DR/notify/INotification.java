package com.apuchals.DR.notify;

import com.apuchals.DR.infoGetter.CommitInformation;

public interface INotification {

	public void notifyAuthor(CommitInformation key, String review);
	
}
