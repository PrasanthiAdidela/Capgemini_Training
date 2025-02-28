package course_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
	int student_id;
	String student_name;

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public Student(int student_id, String student_name) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
	}

	public String toString() {
		return "" + student_id + " : " + student_name;
	}

}

public class StudentManagement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Student> list = new ArrayList<>();

		while (true) {
			System.out.println("1.Add\n 2.Delete \n 3.update \n 4.display \n 5.details\n 6.Exit");
			System.out.println("Enter your choice :");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("Enter Student_Id");
				int r = sc.nextInt();
				System.out.println("Enter Student_name:");
				String t = sc.next();

				Student std = new Student(r, t);
				list.add(std);
				System.out.println(list);
				break;
			case 2:
				System.out.println("Enter StudentId you want to delete");
				int m = sc.nextInt();
				int ind = -1;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getStudent_id() == m) {
						ind = i;
						break;
					}
				}
				if (ind != -1) {
					Student deleted = list.remove(ind);
					System.out.println(deleted);
				} else {
					System.err.println("Id not present");
				}
				break;
			case 3:
				System.out.println("Enter the studentId you want to update :");
				int e = sc.nextInt();
				System.out.println("Enter the name to be updated");
				String name = sc.next();
				int indx = -1;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getStudent_id() == e) {
						indx = i;
						break;
					}
				}
				if (indx != -1) {
					list.get(indx).setStudent_name(name);
				} else {
					System.err.println("Enter valid studentid and name ");
				}
				break;
			case 4:
				System.out.println(list);
				break;
			case 5:
				System.out.println("Enter studentId to display details:");
				int a = sc.nextInt();
				int index = -1;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getStudent_id() == a) {
						index = i;
						break;
					}
				}
				if (index != -1) {
					System.out.println(list.get(index).getStudent_name());
				} else {
					System.err.println("Enter valid studentid and name ");
				}

			case 6:
				System.out.println("Exit ");
				return;
			default:
				System.out.println("Enter a valid choice :");
			}

		}
	}

}
