package com.tupilabs.jenkins.seumadruga;

import com.tupilabs.jenkins.seumadruga.SeuMadrugaAction;
import com.tupilabs.jenkins.seumadruga.Style;

import junit.framework.TestCase;

public class SeuMadrugaActionTest extends TestCase {

	private SeuMadrugaAction action;

	public void setUp() {
		action = new SeuMadrugaAction(Style.FAILURE,
				"Deus ajuda quem cedo madruga!");
	}

	public void testAccessors() {
		assertEquals(Style.FAILURE, action.getStyle());
		assertEquals("Deus ajuda quem cedo madruga!", action
				.getFact());
		assertEquals("Seu Madruga", action.getDisplayName());
		assertNull(action.getIconFileName());
		assertEquals("seumadruga", action.getUrlName());
	}
}
