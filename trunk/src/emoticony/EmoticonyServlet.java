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
/**
 * EmoticonyServlet is the main servlet for the Google Wave robot Emoticony.
 * Emoticony replaces the text equivalent of emoticons with the relevant image.
 * 
 * @author Lee Stone
 * @email emoticony@leestone.co.uk
 * @website http://www.emoticony.leestone.co.uk
 * @date 11th June 2010
 *
 */
public class EmoticonyServlet extends AbstractRobot {
	/** Used for logging */
	private static final Logger log = Logger.getLogger(EmoticonyServlet.class.getName());	
	/** Holds all the emoticons */
	Emoticons emoticons = new Emoticons();
	/** Regular expression to be used as a filter for onDocumentChanged */
	private static final String FILTER = ":\\)|:-\\)|\\=\\)|:D|:-D|:\\(|\\=\\(|:-\\(|:'\\(|:p|:P|:-p|:-P|:o|8-0|\\=8-0|:\\@|:s|:S|;\\)|;-\\)|\\+o\\(|:\\$|:\\||:-\\#|\\|-\\)|8-\\)|:\\\\|:-\\\\|\\*-\\)|:--\\)|\\(lying\\)|8-\\||8o\\||\\(A\\)|\\(bye\\)|\\(clap\\)|\\(\\{\\)|\\(\\}\\)|&amp;lt;:o\\)|\\(h5\\)|\\(hi5\\)|:-\\*|:\\*|\\(L\\)|&amp;lt;3|\\(U\\)|\\(tv\\)|\\(TV\\)|\\(mail\\)|\\(brb\\)|\\(P\\)|\\(pi\\)|\\(st\\)|\\(rain\\)|\\(C\\)|\\(comp\\)|\\(D\\)|\\(B\\)|\\(\\@\\)|\\(&amp;\\)|\\(\\#\\)|\\(\\*\\)|\\(Y\\)|\\(N\\)|\\(O\\)|\\(G\\)|\\(mp\\)|\\(8\\)|\\(Z\\)|\\(X\\)|\\(^\\)|\\(au\\)|\\(car\\)";

	@Capability(filter = FILTER, contexts = {Context.SELF})
	@Override
	public void onDocumentChanged(DocumentChangedEvent event) {
		if(Commons.DEBUG){
			log.info("Document changed event");
		}
		try{
			Blip blip = event.getBlip();
			if(Commons.DEBUG){
				log.info("Blip Content: " + blip.getContent());
			}
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
		String blipContent = blip.getContent();						//content of the blip
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
			
			
			Element img = new Image();
			img.setProperty("url", entry.getEmoticon().getUrl());
			if(Commons.DEBUG){
				log.info("insert image: " + entry.getEmoticon().getUrl());
			}
			//Insert Image
			blip.at(entry.getStartPos()).insert(img);
			
			//Delete Text Characters
			blip.range(entry.getStartPos() +1, entry.getStartPos() +1 +entry.getEmoticon().getTxtLen()).delete();
			
			
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
	
	/**
	 * 
	 * @return
	 */
	public static final Emoticons getStaticEmoticons(){
		return new Emoticons();
	}

}
