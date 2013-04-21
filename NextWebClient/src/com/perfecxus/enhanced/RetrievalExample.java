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

import io.nextweb.Link;
import io.nextweb.ListQuery;
import io.nextweb.Node;
import io.nextweb.NodeList;
import io.nextweb.Session;
import io.nextweb.jre.Nextweb;

import java.util.Arrays;
import java.util.List;


/**
 * This program retrieves the Hello World translations network created in the
 * HelloWorld example. This Program takes at-least 3 arguments to run. The arguments are in the format:
 * 	<URI of Hello World Network> <URI of aTranslatedValue> <lang1> <lang2>...
 * 
 * For example: To retrieve a translation in German and Danish language for a Hello World network, the program arguments should be he following:
 * 	"http://slicnet.com/seed1/seed1/6/0/5/2/h/sd" "http://slicnet.com/seed1/seed1/6/0/5/1/h/sd" "German" "Danish"
 */

public class RetrievalExample {

	public static void main(String[] args) {

		if(args.length<3){
			System.out.println("Please pass proper program arguments. The arguments should be in the format: \n <URI of Hello World Network> <URI of aTranslatedValue> <lang1> <lang2>...");
			
			System.exit(0);
		}
		
		List<String> langArray = Arrays.asList(args).subList(2, args.length);

		Session session = Nextweb.createSession();
		// Load the seed node of our network using the uri
		Link linkHelloWorldNetwork = session
				.node(args[0]); 

		Link linkATranslatedValue = session
				.node(args[1]); 

		Node helloWorld = linkHelloWorldNetwork.get();
		// select all children of the seed node
		ListQuery allLangs = helloWorld.selectAll();
		// get the node list from server
		NodeList resolvedChildNodes = allLangs.get();

		List<Node> list = resolvedChildNodes.asList();
		// Loop through all the children nodes , print only the ones in the
		// language array langList
		for (Node langNode: list) {

			for (String language: langArray) {

				if (language.equals((String) langNode.value())) {
					// from the current language reference node, retrieve
					// children of aLanguageType and aTranslatedValue types

					System.out.println("Hello World translation in "+(langNode).value()
							+ " : "
							+ (langNode.select(linkATranslatedValue)).get()
									.value());

				}
			}
		}
		session.close();
	}

}
