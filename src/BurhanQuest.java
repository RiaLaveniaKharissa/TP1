import java.util.Scanner;

public class BurhanQuest {
    // Banner pembuka, silakan manfaatkan variabel ini untuk menampilkan banner di awal dan di akhir program
    private static final String BANNER = "╔═════════════════════════════════════════════════════════╗\n" + //
                "║                                                         ║\n" + //
                "║     _____         _           _____             _       ║\n" + //
                "║    | __  |_ _ ___| |_ ___ ___|     |_ _ ___ ___| |_     ║\n" + //
                "║    | __ -| | |  _|   | .'|   |  |  | | | -_|_ -|  _|    ║\n" + //
                "║    |_____|___|_| |_|_|__,|_|_|__  _|___|___|___|_|      ║\n" + //
                "║                                 |__|                    ║\n" + //
                "║                                                         ║\n" + //
                "╚═════════════════════════════════════════════════════════╝";
    private static final String STUDENT_NAME = "Ria Lavenia Kharissa";
    private static final String STUDENT_ID = "2506543905";


    // Penanda atribut, silakan manfaatkan variabel ini untuk menandai atribut di dalam data
    // Atribut yang sama
    private static final char NAME_IDENTIFIER = '!';
    private static final char STATUS_IDENTIFIER = '@';
    private static final char EXP_IDENTIFIER = '#';

    // Atribut khusus quest
    private static int questId = 1;
    private static final char REWARD_IDENTIFIER = '$';
    private static final char DESC_IDENTIFIER = '%';
    private static final char DIFFICULTY_IDENTIFIER = '^';

    // Atribut khusus pengembara
    private static int travelerId = 1;
    private static final char LEVEL_IDENTIFIER = '$';

    private static final int MAX_EXP = 1_310_720_000;

