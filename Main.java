//Main.java
//Decodes a text of ASCII values, and then manipulates a name given by the user
//TeJean Florestal
//11/30/23


/*Your program should first decode this block of text and display it.
Then, prompt the user for a name. Take that name and output the following:
The name in reverse, the Reverse order in ALL CAPITALS,
the original string using CaMeL cAsE, and finally the original
string in ASCII. DO NOT USE ANY STRING MANIPULATION METHODS*/

import java.util.Scanner;
class Main
{
  public static void main(String[] args) 
  {
    String ASCIIText = "89 111 117 114 32 112 114 111 103 114 97 109 32 115 104 111 117 108 100 32 102 105 114 115 116 32 100 101 99 111 100 101 32 116 104 105 115 32 98 108 111 99 107 32 111 102 32 116 101 120 116 32 97 110 100 32 100 105 115 112 108 97 121 32 105 116 46 32 84 104 101 110 44 32 112 114 111 109 112 116 32 116 104 101 32 117 115 101 114 32 102 111 114 32 97 32 110 97 109 101 46 32 84 97 107 101 32 116 104 97 116 32 110 97 109 101 32 97 110 100 32 111 117 116 112 117 116 32 116 104 101 32 102 111 108 108 111 119 105 110 103 58 32 84 104 101 32 110 97 109 101 32 105 110 32 114 101 118 101 114 115 101 44 32 116 104 101 32 82 101 118 101 114 115 101 32 111 114 100 101 114 32 105 110 32 65 76 76 32 67 65 80 73 84 65 76 83 44 32 116 104 101 32 111 114 105 103 105 110 97 108 32 115 116 114 105 110 103 32 117 115 105 110 103 32 67 97 77 101 76 32 99 65 115 69 44 32 97 110 100 32 102 105 110 97 108 108 121 32 116 104 101 32 111 114 105 103 105 110 97 108 32 115 116 114 105 110 103 32 105 110 32 65 83 67 73 73 46 32 68 79 32 78 79 84 32 85 83 69 32 65 78 89 32 83 84 82 73 78 71 32 77 65 78 73 80 85 76 65 84 73 79 78 32 77 69 84 72 79 68 83 46 13 10";                                             //ASCII text that must be decoded
    String ASCIIList = " !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";  //Every typable ASCII character, in order

    String TranslatedText = "";                     //Initialized variable for the decoded ASCII text
    String CurrCode = "";                           //Initialized variable for the current ASCII code being translated
    
    for(int i = 0; i < ASCIIText.length(); i++)     //Decodes the hidden ASCII Text
    {
      if (ASCIIText.charAt(i) == ' ')               //Checks for spaces, If it is a space, the current code will be decoded
      {
        if ((Integer.parseInt(CurrCode)-32) >= 0 && (Integer.parseInt(CurrCode)-32) < 95)  //If the ASCII code is valid, decode it and add it to the translated text
        {
          TranslatedText += String.valueOf(ASCIIList.charAt((Integer.parseInt(CurrCode)-32)));
          CurrCode = "";
        }
        else                                        //If the ASCII code is invalid, add a (*) to the translated text
        {
          TranslatedText += " (*)";
          CurrCode = "";
        }
      }
      else if(i == ASCIIText.length() - 1)          //If it is the last character, decode it and add it to the translated text
      {
        CurrCode += String.valueOf(ASCIIText.charAt(i));
        if ((Integer.parseInt(CurrCode)-32) >= 0 && (Integer.parseInt(CurrCode)-32<95))
        {
          TranslatedText += String.valueOf(ASCIIList.charAt((Integer.parseInt(CurrCode)-32)));
        }
        else                                        //If the last character is invalid, add (*)
        {
          TranslatedText += " (*)";
        }
      }
      else                                          //Adds the current character in the ASCIItext to the current code for translating later 
      {
        CurrCode += String.valueOf(ASCIIText.charAt(i));
      }
    }
    System.out.println(TranslatedText + "\n \n ((*)'s indicate a character that cannot be represented) \n \n");
    System.out.println("Give me a name.");          //Prompts the user for a name
    Scanner Scan = new Scanner(System.in);
    String Name = Scan.nextLine();
    String ReverseName = "";
    for (int i = (Name.length()-1); i >= 0; i--)    //Puts the name in reverse order using a for loop
      {
        ReverseName += String.valueOf(Name.charAt(i));
      }
    System.out.println(ReverseName);
    String UpperCaseReverseName = "";
    for (int i = 0; i < ReverseName.length(); i++)  //Puts the name in all caps using a for loop
      {
        if (ASCIIList.substring(65, 91).contains(String.valueOf(ReverseName.charAt(i))))  //If the current character is lowercase, make it uppercase
        {
          int index = ASCIIList.indexOf((String.valueOf(ReverseName.charAt(i))));
          UpperCaseReverseName += String.valueOf(ASCIIList.charAt(index-32));
        }
        else                                        //Otherwise leave the character as it is
        {
          UpperCaseReverseName += String.valueOf(ReverseName.charAt(i));  
        }
      }
    System.out.println(UpperCaseReverseName);
    String CamelCaseName = "";
    Boolean CurrCase = true;                        //Boolean for switching between uppercase (true) and lowercase (false)
    for (int i = 0; i < Name.length(); i++)         //Makes the name AlTeRntE CAPS and lower case
      {
        if (CurrCase == true)                       //If the current letter should be upper case...
        {
          if (ASCIIList.substring(65, 91).contains(String.valueOf(Name.charAt(i))))  //If the current character is lowercase, make it uppercase
          {
            int index = ASCIIList.indexOf((String.valueOf(Name.charAt(i))));
            CamelCaseName += String.valueOf(ASCIIList.charAt(index-32));
            CurrCase = false;
          }
          else if (ASCIIList.substring(33, 59).contains(String.valueOf(Name.charAt(i))))   //If the current character is uppercase, leave it as it is
          {
            CamelCaseName += String.valueOf(Name.charAt(i));
            CurrCase = false;
          }
          else                                      //If the current character is not a letter, leave it as it is    
          {
            CamelCaseName += String.valueOf(Name.charAt(i));
          }
        }
        else                                        //If the current letter should be lower case...
        {
          if (ASCIIList.substring(65, 91).contains(String.valueOf(Name.charAt(i))))  //If the current character is lowercase, leave it as it is
          {
            CamelCaseName += String.valueOf(Name.charAt(i));   
            CurrCase = true;
          }
          else if (ASCIIList.substring(33, 59).contains(String.valueOf(Name.charAt(i)))) //If the current character is uppercase, make it lowercase
          {
            int index = ASCIIList.indexOf((String.valueOf(Name.charAt(i))));
            CamelCaseName += String.valueOf(ASCIIList.charAt(index+32));
            CurrCase = true;
          }
          else                                      //If the current character is not a letter, leave it as it is  
          {
            CamelCaseName += String.valueOf(Name.charAt(i));
          }
        }
      
    } 
    System.out.println(CamelCaseName);
    String ASCIIName = "";
    for (int i = 0; i < Name.length(); i++)         //Prints the name back in ASCII
      {
        if (ASCIIList.contains(String.valueOf(Name.charAt(i))))
        {
          ASCIIName += ASCIIList.indexOf(String.valueOf(Name.charAt(i)))+32 + " ";  //Adds the ASCII value of the current character to the ASCIIName string
        }
        else
        {
          ASCIIName += "(*) ";
        }
      }
    System.out.println(ASCIIName);
  }
}
