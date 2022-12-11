package whiteBoxTesting.Application;

public class StringManipulation
{

    // bu classi yazan developer sadece 1 method yazmis
    //parametre olarak gonderilen String ifadeyi tersten yazarim
    public String reverseString(String input)//abcd
    {

        //bu methodun algorithmasinda 3 farkli olasilik dusunulmus ve 3 farkli return olasiligi var
        if(input==null)
            return null;
        else if(input=="")
            return "";

        //abcd
        char ch;
        String reversedValue = "";

        for (int i=0; i<input.length(); i++)
        {
            ch= input.charAt(i);
            reversedValue=ch+reversedValue;
        }
        return reversedValue;// dcba

    }
}
