# A-simple-encrypter-decrypter
A fun side project of text to binary and vice versa command-Line interface encrypter

So, Basically it is a simple text to binary and vice versa converter, made it just for fun, it uses simple hashmap/ dictionary mapping for characters to map it to binary.

You can either run it on any IDE editor but for that you will need java to be installed on the system or you can just run the exe file and use it in command prompt.

 For IDE Run:
 [Java](https://javadl.oracle.com/webapps/download/AutoDL?BundleId=248737_8c876547113c4e4aab3c868e9e0ec572)
 [JDK](https://www.oracle.com/in/java/technologies/downloads/)
                

## Breakdown of the code
The encrypter and decrypter which uses a single hashmap "Reference_map" for the dictonary mapping which is called upon based on the user input desire.

The Reference_map is a single hashmap which is called in two function namely:
        Reference_table and Reverse_Reference_table

Reference_table and Reverse_Reference_table funtion handle the hasmap reference_map how the value are going to be mapped.

Next up is the encrypt and decrypt fucntion that handle the actual conversion.
    