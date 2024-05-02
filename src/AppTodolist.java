
public class AppTodolist {

    /*
     * Untuk menampung data todos
     */
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodo();
    }

    /*
     * Method untuk meampilkan data Todo
     */
    public static void showTodoList() {
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    /*
     * method untuk menambah todo
     */
    public static void addTodoList(String todo) {

        // mengecek jika apakah sudah full
        var isFull = true;
        for (var i = 0; i < model.length; i++) {
            // jika model isi datanya masih null maka isfull belum penuh
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }
        // jika model sudah full maka di kalikan 2
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];
            // looping panjang temp model sebelumnya di tambah data temp
            for (var i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // add todo ke data yang null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }

    }

    /*
     * method untuk menghapus todo
     */
    public static boolean removeTodoList(Integer number) {
        // jika number yang di inputkan lebih besar dari jumlah model maka false
        if ((number - 1) >= model.length) {
            return false;
            // jika number yang diiputkan dimodel tidak ada maka false
        } else if (model[number - 1] == null) {
            return false;
        } else {
            // model dengan number yang di inputkan di sett null

            // looping panjang model samapi ke index yang di hapus
            for (int i = (number - 1); i < model.length; i++) {
                // jika i sama dengan data ujung model maka model di sett null
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    // geser model ke selanjutnya
                    model[i] = model[i + 1];
                }
            }
            return true;
        }

    }

    public static String input(String label) {
        System.out.print(label + " : ");
        String data = scanner.nextLine();
        return data;
    }

    /*
     * Method tampilan list todo
     */
    public static void viewShowTodo() {
        while (true) {

            showTodoList();
            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodo();
            } else if (input.equals("2")) {
                viewRemoveTodo();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan Tidak Ada");
            }
        }
    }

    /*
     * Method tampilan add todo
     */

    public static void viewAddTodo() {
        while (true) {
            System.out.println("Tambah Todos");
            var input = input("Add Todo");
            addTodoList(input);
            break;
        }
        // showTodoList();
    }

    /*
     * Method tampilan delete todo
     */
    public static void viewRemoveTodo() {
        System.out.println("Remove Todos");
        var input = input("Hapus No");
        removeTodoList(Integer.valueOf(input));
    }

    /*
     * ==UNIT TEST MANUAL==
     */

    /*
     * Test Show Todolist
     */

    public static void testShowTodolist() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Belajar Apache Maven";
        showTodoList();
    }

    public static void testAddTodoList() {
        for (var i = 1; i < 15; i++) {
            addTodoList("Belajar Java Series ke - " + i);
        }
        showTodoList();
    }

    public static void testRemoveTodo() {
        addTodoList("Todo Satu");
        addTodoList("Todo Dua");
        addTodoList("Todo Tiga");
        addTodoList("Todo Empat");
        addTodoList("Todo Lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }
}
