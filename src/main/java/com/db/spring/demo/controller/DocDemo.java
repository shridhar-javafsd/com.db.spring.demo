package com.db.spring.demo.controller;

/**
 * 
 * @author Vaman Deshmukh 
 * @since 2021 
 *
 */

/**
 * 
 * This class creates documents. 
 *
 */
public class DocDemo {

	/**
	 * non static fields 
	 */
	int docId;
	String name;

	/**
	 * creates document string values based on user input. 
	 * @param String docData
	 * @return String 
	 */
	
	public String createDoc(String docData) {
		return this.docId + docData;
	}

}
