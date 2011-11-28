package com.apuchals.DR;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.apuchals.DR.infoGetter.CommitInformation;
import com.apuchals.DR.infoGetter.IVersioningSpider;
import com.apuchals.DR.notify.INotification;
import com.apuchals.DR.review.IReview;

public class DeveloperReminderStarter {
	
    private IVersioningSpider spider;

	private IReview reviewer;
	
	private INotification notifier;

	public void setSpider(IVersioningSpider spider) {
		this.spider = spider;
	}
	
	public void setReviewer (IReview reviewer) {
		this.reviewer = reviewer;
	}
	
	public void setNotifier(INotification notifier) {
		this.notifier = notifier;
	}
	
	public void start() {
		// TODO 26.11.2011 apuchals > adapt the loggers!
		// TODO 28.11.2011 apuchals > add parsers to the rest

		// start the SVNSpider
		// start the Review Starter in a loop with the NotificaitonSender
			// for each revision compute results, build an email and send
		
		Map<CommitInformation, List<File>> newestRevisions = spider.getNewestRevisions();
		
		for (Map.Entry<CommitInformation, List<File>> entry : newestRevisions.entrySet()) {
			String review = reviewer.computeReview(entry.getValue());
			notifier.notifyAuthor(entry.getKey(), review);
		}
		spider.dumy();
	}
	
}
