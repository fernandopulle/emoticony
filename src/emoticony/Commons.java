/**
 * 
 */
package emoticony;

/**
 * @author Lee Stone
 *
 */
public class Commons {

	/** Whether logging should be enabled */
	public static final boolean DEBUG = true;
	
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