    // Scanner untuk input, silakan manfaatkan variabel ini untuk mengambil input dari user
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // TODO: Tampilkan banner
        System.out.println(BANNER);
        System.out.println("Selamat datang di BurhanQuest!");
        System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID);
        System.out.println("Mari kita mulai dengan membuat sejumlah data quest dan pengembara.");

        // TODO: Seeding data quest dan pengembara
        int questCount =0, travelerCount=0;
        boolean invalidInput = true;

        // TODO: Input banyak quest dan pengembara
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak quest yang ingin didaftarkan: ");
            String questCountInput = input.nextLine();
            
            // TODO: Validasi input jumlah quest
            boolean isAllDigits = !questCountInput.isEmpty();
            if(isAllDigits){
                for(int i = 0; i< questCountInput.length(); i++){
                    if(!Character.isDigit(questCountInput.charAt(i))){
                        System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
                        isAllDigits = false;
                        break;
                    }
                }
            }
            if(isAllDigits){
                Scanner konverter = new Scanner(questCountInput);
                questCount = konverter.nextInt();
                invalidInput = false;
            }

        }
        
        // TODO: Input jumlah pengembara
        invalidInput = true;
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak pengembara yang ingin didaftarkan: ");
            String travelerCountInput = input.nextLine();
            // TODO: Validasi input jumlah pengembara
            if(travelerCountInput.matches("^\\d+$")){
                Scanner konverter =new Scanner(travelerCountInput);
                travelerCount = konverter.nextInt();
                invalidInput = false;
                continue;
            }
            System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
        }
        System.out.println();

        String questData = "";
        String travelerData = "";
        System.out.println("Mulai memasukkan data quest.");
        // TODO: Input data quest sebanyak quest yang diminta
        for (int i = 0; i < questCount; i++) {
            boolean isInputValid = false;
            while(!isInputValid){

                // input nama(hanya boleh alfanumerik dan spasi)
                System.out.println("Quest "+ (i+1));
                System.out.print("Masukkan nama quest: ");
                String nama = input.nextLine();
    
                //deskripsi hanya boleh alfanumerik dan spasi
                System.out.print("Masukkan deskripsi quest: ");
                String  deskripsi = input.nextLine();
    
                // reward hanya boleh bilangan bulat nonnegatif
                System.out.print("Masukkan reward quest berupa bilangan bulat nonnegatif: ");
                String rewardStrng = input.nextLine();
    
                //bonus exp hanya boleh bilangan bulat nonnegatif
                System.out.print("Masukkan bonus exp quest berupa bilangan bulat nonnegatif: ");
                String bonusExp = input.nextLine();
    
                //tingkat kesulitan hanya boleh mudah, menengah, sulit. sifatnya ignore case
                System.out.print("Masukkan tingkat kesulitan quest (opsi: mudah, menengah, sulit): ");
                String tingkatKesulitan = input.nextLine();
    
                boolean namaValid = nama.trim().matches("^[a-zA-Z0-9 ]+$");
                boolean deskripsiValid = deskripsi.trim().matches("^[a-zA-Z0-9 ]+$");
                boolean rewardValid= rewardStrng.trim().matches("^\\d+$");  
                boolean bonusValid= bonusExp.trim().matches("^\\d+$");
                boolean kesulitanValid= tingkatKesulitan.trim().matches("(?i)^(mudah|menengah|sulit)$");
                
                String bintang = "";
                switch(tingkatKesulitan.trim().toLowerCase()){
                    case "mudah":
                        bintang = "\u2605";
                        break;
                    case "menengah":
                        bintang = "\u2605\u2605";
                        break;
                    case "sulit":
                        bintang = "\u2605\u2605\u2605";
                        break;
                }

    
                if(namaValid && deskripsiValid && rewardValid && bonusValid && kesulitanValid){
                    questData += "Q"+ (questId++)+NAME_IDENTIFIER + nama.trim() + DESC_IDENTIFIER + deskripsi.trim()+
                    REWARD_IDENTIFIER + rewardStrng.trim() + EXP_IDENTIFIER + bonusExp.trim() + DIFFICULTY_IDENTIFIER + tingkatKesulitan.trim().toLowerCase()+ bintang+
                    STATUS_IDENTIFIER +"tersedia \ud83d\udfe2" + "\n"; 
                    System.out.println("Quest berhasil ditambahkan");
                    isInputValid = true;
                }else{
                    System.out.println("Input tidak valid. Harap masukkan data dengan benar");
                }
                

            }


            
        }
        System.out.println();

        System.out.println("Mulai memasukkan data pengembara.");
        // TODO: Input data pengembara sebanyak pengembara yang diminta
        for (int i = 0; i < travelerCount; i++) {
            boolean isInputValid = false;
            while(!isInputValid){
                System.out.println("Pengembara "+ (i+1));
                // nama hanya boleh alfanumerik dan spasi
                System.out.print("Masukkan nama pengembara: ");
                String namaTraveler = input.nextLine();

                //level hanya boleh pada rentang [1-20]
                System.out.print("Masukkan level pengembara berupa bilangan bulat [1,20]: ");
                String levelTraveler = input.nextLine();
                int levelAngka = 0;

                boolean namaTravelerValid = namaTraveler.trim().matches("^[a-zA-Z0-9 ]+$");
                boolean levelTravelerValid = false;
                if(levelTraveler.trim().matches("^\\d+$")){
                    levelAngka = Integer.parseInt(levelTraveler);
                    if(levelAngka>=1 && levelAngka<=20){
                        levelTravelerValid = true;
                    }
                }
                long nilaiExp =0;
                if(namaTravelerValid && levelTravelerValid){
                    if(levelAngka>1){
                        nilaiExp = (long) (500 * Math.pow(2, levelAngka-2));
                    }
                    travelerData += "P" + (travelerId++)  + NAME_IDENTIFIER + namaTraveler+
                    LEVEL_IDENTIFIER + levelTraveler +EXP_IDENTIFIER+ nilaiExp+ STATUS_IDENTIFIER + "kosong  \u2705" +"\n";
                    isInputValid= true;
                    
                }else{
                    System.out.println("Input tidak valid. Harap masukkan data dengan benar");
                }
              
                
        }

        System.out.println("Data berhasil dimasukkan.");
        System.out.println();

        boolean running = true;
        // TODO: Loop menu utama
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Lihat daftar quest");
            System.out.println("2. Lihat daftar pengembara");
            System.out.println("3. Tambah quest");
            System.out.println("4. Tambah pengembara");
            System.out.println("5. Menjalankan quest");
            System.out.println("6. Menyelesaikan quest");
            System.out.println("7. Filter daftar quest");
            System.out.println("8. Filter daftar pengembara");
            System.out.println("9.Tampilkan daftar quest terurut");
            System.out.println("10.Tampilkan daftar pengembara terurut");
            System.out.println("11. Keluar");
            System.out.print("Masukkan pilihan: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    // TODO: Tampilkan daftar quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "2":
                    // TODO: Tampilkan daftar pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "3":
                    // TODO: Tambah quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "4":
                    // TODO: Tambah pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "5":
                    // TODO: Menjalankan quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "6":
                    // TODO: Menyelesaikan quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "7":
                    // TODO: Filter daftar quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "8":
                    // TODO: Filter daftar pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "9":
                    // TODO: Tampilkan daftar quest terurut
                    System.out.println("Belum diimplementasikan");
                    break;
                case "10":
                    // TODO: Tampilkan daftar pengembara terurut
                    System.out.println("Belum diimplementasikan");
                    break;
                case "11":
                    // TODO: Keluar
                    System.out.println("Terima kasih telah menggunakan BurhanQuest!");
                    System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID);
                    System.out.println(BANNER);

                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }
}
}
























