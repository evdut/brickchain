package com.brickchain.projectTracker.project.handler.query;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.project.domain.Project;
import com.brickchain.projectTracker.project.domain.repository.ProjectRepository;
import com.brickchain.projectTracker.project.interfaces.dto.ProjectDTO;
import com.brickchain.projectTracker.project.interfaces.dto.TaskDTO;
import com.brickchain.projectTracker.project.interfaces.dto.UserDTO;
import com.brickchain.projectTracker.project.interfaces.query.GetProjectQuery;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = GetProjectQuery.class)
public class GetProjectQueryHandler implements Handler<GetProjectQuery> {

	public final static String USER_GROUP = "STUDENT";

	@PostConstruct
	private void init() {

	}

	@PreDestroy
	private void destroy() {

	}

	@Inject
	ProjectRepository projectRepository;

	@Override
	// TODO Update after exception handling mechanism realized
	public void handle(GetProjectQuery query) {
		Project project = projectRepository.find(query.getProjectId());
		if (project == null) {
			throw new RuntimeException(String.format("Cant find project with id %s", query.getProjectId()));
		}
		ProjectDTO projectDTO = new ProjectDTO(project.getTitle(), project.getDescription(),
				project.getSchedule().getDueDate(), project.getBudget().getOriginal());
		project.getTasks().stream().forEach(task -> projectDTO
				.addTask(new TaskDTO(task.getTitle(), null, null, null, task.getBudget().getLast(), null, null)));
		project.getUsers().stream().forEach(user -> projectDTO
				.addUserDTO(new UserDTO(user.getUserName(), null, null, user.getProfileId())));
		
		query.setResult(projectDTO);
	}
}
