package jenkins.plugins.seumadruga;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.Build;
import hudson.model.BuildListener;
import hudson.model.Result;

import java.util.ArrayList;
import java.util.List;

import jenkins.plugins.seumadruga.CordellWalkerRecorder;
import jenkins.plugins.seumadruga.SentenceGenerator;
import jenkins.plugins.seumadruga.SeuMadrugaAction;
import jenkins.plugins.seumadruga.Style;

import junit.framework.TestCase;

public class CordellWalkerRecorderTest extends TestCase {

	private SentenceGenerator mockGenerator;
	private CordellWalkerRecorder recorder;

	@Override
	public void setUp() {
		mockGenerator = mock(SentenceGenerator.class);
		recorder = new CordellWalkerRecorder(mockGenerator);
	}

	public void testGetProjectActionWithNoLastBuildGivesNullAction() {
		AbstractProject mockProject = mock(AbstractProject.class);
		when(mockProject.getLastBuild()).thenReturn(null);
		assertNull(recorder.getProjectAction(mockProject));
	}

	public void testGetProjectActionHavingLastBuildGivesRoundhouseAction() {
		AbstractProject mockProject = mock(AbstractProject.class);
		Build mockBuild = mock(Build.class);

		when(mockProject.getLastBuild()).thenReturn(mockBuild);
		when(mockBuild.getResult()).thenReturn(Result.SUCCESS);
		when(mockGenerator.random()).thenReturn(
				"Deus ajuda quem cedo madruga!");

		Action action = recorder.getProjectAction(mockProject);

		assertTrue(action instanceof SeuMadrugaAction);
		assertEquals(Style.SUCCESS, ((SeuMadrugaAction) action).getStyle());
		assertNotNull(((SeuMadrugaAction) action).getFact());
	}

	public void testPerformWithFailureResultAddsRoundHouseActionWithBadAssStyleAndExpectedFact()
			throws Exception {
		List<Action> actions = new ArrayList<Action>();
		AbstractBuild mockBuild = mock(AbstractBuild.class);
		when(mockBuild.getResult()).thenReturn(Result.FAILURE);
		when(mockBuild.getActions()).thenReturn(actions);

		when(mockGenerator.random()).thenReturn(
				"Deus ajuda quem cedo madruga!");

		assertEquals(0, actions.size());

		recorder.perform(mockBuild, mock(Launcher.class),
				mock(BuildListener.class));

		assertEquals(1, actions.size());
		assertTrue(actions.get(0) instanceof SeuMadrugaAction);
		assertEquals(Style.FAILURE, ((SeuMadrugaAction) actions.get(0))
				.getStyle());
		assertEquals("Deus ajuda quem cedo madruga!",
				((SeuMadrugaAction) actions.get(0)).getFact());
	}
}
