/**
 * Object for each of the emoticon entries found in a blip
 */
package emoticony;

public class EmoticonEntry implements Comparable<EmoticonEntry>{

        private int startPos;   //Holds the starting position of the entry
        private Emoticon emoticon; //Which emoticon
        
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
