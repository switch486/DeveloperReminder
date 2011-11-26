package com.apuchals.DR;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.apuchals.DR.infoGetter.CommitInformation;
import com.apuchals.DR.infoGetter.SVNSpider;
import com.apuchals.DR.notify.NotificationSender;
import com.apuchals.DR.review.ReviewStarter;

public class MainClass {
	public static void main(String[] args) {
		// TODO 26.11.2011 apuchals > adapt the loggers!

		// start the SVNSpider
		// start the Review Starter in a loop with the NotificaitonSender
			// for each revision compute results, build an email and send
		
		Map<CommitInformation, List<File>> newestRevisions = new SVNSpider().getNewestRevisions();
		ReviewStarter reviewStarter = new ReviewStarter();
		NotificationSender notificationSender = new NotificationSender();
		
		for (Map.Entry<CommitInformation, List<File>> entry : newestRevisions.entrySet()) {
			String review = reviewStarter.computeReview(entry.getValue());
			notificationSender.notifyAuthor(entry.getKey(), review);
		}
		
		
	}
}
