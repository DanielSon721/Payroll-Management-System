# TA Payroll Management System

## Description

This Java program simulates a payroll system for managing Teaching Assistants (TAs) in a university course setting. It supports both **regular** and **differential** courses, and manages different types of TAs, including **Undergraduate TAs (UGTAs)** and **Graduate TAs (GradTAs)**. Each TA has constraints on hours and projects worked, and receives a paycheck based on their work and employment type.

---

## Features

- TA Types:
  - `UGTA`: Paid hourly. Limited to 20 work hours per cycle.
  - `GradTA`: Paid a portion of a fixed yearly salary. Maximum of 150 graded projects.

- Course Types:
  - `ARegularCourse`: Fixed maximum number of TAs.
  - `ADifferentialCourse`: Allows unlimited TAs by resizing the TA list dynamically.

- TA Management Capabilities:
  - Add UGTAs and GradTAs to a course.
  - Log office hours and graded projects for each TA.
  - Retrieve the number of hours worked or projects graded.
  - Calculate each TA's paycheck.

- Data Structure:
  - `LarryList`: Custom list implementation used to store TA objects with support for dynamic resizing.

---

## Class Structure

| Class | Description |
|-------|-------------|
| `TA` (abstract) | Base class containing shared TA information |
| `UGTA` | Undergraduate TA with hourly wage |
| `GradTA` | Graduate TA with yearly salary |
| `ARegularCourse` | Manages a fixed number of TAs |
| `ADifferentialCourse` | Inherits from `ARegularCourse`; supports unlimited TAs |
| `LarryList` | Dynamic object list for storing TAs with TA-specific methods |
| `SomeUniversity` | Utility class to create courses (regular or differential) |

---

## Salary Calculation

- **UGTA Paycheck**  
  `Pay = (officeHours + (projectsGraded / 2)) * hourlySalary`

- **GradTA Paycheck**  
  `Pay = yearlySalary / 21`

---

## Input Validation Rules

- No duplicate TAs (same first and last name) allowed in a course.
- `UGTA`:
  - Maximum of 20 office hours per cycle.
  - Maximum graded projects: `(20 - hoursWorked) * 2`
- `GradTA`:
  - Cannot exceed 150 projects graded.
- Project grading must be in even numbers.
- Courses require a valid department name and course number (≥ 100).
- TA names must be non-null and non-empty.

---

## Limitations

- TA identification is based solely on first and last name (no unique ID).
- No persistent data storage (in-memory only).
- No user interface; must be interacted with via code (e.g., test drivers or a main method).
