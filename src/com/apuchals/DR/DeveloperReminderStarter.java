package com.apuchals.DR;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.apuchals.DR.infoGetter.CommitInformation;
import com.apuchals.DR.infoGetter.IVersioningSpider;
import com.apuchals.DR.notify.INotification;
import com.apuchals.DR.review.IReview;

public class DeveloperReminderStarter {
	
	@Autowired
    private IVersioningSpider spider;
	
	@Autowired
	private IReview reviewer;
	
	@Autowired
	private INotification notifier;
	
	public void start() {
		// TODO 26.11.2011 apuchals > adapt the loggers!

		// start the SVNSpider
		// start the Review Starter in a loop with the NotificaitonSender
			// for each revision compute results, build an email and send
		
		Map<CommitInformation, List<File>> newestRevisions = spider.getNewestRevisions();
		
		for (Map.Entry<CommitInformation, List<File>> entry : newestRevisions.entrySet()) {
			String review = reviewer.computeReview(entry.getValue());
			notifier.notifyAuthor(entry.getKey(), review);
		}
	}
	
}
