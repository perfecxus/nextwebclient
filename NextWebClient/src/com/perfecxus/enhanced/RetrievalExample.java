package com.perfecxus.enhanced;

import io.nextweb.Link;
import io.nextweb.ListQuery;
import io.nextweb.Node;
import io.nextweb.NodeList;
import io.nextweb.Session;
import io.nextweb.jre.Nextweb;

import java.util.List;

public class RetrievalExample {

	/**
	 * This program retrieves the Hello World translations network created in the
	 * HelloWorld example. Only the languages mentioned in the langArray are
	 * retrieved
	 */
	public static void main(String[] args) {

		String[] langArray = { "German", "Spanish", "French", "Italian",
				"Danish" };

		Session session = Nextweb.createSession();
		// Load the seed node of our network using the uri
		Link linkHelloWorldNetwork = session
				.node("http://slicnet.com/seed1/seed1/6/0/1/7/h/sd");

		Link linkATranslatedValue = session
				.node("http://slicnet.com/seed1/seed1/6/0/1/6/h/sd");

		Node helloWorld = linkHelloWorldNetwork.get();
		// select all children of the seed node
		ListQuery allLangs = helloWorld.selectAll();
		// get the node list from server
		NodeList resolvedChildNodes = allLangs.get();

		List list = resolvedChildNodes.asList();
		// Loop through all the children nodes , print only the ones in the
		// language array langList
		for (int i = 0; i < list.size(); i++) {

			Node langNode = (Node) list.get(i);

			for (int j = 0; j < langArray.length; j++) {

				if (langArray[j].equals((String) langNode.value())) {
					// from the current language reference node, retrieve
					// children of aLanguageType and aTranslatedValue types

					System.out.println((langNode).value()
							+ " : "
							+ (langNode.select(linkATranslatedValue)).get()
									.value());

				}
			}
		}
	}

}
