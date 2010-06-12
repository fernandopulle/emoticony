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

/**
 * Emoticon is an object which contains the details for each emoticon
 * @author Lee Stone
 * @email emoticony@leestone.co.uk
 * @website http://www.emoticony.leestone.co.uk
 * @date 11th June 2010
 *
 */
public class Emoticon {

	/** The text equivalent which the image replaces */
	private String txt;
	/** The URL for the image of the emoticon */
	private String url;

	/**
	 * Creates a new Emoticon
	 * @param txt
	 * @param url
	 */
	public Emoticon(String txt, String url) {
		this.txt = txt;
		this.url = url;
	}

	/**
	 * @return the txt
	 */
	public String getTxt() {
		return txt;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the length of the txt entry
	 */
	public int getTxtLen() {
		return txt.length();
	}

}