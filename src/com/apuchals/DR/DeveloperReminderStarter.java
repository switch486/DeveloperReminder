package com.apuchals.DR;

import java.util.Map;

import com.apuchals.DR.infoGetter.CheckedFileList;
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

		// start the SVNSpider
		// start the Review Starter in a loop with the NotificaitonSender
			// for each revision compute results, build an email and send
		
		Map<CommitInformation, CheckedFileList> newestRevisions = spider.getNewestRevisions();
		
		for (Map.Entry<CommitInformation, CheckedFileList> entry : newestRevisions.entrySet()) {
			String review = reviewer.computeReview(entry.getValue());
			// TODO 01.12.2011 apuchals > commented code here
//			notifier.notifyAuthor(entry.getKey(), review);
		}
	}
	
}
