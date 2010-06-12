/*
 *  Copyright 2010 Lee Stone
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *    
 */
/**
 * 
 */
package emoticony;

import java.util.logging.Logger;

/**
 * CreateFilter has to be run as a normal java application locally to generate the filter string to be include in the servlet.
 * 
 * @author Lee Stone
 * @email emoticony@leestone.co.uk
 * @website http://www.emoticony.leestone.co.uk
 * @date 11th June 2010
 *
 */
public class CreateFilter {
	/** Used for logging */
	private static final Logger log = Logger.getLogger(CreateFilter.class.getName());

	/** Holds all the emoticons */
	public static Emoticons emoticons = new Emoticons();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(generateFilter());

	}
	
	/**
	 * Creates a regular expression from the list of emoticons to be used as a filter on onDocumentChanged
	 * @return String - the filter for onDocumentChanged
	 */
	private static String generateFilter(){
		if (emoticons !=null){
			if(Commons.DEBUG){
				log.info("Generating regular expression");
			}
			
			//This is the list of special characters which need to be escaped
			String[] specialCharacters = {"(","{",")","|","*","}","@","#","$","£","=","+"};
			
			String filter="";
			
			//replace the special characters and add the emoticon to the filter
			for(Emoticon emoticon : emoticons.iconList){
				String emoticonText = emoticon.getTxt();
				emoticonText = emoticonText.replace("\\", "\\\\\\\\");
				for (String specialChar : specialCharacters){
					emoticonText = emoticonText.replace(specialChar, "\\\\" + specialChar);
				}
				filter = filter + emoticonText +"|";
			}
			
			//We've added one too many |, so remove the last one
			filter = filter.substring(0, filter.length()-1);
			
			//Create Valid XML
			filter = filter.replace(">", "&gt;").replace("<", "&lt;").replace("&", "&amp;");
			
			if(Commons.DEBUG){
				log.info("Generated filter: " + filter);
			}
			return filter;
			
		}else{
			log.severe("the list of emoticons is null");
			return "";
		}
	}

}
