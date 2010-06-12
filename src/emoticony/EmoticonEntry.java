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
 * EmoticonEntry holds the details for each occurrence of an Emoticon found in a blip
 * 
 * @author Lee Stone
 * @email emoticony@leestone.co.uk
 * @website http://www.emoticony.leestone.co.uk
 * @date 11th June 2010
 *
 */
public class EmoticonEntry implements Comparable<EmoticonEntry>{

	/** The character starting position of the occurrence */
	private int startPos;
	/** The emoticon which has been found */
	private Emoticon emoticon;

	/**
	 * Creates a new EmoticonEntry
	 * @param startPos
	 * @param emoticon
	 */
	public EmoticonEntry(int startPos, Emoticon emoticon){
		this.startPos = startPos;
		this.emoticon = emoticon;
	}

	/* Getters*/

	/**
	 * @return the startPos
	 */
	public int getStartPos() {
		return startPos;
	}

	/**
	 * @return the emoticon
	 */
	public Emoticon getEmoticon() {
		return emoticon;
	}

	@Override
	public int compareTo(EmoticonEntry ee) {
		return this.startPos - ee.startPos;
	}

}
