import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int nextId = 11;
    private static ArrayList<Employee> employees = new ArrayList<>();
    public static void main(String[] args) {

        // Dữ liệu của 10 nhân viên
        int[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] names = {"John", "Emma", "Michael", "Sophia", "William", "Olivia", "James", "Amelia", "Daniel", "Isabella"};
        int[] ages = {30, 28, 35, 42, 25, 39, 45, 33, 37, 29};
        String[] departments = {"HR", "IT", "Finance", "Marketing", "Operations", "Sales", "Engineering", "Legal", "Customer Service", "Research"};
        String[] codes = {"E101", "E102", "E103", "E104", "E105", "E106", "E107", "E108", "E109", "E110"};
        double[] salaryRates = {3000.0, 3500.0, 3200.0, 3800.0, 3100.0, 3400.0, 3700.0, 3300.0, 3600.0, 3900.0};

        // Khởi tạo mỗi nhân viên và thêm vào mảng employees
        for (int i = 0; i < 10; i++) {
            employees.add(new Employee(ids[i], names[i], ages[i], departments[i], codes[i], salaryRates[i]));
        }

        // Hiển thị thông tin của từng nhân viên
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1.Thêm một nhân viên");
            System.out.println("2.Xóa một nhân viên");
            System.out.println("3. Hiển thị danh sách nhân viên");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    deleteEmployee(scanner);
                    break;
                case 3:
                    showAllEmployee();
                case 4:
                    System.out.println("Đang thoát");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ .Vui lòng chọn lại.");
            }
        } while (choice != 4);

        scanner.close();
    }
    private static void addEmployee(Scanner scanner) {
        System.out.print("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Nhập phòng ban: ");
        String department = scanner.nextLine();
        System.out.print("Nhập code: ");
        String code = scanner.nextLine();
        System.out.print("Mức lương : ");
        double salaryRate = scanner.nextDouble();
        scanner.nextLine();  // consume newline

        employees.add(new Employee(nextId++, name, age, department, code, salaryRate));
        System.out.println("Thêm nhân viên thành công.");
    }
private static void showAllEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
}
    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Nhập id nhân viên mà bạn muốn xóa: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine();  // consume newline

        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getId() == idToDelete) {
                employees.remove(emp);
                found = true;
                System.out.println("Xóa nhân viên thành công.");
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy Id nhân viên hợp lệ: " + idToDelete);
        }
    }
}
