/**
 * /d:/Wipro/Frontend/Day14/object.js
 *
 * Example of a parent class (Person) and a child class (Student).
 * Creates one Student object and demonstrates usage.
 */

// Parent class
class Person {
    constructor(name, age, gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    introduce() {
        return `Hi, I'm ${this.name}, ${this.age} years old.`;
    }
}

// Child class that extends Person
class Student extends Person {
    constructor(name, age, gender, studentId, course) {
        super(name, age, gender); // call parent constructor
        this.studentId = studentId;
        this.course = course;
        this.grades = []; // store numeric grades
    }

    enroll(newCourse) {
        this.course = newCourse;
    }

    addGrade(grade) {
        if (typeof grade === 'number' && grade >= 0 && grade <= 100) {
            this.grades.push(grade);
        } else {
            throw new Error('Grade must be a number between 0 and 100');
        }
    }

    getAverage() {
        if (this.grades.length === 0) return null;
        const sum = this.grades.reduce((a, b) => a + b, 0);
        return sum / this.grades.length;
    }

    toString() {
        const avg = this.getAverage();
        return `${this.introduce()} Student ID: ${this.studentId}. Course: ${this.course}.` +
                     (avg === null ? ' No grades yet.' : ` Average grade: ${avg.toFixed(2)}.`);
    }
}

// Create one Student object and demonstrate
const student1 = new Student('Alice Johnson', 20, 'female', 'S12345', 'Computer Science');

console.log(student1.toString()); // before grades

student1.addGrade(88);
student1.addGrade(92);
student1.addGrade(75);

console.log(student1.toString()); // after adding grades

// change course
student1.enroll('Software Engineering');
console.log('After enrollment change:', student1.course);