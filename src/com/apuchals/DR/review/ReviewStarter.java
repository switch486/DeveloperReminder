package com.apuchals.DR.review;

import java.util.Iterator;

import com.apuchals.DR.common.UseCase;
import com.apuchals.DR.infoGetter.CheckedFile;
import com.apuchals.DR.infoGetter.CheckedFileList;

public class ReviewStarter extends UseCase implements IReview {

	public String computeReview(CheckedFileList value) {
//		Iterator<CheckedFile> it = value.iterator();
//		while (it.hasNext()) {
//			System.out.println(it.next());
//			
//		}
//		Iterator<CheckedFile> it2 = value.iterator(new String [] {"java"});
//		while (it2.hasNext()) {
//			System.out.println(it2.next());
//			
//		}
		Iterator<CheckedFile> it3 = value.iterator(new String [] {"jfd", "properties", "xml"});
		while (it3.hasNext()) {
			System.out.println(it3.next());
			
		}
		// filter NonJava Files and iterate over the commands to do the review.
		return null;
	}

}
