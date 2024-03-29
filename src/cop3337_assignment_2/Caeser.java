/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cop3337_assignment_2;

/**
 *
 * @author AbsoluteCrow
 */
public class Caeser extends Cipher
{

    interface Constants
    {
        public static int ENCODE_SHIFT = 3;
        public static int WRAP_AROUND = 26;
        public static int DECODE_SHIFT = 23;
    }
    
    public Caeser(String s)
    {
        super(s);
    }
    
    public String encode(String word)
    {
        return code(word,Constants.ENCODE_SHIFT );
    }
    
    public String decode(String word)
    {
        return code(word,Constants.DECODE_SHIFT);
    }
    
    String code(String word, int SHIFT)
    {
        StringBuffer result = new StringBuffer();
        
        for (int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            ch = determineCharacter(ch, SHIFT);
            result.append(ch);
        }
        return result.toString();
    }
    
    public char determineCharacter(char ch, final int shift)
    {
        if(Character.isUpperCase(ch))
            ch = (char)('A' + (ch - 'A' + shift) % Constants.WRAP_AROUND);
        else if(Character.isLowerCase(ch))
            ch = (char)('a' + (ch - 'a' + shift) % Constants.WRAP_AROUND);
        return ch;
    }
}
