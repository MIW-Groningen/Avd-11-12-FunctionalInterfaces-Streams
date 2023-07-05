import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class Course implements Comparable<Course> {
    private final String code;
    private String title;
    private int ects;
    private final Set<Exam> exams;

    public Course(String code) {
        this.code = code;
        this.title = "";
        this.ects = 0;
        this.exams = new HashSet<>();
    }
    public Course(String code, String title, int ects) {
        this(code);
        this.title = title;
        this.ects = ects;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", this.title, this.code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(code, course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public int compareTo(Course o) {
        return this.code.compareTo(o.code);
    }

    /**
     * Retrieves the Exam of the Course at a given date, if any
     * @param date
     * @return  returns null if no Exam has been scheduled for the given date
     */
    public Exam getExamAt(LocalDate date) {

        // TODO-1 determine whether an exam has been scheduled for the given date, using a for-loop
        if (SIS.solutionVariant > 0) {

        }

        // TODO-2 determine whether an exam has been scheduled for the given date, using .stream()
        if (SIS.solutionVariant < 0) {

        }

        return null;
    }
    public Exam getExamAt(String dateString) {
        return this.getExamAt(LocalDate.parse(dateString));
    }

    /**
     * Finds all Exams of the Course that match a given filter predicate
     * @param filter
     * @return
     */
    public Set<Exam> findExams(Predicate<Exam> filter) {
        Set<Exam> foundExams = new TreeSet<>();
        // TODO-1 deliver the set of exams which match the filter using .forEach()
        if (SIS.solutionVariant > 0) {

        }

        // TODO-2 deliver the set of exams which match the filter using .stream()
        if (SIS.solutionVariant < 0) {

        }

        return foundExams;
    }

    /**
     * calculates the average grade of all results of all exams of the Course
     * @return
     */
    public double getAverageGrade() {
        double gradeAverage = 0.0;

        // TODO-1a calculate gradeAverage using for-loop iteration
        if (SIS.solutionVariant == 1) {

        }

        // TODO-1b calculate gradeAverage using .forEach() and lambda expression
        if (SIS.solutionVariant > 1) {
            var ref = new Object() {
                double gradeSum = 0.0;
                int gradeCount = 0;
            };

        }

        // TODO-2 calculate gradeAverage using .stream()
        //  (can be done without need of gradeCount)
        if (SIS.solutionVariant < 0) {

        }

        return gradeAverage;
    }

    private static final Random randomizer = new Random();

    private static final Course[] theCourses = {
            new Course("1019MAT", "ESK Mathematics", 2),
            new Course("1019DUT", "ESK Dutch", 2),
            new Course("1019ENG", "ESK English", 2),
            new Course("1019PER", "PSK Personal Skills", 2),
            new Course("1019COM", "PSK Communication", 2),
            new Course("1019COL", "PSK Collaboration", 2),
            new Course("1019RES", "PSK Research", 2),
            new Course("1019PRO", "Programming", 3),
            new Course("1019OP1", "Object Oriented Programming 1", 3),
            new Course("1019OP2", "Object Oriented Programming 2", 3),
            new Course("1019DAM", "Data Modelling", 3),
            new Course("1019DB2", "Databases 2", 3),
            new Course("1019WET", "Web Technology", 3),
            new Course("1019TES", "Testing", 3),
            new Course("1019UID", "User Interaction Design", 3),
            new Course("1019BUS", "Business", 3),
            new Course("1019INF", "Infrastructure", 3),
            new Course("2019WEF", "Web Frameworks", 6),
            new Course("2019ADS", "Algorithms and Data Structures", 8),
            new Course("3019ERP", "Enterprise Resource Processing", 4),
            new Course("3019NSO", "Simulation and Optimisation with MatLab", 4),
            new Course("3019LIA", "Linear Algebra", 4),
            new Course("3019LSC", "Logistics and Supply Chain Management", 4),
            new Course("3019PME", "Physics and Mechanical Engineering", 4),
            new Course("3019NLD", "Linear and non-linear dynamics", 4),
            new Course("3019NMC", "Numerical Methods with C++", 4),
            new Course("3019VVR", "3D visualisation and virtual reality", 4),
            new Course("4019AAD", "Architecture and Design", 4),
            new Course("4019RED", "Research Design", 3),
            new Course("4019RED", "Advisory Skills", 3),
            new Course("4019ASV", "Automated Software Validation", 4),
            new Course("4019PAC", "Parallel Computing", 4),
            new Course("4019DIM", "Discrete Mathematics", 4)
    };

    public static Course getARandomCourse() {
        Course course = theCourses[randomizer.nextInt(theCourses.length)];
        return new Course(course.code, course.title, course.ects);
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getEcts() {
        return ects;
    }

    public Set<Exam> getExams() {
        return exams;
    }

}
