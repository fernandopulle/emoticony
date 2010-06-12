/*
 * Emoticony
 * @author Lee Stone
 * @date 22nd August 2009
 * Contact: emoticony@leestone.co.uk
 * Web: www.emoticony.leestone.co.uk
 * 
 * Emoticony is a google wave robot which replaces text input with
 * the specified emoticon image
 */
package emoticony;
import com.google.wave.api.*;
import com.google.wave.api.event.*;

import java.util.logging.Logger;
import emoticony.Emoticons; //List of Emoticons
import emoticony.Emoticon; //Emoticon Object
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("serial")
public class EmoticonyServlet extends AbstractRobot {
	//Log for testing purposes
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(EmoticonyServlet.class.getName());
	//This list contains all the emoticons defined
	Emoticons emoticons = new Emoticons();
	
	
	//Special Occasion Emoticons
	public static boolean HALLOWEEN = false;
	public static boolean CHRISTMAS = false;
	public static boolean EASTER = false;
		
	@Override
	public void onDocumentChanged(DocumentChangedEvent event) {
		log.info("Document changed");
	}




	@Override
	public String getRobotAvatarUrl() {
		return "http://emoticonbot.appspot.com/imgs/EmoticonyProfileImg.png";
	}

	@Override
	public String getRobotName() {
		log.info("calling new robot");
		return "Emoticony";
	}

	@Override
	public String getRobotProfilePageUrl() {
		return "http://emoticony.leestone.co.uk";
	}

}
