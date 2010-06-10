/*Object which holds the details for each emoticon */
package emoticony;

public class Emoticon {
        
        private String txt;     //Holds the text which the image replaces
        private String url; //Path to the image placement

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