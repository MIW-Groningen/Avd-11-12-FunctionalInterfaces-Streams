import java.util.*;

public class Student implements Comparable<Student> {
    private static final Random randomizer = new Random();
    private static int lastNumber = 500900000;

    private final int number;
    private String name;
    private final Set<Course> requirements;
    private final Set<Exam> exams;

    public Student(int number) {
        this.number = number;
        lastNumber = Math.max(number, lastNumber);
        this.requirements = new HashSet<>();
        this.exams = new TreeSet<>();
    }

    public Student(int number, String name) {
        this(number);
        this.name = name;
    }

    public Student() {
        this(lastNumber + 1 + randomizer.nextInt(12),
                Names.nextFirstName() + " " + Names.nextSurname());
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", this.name, this.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return number == student.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Student o) {
        return this.number - o.number;
    }

    /**
     * @param course course to be checked
     * @return whether the course is part of the requirements of this Student
     */
    public boolean requires(Course course) {
        return this.requirements.contains(course);
    }

    /**
     * @param course to be checked
     * @return whether this Student has passed the given Course
     */
    public boolean hasPassed(Course course) {
        return this.getBestResult(course) >= 5.5;
    }

    /**
     * retrieves the best Exam result of the Student for the given Course
     * @param course    The Course to get the result for
     * @return          returns 0.0 if no Exam result was registered for the Student yet
     */
    public double getBestResult(Course course) {
        double bestResult = 0;

        // TODO-1 calculate best result using a for-loop
        if (SIS.solutionVariant > 0) {

        }

        // TODO-2 calculate best result using .stream()
        if (SIS.solutionVariant < 0) {

        }

        return bestResult;
    }

    /**
     * Calculates the total number of ECTS of all Course requirements of a Student
     * @return Total ECTS this Student is required to get
     */
    public int getRequiredECTS() {
        int ects = 0;

        // TODO-1a calculate total of required ECTS using a for-loop
        if (SIS.solutionVariant == 1) {

        }

        // TODO-1b calculate total of required ECTS using a .forEach()
        if (SIS.solutionVariant > 1) {
            var ectsObj = new Object() {
                int value = 0;
            };

            return ectsObj.value;
        }

        // TODO-2 calculate total of required ECTS using .stream()
        if (SIS.solutionVariant < 0) {

        }

        return ects;
    }

    /**
     * Calculates the total number of earned ECTS of the student from Courses with a passed Exam
     * @return
     */
    public int getEarnedECTS() {
        int ects = 0;

        // TODO-1a calculate total of earned ECTS using a for-loop
        if (SIS.solutionVariant == 1) {

        }

        // TODO-1b calculate total of earned ECTS using .forEach()
        if (SIS.solutionVariant > 1) {
            var ectsObj = new Object() {
                int value = 0;
            };

            return ectsObj.value;
        }

        // TODO-2 calculate total of earned ECTS using .stream()
        if (SIS.solutionVariant < 0) {

        }

        return ects;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Set<Course> getRequirements() {
        return requirements;
    }

    public Set<Exam> getExams() {
        return exams;
    }
}
