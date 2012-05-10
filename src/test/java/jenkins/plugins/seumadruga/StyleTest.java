package jenkins.plugins.seumadruga;

import jenkins.plugins.seumadruga.Style;
import hudson.model.Result;
import junit.framework.TestCase;

public class StyleTest extends TestCase {

	public void testGetWithFailureResultGivesBadAssStyle() {
		assertEquals(Style.FAILURE, Style.get(Result.FAILURE));
	}

	public void testGetWithSuccessResultGivesSuitupStyle() {
		assertEquals(Style.SUCCESS, Style.get(Result.SUCCESS));
	}

	public void testGetWithAbortedResultGivesAlertStyle() {
		assertEquals(Style.ALERT, Style.get(Result.ABORTED));
	}

	public void testGetWithNotBuiltResultGivesAlertStyle() {
		assertEquals(Style.ALERT, Style.get(Result.NOT_BUILT));
	}

	public void testGetWithUnstableResultGivesAlertStyle() {
		assertEquals(Style.ALERT, Style.get(Result.UNSTABLE));
	}
}
