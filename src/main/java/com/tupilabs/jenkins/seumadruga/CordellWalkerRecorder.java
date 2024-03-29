/**
 * Copyright (c) 2012 Bruno P. Kinoshita
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.tupilabs.jenkins.seumadruga;

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;

import java.io.IOException;
import java.util.logging.Logger;

import org.kohsuke.stapler.DataBoundConstructor;

/**
 * This class associates an Action to a job or a build.
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 0.1
 */
public class CordellWalkerRecorder extends Recorder {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger
            .getLogger(CordellWalkerRecorder.class.getName());

    /**
     * Sentence generator.
     */
    private SentenceGenerator sentence;

    /**
     * Constructs a {@link CordellWalkerRecorder} with default
     * {@link SentenceGenerator}.
     */
    @DataBoundConstructor
    public CordellWalkerRecorder() {
        this(new SentenceGenerator());
    }

    /**
     * Constructs a {@link CordellWalkerRecorder} with specified
     * {@link SentenceGenerator}.
     * @param factGenerator
     *            the fact generator
     */
    public CordellWalkerRecorder(final SentenceGenerator factGenerator) {
        this.sentence = factGenerator;
        LOGGER.info("Seu Madruga is activated");
    }

    /**
     * Gets the Action as the project action. This is applicable for
     * each job and only when there's at least one build in the job.
     * @param project
     *            the project
     * @return the project action
     */
    @Override
    public final Action getProjectAction(final AbstractProject<?, ?> project) {
        Action action = null;
        if (project.getLastBuild() != null) {
            Style style = Style.get(project.getLastBuild().getResult());
            String fact = sentence.random();
            action = new SeuMadrugaAction(style, fact);
        }
        return action;
    }

    /**
     * Adds Action to the build actions. This is applicable for each
     * build.
     * @param build
     *            the build
     * @param launcher
     *            the launcher
     * @param listener
     *            the listener
     * @return true
     * @throws InterruptedException
     *             when there's an interruption
     * @throws IOException
     *             when there's an IO error
     */
    @Override
    public final boolean perform(final AbstractBuild<?, ?> build,
            final Launcher launcher, final BuildListener listener)
            throws InterruptedException, IOException {
        Style style = Style.get(build.getResult());
        String fact = sentence.random();
        build.getActions().add(new SeuMadrugaAction(style, fact));
        return true;
    }

    /**
     * Gets the required monitor service.
     * @return the BuildStepMonitor
     */
    public final BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;
    }
}
