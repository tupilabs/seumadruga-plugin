package jenkins.plugins.seumadruga;

import static org.mockito.Mockito.mock;
import jenkins.plugins.seumadruga.SeuMadrugaDescriptor;
import hudson.model.AbstractProject;
import junit.framework.TestCase;

public class SeuMadrugaDescriptorTest extends TestCase {

	private SeuMadrugaDescriptor descriptor;

	public void setUp() {
		descriptor = new SeuMadrugaDescriptor();
	}

	public void testGetDisplayName() {
		assertEquals("Activate Seu Madruga", descriptor.getDisplayName());
	}

	public void testIsApplicableGivesTrue() {
		assertTrue(descriptor.isApplicable(mock(AbstractProject.class)
				.getClass()));
	}
}
