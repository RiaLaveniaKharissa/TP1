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
                String nama = input.nextLine().trim();
    
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
                
                // cek apakah input valid atau tidak
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
                        bintang = "\u2605 \u2605";
                        break;
                    case "sulit":
                        bintang = "\u2605 \u2605 \u2605";
                        break;
                }

    
                if(namaValid && deskripsiValid && rewardValid && bonusValid && kesulitanValid){// jika nama, deskripsi, reward, bonus, dan kesulitan valid
                    // masukkan input ke variabeel questData
                    questData += "Q"+ (questId++)+NAME_IDENTIFIER + nama.trim() + DESC_IDENTIFIER + deskripsi.trim()+
                    REWARD_IDENTIFIER + rewardStrng.trim() + EXP_IDENTIFIER + bonusExp.trim() + DIFFICULTY_IDENTIFIER+ bintang+
                    STATUS_IDENTIFIER +"tersedia \ud83d\udfe2" + "\n"; 
                    System.out.println("Quest berhasil ditambahkan\n");
                    isInputValid = true;
                }else{
                    System.out.println("Input tidak valid. Harap masukkan data dengan benar");
                }
                

            }


            
        }
        

        System.out.println("Mulai memasukkan data pengembara.");
        // TODO: Input data pengembara sebanyak pengembara yang diminta
        for (int i = 0; i < travelerCount; i++) {
            boolean isInputValid = false;
            while(!isInputValid){
                System.out.println("Pengembara "+ (i+1));
                // nama hanya boleh alfanumerik dan spasi
                System.out.print("Masukkan nama pengembara: ");
                String namaTraveler = input.nextLine().trim();

                //level hanya boleh pada rentang [1-20]
                System.out.print("Masukkan level pengembara berupa bilangan bulat [1,20]: ");
                String levelTraveler = input.nextLine();
                
                int levelAngka = 0;

                boolean namaTravelerValid = namaTraveler.trim().matches("^[a-zA-Z0-9 ]+$");// cek apakah nama traveler yang diinput valid
                boolean levelTravelerValid = false;
                if(levelTraveler.trim().matches("^\\d+$")){
                    levelAngka = Integer.parseInt(levelTraveler);// karena level traveler string, maka diubah ke int di step ini
                    if(levelAngka>=1 && levelAngka<=20){//jika level dalam rentang 1-20
                        levelTravelerValid = true;
                    }
                }
                long nilaiExp =0;// memakai long yang kapasitasnya lebih besar
                if(namaTravelerValid && levelTravelerValid){// jika nama dan level valid
                    if(levelAngka>1){
                        nilaiExp = (long) (5000 * Math.pow(2, levelAngka-2));
                    }
                    // masukkan input ke variabel travelerData
                    travelerData += "P" + (travelerId++)  + NAME_IDENTIFIER + namaTraveler+
                    LEVEL_IDENTIFIER + levelTraveler +EXP_IDENTIFIER+ nilaiExp+ STATUS_IDENTIFIER + "kosong  \u2705" +"\n";
                    isInputValid= true;
                    
                }else{// jika input tidak valid
                    System.out.println("Input tidak valid. Harap masukkan data dengan benar");
                }
              
                
        }
        System.out.println("Data berhasil dimasukkan.");
        System.out.println();
    }


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
                    System.out.println("Quest yang terdaftar:");
                    // menggunakan scanner untuk membaca questData
                    Scanner reader = new Scanner(questData);
                    while(reader.hasNextLine()){
                        String baris = reader.nextLine();
                        
                        String idQuest = baris.substring(0, baris.indexOf(NAME_IDENTIFIER));
                        System.out.println("ID Quest: "+ idQuest);


                        String namaQuest = baris.substring(baris.indexOf(NAME_IDENTIFIER)+ 1, baris.indexOf(DESC_IDENTIFIER));
                        System.out.println("Nama Quest: "+ namaQuest);

                        String deskripsiQuest = baris.substring(baris.indexOf(DESC_IDENTIFIER )+ 1, baris.indexOf(REWARD_IDENTIFIER));
                        System.out.println("Deskripsi Quest: "+ deskripsiQuest);

                        String rewardQuest = baris.substring(baris.indexOf(REWARD_IDENTIFIER)+1, baris.indexOf(EXP_IDENTIFIER));
                        System.out.println("Reward Quest: "+ rewardQuest);

                        String bonusExpQuest = baris.substring(baris.indexOf(EXP_IDENTIFIER)+1, baris.indexOf(DIFFICULTY_IDENTIFIER));
                        System.out.println("Bonus Exp Quest: "+ bonusExpQuest + " poin exp");

                        String tingkatKesulitanQuest = baris.substring(baris.indexOf(DIFFICULTY_IDENTIFIER)+1, baris.indexOf(STATUS_IDENTIFIER));
                        System.out.println("Tingkat Kesulitan Quest: "+ tingkatKesulitanQuest);

                        String statusQuest = baris.substring(baris.indexOf(STATUS_IDENTIFIER)+1);
                        System.out.println("Status Quest: "+ statusQuest);

                        System.out.println();

                    }  
                    break;

                case "2":
                    // TODO: Tampilkan daftar pengembara
                    System.out.println("Pengembara yang terdaftar: ");

                    Scanner travelerReader = new Scanner(travelerData);
                    while(travelerReader.hasNextLine()){

                        String baris = travelerReader.nextLine();
    
                        String idPengembara = baris.substring(0, baris.indexOf(NAME_IDENTIFIER));
                        System.out.println("ID Pengembara: "+idPengembara);
    
                        String namaPengembara = baris.substring(baris.indexOf(NAME_IDENTIFIER)+1, baris.indexOf(LEVEL_IDENTIFIER));
                        System.out.println("Nama Pengembara: "+namaPengembara);
    
                        String levelPengembara = baris.substring(baris.indexOf(LEVEL_IDENTIFIER)+1, baris.indexOf(EXP_IDENTIFIER));
                        System.out.println("Level Pengembara: "+levelPengembara);

                        String expPengembara = baris.substring(baris.indexOf(EXP_IDENTIFIER)+ 1, baris.indexOf(STATUS_IDENTIFIER));
                        System.out.println("EXP Pengembara: "+ expPengembara + " poin exp");

                        String  statusPengembara = baris.substring(baris.indexOf(STATUS_IDENTIFIER)+1);
                        System.out.println("Status Pengembara: "+ statusPengembara);

                        System.out.println();
                    }

                    break;
                case "3":
                    // TODO: Tambah quest
                    
                    boolean isAdding = false;
                    while(!isAdding){

                        System.out.println("Quest "+ (questCount+1));
                        System.out.print("Masukkan nama quest (masukkan 'x' atau 'X'untuk kembali): ");
                        String nama = input.nextLine();
                        if(nama.equalsIgnoreCase("x")){
                            break;
                        }
                        
                        //deskripsi hanya boleh alfanumerik dan spasi
                        System.out.print("Masukkan deskripsi quest (masukkan 'x' atau 'X'untuk kembali): ");
                        String  deskripsi = input.nextLine();
                        if(deskripsi.equalsIgnoreCase("x")){
                            break;
                        }
                        
                        // reward hanya boleh bilangan bulat nonnegatif
                        System.out.print("Masukkan reward quest berupa bilangan bulat nonnegatif (masukkan 'x' atau 'X'untuk kembali): ");
                        String rewardStrng = input.nextLine();
                        if(rewardStrng.equalsIgnoreCase("x")){
                            break;
                        }
                        
                        //bonus exp hanya boleh bilangan bulat nonnegatif
                        System.out.print("Masukkan bonus exp quest berupa bilangan bulat nonnegatif (masukkan 'x' atau 'X'untuk kembali): ");
                        String bonusExp = input.nextLine();
                        if(bonusExp.equalsIgnoreCase("x")){
                            break;
                        }
                        
                        //tingkat kesulitan hanya boleh mudah, menengah, sulit. sifatnya ignore case
                        System.out.print("Masukkan tingkat kesulitan quest (opsi: mudah, menengah, sulit)(masukkan 'x' atau 'X'untuk kembali): ");
                        String tingkatKesulitan = input.nextLine();
                        if(tingkatKesulitan.equalsIgnoreCase("x")){
                            break;
                        }
            
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
                                bintang = "\u2605 \u2605";
                                break;
                            case "sulit":
                                bintang = "\u2605 \u2605 \u2605";
                                break;
                        }
    
            
                        if(namaValid && deskripsiValid && rewardValid && bonusValid && kesulitanValid){
                            questData += "Q"+ (questId++)+NAME_IDENTIFIER + nama.trim() + DESC_IDENTIFIER + deskripsi.trim()+
                            REWARD_IDENTIFIER + rewardStrng.trim() + EXP_IDENTIFIER + bonusExp.trim() + DIFFICULTY_IDENTIFIER+ bintang+
                            STATUS_IDENTIFIER +"tersedia \ud83d\udfe2" + "\n"; 
                            System.out.println("Quest berhasil ditambahkan");
                            isAdding = true;
                        }else{
                            System.out.println("Input tidak valid. Harap masukkan data dengan benar");
                        }
                        
    
                    }
    
    
                    
                    break;
            case "4":
                // TODO: Tambah pengembara
                boolean isAddingTraveler = false;
            while(!isAddingTraveler){
                System.out.println("Pengembara "+ (travelerCount+1));
                // nama hanya boleh alfanumerik dan spasi
                System.out.print("Masukkan nama pengembara (masukkan 'x' atau 'X'untuk kembali): ");
                String namaTraveler = input.nextLine();
                if(namaTraveler.equalsIgnoreCase("x")){
                    break;
                }
                
                //level hanya boleh pada rentang [1-20]
                System.out.print("Masukkan level pengembara berupa bilangan bulat [1,20] (masukkan 'x' atau 'X'untuk kembali): ");
                String levelTraveler = input.nextLine();
                if(levelTraveler.equalsIgnoreCase("x")){
                    break;
                }


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
                        nilaiExp = (long) (5000 * Math.pow(2, levelAngka-2));
                    }
                    travelerData += "P" + (travelerId++)  + NAME_IDENTIFIER + namaTraveler+
                    LEVEL_IDENTIFIER + levelTraveler +EXP_IDENTIFIER+ nilaiExp + STATUS_IDENTIFIER + "kosong  \u2705" +"\n";
                    isAddingTraveler= true;
                    
                }else{
                    System.out.println("Input tidak valid. Harap masukkan data dengan benar");
                }
                System.out.println("Pengembara berhasil ditambahkan.");
              
                
        }
             
                break;
            case "5":
                // TODO: Menjalankan quest
                boolean isSucces = false;
                while(!isSucces){
                    System.out.print("Masukkan ID Quest yang ingin diambil (atau 'X'/'x' untuk kembali): ");
                    String idQuestTarget = input.nextLine().trim();
                    if(idQuestTarget.equalsIgnoreCase("x")){
                        break;
                    }

                    String ketemuQuest ="";
                    Scanner readQuest = new Scanner(questData);
                    while(readQuest.hasNextLine()){
                        String baris = readQuest.nextLine();
                        if(baris.toUpperCase().startsWith(idQuestTarget.toUpperCase() + NAME_IDENTIFIER)){
                            ketemuQuest  = baris;
                            break;
                        }
                    }

                    if(ketemuQuest.equals("") || !ketemuQuest.contains("tersedia \ud83d\udfe2")){
                        System.out.println("Quest tidak ditemukan atau sudah diambil/selesai.");
                        continue;
                    }
                    System.out.print("Masukkan ID Pengembara yang akan mengambil quest (atau 'X'/'x' untuk kembali): ");
                    String idPengembaraTarget = input.nextLine().trim();
                    if(idPengembaraTarget.equalsIgnoreCase("x")){
                        break;
                    }
                    String ketemuPengembara="";
                    Scanner readTraveler = new Scanner(travelerData);
                    while(readTraveler.hasNextLine()){
                        String baris = readTraveler.nextLine();
                        if(baris.toUpperCase().startsWith(idPengembaraTarget.toUpperCase() + NAME_IDENTIFIER)){
                            //diubah ke upper case karena case insensitive
                            ketemuPengembara = baris;
                            break;
                        }
                        
                    }
                    if(ketemuPengembara.equals("") || !ketemuPengembara.contains("kosong  \u2705")){
                        System.out.println("Pengembara tidak ditemukan atau tidak memenuhi persyaratan untuk mengambil quest.");
                        continue;
                        // menggunakan continue agar jika pengembara tidak ditemukan atau tidak memenuhi syarat, program kembali di input id quest
                    }
                    String bintangQuest = ketemuQuest.substring(ketemuQuest.indexOf(DIFFICULTY_IDENTIFIER)+ 1, ketemuQuest.indexOf(STATUS_IDENTIFIER));
                    int levelPengembara = Integer.parseInt(ketemuPengembara.substring(ketemuPengembara.indexOf(LEVEL_IDENTIFIER)+1, ketemuPengembara.indexOf(EXP_IDENTIFIER)));
                    boolean levelCukup = false;
                    // mengecek kesesuaian level pengembaara dengan kesulitan quest
                    if(bintangQuest.equals("\u2605 \u2605 \u2605")){//level sulit
                        if(levelPengembara>= 16){
                            levelCukup = true;
                        }
                    }  else if(bintangQuest.equals("\u2605 \u2605")){//level menengah
                            if(levelPengembara>= 6){
                                levelCukup = true;
                            }
                    }else if(bintangQuest.equals("\u2605")){//level mudah
                        levelCukup = true;
                        // level mudah tidak ada syaarat karena semua pengembara dengan level dari 1-20 dapat mengambil quest
                    }
                    //update status
                    if(levelCukup){
                        questData = questData.replace(ketemuQuest, ketemuQuest.replace("tersedia \ud83d\udfe2", "diambil-"+idPengembaraTarget.toUpperCase()+" \u231b" ));
                        travelerData = travelerData.replace(ketemuPengembara, ketemuPengembara.replace("kosong  \u2705", "dalam quest \u274c"));
                        isSucces = true;
                    }else{//jika level tidak sesuai
                        System.out.println("Pengembara tidak ditemukan atau tidak memenuhi persyaratan untuk mengambil quest.");
                    }
                    
                }System.out.println("Quest berhasil diambil");
                break;
            case "6":
                // TODO: Menyelesaikan quest
                boolean isFinish = false;
                while(!isFinish){
                    System.out.print("Masukkan ID Quest yang ingin diselesaikan (atau 'X'/'x' untuk kembali): ");
                    String idQuestTarget = input.nextLine();
                    if(idQuestTarget.equalsIgnoreCase("x")){
                        break;
                    }
                    
                    // mencari quest berdasarkan input user
                    String ketemuQuest = "";
                    Scanner read = new Scanner(questData);
                    while(read.hasNextLine()){
                        String baris = read.nextLine().trim();
                        if(baris.toUpperCase().startsWith(idQuestTarget.toUpperCase() + NAME_IDENTIFIER)){
                            ketemuQuest = baris;
                            break;// berhenti mencari data jika sudah ketemu
                        }
                    }
                    // jika quest yang diinginkan tidak ada
                    if(ketemuQuest.equals("") || !ketemuQuest.contains("diambil-")){
                        System.out.println("Quest tidak ditemukan atau belum diambil/selesai.");
                        continue; //kembali ke awal input
                    }
                    
                    // mengambil informasi quest:
                    //mengambil bonus exp
                    long bonusExp =Long.parseLong(ketemuQuest.substring(ketemuQuest.indexOf(REWARD_IDENTIFIER)+1,  ketemuQuest.indexOf(EXP_IDENTIFIER)));
                    // mengambil id pengembara dengan mengakses status quest
                    String statusQuest = ketemuQuest.substring(ketemuQuest.indexOf(STATUS_IDENTIFIER)+1);
                    // mengambil contohnya: "P1" dari "diambil-P1", yang diambil dari '-' sampai spasi
                    String idPengembara = statusQuest.substring(statusQuest.indexOf("-")+1, statusQuest.indexOf(" "));

                    // mencari data pengembara
                    String travelerOld  = ""; // simpan data sebelum update ke variabel travelerOld
                    Scanner readTraveler = new Scanner(travelerData);
                    while(readTraveler.hasNextLine()){
                        String baris = readTraveler.nextLine();
                        if(baris.toUpperCase().startsWith(idPengembara + NAME_IDENTIFIER)){
                            travelerOld = baris;
                            break;
                        }
                    }

                    // mengambil data level dari data pengembara
                    int levelNow = Integer.parseInt(travelerOld.substring(travelerOld.indexOf(LEVEL_IDENTIFIER)+1, travelerOld.indexOf(EXP_IDENTIFIER)));
                    long expNow = Long.parseLong(travelerOld.substring(travelerOld.indexOf(EXP_IDENTIFIER)+1, travelerOld.indexOf(STATUS_IDENTIFIER)));
                    // buat syarat untuk naik level
                    long syaratExp = (long) (5000* Math.pow(2, levelNow-1));

                    // menambah exp pengembara dan bonus exp dengan batas maksimal 1310720000
                    long totalExp = Math.min(expNow+bonusExp, 1310720000L);

                    // karena pemberitahuan naik level hanya ditampilkan ketika syarat exp terpenuhi, maka ketika syarat exp tidak terpenuhi,
                    // output hanya berupa exp yang didapatkan dan total exp
                    System.out.println("Quest berhasil diselesaikan!");
                    System.out.println("Exp didapatkan: "+ bonusExp);
                    System.out.println("Total exp: "+ totalExp);
                    
                    // jika total exp memenuhi syarat exp, maka pengembara nail 1 level
                    int levelFinal = levelNow;
                    if(totalExp>= syaratExp && levelNow<20){
                        levelFinal ++;
                        System.out.println("Level pengembara naik menjadi: "+ levelFinal);
                    }
                    // Update data
                    String questNew = ketemuQuest.substring(0, ketemuQuest.indexOf(STATUS_IDENTIFIER)+1) + "selesai \ud83c\udfc6";
                    questData = questData.replace(ketemuQuest, questNew);
                    
                    String travelerNew = idPengembara+ NAME_IDENTIFIER+ travelerOld.substring(travelerOld.indexOf(NAME_IDENTIFIER)+1, travelerOld.indexOf(LEVEL_IDENTIFIER)+1)+
                    levelFinal+ EXP_IDENTIFIER+ totalExp+ STATUS_IDENTIFIER+ "kosong \u2705";
                    
                    travelerData = travelerData.replace(travelerOld, travelerNew);
                    
                    isFinish = true;
                }


                break;
            case "7":
                // TODO: Filter daftar quest
                boolean isValid = false;
                while(!isValid){
                    
                    System.out.println("Filter daftar quest");
                    System.out.println("1. Filter berdasarkan status");
                    System.out.println("2. Filter berdasarkan tingkat kesulitan");
                    System.out.println("X. Kembali ke menu utama");
                    System.out.print("Masukkan tipe filter: ");
                    String filterInput = input.nextLine().trim();
                    if(filterInput.equalsIgnoreCase("x")){
                        break;
                    }

                    if(filterInput.equals("1")){
                        System.out.print("Masukkan status quest yang ingin difilter (tersedia/diambil/selesai), masukkan 'x' atau 'X' untuk kembali ke menu utama: ");
                        String filterstatus = input.nextLine().trim();
                        boolean statusValid= filterstatus.trim().matches("(?i)^(tersedia|diambil|selesai)$");
                        if(filterstatus.equalsIgnoreCase("x")){
                        break;
                        }

                        if(statusValid){
                            System.out.println("Daftar quest terfilter:");
                            Scanner readQuest = new Scanner(questData);
                            while(readQuest.hasNextLine()){
                                
                                String baris = readQuest.nextLine();
                                if(baris.toUpperCase().contains(filterstatus.toUpperCase())){

                                    String idQuest = baris.substring(0, baris.indexOf(NAME_IDENTIFIER));
                                    System.out.println("ID Quest: "+ idQuest);
    
                                    String namaQuest = baris.substring(baris.indexOf(NAME_IDENTIFIER)+ 1, baris.indexOf(DESC_IDENTIFIER));
                                    System.out.println("Nama Quest: "+ namaQuest);
    
                                    String deskripsiQuest = baris.substring(baris.indexOf(DESC_IDENTIFIER )+ 1, baris.indexOf(REWARD_IDENTIFIER));
                                    System.out.println("Deskripsi Quest: "+ deskripsiQuest);
    
                                    String rewardQuest = baris.substring(baris.indexOf(REWARD_IDENTIFIER)+1, baris.indexOf(EXP_IDENTIFIER));
                                    System.out.println("Reward Quest: "+ rewardQuest);
    
                                    String bonusExpQuest = baris.substring(baris.indexOf(EXP_IDENTIFIER)+1, baris.indexOf(DIFFICULTY_IDENTIFIER));
                                    System.out.println("Bonus Exp Quest: "+ bonusExpQuest + " poin exp");
    
                                    String tingkatKesulitanQuest = baris.substring(baris.indexOf(DIFFICULTY_IDENTIFIER)+1, baris.indexOf(STATUS_IDENTIFIER));
                                    System.out.println("Tingkat Kesulitan Quest: "+ tingkatKesulitanQuest);
    
                                    String statusQuest = baris.substring(baris.indexOf(STATUS_IDENTIFIER)+1);
                                    System.out.println("Status Quest: "+ statusQuest);
    
                                    System.out.println();
                                }
                                

                                }
                                isValid = true; 
                                
                    }else{
                        System.out.println("Pilihan tidak valid, harap masukkan pilihan dengan benar.");
                        
                    }

                }

                else if (filterInput.equals("2")){
                        System.out.print("Masukkan tingkat kesulitan quest yang ingin difilter (mudah/menengah/sulit), masukkan 'x' atau 'X' untuk kembali ke menu utama: ");
                        String filterkesulitan = input.nextLine().trim();
                        boolean kesulitanValid = filterkesulitan.trim().matches("(?i)^(mudah|menengah|sulit)$");

                        
                        if(filterkesulitan.equalsIgnoreCase("x")){
                        break;
                        }

                        if(kesulitanValid){
                            // menyesuaikan status kesulitan dengan jumlah bintang
                            String bintangTarget = "";
                            if(filterkesulitan.equalsIgnoreCase("mudah")){
                                bintangTarget = "\u2605";
                            }else if(filterkesulitan.equalsIgnoreCase("menengah")){

                                bintangTarget = "\u2605 \u2605";
                            } else if(filterkesulitan.equalsIgnoreCase("sulit")){
                                bintangTarget ="\u2605 \u2605 \u2605";
                            }


                            System.out.println("Daftar quest terfilter:");
                            Scanner readQuest = new Scanner(questData);
                            while(readQuest.hasNextLine()){
                                String baris = readQuest.nextLine();
                                String bintangDiBaris = baris.substring(baris.indexOf(DIFFICULTY_IDENTIFIER)+1, baris.indexOf(STATUS_IDENTIFIER));
                                if(bintangDiBaris.equals(bintangTarget)){

                                    String idQuest = baris.substring(0, baris.indexOf(NAME_IDENTIFIER));
                                    System.out.println("ID Quest: "+ idQuest);
    
                                    String namaQuest = baris.substring(baris.indexOf(NAME_IDENTIFIER)+ 1, baris.indexOf(DESC_IDENTIFIER));
                                    System.out.println("Nama Quest: "+ namaQuest);
    
                                    String deskripsiQuest = baris.substring(baris.indexOf(DESC_IDENTIFIER )+ 1, baris.indexOf(REWARD_IDENTIFIER));
                                    System.out.println("Deskripsi Quest: "+ deskripsiQuest);
    
                                    String rewardQuest = baris.substring(baris.indexOf(REWARD_IDENTIFIER)+1, baris.indexOf(EXP_IDENTIFIER));
                                    System.out.println("Reward Quest: "+ rewardQuest);
    
                                    String bonusExpQuest = baris.substring(baris.indexOf(EXP_IDENTIFIER)+1, baris.indexOf(DIFFICULTY_IDENTIFIER));
                                    System.out.println("Bonus Exp Quest: "+ bonusExpQuest + " poin exp");
    
                                    String tingkatKesulitanQuest = baris.substring(baris.indexOf(DIFFICULTY_IDENTIFIER)+1, baris.indexOf(STATUS_IDENTIFIER));
                                    System.out.println("Tingkat Kesulitan Quest: "+ tingkatKesulitanQuest);
    
                                    String statusQuest = baris.substring(baris.indexOf(STATUS_IDENTIFIER)+1);
                                    System.out.println("Status Quest: "+ statusQuest);
    
                                    System.out.println();
                                }
                                

                                }
                                isValid = true; 
                                
                    }
                    else{// jika inputnya tidak valid/sesuai
                        System.out.println("Pilihan tidak valid, harap masukkan pilihan dengan benar.");
                
                    }

                } 
            }  
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
                    























