import java.util.*;
class Example {
	public static Scanner input = new Scanner(System.in);
    public static String[] studentId = new String[0];
    public static String[] studentName = new String[0];
    public static int[] prfMarks = new int[0];
    public static int[] dbmsMarks = new int[0];

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public final static void homePage() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "|                                                         WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                                                                    |");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.print(
                "[1] Add New Student                                                                [2]  Add New Student with Marks\n");
        System.out.print(
                "[3] Add Marks                                                                      [4]  Update Student Details\n");
        System.out.print(
                "[5] Update Marks                                                                   [6]  Delete Student\n");
        System.out.print(
                "[7] Print Student Details                                                          [8]  Print Student Ranks\n");
        System.out.print(
                "[9] Best in Programing Fundamentals                                                [10] Best in Database Management System\n");
        System.out.println();
        System.out.println();
        System.out.print("Enter an option to continue > ");
    }

    public static void addNewStudent() {
        Scanner input = new Scanner(System.in);
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "|                                                                       ADD NEW STUDENT                                                                              |");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        String addMore;
        boolean continueLoop = false;
        do {
            // student id values add to temp array and add insert value to temp array last
            // eliment and temp array copy to student id array
            System.out.println();
            System.out.print("Enter Student ID : ");
            String id = input.nextLine();
            String[] tempStudentId = new String[studentId.length + 1];
            boolean notDuplicateId = true;
            for (int i = 0; i < studentId.length; i++) {
                if (studentId[i].equals(id)) {
                    System.out.println("The Student ID already exists");
                    notDuplicateId = false;
                    continueLoop = true;
                }
                tempStudentId[i] = studentId[i];
            }
            if (notDuplicateId) {
                tempStudentId[tempStudentId.length - 1] = id;
                studentId = tempStudentId;
                // student name values add to temp array and add new insert name value to temp
                // array last eliment and temp array copy to student name array
                System.out.print("Enter Student Name : ");
                String name = input.nextLine();
                System.out.println();
                String[] tempStudentName = new String[studentName.length + 1];
                int[] tempPrf = new int[prfMarks.length + 1];
                int[] tempDbms = new int[dbmsMarks.length + 1];
                for (int j = 0; j < studentName.length; j++) {
                    tempStudentName[j] = studentName[j];
                    tempPrf[j] = prfMarks[j];
                    tempDbms[j] = dbmsMarks[j];
                }
                tempStudentName[tempStudentName.length - 1] = name;
                tempPrf[tempPrf.length - 1] = -1;
                tempDbms[tempDbms.length - 1] = -1;
                studentName = tempStudentName;
                prfMarks = tempPrf;
                dbmsMarks = tempDbms;
                boolean invalidInput = true;
                do {
                    System.out.print("Student has been added successfully. Do you want to add a new student (Y/N): ");
                    addMore = input.nextLine();
                    if (addMore.equalsIgnoreCase("Y") || addMore.equalsIgnoreCase("N")) {
                        invalidInput = false;
                        if (addMore.equalsIgnoreCase("Y")) {
                            continueLoop = true;
                        } else {
                            continueLoop = false;
                            clearConsole();
                            homePage();
                        }
                    } else {
                        invalidInput = true;
                        System.out.println("You added value is invalid please insert again");
                        System.out.println();
                    }
                } while (invalidInput);
            }
        } while (continueLoop);
    }

    public static void addStudentwithMarks() {
        Scanner input = new Scanner(System.in);
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "|                                                                    ADD NEW STUDENT WITH MARKS                                                                      |");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        String addMore;
        boolean continueLoop = false;
        do {
            int prfMark;
            int dbmsMark;
            // student id values add to temp array and add insert value to temp array last
            // eliment and temp array copy to student id array
            System.out.println();
            System.out.print("Enter Student ID : ");
            String id = input.next();
            String[] tempStudentId = new String[studentId.length + 1];
            boolean notDuplicateId = true;
            for (int i = 0; i < studentId.length; i++) {
                if (studentId[i].equals(id)) {
                    System.out.println("The Student ID already exists");
                    notDuplicateId = false;
                    continueLoop = true;
                }
                tempStudentId[i] = studentId[i];
            }
            if (notDuplicateId) {
                tempStudentId[tempStudentId.length - 1] = id;
                studentId = tempStudentId;
                // student name values add to temp array and add new insert name value to temp
                // array last eliment and temp array copy to student name array
                System.out.print("Enter Student Name : ");
                String name = input.next();
                String[] tempStudentName = new String[studentName.length + 1];
                for (int j = 0; j < studentName.length; j++) {
                    tempStudentName[j] = studentName[j];
                }
                tempStudentName[tempStudentName.length - 1] = name;
                studentName = tempStudentName;
                // student marks values add to temp array and add new insert marks value to temp
                // array last eliment and temp array copy to student mark array
                boolean invalidMarks = false;
                do {
                    invalidMarks = false;
                    System.out.print("Programming Fundamentals Marks : ");
                    prfMark = input.nextInt();
                    if (prfMark < 0 || prfMark > 100) {
                        invalidMarks = true;
                        System.out.println();
                        System.out.println("Invalid marks, please enter correct marks.");
                        System.out.println();
                    }
                } while (invalidMarks);
                do {
                    invalidMarks = false;
                    System.out.print("Database Management System Marks : ");
                    dbmsMark = input.nextInt();
                    if (dbmsMark < 0 || dbmsMark > 100) {
                        invalidMarks = true;
                        System.out.println();
                        System.out.println("Invalid marks, please enter correct marks.");
                        System.out.println();
                    }
                } while (invalidMarks);
                int[] tempPrfMarks = new int[prfMarks.length + 1];
                for (int i = 0; i < prfMarks.length; i++) {
                    tempPrfMarks[i] = prfMarks[i];
                }
                tempPrfMarks[tempPrfMarks.length - 1] = prfMark;
                prfMarks = tempPrfMarks;
                int[] tempDbmsMarks = new int[dbmsMarks.length + 1];
                for (int i = 0; i < dbmsMarks.length; i++) {
                    tempDbmsMarks[i] = dbmsMarks[i];
                }
                tempDbmsMarks[tempDbmsMarks.length - 1] = dbmsMark;
                dbmsMarks = tempDbmsMarks;
                boolean invalidInput = true;
                do {
                    System.out.print("Do you want to add a new student (Y/N)");
                    addMore = input.next();
                    if (addMore.equalsIgnoreCase("Y") || addMore.equalsIgnoreCase("N")) {
                        invalidInput = false;
                        if (addMore.equalsIgnoreCase("Y")) {
                            continueLoop = true;
                        } else {
                            continueLoop = false;
                            clearConsole();
                            homePage();
                        }
                    } else {
                        invalidInput = true;
                        System.out.println("You added value is invalid please insert again");
                        System.out.println();
                    }
                } while (invalidInput);
            }
        } while (continueLoop);
    }

    public static void addAnotherMarks() {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                        ADD MARKS                                                                                   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        String studentNo;
        String inputMore;
        String addMore;
        int prfMark;
        int dbmsMark;
        boolean invalidInput = true;
        boolean invalidMarks = false;
        boolean continueLoop = false;
        do {
            boolean studentFound = false;
            System.out.print("Enter Student ID : ");
            studentNo = input.nextLine();
            searchLoop: for (int i = 0; i < studentId.length; i++) {
                if (studentId[i].equalsIgnoreCase(studentNo)) {
                    studentFound = true;
                    System.out.println("Studnt Name : " + studentName[i]);
                    if (!(prfMarks[i] == -1 && dbmsMarks[i] == -1)) {
                        System.out.println("This student's marks have been already added.");
                        System.out.println("If you want to update marks, please use [4] Update Marks option.");
                        break searchLoop;
                    } else {
                        do {
                            invalidMarks = false;
                            System.out.print("Programming Fundamentals Marks : ");
                            prfMark = input.nextInt();
                            input.nextLine();
                            if (prfMark < 0 || prfMark > 100) {
                                invalidMarks = true;
                                System.out.println();
                                System.out.println("Invalid marks, please enter correct marks.");
                                System.out.println();
                            } else {
                                prfMarks[i] = prfMark;
                            }
                        } while (invalidMarks);

                        do {
                            invalidMarks = false;
                            System.out.print("Database Management System Marks : ");
                            dbmsMark = input.nextInt();
                            input.nextLine();
                            if (dbmsMark < 0 || dbmsMark > 100) {
                                invalidMarks = true;
                                System.out.println();
                                System.out.println("Invalid marks, please enter correct marks.");
                                System.out.println();
                            } else {
                                dbmsMarks[i] = dbmsMark;
                            }

                        } while (invalidMarks);
                        break searchLoop;
                    }
                }
            }
            if (!studentFound) {
                do {
                    System.out.print("Invalid Student ID. Do you want to search again ? (Y/N) ");
                    addMore = input.nextLine();
                    if (addMore.equalsIgnoreCase("Y") || addMore.equalsIgnoreCase("N")) {
                        invalidInput = false;
                        if (addMore.equalsIgnoreCase("Y")) {
                            continueLoop = true;
                        } else {
                            continueLoop = false;
                            clearConsole();
                            homePage();
                            break;
                        }
                    } else {
                        System.out.println("You added value is invalid please insert again");
                        System.out.println();
                        invalidInput = true;
                    }
                } while (invalidInput);

            } else {
                do {
                    System.out.print("Do you want to add marks for another student (Y/N): ");
                    inputMore = input.nextLine();
                    if (inputMore.equalsIgnoreCase("Y") || inputMore.equalsIgnoreCase("N")) {
                        invalidInput = false;
                        if (inputMore.equalsIgnoreCase("Y")) {
                            continueLoop = true;
                        } else {
                            continueLoop = false;
                            clearConsole();
                            homePage();
                            break;
                        }
                    } else {
                        invalidInput = true;
                        System.out.println("You added value is invalid please insert again");
                        System.out.println();
                        continue;
                    }
                } while (invalidInput);
            }

        } while (continueLoop);
    }

    public static void updateStudentDetails() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "|                                                                   UPDATE STUDENT DETAILS                                                                           |");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        String studentNo;
        String inputMore;
        boolean continueLoop = false;
        boolean invalidInput = true;
        do {
            boolean studentFound = false;
            System.out.print("Enter Student ID : ");
            studentNo = input.next();
            for (int i = 0; i < studentId.length; i++) {
                if (studentId[i].equals(studentNo)) {
                    System.out.println("Studnt Name : " + studentName[i]);
                    System.out.print("Enter the new student name : ");
                    studentName[i] = input.next();
                    System.out.println("Student details has been updated successfuly.");
                    studentFound = true;
                    break;
                }
            }
            if (studentFound) {
                do {
                    System.out.print("Do you want to update details for another student (Y/N): ");
                    inputMore = input.next();
                    if (inputMore.equalsIgnoreCase("Y") || inputMore.equalsIgnoreCase("N")) {
                        invalidInput = false;
                        if (inputMore.equalsIgnoreCase("Y")) {
                            continueLoop = true;
                        } else {
                            continueLoop = false;
                            clearConsole();
                            homePage();
                            break;
                        }
                    } else {
                        invalidInput = true;
                        System.out.println("You added value is invalid please insert again");
                        System.out.println();
                        continue;
                    }
                } while (invalidInput);
            } else {
                System.out.println("You search student id is invalid");
                do {
                    System.out.print("Do you want to update the another student details (Y/N) : ");
                    inputMore = input.next();
                    if (inputMore.equalsIgnoreCase("Y") || inputMore.equalsIgnoreCase("N")) {
                        invalidInput = false;
                        if (inputMore.equalsIgnoreCase("Y")) {
                            continueLoop = true;
                        } else {
                            continueLoop = false;
                            clearConsole();
                            homePage();
                            break;
                        }
                    } else {
                        invalidInput = true;
                        System.out.println("You added value is invalid please insert again");
                        System.out.println();
                    }
                } while (invalidInput);
            }

        } while (continueLoop);
    }

    public static void updateMarks() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "|                                                                          UPDATE MARKS                                                                              |");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        String studentNo;
        String inputMore;
        int indexOfStd = 0;
        int prfMark;
        int dbmsMark;
        int i = 0;
        boolean continueLoop = false;
        boolean invalidInput = true;
        boolean idFound = false;
        L1: do {
            System.out.print("Enter Student ID : ");
            studentNo = input.next();
            for (i = 0; i < studentId.length; i++) {
                if (studentId[i].equals(studentNo)) {
                    idFound = true;
                    indexOfStd = i;
                    System.out.println("Studnt Name : " + studentName[i]);
                    System.out.println("Programming Fundamentals Marks : " + prfMarks[i]);
                    System.out.println("Database Management System Marks : " + dbmsMarks[i]);
                    break;
                } else {
                    idFound = false;
                }
            }
            if (idFound) {
                if (prfMarks[indexOfStd] > 0) {
                    System.out.print("Enter new Programming Fundamentals Marks : ");
                    prfMarks[indexOfStd] = input.nextInt();
                    System.out.print("Enter new Database Management System Marks : ");
                    dbmsMarks[indexOfStd] = input.nextInt();
                    System.out.print("Marks have been updated successfuly.");
                    System.out.print("Do you want to update the marks of another student (Y/N)");
                } else {
                    System.out.println("This student's marks yet to be added.");
                    do {
                        System.out.print("Do you want to update the marks of another student (Y/N) : ");
                        inputMore = input.next();
                        if (inputMore.equalsIgnoreCase("Y") || inputMore.equalsIgnoreCase("N")) {
                            invalidInput = false;
                            if (inputMore.equalsIgnoreCase("Y")) {
                                continue L1;
                            } else {
                                continueLoop = false;
                                clearConsole();
                                homePage();
                                break L1;
                            }
                        } else {
                            invalidInput = true;
                            System.out.println("You added value is invalid please insert again");
                            System.out.println();
                        }
                    } while (invalidInput);
                }
                inputMore = input.next();
                if (inputMore.equalsIgnoreCase("Y") || inputMore.equalsIgnoreCase("N")) {
                    invalidInput = false;
                    if (inputMore.equalsIgnoreCase("Y")) {
                        continueLoop = true;
                    } else {
                        continueLoop = false;
                        clearConsole();
                        homePage();
                        break L1;
                    }
                } else {
                    invalidInput = true;
                    System.out.println("You added value is invalid please insert again");
                    System.out.println();
                }
            } else {
                do {
                    System.out.print("invalid student ID. Do you want to search again? (Y/N) : ");
                    inputMore = input.next();
                    if (inputMore.equalsIgnoreCase("Y") || inputMore.equalsIgnoreCase("N")) {
                        invalidInput = false;
                        if (inputMore.equalsIgnoreCase("Y")) {
                            continue L1;
                        } else {
                            continueLoop = false;
                            clearConsole();
                            homePage();
                            break L1;
                        }
                    } else {
                        invalidInput = true;
                        System.out.println("You added value is invalid please insert again");
                        System.out.println();
                    }
                } while (invalidInput);
            }

        } while (true);
    }

    public static void deleteStudent() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                DELETE STUDENT                                                                                     |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        String studentNo;
        String inputMore;
        String addMore;
        boolean continueLoop = false;
        boolean invalidInput = true;
        int deleteElementId = -1;
        String[] tempStudentId = new String[studentId.length - 1];
        String[] tempStudentName = new String[studentName.length - 1];
        int[] tempPrfMarks = new int[prfMarks.length - 1];
        int[] tempDbmsMarks = new int[dbmsMarks.length - 1];

        do {
            boolean studentFound = false;
            System.out.print("Enter Student ID : ");
            studentNo = input.nextLine();
            for (int i = 0; i < studentId.length; i++) {
                if (studentId[i].equals(studentNo)) {
                    studentFound = true;
                    deleteElementId = i;
                    break;
                }
            }
            if (studentFound) {
                for (int i = 0, k = 0; i < studentId.length; i++) {
                    if (i == deleteElementId) {
                        continue;
                    }
                    tempStudentId[k] = studentId[i];
                    tempStudentName[k] = studentName[i];
                    tempPrfMarks[k] = prfMarks[i];
                    tempDbmsMarks[k] = dbmsMarks[i];
                    k++;
                }
                studentId = tempStudentId;
                studentName = tempStudentName;
                prfMarks = tempPrfMarks;
                dbmsMarks = tempDbmsMarks;
                System.out.println("Student has been deleted successfully.");
            }
            if (!studentFound) {
                do {
                    System.out.print("Invalid Student ID. Do you want to search again ? (Y/N) ");
                    addMore = input.nextLine();
                    if (addMore.equalsIgnoreCase("Y") || addMore.equalsIgnoreCase("N")) {
                        invalidInput = false;
                        if (addMore.equalsIgnoreCase("Y")) {
                            continueLoop = true;
                        } else {
                            continueLoop = false;
                            clearConsole();
                            homePage();
                            break;
                        }
                    } else {
                        System.out.println("You added value is invalid please insert again");
                        System.out.println();
                        invalidInput = true;
                    }
                } while (invalidInput);

            } else {
                do {
                    System.out.print("Do you want to delete another student (Y/N): ");
                    inputMore = input.nextLine();
                    if (inputMore.equalsIgnoreCase("Y") || inputMore.equalsIgnoreCase("N")) {
                        invalidInput = false;
                        if (inputMore.equalsIgnoreCase("Y")) {
                            continueLoop = true;
                        } else {
                            continueLoop = false;
                            clearConsole();
                            homePage();
                            break;
                        }
                    } else {
                        invalidInput = true;
                        System.out.println("You added value is invalid please insert again");
                        System.out.println();
                        continue;
                    }
                } while (invalidInput);
            }
        } while (continueLoop);
    }

    public static void printStudentDetails() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                            PRINT STUDENT DETAILS                                                                                   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        String studentNo;
        String inputMore;
        String addMore;
        int indexOfStd = 0;
        int prfMark;
        int dbmsMark;
        int i = 0;
        boolean invalidInput = true;
        boolean invalidMarks = false;
        boolean continueLoop = false;
        boolean idFound = false;
        L1: do {
            boolean studentFound = false;
            System.out.print("Enter Student ID : ");
            studentNo = input.next();
            for (i = 0; i < studentId.length; i++) {
                if (studentId[i].equals(studentNo)) {
                    studentFound = true;
                    indexOfStd = i;
                    System.out.println("Studnt Name : " + studentName[i]);
                    break;
                } else {
                    studentFound = false;
                }
            }
            if (studentFound) {
                if (prfMarks[indexOfStd] > 0) {
                    System.out.println("+---------------------------------------+-----------+");
                    System.out.print("| Programing Fundamentals Marks		| ");
                    System.out.printf("%10d|\n", prfMarks[i]);
                    System.out.print("| Database Management System Marks	| ");
                    System.out.printf("%10d|\n", dbmsMarks[i]);
                    System.out.print("| Total Marks				| ");
                    System.out.printf("%10d|\n", (prfMarks[i] + dbmsMarks[i]));
                    System.out.print("| Avg. Marks				| ");
                    System.out.printf("%10.2f|\n", (double) (prfMarks[i] + dbmsMarks[i]) / 2);
                    System.out.print("| Rank					| ");
                    int[] total = new int[prfMarks.length];
                    for (int k = 0; k < total.length; k++) {
                        total[k] = (prfMarks[k] + dbmsMarks[k]);
                    }
                    for (int j = 0; j < total.length; j++) {
                        for (int p = j + 1; p < total.length; p++) {
                            if (total[j] < total[p]) {
                                int temp = total[j];
                                total[j] = total[p];
                                total[p] = temp;
                            }
                        }
                    }
                    int rankNum = 0;
                    L2: for (int p = 0; p < total.length; p++) {
                        if ((prfMarks[i] + dbmsMarks[i]) == total[p]) {
                            rankNum = p;
                            break L2;
                        }
                    }
                    System.out.printf("%10d|\n", rankNum + 1);
                    System.out.println("+---------------------------------------+-----------+");
                    do {
                        System.out.print("Do you want to print details for another student (Y/N): ");
                        inputMore = input.next();
                        if (inputMore.equalsIgnoreCase("Y") || inputMore.equalsIgnoreCase("N")) {
                            invalidInput = false;
                            if (inputMore.equalsIgnoreCase("Y")) {
                                continueLoop = true;
                            } else {
                                continueLoop = false;
                                clearConsole();
                                homePage();
                                break;
                            }
                        } else {
                            invalidInput = true;
                            System.out.println("You added value is invalid please insert again");
                            System.out.println();
                            continue;
                        }
                    } while (invalidInput);
                } else {
                    System.out.print("Marks need to be added. Do you want to search another (Y/N)");
                    inputMore = input.next();
                    if (inputMore.equalsIgnoreCase("Y") || inputMore.equalsIgnoreCase("N")) {
                        invalidInput = false;
                        if (inputMore.equalsIgnoreCase("Y")) {
                            continue L1;
                        } else {
                            continueLoop = false;
                            clearConsole();
                            homePage();
                            break L1;
                        }
                    } else {
                        invalidInput = true;
                        System.out.println("You added value is invalid please insert again");
                        System.out.println();
                    }
                }
            }
            else{
                do {
                    System.out.print("Invalid Student ID. Do you want to search again ? (Y/N) ");
                    addMore = input.next();
                    if (addMore.equalsIgnoreCase("Y") || addMore.equalsIgnoreCase("N")) {
                        invalidInput = false;
                        if (addMore.equalsIgnoreCase("Y")) {
                            continueLoop = true;
                        } else {
                            continueLoop = false;
                            clearConsole();
                            homePage();
                            break;
                        }
                    } else {
                        System.out.println("You added value is invalid please insert again");
                        System.out.println();
                        invalidInput = true;
                    }
                } while (invalidInput);
            }
        } while (continueLoop);
    }

    public static void printStudentRank() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                         PRINT STUDENTS' RANK                                                                                       |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        String inputMore;
        String addMore;
        boolean invalidInput = true;
        boolean invalidMarks = false;
        boolean continueLoop = false;
        int[] total = new int[prfMarks.length];
        String[] tempStudentId = new String[studentId.length];
        String[] tempStudentName = new String[studentName.length];
        tempStudentId = studentId;
        tempStudentName = studentName;
        do {
            for (int i = 0; i < total.length; i++) {
                total[i] = (prfMarks[i] + dbmsMarks[i]);
            }
            for (int i = 0; i < total.length; i++) {
                for (int k = i + 1; k < total.length; k++) {
                    if (total[i] < total[k]) {
                        int temp = total[i];
                        total[i] = total[k];
                        total[k] = temp;
                        // ----------------------------------
                        String temp2 = tempStudentId[i];
                        tempStudentId[i] = tempStudentId[k];
                        tempStudentId[k] = temp2;
                        // ----------------------------------
                        String temp3 = tempStudentName[i];
                        tempStudentName[i] = tempStudentName[k];
                        tempStudentName[k] = temp3;
                    }
                }
            }
            int[] rank = new int[total.length];
            for (int i = 0; i < rank.length; i++) {
                rank[i] = i + 1;
            }
            System.out.println("+-------+-------+-----------------------+------+------+");
            System.out.println("|Rank\t|Id\t|Name\t\t\t|Total | Avg  |");
            System.out.println("+-------+-------+-----------------------+------+------+");
            L1: for (int i = 0; i < studentId.length; i++) {
                if (0 > total[i]) {
                    continue L1;
                } else {
                    double avg = (double) total[i] / 2;
                    System.out.printf("|%-7d|%-7s|%-23s|%-6d|%6.2f|\n", rank[i], tempStudentId[i], tempStudentName[i],
                            total[i], avg);
                }
            }
            System.out.println("+-------+-------+-----------------------+------+------+\n");
            do {
                System.out.print("Do you want to go back to main menu? (Y/N) : ");
                inputMore = input.next();
                if (inputMore.equalsIgnoreCase("Y") || inputMore.equalsIgnoreCase("N")) {
                    invalidInput = false;
                    if (inputMore.equalsIgnoreCase("N")) {
                        // continueLoop = true;
                        printStudentRank();
                    } else {
                        continueLoop = false;
                        clearConsole();
                        homePage();
                        break;
                    }
                } else {
                    invalidInput = true;
                    System.out.println("You added value is invalid please insert again");
                    System.out.println();
                    continue;
                }
            } while (invalidInput);
        } while (continueLoop);
    }

    public static void bestinPRF() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                   BEST IN PROGRAMMING FUNDAMENTALS                                                                 |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        String inputMore;
        String addMore;
        int[] tempPrfMarks = new int[prfMarks.length];
        int[] tempDbmsMarks = new int[dbmsMarks.length];
        String[] tempStudentId = new String[studentId.length];
        String[] tempStudentName = new String[studentName.length];
        boolean invalidInput = true;
        boolean invalidMarks = false;
        boolean continueLoop = false;
        tempPrfMarks = prfMarks;
        tempDbmsMarks = dbmsMarks;
        tempStudentId = studentId;
        tempStudentName = studentName;
        do {
            for (int i = 0; i < tempPrfMarks.length; i++) {
                for (int k = i + 1; k < tempPrfMarks.length; k++) {
                    if (tempPrfMarks[i] < tempPrfMarks[k]) {
                        int temp = tempPrfMarks[i];
                        tempPrfMarks[i] = tempPrfMarks[k];
                        tempPrfMarks[k] = temp;
                        // ----------------------------------
                        int temp1 = tempDbmsMarks[i];
                        tempDbmsMarks[i] = tempDbmsMarks[k];
                        tempDbmsMarks[k] = temp1;
                        // ----------------------------------
                        String temp2 = tempStudentId[i];
                        tempStudentId[i] = tempStudentId[k];
                        tempStudentId[k] = temp2;
                        // ----------------------------------
                        String temp3 = tempStudentName[i];
                        tempStudentName[i] = tempStudentName[k];
                        tempStudentName[k] = temp3;
                    }
                }
            }
            System.out.println("+-------+-----------------------+---------+-----------+");
            System.out.println("|ID\t|Name\t\t\t|Pf Marks |DBMS Marks |");
            System.out.println("+-------+-----------------------+---------+-----------+");
            L1: for (int i = 0; i < studentId.length; i++) {
                if (tempPrfMarks[i] == -1) {
                    continue L1;
                } else {
                    System.out.printf("|%-7s|%-23s|%-9d|%-11d|\n", tempStudentId[i], tempStudentName[i],
                            tempPrfMarks[i], tempDbmsMarks[i]);
                }
            }
            System.out.println("+-------+-----------------------+---------+-----------+\n");
            do {
                System.out.print("Do you want to go back to main menu? (Y/N) : ");
                inputMore = input.nextLine();
                if (inputMore.equalsIgnoreCase("Y") || inputMore.equalsIgnoreCase("N")) {
                    invalidInput = false;
                    if (inputMore.equalsIgnoreCase("N")) {
                        // continueLoop = true;
                        printStudentRank();
                    } else {
                        continueLoop = false;
                        clearConsole();
                        homePage();
                        break;
                    }
                } else {
                    invalidInput = true;
                    System.out.println("You added value is invalid please insert again");
                    System.out.println();
                    continue;
                }
            } while (invalidInput);
        } while (continueLoop);
    }

    public static void bestinDMS() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                   BEST IN DATABASE MANAGEMENT SYSTEM                                                                               |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        boolean invalidInput = true;
        boolean invalidMarks = false;
        boolean continueLoop = false;
        do {
            int[] tempPrfMarks = new int[prfMarks.length];
            int[] tempDbmsMarks = new int[dbmsMarks.length];
            String[] tempStudentId = new String[studentId.length];
            String[] tempStudentName = new String[studentName.length];
            String inputMore;
            String addMore;
            tempPrfMarks = prfMarks;
            tempDbmsMarks = dbmsMarks;
            tempStudentId = studentId;
            tempStudentName = studentName;
            for (int i = 0; i < tempDbmsMarks.length; i++) {
                for (int k = i + 1; k < tempDbmsMarks.length; k++) {
                    if (tempDbmsMarks[i] < tempDbmsMarks[k]) {
                        int temp1 = tempDbmsMarks[i];
                        tempDbmsMarks[i] = tempDbmsMarks[k];
                        tempDbmsMarks[k] = temp1;
                        // ----------------------------------
                        int temp = tempPrfMarks[i];
                        tempPrfMarks[i] = tempPrfMarks[k];
                        tempPrfMarks[k] = temp;
                        // ----------------------------------
                        String temp2 = tempStudentId[i];
                        tempStudentId[i] = tempStudentId[k];
                        tempStudentId[k] = temp2;
                        // ----------------------------------
                        String temp3 = tempStudentName[i];
                        tempStudentName[i] = tempStudentName[k];
                        tempStudentName[k] = temp3;
                    }
                }
            }
            System.out.println("+-------+-----------------------+----------+-----------+");
            System.out.println("|ID\t|Name\t\t\t|DBMS Marks|Pf Marks   |");
            System.out.println("+-------+-----------------------+----------+-----------+");
            L2: for (int i = 0; i < studentId.length; i++) {
                if (tempPrfMarks[i] == -1) {
                    continue L2;
                } else {
                    System.out.printf("|%-7s|%-23s|%-10d|%-11d|\n", tempStudentId[i], tempStudentName[i],
                            tempDbmsMarks[i], tempPrfMarks[i]);
                }
            }
            System.out.println("+-------+-----------------------+----------+-----------+\n");
            do {
                System.out.print("Do you want to go back to main menu? (Y/N) : ");
                inputMore = input.nextLine();
                if (inputMore.equalsIgnoreCase("Y") || inputMore.equalsIgnoreCase("N")) {
                    invalidInput = false;
                    if (inputMore.equalsIgnoreCase("N")) {
                        // continueLoop = true;
                        printStudentRank();
                    } else {
                        continueLoop = false;
                        clearConsole();
                        homePage();
                        break;
                    }
                } else {
                    invalidInput = true;
                    System.out.println("You added value is invalid please insert again");
                    System.out.println();
                    continue;
                }
            } while (invalidInput);
        } while (continueLoop);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        homePage();
        do {
            int option = input.nextInt();
            switch (option) {
                case 1:
                    clearConsole();
                    addNewStudent();
                    break;
                case 2:
                    clearConsole();
                    addStudentwithMarks();
                    break;
                case 3:
                    clearConsole();
                    addAnotherMarks();
                    break;
                case 4:
                    clearConsole();
                    updateStudentDetails();
                    break;
                case 5:
                    clearConsole();
                    updateMarks();
                    break;
                case 6:
                    clearConsole();
                    deleteStudent();
                    break;
                case 7:
                    clearConsole();
                    printStudentDetails();
                    break;
                case 8:
                    clearConsole();
                    printStudentRank();
                    break;
                case 9:
                    clearConsole();
                    bestinPRF();
                    break;
                case 10:
                    clearConsole();
                    bestinDMS();
                    break;
                default:
                    clearConsole();
                    homePage();
            }
        } while (true);
    }
}
