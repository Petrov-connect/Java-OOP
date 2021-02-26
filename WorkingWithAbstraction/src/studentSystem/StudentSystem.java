package studentSystem;
//created by J.M.

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {

    private final Map<String, Student> studentsInfo;

    public StudentSystem() {
        this.studentsInfo = new HashMap<>();
    }

    public Map<String, Student> getStudentsInfo() {
        return this.studentsInfo;
    }

    public String parseCommand(String[] input) {

        if ("Create".equals(input[0]) && !studentsInfo.containsKey(input[1])) {
            studentsInfo.put(input[1], new Student(input));
        } else if ("Show".equals(input[0]) && getStudentsInfo().containsKey(input[1])) {
            return studentsInfo.get(input[1]).toString();
        }
        return null;
    }
}

