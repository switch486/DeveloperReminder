package com.apuchals.DR.notify;

import com.apuchals.DR.common.UseCase;
import com.apuchals.DR.infoGetter.CommitInformation;
import com.apuchals.DR.toRemove.NotImplementedException;

public class NotificationSender extends UseCase implements INotification {

	public void notifyAuthor(CommitInformation key, String review) {
		throw new NotImplementedException();
	}

}
