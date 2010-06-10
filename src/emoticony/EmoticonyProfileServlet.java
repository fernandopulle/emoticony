/* Profile details for Emoticony */
package emoticony;

import com.google.wave.api.ProfileServlet;

@SuppressWarnings("serial")

public class EmoticonyProfileServlet extends ProfileServlet{

	//Avatar
	@Override
	public String getRobotAvatarUrl() {
		return "http://emoticonbot.appspot.com/imgs/EmoticonyProfileImg.png";
	}

	//Name
	@Override
	public String getRobotName() {
		return "Emoticony";
	}

	//URL
	@Override
	public String getRobotProfilePageUrl() {
		return "http://emoticony.leestone.co.uk";
	}


}