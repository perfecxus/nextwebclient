package com.perfecxus.enhanced;

import io.nextweb.Link;
import io.nextweb.ListQuery;
import io.nextweb.Node;
import io.nextweb.NodeList;
import io.nextweb.Session;
import io.nextweb.jre.Nextweb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RetrievalExample {

	/**
	 * This program retrieves the Hello World translations network created in the
	 * HelloWorld example. Only the languages mentioned in the langArray are
	 * retrieved
	 */
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
