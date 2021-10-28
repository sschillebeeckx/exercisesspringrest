package be.abis.exercise.service;

import be.abis.exercise.exception.EnrollException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;

import java.time.LocalDate;
import java.util.List;

public interface TrainingService {

    public String getWelcomeMessage();
    public PersonService getPersonService();
    public CourseService getCourseService();

    public List<Course> showFollowedCourses(Person person);

    public void enrollForSession(Person person, Course course, LocalDate date) throws EnrollException;
}
