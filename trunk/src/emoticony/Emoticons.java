/*
 * Holds all the emoticons available
 * 
 * This exists purely to remove the large number of lines
 * required to create the list of emoticons from the
 * main servlet.
 */
package emoticony;
import java.util.ArrayList;

public class Emoticons {
	
	//List which stores all the emoticons in
	//Within the list it contains the string match and image url
	ArrayList<Emoticon> iconList = new ArrayList<Emoticon>();
	
	public Emoticons() {
		//Every Emoticon is created and added to the list here
		//iconList.add(new Emoticon("",extendUrl("")));
		
		/*
		 * Special Occasion - Halloween
		 */
		if (Commons.HALLOWEEN == true){
			iconList.add(new Emoticon("(bat)",extendHalUrl("bat")));
			iconList.add(new Emoticon("(pumpkin)",extendHalUrl("pumpkin2")));
			iconList.add(new Emoticon("(witch)",extendHalUrl("witch")));
			iconList.add(new Emoticon("(flywitch)",extendHalUrl("witching")));
			iconList.add(new Emoticon("(witching)",extendHalUrl("witching")));
		}
		
		/*
		 * Special Occasion - Christmas
		 */
		//TODO Problems with emoticons containing :)
		if (Commons.CHRISTMAS == true){
			iconList.add(new Emoticon("(cc)",extendXmasUrl("candycane")));
			iconList.add(new Emoticon("(cc2)",extendXmasUrl("cc2")));
			iconList.add(new Emoticon("(candle)",extendXmasUrl("christmascandle")));
			iconList.add(new Emoticon("(gbhouse)",extendXmasUrl("gingerbreadhouse")));
			iconList.add(new Emoticon("(reindeer)",extendXmasUrl("reindeer")));
			iconList.add(new Emoticon("(santa)",extendXmasUrl("santa")));
			iconList.add(new Emoticon("(santaclaus)",extendXmasUrl("santaclaus")));
			//iconList.add(new Emoticon("x:)",extendXmasUrl("santasmile")));
			iconList.add(new Emoticon("(santasmile)",extendXmasUrl("santasmile")));
			iconList.add(new Emoticon("(snowman)",extendXmasUrl("snowman")));
			iconList.add(new Emoticon("(snowmansmile)",extendXmasUrl("snowmanhead")));
			//iconList.add(new Emoticon("s:)",extendXmasUrl("snowmanhead")));
			iconList.add(new Emoticon("(stocking)",extendXmasUrl("stocking")));
			iconList.add(new Emoticon("(tree)",extendXmasUrl("tree")));
		}
		
		/*
		 * Standard
		 */
		
		iconList.add(new Emoticon(":)",extendUrl("smile")));
		iconList.add(new Emoticon(":-)",extendUrl("smile")));
		iconList.add(new Emoticon("=)",extendUrl("smile")));
		iconList.add(new Emoticon(":D",extendUrl("smile-big")));
		iconList.add(new Emoticon(":-D",extendUrl("smile-big")));
		iconList.add(new Emoticon(":(",extendUrl("sad")));
		iconList.add(new Emoticon("=(",extendUrl("sad")));
		iconList.add(new Emoticon(":-(",extendUrl("sad")));
		iconList.add(new Emoticon(":'(",extendUrl("crying")));
		iconList.add(new Emoticon(":p",extendUrl("tongue")));
		iconList.add(new Emoticon(":P",extendUrl("tongue")));
		iconList.add(new Emoticon(":-p",extendUrl("tongue")));
		iconList.add(new Emoticon(":-P",extendUrl("tongue")));
		iconList.add(new Emoticon(":o",extendUrl("shock")));
		iconList.add(new Emoticon("8-0",extendUrl("shock")));
		iconList.add(new Emoticon("=8-0",extendUrl("shock")));
		iconList.add(new Emoticon(":@",extendUrl("angry")));
		iconList.add(new Emoticon(":s",extendUrl("confused")));
		iconList.add(new Emoticon(":S",extendUrl("confused")));
		iconList.add(new Emoticon(";)",extendUrl("wink")));
		iconList.add(new Emoticon(";-)",extendUrl("wink")));
		iconList.add(new Emoticon("+o(",extendUrl("sick")));
		iconList.add(new Emoticon(":$",extendUrl("embarrassed")));
		iconList.add(new Emoticon(":|",extendUrl("disapointed")));
		iconList.add(new Emoticon(":-#",extendUrl("shut-mouth")));
		iconList.add(new Emoticon("|-)",extendUrl("sleepy")));
		iconList.add(new Emoticon("8-)",extendUrl("eyeroll")));
		iconList.add(new Emoticon(":\\",extendUrl("thinking")));
		iconList.add(new Emoticon(":-\\",extendUrl("thinking")));
		iconList.add(new Emoticon("*-)",extendUrl("thinking")));
		iconList.add(new Emoticon(":--)",extendUrl("lying")));
		iconList.add(new Emoticon("(lying)",extendUrl("lying")));
		iconList.add(new Emoticon("8-|",extendUrl("glasses-nerdy")));
		iconList.add(new Emoticon("8o|",extendUrl("teeth")));
		
		iconList.add(new Emoticon("(A)",extendUrl("angel")));
		iconList.add(new Emoticon("(bye)",extendUrl("bye")));
		iconList.add(new Emoticon("(clap)",extendUrl("clap")));
		iconList.add(new Emoticon("({)",extendUrl("hug-left")));
		iconList.add(new Emoticon("(})",extendUrl("hug-right")));
		iconList.add(new Emoticon("<:o)",extendUrl("party")));
		iconList.add(new Emoticon("(h5)",extendUrl("highfive")));
		iconList.add(new Emoticon("(hi5)",extendUrl("highfive")));
		iconList.add(new Emoticon(":-*",extendUrl("kiss")));
		iconList.add(new Emoticon(":*",extendUrl("kiss")));
		
		iconList.add(new Emoticon("(L)",extendUrl("love")));
		iconList.add(new Emoticon("<3",extendUrl("love")));
		iconList.add(new Emoticon("(U)",extendUrl("love-over")));
		iconList.add(new Emoticon("(tv)",extendUrl("tv")));
		iconList.add(new Emoticon("(TV)",extendUrl("tv")));
		iconList.add(new Emoticon("(mail)",extendUrl("mail")));
		iconList.add(new Emoticon("(brb)",extendUrl("brb")));
		iconList.add(new Emoticon("(P)",extendUrl("pizza")));
		iconList.add(new Emoticon("(pi)",extendUrl("pizza")));
		iconList.add(new Emoticon("(st)",extendUrl("rain")));
		iconList.add(new Emoticon("(rain)",extendUrl("rain")));
		iconList.add(new Emoticon("(C)",extendUrl("coffee")));
		iconList.add(new Emoticon("(comp)",extendUrl("computer")));
		iconList.add(new Emoticon("(D)",extendUrl("drink")));
		iconList.add(new Emoticon("(B)",extendUrl("beer")));
		iconList.add(new Emoticon("(@)",extendUrl("cat")));
		iconList.add(new Emoticon("(&)",extendUrl("dog")));
		iconList.add(new Emoticon("(#)",extendUrl("sun")));
		iconList.add(new Emoticon("(*)",extendUrl("star")));
		iconList.add(new Emoticon("(Y)",extendUrl("good")));
		iconList.add(new Emoticon("(N)",extendUrl("bad")));
		iconList.add(new Emoticon("(O)",extendUrl("clock")));
		iconList.add(new Emoticon("(G)",extendUrl("present")));
		iconList.add(new Emoticon("(mp)",extendUrl("mobile")));
		iconList.add(new Emoticon("(8)",extendUrl("musical-note")));
		iconList.add(new Emoticon("(Z)",extendUrl("boy")));
		iconList.add(new Emoticon("(X)",extendUrl("girl")));
		iconList.add(new Emoticon("(^)",extendUrl("cake")));
		iconList.add(new Emoticon("(au)",extendUrl("car")));
		iconList.add(new Emoticon("(car)",extendUrl("car")));
		
	}
	
	/*
	 * This function adds the prefix and suffix to the filename
	 * In future this will be adapted to deal with themed emoticons
	 */
	public String extendUrl(String fname){
		return "http://emoticonbot.appspot.com/emoticons/".concat(fname).concat(".png");
	}
	public String extendHalUrl(String fname){
		return "http://emoticonbot.appspot.com/emoticons/halloween/".concat(fname).concat(".gif");
	}
	public String extendXmasUrl(String fname){
		return "http://emoticonbot.appspot.com/emoticons/christmas/".concat(fname).concat(".gif");
	}
}
