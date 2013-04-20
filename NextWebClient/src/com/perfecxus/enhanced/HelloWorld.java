package com.perfecxus.enhanced;

import io.nextweb.Node;
import io.nextweb.Query;
import io.nextweb.Session;
import io.nextweb.jre.Nextweb;

public class HelloWorld {

	/**
	 * This program creates a network with translation of Hello World in 5
	 * different languages besides English
	 */
	public static void main(String[] args) {
		Session session = Nextweb.createSession();
		Query helloWorld = session.seed("helloworld");

		// add value
		Node aLanguageType = session.seed("aLanguageType").get();
		Node aTranslatedValue = session.seed(" aTranslatedValue").get();
		// English Language node
		Query english = helloWorld.append("english");
		english.append("English").append(aLanguageType);

		english.append("HelloWorld").append(aTranslatedValue);

		// German Language node
		Query german = helloWorld.append("german");
		german.append("German").append(aLanguageType);

		german.append("Hallo Welt").append(aTranslatedValue);

		// Spanish Language node
		Query spanish = helloWorld.append("spanish");
		spanish.append("Spanish").append(aLanguageType);
		spanish.append("Hola mundo").append(aTranslatedValue);

		// French Language node
		Query french = helloWorld.append("french");
		french.append("French").append(aLanguageType);
		french.append("Bonjour tout le monde").append(aTranslatedValue);

		// Italian Language node
		Query italian = helloWorld.append("italian");
		italian.append("Italian").append(aLanguageType);
		italian.append("Ciao mondo").append(aTranslatedValue);

		// Danish Language node
		Query danish = helloWorld.append("danish");
		danish.append("Danish").append(aLanguageType);
		danish.append("Hej verdens").append(aTranslatedValue);

		// Create the nodes in the cloud
		Node nHelloWorld = helloWorld.get();

		// Print out the URIs
		System.out.println("URI of the network :" + nHelloWorld.uri());
		System.out.println("URI of aTranslatedValue: " + aTranslatedValue.uri());
		System.out.println("URI of aLanguageType: " + aLanguageType.uri());

	}
}