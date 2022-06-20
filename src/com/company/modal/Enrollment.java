package com.company.modal;




    import com.company.repository.Repository;

    import java.util.ArrayList;
    import java.util.HashSet;

public class Enrollment {
        int id;
        Student student;
        Course course;

        static int lastID;
        public static ArrayList<Enrollment> allCE = new ArrayList<>();

        public Enrollment(Student student, Course course) {
            this.id = ++lastID;
            this.student = student;
            this.course = course;
            allCE.add(this);
            Repository.addEnrollment(id, "" + student.getId(), "" + course.getId());
        }

        public Enrollment(int id, int studentId, int courseId) {
            this.id = lastID = id;
            this.student = Student.getStudentById(studentId);
            this.course = Course.getCourseById(courseId);
            allCE.add(this);
        }

        public static ArrayList<Student> getStudentsByCourse(Course course) {
            ArrayList<Student> res = new ArrayList<>();
            for (Enrollment ce : allCE){
                if (course.getId() == ce.course.getId()){
                    res.add(ce.student);
                }
            }
            return res;
        }

        public static ArrayList<Course> getCoursesByStudent(Student student) {
            ArrayList<Course> res = new ArrayList<>();
            for (Enrollment ce : allCE){
                if (student.getId() == ce.student.getId()){
                    res.add(ce.course);
                }
            }
            return  res;
        }


        public static Enrollment getCourseEnrollment(Student st, Course c){
            for (Enrollment ce : allCE){
                if (ce.student.getId() == st.getId() && ce.course.getId() == c.getId()){
                    return ce;
                }
            }
            return new Enrollment(st, c);
        }

        public static ArrayList<Course> getCoursesByStudentId(int id) {
            ArrayList<Course> res = new ArrayList<>();
            for (Enrollment ce : allCE) {
                if (id == ce.student.getId()) {
                    res.add(ce.course);

                }
            }
            return res;
        }

        public static ArrayList<Student> getStudentsByCourseId(int id) {
            ArrayList<Student> res = new ArrayList<>();
            for (Enrollment ce : allCE) {
                if (id == ce.course.getId()) {
                    res.add(ce.student);

                }
            }
            return res;
        }

        public int getId() {
            return id;
        }
        public static Enrollment getEnrollment(Student st, Course c) {
            for (Enrollment ce: allCE) {
                if (ce.student.getId() == st.getId() && ce.course.getId() == c.getId()) {
                    return ce;
                }
            }
            return new Enrollment(st, c);
        }
        public static void remove(int id) {
            allCE.removeIf(ce -> ce.id == id);
        }
        public static void removeByStudentId(int id) {
            HashSet<Enrollment> toRemove =  new HashSet<>();
            for (Enrollment ce : allCE) {
                if (id == ce.student.getId()) {
                    toRemove.add(ce);
                    Repository.deleteEnrollment(ce.getId());
                }
            }
            allCE.removeAll(toRemove);
        }
    public static void removeByCourseId(int id) {
        HashSet<Enrollment> toRemove = new HashSet<>();
        for (Enrollment ce : allCE) {
            if (id == ce.course.getId()) {
                toRemove.add(ce);
                Repository.deleteEnrollment(ce.getId());
            }
        }
        allCE.removeAll(toRemove);
    }
    }
