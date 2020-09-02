package com.teamjeaa.projecttemplate;

import com.teamjeaa.projecttemplate.controller.ProjectController;
import com.teamjeaa.projecttemplate.model.Project;
import com.teamjeaa.projecttemplate.view.ProjectView;
import javax.swing.SwingUtilities;

public final class ProjectTemplate {
	private ProjectTemplate() {
		/* No instances allowed! */
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				final Project project = new Project();
				final ProjectView projectView = new ProjectView(project);

				ProjectController.create(project, projectView);
				projectView.setVisible(true);
			}
		});
	}
}
