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
 * Commons holds any variables which are required across Emoticony
 * @author Lee Stone
 * @email emoticony@leestone.co.uk
 * @website http://www.emoticony.leestone.co.uk
 * @date 11th June 2010
 *
 */
public class Commons {

	/** Whether logging should be enabled */
	public static final boolean DEBUG = false;
	
	//Special Occasion Emoticons
	/** Whether Halloween emoticons should be available */
	public static boolean HALLOWEEN = false;
	/** Whether Christmas emoticons should be available */
	public static boolean CHRISTMAS = false;
	/** Whether Easter emoticons should be available */
	public static boolean EASTER = false;
	
	/**
	 * @return the hALLOWEEN
	 */
	public static boolean isHALLOWEEN() {
		return HALLOWEEN;
	}
	/**
	 * @param hALLOWEEN the hALLOWEEN to set
	 */
	public static void setHALLOWEEN(boolean hALLOWEEN) {
		HALLOWEEN = hALLOWEEN;
	}
	/**
	 * @return the cHRISTMAS
	 */
	public static boolean isCHRISTMAS() {
		return CHRISTMAS;
	}
	/**
	 * @param cHRISTMAS the cHRISTMAS to set
	 */
	public static void setCHRISTMAS(boolean cHRISTMAS) {
		CHRISTMAS = cHRISTMAS;
	}
	/**
	 * @return the eASTER
	 */
	public static boolean isEASTER() {
		return EASTER;
	}
	/**
	 * @param eASTER the eASTER to set
	 */
	public static void setEASTER(boolean eASTER) {
		EASTER = eASTER;
	}
	/**
	 * @return the debug
	 */
	public static boolean isDebug() {
		return DEBUG;
	}
}
