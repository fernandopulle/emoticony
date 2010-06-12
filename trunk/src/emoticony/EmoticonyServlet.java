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
	/** Log */
	private static final Logger log = Logger.getLogger(EmoticonyServlet.class.getName());	
	/** Holds all the emoticons */
	Emoticons emoticons = new Emoticons();
		
	@Override
	public void onDocumentChanged(DocumentChangedEvent event) {
		if(Commons.DEBUG){
			log.info("Document changed event");
		}
		Blip blip = event.getBlip();
		if(Commons.DEBUG){
			log.info("Blip Content: " + blip.getContent());
		}
		try{
			//Do nothing if marked with ne (no emoticony)
			if(!(blip.getContent().startsWith("\n[ne]") | 
					blip.getContent().startsWith("\n[NE]"))){
				
				if(Commons.DEBUG){
					log.info("Blip isn't a non emoticony blip");
				}
				
				//Default action - Process text and insert the emoticons
				processEmoticon(blip);
			}
		}catch (NullPointerException e){
			log.warning("NullPointerException: " + e.getStackTrace().toString());
		}
		
	}
	
	/**
	 * Handles detecting which emoticons are required and inserts them
	 */
	private void processEmoticon(Blip blip){
		if(Commons.DEBUG){
			log.info("processEmoticon function");
		}
		String blipContent = blip.getContent();					//content of the blip
		List<EmoticonEntry> posn = new ArrayList<EmoticonEntry>();	//List of positions

		//Locate every Emoticon replacement
		for(Emoticon icon : emoticons.iconList){
			int i=0;
			while (blipContent.indexOf(icon.getTxt(), i) != -1){				
				i = blipContent.indexOf(icon.getTxt(), i);	//Update to the position
				posn.add(new EmoticonEntry(i, icon));		//Add entry to list
				i++;										//Increment to move on
			}
		}	

		//Organise the list of entries so deletes etc. don't override each other
		Collections.sort(posn);
		Collections.reverse(posn);

		//Insert the emoticons into the blip
		for (EmoticonEntry entry : posn){
			//Delete Text Characters
			blip.range(entry.getStartPos(), entry.getStartPos() +entry.getEmoticon().getTxtLen()).delete();
			
			Element img = new Image();
			img.setProperty("url", entry.getEmoticon().getUrl());
			if(Commons.DEBUG){
				log.info("insert image: " + entry.getEmoticon().getUrl());
			}
			//Insert Image
			blip.at(entry.getStartPos()).insert(img);
			
			
		}
	}

	//Profile Related
	@Override
	public String getRobotAvatarUrl() {
		return "http://emoticonbot.appspot.com/imgs/EmoticonyProfileImg.png";
	}

	@Override
	public String getRobotName() {
		return "Emoticony";
	}

	@Override
	public String getRobotProfilePageUrl() {
		return "http://emoticony.leestone.co.uk";
	}

}
