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
import com.google.wave.api.impl.BlipData;

import java.util.logging.Logger;
import emoticony.Emoticons; //List of Emoticons
import emoticony.Emoticon; //Emoticon Object
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("serial")
public class EmoticonyServlet extends AbstractRobotServlet {
	//Log for testing purposes
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(EmoticonyServlet.class.getName());
	//This list contains all the emoticons defined
	Emoticons emoticons = new Emoticons();
	
	
	//Special Occasion Emoticons
	public static boolean HALLOWEEN = false;
	public static boolean CHRISTMAS = true;
	public static boolean EASTER = false;

	@Override
	public void processEvents(RobotMessageBundle bundle) {

		for (Event e: bundle.getEvents()) {
			//TODO later version will go back and put emoticons in all previously submitted blips.
			if(e.getType() ==EventType.WAVELET_SELF_ADDED){
				//Nothing for now 
			}

			//Actions take place when blip is submitted
			if (e.getType() == EventType.BLIP_SUBMITTED) {						
				Blip blip = e.getBlip();
				
				//Only process standard blips (i.e. not title blip)
				if (blip.getBlipId().equals(blip.getWavelet().getRootBlipId()) == false){
					
					//log.info("Blip contents: " + blip.getDocument().getText());
					
					//Check if the blip starts with [ne] - the instruction to ignore blip
					if(!(blip.getDocument().getText().startsWith("[ne]") | 
							blip.getDocument().getText().startsWith("[NE]"))){
						
						//log.info("process blip");
						
						//Default action - Process text and insert the emoticons
						processEmoticon(blip);
					}				
				}		
			}
		}				
	}

	/*
	 * General running of the program (i.e puts in the emoticons)
	 */
	private void processEmoticon(Blip blip){
		
		TextView doc = blip.getDocument();
		String blipContent = doc.getText();						//content of the blip
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
			doc.delete(new Range(entry.getStartPos(), 
					(entry.getStartPos() +entry.getEmoticon().getTxtLen())));
															//Delete Text Characters
			Element img = new Image();
			img.setProperty("url", entry.getEmoticon().getUrl());
			doc.insertElement(entry.getStartPos(), img);	//Add Image
			
			
		}
	}
}
