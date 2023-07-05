import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Exam implements Comparable<Exam> {
    private static final Random randomizer = new Random();
    private final LocalDate date;
    private final Course course;
    private final Map<Student, Double> results;

    public Exam(LocalDate date, Course course) {
        this.date = date;
        this.course = course;
        this.results = new HashMap<>();
        this.course.getExams().add(this);
    }
    public Exam(String dateString, Course course) {
        this(LocalDate.parse(dateString), course);
    }

    public Exam(Course course) {
        this(Exam.getARandomDate(course), course);
    }

    @Override
    public String toString() {
        return String.format("E_%s(%s)", this.date.format(DateTimeFormatter.ISO_DATE), this.course.getCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return Objects.equals(date, exam.date) && Objects.equals(course, exam.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, course);
    }

    @Override
    public int compareTo(Exam o) {
        int result = this.date.compareTo(o.date);
        if (result == 0) {
            result = this.course.compareTo(o.course);
        }
        return result;
    }

    /**
     * Adds a result by a Student or overwrites a previous registration of a result by the same student.
     * Also updates the Student's requirements and exam participation if required
     * @param student
     * @param grade
     * @return
     */
    public Exam addResult(Student student, double grade) {
        student.getRequirements().add(this.getCourse());
        student.getExams().add(this);
        this.results.put(student, grade);

        return this;
    }

    /**
     * finds a suitable random date for a new Exam of a Course
     * (on a day when no Exam has been scheduled already)
     * @param course
     * @return
     */
    public static LocalDate getARandomDate(Course course) {
        LocalDate examDate;
        do {
            examDate = LocalDate.now().minusDays(randomizer.nextInt(1000));
        } while (course.getExamAt(examDate) != null);
        return examDate;
    }

    public static LocalTime getARandomTime() {
        return LocalTime.NOON.plusHours(randomizer.nextInt(10)-3);
    }

    public Course getCourse() {
        return course;
    }

    public Map<Student, Double> getResults() {
        return results;
    }

    public LocalDate getDate() {
        return date;
    }
}
