package com.brickchain.projectTracker.project.handler.query;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.project.domain.Project;
import com.brickchain.projectTracker.project.domain.repository.ProjectRepository;
import com.brickchain.projectTracker.project.domain.repository.UserRepository;
import com.brickchain.projectTracker.project.interfaces.dto.ProjectDTO;
import com.brickchain.projectTracker.project.interfaces.query.GetProjectsQuery;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = GetProjectsQuery.class)
public class GetTaskQueryHandler implements Handler<GetProjectsQuery> {

	public final static String USER_GROUP = "STUDENT";

	@PostConstruct
	private void init() {

	}

	@PreDestroy
	private void destroy() {

	}

	@Inject
	ProjectRepository projectRepository;

	@Inject
	UserRepository userRepository;

	@Override
	// TODO Update after exception handling mechanism realized
	public void handle(GetProjectsQuery query) {
		List<ProjectDTO> result = null;
		if (query.getParticipantId() != null) {
			result = userRepository.findByProfileId(query.getParticipantId()).getProjects().stream()
					.map(projectToDtoMap).collect(Collectors.toList());
		} else if (query.getProjectIds() != null) {
			projectRepository.findByIds(query.getProjectIds()).stream().map(projectToDtoMap)
					.collect(Collectors.toList());
		} else {
			projectRepository.findAll().stream().map(projectToDtoMap)
					.collect(Collectors.toList());
		}

		query.setResult((ArrayList<ProjectDTO>) result);
	}

	private Function<Project, ProjectDTO> projectToDtoMap = project -> new ProjectDTO(project.getTitle(), null,
			project.getSchedule().getDueDate(), project.getBudget().getLast());
}
