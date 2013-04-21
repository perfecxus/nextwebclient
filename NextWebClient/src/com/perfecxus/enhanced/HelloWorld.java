/*Copyright (c) 2013 Perfecxus Global
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
 * and associated documentation files (the "Software"), to deal in the Software without restriction, 
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *  
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 *  LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 *  IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE
*/

package com.perfecxus.enhanced;

import io.nextweb.Node;
import io.nextweb.Query;
import io.nextweb.Session;
import io.nextweb.jre.Nextweb;
/**
 * This program creates a network with translation of Hello World in 5
 * different languages besides English.The other languages are:
 * 1. German
 * 2. Danish
 * 3. French
 * 4. Latin
 * 5. Spanish
 */
public class HelloWorld {

	
	public static void main(String[] args) {
		Session session = Nextweb.createSession();
		Query helloWorld = session.seed("helloworld");

		// add value
		Node aLanguageType = session.seed("aLanguageType").get();
		aLanguageType.append("This denotes a property Language type", "./aLanguageType");
		Node aTranslatedValue = session.seed(" aTranslatedValue").get();
		aTranslatedValue.append("This denotesa Translation value type ", "./aTranslatedValue");
		// English Language node
		Query english = helloWorld.append("English");
		english.append(aLanguageType);

		english.append("Hello World").append(aTranslatedValue);

		// German Language node
		Query german = helloWorld.append("German");
		german.append(aLanguageType);
		german.append("Hallo Welt").append(aTranslatedValue);

		// Spanish Language node
		Query spanish = helloWorld.append("Spanish");
		spanish.append(aLanguageType);
		spanish.append("Hola mundo").append(aTranslatedValue);

		// French Language node
		Query french = helloWorld.append("French");
		french.append(aLanguageType);
		french.append("Bonjour tout le monde").append(aTranslatedValue);

		// Italian Language node
		Query italian = helloWorld.append("Latin");
		italian.append(aLanguageType);
		italian.append("salve mundi").append(aTranslatedValue);

		// Danish Language node
		Query danish = helloWorld.append("Danish");
		danish.append(aLanguageType);
		danish.append("Hej verdens").append(aTranslatedValue);

		// Create the nodes in the cloud
		Node nHelloWorld = helloWorld.get();

		// Print out the URIs
		System.out.println("URI of the network :" + nHelloWorld.uri());
		System.out.println("URI of aTranslatedValue: " + aTranslatedValue.uri());
		System.out.println("URI of aLanguageType: " + aLanguageType.uri());
		session.close();
	}
}