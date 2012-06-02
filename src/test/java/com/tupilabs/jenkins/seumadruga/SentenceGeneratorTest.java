package com.tupilabs.jenkins.seumadruga;

import com.tupilabs.jenkins.seumadruga.SentenceGenerator;

import junit.framework.TestCase;

public class SentenceGeneratorTest extends TestCase {

	private SentenceGenerator generator;

	public void setUp() {
		generator = new SentenceGenerator();
	}

	public void testRandomGivesAtLeast2Facts() {
		String lastFact = null;
		for (int i = 0; i < 1000000; i++) {
			String currFact = generator.random();
			if (lastFact != null && !lastFact.equals(currFact)) {
				return;
			}
			lastFact = currFact;
		}
		fail("Random should give at least 2 different facts in 1000000 tries.");
	}
}
