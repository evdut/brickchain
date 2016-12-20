package com.brickchain.projectTracker;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
@LocalBean
public class Bootstrap {

	@PersistenceContext
	private EntityManager em;

	@PostConstruct
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void init() {
//		Group group = new Group("STUDENT", null);
//		Group group2 = new Group("ADMIN", null);
//		Group group3 = new Group("TUTOR", null);
//		Group group4 = new Group("MODERATOR", null);
//		em.persist(group);
//		em.persist(group2);
//		em.persist(group3);
//		em.persist(group4);
//
//		User admin = new User("admin","admin","admin");
//		admin.addGroup(group2);
//		em.persist(admin);
//		
//		em.flush();
//		
//		Tutor tutor = new Tutor("tutor","tutor","tutor");
//		tutor.addGroup(group3);
//		em.persist(tutor);
//		
//		
//		tutor.rate(5);
//		tutor.rate(5);
//		tutor.rate(4);
//		em.flush();
//		Category category = new Category("Математика", "Математика");
//		Category category2 = new Category("Информатика", "Математика");
//		
//		for (int i = 1; i <= 4; i++) {
//			Course course = new Course(
//					"Математический анализ " + i,
//					"Курс математического анализа " + i,
//					"<ul><li>Введение в анализ.</li>"
//							+ "<li>Элементы теории множеств.</li>"
//							+ "<li>Натуральные числа. Математическая Индукция. Бином Ньютона.</li>"
//							+ "<li>Числа целые, рациональные, действительные. Аксиоматика множества"
//							+ "вещественных чисел.</li>"
//							+ "<li>Ограниченные множества. Инфимум и супремум. Теорема о существова-"
//							+ "нии точной верхней грани. Принцип Архимеда.</li>"
//							+ "<li>Три принциапа математического анализа. Принцип Больцано-Вейерштрасса."
//							+ "Теорема Кантора об интервалах. Теорема Бореля</li></ul>",
//					"https://player.vimeo.com/video/157100757", tutor, category);
//			course.addLessson(new Lesson("Урок 1", "Введение в анализ",
//					"https://player.vimeo.com/video/157100757"));
//			course.addLessson(new Lesson(
//					"Урок 2",
//					"Натуральные числа. Математическая Индукция. Бином Ньютона.",
//					"https://player.vimeo.com/video/157100757"));
//			course.addLessson(new Lesson("Урок 3",
//					"Числа целые, рациональные, действительные. Аксиоматика множества"
//							+ "вещественных чисел.",
//					"https://player.vimeo.com/video/157100757"));
//			course.addLessson(new Lesson("Урок 4",
//					"Ограниченные множества. Инфимум и супремум. Теорема о существова-"
//							+ "нии точной верхней грани. Принцип Архимеда.",
//					"https://player.vimeo.com/video/157100757"));
//			
//			
//			Integer views = ThreadLocalRandom.current().nextInt(1, 1200);
//			Integer likes = ThreadLocalRandom.current().nextInt(1, views);
//			for(int j = 1; j <= views; j++){
//				course.getViewsAndLikes().viewed();
//			}
//			for(int j = 1; j <= likes; j++){
//				course.getViewsAndLikes().like();
//			}
//			em.persist(course);
//		}
//
//		
//		Course course = new Course(
//				"Введение в java ",
//				"Курс для тех кто хочет начать изучать язык программирования Java ",
//				"<ul><li>Введение в анализ.</li>"
//						+ "<li>Элементы теории множеств.</li>"
//						+ "<li>Натуральные числа. Математическая Индукция. Бином Ньютона.</li>"
//						+ "<li>Числа целые, рациональные, действительные. Аксиоматика множества"
//						+ "вещественных чисел.</li>"
//						+ "<li>Ограниченные множества. Инфимум и супремум. Теорема о существова-"
//						+ "нии точной верхней грани. Принцип Архимеда.</li>"
//						+ "<li>Три принциапа математического анализа. Принцип Больцано-Вейерштрасса."
//						+ "Теорема Кантора об интервалах. Теорема Бореля</li></ul>",
//				"https://player.vimeo.com/video/157100757", tutor, category2);
//		course.addLessson(new Lesson("Урок 1", "Введение в анализ",
//				"https://player.vimeo.com/video/157100757"));
//		course.addLessson(new Lesson(
//				"Урок 2",
//				"Натуральные числа. Математическая Индукция. Бином Ньютона.",
//				"https://player.vimeo.com/video/157100757"));
//		course.addLessson(new Lesson("Урок 3",
//				"Числа целые, рациональные, действительные. Аксиоматика множества"
//						+ "вещественных чисел.",
//				"https://player.vimeo.com/video/157100757"));
//		course.addLessson(new Lesson("Урок 4",
//				"Ограниченные множества. Инфимум и супремум. Теорема о существова-"
//						+ "нии точной верхней грани. Принцип Архимеда.",
//				"https://player.vimeo.com/video/157100757"));
//		
//		Integer views2 = ThreadLocalRandom.current().nextInt(1, 1200);
//
//		for(int j = 1; j <= views2; j++){
//			course.getViewsAndLikes().viewed();
//		}
//		for(int j = 1; j <= ThreadLocalRandom.current().nextInt(1, views2); j++){
//			course.getViewsAndLikes().like();
//		}
//		em.persist(course);
//		
//		for (int i = 1; i <= 4; i++) {
//			Article article = new Article(
//					"Заметка" + i,
//					"Заметка о Lorem ipsum dolor sit amet",
//					"<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
//					+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
//					+ "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris "
//					+ "nisi ut aliquip ex ea commodo consequat.</p><br/>"
//					+ "<a href='http://random-ize.com/lorem-ipsum-generators/lorem-ipsum/lorem-ipsum.jpg'></a> "
//					+ "<p>Duis aute irure dolor in "
//					+ "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla "
//					+ "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa"
//					+ " qui officia deserunt mollit anim id est laborum.</p>");
//			
//			Integer views = ThreadLocalRandom.current().nextInt(1, 1200);
//			Integer likes = ThreadLocalRandom.current().nextInt(1, views);
//			for(int j = 1; j <= views; j++){
//				article.getViewsAndLikes().viewed();
//			}
//			for(int j = 1; j <= likes; j++){
//				article.getViewsAndLikes().like();
//			}
//			em.persist(article);
//		}
//		
//		for (int i = 1; i <= 4; i++) {
//			Integer days = ThreadLocalRandom.current().nextInt(10, 40);
//			Webinar webinar = new Webinar("Webinar" + i, "Webinar about physics", "http://www.clickwebinar.com/", Date.from(Instant.now().plus(days, ChronoUnit.DAYS)));
//			
//			Integer views = ThreadLocalRandom.current().nextInt(1, 1200);
//			Integer likes = ThreadLocalRandom.current().nextInt(1, views);
//			for(int j = 1; j <= views; j++){
//				webinar.getViewsAndLikes().viewed();
//			}
//			for(int j = 1; j <= likes; j++){
//				webinar.getViewsAndLikes().like();
//			}
//			em.persist(webinar);
//		}		
	}

}
